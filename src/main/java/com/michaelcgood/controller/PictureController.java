package com.michaelcgood.controller;


import com.michaelcgood.Service.DBFileStorageService;
import com.michaelcgood.Service.StorageService;
import com.michaelcgood.dao.DBFileRepository;
import com.michaelcgood.dao.PictureRepository;
import com.michaelcgood.model.DBFile;
import com.michaelcgood.model.PictureModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.core.io.Resource;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/picture")
public class PictureController {

    @Autowired
    PictureRepository pictureRepository;
    
    @Autowired
    StorageService storageService;


    @Autowired
    private DBFileStorageService dbFileStorageService;

    @Autowired
    private DBFileRepository  dbFileRepository;

    List<String> files = new ArrayList<>();


   @PostMapping("/savePictureToDatabase")
   public DBFile savePictureToDatabase(@Valid @RequestBody DBFile dbFile ){

//        DBFile dbFile1 = dbFileStorageService.storeFile(multipartFile);
//       // dbFileStorageService.storeFileAndValues(multipartFile, dbFile);
//        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentServletMapping()
//                .path("/downloadFile/")
//                .path(dbFile1.getId())
//                .toUriString();

     return dbFileRepository.save(dbFile);
    }

//    @GetMapping("/downloadFile/{fileId}")
//    public ResponseEntity<Resource> downloadFile(@PathVariable String fileId){
//        // Load file from database
//
//        DBFile dbFile = dbFileStorageService.getFile(fileId);

//        return  ResponseEntity.ok()
//                .contentType(MediaType.parseMediaType(dbFile.getFileType()))
//                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + dbFile.getFileName() + "\"")
//                .body(new ByteArrayResource(dbFile.getData()));
 //   }

    @GetMapping("/getAllPictures")
    public List<DBFile> getAllPictures(){

        return dbFileRepository.findAll();
    }



    @PostMapping("/savePicture")
    public PictureModel savePicture(@Valid @RequestBody PictureModel pictureModel){
        
        if(pictureModel.getPicture() != null)
        {
            return pictureRepository.save(pictureModel);
        }
        
        else{
            
            return null;
        }
      
    }
    
    @PostMapping("/post")
    public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file){
        String message = "";
        
        try {

            storageService.store(file);
            files.add(file.getOriginalFilename());
            message = "You succesfully uploaded " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.OK).body(message);
            
        }catch (Exception e){
            message = "Failed to upload" + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
        }
    }
    
    @GetMapping("/getallfiles")
    public ResponseEntity<List<String>> getListFiles(Model file){
        List<String> fileNames = files
                .stream().map(fileName -> MvcUriComponentsBuilder
                .fromMethodName(PictureController.class, "getFile", fileName).build().toString())
                .collect(Collectors.toList());
        
        return ResponseEntity.ok().body(fileNames);
    }
    
    @GetMapping("/files/filename:.+")
    @ResponseBody
    public ResponseEntity<Resource> getFile(@PathVariable String filename){
        Resource file = storageService.loadFile(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\" " + file.getFilename())
                .body(file);
    }
        

}
