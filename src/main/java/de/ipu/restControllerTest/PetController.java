package de.ipu.restControllerTest;

import com.baeldung.openapi.api.PetsApi;
import com.baeldung.openapi.api.PetsApiController;
import com.baeldung.openapi.model.Pet;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("test")
public class PetController implements PetsApi {

    @GetMapping("/didi1")
    public String getmessung() {
        return "nuki";
    }


    @PreAuthorize("hasRole('ADMIN')")
    @Override
    public ResponseEntity<List<Pet>> listPets(@ApiParam(value = "How many items to return at one time (max 100)") @Valid @RequestParam(value = "limit", required = false) Integer limit) {
        return new ResponseEntity(Arrays.asList(new Pet()), HttpStatus.ACCEPTED);
    }

}
