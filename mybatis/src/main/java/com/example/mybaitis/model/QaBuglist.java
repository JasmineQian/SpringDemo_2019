package com.example.mybaitis.model;

import java.io.Serializable;
import java.util.Date;

public class QaBuglist implements Serializable {

    private Integer bugId;

    private Integer bugProjectId;

    private Integer bugCrTypeId;

    private String bugCrNum;

    private String bugTaskNum;

    private Integer qaTypeId;

    private String bugDescription;

    private String bugRca;

    private String bugSolution;

    private Integer qaAssigneeId;

    private Integer qaTesterId;

    private Date qaCreationdt;

    private Date qaUpdatedt;

    private Boolean bugDeletedFlag;

    private String bugDeletedComment;

    private static final long serialVersionUID = 1L;

    public Integer getBugId() {
        return bugId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column qa_buglist.BUG_ID
     *
     * @param bugId the value for qa_buglist.BUG_ID
     *
     * @mbg.generated
     */
    public void setBugId(Integer bugId) {
        this.bugId = bugId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column qa_buglist.BUG_PROJECT_ID
     *
     * @return the value of qa_buglist.BUG_PROJECT_ID
     *
     * @mbg.generated
     */
    public Integer getBugProjectId() {
        return bugProjectId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column qa_buglist.BUG_PROJECT_ID
     *
     * @param bugProjectId the value for qa_buglist.BUG_PROJECT_ID
     *
     * @mbg.generated
     */
    public void setBugProjectId(Integer bugProjectId) {
        this.bugProjectId = bugProjectId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column qa_buglist.BUG_CR_TYPE_ID
     *
     * @return the value of qa_buglist.BUG_CR_TYPE_ID
     *
     * @mbg.generated
     */
    public Integer getBugCrTypeId() {
        return bugCrTypeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column qa_buglist.BUG_CR_TYPE_ID
     *
     * @param bugCrTypeId the value for qa_buglist.BUG_CR_TYPE_ID
     *
     * @mbg.generated
     */
    public void setBugCrTypeId(Integer bugCrTypeId) {
        this.bugCrTypeId = bugCrTypeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column qa_buglist.BUG_CR_NUM
     *
     * @return the value of qa_buglist.BUG_CR_NUM
     *
     * @mbg.generated
     */
    public String getBugCrNum() {
        return bugCrNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column qa_buglist.BUG_CR_NUM
     *
     * @param bugCrNum the value for qa_buglist.BUG_CR_NUM
     *
     * @mbg.generated
     */
    public void setBugCrNum(String bugCrNum) {
        this.bugCrNum = bugCrNum == null ? null : bugCrNum.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column qa_buglist.BUG_TASK_NUM
     *
     * @return the value of qa_buglist.BUG_TASK_NUM
     *
     * @mbg.generated
     */
    public String getBugTaskNum() {
        return bugTaskNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column qa_buglist.BUG_TASK_NUM
     *
     * @param bugTaskNum the value for qa_buglist.BUG_TASK_NUM
     *
     * @mbg.generated
     */
    public void setBugTaskNum(String bugTaskNum) {
        this.bugTaskNum = bugTaskNum == null ? null : bugTaskNum.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column qa_buglist.QA_TYPE_ID
     *
     * @return the value of qa_buglist.QA_TYPE_ID
     *
     * @mbg.generated
     */
    public Integer getQaTypeId() {
        return qaTypeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column qa_buglist.QA_TYPE_ID
     *
     * @param qaTypeId the value for qa_buglist.QA_TYPE_ID
     *
     * @mbg.generated
     */
    public void setQaTypeId(Integer qaTypeId) {
        this.qaTypeId = qaTypeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column qa_buglist.BUG_DESCRIPTION
     *
     * @return the value of qa_buglist.BUG_DESCRIPTION
     *
     * @mbg.generated
     */
    public String getBugDescription() {
        return bugDescription;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column qa_buglist.BUG_DESCRIPTION
     *
     * @param bugDescription the value for qa_buglist.BUG_DESCRIPTION
     *
     * @mbg.generated
     */
    public void setBugDescription(String bugDescription) {
        this.bugDescription = bugDescription == null ? null : bugDescription.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column qa_buglist.BUG_RCA
     *
     * @return the value of qa_buglist.BUG_RCA
     *
     * @mbg.generated
     */
    public String getBugRca() {
        return bugRca;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column qa_buglist.BUG_RCA
     *
     * @param bugRca the value for qa_buglist.BUG_RCA
     *
     * @mbg.generated
     */
    public void setBugRca(String bugRca) {
        this.bugRca = bugRca == null ? null : bugRca.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column qa_buglist.BUG_SOLUTION
     *
     * @return the value of qa_buglist.BUG_SOLUTION
     *
     * @mbg.generated
     */
    public String getBugSolution() {
        return bugSolution;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column qa_buglist.BUG_SOLUTION
     *
     * @param bugSolution the value for qa_buglist.BUG_SOLUTION
     *
     * @mbg.generated
     */
    public void setBugSolution(String bugSolution) {
        this.bugSolution = bugSolution == null ? null : bugSolution.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column qa_buglist.QA_ASSIGNEE_ID
     *
     * @return the value of qa_buglist.QA_ASSIGNEE_ID
     *
     * @mbg.generated
     */
    public Integer getQaAssigneeId() {
        return qaAssigneeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column qa_buglist.QA_ASSIGNEE_ID
     *
     * @param qaAssigneeId the value for qa_buglist.QA_ASSIGNEE_ID
     *
     * @mbg.generated
     */
    public void setQaAssigneeId(Integer qaAssigneeId) {
        this.qaAssigneeId = qaAssigneeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column qa_buglist.QA_TESTER_ID
     *
     * @return the value of qa_buglist.QA_TESTER_ID
     *
     * @mbg.generated
     */
    public Integer getQaTesterId() {
        return qaTesterId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column qa_buglist.QA_TESTER_ID
     *
     * @param qaTesterId the value for qa_buglist.QA_TESTER_ID
     *
     * @mbg.generated
     */
    public void setQaTesterId(Integer qaTesterId) {
        this.qaTesterId = qaTesterId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column qa_buglist.QA_CREATIONDT
     *
     * @return the value of qa_buglist.QA_CREATIONDT
     *
     * @mbg.generated
     */
    public Date getQaCreationdt() {
        return qaCreationdt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column qa_buglist.QA_CREATIONDT
     *
     * @param qaCreationdt the value for qa_buglist.QA_CREATIONDT
     *
     * @mbg.generated
     */
    public void setQaCreationdt(Date qaCreationdt) {
        this.qaCreationdt = qaCreationdt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column qa_buglist.QA_UPDATEDT
     *
     * @return the value of qa_buglist.QA_UPDATEDT
     *
     * @mbg.generated
     */
    public Date getQaUpdatedt() {
        return qaUpdatedt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column qa_buglist.QA_UPDATEDT
     *
     * @param qaUpdatedt the value for qa_buglist.QA_UPDATEDT
     *
     * @mbg.generated
     */
    public void setQaUpdatedt(Date qaUpdatedt) {
        this.qaUpdatedt = qaUpdatedt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column qa_buglist.BUG_DELETED_FLAG
     *
     * @return the value of qa_buglist.BUG_DELETED_FLAG
     *
     * @mbg.generated
     */
    public Boolean getBugDeletedFlag() {
        return bugDeletedFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column qa_buglist.BUG_DELETED_FLAG
     *
     * @param bugDeletedFlag the value for qa_buglist.BUG_DELETED_FLAG
     *
     * @mbg.generated
     */
    public void setBugDeletedFlag(Boolean bugDeletedFlag) {
        this.bugDeletedFlag = bugDeletedFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column qa_buglist.BUG_DELETED_COMMENT
     *
     * @return the value of qa_buglist.BUG_DELETED_COMMENT
     *
     * @mbg.generated
     */
    public String getBugDeletedComment() {
        return bugDeletedComment;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column qa_buglist.BUG_DELETED_COMMENT
     *
     * @param bugDeletedComment the value for qa_buglist.BUG_DELETED_COMMENT
     *
     * @mbg.generated
     */
    public void setBugDeletedComment(String bugDeletedComment) {
        this.bugDeletedComment = bugDeletedComment == null ? null : bugDeletedComment.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table qa_buglist
     *
     * @mbg.generated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", bugId=").append(bugId);
        sb.append(", bugProjectId=").append(bugProjectId);
        sb.append(", bugCrTypeId=").append(bugCrTypeId);
        sb.append(", bugCrNum=").append(bugCrNum);
        sb.append(", bugTaskNum=").append(bugTaskNum);
        sb.append(", qaTypeId=").append(qaTypeId);
        sb.append(", bugDescription=").append(bugDescription);
        sb.append(", bugRca=").append(bugRca);
        sb.append(", bugSolution=").append(bugSolution);
        sb.append(", qaAssigneeId=").append(qaAssigneeId);
        sb.append(", qaTesterId=").append(qaTesterId);
        sb.append(", qaCreationdt=").append(qaCreationdt);
        sb.append(", qaUpdatedt=").append(qaUpdatedt);
        sb.append(", bugDeletedFlag=").append(bugDeletedFlag);
        sb.append(", bugDeletedComment=").append(bugDeletedComment);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}