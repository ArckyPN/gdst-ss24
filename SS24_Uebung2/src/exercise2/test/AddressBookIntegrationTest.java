package exercise2.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
    AddressBookControllerTest.class,
    ControllerAddressBookIntegrationTest.class
})
public class AddressBookIntegrationTest {
    
}
