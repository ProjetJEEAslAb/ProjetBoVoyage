package fr.adaming.webservice;

import javax.ws.rs.core.MediaType;

import com.paypal.api.payments.Payment;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

public class PaypalWS {
	public Payment getPaysById(Integer id) {
		ClientConfig config = new DefaultClientConfig();
		config.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
		Client client = Client.create(config);
		WebResource service = client.resource("http://localhost:8080/ProjetBoVoyages/paypal/init");
		return service.accept(MediaType.APPLICATION_JSON).get(Payment.class);
	}
}
