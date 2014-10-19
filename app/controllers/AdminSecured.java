package controllers;

import play.mvc.Result;
import play.mvc.Http.Context;
import play.mvc.Security.Authenticator;

public class AdminSecured extends Authenticator {

	@Override
    public String getUsername(Context ctx) {
        String id = ctx.session().get("id");
        if(id != null && id.startsWith("M")){
        		return id;
        }else{
        		return null;
        }
    }

    @Override
    public Result onUnauthorized(Context ctx) {
        return ok("You have not logged in as System Administrator...");
    }

}
