package co.discord.media_engine;

import d0.z.d.m;
import org.webrtc.MediaStreamTrack;
import org.webrtc.VideoCapturer;

/* JADX INFO: compiled from: Connection.kt */
/* JADX INFO: loaded from: classes.dex */
public final class Connection {
    private final long nativeInstance;
    private Connection$UserSpeakingStatusChangedCallback userSpeakingStatusChangedCallback;

    private Connection(long j) {
        this.nativeInstance = j;
    }

    private final native void getStatsNative(Connection$GetStatsCallbackNative callback, int filter);

    public final native void connectUser(long userId, int audioSsrc, int videoSsrc, int rtxSsrc, boolean isMuted, float volume);

    public final native void deafenLocalUser(boolean willBeDeafened);

    public final native void disableVideo(long userId, boolean willBeDisabled);

    public final native void disconnectUser(long userId);

    public final native void dispose();

    public final native void enableDiscontinuousTransmission(boolean enabled);

    public final native void enableForwardErrorCorrection(boolean enabled);

    public final native void getEncryptionModes(Connection$EncryptionModesCallback callback);

    public final long getNativeInstance() {
        return this.nativeInstance;
    }

    public final void getStats(Connection$GetStatsCallback callback) {
        m.checkNotNullParameter(callback, "callback");
        getStatsNative(new Connection$GetStatsCallbackNative(callback), -1);
    }

    public final native void muteLocalUser(boolean willBeMuted);

    public final native void muteUser(long userId, boolean willBeMuted);

    public final native void setAudioInputMode(int mode);

    public final native void setCodecs(AudioEncoder audioEncoder, VideoEncoder videoEncoder, AudioDecoder[] audioDecoders, VideoDecoder[] videoDecoder);

    public final native void setEncodingQuality(int minBitrate, int maxBitrate, int width, int height, int framerate);

    public final native void setEncryptionSettings(EncryptionSettings settings);

    public final native void setExpectedPacketLossRate(float expectedPacketLossRate);

    public final native void setMinimumPlayoutDelay(int delayMs);

    public final native void setOnVideoCallback(Connection$OnVideoCallback callback);

    public final native void setPTTActive(boolean active);

    public final native void setQoS(boolean enabled);

    public final native void setUserPlayoutVolume(long userId, float volume);

    public final void setUserSpeakingStatusChangedCallback(Connection$UserSpeakingStatusChangedCallback callback) {
        m.checkNotNullParameter(callback, "callback");
        this.userSpeakingStatusChangedCallback = callback;
    }

    public final native void setVADAutoThreshold(int autoThreshold);

    public final native void setVADLeadingFramesToBuffer(int numFrames);

    public final native void setVADTrailingFramesToSend(int numFrames);

    public final native void setVADTriggerThreshold(float thresholdDb);

    public final native void setVADUseKrisp(boolean useKrisp);

    public final native void setVideoBroadcast(boolean broadcastVideo);

    public final native void simulatePacketLoss(float packetLossRate);

    public final native void startScreenshareBroadcast(VideoCapturer capturer, long audio);

    public final native void stopScreenshareBroadcast();

    public final void getStats(Connection$GetStatsCallback callback, int filter) {
        m.checkNotNullParameter(callback, "callback");
        getStatsNative(new Connection$GetStatsCallbackNative(callback), filter);
    }
}
