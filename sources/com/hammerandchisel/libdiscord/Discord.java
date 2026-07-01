package com.hammerandchisel.libdiscord;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import co.discord.media_engine.CameraEnumeratorProvider;
import co.discord.media_engine.Connection;
import co.discord.media_engine.RtcRegion;
import co.discord.media_engine.SharedEglBaseContext;
import co.discord.media_engine.StreamParameters;
import org.webrtc.EglBase$Context;

/* JADX INFO: loaded from: classes3.dex */
public class Discord {
    public static final int LOGLEVEL_DEBUG = 2;
    public static final int LOGLEVEL_DEFAULT = -1;

    @NonNull
    private static String krispVersion;

    @NonNull
    private Context context;

    @NonNull
    private Discord$LocalVoiceLevelChangedCallback localVoiceLevelChangedCallback;
    private long nativeInstance;

    static {
        System.loadLibrary("discord");
    }

    public Discord(@NonNull Context context, int i) {
        this.context = context;
        krispVersion = context.getString(R$string.krisp_model_version);
        CameraEnumeratorProvider.maybeInit(this.context);
        this.nativeInstance = nativeConstructor(context, SharedEglBaseContext.getEglContext(), i);
    }

    private native long nativeConstructor(@NonNull Context context, @NonNull EglBase$Context eglBase$Context, int i);

    private native void setLocalVoiceLevelChangedCallbackNative(boolean z2);

    @NonNull
    public native Connection connectToServer(int i, long j, @NonNull String str, int i2, @NonNull StreamParameters[] streamParametersArr, @NonNull Discord$ConnectToServerCallback discord$ConnectToServerCallback);

    public native void crash();

    public native void dispose();

    @Deprecated
    public native void enableBuiltInAEC(boolean z2);

    public native void enableBuiltInAEC(boolean z2, @Nullable Discord$BuiltinAECCallback discord$BuiltinAECCallback);

    public native void getAudioInputDevices(@NonNull Discord$GetAudioInputDevicesCallback discord$GetAudioInputDevicesCallback);

    public native void getAudioOutputDevices(@NonNull Discord$GetAudioOutputDevicesCallback discord$GetAudioOutputDevicesCallback);

    public native void getAudioSubsystem(@NonNull Discord$GetAudioSubsystemCallback discord$GetAudioSubsystemCallback);

    public native void getRankedRtcRegions(@NonNull RtcRegion[] rtcRegionArr, @NonNull Discord$GetRankedRtcRegionsCallback discord$GetRankedRtcRegionsCallback);

    public native void getSupportedVideoCodecs(@NonNull Discord$GetSupportedVideoCodecsCallback discord$GetSupportedVideoCodecsCallback);

    public native void getVideoInputDevices(@NonNull Discord$GetVideoInputDevicesCallback discord$GetVideoInputDevicesCallback);

    public native void setAudioInputEnabled(boolean z2);

    public native void setAutomaticGainControl(boolean z2);

    @Deprecated
    public native void setEchoCancellation(boolean z2);

    public native void setEchoCancellation(boolean z2, boolean z3, @Nullable Discord$AecConfigCallback discord$AecConfigCallback);

    public native void setKeepAliveChannel(boolean z2);

    public void setLocalVoiceLevelChangedCallback(@Nullable Discord$LocalVoiceLevelChangedCallback discord$LocalVoiceLevelChangedCallback) {
        this.localVoiceLevelChangedCallback = discord$LocalVoiceLevelChangedCallback;
        setLocalVoiceLevelChangedCallbackNative(discord$LocalVoiceLevelChangedCallback != null);
    }

    public native void setMicVolume(float f);

    public native void setNoAudioInputCallback(@NonNull Discord$NoAudioInputCallback discord$NoAudioInputCallback);

    public native void setNoAudioInputThreshold(float f);

    public native void setNoiseCancellation(boolean z2);

    public native void setNoiseSuppression(boolean z2);

    public native void setPlayoutDevice(int i);

    public native void setRecordingDevice(int i);

    public native void setSpeakerVolume(float f);

    public native void setVideoInputDevice(int i);

    public native void setVideoOutputSink(@NonNull String str, @Nullable Discord$VideoFrameCallback discord$VideoFrameCallback);

    public native void signalVideoOutputSinkReady(@NonNull String str);

    public Discord(@NonNull Context context) {
        this(context, -1);
    }
}
