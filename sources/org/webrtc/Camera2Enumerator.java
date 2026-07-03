package org.webrtc;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.os.Build;
import android.os.SystemClock;
import android.util.AndroidException;
import android.util.Range;
import androidx.annotation.Nullable;
import com.discord.utilities.analytics.ChatInputComponentTypes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.webrtc.CameraEnumerationAndroid;
import org.webrtc.CameraVideoCapturer;

/* JADX INFO: loaded from: classes3.dex */
@TargetApi(21)
public class Camera2Enumerator implements CameraEnumerator {
    private static final double NANO_SECONDS_PER_SECOND = 1.0E9d;
    private static final String TAG = "Camera2Enumerator";
    private static final Map<String, List<CameraEnumerationAndroid.CaptureFormat>> cachedSupportedFormats = new HashMap();

    @Nullable
    public final CameraManager cameraManager;
    public final Context context;

    public Camera2Enumerator(Context context) {
        this.context = context;
        this.cameraManager = (CameraManager) context.getSystemService(ChatInputComponentTypes.CAMERA);
    }

    public static List<CameraEnumerationAndroid.CaptureFormat.FramerateRange> convertFramerates(Range<Integer>[] rangeArr, int i) {
        ArrayList arrayList = new ArrayList();
        for (Range<Integer> range : rangeArr) {
            arrayList.add(new CameraEnumerationAndroid.CaptureFormat.FramerateRange(((Integer) range.getLower()).intValue() * i, ((Integer) range.getUpper()).intValue() * i));
        }
        return arrayList;
    }

    private static List<Size> convertSizes(@Nullable android.util.Size[] sizeArr) {
        ArrayList arrayList = new ArrayList();
        if (sizeArr != null) {
            for (android.util.Size size : sizeArr) {
                arrayList.add(new Size(size.getWidth(), size.getHeight()));
            }
        }
        return arrayList;
    }

    @Nullable
    private CameraCharacteristics getCameraCharacteristics(String str) {
        try {
            return this.cameraManager.getCameraCharacteristics(str);
        } catch (AndroidException e) {
            Logging.m11028e(TAG, "Camera access exception: " + e);
            return null;
        }
    }

    public static int getFpsUnitFactor(Range<Integer>[] rangeArr) {
        return (rangeArr.length != 0 && ((Integer) rangeArr[0].getUpper()).intValue() >= 1000) ? 1 : 1000;
    }

