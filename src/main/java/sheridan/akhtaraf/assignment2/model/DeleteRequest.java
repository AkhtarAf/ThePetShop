package sheridan.akhtaraf.assignment2.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DeleteRequest {
    private Integer id;

    public DeleteRequest(Integer id) {
        this.id = id;
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }
}
