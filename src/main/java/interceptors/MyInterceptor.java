package interceptors;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.io.Serializable;

/**
 * Created by Raymond Phua on 15-11-2016.
 */
@Interceptor
@MyInterceptorBinding
public class MyInterceptor implements Serializable {

    @AroundInvoke
    public Object log(InvocationContext context) throws Exception {
        System.out.println("Intercepting to method: " + context.getMethod().getName());
        Object[] parameters = context.getParameters();
        if (parameters.length > 0 && parameters[0] instanceof String) {
            String param = (String) parameters[0];
            parameters[0] = "Hi " + param + " !";
            context.setParameters(parameters);
            System.out.println(param);
        }
        return context.proceed();
    }
}
