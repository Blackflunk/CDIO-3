package cdio3.interfaces;

import java.util.List;

import cdio3.data.OperatoerDTO;

public interface IOperatoerDAO {
	OperatoerDTO getOperatoer(int oprId);
	List<OperatoerDTO> getOperatoerList();
	void createOperatoer(OperatoerDTO opr);
	void updateOperatoer(OperatoerDTO opr);
	void deleteOperatoer(OperatoerDTO opr);
}
