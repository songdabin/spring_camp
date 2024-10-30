package com.example.demo.service.impl;

import com.example.demo.domain.Faq;
import com.example.demo.domain.User;
import com.example.demo.dto.DefaultDto;
import com.example.demo.dto.FaqDto;
import com.example.demo.mapper.FaqMapper;
import com.example.demo.repository.FaqRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.FaqService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FaqServiceImpl implements FaqService {
    private final FaqRepository faqRepository;
    private final FaqMapper faqMapper;
    private final UserRepository userRepository;

    public FaqServiceImpl(FaqRepository faqRepository, FaqMapper faqMapper, UserRepository userRepository) {
        this.faqRepository = faqRepository;
        this.faqMapper = faqMapper;
        this.userRepository = userRepository;
    }

    @Override
    public DefaultDto.CreateResDto create(FaqDto.CreateReqDto param) {
        return faqRepository.save(param.toEntity()).toCreateResDto();
    }

    @Override
    public void update(FaqDto.UpdateReqDto param) {
        Faq faq = faqRepository.findById(param.getId()).orElseThrow(() -> new RuntimeException(""));

        if(param.getTitle() != null) {
            faq.setTitle(param.getTitle());
        }

        if(param.getContent() != null) {
            faq.setContent(param.getContent());
        }

        faqRepository.save(faq);
    }

    public FaqDto.DetailResDto entityToDto(Faq faq) {
        FaqDto.DetailResDto result = new FaqDto.DetailResDto();

        result.setId(faq.getId());
        result.setTitle(faq.getTitle());
        result.setContent(faq.getContent());
        result.setUserId(faq.getUserId());

        Long userId = faq.getUserId();
        try {
            User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException(""));
            result.setUserUsername(user.getUsername());
        } catch(Exception e) {
        }

        return result;
    }

    public List<FaqDto.DetailResDto> detailList(List<FaqDto.DetailResDto> list) {
        List<FaqDto.DetailResDto> newList = new ArrayList<>();

        for (FaqDto.DetailResDto each : list) {
            newList.add(get(each.getId()));
        }
        return newList;
    }

    @Override
    public List<FaqDto.DetailResDto> list(FaqDto.ListReqDto param) {
        return detailList(faqMapper.list(param));

        // return faqMapper.list(param);
    }

    @Override
    public DefaultDto.PagedListResDto pagedList(FaqDto.PagedListReqDto param) {
        DefaultDto.PagedListResDto returnVal = DefaultDto.PagedListResDto.init(param, faqMapper.pagedListCount(param));
        returnVal.setList(detailList(faqMapper.pagedList(param)));
        return returnVal;

        /*
        // 반복해서 사용할 코드이기 때문에, DefaultDto의 init으로 코드 이동
        int perpage = param.getPerpage();
        int pagecount = itemcount/perpage;
        if (itemcount % perpage > 0) {
            pagecount++;
        }
        int callpage = param.getCallpage();

        if (callpage < 1) {
            callpage = 1;
        }
        if (callpage > pagecount) {
            callpage = pagecount;
        }

        int offset = (callpage - 1) * perpage;
        param.setOffset(offset);

        // 정렬 기준
        String orderby = param.getOrderby();
        if (orderby == null || "".equals(orderby)) {
            orderby = "created_at";
        }
        param.setOrderby(orderby);

        // 정렬 방향
        String orderway = param.getOrderway();
        if (orderway == null || "".equals(orderway)) {
            orderway = "desc";
        }
        param.setOrderway(orderway);

        // 파라미터 완성 후 리스트 조회
        List<FaqDto.DetailResDto> plist = faqMapper.pagedList(param);

        DefaultDto.PagedListResDto returnVal = DefaultDto.PagedListResDto.builder()
                .itemcount(itemcount)
                .pagecount(pagecount)
                .callpage(callpage)
                .list(detailList(plist))
                .build();

        return returnVal;
        */
    }

    public FaqDto.DetailResDto get(Long id) {
        return faqMapper.detail(id);
    }

    @Override
    public FaqDto.DetailResDto detail(Long id) {
        return get(id);
    }

    @Override
    public void delete(Long id) {
        Faq faq = faqRepository.findById(id).orElseThrow(() -> new RuntimeException(""));

        faqRepository.delete(faq);
    }
}
