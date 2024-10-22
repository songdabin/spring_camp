package com.example.demo.service.impl;

import com.example.demo.domain.Faq;
import com.example.demo.domain.User;
import com.example.demo.dto.FaqDto;
import com.example.demo.mapper.FaqMapper;
import com.example.demo.repository.FaqRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.FaqService;
import org.springframework.stereotype.Service;

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
    public FaqDto.CreateResDto create(FaqDto.CreateReqDto param) {
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

    @Override
    public List<FaqDto.DetailResDto> list(FaqDto.ListReqDto param) {
        return faqMapper.list(param);
        /*List<FaqDto.DetailResDto> list = new ArrayList<>();
        List<Faq> faqList = faqRepository.findAll();

        for (Faq faq:
             faqList) {
            list.add(entityToDto(faq));
        }

        return list;*/
    }

    @Override
    public FaqDto.DetailResDto detail(Long id) {
        return faqMapper.detail(id);
        /*
        // without mapper
        Faq faq = faqRepository.findById(id).orElseThrow(()-> new RuntimeException(""));

        return entityToDto(faq);
        */
    }

    @Override
    public void delete(Long id) {
        Faq faq = faqRepository.findById(id).orElseThrow(() -> new RuntimeException(""));

        faqRepository.delete(faq);
    }
}
