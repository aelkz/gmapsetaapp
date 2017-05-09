package br.com.github.aelkz.gmapseta.app.model;

import br.com.github.aelkz.gmapseta.app.repository.Point;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;

public class Status {

    @Id
    private Long id;
    private String name;
    private Double kilometers;
    private Point startingPoint;
    private Point endindPoint;
    private String trafficTime;
    private Boolean selected;
    private String color;
    private BigDecimal fillPercent;

    public Status() {
    }

    public Status(Long id, String name, Double kilometers, Point startingPoint, Point endindPoint, String trafficTime, Boolean selected, String color, BigDecimal fillPercent) {
        this.id = id;
        this.name = name;
        this.kilometers = kilometers;
        this.startingPoint = startingPoint;
        this.endindPoint = endindPoint;
        this.trafficTime = trafficTime;
        this.selected = selected;
        this.color = color;
        this.fillPercent = fillPercent;
    }

    public static Status from(Info info) {
        Status status = new Status();
        status.setId(info.getId());
        status.setName(info.getName());
        status.setKilometers(info.getKilometers());
        status.setStartingPoint(info.getStartingPoint());
        status.setEndindPoint(info.getEndindPoint());
        status.setTrafficTime(info.getTrafficTime());
        return status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getKilometers() {
        return kilometers;
    }

    public void setKilometers(Double kilometers) {
        this.kilometers = kilometers;
    }

    public String getTrafficTime() { return trafficTime; }

    @JsonIgnore
    public BigDecimal getTraffic() {
        return new BigDecimal(getTrafficTime().replace(" min","").trim());
    }

    public void setTrafficTime(String trafficTime) { this.trafficTime = trafficTime; }

    public Point getStartingPoint() { return startingPoint; }

    public void setStartingPoint(Point startingPoint) { this.startingPoint = startingPoint; }

    public Point getEndindPoint() { return endindPoint; }

    public void setEndindPoint(Point endindPoint) { this.endindPoint = endindPoint; }

    public Boolean getSelected() { return selected; }

    public void setSelected(Boolean selected) { this.selected = selected; }

    public String getColor() { return color; }

    public void setColor(String color) { this.color = color; }

    public BigDecimal getFillPercent() { return fillPercent; }

    public void setFillPercent(BigDecimal fillPercent) { this.fillPercent = fillPercent; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Status)) return false;

        Status status = (Status) o;

        if (!getId().equals(status.getId())) return false;
        if (!getName().equals(status.getName())) return false;
        return getKilometers().equals(status.getKilometers());
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getName().hashCode();
        result = 31 * result + getKilometers().hashCode();
        return result;
    }

}