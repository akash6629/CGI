package testscripts;

import org.testng.annotations.Test;

public class Tc_010_Groups {

    @Test(groups = {"smoke"}, priority = 1)
    public void loginTest() {
        System.out.println("Smoke: Login Test");
    }

    @Test(groups = {"smoke"}, priority = 2)
    public void dashboardTest() {
        System.out.println("Smoke: Dashboard Test");
    }

    @Test(groups = {"regression"}, priority = 1)
    public void paymentTest() {
        System.out.println("Regression: Payment Test");
    }

    @Test(groups = {"regression"}, priority = 2)
    public void transactionHistoryTest() {
        System.out.println("Regression: Transaction History Test");
    }

}
