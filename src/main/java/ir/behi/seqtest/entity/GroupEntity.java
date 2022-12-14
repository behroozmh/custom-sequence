package ir.behi.seqtest.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class GroupEntity {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_seq")
    @GenericGenerator(name = "id_seq", strategy = "ir.behi.seqtest.entity.GroupSeqGenerator"
            , parameters = {
            @org.hibernate.annotations.Parameter(name = GroupSeqGenerator.SEQUENCE, value = "group_seq"),
    })
    @Id
    private Long id;
    private String name;
}
