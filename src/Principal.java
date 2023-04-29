import java.util.ArrayList;

public class Principal {

	public static void main(String[] args) throws Exception {

		System.out.println("Codigo en ejecución:\n");

		System.out.println(ejecutador(new Pulgadas(40000000)));

	}

	public static String ejecutador(Pulgadas pulgadas) {
		int m, f, y, p, q;

		try {
			m = (int) pulgadas.toMillas().getValor();
			pulgadas.setValor(pulgadas.getValor() - new Millas(m).toPulgadas().getValor());

			f = (int) pulgadas.toFurlongs().getValor();
			pulgadas.setValor(pulgadas.getValor() - new Furlongs(f).toPulgadas().getValor());

			y = (int) pulgadas.toYardas().getValor();
			pulgadas.setValor(pulgadas.getValor() - new Yardas(y).toPulgadas().getValor());

			p = (int) pulgadas.toPies().getValor();
			pulgadas.setValor(pulgadas.getValor() - new Pies(p).toPulgadas().getValor());

			q = (int) pulgadas.toPulgadas().getValor();
			return "" + m + " " + f + " " + " " + y + " " + p + " " + q;

		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}

	}

}

abstract class UnidadImperial {

	public static final double MILLA_TO_FURLONGS = 8.0;
	public static final double FURLONG_TO_YARDAS = 220.0;
	public static final double YARDA_TO_PIES = 3;
	public static final double PIE_TO_PULGADAS = 12;

	public static final double MILLA_TO_YARDAS = MILLA_TO_FURLONGS * FURLONG_TO_YARDAS;
	public static final double MILLA_TO_PIES = MILLA_TO_YARDAS * YARDA_TO_PIES;
	public static final double MILLA_TO_PULGADAS = MILLA_TO_PIES * PIE_TO_PULGADAS;

	public static final double FURLONG_TO_MILLAS = 1.0 / MILLA_TO_FURLONGS;
	public static final double FURLONG_TO_PIES = FURLONG_TO_YARDAS * YARDA_TO_PIES;
	public static final double FURLONG_TO_PULGADAS = FURLONG_TO_PIES * PIE_TO_PULGADAS;

	public static final double YARDA_TO_MILLAS = 1.0 / MILLA_TO_YARDAS;
	public static final double YARDA_TO_FURLONGS = 1.0 / FURLONG_TO_YARDAS;
	public static final double YARDA_TO_PULGADAS = YARDA_TO_PIES * PIE_TO_PULGADAS;

	public static final double PIE_TO_MILLAS = 1.0 / MILLA_TO_PIES;
	public static final double PIE_TO_FURLONGS = 1.0 / FURLONG_TO_PIES;
	public static final double PIE_TO_YARDAS = 1.0 / YARDA_TO_PIES;

	public static final double PULGADA_TO_MILLAS = 1.0 / MILLA_TO_PULGADAS;
	public static final double PULGADA_TO_FURLONG = 1.0 / FURLONG_TO_PULGADAS;
	public static final double PULGADA_TO_YARDAS = 1.0 / YARDA_TO_PULGADAS;
	public static final double PULGADA_TO_PIES = 1.0 / PIE_TO_PULGADAS;

	private double valor;

	public UnidadImperial(double valor) throws Exception {
		this.setValor(valor);
	}

	public String toString() {
		return "" + this.valor + " " + this.getClass().getName();
	}

	public double getValor() {
		return this.valor;
	}

	public void setValor(double valor) throws Exception {
		if (valor < 0) {
			throw new Exception("Número debe ser mayor a cero.");
		} else {
			this.valor = valor;
		}
	}

	public Millas toMillas() {
		try {
			switch (this.getClass().getName()) {
			case "Millas":
				return new Millas(this.valor);
			case "Furlongs":
				return new Millas(this.valor * FURLONG_TO_MILLAS);
			case "Yardas":
				return new Millas(this.valor * YARDA_TO_MILLAS);
			case "Pies":
				return new Millas(this.valor * PIE_TO_MILLAS);
			case "Pulgadas":
				return new Millas(this.valor * PULGADA_TO_MILLAS);
			default:
				throw new Exception("Unidad no reconocida.");
			}
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	};

	public Furlongs toFurlongs() {
		try {
			switch (this.getClass().getName()) {
			case "Millas":
				return new Furlongs(this.valor * MILLA_TO_FURLONGS);
			case "Furlongs":
				return new Furlongs(this.valor);
			case "Yardas":
				return new Furlongs(this.valor * YARDA_TO_FURLONGS);
			case "Pies":
				return new Furlongs(this.valor * PIE_TO_FURLONGS);
			case "Pulgadas":
				return new Furlongs(this.valor * PULGADA_TO_FURLONG);
			default:
				throw new Exception("Unidad no reconocida.");
			}
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public Yardas toYardas() {
		try {
			switch (this.getClass().getName()) {
			case "Millas":
				return new Yardas(this.valor * MILLA_TO_YARDAS);
			case "Furlongs":
				return new Yardas(this.valor * FURLONG_TO_YARDAS);
			case "Yardas":
				return new Yardas(this.valor);
			case "Pies":
				return new Yardas(this.valor * PIE_TO_YARDAS);
			case "Pulgadas":
				return new Yardas(this.valor * PULGADA_TO_YARDAS);
			default:
				throw new Exception("Unidad no reconocida.");
			}
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public Pies toPies() {
		try {
			switch (this.getClass().getName()) {
			case "Millas":
				return new Pies(this.valor * MILLA_TO_PIES);
			case "Furlongs":
				return new Pies(this.valor * FURLONG_TO_PIES);
			case "Yardas":
				return new Pies(this.valor * YARDA_TO_PIES);
			case "Pies":
				return new Pies(this.valor);
			case "Pulgadas":
				return new Pies(this.valor * PULGADA_TO_PIES);
			default:
				throw new Exception("Unidad no reconocida.");
			}
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public Pulgadas toPulgadas() {
		try {
			switch (this.getClass().getName()) {
			case "Millas":
				return new Pulgadas(this.valor * MILLA_TO_PULGADAS);
			case "Furlongs":
				return new Pulgadas(this.valor * FURLONG_TO_PULGADAS);
			case "Yardas":
				return new Pulgadas(this.valor * YARDA_TO_PULGADAS);
			case "Pies":
				return new Pulgadas(this.valor * PIE_TO_PULGADAS);
			case "Pulgadas":
				return new Pulgadas(this.valor);
			default:
				throw new Exception("Unidad no reconocida.");
			}
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

}

class Millas extends UnidadImperial {

	public Millas(double valor) throws Exception {
		super(valor);
	}

}

class Furlongs extends UnidadImperial {

	public Furlongs(double valor) throws Exception {
		super(valor);
	}

}

class Yardas extends UnidadImperial {

	public Yardas(double valor) throws Exception {
		super(valor);
		// TODO Auto-generated constructor stub
	}

}

class Pies extends UnidadImperial {

	public Pies(double valor) throws Exception {
		super(valor);
		// TODO Auto-generated constructor stub
	}

}

class Pulgadas extends UnidadImperial {

	public Pulgadas(double valor) throws Exception {
		super(valor);
		// TODO Auto-generated constructor stub
	}

}
