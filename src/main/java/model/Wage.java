package model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize
public class Wage {

    public double getKwota() {
        return kwota;
    }

    public String getWaluta() {
        return waluta;
    }


    @JsonProperty("kwota")
    public  double kwota;
    @JsonProperty("waluta")
    public  String waluta;

    public void setKwota(double kwota) {
        this.kwota = kwota;
    }

    public void setWaluta(String waluta) {
        this.waluta = waluta;
    }

}
