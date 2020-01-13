package canal.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import canal.model.Contracts;
import canal.model.Subscriber;
import canal.service.SubscriberService;

@RestController
public class SubscriberController {
	
	@Autowired
	SubscriberService subscriberService;
	
	/**
     * Get all subscribers in the actual database.
     *
     * @return an empty list or actual list of the subscribers
     */
	@GetMapping(value = "/subscribers")
	public List <Subscriber> getAllSubscribers(){
		return subscriberService.getAllSubscribers();
	}
	
	
	@GetMapping(value = "/subscriber/{id}")
	public Optional<Subscriber> getSubscriberById(@PathVariable String id) throws Exception{
		return subscriberService.getSubscriberById(id);
	}
	
	/**
     * Create a subscriber.
     *
     * @param subscriber a valid {@link Subscriber} model
     * @return name of the actual subscribers
     */
	@PostMapping(value = "/addsubscriber")
	public String addSubscriber(@Valid @RequestBody Subscriber subscriber){
		System.out.println(subscriber.getFirstname());
		return subscriberService.addSubscriber(subscriber);
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
	@PostMapping(value="subscriber/{id}/editadress")
	public String updateSubscriberAdress(@PathVariable String id, @Valid @RequestBody String adress) throws Exception {
		return subscriberService.updateSubscriberAdress(id, adress);
	}
	
	/**
     * Get all contracts by subscribers id in the actual database, we should check
     * if the subscriber exist so we can get the contract inside
     * of it otherwise we need to throw an exception.
     *
     * @return an empty list or actual list of contracts
     */
	@GetMapping(value="/subscriber/{id}/contracts")
	public List <Contracts> getAllContractsBySubscriber(@PathVariable String id) throws Exception{
		return subscriberService.getAllContractsBySubscriber(id);
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
	@PostMapping(value = "/subsciber/{id}/addcontract")
	public String addContractBySubscriber(@PathVariable String id,@Valid @RequestBody Contracts contract) throws Exception{
		return subscriberService.addContractsBySubscriberId(id, contract);
	}
	
}
