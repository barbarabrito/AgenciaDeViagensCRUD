import br.com.crudagencia.dao.ClientesDAO;
import br.com.crudagencia.dao.ComprasDAO;
import br.com.crudagencia.dao.ViagensDAO;
import br.com.crudagencia.model.Clientes;
import br.com.crudagencia.model.Compras;
import br.com.crudagencia.model.Viagens;

public class Teste {

	public static void main(String[] args) {
		
		
		ClientesDAO clientesDAO = new ClientesDAO();
		
		Clientes clientes1 = new Clientes();
		
		clientes1.setNomeCliente("maria");
		clientes1.setDataNascimento("01-11-94");
		clientes1.setCpf("113-451-211-99");
		clientes1.setEmail("maria@gmail.com");
		
		
		clientesDAO.save(clientes1);
		
		/*
		Clientes clientes3 = new Clientes();
		
		clientes3.setClienteId(1);
		clientes3.setNomeCliente("francisco");
		clientes3.setDataNascimento("20-02-83");
		clientes3.setCpf("123-654-204-90");
		clientes3.setEmail("francisco@gmail.com");
		
		clientesDAO.update(clientes3);
		
		clientesDAO.removeById(1);
		
		ViagensDAO viagensDAO = new ViagensDAO();
		
		Viagens viagens1 = new Viagens();
		viagens1.setDestino("salvador");
		viagens1.setDataViagem("10-02-2022");
		
		viagensDAO.save(viagens1);
		
		Viagens viagens2 = new Viagens();
		viagens2.setViagemId(1);
		viagens2.setDestino("joao pessoa");
		viagens2.setDataViagem("10-02-2022");
		
		viagensDAO.update(viagens2);
		
		
		viagensDAO.removeById(1);
		
		//for(Viagens v : viagensDAO.getViagens()) {
			//System.out.println("VIAGEM: "+ v.getDestino());
		//}

		*/
		for(Clientes c : clientesDAO.getClientes()) {
			System.out.println("NOME: "+ c.getNomeCliente());
		}
		

	}

}
