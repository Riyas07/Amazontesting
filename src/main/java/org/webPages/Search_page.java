package org.webPages;

import org.WebElements.Search_webelements;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;


public class Search_page {
  Search_webelements searchWebelements=new Search_webelements();

    @Test
  public void search_ptoducts() throws IOException {
      searchWebelements.enter_products().clilck_search_btn();
  }
}
