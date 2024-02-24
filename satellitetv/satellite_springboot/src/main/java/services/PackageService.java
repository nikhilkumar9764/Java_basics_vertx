package services;
import repositories.PackageRepository;

public class PackageService {

    private PackageRepository packageRepository;

    public Package getPackageById(Long id) {
        return packageRepository.findById(id).orElse(null);
    }
}
