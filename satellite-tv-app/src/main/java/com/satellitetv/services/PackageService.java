package com.satellitetv.services;

import com.satellitetv.repositories.PackageRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class PackageService {

    @Autowired
    private PackageRepository packageRepository;

    public Package getPackageById(Long id) {
        return packageRepository.findById(id).orElse(null);
    }
}
