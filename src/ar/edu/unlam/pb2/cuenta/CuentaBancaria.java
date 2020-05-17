package ar.edu.unlam.pb2.cuenta;

public abstract class CuentaBancaria {
    
	protected Integer cbu;
	protected Cliente cliente;
	protected Double saldo;

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cbu == null) ? 0 : cbu.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CuentaBancaria other = (CuentaBancaria) obj;
		if (cbu == null) {
			if (other.cbu != null)
				return false;
		} else if (!cbu.equals(other.cbu))
			return false;
		return true;
	}


	public CuentaBancaria(Integer nroDecCuenta, Cliente cliente, Double saldo) {
		super();
		this.cbu = nroDecCuenta;
		this.cliente = cliente;
		this.saldo = saldo;
	}

	
	public Integer getCbu() {
		return cbu;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public Double getSaldo() {
		return saldo;
	}

	public abstract void depositar(Double monto );
	
	public abstract Boolean extraer(Double monto);
		
		
	
	
	
}
