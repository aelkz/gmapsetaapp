package br.com.github.aelkz.gmapseta.app.repository;

public enum Point {
    HOME(1L,"home","-15.658317,-47.8024429"),
    WORK(2L,"work","-15.7921982,-47.8721076"),
    EMPTY(99L,"","")
    ;

    private Long id;
    private String description;
    private String position;

    Point(Long id, String description, String position) {
        this.id = id;
        this.description = description;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public static Point getPoint(Integer id) {
        for (Point point: Point.values()) {
            if (point.getId().intValue() == id) {
                return point;
            }
        }
        return null;
    }

}