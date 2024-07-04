package br.com.accenture.automations.page_objects;

import org.openqa.selenium.By;

public class SelectProductPageObject {
    public static By ComboBoxRamo= By.xpath("//span[text()='Ramo']//ancestor::div[@class='slds-grid']//following-sibling::div//input");
    public static By ComboBoxProduto = By.xpath("//span[text()='Produto']//ancestor::div[@class='slds-grid']//following-sibling::div//input");
    public  static By ButtonNext = By.xpath("//button[contains(@aria-label, 'Next Step')]");
    public static By lablePaginaDadosDoTomador= By.xpath("//h1[text()='Dados do Tomador']");
    public static By OptionBoxRamo(String ramo) {
         return By.xpath("//div[contains(@data-label,'Garantia Setor "+ramo+"')]");
    }
    public static By OptionBoxProduto(String produto){
        return By.xpath("//div[contains(@data-label,'"+produto+"')]");
    }
}
