package br.com.github.aelkz.gmapseta.app.repository;

import java.util.ArrayList;
import java.util.List;

public enum Condition {
    EXCELLENT(1L,"Excellent","#91E52F","100%"),
    BEST(2L,"Best","#B2C831","90%"),
    GOOD(3L,"Good","#FFC90E","75%"),
    AVERAGE(4L,"Average","#FF7F27","60%"),
    BELOW_AVERAGE(5L,"Below Average","#F25D22","45%"),
    POOR(6L,"Poor","#FA1D2D","30%"),
    WORST(7L,"Worst","#C01F5C","15%"),
    ;

    private Long id;
    private String description;
    private String hexaColor;
    private String fillPercent; // can be more wise (further logic upgrade)

    Condition(Long id, String description, String hexaColor, String fillPercent) {
        this.id = id;
        this.description = description;
        this.hexaColor = hexaColor;
        this.fillPercent = fillPercent;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHexaColor() { return hexaColor; }

    public void setHexaColor(String hexaColor) { this.hexaColor = hexaColor; }

    public String getFillPercent() { return fillPercent; }

    public void setFillPercent(String fillPercent) { this.fillPercent = fillPercent; }

    public static Condition getBy(Long id) {
        for (Condition condition: Condition.values()) {
            if (condition.getId().equals(id)) {
                return condition;
            }
        }

        return null;
    }

    public static Condition getBy(String description) {
        for (Condition condition: Condition.values()) {
            if (condition.getDescription().equals(description)) {
                return condition;
            }
        }

        return null;
    }

}