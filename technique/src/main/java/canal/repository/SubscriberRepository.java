package canal.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import canal.model.Contracts;
import canal.model.Subscriber;

@Repository
public interface SubscriberRepository {

	List <Subscriber> findAllSubscribers();
	Optional<Subscriber> findSubscriberById(String id) throws Exception;
	String addSubscriber(Subscriber subscriber);
	String updateSubscriberAdress (String id, String adress) throws Exception;
	List <Contracts> findAllContractsBySubscribers(String subscriberId) throws Exception;
	String addContracts(String subscriberId, Contracts contracts) throws Exception;

}
