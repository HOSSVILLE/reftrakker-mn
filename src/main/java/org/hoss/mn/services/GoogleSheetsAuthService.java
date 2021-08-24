package org.hoss.mn.services;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;

import jakarta.inject.Singleton;
import org.hoss.mn.config.ApplicationConfig;


import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

@Singleton
public class GoogleSheetsAuthService {

    private ApplicationConfig applicationConfig;

    public GoogleSheetsAuthService(final ApplicationConfig config) {
        this.applicationConfig = config;
    }

    public Credential authorize() throws IOException {
        InputStream in = new ByteArrayInputStream(applicationConfig.getGoogleCredentials().getBytes());

        GoogleCredential credential = GoogleCredential.fromStream(in).createScoped(applicationConfig.getScopes());
        return credential;
    }
}
