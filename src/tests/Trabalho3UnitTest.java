package tests;


import org.testng.Assert;
import org.testng.annotations.Test;

import Action.Trabalho3;

public class Trabalho3UnitTest
{
  
  @Test
  public void test_VerificarComecaVogal_EntradaComecaComVogal_DeveRetornarTrue()
  {
    Trabalho3 trabalho3 = new Trabalho3();
    String comecaComVogal = "aranha";
    Assert.assertTrue(trabalho3.verificarComecaComVogal(comecaComVogal));
  }
  
  @Test
  public void test_VerificarComecaVogal_EntradaNaoComecaComVogal_DeveRetornarFalse()
  {
    Trabalho3 trabalho3 = new Trabalho3();
    String naoComecaComVogal = "Batata";
    Assert.assertFalse(trabalho3.verificarComecaComVogal(naoComecaComVogal));
    
  }
  
  @Test
  public void test_VerificarTresConsoantesJuntas_EntradaComTresConsoantesJuntas_DeveRetornarTrue()
  {
    Trabalho3 trabalho3 = new Trabalho3();
    String tresConsoantesJuntas = "tchau";
    Assert.assertTrue(trabalho3.verificarTresConsoantesJuntas(tresConsoantesJuntas));
  }
  
  @Test
  public void test_VerificarTresConsoantesJuntas_EntradaSemTresConsoantesJuntas_DeveRetornarFalse()
  {
    Trabalho3 trabalho3 = new Trabalho3();
    String tresConsoantesJuntas = "tcauhs";
    Assert.assertFalse(trabalho3.verificarTresConsoantesJuntas(tresConsoantesJuntas));
  }
  
  @Test
  public void test_VerificarTresConsoantesJuntas_EntradaComTresConsoantesJuntasDepoisDeDuas_DeveRetornarTrue()
  {
    Trabalho3 trabalho3 = new Trabalho3();
    String tresConsoantesJuntas = "tcauhsb";
    Assert.assertTrue(trabalho3.verificarTresConsoantesJuntas(tresConsoantesJuntas));
  }
  
  @Test
  public void test_VerificarOcorrenciaLetraPAntesDeG_EntradaComPAntesG_DeveRetornarTrue()
  {
    Trabalho3 trabalho3 = new Trabalho3();
    String pAntesG = "paguei";
    Assert.assertTrue(trabalho3.verificarOcorrenciaLetraPAntesDeG(pAntesG));
  }
  
  @Test
  public void test_VerificarOcorrenciaLetraPAntesDeG_EntradaComGAntesP_DeveRetornarFalse()
  {
    Trabalho3 trabalho3 = new Trabalho3();
    String pAntesG = "garpo";
    Assert.assertFalse(trabalho3.verificarOcorrenciaLetraPAntesDeG(pAntesG));
  }
  
  @Test
  public void test_VerificarOcorrenciaLetraPAntesDeG_EntradaSemLetraP_DeveRetornarTrue()
  {
    Trabalho3 trabalho3 = new Trabalho3();
    String pAntesG = "garfo";
    Assert.assertTrue(trabalho3.verificarOcorrenciaLetraPAntesDeG(pAntesG));
  }
  
  @Test
  public void test_VerificarOcorrenciaLetraPAntesDeG_EntradaSemLetraG_DeveRetornarTrue()
  {
    Trabalho3 trabalho3 = new Trabalho3();
    String pAntesG = "apache";
    Assert.assertTrue(trabalho3.verificarOcorrenciaLetraPAntesDeG(pAntesG));
  }
  
  @Test
  public void test_VerificarOcorrenciaLetraPAntesDeG_EntradaSemLetraGNemP_DeveRetornarTrue()
  {
    Trabalho3 trabalho3 = new Trabalho3();
    String pAntesG = "ba";
    Assert.assertTrue(trabalho3.verificarOcorrenciaLetraPAntesDeG(pAntesG));
  }
  
  @Test
  public void test_VerificarOcorrenciaLetraPAntesDeG_EntradaPDepoisPrimeiroGAntesSegundo_DeveRetornarFalse()
  {
    Trabalho3 trabalho3 = new Trabalho3();
    String pAntesG = "gapolaga";
    Assert.assertFalse(trabalho3.verificarOcorrenciaLetraPAntesDeG(pAntesG));
  }
  
  @Test
  public void test_VerificarOcorrenciaLetraPAntesDeG_EntradaParaigua_DeveRetornarTrue()
  {
    Trabalho3 trabalho3 = new Trabalho3();
    String pAntesG = "paraigua";
    Assert.assertTrue(trabalho3.verificarOcorrenciaLetraPAntesDeG(pAntesG));
  }
  
  @Test
  public void test_VerificarLetrasIguaisConsecutivas_EntradaPossuiLetrasIguaisConsecutivas_DeveRetornarTrue()
  {
    Trabalho3 trabalho3 = new Trabalho3();
    String letrasIguaisConsecutivas = "leioo";
    Assert.assertTrue(trabalho3.verificarLetrasIguaisConsecutivas(letrasIguaisConsecutivas));
  }
  
  @Test
  public void test_VerificarLetrasIguaisConsecutivas_EntradaNaoPossuiLetrasIguaisConsecutivas_DeveRetornarFalse()
  {
    Trabalho3 trabalho3 = new Trabalho3();
    String letrasIguaisConsecutivas = "leioi";
    Assert.assertFalse(trabalho3.verificarLetrasIguaisConsecutivas(letrasIguaisConsecutivas));
  }
}