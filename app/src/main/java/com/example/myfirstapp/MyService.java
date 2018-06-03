package com.example.myfirstapp;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import com.amazonaws.auth.CognitoCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.rekognition.AmazonRekognitionClient;
import com.amazonaws.services.rekognition.model.DetectLabelsRequest;
import com.amazonaws.services.rekognition.model.DetectLabelsResult;
import com.amazonaws.services.rekognition.model.Image;
import com.amazonaws.services.rekognition.model.Label;
import com.amazonaws.services.rekognition.model.S3Object;

import java.util.List;

public class MyService extends Service {
    String photo = "photo.jpg";
    //String bucket = "mengtongtomassignment3";
    String bucket = "recognition-deployments-mobilehub-862349224";
    public MyService() {

        new Thread(networkTask).start();
    }

    Runnable networkTask = new Runnable() {
        @Override
        public void run(){
            CognitoCredentialsProvider credentialsProvider = new CognitoCredentialsProvider(
                    //this.getApplicationContext(),
                    "us-east-1:3e275793-b7f1-435b-addb-050cb376e39b", // Identity pool ID
                    Regions.US_EAST_1 // Region
            );
            AmazonRekognitionClient rekognitionClient = new AmazonRekognitionClient(credentialsProvider);
            //rekognitionClient.setEndpoint("https://rekognition.US_EAST_1.amazonaws.com");
            //rekognitionClient.setSignerRegionOverride("US_EAST_1");
            DetectLabelsRequest request = new DetectLabelsRequest()
                    .withImage(new Image()
                    .withS3Object(new S3Object()
                    .withName(photo).withBucket(bucket)))
                    .withMaxLabels(10)
                    .withMinConfidence(75F);
            DetectLabelsResult result = rekognitionClient.detectLabels(request);
            List<Label> labels = result.getLabels();
            Log.d("myLog","Detected labels for "+photo);
            for(Label label:labels)
                Log.d("myLog", label.getName() + ": " + label.getConfidence().toString());
            }
    };


    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }




}
