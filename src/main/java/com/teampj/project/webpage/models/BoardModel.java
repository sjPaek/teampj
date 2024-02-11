package com.teampj.project.webpage.models;

import java.time.LocalDateTime;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardModel {
    private Integer dcmtCode;
    private String userSeq;
    private String dcmtTitle;
    private String dcmtText;
    private Date dcmtDate;
    private LocalDateTime regDate;
    private LocalDateTime modifyDate;
}
