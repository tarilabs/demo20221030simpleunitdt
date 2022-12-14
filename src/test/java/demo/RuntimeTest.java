package demo;

import static org.assertj.core.api.Assertions.assertThat;

import javax.inject.Inject;

import org.drools.ruleunits.api.DataSource;
import org.drools.ruleunits.api.RuleUnit;
import org.drools.ruleunits.api.RuleUnitInstance;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class RuntimeTest {
    
    @Inject
    RuleUnit<SimpleDTUnit> ruleUnit;

    @Test
    public void testR1() {
        SimpleDTUnit unitData = new SimpleDTUnit();
        unitData.getAge().set( 19 );
        unitData.getIncidents().set( false );

        RuleUnitInstance<SimpleDTUnit> unitInstance = ruleUnit.createInstance(unitData);
        unitInstance.fire();

        assertThat( unitData.getBasePrice() ).hasValue( 800 );
        System.out.println("Base price: " + unitData.getBasePrice().get());
    }
}
