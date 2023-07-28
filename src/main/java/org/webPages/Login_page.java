package org.webPages;

import org.TestBase.Testbase;
import org.testng.annotations.Test;


public class Login_page extends Testbase {

    @Test
    public void login()
    {
        login_webelements.click_sign_in().enter_email().click_continue().enter_password().click_sign_tbn();
    }
}
