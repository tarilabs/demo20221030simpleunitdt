package demo;

import java.util.concurrent.atomic.AtomicReference;

// TODO check w/ docs
import org.drools.ruleunits.api.DataSource;
import org.drools.ruleunits.api.DataStore;
import org.drools.ruleunits.api.RuleUnitData;
import org.drools.ruleunits.api.SingletonStore;

public class SimpleDTUnit implements RuleUnitData {
    
    private SingletonStore<Number> age;
    private SingletonStore<Boolean> incidents;
    
    // TODO can't use SingletonStore as it cannot be read, can't use global as can't be set from RHS?
    private AtomicReference<Number> basePrice;

    public SimpleDTUnit() {
        this(DataSource.createSingleton(), DataSource.createSingleton(), null);
    }

    public SimpleDTUnit(SingletonStore<Number> age, SingletonStore<Boolean> incidents, Number basePrice) {
        this.age = age;
        this.incidents = incidents;
        this.basePrice = new AtomicReference<>(basePrice);
    }

    public SingletonStore<Number> getAge() {
        return age;
    }

    public SingletonStore<Boolean> getIncidents() {
        return incidents;
    }

    public AtomicReference<Number> getBasePrice() {
        return basePrice;
    }

    public void setAge(SingletonStore<Number> age) {
        this.age = age;
    }

    public void setIncidents(SingletonStore<Boolean> incidents) {
        this.incidents = incidents;
    }

    public void setBasePrice(AtomicReference<Number> basePrice) {
        this.basePrice = basePrice;
    }
}
