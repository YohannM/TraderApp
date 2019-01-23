/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author p1702174
 */
public class ValueChecker {
    
    public static boolean strEstValide(String s)
    {
        return s != null && !s.equals("");
    }
    
    public static boolean floatEstValide(float f)
    {
        return f >= 0;
    }
    
}
