package model;

public class Rook extends Piece{

	
	public Rook(Player player, Board board, String name, String color, int X, int Y) {
		super(player, board, name, color, X, Y);
		// TODO Auto-generated constructor stub
//		this.addPiece(this);

	}

	@Override
	public boolean validMove(int toX, int toY) {
		
		int fromX = this.getPosX();
		int fromY= this.getPosY(); 
		int spaceX = Math.abs(fromX - toX);
		int spaceY = Math.abs(fromY - toY);
		if (((spaceX<=2 &&spaceY==0) || (spaceY<=2 &&spaceX==0)) && !isMovingOverPiece(toX,toY))
		{
			return true;
		}
		
		return false;
		
	}
	
	private boolean isMovingOverPiece(int toX, int toY) {
		int fromX = this.getPosX();
		int fromY = this.getPosY();
		if (fromX == toX) {// Vertically move
			int minY = Math.min(fromY, toY);
			int maxY = Math.max(fromY, toY);
			int x = toX;
			for (int y = minY + 1; y < maxY; y++) {
				if (board.getSquares(x, y).getPiece() != null)
					return true;
			}
		}

		if (fromY == toY) {// Horizontal move
			int minX = Math.min(fromX, toX);
			int maxX = Math.max(fromX, toX);
			int y = toY;
			for (int x = minX + 1; x < maxX; x++) {
				if (board.getSquares(x, y).getPiece() != null)
					return true;

			}
		}
		return false;
	}
}
