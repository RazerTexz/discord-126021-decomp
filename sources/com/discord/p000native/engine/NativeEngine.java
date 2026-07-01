package com.discord.p000native.engine;

import android.content.Context;
import co.discord.media_engine.CameraEnumeratorProvider;
import co.discord.media_engine.SharedEglBaseContext;
import d0.z.d.Intrinsics3;
import org.webrtc.EglBase;
import org.webrtc.VideoFrame;

/* JADX INFO: compiled from: NativeEngine.kt */
/* JADX INFO: loaded from: classes.dex */
public final class NativeEngine {
    public static final int LOGLEVEL_DEBUG = 2;
    public static final int LOGLEVEL_DEFAULT = -1;
    private final int logLevel;
    private final long nativeInstance;

    /* JADX INFO: compiled from: NativeEngine.kt */
    public interface ConnectToServerCallback {
        void onConnectToServer(ConnectionInfo info, String error);
    }

    /* JADX INFO: compiled from: NativeEngine.kt */
    public interface DeviceChangeCallback {
        void onChange(AudioInputDeviceDescription[] audioInputDevices, AudioOutputDeviceDescription[] audioOutputDevices, VideoInputDeviceDescription[] videoInputDevices);
    }

    /* JADX INFO: compiled from: NativeEngine.kt */
    public interface GetAudioInputDevicesCallback {
        void onDevices(AudioInputDeviceDescription[] devices);
    }

    /* JADX INFO: compiled from: NativeEngine.kt */
    public interface GetAudioOutputDevicesCallback {
        void onDevices(AudioOutputDeviceDescription[] devices);
    }

    /* JADX INFO: compiled from: NativeEngine.kt */
    public interface GetAudioSubsystemCallback {
        void onAudioSubsystem(String subsystem, String audioLayer);
    }

    /* JADX INFO: compiled from: NativeEngine.kt */
    public interface GetRankedRtcRegionsCallback {
        void onRankedRtcRegions(String[] regions);
    }

    /* JADX INFO: compiled from: NativeEngine.kt */
    public interface GetSupportedVideoCodecsCallback {
        void onSupportedVideoCodecs(String[] codecs);
    }

    /* JADX INFO: compiled from: NativeEngine.kt */
    public interface GetVideoInputDevicesCallback {
        void onDevices(VideoInputDeviceDescription[] devices);
    }

    /* JADX INFO: compiled from: NativeEngine.kt */
    public interface OnNoInputCallback {
        void onNoInput(boolean input);
    }

    /* JADX INFO: compiled from: NativeEngine.kt */
    public interface OnVoiceCallback {
        void onVoice(float level, int speaking);
    }

    /* JADX INFO: compiled from: NativeEngine.kt */
    public interface VideoFrameCallback {
        boolean onFrame(VideoFrame frame);
    }

    static {
        System.loadLibrary("discord");
    }

    public NativeEngine(Context context, int i) {
        Intrinsics3.checkNotNullParameter(context, "context");
        this.logLevel = i;
        Context applicationContext = context.getApplicationContext();
        Intrinsics3.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
        CameraEnumeratorProvider.maybeInit(applicationContext);
        Context applicationContext2 = context.getApplicationContext();
        Intrinsics3.checkNotNullExpressionValue(applicationContext2, "context.applicationContext");
        EglBase.Context eglContext = SharedEglBaseContext.getEglContext();
        Intrinsics3.checkNotNullExpressionValue(eglContext, "SharedEglBaseContext.getEglContext()");
        this.nativeInstance = nativeCreateInstance(applicationContext2, eglContext, i);
    }

    private final native long nativeCreateInstance(Context context, EglBase.Context eglContext, int logLevel);

    private final native void nativeDestroyInstance();

    public final native NativeConnection createVoiceConnection(long ssrc, String userId, String serverIp, int port, String experimentsJSON, String streamParametersJSON, ConnectToServerCallback callback);

    public final void dispose() {
        nativeDestroyInstance();
    }

    public final native void enableBuiltInAEC(boolean enable);

    public final native void getAudioSubsystem(GetAudioSubsystemCallback callback);

    public final native void getInputDevices(GetAudioInputDevicesCallback callback);

    public final native void getOutputDevices(GetAudioOutputDevicesCallback callback);

    public final native void getSupportedVideoCodecs(GetSupportedVideoCodecsCallback callback);

    public final native void getVideoInputDevices(GetVideoInputDevicesCallback callback);

    public final native void rankRtcRegions(String regionsWithIpsJSON, GetRankedRtcRegionsCallback callback);

    public final native void setAudioInputEnabled(boolean enable);

    public final native void setEmitVADLevel(boolean enable, boolean playback, String optionsJSON);

    public final native void setInputDevice(String deviceIndex);

    public final native void setInputDeviceIndex(int deviceIndex);

    public final native void setInputVolume(float volume);

    public final native void setNoInputThreshold(float threshold);

    public final native void setOnDeviceChangeCallback(DeviceChangeCallback callback);

    public final native void setOnNoInputCallback(OnNoInputCallback callback);

    public final native void setOnVoiceCallback(OnVoiceCallback callback);

    public final native void setOutputDevice(String deviceIndex);

    public final native void setOutputDeviceIndex(int deviceIndex);

    public final native void setOutputVolume(float volume);

    public final native void setTransportOptions(String optionsJSON);

    public final native void setVideoInputDevice(String deviceIndex);

    public final native void setVideoInputDeviceIndex(int deviceIndex);

    public final native void setVideoOutputSink(String streamIdentifier, VideoFrameCallback callback);
}
