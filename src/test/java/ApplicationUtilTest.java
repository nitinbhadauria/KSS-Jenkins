import com.ttn.util.ApplicationUtil;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by harkesh on 18/8/17.
 */
@SpringBootTest(classes = ApplicationUtil.class)
@RunWith(SpringRunner.class)
public class ApplicationUtilTest {

  ApplicationUtil applicationUtil = new ApplicationUtil();

  @Test
  public void firstTest(){
    Assert.assertEquals(applicationUtil.sum(1,2),1);
  }

  @Test
  public void secondtTest(){
    Assert.assertEquals(applicationUtil.sum(0,2),2);
  }
}
