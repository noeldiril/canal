package canal.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import canal.model.Contracts;
import canal.model.Subscriber;

@Component
public class SubscriberRepositoryImpl implements SubscriberRepository {

	private ArrayList<Subscriber> subscribers = new ArrayList<>();

	@Override
	public Optional<Subscriber> findSubscriberById(String id) {
		return subscribers.stream().filter(x -> x.getId().contentEquals(id)).findFirst();
	}

	@Override
	public List<Subscriber> findAllSubscribers() {
		return subscribers;
	}

	/**
     * Create a subscriber.
     *
     * @param subscriber a valid {@link Subscriber} model
     * @return name of the actual subscribers
     */
	@Override
	public String addSubscriber(Subscriber subscriber) {
		subscribers.add(subscriber);
		return subscriber.getFirstname();
	}
	/**
     * Update a subscriber adress and all of his contracts, we should check
     * if the subscriber exist so we can update the information 
     * of it otherwise we need to throw an exception.
     *
     * @param subscribers id
     * @param the new adress 
     * @return the actual adress
     */
	@Override
	public String updateSubscriberAdress(String id, String adress) throws Exception{
		Subscriber subscriber = findSubscriberById(id).orElseThrow(() -> new Exception("Subscribers not found, try with an other id"));
		subscriber.setAdress(adress);
		subscriber.getContracts().forEach(x -> x.setAdress(adress));
		return adress;
	}

	/**
     * Get all contracts by subscribers id in the actual database, we should check
     * if the subscriber exist so we can get the contract inside
     * of it otherwise we need to throw an exception.
     *
     * @return an empty list or actual list of contracts
     */
	@Override
	public List<Contracts> findAllContractsBySubscribers(String subscriberId) throws Exception {
		Subscriber subscriber = findSubscriberById(subscriberId).orElseThrow(() -> new Exception("Subscribers not found, try with an other id"));
		return subscriber.getContracts();
	}

	/**
     * Create a contract with subscribers, we should check
     * if the subscriber exist so we can create the contract inside
     * of it otherwise we need to throw an exception..
     *
     * @param contract a valid {@link Contracts} model
     * @param subscribers id
     * @return adress of the actual contract
     */
	@Override
	public String addContracts(String subscriberId, Contracts contracts) throws Exception {
		Subscriber subscriber = findSubscriberById(subscriberId).orElseThrow(() -> new Exception("Subscribers not found, try with an other id"));
		subscriber.getContracts().add(contracts);
		return contracts.getId();
	}



}
