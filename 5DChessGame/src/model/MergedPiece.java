package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class MergedPiece extends Piece {
	
	private HashMap<String, Piece> pieceMembers = new HashMap<String, Piece>();

	public MergedPiece(Player player, Board board, String name, String color, int x, int y) {
		super(player, board, name, color, x, y);
	}
	
	@Override
	public void move(int x, int y) {
		if (validMove(x, y)) {
			for (Piece piece : pieceMembers.values()) {
				posX = x;
				posY = y;
			}
		}
	}

	@Override
	public boolean validMove(int toX, int toY) {
		for (Piece piece : getPieces()) {
			if (piece.validMove(toX, toY))
				return true;
		}
		return false;
	}
	
	public boolean isValidToCombine(String name,int x,int y, String color) {
		return !(this.name.contains(name)|| name.contains(this.name));
	}

	//change name
	// mergedpiece name is the combined name of all child pieces
	public void setName() {
		String combinedName = "";
		for (Piece p : getPieces()) {
			combinedName += p.getName();
		}
		name = combinedName;
	}

	@Override
	public String getName() {
		return name;
	}

	public Collection<Piece> getPieces() {					// ???
		Collection<Piece> p = new ArrayList<Piece>();
		TreeMap<String, Piece> sorted = new TreeMap<>(pieceMembers);
		Set<Entry<String, Piece>> mappings = sorted.entrySet();

		for (Entry<String, Piece> mapping : mappings) {
			p.add(mapping.getValue());
		}
		return p;
	}

	public void addPiece(Piece piece) {
		if (!(piece instanceof MergedPiece)) {
			this.pieceMembers.put(piece.getName(), piece);
		} else {
			MergedPiece mPiece = (MergedPiece) piece;
			for (Piece p: mPiece.getPieces()) {
				this.pieceMembers.put(p.getName(), p);

			}
		}	
	}

	public void removePieceMember(Piece piece) {
		pieceMembers.remove(piece.getName());
	}
}
