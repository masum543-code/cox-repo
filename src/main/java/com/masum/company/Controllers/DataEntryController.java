package com.masum.company.Controllers;

import com.masum.company.DataEntryPoint.DataEntry;
import com.masum.company.Services.DataEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("data-entry")
public class DataEntryController {
    @Autowired
    private DataEntryService dataEntryService;

    @GetMapping
    public List<DataEntry> findmethod(){
        return dataEntryService.finddata();
    }
    @PostMapping
    public String creating(@RequestBody DataEntry dataEntry){
        dataEntryService.postData(dataEntry);
        return "Data Create";
    }
    @GetMapping("id/{myid}")
    public DataEntry findById(@PathVariable String myid){
        return dataEntryService.findByid(myid).orElse(null);
    }
    @PutMapping("id/{myid}")
    public DataEntry updatedData(@PathVariable String myid, DataEntry newdata){
        DataEntry olddata = dataEntryService.findByid(myid).orElse(null);
        if (newdata != null){
            olddata.setName(newdata.getName() != null && !newdata.getName().equals("")? newdata.getName() : olddata.getName());
            olddata.setId(newdata.getId() != null && !newdata.getId().equals("")? newdata.getId() : olddata.getId());
            olddata.setResult(newdata.getResult() != null && !newdata.getResult().equals("")? newdata.getResult() : olddata.getResult());
        }
        dataEntryService.postData(olddata);
        return olddata;
    }
    @DeleteMapping("id/{myid}")
    public String delete(@PathVariable String myid){
        dataEntryService.delete(myid);
        return "Data Was Delete";
    }
}
