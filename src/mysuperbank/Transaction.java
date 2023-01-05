/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mysuperbank;

import java.time.LocalDateTime;

/**
 *
 * @author Mohaned
 */
public class Transaction {
    private double money;
    LocalDateTime dt;
    
    public Transaction(double money, LocalDateTime date){
        this.money = money;
        dt = date;
    }
    
    public double getMoney(){
        return money;
    }
}
