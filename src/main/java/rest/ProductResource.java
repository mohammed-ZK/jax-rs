package rest;

import jakarta.ejb.Singleton;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import model.Product;
import service.ProductService;

import java.util.List;
import java.util.NoSuchElementException;

@Path("products")
@Singleton
public class ProductResource {

    @Inject
    ProductService productService;

    @GET
    @Produces({ MediaType.APPLICATION_JSON })
    public Response findall() {
//        return productService.findall();
        return Response.ok(productService.findall()).build();
    }

    @POST
    @Produces({ MediaType.APPLICATION_JSON })
    public Response add(@Valid Product product)  {
        Product createdProduct =productService.add(product);
        return Response.status(Response.Status.CREATED).entity(createdProduct).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
//        productService.delete(id);
//        return Response.noContent().build();
        if (!productService.delete(id)) {
            throw new NotFoundException("Product "+id+" not found");
        }
        return Response.noContent().build();
    }

    @PUT
    @Path("/{id}")
    @Produces({ MediaType.APPLICATION_JSON })
    public Response updateProduct(@PathParam("id") Long id,@Valid Product product)  {
//        Optional<Product> updatedProduct =productService.updata(id, product);
//        return updatedProduct.map(value -> Response.ok(value).build())
//                .orElseGet(() -> Response.status(Response.Status.NOT_FOUND).build());
        try {
            Product updatedProduct = productService.updata(id,product);
            return Response.ok(updatedProduct).build();
        } catch (NoSuchElementException e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

    }

    @GET
    @Path("/search")
    @Produces({ MediaType.APPLICATION_JSON })
    public Response searchByName(@QueryParam("name") String name)  {
//        return productService.getByName(name);
        Product product = productService.getByName(name);
        if (product == null) {
            throw new NotFoundException("Product "+name+" not found");
        }
        return Response.ok(product).build();
    }

}
