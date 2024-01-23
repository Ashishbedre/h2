package H2Demo.example.H2Demo.repo;

import H2Demo.example.H2Demo.Entities.AppData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface H2Repository extends JpaRepository<AppData, Long> {
}
