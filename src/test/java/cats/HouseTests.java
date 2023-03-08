package cats;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HouseTests {

    private House house;
    private Cat cat;

    @Before
    public void setUp() {
        house = new House("House1", 1);
        cat = new Cat("Naja");
        house.addCat(cat);
    }

    @Test(expected = NullPointerException.class)
    public void setNameNull() {
        House nullNameHouse = new House(null, 5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setNullCapacity() {
        House nullCapHouse = new House("House2", -1);
    }

    @Test
    public void checkGetCount() {
        Assert.assertEquals(1, house.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void addCatWhenNoEnoughtCapacity() {
        Cat newCat = new Cat("NewCat");
        house.addCat(newCat);
    }

    @Test
    public void checkCapacity() {
        Assert.assertEquals(1, house.getCapacity());
    }

    @Test
    public void checkGetName() {
        Assert.assertEquals("House1", house.getName());
    }

    @Test
    public void checkStatistics() {
        String expectedOutput = "The cat Naja is in the house House1!";
        Assert.assertEquals(expectedOutput, house.statistics());
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeNullCat() {
        house.removeCat("nullCat");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nullCatForSell() {
        house.catForSale("NullCat");
    }

    @Test
    public void removeCat() {
        house.removeCat("Naja");
        Assert.assertEquals(0,house.getCount());
    }

    @Test
    public void sellCat() {
        Assert.assertEquals(cat, house.catForSale("Naja"));
    }

    @Test
    public void hungry() {
        Assert.assertEquals(true, cat.isHungry());
    }
}
