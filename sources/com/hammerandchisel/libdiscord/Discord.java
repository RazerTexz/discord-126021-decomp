package com.hammerandchisel.libdiscord;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import co.discord.media_engine.CameraEnumeratorProvider;
import co.discord.media_engine.Connection;
import co.discord.media_engine.DeviceDescription;
import co.discord.media_engine.DeviceDescription2;
import co.discord.media_engine.DeviceDescription4;
import co.discord.media_engine.RtcRegion;
import co.discord.media_engine.SharedEglBaseContext;
import co.discord.media_engine.StreamParameters;
import org.webrtc.EglBase;
import org.webrtc.VideoFrame;

/* JADX INFO: loaded from: classes3.dex */
public class Discord {
    public static final int LOGLEVEL_DEBUG = 2;
    public static final int LOGLEVEL_DEFAULT = -1;

    @NonNull
    private static String krispVersion;

    @NonNull
    private Context context;

    @NonNull
    private LocalVoiceLevelChangedCallback localVoiceLevelChangedCallback;
    private long nativeInstance;

    public interface AecConfigCallback {
        void onConfigureAEC(boolean z2, boolean z3, boolean z4, boolean z5, boolean z6);
    }

    public interface BuiltinAECCallback {
        void onConfigureBuiltinAEC(boolean z2, boolean z3, boolean z4);
    }

    public interface ConnectToServerCallback {
        void onConnectToServer(@NonNull ConnectionInfo connectionInfo, @NonNull String str);
    }

    public static class ConnectionInfo {
        public boolean isConnected;

        @NonNull
        public String localAddress;
        public int localPort;

        @NonNull
        public String protocol;

        public ConnectionInfo(boolean z2, @NonNull String str, @NonNull String str2, int i) {
            this.isConnected = z2;
            this.protocol = str;
            this.localAddress = str2;
            this.localPort = i;
        }
    }

    public interface GetAudioInputDevicesCallback {
        void onDevices(@NonNull DeviceDescription[] deviceDescriptionArr);
    }

    public interface GetAudioOutputDevicesCallback {
        void onDevices(@NonNull DeviceDescription2[] deviceDescription2Arr);
    }

    public interface GetAudioSubsystemCallback {
        void onAudioSubsystem(@NonNull String str, @NonNull String str2);
    }

    public interface GetRankedRtcRegionsCallback {
        void onRankedRtcRegions(@NonNull String[] strArr);
    }

    public interface GetSupportedVideoCodecsCallback {
        void onSupportedVideoCodecs(@NonNull String[] strArr);
    }

    public interface GetVideoInputDevicesCallback {
        void onDevices(@NonNull DeviceDescription4[] deviceDescription4Arr);
    }

    public interface LocalVoiceLevelChangedCallback {
        void onLocalVoiceLevelChanged(float f, int i);
    }

    public interface NoAudioInputCallback {
        void onNoAudioInput(boolean z2);
    }

    public interface OnVideoCallback {
        void onVideo(long j, int i, @NonNull String str, @NonNull StreamParameters[] streamParametersArr);
    }

    public interface VideoFrameCallback {
        boolean onFrame(@NonNull VideoFrame videoFrame);
    }

    static {
        System.loadLibrary("discord");
    }

    public Discord(@NonNull Context context, int i) {
        this.context = context;
        krispVersion = context.getString(R.string.krisp_model_version);
        CameraEnumeratorProvider.maybeInit(this.context);
        this.nativeInstance = nativeConstructor(context, SharedEglBaseContext.getEglContext(), i);
    }

    private native long nativeConstructor(@NonNull Context context, @NonNull EglBase.Context context2, int i);

    private native void setLocalVoiceLevelChangedCallbackNative(boolean z2);

    @NonNull
    public native Connection connectToServer(int i, long j, @NonNull String str, int i2, @NonNull StreamParameters[] streamParametersArr, @NonNull ConnectToServerCallback connectToServerCallback);

    public native void crash();

    public native void dispose();

    @Deprecated
    public native void enableBuiltInAEC(boolean z2);

    public native void enableBuiltInAEC(boolean z2, @Nullable BuiltinAECCallback builtinAECCallback);

    public native void getAudioInputDevices(@NonNull GetAudioInputDevicesCallback getAudioInputDevicesCallback);

    public native void getAudioOutputDevices(@NonNull GetAudioOutputDevicesCallback getAudioOutputDevicesCallback);

    public native void getAudioSubsystem(@NonNull GetAudioSubsystemCallback getAudioSubsystemCallback);

    public native void getRankedRtcRegions(@NonNull RtcRegion[] rtcRegionArr, @NonNull GetRankedRtcRegionsCallback getRankedRtcRegionsCallback);

    public native void getSupportedVideoCodecs(@NonNull GetSupportedVideoCodecsCallback getSupportedVideoCodecsCallback);

    public native void getVideoInputDevices(@NonNull GetVideoInputDevicesCallback getVideoInputDevicesCallback);

    public native void setAudioInputEnabled(boolean z2);

    public native void setAutomaticGainControl(boolean z2);

    @Deprecated
    public native void setEchoCancellation(boolean z2);

    public native void setEchoCancellation(boolean z2, boolean z3, @Nullable AecConfigCallback aecConfigCallback);

    public native void setKeepAliveChannel(boolean z2);

    public void setLocalVoiceLevelChangedCallback(@Nullable LocalVoiceLevelChangedCallback localVoiceLevelChangedCallback) {
        this.localVoiceLevelChangedCallback = localVoiceLevelChangedCallback;
        setLocalVoiceLevelChangedCallbackNative(localVoiceLevelChangedCallback != null);
    }

    public native void setMicVolume(float f);

    public native void setNoAudioInputCallback(@NonNull NoAudioInputCallback noAudioInputCallback);

    public native void setNoAudioInputThreshold(float f);

    public native void setNoiseCancellation(boolean z2);

    public native void setNoiseSuppression(boolean z2);

    public native void setPlayoutDevice(int i);

    public native void setRecordingDevice(int i);

    public native void setSpeakerVolume(float f);

    public native void setVideoInputDevice(int i);

    public native void setVideoOutputSink(@NonNull String str, @Nullable VideoFrameCallback videoFrameCallback);

    public native void signalVideoOutputSinkReady(@NonNull String str);

    public Discord(@NonNull Context context) {
        this(context, -1);
    }
}
