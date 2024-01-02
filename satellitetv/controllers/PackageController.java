package satellitetv.controllers;
import satellitetv.services.PackageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/package")
public class PackageController
{

    private PackageService packageService;

    @GetMapping("/{id}")
    public Package getPackage(@PathVariable Long id)
    {
        return this.packageService.getPackageById(id);
    }
}
