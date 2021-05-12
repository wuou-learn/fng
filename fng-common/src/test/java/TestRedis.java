import com.upup.fng.engine.redis.RedisUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author wuou
 * @version 1.0.0
 * @date 2020/10/20 下午3:46
 */
public class TestRedis {
    
    @Autowired
    private RedisUtils redisUtils;
    
    @Test
    public void testUc1(){
        boolean set = redisUtils.set("fng", "test");
        
    }
}
