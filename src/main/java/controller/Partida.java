package controller;
import model.Enemigo;
import model.Jugador;
import java.util.ArrayList;
import data.GestionArchivos;
public class Partida {
	private int idPartida;
	private ArrayList<Jugador> jugadores;
	private ArrayList<Enemigo> enemigos;
	GestionArchivos gestionArchivos = new GestionArchivos();
	public Partida(int idPartida){
		this.idPartida = idPartida;
		this.jugadores = new ArrayList<>();
		this.enemigos = new ArrayList<>();
	}

	public ArrayList<Jugador> getJugadores() {
		return this.jugadores;
	}

	public ArrayList<Enemigo> getEnemigos() {
		return this.enemigos;
	}

	public void agregarJugador(Jugador jugador) {
		if(buscarJugador(jugador)!= null) {
			jugadores.add(jugador);
		}
	}

	public void agregarMonstruos(Enemigo enemigo) {
		for(Enemigo enemigo1 : this.enemigos){
			if (!enemigo1.getTipo().equals("JEFE FINAL")){
				enemigos.add(enemigo);
			}
		}
	}
	public void agregarJefeFinal(Enemigo enemigo) {
		for(Enemigo enemigo1 : this.enemigos){
			if (enemigo1.getTipo().equals("JEFE FINAL")){
				enemigos.add(enemigo);
			}
		}
	}
	public Jugador buscarJugador(Jugador jugador){
		for (Jugador jugador1 : this.jugadores){
			if (jugador1.equals(jugador)){
				return jugador;
			}
		}
		return null;
	}

	public void enfrentarEnemigo(Jugador jugador, Enemigo enemigo) {
		if(resultadoPeleaEnemigo(jugador,enemigo)){
			jugador.setSalud(jugador.getSalud()+10);
			jugador.setFuerza(jugador.getFuerza()+5);
			jugador.setVelocidad(jugador.getVelocidad()+2);
			enemigos.remove(enemigo);
			gestionArchivos.jugadorVsEnemigo(jugador,enemigo,"resultado.txt");
		}
		else{
			gestionArchivos.jugadorVsEnemigo1(enemigo, jugador,"resultado.txt");
			jugadores.remove(jugador);
		}

	}

	public void atacarJugador(Jugador jugador, Jugador jugador1) {

		if(resultadoPeleaJugador(jugador,jugador1)){
			gestionArchivos.jugadorVsJugador(jugador,jugador1,"resultado.txt");
			jugadores.remove(jugador1);
		}
		else{
			gestionArchivos.jugadorVsJugador(jugador1,jugador,"resultado.txt");
			jugadores.remove(jugador);
		}

	}

	public boolean resultadoPeleaEnemigo(Jugador jugador, Enemigo enemigo) {
		int vidaEnemigo = enemigo.getVida();
		int vidaJugador = jugador.getSalud();

		while(vidaJugador>0 && vidaEnemigo>0){
			vidaJugador = vidaJugador - enemigo.getFuerza();
			vidaEnemigo = vidaEnemigo - jugador.getFuerza();
			if(vidaJugador <0){
				vidaJugador = 0;
			}
			if (vidaEnemigo<0){
				vidaEnemigo =0;
			}
			gestionArchivos.jugadorVsEnemigoEnfrentamiento(jugador,enemigo,"resultado.txt",vidaJugador,vidaEnemigo);
		}
		if(vidaJugador>vidaEnemigo){
			return true;
		}else {
			return false;
		}
	}
	public boolean resultadoPeleaJugador(Jugador jugador, Jugador jugador1) {
		int vidaJugador1 = jugador1.getSalud();
		int vidaJugador = jugador.getSalud();
		while(vidaJugador>0 && vidaJugador1>0){
			vidaJugador1 = vidaJugador1 - jugador.getFuerza();
			vidaJugador = vidaJugador - jugador1.getFuerza();
			if(vidaJugador <0){
				vidaJugador = 0;
			}
			if (vidaJugador1<0){
				vidaJugador1=0;
			}
			gestionArchivos.jugadorVsJugadorEnfrentamiento(jugador,jugador1,"resultado.txt", vidaJugador, vidaJugador1);
		}
		if(vidaJugador>vidaJugador1){
			return true;
		}else {
			return false;
		}
	}
	public void mostrarJugador(Jugador jugador) {
		System.out.println(jugador);
	}
	public void mostrarEnemigo(Enemigo enemigo){
		System.out.println(enemigo);
	}
}