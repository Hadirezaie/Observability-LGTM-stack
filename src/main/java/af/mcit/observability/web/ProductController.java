package af.mcit.observability.web;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

import af.mcit.observability.entities.Product;
import af.mcit.observability.model.Post;
import af.mcit.observability.repository.ProductRepository;

import java.util.List;

/**
 * @author mohamedyoussfi
 **/
@RestController
public class ProductController {
    private ProductRepository productRepository;
    private RestClient restClient;

    public ProductController(ProductRepository productRepository,
            RestClient.Builder restClient) {
        this.productRepository = productRepository;
        this.restClient = restClient
                .baseUrl("https://jsonplaceholder.typicode.com")
                .build();
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/posts")
    public List<Post> allPosts() {
        return restClient.get()
                .uri("/posts")
                .retrieve()
                .body(new ParameterizedTypeReference<List<Post>>() {
                });
    }
}