package com.discord.p687native.engine;

import com.discord.models.domain.ModelAuditLogEntry;
import org.webrtc.VideoCapturer;

/* JADX INFO: compiled from: NativeConnection.kt */
/* JADX INFO: loaded from: classes.dex */
public final class NativeConnection {
    private final long nativeInstance;

    /* JADX INFO: compiled from: NativeConnection.kt */
    public interface GetEncryptionModesCallback {
        void onEncryptionModes(String[] modes);
    }

    /* JADX INFO: compiled from: NativeConnection.kt */
    public interface GetStatsCallback {
        void onStats(String stats);
    }

    /* JADX INFO: compiled from: NativeConnection.kt */
    public interface OnPingCallback {
        void onPing(int ping, String server, int port, int seq);
    }

    /* JADX INFO: compiled from: NativeConnection.kt */
    public interface OnPingTimeoutCallback {
        void onPingTimeout(String server, int port, int seq, int timeout);
    }

    /* JADX INFO: compiled from: NativeConnection.kt */
    public interface OnSpeakingCallback {
        void onSpeaking(String userId, int speakingFlags);
    }

    /* JADX INFO: compiled from: NativeConnection.kt */
    public interface OnVideoCallback {
        void onVideo(String userId, long ssrc, String streamId, String videoStreamParametersJson);
    }

    private final native void nativeDestroyInstance();

    public final native void configureConnectionRetries(int baseDelayMs, int maxDelayMs, int maxAttempts);

    public final native void destroyUser(String userId);

    public final void dispose() {
        nativeDestroyInstance();
    }

    public final native void getEncryptionModes(GetEncryptionModesCallback callback);

    public final native void getFilteredStats(int filter, GetStatsCallback callback);

    public final native void getStats(GetStatsCallback callback);

    public final native void mergeUsers(String usersJSON);

    public final native void setDesktopSource(String stringId, boolean useVideoHook, String type);

    public final native void setLocalMute(String userId, boolean mute);

    public final native void setLocalPan(String userId, float left, float right);

    public final native void setLocalVolume(String userId, float volume);

    public final native void setMinimumOutputDelay(int delay);

    public final native void setNoInputThreshold(float threshold);

    public final native void setOnPingCallback(OnPingCallback callback);

    public final native void setOnPingTimeoutCallback(OnPingTimeoutCallback callback);

    public final native void setOnSpeakingCallback(OnSpeakingCallback callback);

    public final native void setOnVideoCallback(OnVideoCallback callback);

    public final native void setPTTActive(boolean active, boolean priority);

    public final native void setPingInterval(int pingInterval);

    public final native void setSelfDeafen(boolean deafened);

    public final native void setSelfMute(boolean muted);

    public final native void setTransportOptions(String optionsJSON);

    public final native void setVideoBroadcast(boolean broadcasting);

    public final native void startBroadcast(VideoCapturer capturer, long soundshareNativeInstance);

    public final native void stopBroadcast();
}
