/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import com.samuel.server.database.Database;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.*;


/**
 *
 * @author sscos
 */
public class ServerTest {
    
   @Test
   public void Conexao(){
       Database data = new Database();
       
       Boolean status = true;
       
       assertEquals(status, data.ConexaoStatus());
   }
}
