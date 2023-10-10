package com.JavaProject2020.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import com.JavaProject2020.objects.Player;

public class LoadGame {

	private ArrayList<Player> players = new ArrayList<Player>();
	
	public LoadGame() {
		File file = new File("./game.txt");
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(file);
			ois = new ObjectInputStream(fis);
			for (int i = 0; i < 6; i++) {
				try {
					players.add((Player) ois.readObject());
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fis != null) {
					fis.close();
				}
				if (ois != null) {
					ois.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public ArrayList<Player> getPlayers(){
		return players;
	}
}
