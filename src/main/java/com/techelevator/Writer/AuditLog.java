package com.techelevator.Writer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


public class AuditLog {
    File auditText = new File("VendingAudit.txt");
    Logger auditLogger = Logger.getLogger("");

    public void auditLog(String messageToLog) throws FileNotFoundException {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM-dd-yyy hh:mm:ss a");
        String currentTime = dateTimeFormatter.format(LocalDateTime.now());

        String messageWithTimestamp = currentTime + " " + messageToLog;

        try (PrintWriter writer = new PrintWriter(new FileOutputStream(auditText, true))){
            writer.write(messageWithTimestamp);
            writer.println();

        }catch (FileNotFoundException ex){
            System.out.println("File path was not found");
        }



    }
}