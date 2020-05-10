

import java.util.concurrent.*;

/**
 * 详情见附件   JAVA线程池.pdf
 */
public class ThreadPoolTest {

    public static void main(String[] args) {
        //创建线程池
//        ExecutorService executorService = new ThreadPoolExecutor(2, 2,
//                0, TimeUnit.SECONDS,
//                new ArrayBlockingQueue<>(512), // 使用有界队列，避免OOM
//                new ThreadPoolExecutor.DiscardPolicy());//拒绝时直接抛出异常

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        Future<Object> future = executorService.submit(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                throw new RuntimeException("exception in call~");// 该异常会在调用Future.get()时传递给调用者
            }
        });
        try {
            Object result = future.get();
        } catch (InterruptedException e) {
            // interrupt
        } catch (ExecutionException e) {
            // exception in Callable.call()
            e.printStackTrace();
        }

    }

    //获取多个结果
//    void solve(Executor executor, Collection<Callable<Result>> solvers)
//            throws InterruptedException, ExecutionException {
//
//        CompletionService<Result> ecs = new ExecutorCompletionService<Result>(executor);// 构造器
//
//        for (Callable<Result> s : solvers)// 提交所有任务
//            ecs.submit(s);
//
//        int n = solvers.size();
//        for (int i = 0; i < n; ++i) {// 获取每一个完成的任务
//            Result r = ecs.take().get();
//            if (r != null)
//                use(r);
//        }
//    }

}
