package food.delivery.infra;
import food.delivery.domain.*;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;


@RestController
// @RequestMapping(value="/foodCookings")
@Transactional
public class FoodCookingController {
    @Autowired
    FoodCookingRepository foodCookingRepository;



    @RequestMapping(value = "foodCookings/{id}/accept",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8")
    public FoodCooking accept(@PathVariable(value = "id") Long id, @RequestBody AcceptCommand acceptCommand, HttpServletRequest request, HttpServletResponse response) throws Exception {
            System.out.println("##### /foodCooking/accept  called #####");
            Optional<FoodCooking> optionalFoodCooking = foodCookingRepository.findById(id);
            
            optionalFoodCooking.orElseThrow(()-> new Exception("No Entity Found"));
            FoodCooking foodCooking = optionalFoodCooking.get();
            foodCooking.accept(acceptCommand);
            
            foodCookingRepository.save(foodCooking);
            return foodCooking;
            
    }
    



    @RequestMapping(value = "foodCookings/{id}/start",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8")
    public FoodCooking start(@PathVariable(value = "id") Long id, HttpServletRequest request, HttpServletResponse response) throws Exception {
            System.out.println("##### /foodCooking/start  called #####");
            Optional<FoodCooking> optionalFoodCooking = foodCookingRepository.findById(id);
            
            optionalFoodCooking.orElseThrow(()-> new Exception("No Entity Found"));
            FoodCooking foodCooking = optionalFoodCooking.get();
            foodCooking.start();
            
            foodCookingRepository.save(foodCooking);
            return foodCooking;
            
    }
    




}
