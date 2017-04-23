package br.com.github.aelkz.gmapseta.app.model;

import br.com.github.aelkz.gmapseta.app.repository.Routes;
import org.springframework.data.annotation.Id;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Info {

    @Id
    private Long id;
    private String name;
    private String description;
    private Double kilometers;
    private String routeUrl;
    private String startingPoint;
    private String endindPoint;

    // traffic
    private String arriveTime;
    private String trafficTime;

    public Info() {
    }

    public Info(Long id, String name, String description, Double kilometers, String routeUrl, String arriveTime, String trafficTime, String startingPoint, String endindPoint) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.kilometers = kilometers;
        this.routeUrl = routeUrl;
        this.arriveTime = arriveTime;
        this.trafficTime = trafficTime;
        this.startingPoint = startingPoint;
        this.endindPoint = endindPoint;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getKilometers() {
        return kilometers;
    }

    public void setKilometers(Double kilometers) {
        this.kilometers = kilometers;
    }

    public String getRouteUrl() {
        return routeUrl;
    }

    public void setRouteUrl(String routeUrl) {
        this.routeUrl = routeUrl;
    }

    public String getArriveTime() { return arriveTime; }

    public void setArriveTime(String arriveTime) { this.arriveTime = arriveTime; }

    public String getTrafficTime() { return trafficTime; }

    public void setTrafficTime(String trafficTime) { this.trafficTime = trafficTime; }

    public String getStartingPoint() { return startingPoint; }

    public void setStartingPoint(String startingPoint) { this.startingPoint = startingPoint; }

    public String getEndindPoint() { return endindPoint; }

    public void setEndindPoint(String endindPoint) { this.endindPoint = endindPoint; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Info)) return false;

        Info info = (Info) o;

        if (!getId().equals(info.getId())) return false;
        if (getDescription() != null ? !getDescription().equals(info.getDescription()) : info.getDescription() != null)
            return false;
        if (getKilometers() != null ? !getKilometers().equals(info.getKilometers()) : info.getKilometers() != null)
            return false;
        return getRouteUrl().equals(info.getRouteUrl());
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + (getDescription() != null ? getDescription().hashCode() : 0);
        result = 31 * result + (getKilometers() != null ? getKilometers().hashCode() : 0);
        result = 31 * result + getRouteUrl().hashCode();
        return result;
    }

    public static class Builder {
        private String source;
        private Routes route;

        public Builder(String source, Routes route) {
            this.source = source;
            this.route = route;
        }

        public String getSource() { return source; }

        public void setSource(String source) { this.source = source; }

        // see: https://docs.oracle.com/javase/7/docs/api/java/util/regex/Pattern.html
        public String[] extractTime(String src) {
            Pattern p = Pattern.compile("(\\d{2,3}\\smin)(.{1,20})(\\d{2,3}\\smin)",Pattern.CASE_INSENSITIVE);
            Matcher m = p.matcher(src);
            String values[] = new String[]{"",""};
            if(m.find()) {
                values[0] = m.group(1);
                values[1] = m.group(3);
            }
            return values;
        }

        public Info build() {
            Info info = new Info();

            String times[] = extractTime(getSource());

            info.setDescription(route.getDescription());
            info.setId(route.getId());
            info.setKilometers(route.getKilometers());
            info.setName(route.name().toUpperCase());
            info.setRouteUrl(route.getRouteUrl());
            info.setStartingPoint(route.getStartingPoint());
            info.setEndindPoint(route.getEndingPoint());

            info.setTrafficTime(times[0]);
            info.setArriveTime(times[1]);

            return info;
        }
    }

}