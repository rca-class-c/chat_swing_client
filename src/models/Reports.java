package models;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

/**
 * model for all reports
 * @author damour
 * @version 0.0.1
 */
public class Reports {
    private String messageId;
    private int total;
    private String createAt;

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    public List returnreport(String data) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        List reports = objectMapper.readValue(data, List.class);
        return reports;
    }
}
