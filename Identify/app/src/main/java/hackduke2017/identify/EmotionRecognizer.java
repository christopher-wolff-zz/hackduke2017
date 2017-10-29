package hackduke2017.identify;

import android.graphics.Bitmap;

import com.google.gson.Gson;
import com.microsoft.projectoxford.emotion.EmotionServiceClient;
import com.microsoft.projectoxford.emotion.EmotionServiceRestClient;
import com.microsoft.projectoxford.emotion.contract.RecognizeResult;
import com.microsoft.projectoxford.emotion.rest.EmotionServiceException;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import java.util.Map;
import java.util.HashMap;

public enum EmotionRecognizer{

    SINGLETON;

    public final String ANGER = "Anger";
    public final String CONTEMPT = "Contempt";
    public final String DISGUIST = "Disguist";
    public final String FEAR = "Fear";
    public final String HAPPINESS = "Happiness";
    public final String NEUTRAL = "Neutral";
    public final String SADNESS = "Sadness";
    public final String SURPRISE = "Surprise";

    private final String SUBSCRIPTION_KEY = "9a534adbdb8d4bd4acd3555dd0f0fe23";
    private final String API_ROOT = "https://westus.api.cognitive.microsoft.com/emotion/v1.0";

    private EmotionServiceClient client = new EmotionServiceRestClient(SUBSCRIPTION_KEY, API_ROOT);

    public Map<String, Double> getEmotionValues(Bitmap mBitmap) throws EmotionServiceException, IOException {
        Gson gson = new Gson();

        // Put the image into an input stream for detection.
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        mBitmap.compress(Bitmap.CompressFormat.JPEG, 100, output);
        ByteArrayInputStream inputStream = new ByteArrayInputStream(output.toByteArray());

        long startTime = System.currentTimeMillis();

        List<RecognizeResult> result = null;
        result = this.client.recognizeImage(inputStream);

        String json = gson.toJson(result);
        System.out.println("result: " + json);

        Map<String, Double> map = new HashMap<>();
        return null;
    }

}
