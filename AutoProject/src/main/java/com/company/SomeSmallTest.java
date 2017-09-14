  package com.company;

  import java.nio.file.Path;
import java.nio.file.Paths;

import org.graphwalker.core.condition.EdgeCoverage;
import org.graphwalker.core.generator.RandomPath;
import org.graphwalker.core.machine.ExecutionContext;
  import org.graphwalker.java.annotation.GraphWalker;
import org.graphwalker.java.test.TestBuilder;
import org.testng.annotations.Test;

/**
 * See: http://graphwalker.org/docs/maven_archetype for more details
 * <p/>
 * Implements the GraphWalker model: src/main/resources/SmallTest.graphml
 * The SmallTest.graphml can be opened and edited using http://www.yworks.com/en/products/yfiles/yed/
 * <p/>
 * For convienicene, a jpg image exists side-by-side in the same folder.
 * <p/>
 * The @GraphWalker annotation, has the following meaning:
 * 1) value defines the generator of this test. Please read more
 * on the subject at: http://graphwalker.org/docs/path_generators_and_stop_conditions
 * 2) start defines the first element in the model to be executed. (Element is
 * either a vertex or an edge)
 * <p/>
 * The interface SmallTest, that SomeSmallTest implements, is generated by
 * running: mvn graphwalker:generate-sources
 * also: mvn graphwalker:test
 */
@GraphWalker(value = "random(edge_coverage(100))", start = "e_FirstAction")
public class SomeSmallTest extends ExecutionContext implements SmallTest {

	public final static Path MODEL_PATH = Paths.get("D:\\Users\\yanzhipeng\\git\\AutoProject\\src\\main\\resources\\com\\company/SmallTest.graphml");
	
  @Override
  public void e_FirstAction() {
    System.out.println("Running: e_FirstAction");
  }

  @Override
  public void e_AnotherAction() {
    System.out.println("Running: e_AnotherAction");
  }

  @Override
  public void e_SomeAction() {
    System.out.println("Running: e_SomeAction");
  }

  @Override
  public void e_SomeOtherAction() {
    System.out.println("Running: e_SomeOtherAction");
  }

  @Override
  public void v_VerifySomeAction() {
    System.out.println("Running: v_VerifySomeAction");
  }

  @Override
  public void v_VerifySomeOtherAction() {
    System.out.println("Running: v_VerifySomeOtherAction");
  }
  
//  @Test
//  public void runSmokeTest() {
//      new TestBuilder()
//          .setModel(MODEL_PATH)
//          .setContext(new SomeSmallTest())
//          .setPathGenerator(new AStarPath(new ReachedVertex("v_Browse")))
//          .setStart("e_Init")
//          .execute();
//  }

  @Test
  public void runFunctionalTest() {
      new TestBuilder()
          .setModel(MODEL_PATH)
          .setContext(new SomeSmallTest())
          .setPathGenerator(new RandomPath(new EdgeCoverage(100)))
          .setStart("e_Init")
          .execute();
  }

//  @Test
//  public void runStabilityTest() {
//      new TestBuilder()
//          .setModel(MODEL_PATH)
//          .setContext(new SomeSmallTest())
//          .setPathGenerator(new RandomPath(new TimeDuration(30, TimeUnit.SECONDS)))
//          .setStart("e_Init")
//          .execute();
//  }
}
