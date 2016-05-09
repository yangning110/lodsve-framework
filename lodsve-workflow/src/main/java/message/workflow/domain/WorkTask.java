package message.workflow.domain;

import java.util.Date;
import message.base.utils.DateUtils;
import message.workflow.enums.AuditResult;
import message.workflow.enums.UrlType;

/**
 * 工作流任务.
 *
 * @author sunhao(sunhao.java@gmail.com)
 * @version V1.0, 2015-11-18 下午1:43
 */
public class WorkTask {
    private Long id;
    /**
     * 流程ID
     */
    private Long flowId;
    /**
     * 流程名
     */
    private String flowTitle;
    /**
     * 节点ID
     */
    private Long nodeId;
    /**
     * 关联的资源ID
     */
    private Long resourceId;
    /**
     * 流程实例名称
     */
    private String processTitle;
    /**
     * 任务描述
     */
    private String nodeTitle;
    /**
     * 表单URL类型
     */
    private UrlType urlType;
    /**
     * 办理人Id
     */
    private Long taskUserId;
    /**
     * 办理人姓名
     */
    private String taskUserName;
    /**
     * 审核结果(为空即待办)
     */
    private AuditResult result;
    /**
     * 处理意见
     */
    private String remark;
    /**
     * 接收时间
     */
    private Date receiveTime = DateUtils.getNow();
    /**
     * 办理时间
     */
    private Date handleTime;

    /**
     * 关联表单的URL
     */
    private String formUrl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFlowId() {
        return flowId;
    }

    public void setFlowId(Long flowId) {
        this.flowId = flowId;
    }

    public String getFlowTitle() {
        return flowTitle;
    }

    public void setFlowTitle(String flowTitle) {
        this.flowTitle = flowTitle;
    }

    public Long getNodeId() {
        return nodeId;
    }

    public void setNodeId(Long nodeId) {
        this.nodeId = nodeId;
    }

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }

    public String getProcessTitle() {
        return processTitle;
    }

    public void setProcessTitle(String processTitle) {
        this.processTitle = processTitle;
    }

    public String getNodeTitle() {
        return nodeTitle;
    }

    public void setNodeTitle(String nodeTitle) {
        this.nodeTitle = nodeTitle;
    }

    public UrlType getUrlType() {
        return urlType;
    }

    public void setUrlType(UrlType urlType) {
        this.urlType = urlType;
    }

    public Long getTaskUserId() {
        return taskUserId;
    }

    public void setTaskUserId(Long taskUserId) {
        this.taskUserId = taskUserId;
    }

    public String getTaskUserName() {
        return taskUserName;
    }

    public void setTaskUserName(String taskUserName) {
        this.taskUserName = taskUserName;
    }

    public AuditResult getResult() {
        return result;
    }

    public void setResult(AuditResult result) {
        this.result = result;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(Date receiveTime) {
        this.receiveTime = receiveTime;
    }

    public Date getHandleTime() {
        return handleTime;
    }

    public void setHandleTime(Date handleTime) {
        this.handleTime = handleTime;
    }

    public String getFormUrl() {
        return formUrl;
    }

    public void setFormUrl(String formUrl) {
        this.formUrl = formUrl;
    }
}
