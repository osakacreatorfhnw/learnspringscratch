package com.damjan.fileimport.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;

@Controller
public class Fileimportlogic {

    // returns the view name for the upload page
    @GetMapping("/import")
    public String importer() {
        return "importpage";  // returns the view name for the upload page
    }

    // Handle file upload
    @PostMapping("/import")
    public String handleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        
        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:/import";
        }

        // Save the file
        try {
            String repoPath = "/home/damjan/Desktop/semester/code/ip5/learnspringscratch/imported/";
            String filePath = repoPath + file.getOriginalFilename();
            file.transferTo(new File(filePath));
            redirectAttributes.addFlashAttribute("message", "You successfully uploaded '" + file.getOriginalFilename() + "'");
        } 
        catch (IOException e) {
            redirectAttributes.addFlashAttribute("message", "Failed to upload file: " + e.getMessage());
        }

        // Redirect back to the import page after upload
        return "redirect:/import";
    }
}
