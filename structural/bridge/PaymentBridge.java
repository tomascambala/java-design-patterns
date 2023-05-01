package structural.bridge;

public class PaymentBridge {

    public static void main(String[] args) {
        Payment payment1 = new CreditCardPayment(new PayPalPaymentProcessor());
        payment1.processPayment(34.74);

        Payment payment2 = new EtherneumPayment(new BitPayPaymentProcessor());
        payment2.processPayment(32.12);
    }

    interface Payment {
        void processPayment(double amount);
    }

    abstract static class PaymentProcessor {
        abstract void processPayment(double amount);
    }

    static class CreditCardPayment implements Payment {
        private PaymentProcessor paymentProcessor;

        CreditCardPayment(PaymentProcessor paymentProcessor) {
            this.paymentProcessor = paymentProcessor;
        }

        @Override
        public void processPayment(double amount) {
            System.out.println("Processing credit card: $" + amount);
            paymentProcessor.processPayment(amount);
        }
    }

    static class EtherneumPayment implements Payment {
        private PaymentProcessor paymentProcessor;

        EtherneumPayment(PaymentProcessor paymentProcessor) {
            this.paymentProcessor = paymentProcessor;
        }

        @Override
        public void processPayment(double amount) {
            System.out.println("Processing Etherneum:  $" + amount);
            paymentProcessor.processPayment(amount);
        }
    }

    static class PayPalPaymentProcessor extends PaymentProcessor {
        @Override
        void processPayment(double amount) {
            System.out.println("Processing payment using PayPal");
        }
    }

    static class BitPayPaymentProcessor extends PaymentProcessor {
        @Override
        void processPayment(double amount) {
            System.out.println("Processing payment using BitPay");
        }
    }
}
