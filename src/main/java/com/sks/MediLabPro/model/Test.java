import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "tests")
public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String testName;

    @Column(length = 1000)
    private String description;

    private String category;           // e.g., Blood, Radiology, Pathology

    private BigDecimal cost;

    private String sampleRequired;     // e.g., Blood, Urine, Saliva

    private String normalRange;        // e.g., 4.5 - 6.0

    private String unit;               // e.g., mg/dL

    private String method;             // e.g., ELISA, PCR

    private String status;             // Active, Inactive

    private Integer durationInMinutes; // Estimated time to complete the test

    private Boolean isHomeCollectionAvailable;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = this.createdAt;
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    // Constructors
    public Test() {}

    public Test(String testName, String description, String category, BigDecimal cost,
                String sampleRequired, String normalRange, String unit, String method,
                String status, Integer durationInMinutes, Boolean isHomeCollectionAvailable) {
        this.testName = testName;
        this.description = description;
        this.category = category;
        this.cost = cost;
        this.sampleRequired = sampleRequired;
        this.normalRange = normalRange;
        this.unit = unit;
        this.method = method;
        this.status = status;
        this.durationInMinutes = durationInMinutes;
        this.isHomeCollectionAvailable = isHomeCollectionAvailable;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public String getSampleRequired() {
        return sampleRequired;
    }

    public void setSampleRequired(String sampleRequired) {
        this.sampleRequired = sampleRequired;
    }

    public String getNormalRange() {
        return normalRange;
    }

    public void setNormalRange(String normalRange) {
        this.normalRange = normalRange;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getDurationInMinutes() {
        return durationInMinutes;
    }

    public void setDurationInMinutes(Integer durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

    public Boolean getIsHomeCollectionAvailable() {
        return isHomeCollectionAvailable;
    }

    public void setIsHomeCollectionAvailable(Boolean isHomeCollectionAvailable) {
        this.isHomeCollectionAvailable = isHomeCollectionAvailable;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
