package com.example.demo.service.impl;

import com.example.demo.domain.Post;
import com.example.demo.dto.DefaultDto;
import com.example.demo.dto.PostDto;
import com.example.demo.mapper.PostMapper;
import com.example.demo.repository.PostRepository;
import com.example.demo.service.PostService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final PostMapper postMapper;
    public PostServiceImpl(
            PostRepository postRepository
            , PostMapper postMapper
    ) {
        this.postRepository = postRepository;
        this.postMapper = postMapper;
    }

    /**/

    @Override
    public DefaultDto.CreateResDto create(PostDto.CreateReqDto param) {
        System.out.println("create");
        return postRepository.save(param.toEntity()).toCreateResDto();
    }
    @Override
    public void update(PostDto.UpdateReqDto param) {
        System.out.println("update");
        Post post = postRepository.findById(param.getId()).orElseThrow(() -> new RuntimeException(""));
        if(param.getDeleted() != null) {
            post.setDeleted(param.getDeleted());
        }
        if(param.getTitle() != null) {
            post.setTitle(param.getTitle());
        }
        if(param.getContent() != null) {
            post.setContent(param.getContent());
        }
        postRepository.save(post);
    }
    @Override
    public void delete(Long id) {
        update(PostDto.UpdateReqDto.builder().id(id).deleted(true).build());
    }
    @Override
    public void deletes(DefaultDto.DeletesReqDto param) {
        for(Long id : param.getIds()){
            delete(id);
        }
    }

    public PostDto.DetailResDto get(Long id) {
        return postMapper.detail(id);
    }
    public List<PostDto.DetailResDto> detailList(List<PostDto.DetailResDto> list) {
        List<PostDto.DetailResDto> newList = new ArrayList<>();
        for(PostDto.DetailResDto each : list) {
            newList.add(get(each.getId()));
        }
        return newList;
    }
    @Override
    public PostDto.DetailResDto detail(Long id) {
        return get(id);
    }
    @Override
    public List<PostDto.DetailResDto> list(PostDto.ListReqDto param) {
        return detailList(postMapper.list(param));
    }

    @Override
    public DefaultDto.PagedListResDto pagedList(PostDto.PagedListReqDto param){
        DefaultDto.PagedListResDto rtnVal = DefaultDto.PagedListResDto.init(param, postMapper.pagedListCount(param));
        rtnVal.setList(detailList(postMapper.pagedList(param)));
        return rtnVal;
    }

    @Override
    public List<PostDto.DetailResDto> scrollList(PostDto.ScrollListReqDto param){
        param.init();
        Long cursor = param.getCursor();
        if(cursor != null){
            Post post = postRepository.findById(cursor).orElseThrow(() -> new RuntimeException(""));
            param.setCreatedAt(post.getCreatedAt() + "");
        }
        return detailList(postMapper.scrollList(param));
    }
}