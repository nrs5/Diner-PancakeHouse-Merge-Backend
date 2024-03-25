package edu.iu.habahram.DinerPancakeHouseMerge.controllers;

import edu.iu.habahram.DinerPancakeHouseMerge.model.MenuItem;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.DinerRepository;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.PancakeHouseRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/merger")
public class MergeController {

    private final DinerRepository dinerRepository;
    private final PancakeHouseRepository pancakeHouseRepository;

    public MergeController(DinerRepository dinerRepository, PancakeHouseRepository pancakeHouseRepository) {
        this.dinerRepository = dinerRepository;
        this.pancakeHouseRepository = pancakeHouseRepository;
    }

    //need method to loop over items
    @GetMapping
    public List<MenuItem> getMergedMenu() {
        // Convert Diner menu array to list
        List<MenuItem> dinerMenuItems = Arrays.asList(dinerRepository.getTheMenu());
        // Get Pancake House menu list
        List<MenuItem> pancakeHouseMenuItems = pancakeHouseRepository.getTheMenu();
        // Merge both lists
        List<MenuItem> mergedMenuItems = Stream.concat(dinerMenuItems.stream(), pancakeHouseMenuItems.stream())
                .collect(Collectors.toList());
        // Sort the merged list by name
        mergedMenuItems.sort(Comparator.comparing(MenuItem::getName));
        return mergedMenuItems;
    }
}
