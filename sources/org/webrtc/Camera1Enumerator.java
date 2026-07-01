package org.webrtc;

import android.hardware.Camera;
import android.hardware.Camera$CameraInfo;
import android.hardware.Camera$Parameters;
import android.hardware.Camera$Size;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import b.d.b.a.a;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class Camera1Enumerator implements CameraEnumerator {
    private static final String TAG = "Camera1Enumerator";
    private static List<List<CameraEnumerationAndroid$CaptureFormat>> cachedSupportedFormats;
    private final boolean captureToTexture;

    public Camera1Enumerator() {
        this(true);
    }

    public static List<CameraEnumerationAndroid$CaptureFormat$FramerateRange> convertFramerates(List<int[]> list) {
        ArrayList arrayList = new ArrayList();
        for (int[] iArr : list) {
            arrayList.add(new CameraEnumerationAndroid$CaptureFormat$FramerateRange(iArr[0], iArr[1]));
        }
        return arrayList;
    }

    public static List<Size> convertSizes(List<Camera$Size> list) {
        ArrayList arrayList = new ArrayList();
        for (Camera$Size camera$Size : list) {
            arrayList.add(new Size(camera$Size.width, camera$Size.height));
        }
        return arrayList;
    }

    private static List<CameraEnumerationAndroid$CaptureFormat> enumerateFormats(int i) {
        int i2;
        Logging.d(TAG, "Get supported formats for camera index " + i + ".");
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        Camera cameraOpen = null;
        try {
            try {
                Logging.d(TAG, "Opening camera with index " + i);
                cameraOpen = Camera.open(i);
                Camera$Parameters parameters = cameraOpen.getParameters();
                cameraOpen.release();
                ArrayList arrayList = new ArrayList();
                try {
                    List<int[]> supportedPreviewFpsRange = parameters.getSupportedPreviewFpsRange();
                    int i3 = 0;
                    if (supportedPreviewFpsRange != null) {
                        int[] iArr = supportedPreviewFpsRange.get(supportedPreviewFpsRange.size() - 1);
                        i3 = iArr[0];
                        i2 = iArr[1];
                    } else {
                        i2 = 0;
                    }
                    for (Camera$Size camera$Size : parameters.getSupportedPreviewSizes()) {
                        arrayList.add(new CameraEnumerationAndroid$CaptureFormat(camera$Size.width, camera$Size.height, i3, i2));
                    }
                } catch (Exception e) {
                    Logging.e(TAG, "getSupportedFormats() failed on camera index " + i, e);
                }
                long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                StringBuilder sbV = a.V("Get supported formats for camera index ", i, " done. Time spent: ");
                sbV.append(jElapsedRealtime2 - jElapsedRealtime);
                sbV.append(" ms.");
                Logging.d(TAG, sbV.toString());
                return arrayList;
            } catch (RuntimeException e2) {
                Logging.e(TAG, "Open camera failed on camera index " + i, e2);
                ArrayList arrayList2 = new ArrayList();
                if (cameraOpen != null) {
                    cameraOpen.release();
                }
                return arrayList2;
            }
        } catch (Throwable th) {
            if (cameraOpen != null) {
                cameraOpen.release();
            }
            throw th;
        }
    }

    public static int getCameraIndex(String str) {
        Logging.d(TAG, "getCameraIndex: " + str);
        for (int i = 0; i < Camera.getNumberOfCameras(); i++) {
            if (str.equals(getDeviceName(i))) {
                return i;
            }
        }
        throw new IllegalArgumentException(a.w("No such camera: ", str));
    }

    @Nullable
    private static Camera$CameraInfo getCameraInfo(int i) {
        Camera$CameraInfo camera$CameraInfo = new Camera$CameraInfo();
        try {
            Camera.getCameraInfo(i, camera$CameraInfo);
            return camera$CameraInfo;
        } catch (Exception e) {
            Logging.e(TAG, "getCameraInfo failed on index " + i, e);
            return null;
        }
    }

    @Nullable
    public static String getDeviceName(int i) {
        Camera$CameraInfo cameraInfo = getCameraInfo(i);
        if (cameraInfo == null) {
            return null;
        }
        return "Camera " + i + ", Facing " + (cameraInfo.facing == 1 ? "front" : "back") + ", Orientation " + cameraInfo.orientation;
    }

    @Override // org.webrtc.CameraEnumerator
    public CameraVideoCapturer createCapturer(String str, CameraVideoCapturer$CameraEventsHandler cameraVideoCapturer$CameraEventsHandler) {
        return new Camera1Capturer(str, cameraVideoCapturer$CameraEventsHandler, this.captureToTexture);
    }

    @Override // org.webrtc.CameraEnumerator
    public String[] getDeviceNames() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < Camera.getNumberOfCameras(); i++) {
            String deviceName = getDeviceName(i);
            if (deviceName != null) {
                arrayList.add(deviceName);
                Logging.d(TAG, "Index: " + i + ". " + deviceName);
            } else {
                Logging.e(TAG, "Index: " + i + ". Failed to query camera name.");
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    @Override // org.webrtc.CameraEnumerator
    public List<CameraEnumerationAndroid$CaptureFormat> getSupportedFormats(String str) {
        return getSupportedFormats(getCameraIndex(str));
    }

    @Override // org.webrtc.CameraEnumerator
    public boolean isBackFacing(String str) {
        Camera$CameraInfo cameraInfo = getCameraInfo(getCameraIndex(str));
        return cameraInfo != null && cameraInfo.facing == 0;
    }

    @Override // org.webrtc.CameraEnumerator
    public boolean isFrontFacing(String str) {
        Camera$CameraInfo cameraInfo = getCameraInfo(getCameraIndex(str));
        return cameraInfo != null && cameraInfo.facing == 1;
    }

    public Camera1Enumerator(boolean z2) {
        this.captureToTexture = z2;
    }

    public static synchronized List<CameraEnumerationAndroid$CaptureFormat> getSupportedFormats(int i) {
        if (cachedSupportedFormats == null) {
            cachedSupportedFormats = new ArrayList();
            for (int i2 = 0; i2 < Camera.getNumberOfCameras(); i2++) {
                cachedSupportedFormats.add(enumerateFormats(i2));
            }
        }
        return cachedSupportedFormats.get(i);
    }
}
