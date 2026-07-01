package co.discord.media_engine;

import co.discord.media_engine.internal.TransformStats;
import d0.z.d.Intrinsics3;
import org.webrtc.MediaStreamTrack;
import org.webrtc.VideoCapturer;

/* JADX INFO: compiled from: Connection.kt */
/* JADX INFO: loaded from: classes.dex */
public final class Connection {
    private final long nativeInstance;
    private UserSpeakingStatusChangedCallback userSpeakingStatusChangedCallback;

    /* JADX INFO: compiled from: Connection.kt */
    public interface EncryptionModesCallback {
        void onEncryptionModes(String[] modes);
    }

    /* JADX INFO: compiled from: Connection.kt */
    public interface GetStatsCallback {
        void onStats(Stats stats);

        void onStatsError(Throwable t);
    }

    /* JADX INFO: compiled from: Connection.kt */
    public static final class GetStatsCallbackNative {
        private final GetStatsCallback callback;

        public GetStatsCallbackNative(GetStatsCallback getStatsCallback) {
            Intrinsics3.checkNotNullParameter(getStatsCallback, "callback");
            this.callback = getStatsCallback;
        }

        public final GetStatsCallback getCallback() {
            return this.callback;
        }

        public final void onStats(String stats) {
            Intrinsics3.checkNotNullParameter(stats, "stats");
            try {
                this.callback.onStats(TransformStats.transform(stats));
            } catch (Exception e) {
                this.callback.onStatsError(e);
            }
        }
    }

    /* JADX INFO: compiled from: Connection.kt */
    public interface OnVideoCallback {
        void onVideo(long userId, int ssrc, String streamIdentifier, StreamParameters[] streams);
    }

    /* JADX INFO: compiled from: Connection.kt */
    public static final class StatsFilter {
        public static final int ALL = -1;
        public static final int INBOUND = 4;
        public static final int OUTBOUND = 2;
        public static final int TRANSPORT = 1;
    }

    /* JADX INFO: compiled from: Connection.kt */
    public interface UserSpeakingStatusChangedCallback {
        void onUserSpeakingStatusChanged(long userId, boolean isUserSpeakingNow, boolean wantsPriority);
    }

    private Connection(long j) {
        this.nativeInstance = j;
    }

    private final native void getStatsNative(GetStatsCallbackNative callback, int filter);

    public final native void connectUser(long userId, int audioSsrc, int videoSsrc, int rtxSsrc, boolean isMuted, float volume);

    public final native void deafenLocalUser(boolean willBeDeafened);

    public final native void disableVideo(long userId, boolean willBeDisabled);

    public final native void disconnectUser(long userId);

    public final native void dispose();

    public final native void enableDiscontinuousTransmission(boolean enabled);

    public final native void enableForwardErrorCorrection(boolean enabled);

    public final native void getEncryptionModes(EncryptionModesCallback callback);

    public final long getNativeInstance() {
        return this.nativeInstance;
    }

    public final void getStats(GetStatsCallback callback) {
        Intrinsics3.checkNotNullParameter(callback, "callback");
        getStatsNative(new GetStatsCallbackNative(callback), -1);
    }

    public final native void muteLocalUser(boolean willBeMuted);

    public final native void muteUser(long userId, boolean willBeMuted);

    public final native void setAudioInputMode(int mode);

    public final native void setCodecs(Codecs3 audioEncoder, Codecs5 videoEncoder, Codecs2[] audioDecoders, Codecs4[] videoDecoder);

    public final native void setEncodingQuality(int minBitrate, int maxBitrate, int width, int height, int framerate);

    public final native void setEncryptionSettings(EncryptionSettings settings);

    public final native void setExpectedPacketLossRate(float expectedPacketLossRate);

    public final native void setMinimumPlayoutDelay(int delayMs);

    public final native void setOnVideoCallback(OnVideoCallback callback);

    public final native void setPTTActive(boolean active);

    public final native void setQoS(boolean enabled);

    public final native void setUserPlayoutVolume(long userId, float volume);

    public final void setUserSpeakingStatusChangedCallback(UserSpeakingStatusChangedCallback callback) {
        Intrinsics3.checkNotNullParameter(callback, "callback");
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

    public final void getStats(GetStatsCallback callback, int filter) {
        Intrinsics3.checkNotNullParameter(callback, "callback");
        getStatsNative(new GetStatsCallbackNative(callback), filter);
    }
}
