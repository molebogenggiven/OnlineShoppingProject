package com.michaelcgood.Service;

import com.michaelcgood.dao.DBFileRepository;
import com.michaelcgood.model.DBFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class DBFileStorageService {

    @Autowired
    private DBFileRepository dbFileRepository;

//    public DBFile storeFileAndValues(MultipartFile multipartFile, DBFile dbFile){
//
//       // String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
//
//        String fileName = dbFile.getFileName();
//        String fileType = dbFile.getFileType();
//
//
//
//        try{
//            if(fileName.contains("..")){
//
//                throw new Exception("Sorry! Filename contains invalid path"+ fileName);
//            }
//
//            DBFile dbFile1 = new DBFile(fileName, multipartFile.getContentType(), multipartFile.getBytes() );
//
//            return dbFileRepository.save(dbFile1);
//        }catch (Exception e){
//            System.out.println("File throwen an exception");
//        }
//
//        return new DBFile();
//    }

//    public DBFile storeFile(MultipartFile multipartFile){
//
//        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
//
//        try {
//            // check if the files's name contains invalid characters
//            if(fileName.contains("..")){
//                throw new Exception("Sorry! Filename contains invalid path sequence" + fileName);
//            }
//
//            DBFile dbFile = new DBFile(fileName, multipartFile.getContentType(), multipartFile.getBytes());
//            return dbFileRepository.save(dbFile);
//
//        }catch (Exception e){
//            System.out.println("File throwed an exception");
//        }
//
//        return new DBFile();
//    }



    public DBFile getFile(String fileId){

        return dbFileRepository.findById(fileId)
                .orElseThrow(()-> new RuntimeException("File not found with id " + fileId));
    }
}
