package service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ClientRepository;
import model.Client;


public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientRepository repo;

	/**
	 * Méthode permettant d'ajouter un client en BDD
	 * 
	 */
	@Override
	public void saveClient(Client c) {
		if (c.getName().length() < 5) {
			System.out.println("Le nom doit comporter 5 caractères au minimum");
		} else if (c.getName() == null) {
			System.out.println("Merci de saisir un nom");
		} else {
				this.repo.save(c);
		}
	}

	@Override
	public Client getValidatedClient(int id) {
		Client c = new Client();
		c = this.repo.getOne(id);
		return c;
	}

	@Override
	public List<Client> getAllClient() {
		return this.repo.findAll();
	}

	@Override
	public void deleteClient(int id) {
		this.repo.deleteById(id);
	}

	@Override
	public Client traduClient(int id) {
		Optional<Client> cl = this.repo.findById(id);
		Client result = new Client();
		if(cl.isPresent()) {
			result = cl.get();
		}
		return result;
	}
}
