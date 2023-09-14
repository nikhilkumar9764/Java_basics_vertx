package com.satellitetv.controllers;

import com.satellitetv.services.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/package")
public class PackageController
{
    @Autowired
    private PackageService packageService;

    @GetMapping("/{id}")
    public Package getPackage(@PathVariable Long id)
    {
        return this.packageService.getPackageById(id);
    }
}
