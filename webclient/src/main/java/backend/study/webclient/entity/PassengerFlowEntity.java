package backend.study.webclient.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Getter
@Entity
@Table(name = "passenger_flow")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PassengerFlowEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private String id;

    @Column(name = "a_time")
    private String atime;

    @Column(name = "a_date")
    private String adate;

    @Column(name = "t1_sum1")
    private String t1sum1;

    @Column(name = "t1_sum2")
    private String t1sum2;

    @Column(name = "t1_sum3")
    private String t1sum3;

    @Column(name = "t1_sum4")
    private String t1sum4;

    @Column(name = "t1_sum_set1")
    private String t1sumset1;

    @Column(name = "t1_sum5")
    private String t1sum5;

    @Column(name = "t1_sum6")
    private String t1sum6;

    @Column(name = "t1_sum7")
    private String t1sum7;

    @Column(name = "t1_sum8")
    private String t1sum8;

    @Column(name = "t1_sum_set2")
    private String t1sumset2;

    @Column(name = "t2_sum1")
    private String t2sum1;

    @Column(name = "t2_sum2")
    private String t2sum2;

    @Column(name = "t2_sum_set1")
    private String t2sumset1;

    @Column(name = "t2_sum3")
    private String t2sum3;

    @Column(name = "t2_sum4")
    private String t2sum4;

    @Column(name = "t2_sum_set2")
    private String t2sumset2;

    @CreatedDate
    @Column(name = "created_at", updatable = false)
    private String createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private String updatedAt;

    private PassengerFlowEntity(String atime, String adate, String t1sum1, String t1sum2,
        String t1sum3, String t1sum4, String t1sumset1, String t1sum5, String t1sum6,
        String t1sum7, String t1sum8, String t1sumset2, String t2sum1, String t2sum2,
        String t2sumset1, String t2sum3, String t2sum4, String t2sumset2) {
        this.atime = atime;
        this.adate = adate;
        this.t1sum1 = t1sum1;
        this.t1sum2 = t1sum2;
        this.t1sum3 = t1sum3;
        this.t1sum4 = t1sum4;
        this.t1sumset1 = t1sumset1;
        this.t1sum5 = t1sum5;
        this.t1sum6 = t1sum6;
        this.t1sum7 = t1sum7;
        this.t1sum8 = t1sum8;
        this.t1sumset2 = t1sumset2;
        this.t2sum1 = t2sum1;
        this.t2sum2 = t2sum2;
        this.t2sumset1 = t2sumset1;
        this.t2sum3 = t2sum3;
        this.t2sum4 = t2sum4;
        this.t2sumset2 = t2sumset2;
    }
    
    /**
     * 공항 승객 예보 객체 생성
     *
     * @param atime
     * @param adate
     * @param t1sum1
     * @param t1sum2
     * @param t1sum3
     * @param t1sum4
     * @param t1sumset1
     * @param t1sum5
     * @param t1sum6
     * @param t1sum7
     * @param t1sum8
     * @param t1sumset2
     * @param t2sum1
     * @param t2sum2
     * @param t2sumset1
     * @param t2sum3
     * @param t2sum4
     * @param t2sumset2
     * @return
     */
    public static PassengerFlowEntity createPassengerFlowEntity(
        String atime, String adate, String t1sum1, String t1sum2,
        String t1sum3, String t1sum4, String t1sumset1, String t1sum5, String t1sum6,
        String t1sum7, String t1sum8, String t1sumset2, String t2sum1, String t2sum2,
        String t2sumset1, String t2sum3, String t2sum4, String t2sumset2) {
        return new PassengerFlowEntity(atime, adate, t1sum1,
            t1sum2, t1sum3, t1sum4, t1sumset1, t1sum5, t1sum6,
            t1sum7, t1sum8, t1sumset2, t2sum1, t2sum2,
            t2sumset1, t2sum3, t2sum4, t2sumset2);
    }

}
