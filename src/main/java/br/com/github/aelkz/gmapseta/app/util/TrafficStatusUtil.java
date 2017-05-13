package br.com.github.aelkz.gmapseta.app.util;

import br.com.github.aelkz.gmapseta.app.model.Status;
import br.com.github.aelkz.gmapseta.app.repository.Condition;

import java.math.BigDecimal;


public class TrafficStatusUtil {

    /**
     * Calculates de traffic condition based on the actual traffic time.
     * This function can be adjusted later to get better insights based
     * on the user traffic experience
     * @param status
     * @return
     */
    public static Condition calculateTrafficCondition(Status status) {
        Long noTrafficTime = status.getNoTraffic().longValue();
        Long trafficTime = status.getTraffic().longValue();

        if (trafficTime <= (noTrafficTime+2)) {
            return Condition.EXCELLENT;
        }else if (trafficTime <= (noTrafficTime+5)) {
            return Condition.BEST;
        }else if (trafficTime <= (noTrafficTime+7)) {
            return Condition.GOOD;
        }else if (trafficTime <= (noTrafficTime+12)) {
            return Condition.AVERAGE;
        }else if (trafficTime <= (noTrafficTime+16)) {
            return Condition.BELOW_AVERAGE;
        }else if (trafficTime <= (noTrafficTime+19)) {
            return Condition.POOR;
        }else {
            return Condition.WORST;
        }
    }
}
