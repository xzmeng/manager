package app.manager.model;

import app.manager.web.FileData;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="files")
public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    /* 学院 */
    @Column(name = "institute", nullable = false, length = 128)
    private String institute;
    /* 专业 */
    @Column(name = "major", nullable = false, length = 128)
    private String major;
    /* 招生情况 */
    @Column(name = "admission_info", nullable = false, length = 1024)
    private String admissionInfo;
    /* 毕业生就业情况 */
    @Column(name = "job_info", nullable = false, length = 1024)
    private String jobInfo;
    /* 教学质量 */
    @Column(name = "teaching_quality", nullable = false, length = 1024)
    private String teachingQuality;
    /* 专业建设文件 */
    @Column(name = "construct_file", length = 1024)
    private String constructFile;
    /* 上传日期 */
    @Column(name = "upload_time", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date uploadTime;
    /* 备注 */
    @Column(name = "note", length = 1024)
    private String note;

    /* constructor for hibernate */
    public File() {}

    /* constructor for application */
    public File(FileData fileData) {
        this.institute = fileData.getInstitute();
        this.major = fileData.getMajor();
        this.admissionInfo = fileData.getAdmissionInfo();
        this.jobInfo = fileData.getJobInfo();
        this.teachingQuality = fileData.getTeachingQuality();
        this.uploadTime = new Date();
        this.note = fileData.getNote();
    }

    /* essential getters */
    public Integer getId() {
        return id;
    }

    public String getInstitute() {
        return institute;
    }

    public String getMajor() {
        return major;
    }

    public String getAdmissionInfo() {
        return admissionInfo;
    }

    public String getJobInfo() {
        return jobInfo;
    }

    public String getTeachingQuality() {
        return teachingQuality;
    }

    public String getConstructFile() {
        return constructFile;
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public String getNote() {
        return note;
    }
}
