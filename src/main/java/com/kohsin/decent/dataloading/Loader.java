package com.kohsin.decent.dataloading;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.kohsin.decent.entities.Claim;
import com.kohsin.decent.repository.ClaimRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

@Component
public class Loader {

    private ClaimRepository claimRepository;

    private ObjectMapper objectMapper;

    private static String filesDirectory = "/claims/";
    private static String savedClaims = filesDirectory + "saved/";

    @Autowired
    public Loader(ClaimRepository claimRepository) throws URISyntaxException {
        this.claimRepository = claimRepository;
        this.objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
    }

    @PostConstruct
    public void load() throws URISyntaxException {
        loadDataFromFiles();
    }

    @Scheduled(fixedRate = 5 * 60 * 1000, fixedDelay = 5 * 60 * 1000)
    public void loadClaimsToDb() {
        loadDataFromFiles();
    }

    //todo: implement mechanism for moving loaded files to another directory
    private void loadDataFromFiles() {
        try {
            Path resourcePath = Paths.get(Loader.class.getResource(filesDirectory).toURI());
            String[] filenames = Objects.requireNonNull(resourcePath.toFile().list());
            for (String path : filenames) {
                File file = Paths.get(resourcePath.toString() + '/' + path).toFile();
                Claim claim = objectMapper.readValue(file, Claim.class);
                saveClaimToDb(claim);
            }
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }
    }

    private void saveClaimToDb(Claim claim) {
        if (!claimRepository.existsById(claim.getId())) {
            claimRepository.save(claim);
        }
    }
}
