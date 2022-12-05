package ir.behi.seqtest;

import ir.behi.seqtest.entity.GroupEntity;
import ir.behi.seqtest.repo.GroupDAO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.MessageFormat;
import java.util.Random;

@SpringBootTest
class ApplicationTests {

    @Autowired
    private GroupDAO groupDAO;

    @Test
    void contextLoads() {
        GroupEntity entity=new GroupEntity();
        entity.setName("Ali "+ new Random(12000).nextInt());
        entity=groupDAO.save(entity);
        groupDAO.findById(entity.getId());
        System.out.println(MessageFormat.format("group save with id={0}, name={1}", entity.getId(),entity.getName()));
    }

}
