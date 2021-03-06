package com.jetbrains.php.psalm.types;

import com.jetbrains.php.codeInsight.PhpTypeInferenceTestCase;
import com.jetbrains.php.lang.psi.resolve.types.PhpType;
import org.jetbrains.annotations.NotNull;

public class PsalmTypeInferenceTest extends PhpTypeInferenceTestCase {
  public static final String TEST_DATA_HOME = "/phpstorm/psalm/testData/";

  @Override
  protected @NotNull String getTestDataHome() {
    return TEST_DATA_HOME;
  }

  @Override
  protected String getFixtureTestDataFolder() {
    return "codeInsight/typeInference";
  }

  public void testGenericArray$simpleKey() {
    doTypeTest(PhpType.STRING.pluralise());
  }

  public void testGenericArray$simpleValue() {
    doTypeTest(PhpType.STRING.pluralise());
  }

  public void testGenericArray$nestedKey() {
    doTypeTest(PhpType.STRING.pluralise(2));
  }

  public void testGenericArray$nestedValue() {
    doTypeTest(PhpType.STRING.pluralise(2));
  }

  public void testGenericArray$nestedValueWithKey() {
    doTypeTest(PhpType.STRING.pluralise(2));
  }

  public void testGenericArray$union() {
    doTypeTest(PhpType.or(PhpType.STRING, PhpType.INT).pluralise());
  }

  public void testGenericArray$nonArray() {
    doTypeTest("\\nonArray"); // no particular guarantees here
  }

  public void testGenericArray$nestedClassString() {
    doTypeTest(PhpType.STRING.pluralise(2));
  }

  public void testPsalmParam() {
    doTypeTest(PhpType.STRING);
  }

  public void testPsalmReturn() {
    doTypeTest(PhpType.INT, PhpType.STRING);
  }

  public void testPsalmVarField() {
    doTypeTest(PhpType.FLOAT);
  }

  public void testPsalmVarVar() {
    doTypeTest(PhpType.INT.pluralise());
  }

  public void testClassString() {
    doTypeTest(PhpType.STRING);
  }

  public void testCallableString() {
    doTypeTest(PhpType.STRING);
  }

  public void testNumericString() {
    doTypeTest(PhpType.STRING);
  }

  public void testTraitString() {
    doTypeTest(PhpType.STRING);
  }

  public void testScalar() {
    assertEquals(getActualType().getTypes(), PhpType.SCALAR.getTypes());
  }

  public void testNumeric() {
    doTypeTest(PhpType.STRING, PhpType.INT, PhpType.FLOAT);
  }

  public void testArrayKey() {
    doTypeTest(PhpType.NUMERIC);
  }

  public void testTypesFromExtendedClassConstants() {
    doTypeTest(PhpType.INT);
  }

  public void testTypesFromExtendedClassConstantsWildcard() {
    doTypeTest(PhpType.INT, PhpType.STRING);
  }
}
