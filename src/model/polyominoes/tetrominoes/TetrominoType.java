package model.polyominoes.tetrominoes;



enum TetrominoType{
	STRAIGHT, SQUARE, T,L,SKEW;

	static TetrominoType valueOf(int x) {
		
		switch(x) {
		case 0: return STRAIGHT;
		case 1: return SQUARE;
		case 2: return T;
		case 3: return L;
		case 4: return SKEW;
		default: return STRAIGHT;
		}			
	}
}