package ar.edu.unlam.pb2.cuenta;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestCuenta {

	

	@Test
	public void testQueDepositeUnaCuentaSueldo() {
		
		Cliente cliente1 = new Cliente(528,"fabian", "zarate");
		CuentaSueldo cuenta1= new CuentaSueldo(100, cliente1, 10000d);
		
		Double monto=1000d;
		cuenta1.depositar(monto);
		
		Double actual = cuenta1.getSaldo();
		Double esperado = 11000d;
		
		assertEquals(esperado,actual,0.01);
		
	}
	

	@Test
	public void testQueDepositeUnaCorriente() {
		
		Cliente cliente1 = new Cliente(528,"fabian", "zarate");
		CuentaCorriente cuenta1= new CuentaCorriente(100, cliente1, 10000d, 2000d);
		
		Double monto=1000d;
		cuenta1.depositar(monto);
		
		Double actual = cuenta1.getSaldo();
		Double esperado = 11000d;
		
		assertEquals(esperado,actual,0.01);
		
	}
    
	@Test
	public void testQueExtraigaDineroCuentaCorriente(){
		
		Cliente cliente1 = new Cliente(528,"fabian", "zarate");
		CuentaCorriente cuenta1= new CuentaCorriente(100, cliente1, 10000d, 2000d);
		
		Double monto=1000d;
		cuenta1.extraer(monto);
		
		Double actual = cuenta1.getSaldo();
		Double esperado = 9000d;
		
		assertEquals(esperado,actual,0.01);
	}
	
	@Test
	public void testQueExtraigaDineroCuentaSueldo(){
		
		Cliente cliente1 = new Cliente(528,"fabian", "zarate");
		CuentaSueldo cuenta1= new CuentaSueldo(100, cliente1, 10000d);
		
		Double monto=1000d;
		cuenta1.extraer(monto);
		
		Double actual = cuenta1.getSaldo();
		Double esperado = 9000d;
		
		assertEquals(esperado,actual,0.01);
	}
	
	@Test
	public void testQueNoPuedaExtraerDineroEnUnaCuentaSueldo(){
		
		Cliente cliente1 = new Cliente(528,"fabian", "zarate");
		CuentaSueldo cuenta1= new CuentaSueldo(100, cliente1, 10000d);
		
		Double monto=11000d;
		
		
		Boolean actual = cuenta1.extraer(monto);
		
		
		assertFalse(actual);
	}
	   
	   @Test
       public void testQueNoPuedaExtraerDineroEnUnaCuentaCorriente(){
		
		Cliente cliente1 = new Cliente(528,"fabian", "zarate");
		CuentaCorriente cuenta1= new CuentaCorriente(100, cliente1, 10000d,2000d);
		
		Double monto=13000d;
		
		
		Boolean actual = cuenta1.extraer(monto);
		
		
		assertFalse(actual);
	}
	
	
	
	
}
