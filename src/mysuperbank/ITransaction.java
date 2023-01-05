/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package mysuperbank;

import java.time.LocalDateTime;

/**
 *
 * @author Mohaned
 */
public interface ITransaction {
    public void deposit(double money, LocalDateTime dateTime);
    public void withdraw(double money, LocalDateTime dateTime);
}
