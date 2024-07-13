package model.polyominoes.pentominoes;


public enum PentominoType {
	
	F,I,L,N,P,T,U,V,W,X,Y,Z;

	static PentominoType valueOf(int x) {
		
		switch(x) {
		case 0: return F;
		case 1: return I;
		case 2: return L;
		case 3: return N;
		case 4: return P;
		case 5: return T;
		case 6: return U;
		case 7: return V;
		case 8: return W;
		case 9: return X;
		case 10: return Y;
		case 11: return Z;
		default: return F;
		
		}			
	}

}
