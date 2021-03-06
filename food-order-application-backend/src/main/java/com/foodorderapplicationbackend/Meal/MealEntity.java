package com.foodorderapplicationbackend.Meal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.stereotype.Controller;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Controller
@Entity(name="Meal")
@Table(name="Meal")
@AllArgsConstructor
@NoArgsConstructor
@Builder
//@IdClass(MenuId.class)
public class MealEntity {
    @Id
    @SequenceGenerator(
            name="meal_sequence",
            sequenceName = "meal_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "meal_sequence"
    )
    @Column(
            name="mealId",
            updatable = false,
            nullable = false
    )
    private Long mealId;
//    @Id
//    private Long menuId;
    @Column(
            nullable = false,
            columnDefinition="Decimal(10,2)"
    )
    private double cost;
    @Column(
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String title;
    @Column(
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String details;

//    @ManyToOne
//    private MealEntity menu;


    public MealEntity(double cost, String title, String details) {
        this.cost = cost;
        this.title = title;
        this.details = details;
    }


    public Long getMealId() {
        return mealId;
    }

    public void setMealId(Long mealId) {
        this.mealId = mealId;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "Meal{" +
                "id=" + mealId +
                ", cost=" + cost +
                ", title='" + title + '\'' +
                ", details='" + details + '\'' +
                '}';
    }
}
