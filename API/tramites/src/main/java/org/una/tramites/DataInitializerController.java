package org.una.tramites;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.una.tramites.services.IDataInitializerService;

@RestController
@RequestMapping("/data")
@Api(tags = {"data"})
public class DataInitializerController {
    @Autowired
    private IDataInitializerService dataInitializerService;


    @GetMapping("/")
    @ApiOperation(value = "Init develop data",  tags = "data")
    public ResponseEntity<?> initDevelopData(){
        try {
            dataInitializerService.initDevelopData();
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @DeleteMapping("/")
    @ApiOperation(value = "Eliminar toda la informacion", tags = "data")
    public ResponseEntity<?> deleteAllData(){
        try {
            dataInitializerService.deleteAllData();
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
