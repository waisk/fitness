/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ak.fitness.services;

import com.ak.fitness.dao.SubscriptionDao;
import com.ak.fitness.entities.Subscription;
import com.ak.fitness.entities.User;
import com.paypal.api.payments.Address;
import com.paypal.api.payments.Amount;
import com.paypal.api.payments.CreditCard;
import com.paypal.api.payments.Details;
import com.paypal.api.payments.FundingInstrument;
import com.paypal.api.payments.Payer;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.Transaction;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author wais
 */
@Service("paymentService")
public class PaymentService {

    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(PaymentService.class.getName());

    @Autowired
    SubscriptionDao subscriptionDao;

    public Payment createPayment(HttpServletRequest req,
            HttpServletResponse resp) {
        // ###Address
        // Base Address object used as shipping or billing
        // address in a payment. [Optional]
        Address billingAddress = new Address();
        billingAddress.setCity("Johnstown");
        billingAddress.setCountryCode("US");
        billingAddress.setLine1("52 N Main ST");
        billingAddress.setPostalCode("43210");
        billingAddress.setState("OH");

        // ###CreditCard
        // A resource representing a credit card that can be
        // used to fund a payment.
        CreditCard creditCard = new CreditCard();
        creditCard.setBillingAddress(billingAddress);
        creditCard.setCvv2("012");
        creditCard.setExpireMonth(11);
        creditCard.setExpireYear(2018);
        creditCard.setFirstName("Joe");
        creditCard.setLastName("Shopper");
        creditCard.setNumber("4669424246660779");
        creditCard.setType("visa");

        // ###Details
        // Let's you specify details of a payment amount.
        Details details = new Details();
        details.setShipping("1");
        details.setSubtotal("5");
        details.setTax("1");

        // ###Amount
        // Let's you specify a payment amount.
        Amount amount = new Amount();
        amount.setCurrency("USD");
        // Total must be equal to sum of shipping, tax and subtotal.
        amount.setTotal("7");
        amount.setDetails(details);

        // ###Transaction
        // A transaction defines the contract of a
        // payment - what is the payment for and who
        // is fulfilling it. Transaction is created with
        // a `Payee` and `Amount` types
        Transaction transaction = new Transaction();
        transaction.setAmount(amount);
        transaction
                .setDescription("This is the payment transaction description.");

        // The Payment creation API requires a list of
        // Transaction; add the created `Transaction`
        // to a List
        List<Transaction> transactions = new ArrayList<Transaction>();
        transactions.add(transaction);

        // ###FundingInstrument
        // A resource representing a Payeer's funding instrument.
        // Use a Payer ID (A unique identifier of the payer generated
        // and provided by the facilitator. This is required when
        // creating or using a tokenized funding instrument)
        // and the `CreditCardDetails`
        FundingInstrument fundingInstrument = new FundingInstrument();
        fundingInstrument.setCreditCard(creditCard);

        // The Payment creation API requires a list of
        // FundingInstrument; add the created `FundingInstrument`
        // to a List
        List<FundingInstrument> fundingInstrumentList = new ArrayList<FundingInstrument>();
        fundingInstrumentList.add(fundingInstrument);

        // ###Payer
        // A resource representing a Payer that funds a payment
        // Use the List of `FundingInstrument` and the Payment Method
        // as 'credit_card'
        Payer payer = new Payer();
        payer.setFundingInstruments(fundingInstrumentList);
        payer.setPaymentMethod("credit_card");

        // ###Payment
        // A Payment Resource; create one using
        // the above types and intent as 'sale'
        Payment payment = new Payment();
        payment.setIntent("sale");
        payment.setPayer(payer);
        payment.setTransactions(transactions);
        Payment createdPayment = null;
        try {
            // ### Api Context
            // Pass in a `ApiContext` object to authenticate
            // the call and to send a unique request id
            // (that ensures idempotency). The SDK generates
            // a request id if you do not pass one explicitly.

            //example
            // Replace these values with your clientId and secret. You can use these to get started right now.
            String clientId = "Aa7Bw1nkj6--HLSBIUo0-H-sR-F_12P0e2qzVwMyYt2Zx0R1qJlbu14_tsSVch085hpjEr4bEOSF24IF";
            String clientSecret = "EDaQT5qOMkb8GiRocpOgPPmDkdFVH4DCopeaBhApztzVmQhoBI7FDhK4mgBKBOtFf5apNVM3t96A5A4v";

            //change sandbox to live before PROD
            APIContext apiContext = new APIContext(clientId, clientSecret, "sandbox");

            // Create a payment by posting to the APIService
            // using a valid AccessToken
            // The return object contains the status;
            createdPayment = payment.create(apiContext);

            LOGGER.info("Created payment with id = " + createdPayment.getId()
                    + " and status = " + createdPayment.getState());
//			ResultPrinter.addResult(req, resp, "Payment with Credit Card",
//					Payment.getLastRequest(), Payment.getLastResponse(), null);
        } catch (PayPalRESTException e) {
            LOGGER.log(Level.SEVERE, null, e.getMessage());

//			ResultPrinter.addResult(req, resp, "Payment with Credit Card",
//					Payment.getLastRequest(), null, e.getMessage());
        }
        return createdPayment;

    }

    public void createSubscription(User u, Integer trainingPackage) {

        try {
            //create subscription for user => dont create subscription now, create subscription after paypal payment account made

            Subscription subscription = new Subscription();
            subscription.setIduser(u.getIduser());
            subscription.setPackage1(trainingPackage);
            subscription.setValid(true);
            subscription.setCreationdate(new Date());
            subscription.setUpdatedate(new Date());
            //set date for subscription too
            subscriptionDao.createSubscription(subscription);

        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, null, ex.getMessage());
        }
    }

}
