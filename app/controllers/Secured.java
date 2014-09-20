package controllers;

import play.mvc.Security.Authenticator;
import play.*;
import play.mvc.*;
import play.mvc.Http.*;
import models.*;

public class Secured extends Authenticator {
	@Override
    public String getUsername(Context ctx) {
        return ctx.session().get("id");
    }

    @Override
    public Result onUnauthorized(Context ctx) {
        return ok(util.HelperClass.jsonNodeForError("You have not logged in..."));
    }
 }
