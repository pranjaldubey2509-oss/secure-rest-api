package secureapi.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import secureapi.entity.Details;
import secureapi.service.DetailsService;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/details")
@RequiredArgsConstructor
public class DetailsController {

    private final DetailsService service;

    @PostMapping
    public Details create(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String countryCode,
            @RequestParam String phone,
            @RequestParam String address,
            @RequestParam MultipartFile pdf,
            @RequestParam MultipartFile video
    ) throws IOException {

        String uploadDir = "uploads/";

        File dir = new File(uploadDir);

        if (!dir.exists()) {

            dir.mkdirs();
        }

        String pdfPath =
                uploadDir + pdf.getOriginalFilename();

        String videoPath =
                uploadDir + video.getOriginalFilename();

        pdf.transferTo(new File(pdfPath));

        video.transferTo(new File(videoPath));

        Details details = new Details();

        details.setName(name);
        details.setEmail(email);
        details.setCountryCode(countryCode);
        details.setPhone(phone);
        details.setAddress(address);
        details.setPdfPath(pdfPath);
        details.setVideoPath(videoPath);

        return service.create(details);
    }

    @GetMapping
    public List<Details> getAll() {

        return service.getAll();
    }

    @PutMapping("/{id}")
    public Details update(
            @PathVariable Long id,
            @RequestBody Details details
    ) {

        return service.update(id, details);
    }

    @DeleteMapping("/{id}")
    public String delete(
            @PathVariable Long id
    ) {

        service.delete(id);

        return "Deleted Successfully";
    }
}