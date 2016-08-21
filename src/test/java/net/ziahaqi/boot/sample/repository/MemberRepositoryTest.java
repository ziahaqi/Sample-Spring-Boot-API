package net.ziahaqi.boot.sample.repository;

import net.ziahaqi.boot.sample.entity.Member;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.Temporal;
import java.util.Date;

/**
 * Created by ziahaqi on 8/14/16.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Sql(
        scripts = "/data/member.sql",
        executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD
)
public class MemberRepositoryTest {

    @Before
    public void setup(){

    }

    @Autowired
    private MemberRepository repository;

    @Test
    public void insert(){
        Member member = new Member("sample name", "sample@mail.com", new Date());
        Member saved = repository.save(member);
        Assert.assertNotNull(saved);

    }

    @Test
    public void findById(){
        Member member = repository.findOne("001");
        Assert.assertNotNull(member);
        Assert.assertEquals("sample1@mail.com", member.getEmail());
    }
}
