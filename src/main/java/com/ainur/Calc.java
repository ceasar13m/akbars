package com.ainur;

import org.springframework.stereotype.Service;

import com.ainur.model.Data;

@Service
public class Calc {

    public double getLimit(Data data) {
        double limitMa = getLimitMA(data.getaIncMA(), data.getKolIzdMA(), data.getaExpBankMA(), data.getaExpAnkMA(), data.getaExpBKIMA());
        double limitSP = getLimitSP(data.getaIncSP(), data.getKolIzdSP(), data.getaExpBankSP(), data.getaExpAnkSP(), data.getaExpBKISP());
        return limitMa + limitSP * 0.3;
    }

    private double getLimitMA(double aInc, int KolIzd, double aExpBank, double aExpAnk, double aExpBKI) {
        return aInc - KolIzd * 0.09 - aExpBank - aExpAnk - aExpBKI;
    }

    private double getLimitSP(double aInc, int KolIzd, double aExpBank, double aExpAnk, double aExpBKI) {
        if (aInc == 0 && KolIzd == 0 && aExpBank == 0 && aExpAnk == 0 && aExpBKI == 0)
            return 0;
        else
            return aInc * 0.5 - KolIzd * 0.03 - aExpBank - aExpAnk - aExpBKI;
    }
}
