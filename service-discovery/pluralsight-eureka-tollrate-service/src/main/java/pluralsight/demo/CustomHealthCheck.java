package pluralsight.demo;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;

// @Component
public class CustomHealthCheck implements HealthIndicator {

  private int errorCode = 0;

  @Override
  public Health health() {
    System.out.println("Health check performed. Error code is " + this.errorCode);

    Health health = Health.up().build();
    if (this.errorCode % 8 > 3) {
      health = Health.down()
          .withDetail("Custom Error Code", this.errorCode)
          .build();
    }

    this.errorCode++;
    return health;
  }

}
