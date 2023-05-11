package behavioral.templateMethod;

abstract class OrderProcessTemplate
{
	public boolean isSale;

	public abstract void startOrder();

	public abstract void doPayment();

	public final void checkCoupon()
	{
		try
		{
			System.out.println("Coupon is valid");
		}
		catch (Exception e)
		{
			System.out.println("Coupon is invalid");
		}
	}

	public abstract void doDelivery();

	public final void processOrder(boolean isSale)
	{
		startOrder();
		doPayment();
		if (isSale) {
			checkCoupon();
		}
		doDelivery();
	}
}


class NetOrder extends OrderProcessTemplate
{
	@Override
	public void startOrder()
	{
		System.out.println("Order is selected, customer has sale coupon");
	}

	@Override
	public void doPayment()
	{
		System.out.println("Cash or Credit card payment is provided");
	}

	@Override
	public void doDelivery()
	{
		System.out.println("Deliver the item through post to delivery address");
	}

}

class StoreOrder extends OrderProcessTemplate
{

	@Override
	public void startOrder()
	{
		System.out.println("Customer chooses his favorite item");
	}

	@Override
	public void doPayment()
	{
		System.out.println("Pays at counter through cash or credit card");
	}

	@Override
	public void doDelivery()
	{
		System.out.println("Item is delivered at exact address");
	}

}

class TemplateMethodOrder
{
	public static void main(String[] args)
	{
		OrderProcessTemplate netOrder = new NetOrder();
		netOrder.processOrder(true);
		System.out.println();
		OrderProcessTemplate storeOrder = new StoreOrder();
		storeOrder.processOrder(true);
	}
}
