package com.portfolio.exception;

import com.portfolio.utils.enume.MessageCode;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * Created by e7006722 on 26/02/14.
 */
public class ApplicationException extends Exception {
    private MessageCode messageCode;

    public ApplicationException(MessageCode messageCode, String message, Throwable cause) {
        super(message, cause);
        this.messageCode = messageCode;
    }

    public ApplicationException(MessageCode messageCode, String message) {
        super(message);
        this.messageCode = messageCode;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("messageCode", messageCode)
                .toString();
    }

    public MessageCode getMessageCode() {
        return messageCode;
    }

    public void setMessageCode(MessageCode messageCode) {
        this.messageCode = messageCode;
    }
}
