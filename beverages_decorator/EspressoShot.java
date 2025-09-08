package beverages_decorator;

public class EspressoShot extends Beverage {
    Beverage beverage;
    public EspressoShot(Beverage beverage) {
        this.beverage = beverage;
    }
    @Override
    public int cost() {
        return 5 + this.beverage.cost();
    }
    
}