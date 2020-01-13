package canal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import canal.model.Contracts;
import canal.model.Subscriber;
import canal.repository.SubscriberRepository;


@Service
public class SubscriberService {

	private final SubscriberRepository subscriberRepository;

	/**
	 * Create a new {@link subscriberRepository} instance with the
	 * repository that will be injected to it.
	 *
	 * @param subscriberRepository an instance of {@link subscriberRepository}
	 */
	@Autowired
	public SubscriberService(SubscriberRepository subscriberRepository) {
		this.subscriberRepository = subscriberRepository;
	}

	
	public List<Subscriber> getAllSubscribers(){
		return subscriberRepository.findAllSubscribers();
	}
	
	public Optional<Subscriber> getSubscriberById(String id) throws Exception{
		return subscriberRepository.findSubscriberById(id);
	}
	
	public String addSubscriber(Subscriber subscriber) {
		return subscriberRepository.addSubscriber(subscriber);
	}
	
	public List<Contracts> getAllContractsBySubscriber(String subscriberId) throws Exception{
		return subscriberRepository.findAllContractsBySubscribers(subscriberId);
	}

	public String addContractsBySubscriberId(String subscriberId,Contracts contract) throws Exception {
		return subscriberRepository.addContracts(subscriberId, contract);
	}
	
	public 	String updateSubscriberAdress (String id, String adress) throws Exception{
		return subscriberRepository.updateSubscriberAdress(id, adress);
	}

}
