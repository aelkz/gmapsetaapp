package br.com.github.aelkz.gmapseta.app.repository;

import java.util.ArrayList;
import java.util.List;

public enum Route {
    // WORK2HOME
    L4_EPIA(1L,"N2 Norte, L4 Norte, Pier Asa Norte, Boulevard Shopping e EPIA",29.1,"https://www.google.com.br/maps/dir/-15.7922056,-47.8721159/Edif%C3%ADcio+Sobradinho+I+-+Q+2+Conjunto+B4,+Bras%C3%ADlia+-+DF/@-15.7517066,-47.8619975,14z/data=!4m34!4m33!1m25!3m4!1m2!1d-47.8583339!2d-15.7912141!3s0x935a3b6a3b019d89:0x762790ba200790ab!3m4!1m2!1d-47.8632066!2d-15.769395!3s0x935a3ba21256e2a7:0x14d467b4b0bebf07!3m4!1m2!1d-47.8795237!2d-15.7446368!3s0x935a397feba1b83f:0x43b2f3824f531e4e!3m4!1m2!1d-47.9000175!2d-15.732741!3s0x935a39936742f6b7:0x229001779c2bf179!3m4!1m2!1d-47.9112275!2d-15.7320843!3s0x935a39e86dde59f5:0x31584c755a003c57!1m5!1m1!1s0x935a3f9d4899e0f7:0x36b84418dd6501a1!2m2!1d-47.8021102!2d-15.6582994!3e0",Point.WORK,Point.HOME),
    L2_EPIA(2L,"L2 Norte, L4 Norte, Pier da Asa Norte, Boulevard Shopping e EPIA",26.0,"https://www.google.com.br/maps/dir/-15.7922056,-47.8721159/Edif%C3%ADcio+Sobradinho+I+-+Q+2+Conjunto+B4,+Bras%C3%ADlia+-+DF/@-15.7285911,-47.8914949,14.75z/data=!4m29!4m28!1m20!3m4!1m2!1d-47.8739621!2d-15.7801242!3s0x935a3b064f3a4471:0xf5f487dbd0782dc4!3m4!1m2!1d-47.8805991!2d-15.7513821!3s0x935a3bcd65164399:0xde74e50f4d8525ec!3m4!1m2!1d-47.9000175!2d-15.732741!3s0x935a39936742f6b7:0x229001779c2bf179!3m4!1m2!1d-47.9112275!2d-15.7320843!3s0x935a39e86dde59f5:0x31584c755a003c57!1m5!1m1!1s0x935a3f9d4899e0f7:0x36b84418dd6501a1!2m2!1d-47.8021102!2d-15.6582994!3e0",Point.WORK,Point.HOME),
    EIXO_ERW_EPIA(3L,"N2 Norte, Setor Bancário Norte, Eixo ERW e EPIA",26.6,"https://www.google.com.br/maps/dir/-15.7922056,-47.8721159/-15.7897922,-47.8804032/Edif%C3%ADcio+Sobradinho+I+-+Q+2+Conjunto+B4,+Bras%C3%ADlia+-+DF/@-15.7856347,-47.8901891,16z/data=!4m25!4m24!1m5!3m4!1m2!1d-47.8784028!2d-15.7914532!3s0x935a3b1c6bd37a7b:0x6986e3139b036ff1!1m10!3m4!1m2!1d-47.8814415!2d-15.7869032!3s0x935a3b028e512591:0x8847f9af2a48137!3m4!1m2!1d-47.9044665!2d-15.7328484!3s0x935a39eb7803fec9:0x611e535131bbe202!1m5!1m1!1s0x935a3f9d4899e0f7:0x36b84418dd6501a1!2m2!1d-47.8021102!2d-15.6582994!3e0",Point.WORK,Point.HOME),
    EIXO_ERL_AGUL214_EIXAO(4L,"Eixo ERL, Agulhinha na 214N e Eixão (Ponte do Bragueto)",23.1,"https://www.google.com.br/maps/dir/-15.7922056,-47.8721159/Edif%C3%ADcio+Sobradinho+I+-+Q+2+Conjunto+B4,+Bras%C3%ADlia+-+DF/@-15.7733268,-47.8748364,14.5z/data=!4m14!4m13!1m5!3m4!1m2!1d-47.8892573!2d-15.7454003!3s0x935a3a29ca12d9db:0xb0b3a3d5c0584c4f!1m5!1m1!1s0x935a3f9d4899e0f7:0x36b84418dd6501a1!2m2!1d-47.8021102!2d-15.6582994!3e0",Point.WORK,Point.HOME),
    PONTEJK_PARANOA(5L,"N2 Norte, Ponte JK, EPDB/Paranoá, EPCT/Paranoá e Torre de TV Digital",37.2,"https://www.google.com.br/maps/dir/-15.7922056,-47.8721159/Edif%C3%ADcio+Sobradinho+I+-+Q+2+Conjunto+B4,+Bras%C3%ADlia+-+DF/@-15.7578684,-47.8378537,13.25z/data=!4m14!4m13!1m5!3m4!1m2!1d-47.776043!2d-15.7792226!3s0x935a3d448985f0ff:0x7dd094291e8e377e!1m5!1m1!1s0x935a3f9d4899e0f7:0x36b84418dd6501a1!2m2!1d-47.8021102!2d-15.6582994!3e0",Point.WORK,Point.HOME),
    EIXO_MONUMENTAL_EPIA(6L,"retorno Eixo ERL, Eixo Monumental e EPIA",29.5,"https://www.google.com.br/maps/dir/-15.7928297,-47.8727061/-15.7834331,-47.9127256/Edif%C3%ADcio+Sobradinho+I+-+Q+2+Conjunto+B4,+Bras%C3%ADlia+-+DF/@-15.7839077,-47.9261887,15z/data=!4m15!4m14!1m5!3m4!1m2!1d-47.8737601!2d-15.7889347!3s0x935a3b1af3b7646d:0x6a96e4988deabde3!1m0!1m5!1m1!1s0x935a3f9d4899e0f7:0x36b84418dd6501a1!2m2!1d-47.8021102!2d-15.6582994!3e0",Point.WORK,Point.HOME),
    // HOME2WORK
    L4(6L,"BR-010/BR-020, BR-450 e L4 Norte",28.2,"https://www.google.com.br/maps/dir/Edif%C3%ADcio+Sobradinho+I+-+Q+2+Conjunto+B4,+Brasilia+-+Federal+District/-15.7376207,-47.896384/-15.7359741,-47.8977719/-15.7341081,-47.8965396/-15.7323409,-47.8905236/-15.7535811,-47.8714287/-15.7871582,-47.8585325/-15.7926924,-47.859813/-15.7921912,-47.872105/@-15.7261612,-47.8864774,13z/data=!3m1!4b1!4m21!4m20!1m10!1m1!1s0x935a3f9d4899e0f7:0x36b84418dd6501a1!2m2!1d-47.8021102!2d-15.6582994!3m4!1m2!1d-47.8946602!2d-15.7295076!3s0x935a3996e270a2a1:0x94a024c85f887ba!1m0!1m0!1m0!1m0!1m0!1m0!1m0!1m0!3e0",Point.HOME,Point.WORK),
    EIXAO(7L,"BR-010/BR-020 e Eixo Rodoviário de Brasília",29.9,"https://www.google.com.br/maps/dir/Edif%C3%ADcio+Sobradinho+I+-+Q+2+Conjunto+B4,+Brasilia+-+Federal+District/-15.7921912,-47.872105/@-15.7901025,-47.8791199,16.75z/data=!4m9!4m8!1m5!1m1!1s0x935a3f9d4899e0f7:0x36b84418dd6501a1!2m2!1d-47.8021102!2d-15.6582994!1m0!3e0",Point.HOME,Point.WORK)
    ;

