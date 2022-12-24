package hellojpa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
//@Table(name = "MBR")
//@SequenceGenerator(name = "member_seq_generator", sequenceName = "member-seq")
//@TableGenerator(name = "MEMBER_SEQ_GENERATOR",
//        table = "MY_SEQUENCES", pkColumnValue = "MEMBER_SEQ", allocationSize = 1)
//@SequenceGenerator(
//        name = "MEMBER_SEQ_GENERATOR",
//        sequenceName = "MEMBER_SEQ", //매핑할 데이터베이스 시퀀스 이름
//        initialValue = 1, allocationSize = 1)
public class Member {

    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member_seq_generator")
//    @GeneratedValue(strategy = GenerationType.TABLE,
//            generator = "MEMBER_SEQ_GENERATOR")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "USERNAME")
    private String username;

    @ManyToOne
    @JoinColumn(name = "TEAM_ID", insertable = false, updatable = false)  // 다대일 양방향(읽기 전용)
    private Team team;

//    @Column(name = "TEAM_ID")
//    private Long teamId;

//    @ManyToOne
//    @JoinColumn(name = "TEAM_ID")
//    private Team team;

    @OneToOne
    @JoinColumn(name = "LOCKER_ID")
    private Locker locker;

    @OneToMany(mappedBy = "member")
    private List<MemberProduct> memberProducts = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
