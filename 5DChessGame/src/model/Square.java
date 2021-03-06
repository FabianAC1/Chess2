package model;

public class Square {
	private int posX;
	private int posY;
	private String name;
	private Piece piece;
	public Square(int X, int Y) {
		// TODO Auto-generated constructor stub
		this.posX = X;
		this.posY = Y;
		this.piece = null;
		this.name="(  )";
	}
	
	public Square(int X, int Y, Piece piece) {
		// TODO Auto-generated constructor stub
		this.posX = X;
		this.posY = Y;
		this.piece = piece;
		this.name = piece.getName();
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return String.format("Name:%s, X:%s, Y:%s\t", this.getPiece()!=null?this.getPiece().getName():this.name, this.getPosX(), this.getPosY());
	}
}
