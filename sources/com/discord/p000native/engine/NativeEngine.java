package com.discord.p000native.engine;

import android.content.Context;
import co.discord.media_engine.CameraEnumeratorProvider;
import co.discord.media_engine.SharedEglBaseContext;
import d0.z.d.m;
import org.webrtc.EglBase$Context;

/* JADX INFO: compiled from: NativeEngine.kt */
/* JADX INFO: loaded from: classes.dex */
public final class NativeEngine {
    public static final NativeEngine$Companion Companion = new NativeEngine$Companion(null);
    public static final int LOGLEVEL_DEBUG = 2;
    public static final int LOGLEVEL_DEFAULT = -1;
    private final int logLevel;
    private final long nativeInstance;

    static {
        System.loadLibrary("discord");
    }

    public NativeEngine(Context context, int i) {
        m.checkNotNullParameter(context, "context");
        this.logLevel = i;
        Context applicationContext = context.getApplicationContext();
        m.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
        CameraEnumeratorProvider.maybeInit(applicationContext);
        Context applicationContext2 = context.getApplicationContext();
        m.checkNotNullExpressionValue(applicationContext2, "context.applicationContext");
        EglBase$Context eglContext = SharedEglBaseContext.getEglContext();
        m.checkNotNullExpressionValue(eglContext, "SharedEglBaseContext.getEglContext()");
        this.nativeInstance = nativeCreateInstance(applicationContext2, eglContext, i);
    }

    private final native long nativeCreateInstance(Context context, EglBase$Context eglContext, int logLevel);

    private final native void nativeDestroyInstance();

    public final native NativeConnection createVoiceConnection(long ssrc, String userId, String serverIp, int port, String experimentsJSON, String streamParametersJSON, NativeEngine$ConnectToServerCallback callback);

    public final void dispose() {
        nativeDestroyInstance();
    }

    public final native void enableBuiltInAEC(boolean enable);

    public final native void getAudioSubsystem(NativeEngine$GetAudioSubsystemCallback callback);

    public final native void getInputDevices(NativeEngine$GetAudioInputDevicesCallback callback);

    public final native void getOutputDevices(NativeEngine$GetAudioOutputDevicesCallback callback);

    public final native void getSupportedVideoCodecs(NativeEngine$GetSupportedVideoCodecsCallback callback);

    public final native void getVideoInputDevices(NativeEngine$GetVideoInputDevicesCallback callback);

    public final native void rankRtcRegions(String regionsWithIpsJSON, NativeEngine$GetRankedRtcRegionsCallback callback);

    public final native void setAudioInputEnabled(boolean enable);

    public final native void setEmitVADLevel(boolean enable, boolean playback, String optionsJSON);

    public final native void setInputDevice(String deviceIndex);

    public final native void setInputDeviceIndex(int deviceIndex);

    public final native void setInputVolume(float volume);

    public final native void setNoInputThreshold(float threshold);

    public final native void setOnDeviceChangeCallback(NativeEngine$DeviceChangeCallback callback);

    public final native void setOnNoInputCallback(NativeEngine$OnNoInputCallback callback);

    public final native void setOnVoiceCallback(NativeEngine$OnVoiceCallback callback);

    public final native void setOutputDevice(String deviceIndex);

    public final native void setOutputDeviceIndex(int deviceIndex);

    public final native void setOutputVolume(float volume);

    public final native void setTransportOptions(String optionsJSON);

    public final native void setVideoInputDevice(String deviceIndex);

    public final native void setVideoInputDeviceIndex(int deviceIndex);

    public final native void setVideoOutputSink(String streamIdentifier, NativeEngine$VideoFrameCallback callback);
}
