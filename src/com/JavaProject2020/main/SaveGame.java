package com.JavaProject2020.main;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.JavaProject2020.objects.Player;

public class SaveGame {
	
	private ArrayList<Player> players;

	public SaveGame(ArrayList<Player> players) {
		this.players = players;
	}
	
	public void save() {
		File file = new File("./game.txt");
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream(file);
			oos = new ObjectOutputStream(fos);
			for (int i = 0; i < players.size(); i++) {
				oos.writeObject(players.get(i));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fos != null) {
					fos.close();
				}
				if (oos != null) {
					oos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}