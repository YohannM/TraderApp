/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.io.Serializable;
import static utils.ValueChecker.floatEstValide;
import static utils.ValueChecker.strEstValide;

/**
 *
 * @author natov
 */
public class Trade implements Serializable{
    
    private int idTrade;
    private String symbol;
    private float open;
    private float high;
    private float close;
    private float low;

    
    public Trade()
    {
        this.symbol = "AAA";
        this.high = 15;
        this.close = 2;
        this.low = 2;
        this.open = 1;
    }
    
    public Trade(String sym)
    {
        this();
        this.symbol = strEstValide(sym) ? sym : this.symbol;
    }
    
    public Trade(String sym, float open, float high, float close, float low)
    {
        this();
        this.symbol = strEstValide(sym) ? sym : this.symbol;
        this.high = floatEstValide(high) ? high : this.high;
        this.close = floatEstValide(close) ? close : this.close;
        this.low = floatEstValide(low) ? low : this.low;
        this.open = floatEstValide(open) ? open : this.open;
    }
    
    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public float getOpen() {
        return open;
    }

    public void setOpen(float open) {
        this.open = open;
    }

    public float getHigh() {
        return high;
    }

    public void setHigh(float high) {
        this.high = high;
    }

    public float getClose() {
        return close;
    }

    public void setClose(float close) {
        this.close = close;
    }

    public float getLow() {
        return low;
    }

    public void setLow(float low) {
        this.low = low;
    }

    public String serialize() {
        return "Trade{" + "symbol=" + symbol + ", open=" + open + ", high=" + high + ", close=" + close + ", low=" + low + '}';
    }
    
    @Override
    public String toString()
    {
        return "Symbol :" + this.getSymbol() + "\nClose : " + String.valueOf(this.getClose()) + "\nHigh : " + String.valueOf(this.getHigh()) + "\nLow : " + String.valueOf(this.getLow()) + "\nClose : " + String.valueOf(this.getClose());
    }
    
}
