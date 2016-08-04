package wang.imchao.zhuge;

import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableNativeMap;
import com.zhuge.analysis.stat.ZhugeSDK;

import org.json.JSONObject;

/**
 * Created by chao on 8/4/16.
 */
public class ZhuGeModule extends ReactContextBaseJavaModule  implements LifecycleEventListener {
    public ZhuGeModule(ReactApplicationContext reactContext) {
        super(reactContext);
        ZhugeSDK.getInstance().init(reactContext);
    }

    @ReactMethod
    public void identify(String userId, ReadableMap personObject){
        ZhugeSDK.getInstance().identify(getReactApplicationContext(), userId, new JSONObject(((ReadableNativeMap) personObject).toHashMap()));
    }

    @ReactMethod
    public void track(String eventName, ReadableMap eventObject){
        ZhugeSDK.getInstance().track(getReactApplicationContext(), eventName, new JSONObject(((ReadableNativeMap) eventObject).toHashMap()));
    }

    @Override
    public String getName() {
        return "ZhuGe";
    }

    @Override
    public void onHostResume() {
    }

    @Override
    public void onHostPause() {

    }

    @Override
    public void onHostDestroy() {
        ZhugeSDK.getInstance().flush(getReactApplicationContext());
    }
}
