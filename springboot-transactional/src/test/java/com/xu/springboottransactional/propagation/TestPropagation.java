package com.xu.springboottransactional.propagation;

import com.xu.springboottransactional.service.IPropagationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestPropagation {

    @Autowired
    private IPropagationService propagationService;

    /**
     * Spring默认的传播机制，能满足绝大部分业务需求，如果外层有事务，则当前事务加入到外层事务，一块提交，一块回滚。
     * 任何一部分发生异常，都会回滚。
     * 如果外层没有事务，新建一个事务执行。
     */
    @Test
    public void test_REQUIRED(){
        propagationService.test_REQUIRED();
    }

    /**
     * 该事务传播机制是每次都会新开启一个事务，同时把外层事务挂起，当当前事务执行完毕，恢复上层事务的执行。
     * 如果外层没有事务，执行当前新开启的事务即可。
     * 先执行当前事务，外层事务发生异常不影响当前业务。（需要保证以常发生在执行内层事务之后，否则抛出异常，必然不会执行）
     */
    @Test
    public void test_REQUIRES_NEW(){
        propagationService.test_REQUIRES_NEW();
    }

    /**
     * 如果外层有事务，则加入外层事务，如果外层没有事务，则直接使用非事务方式执行。完全依赖外层的事务
     */
    @Test
    public void test_SUPPORTS(){
        propagationService.test_SUPPORTS();
    }


    /**
     * 该传播机制不支持事务，如果外层存在事务则挂起，执行完当前代码，则恢复外层事务，无论是否异常都不会回滚当前的代码
     * 与REQUIRES_NEW类似，但是这种传播机制不需要新建事务
    */
    @Test
    public void test_NOT_SUPPORTED(){
        propagationService.test_NOT_SUPPORTED();
    }

    /**
     * 该传播机制不支持外层事务，即如果外层有事务就抛出异常
     */
    @Test
    public void test_NEVER(){
        propagationService.test_NEVER();
    }

    /**
     * 与NEVER相反，如果外层没有事务，则抛出异常，意为“强制”，强制外层必须有事务注解
     */
    @Test
    public void test_MANDATORY(){
        propagationService.test_MANDATORY();
    }


    /**
     * REQUIRES_NEW如果B正常执行，则B中的数据在A提交之前已经完成提交，其他线程已经可见其修改，这就意味着可能有脏数据的产生；同时，如果接下来A的其他逻辑发生了异常，A回滚，但是B已经完成提交，不会回滚了。当然，如果A接下来的逻辑没有相关要求，那就无所谓了
     * NESTED如果B正常执行，此时B中的修改并不会立即提交，而是在A提交时一并提交，如果A下面的逻辑中发生异常，A回滚时，B中的修改也会回滚，就可以避免上述情况的发生
     */
    @Test
    public void test_NESTED(){
        propagationService.test_NESTED();
    }
}
