package interceptors;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

/**
 * Created by Raymond Phua on 14-11-2016.
 */
@Interceptor
public class TracelogInterceptor {
    @AroundInvoke
    public Object log(InvocationContext ic) throws Exception {
        System.out.println("Intercepting to method: " + ic.getMethod().getName());

        return ic.proceed();
    }
}
