package tz.go.moh.him.hfr.mediator.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents a Health Facility Registry request message.
 */
public class HcmisHfrRequest extends HrhisHfrRequest {
    @JsonProperty("IsDesignated")
    private int isDesignated;

    @JsonProperty("Vote")
    private String vote;

    public int getIsDesignated() {
        return isDesignated;
    }

    public void setIsDesignated(int isDesignated) {
        this.isDesignated = isDesignated;
    }

    public String getVote() {
        return vote;
    }

    public void setVote(String vote) {
        this.vote = vote;
    }
}
