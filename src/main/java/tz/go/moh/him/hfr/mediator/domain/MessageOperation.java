package tz.go.moh.him.hfr.mediator.domain;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Represents a message operation.
 */
public enum MessageOperation {
    /**
     * Represents a post.
     */
    Post("P"),

    /**
     * Represents a update.
     */
    Update("U");

    /**
     * Represents the operation.
     */
    private final String operation;

    /**
     * Initializes a new instance of the {@link MessageOperation} class.
     *
     * @param operation The operation.
     */
    MessageOperation(String operation) {
        this.operation = operation;
    }

    /**
     * Gets the operation.
     *
     * @return Returns the operation.
     */
    @JsonValue
    public String getOperation() {
        return this.operation;
    }
}
