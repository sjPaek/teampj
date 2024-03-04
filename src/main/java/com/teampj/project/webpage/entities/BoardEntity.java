package com.teampj.project.webpage.entities;

import java.sql.Date;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="document")
@NoArgsConstructor
@Data

public class BoardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer dcmt_code;

    @Column(name = "user_seq")
    private String userSeq;

    @Column(name = "dcmt_title")
    private String dcmtTitle;

    @Column(name = "dcmt_text")
    private String dcmtText;

    @Column(name = "dcmt_date")
    private Date dcmtDate;

    @Column (name = "reg_date")
    private LocalDateTime regDate;

    @Column (name = "modify_date")
    private LocalDateTime modifyDate;
}
