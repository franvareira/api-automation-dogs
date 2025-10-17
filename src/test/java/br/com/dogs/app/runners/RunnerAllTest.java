package br.com.dogs.app.runners;

import br.com.dogs.app.scenarios.VerificarApiDogsTest;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;


@Suite
@SelectClasses({VerificarApiDogsTest.class})
public class RunnerAllTest {
}
