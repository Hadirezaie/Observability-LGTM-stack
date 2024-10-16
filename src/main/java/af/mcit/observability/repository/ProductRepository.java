package af.mcit.observability.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import af.mcit.observability.entities.Product;

/**
 * @author mohamedyoussfi
 **/
public interface ProductRepository extends JpaRepository<Product, Long> {
}
