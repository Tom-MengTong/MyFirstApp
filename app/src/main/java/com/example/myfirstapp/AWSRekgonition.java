package com.example.myfirstapp;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.Protocol;
import com.amazonaws.auth.CognitoCachingCredentialsProvider;
import com.amazonaws.auth.CognitoCredentialsProvider;
import com.amazonaws.services.rekognition.AmazonRekognition;
import com.amazonaws.services.rekognition.AmazonRekognitionClient;
import com.amazonaws.services.rekognition.model.*;
//import com.amazonaws.services.rekognition.AmazonRekognitionClientBuilder;
import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.AWSCredentials;
//import com.amazonaws.auth.AWSStaticCredentialsProvider;
//import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.AmazonServiceException;
//import com.amazonaws.services.rekognition.model.AmazonRekognitionException;
import com.amazonaws.services.rekognition.model.DetectLabelsRequest;
import com.amazonaws.services.rekognition.model.DetectLabelsResult;
import com.amazonaws.services.rekognition.model.Image;
import com.amazonaws.services.rekognition.model.Label;
import com.amazonaws.services.rekognition.model.S3Object;
import java.util.List;

public class AWSRekgonition extends Activity {

    public static void main(String[] args) throws Exception {

        String photo = "photo.jpg";
        String bucket = "mengtongtomassignment3";
/*
        // Initialize the Amazon Cognito credentials provider
        CognitoCachingCredentialsProvider credentialsProvider = new CognitoCachingCredentialsProvider(
                getApplicationContext(),
                "us-east-1:3e275793-b7f1-435b-addb-050cb376e39b", // Identity pool ID
                Regions.US_EAST_1 // Region
        );
*/
        // Initialize the Amazon Cognito credentials provider

        /*
        CognitoCachingCredentialsProvider credentialsProvider = new CognitoCachingCredentialsProvider(
                getApplicationContext(),
                "us-east-1:3e275793-b7f1-435b-addb-050cb376e39b", // Identity pool ID
                Regions.US_EAST_1 // Region
        );
        */
        //ClientConfiguration clientConfiguration = new ClientConfiguration();
        //clientConfiguration.setProtocol(Protocol.HTTPS);
/*
        AWSCredentials credentials;
        try {
            credentials = new ProfileCredentialsProvider("Adminuser").getCredentials();
        } catch(Exception e) {
            throw new AmazonClientException("Cannot load the credentials from the credential profiles file. "
                    + "Please make sure that your credentials file is at the correct "
                    + "location (/Users/userid/.aws/credentials), and is in a valid format.", e);
        }

        AmazonRekognition rekognitionClient = AmazonRekognitionClientBuilder
                .standard()
                .withRegion(Regions.US_WEST_2)
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .build();

        AmazonRekognitionClient rekognitionClient = new AmazonRekognitionClient(credentialsProvider);
        rekognitionClient.setEndpoint("https://rekognition.US_WEST_2.amazonaws.com");
        rekognitionClient.setSignerRegionOverride("US_WEST_2");

        DetectLabelsRequest request = new DetectLabelsRequest()
                .withImage(new Image()
                        .withS3Object(new S3Object()
                                .withName(photo).withBucket(bucket)))
                .withMaxLabels(10)
                .withMinConfidence(75F);

        try {
            DetectLabelsResult result = rekognitionClient.detectLabels(request);
            List <Label> labels = result.getLabels();

            System.out.println("Detected labels for " + photo);
            for (Label label: labels) {
                System.out.println(label.getName() + ": " + label.getConfidence().toString());
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
        */
    }

}
