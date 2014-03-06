/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util.holder;

import java.math.BigDecimal;

/**
 *
 * @author Semir
 */
public class CompetenceHolder {

    String competenceName;
    BigDecimal yoe;

    public String getCompetenceName() {
        return competenceName;
    }

    public void setCompetenceName(String competenceName) {
        this.competenceName = competenceName;
    }

    public BigDecimal getYoe() {
        return yoe;
    }

    public void setYoe(BigDecimal yoe) {
        this.yoe = yoe;
    }

}
