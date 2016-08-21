package net.ziahaqi.boot.sample.repository;

import net.ziahaqi.boot.sample.entity.Material;
import net.ziahaqi.boot.sample.entity.Member;
import net.ziahaqi.boot.sample.entity.Session;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by ziahaqi on 8/14/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Sql(scripts = {"/data/member.sql", "/data/material.sql", "/data/session.sql"})
public class SessionRepositoryTest {

    @Autowired
    SessionRepository repository;

    @Autowired
    DataSource dataSource;
    @Test
    public void findByMaterial(){
        Material material = new Material();
        material.setId("M01");

        PageRequest request = new PageRequest(0, 5);
        Page<Session> result = repository.findByMaterial(material, request);
        Assert.assertNotNull(result);
        Assert.assertEquals(2L, result.getTotalElements());

        Session sessionResult = result.getContent().get(0);
        Assert.assertNotNull(sessionResult);
        Assert.assertEquals("J-001", sessionResult.getMaterial().getCode());

    }

    @Test
    public void findByDateStart() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse("2016-08-01");
        List<Session>  sessionList = repository.findBydateStart(date);
        Assert.assertNotNull(sessionList);
        Assert.assertEquals(2, sessionList.size());
    }

    @Test
    public void saveSession() throws ParseException, SQLException {
        Member member1 = new Member();
        member1.setId("001");

        Member member2 = new Member();
        member2.setId("003");

        Material material = new Material();
        material.setId("M03");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date start = sdf.parse("2016-10-10");
        Date finish = sdf.parse("2016-10-20");

        Session session = new Session();
        session.setDateStart(start);
        session.setDateFinish(finish);
        session.setMaterial(material);
        session.getMembers().add(member1);
        session.getMembers().add(member2);
        repository.save(session);

        Connection connection = dataSource.getConnection();

        String sqlSession = "SELECT * FROM session where material_id = 'M03'";
        ResultSet rs = connection.createStatement().executeQuery(sqlSession);
        Assert.assertTrue(rs.next());
        Assert.assertEquals(1L, rs.getLong(1));


        String sqlSessionMember = "sql";

    }


}
