package Login;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import java.util.Map;

public class LoginInterceptor extends AbstractInterceptor {
    private static final long serialVersionUID = 1L;

    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        if (!actionInvocation.getProxy ().getMethod ().equals ( "login" )){
            ActionContext context = actionInvocation.getInvocationContext ();
            Map<String,Object> session = context.getSession ();
            String username = (String) session.get ( "username" );
            if (username ==null){
                return Action.LOGIN;
            }
        }
        return actionInvocation.invoke ();
    }
}
