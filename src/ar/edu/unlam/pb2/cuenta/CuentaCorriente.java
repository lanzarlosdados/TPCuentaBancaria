package ar.edu.unlam.pb2.cuenta;

public class CuentaCorriente extends CuentaBancaria {
    
	private Double limiteDescubierto;
	
	public CuentaCorriente(Integer nroDecCuenta, Cliente cliente, Double saldo,Double limiteDesCubierto) {
		super(nroDecCuenta, cliente, saldo);
		this.limiteDescubierto = limiteDesCubierto;
	}

	@Override
	public void depositar(Double monto) {
		
		this.saldo+=monto;

	}

	@Override
	public Boolean extraer(Double monto) {
		
		Boolean extraccion=false; 
		
		if(sePuedeExtraer(monto)){
			this.saldo-=monto;
			extraccion=true;
		}
		if(saldo<0){
			saldo-=(-saldo*5/100);
		}
		
		return extraccion;
	}
    
	public Boolean sePuedeExtraer(Double monto){
		
		if(monto <= (saldo+limiteDescubierto) ){
			return true;
		}
		return false;
	}
}
