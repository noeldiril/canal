import org.junit.Ignore;
import org.junit.jupiter.api.BeforeAll;

import canal.model.Contracts;
import canal.model.Subscriber;
import canal.repository.SubscriberRepositoryImpl;
import canal.service.SubscriberService;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

@Ignore
public class CanalStepDef extends SpringIntegrationTest {

	String url = DEFAULT_URL ;

	private static SubscriberService subscriberService;
	public Subscriber subscriber = new Subscriber("1", "noel",new Contracts("1", "adress"));

	@BeforeAll
	static void setUp() {
		subscriberService = new SubscriberService(new SubscriberRepositoryImpl());
	}

	@Given("^Un abonné avec une adresse principale$")
	public void Un_abonné_avec_une_adresse_principale(Subscriber subscriber) throws Throwable {
		subscriberService.addSubscriber(subscriber);
		throw new PendingException();
	}
	
	@When("^Le conseiller connecté à canal modifie l'adresse de l'abonné$")
	public void Le_conseiller_connecté_à_canal_modifie_l_adresse_de_l_abonné(String id, String adress) throws Exception {
		subscriberService.updateSubscriberAdress(id, adress);
	}

	@Then("^L'adresse de l'abonné modifiée est enregistrée sur l'ensemble des contrats de l'abonné$")
	public void L_adresse_de_l_abonné_modifiée_est_enregistrée_sur_l_ensemble_des_contrats_de_l_abonné(String adress) throws Throwable {
		Assert.assertEquals(adress, subscriber.getContracts().get(0).getAdress());  
		throw new PendingException();
	}


}
