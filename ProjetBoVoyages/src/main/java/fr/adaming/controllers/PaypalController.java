package fr.adaming.controllers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.paypal.api.payments.Amount;
import com.paypal.api.payments.Details;
import com.paypal.api.payments.Item;
import com.paypal.api.payments.ItemList;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payer;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.PaymentExecution;
import com.paypal.api.payments.RedirectUrls;
import com.paypal.api.payments.Transaction;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;

@RestController
//@Controller
//@RequestMapping("paypal")
public class PaypalController {

	@RequestMapping(value="/paypal", method=RequestMethod.POST, produces="application/json")
	public Payment payer(ServletRequest req) {
		String clientId = "AdefAyV6hsxNei-XdAIAxSrQq2Tr2G9eHQ9YNI5jEa1MLQ_RiUV4gXOWXPdvPsv3zI8SI0mXmGywV_o1";
		String clientSecret = "EEMPWH-dM2BRVuqv-2CaJ9Qi2Qzw402xELnEIZw-PuGzB0hSvsCUYCgQcVdhvGN5-Oo4e6T347S2FwvX";
		APIContext apiContext = new APIContext(clientId, clientSecret, "sandbox");
		// Set payer details
		Payer payer = new Payer();
		payer.setPaymentMethod("paypal");

		// Set redirect URLs
		RedirectUrls redirectUrls = new RedirectUrls();
		redirectUrls.setCancelUrl("http://localhost:3000/cancel");
		redirectUrls.setReturnUrl("http://localhost:3000/process");

		// Set payment details
		Details details = new Details();
		details.setShipping("1");
		details.setSubtotal("5");
		details.setTax("1");

		// Payment amount
		Amount amount = new Amount();
		amount.setCurrency("USD");
		// Total must be equal to sum of shipping, tax and subtotal.
		amount.setTotal("7");
		amount.setDetails(details);

		// Transaction information
		Transaction transaction = new Transaction();
		transaction.setAmount(amount);
		transaction.setDescription("This is the payment transaction description.");

		// Add transaction to a list
		List<Transaction> transactions = new ArrayList<Transaction>();
		transactions.add(transaction);

		// Add payment details
		Payment payment = new Payment();
		payment.setIntent("sale");
		payment.setPayer(payer);
		payment.setRedirectUrls(redirectUrls);
		payment.setTransactions(transactions);
		try {
			  Payment createdPayment = payment.create(apiContext);
			  Iterator links = createdPayment.getLinks().iterator();
			  while (links.hasNext()) {
			    Links link = (Links) links.next();
			    if (link.getRel().equalsIgnoreCase("approval_url")) {
			      // REDIRECT USER TO link.getHref()
			    }
			  }
			} catch (PayPalRESTException e) {
			    System.err.println(e.getDetails());
			}
		payment.setId(req.getParameter("paymentId"));

		PaymentExecution paymentExecution = new PaymentExecution();
		paymentExecution.setPayerId(req.getParameter("PayerID"));
		try {
		  Payment createdPayment = payment.execute(apiContext, paymentExecution);
//		  System.out.println(createdPayment);
//		  return createdPayment;
		  return payment;
		} catch (PayPalRESTException e) {
		  System.err.println(e.getDetails());
		}
		return null;
	}
	
//	@RequestMapping(value="/paypal", method=RequestMethod.POST, produces="application/json")
	public Payment payer_old(ServletRequest req) {
		Payment createdPayment = null;
		PaymentExecution paymentExecution = new PaymentExecution();
		String clientId = "AdefAyV6hsxNei-XdAIAxSrQq2Tr2G9eHQ9YNI5jEa1MLQ_RiUV4gXOWXPdvPsv3zI8SI0mXmGywV_o1";
		String clientSecret = "EEMPWH-dM2BRVuqv-2CaJ9Qi2Qzw402xELnEIZw-PuGzB0hSvsCUYCgQcVdhvGN5-Oo4e6T347S2FwvX";
		APIContext apiContext = new APIContext(clientId, clientSecret, "sandbox");
		if (req.getParameter("PayerID") != null) {
			Payment payment = new Payment();
//			if (req.getParameter("guid") != null) {
//				payment.setId(map.get(req.getParameter("guid")));
//			}
			paymentExecution.setPayerId(req.getParameter("PayerID"));
			try {
				createdPayment = payment.execute(apiContext, paymentExecution);
//				ResultPrinter.addResult(req, resp, "Executed The Payment", Payment.getLastRequest(), Payment.getLastResponse(), null);
			} catch (PayPalRESTException e) {
//				ResultPrinter.addResult(req, resp, "Executed The Payment", Payment.getLastRequest(), null, e.getMessage());
			}
		} else {
			Details details = new Details();
			details.setShipping("1");
			details.setSubtotal("5");
			details.setTax("1");
			Amount amount = new Amount();
			amount.setCurrency("USD");
			amount.setTotal("7");
			amount.setDetails(details);
			Transaction transaction = new Transaction();
			transaction.setAmount(amount);
			transaction.setDescription("This is the payment transaction description.");

			// ### Items
			Item item = new Item();
			item.setName("Ground Coffee 40 oz").setQuantity("1").setCurrency("USD").setPrice("5");
			ItemList itemList = new ItemList();
			List<Item> items = new ArrayList<Item>();
			items.add(item);
			itemList.setItems(items);
			transaction.setItemList(itemList);

			List<Transaction> transactions = new ArrayList<Transaction>();
			transactions.add(transaction);
			Payer payer = new Payer();
			payer.setPaymentMethod("paypal");

			Payment payment = new Payment();
			payment.setIntent("sale");
			payment.setPayer(payer);
			payment.setTransactions(transactions);

//			RedirectUrls redirectUrls = new RedirectUrls();
//			String guid = UUID.randomUUID().toString().replaceAll("-", "");
//			redirectUrls.setCancelUrl(req.getScheme() + "://"
//					+ req.getServerName() + ":" + req.getServerPort()
//					+ req.getContextPath() + "/paymentwithpaypal?guid=" + guid);
//			redirectUrls.setReturnUrl(req.getScheme() + "://"
//					+ req.getServerName() + ":" + req.getServerPort()
//					+ req.getContextPath() + "/paymentwithpaypal?guid=" + guid);
//			payment.setRedirectUrls(redirectUrls);
			RedirectUrls redirectUrls = new RedirectUrls();
			redirectUrls.setCancelUrl("https://fr.wikipedia.org/wiki/Annulation");
			redirectUrls.setReturnUrl("https://fr.wikipedia.org/wiki/R%C3%A9ussite");
			payment.setRedirectUrls(redirectUrls);

			try {
				createdPayment = payment.create(apiContext);
//				LOGGER.info("Created payment with id = "
//						+ createdPayment.getId() + " and status = "
//						+ createdPayment.getState());
				Iterator<Links> links = createdPayment.getLinks().iterator();
				while (links.hasNext()) {
					Links link = links.next();
					if (link.getRel().equalsIgnoreCase("approval_url")) {
						req.setAttribute("redirectURL", link.getHref());
					}
				}

				try {
					payment.execute(apiContext, paymentExecution);
				} catch (PayPalRESTException e1) {
					e1.printStackTrace();
				}
//				ResultPrinter.addResult(req, resp, "Payment with PayPal", Payment.getLastRequest(), Payment.getLastResponse(), null);
//				map.put(guid, createdPayment.getId());
//				System.out.println("Payment.getLastRequest() : " + Payment.getLastRequest());
//				System.out.println("Payment.getLastResponse() : " + Payment.getLastResponse());
				System.out.println("Paiement effectué");
			} catch (PayPalRESTException e) {
				e.printStackTrace();
//				ResultPrinter.addResult(req, resp, "Payment with PayPal", Payment.getLastRequest(), null, e.getMessage());
			}
		}
		return createdPayment;
		// String clientId = "AdefAyV6hsxNei-XdAIAxSrQq2Tr2G9eHQ9YNI5jEa1MLQ_RiUV4gXOWXPdvPsv3zI8SI0mXmGywV_o1";
		// String clientSecret = "EEMPWH-dM2BRVuqv-2CaJ9Qi2Qzw402xELnEIZw-PuGzB0hSvsCUYCgQcVdhvGN5-Oo4e6T347S2FwvX";
		//
		// Amount amount = new Amount();
		// amount.setCurrency("EUR");
		// amount.setTotal("1.00");
		//
		// Transaction transaction = new Transaction();
		// transaction.setAmount(amount);
		// List<Transaction> transactions = new ArrayList<Transaction>();
		// transactions.add(transaction);
		//
		// Payer payer = new Payer();
		// payer.setPaymentMethod("paypal");
		//
		// Payment payment = new Payment();
		// payment.setIntent("sale");
		// payment.setPayer(payer);
		// payment.setTransactions(transactions);
		//
		// RedirectUrls redirectUrls = new RedirectUrls();
		// redirectUrls.setCancelUrl("https://fr.wikipedia.org/wiki/Annulation");
		// redirectUrls.setReturnUrl("https://fr.wikipedia.org/wiki/R%C3%A9ussite");
		// payment.setRedirectUrls(redirectUrls);
		//
		// try {
		// APIContext apiContext = new APIContext(clientId, clientSecret,
		// "sandbox");
		// Payment createdPayment = payment.create(apiContext);
		// System.out.println("Payment.getLastRequest() : " +
		// Payment.getLastRequest());
		// System.out.println("Payment.getLastResponse() : " +
		// Payment.getLastResponse());
		// return createdPayment;
		// } catch (PayPalRESTException e) {
		// System.out.println("Payment.getLastRequest() : " +
		// Payment.getLastRequest());
		// e.printStackTrace();
		// }
		// return null;
	}

}
