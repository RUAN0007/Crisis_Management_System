package controllers;

import play.mvc.Security.Authenticator;
import play.mvc.*;
import play.mvc.Http.*;

public class Secured extends Authenticator {
	@Override
    public String getUsername(Context ctx) {
        return ctx.session().get("id");
    }

    @Override
    public Result onUnauthorized(Context ctx) {
        return ok(ControllerUtil.jsonNodeForError("You have not logged in..."));
    }
 }
