package co.discord.media_engine;

import android.content.Context;
import androidx.annotation.AnyThread;
import co.discord.media_engine.internal.ExtensionFunctions;
import d0.z.d.Intrinsics3;
import org.webrtc.Camera1Enumerator;
import org.webrtc.Camera2Enumerator;
import org.webrtc.CameraEnumerator;
import org.webrtc.CameraVideoCapturer;

/* JADX INFO: compiled from: CameraEnumeratorProvider.kt */
/* JADX INFO: loaded from: classes.dex */
public final class CameraEnumeratorProvider {
    public static final CameraEnumeratorProvider INSTANCE = new CameraEnumeratorProvider();
    private static final String TAG = "CameraEnumeratorProvider";
    private static CameraEnumerator enumerator;

    private CameraEnumeratorProvider() {
    }

    @AnyThread
    public static final CameraVideoCapturer createCapturer(String cameraName) {
        Intrinsics3.checkNotNullParameter(cameraName, "cameraName");
        CameraVideoCapturer cameraVideoCapturerCreateCapturer = get().createCapturer(cameraName, null);
        Intrinsics3.checkNotNullExpressionValue(cameraVideoCapturerCreateCapturer, "get().createCapturer(cameraName, null)");
        return cameraVideoCapturerCreateCapturer;
    }

    @AnyThread
    public static final synchronized CameraEnumerator get() {
        CameraEnumerator camera1Enumerator;
        camera1Enumerator = enumerator;
        if (camera1Enumerator == null) {
            ExtensionFunctions.logi(TAG, "init was never called. Use Camera 1 API by default.");
            camera1Enumerator = new Camera1Enumerator();
        }
        return camera1Enumerator;
    }

    @AnyThread
    public static final synchronized void maybeInit(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        if (enumerator == null) {
            INSTANCE.init(context, false);
        }
    }

    @AnyThread
    public final synchronized void init(Context context, boolean forceCamera1) {
        CameraEnumerator camera1Enumerator;
        Intrinsics3.checkNotNullParameter(context, "context");
        if (forceCamera1) {
            ExtensionFunctions.logi(TAG, "Override: Forcing Camera 1 API");
            camera1Enumerator = new Camera1Enumerator();
        } else if (Camera2Enumerator.isSupported(context)) {
            ExtensionFunctions.logi(TAG, "Use Camera 2 API");
            camera1Enumerator = new Camera2Enumerator(context.getApplicationContext());
        } else {
            ExtensionFunctions.logi(TAG, "Camera 2 API is not supported. Use Camera 1 API");
            camera1Enumerator = new Camera1Enumerator();
        }
        enumerator = camera1Enumerator;
    }
}
