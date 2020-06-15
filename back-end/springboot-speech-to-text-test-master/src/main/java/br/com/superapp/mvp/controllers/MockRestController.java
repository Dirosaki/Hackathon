package br.com.superapp.mvp.controllers;

import java.io.InputStream;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.watson.developer_cloud.speech_to_text.v1.SpeechToText;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.RecognizeOptions;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechRecognitionResults;

@RestController
public class MockRestController {

  @Autowired
  protected SpeechToText speechToText;

  // mock

  @RequestMapping(value = "/test", produces = "text/plain")
  public String mockSample() {
      
      InputStream inputSteam = this.getClass().getResourceAsStream("/mock-audio-file.flac");
      RecognizeOptions recognizeOptions = new RecognizeOptions.Builder().audio(inputSteam).contentType("audio/flac")
          .model("en-US_BroadbandModel").keywords(Arrays.asList("command 01", "command 02", "command 03"))
          .keywordsThreshold((float) 0.5).maxAlternatives(3).build();

      SpeechRecognitionResults speechRecognitionResults = speechToText.recognize(recognizeOptions).execute();

      return speechRecognitionResults.toString();
      
  }
}