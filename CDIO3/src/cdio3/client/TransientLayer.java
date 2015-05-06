package cdio3.client;
import java.util.ArrayList;
public class TransientLayer {
	ArrayList<OperatoerDTO> oprList = new ArrayList<OperatoerDTO>();
	OperatoerDTO opr;
	
	public TransientLayer() {
		opr = new OperatoerDTO(101, "Kurt Hansen", "kuh", "1804801327", "nIo!.32A");
		oprList.add(opr);
		opr = new OperatoerDTO(209, "Poul Poulsen", "pop", "2207861005", "Mu3a.?Ub");
		oprList.add(opr);
		opr = new OperatoerDTO(10008, "Arne Pedersen", "arp", "0103680817", "A!uiM31Y");
		oprList.add(opr);
		opr = new OperatoerDTO(1892, "Peter Nielsen", "pen", "1102740811", "u?1M32!.");
		oprList.add(opr);
		opr = new OperatoerDTO(2, "Karen Vilhelmsen", "kav", "1009811304", "1!pUmZ9T");
		oprList.add(opr);
		opr = new OperatoerDTO(109, "Gitte Thomasen", "git", "2703892118", "up32!.Fy");
		oprList.add(opr);
		opr = new OperatoerDTO(32, "Jytte Traulsen", "jyt", "3107692102", "R4!mI?uP");
		oprList.add(opr);
	}
	
	public ArrayList<OperatoerDTO> getTransientDB(){
		return oprList;
	}

}
