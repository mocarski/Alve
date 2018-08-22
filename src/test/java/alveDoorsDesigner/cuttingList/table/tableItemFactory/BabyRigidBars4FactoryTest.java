package alveDoorsDesigner.cuttingList.table.tableItemFactory;

import alveDoorsDesigner.model.Wardrobe;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BabyRigidBars4FactoryTest {

    @Test
    public void amountOfBabyRigidBars4ShouldBe3TimesGraterThenNumberOfModulesWithGlass() {

        Wardrobe wardrobe = new Wardrobe();
        wardrobe.setCavityWidth(2000);
        wardrobe.setCavityHeight(2000);
        wardrobe.setNumberOfDoors(2);

        BabyRigidBars4Factory factory = new BabyRigidBars4Factory();
        factory.create(wardrobe);

        assertEquals(6, factory.create(wardrobe).getQuantity());

    }
}