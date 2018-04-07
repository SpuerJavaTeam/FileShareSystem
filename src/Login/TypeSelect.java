package Login;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

import java.util.Map;

public class TypeSelect {
    private Map<String,Object> session= ActionContext.getContext ().getSession ();
    public Map <String, Object> getSession() {
        return session;
    }

    public void setSession(Map <String, Object> session) {
        this.session = session;
    }


    public String Type() {
        int type = (int) session.get ( "type" );
        if (type == 0) {
            return "admin";
        }else if (type == 1){
            return "normal";
        }
        return Action.LOGIN;
    }
}