    public static List<Size> getSupportedSizes(CameraCharacteristics cameraCharacteristics) {
        StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) cameraCharacteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
        int iIntValue = ((Integer) cameraCharacteristics.get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL)).intValue();
        List<Size> listConvertSizes = convertSizes(streamConfigurationMap.getOutputSizes(SurfaceTexture.class));
        if (Build.VERSION.SDK_INT >= 22 || iIntValue != 2) {
            return listConvertSizes;
        }
        Rect rect = (Rect) cameraCharacteristics.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
        ArrayList arrayList = new ArrayList();
        for (Size size : listConvertSizes) {
            if (rect.width() * size.height == rect.height() * size.width) {
                arrayList.add(size);
            }
        }
        return arrayList;
    }

    public static boolean isSupported(Context context) {
        CameraManager cameraManager = (CameraManager) context.getSystemService(ChatInputComponentTypes.CAMERA);
        try {
            for (String str : cameraManager.getCameraIdList()) {
                CameraCharacteristics cameraCharacteristics = cameraManager.getCameraCharacteristics(str);
                if (((Integer) cameraCharacteristics.get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL)).intValue() == 2 || getSupportedSizes(cameraCharacteristics).isEmpty()) {
                    return false;
                }
            }
            return true;
        } catch (AndroidException e) {
            Logging.m11028e(TAG, "Camera access exception: " + e);
            return false;
        } catch (Throwable th) {
            Logging.m11028e(TAG, "Uncaught camera exception: " + th);
            return false;
        }
    }

    @Override // org.webrtc.CameraEnumerator
    public CameraVideoCapturer createCapturer(String str, CameraVideoCapturer.CameraEventsHandler cameraEventsHandler) {
        return new Camera2Capturer(this.context, str, cameraEventsHandler);
    }

    @Override // org.webrtc.CameraEnumerator
    public String[] getDeviceNames() {
        try {
            return this.cameraManager.getCameraIdList();
        } catch (AndroidException e) {
            Logging.m11028e(TAG, "Camera access exception: " + e);
            return new String[0];
        }
    }

    @Override // org.webrtc.CameraEnumerator
    @Nullable
    public List<CameraEnumerationAndroid.CaptureFormat> getSupportedFormats(String str) {
        return getSupportedFormats(this.context, str);
    }

    @Override // org.webrtc.CameraEnumerator
    public boolean isBackFacing(String str) {
        CameraCharacteristics cameraCharacteristics = getCameraCharacteristics(str);
        return cameraCharacteristics != null && ((Integer) cameraCharacteristics.get(CameraCharacteristics.LENS_FACING)).intValue() == 1;
    }

    @Override // org.webrtc.CameraEnumerator
    public boolean isFrontFacing(String str) {
        CameraCharacteristics cameraCharacteristics = getCameraCharacteristics(str);
        return cameraCharacteristics != null && ((Integer) cameraCharacteristics.get(CameraCharacteristics.LENS_FACING)).intValue() == 0;
    }

    @Nullable
    public static List<CameraEnumerationAndroid.CaptureFormat> getSupportedFormats(Context context, String str) {
        return getSupportedFormats((CameraManager) context.getSystemService(ChatInputComponentTypes.CAMERA), str);
    }

    @Nullable
    public static List<CameraEnumerationAndroid.CaptureFormat> getSupportedFormats(CameraManager cameraManager, String str) {
        long outputMinFrameDuration;
        Map<String, List<CameraEnumerationAndroid.CaptureFormat>> map = cachedSupportedFormats;
        synchronized (map) {
            if (map.containsKey(str)) {
                return map.get(str);
            }
            Logging.m11027d(TAG, "Get supported formats for camera index " + str + ".");
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            try {
                CameraCharacteristics cameraCharacteristics = cameraManager.getCameraCharacteristics(str);
                StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) cameraCharacteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
                Range[] rangeArr = (Range[]) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES);
                List<CameraEnumerationAndroid.CaptureFormat.FramerateRange> listConvertFramerates = convertFramerates(rangeArr, getFpsUnitFactor(rangeArr));
                List<Size> supportedSizes = getSupportedSizes(cameraCharacteristics);
                Iterator<CameraEnumerationAndroid.CaptureFormat.FramerateRange> it = listConvertFramerates.iterator();
                int iMax = 0;
                while (it.hasNext()) {
                    iMax = Math.max(iMax, it.next().max);
                }
                ArrayList arrayList = new ArrayList();
                for (Size size : supportedSizes) {
                    try {
                        outputMinFrameDuration = streamConfigurationMap.getOutputMinFrameDuration(SurfaceTexture.class, new android.util.Size(size.width, size.height));
                    } catch (Exception unused) {
                        outputMinFrameDuration = 0;
                    }
                    int iRound = outputMinFrameDuration == 0 ? iMax : ((int) Math.round(NANO_SECONDS_PER_SECOND / outputMinFrameDuration)) * 1000;
                    arrayList.add(new CameraEnumerationAndroid.CaptureFormat(size.width, size.height, 0, iRound));
                    Logging.m11027d(TAG, "Format: " + size.width + "x" + size.height + "@" + iRound);
                }
                cachedSupportedFormats.put(str, arrayList);
                Logging.m11027d(TAG, "Get supported formats for camera index " + str + " done. Time spent: " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms.");
                return arrayList;
            } catch (Exception e) {
                Logging.m11028e(TAG, "getCameraCharacteristics(): " + e);
                return new ArrayList();
            }
        }
    }
}
