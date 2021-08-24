package org.hoss.mn.config;


import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.sheets.v4.SheetsScopes;
import io.micronaut.context.annotation.Value;
import jakarta.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.List;

@Singleton
public class ApplicationConfig {
    private static Logger logger = LoggerFactory.getLogger(ApplicationConfig.class);

    private java.io.File dataStoreDir = new java.io.File(".credentials");
    private FileDataStoreFactory dataStoreFactory;
    private List<String> scopes = Arrays.asList(SheetsScopes.SPREADSHEETS_READONLY);
    private JsonFactory jsonFactory = GsonFactory.getDefaultInstance();
    private HttpTransport httpTransport;

    public ApplicationConfig() {
        try {
            dataStoreFactory = new FileDataStoreFactory(dataStoreDir);
            httpTransport = GoogleNetHttpTransport.newTrustedTransport();
        } catch (IOException | GeneralSecurityException ex) {
            ex.printStackTrace();
        }
    }

    @Value("${GOOGLE_CREDENTIALS}")
    private String googleCredentials;

    @Value("${org.hoss.spreadsheet.id}")
    private String sheetId;

    @Value("${micronaut.application.name}")
    private String name;

    public String getSheetId() {
        return this.sheetId;
    }

    public String getGoogleCredentials() {
        return this.googleCredentials;
    }

    public List<String> getScopes() {
        return scopes;
    }
    public HttpTransport getHttpTransport() {
        return httpTransport;
    }
    public JsonFactory getJsonFactory() {
        return jsonFactory;
    }
    public String getName() { return this.name;}
}
