package fr.adaming.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.paypal.api.payments.Amount;
import com.paypal.api.payments.Payer;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.PaymentExecution;
import com.paypal.api.payments.RedirectUrls;
import com.paypal.api.payments.Transaction;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.OAuthTokenCredential;
import com.paypal.base.rest.PayPalRESTException;

@RestController
@RequestMapping("paypal")
public class PaypalRest {

	@RequestMapping(value="/init", method=RequestMethod.POST, produces="application/json")
	public Payment payer(ServletRequest req) {
		Map<String, String> sdkConfig = new HashMap<String, String>();
		sdkConfig.put("mode", "sandbox");
		String clientId = "AdefAyV6hsxNei-XdAIAxSrQq2Tr2G9eHQ9YNI5jEa1MLQ_RiUV4gXOWXPdvPsv3zI8SI0mXmGywV_o1";
		String clientSecret = "EEMPWH-dM2BRVuqv-2CaJ9Qi2Qzw402xELnEIZw-PuGzB0hSvsCUYCgQcVdhvGN5-Oo4e6T347S2FwvX";
		try {
			String accessToken = new OAuthTokenCredential("AQkquBDf1zctJOWGKWUEtKXm6qVhueUEMvXO_-MCI4DQQ4-LWvkDLIN2fGsd", "EL1tVxAjhT7cJimnz5-Nsx9k2reTKSVfErNQF-CmrwJgxRtylkGTKlU4RvrX", sdkConfig).getAccessToken();
			
			APIContext apiContext = new APIContext(accessToken);
			apiContext.setConfigurationMap(sdkConfig);
			
			Amount amount = new Amount();
			amount.setCurrency("USD");
			amount.setTotal("12");
			
			Transaction transaction = new Transaction();
			transaction.setDescription("creating a payment");
			transaction.setAmount(amount);
			
			List<Transaction> transactions = new ArrayList<Transaction>();
			transactions.add(transaction);
			
			Payer payer = new Payer();
			payer.setPaymentMethod("paypal");
			
			Payment payment = new Payment();
			payment.setIntent("sale");
			payment.setPayer(payer);
			payment.setTransactions(transactions);
			RedirectUrls redirectUrls = new RedirectUrls();
			redirectUrls.setCancelUrl("https://example.com/canceled/");
			redirectUrls.setReturnUrl("https://example.com/success/");
			payment.setRedirectUrls(redirectUrls);
			
			Payment createdPayment = payment.create(apiContext);
			String paymentId = createdPayment.getId();
			System.out.println("paymentId : " + paymentId);
			
			return createdPayment;
		} catch (PayPalRESTException e) {
			e.printStackTrace();
		}
		 return null;
	}
}
