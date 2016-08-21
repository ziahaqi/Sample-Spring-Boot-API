package net.ziahaqi.boot.sample.controller;

import net.ziahaqi.boot.sample.entity.Member;
import net.ziahaqi.boot.sample.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by ziahaqi on 8/21/16.
 */
@RestController
public class MemberController {

    @Autowired
    private MemberRepository repository;

    @RequestMapping(value = "/member", method = RequestMethod.GET)
    public ResponseEntity<Page<Member>>findMember(Pageable pageable){
        Page<Member> pageAbleMember = repository.findAll(pageable);
        return new ResponseEntity<>(pageAbleMember, HttpStatus.OK);
    }

    @RequestMapping(value = "/member", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void saveMember(@RequestBody Member member){

        repository.save(member);
    }

    @RequestMapping(value = "/member/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void updateMember(@PathVariable("id")String id, @RequestBody Member member){
        member.setId(id);
        repository.save(member);
    }

    @RequestMapping(value = "/member/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteMember(@PathVariable("id") String id){
        repository.delete(id);
    }

    @RequestMapping(value = "/member/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Member> getUserById(@PathVariable("id")String id){
        Member member = repository.findOne(id);
        if(member == null || id == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(member, HttpStatus.OK);
    }
}
