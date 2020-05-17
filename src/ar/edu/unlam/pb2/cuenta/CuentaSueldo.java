package ar.edu.unlam.pb2.cuenta;

public class CuentaSueldo extends CuentaBancaria {
    
	public CuentaSueldo(Integer nroDecCuenta, Cliente cliente, Double saldo) {
		super(nroDecCuenta, cliente, saldo);
		// TODO Auto-generated constructor stub
	}
   
	@Override
	public void depositar(Double monto) {
		
		this.saldo+=monto;
		
	}

	@Override
	public Boolean extraer(Double monto) {
		 
		if(sePuedeExtraer(monto)){
			this.saldo-=monto;
			return true;
		}
		return false;
	}
    
	public Boolean sePuedeExtraer(Double monto){
		
		if(monto <= saldo ){
			return true;
		}
		return false;
	}
	
	

}
