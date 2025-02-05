package io.quarkus.demo.wellness;

import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.reactive.RestPath;
import org.jboss.resteasy.reactive.RestQuery;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("recipes")
@RegisterRestClient(configKey="spoonacular-recipe-api")
@ClientHeaderParam(name = "x-rapidapi-host", value = "${spoonacular.host}")
@ClientHeaderParam(name = "x-rapidapi-key", value = "${rapid-api.key}")
public interface SpoonacularRecipesClient {

    @GET
    @Path("random")
    RandomRecipesResponse random(@RestQuery("tags") String tag, @RestQuery int number);

    @GET
    @Path("{id}/information")
    Recipe information(@RestPath long id);
}
