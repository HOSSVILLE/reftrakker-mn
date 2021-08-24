package org.hoss.mn.services;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.services.sheets.v4.Sheets;
import jakarta.inject.Singleton;
import org.hoss.mn.config.ApplicationConfig;

import java.io.IOException;

@Singleton
public class GoogleSheetsService {
    private GoogleSheetsAuthService googleSheetsAuthService;
    private ApplicationConfig appConfig;

    public GoogleSheetsService(final GoogleSheetsAuthService googleSheetsAuthService, final ApplicationConfig appConfig) {
        this.googleSheetsAuthService = googleSheetsAuthService;
        this.appConfig = appConfig;
    }

    public Sheets getSheetsService() throws IOException {
        Credential credential = googleSheetsAuthService.authorize();
        return new Sheets.Builder(appConfig.getHttpTransport(), appConfig.getJsonFactory(), credential)
                .setApplicationName(appConfig.getName())
                .build();
    }
}