    private Long id;
    private String description;
    private Double kilometers;
    private String routeUrl;
    private Point startingPoint;
    private Point endingPoint;

    Route(Long id, String description, Double kilometers, String routeUrl, Point startingPoint, Point endingPoint) {
        this.id = id;
        this.description = description;
        this.kilometers = kilometers;
        this.routeUrl = routeUrl;
        this.startingPoint = startingPoint;
        this.endingPoint = endingPoint;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRouteUrl() {
        return routeUrl;
    }

    public void setRouteUrl(String routeUrl) {
        this.routeUrl = routeUrl;
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

    public Point getStartingPoint() { return startingPoint; }

    public void setStartingPoint(Point startingPoint) { this.startingPoint = startingPoint; }

    public Point getEndingPoint() { return endingPoint; }

    public void setEndingPoint(Point endingPoint) {
        this.endingPoint = endingPoint;
    }

    public String getKilometersAsText() {
        String text = String.valueOf(getKilometers())+" km";
        return text.replace('.',',');
    }

    public static String getURL(String id) {
        String routeID = null;
        for (Route route: Route.values()) {
            routeID = String.valueOf(route.getId());
            if (routeID.equalsIgnoreCase(id)) {
                return route.getRouteUrl();
            }
        }
        routeID = null;
        return null;
    }

    public static Route getRoute(String id) {
        String routeID = null;
        for (Route route: Route.values()) {
            routeID = String.valueOf(route.getId());
            if (routeID.equalsIgnoreCase(id)) {
                return route;
            }
        }
        routeID = null;
        return null;
    }

    public static List<Route> getRoutesBy(Point startingPoint) {
        List<Route> routes = new ArrayList<>();

        for (Route route: Route.values()) {
            if (route.getStartingPoint().getId().intValue() == startingPoint.getId().intValue()) {
                routes.add(route);
            }
        }

        return routes;
    }

}