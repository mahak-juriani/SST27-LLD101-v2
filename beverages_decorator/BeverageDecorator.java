public class BeverageDecorator extends Beverage {
    private Beverage beverage;

    public BeverageDecorator(Beverage beverage){
        this.beverage = beverage;
    }

    
}
