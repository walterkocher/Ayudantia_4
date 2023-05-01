package data;

import model.Enemigo;
import model.Jugador;
import java.io.*;

public class GestionArchivos {
	public boolean jugadorVsEnemigo(Jugador jugador, Enemigo enemigo, String direccion) {
		boolean lineaVacia = false;
		try {
			File file = new File(direccion);
			if (!file.exists()) {
				file.createNewFile();
				lineaVacia = true;
			}
			FileWriter fw = new FileWriter(file, true);
			BufferedWriter bw = new BufferedWriter(fw);
			if (lineaVacia == false) {
				bw.newLine();
			}
			bw.write("¡Has ganado la batalla contra "+enemigo.getTipo()+"!\nHaz recibido una mejora en tus atributos\n");
			bw.write(jugador.toString()+"\n");
			bw.close();
			fw.close();
			return true;
		} catch (Exception e) {
			System.out.println("Error al ingresar hora de llegada, favor contactar con administrador");
			return false;
		}
	}
	public boolean jugadorVsEnemigoEnfrentamiento(Jugador jugador, Enemigo enemigo, String direccion, int vidaJugador, int vidaEnemigo) {
		boolean lineaVacia = false;
		try {
			File file = new File(direccion);
			if (!file.exists()) {
				file.createNewFile();
				lineaVacia = true;
			}
			FileWriter fw = new FileWriter(file, true);
			BufferedWriter bw = new BufferedWriter(fw);
			if (lineaVacia == false) {
				bw.newLine();
			}
			bw.write(enemigo.getTipo()+" te ha inflingido "+enemigo.getFuerza()+" puntos de daño "+
							"\nVida restante del jugador: "+vidaJugador+"\n"+ jugador.getNombre()+" ha inflingido "+
							jugador.getFuerza()+" puntos de daño a "+enemigo.getTipo()+
					"\nVida restante del enemigo: "+vidaEnemigo+"\n");
			bw.close();
			fw.close();
			return true;
		} catch (Exception e) {
			System.out.println("Error al ingresar hora de llegada, favor contactar con administrador");
			return false;
		}
	}
	public boolean jugadorVsJugadorEnfrentamiento(Jugador jugador, Jugador jugador1, String direccion, int vidaJugador, int vidaJugador1) {
		boolean lineaVacia = false;
		try {
			File file = new File(direccion);
			if (!file.exists()) {
				file.createNewFile();
				lineaVacia = true;
			}
			FileWriter fw = new FileWriter(file, true);
			BufferedWriter bw = new BufferedWriter(fw);
			if (lineaVacia == false) {
				bw.newLine();
			}
			bw.write(jugador.getNombre()+" ha inflingido "+jugador.getFuerza()+" puntos de daño a "+jugador1.getNombre()+
					"\nVida restante de "+jugador1.getNombre()+" es: "+vidaJugador1+"\n"+
					jugador1.getNombre()+" ha inflingido "+jugador1.getFuerza()+" puntos de daño a "+jugador.getNombre()+
					"\nVida restante de "+jugador.getNombre()+" es: "+vidaJugador+"\n");
			bw.close();
			fw.close();
			return true;
		} catch (Exception e) {
			System.out.println("Error al ingresar hora de llegada, favor contactar con administrador");
			return false;
		}
	}
	public boolean jugadorVsEnemigo1(Enemigo enemigo, Jugador jugador, String direccion) {
		boolean lineaVacia = false;
		try {
			File file = new File(direccion);
			if (!file.exists()) {
				file.createNewFile();
				lineaVacia = true;
			}
			FileWriter fw = new FileWriter(file, true);
			BufferedWriter bw = new BufferedWriter(fw);
			if (lineaVacia == false) {
				bw.newLine();
			}
			bw.write(jugador.getNombre()+" ha sido derrotado por "+enemigo.getTipo()+"\nAtributos del "+enemigo.getTipo()+"\n"+
					enemigo);
			bw.close();
			fw.close();
			return true;
		} catch (Exception e) {
			System.out.println("Error al ingresar hora de llegada, favor contactar con administrador");
			return false;
		}
	}

	public boolean jugadorVsJugador(Jugador jugador, Jugador jugador1, String direccion) {
		boolean lineaVacia = false;
		try {
			File file = new File(direccion);
			if (!file.exists()) {
				file.createNewFile();
				lineaVacia = true;
			}
			FileWriter fw = new FileWriter(file, true);
			BufferedWriter bw = new BufferedWriter(fw);
			if (lineaVacia == false) {
				bw.newLine();
			}
			bw.write(jugador.getNombre()+" a asecinado a "+jugador1.getNombre());
			bw.write(jugador.toString());
			bw.close();
			fw.close();
			return true;
		} catch (Exception e) {
			System.out.println("Error al ingresar hora de llegada, favor contactar con administrador");
			return false;
		}
	}
}