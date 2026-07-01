package org.webrtc.voiceengine;

import android.annotation.TargetApi;
import android.media.AudioAttributes$Builder;
import android.media.AudioFormat$Builder;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.os.Build$VERSION;
import androidx.annotation.Nullable;
import b.d.b.a.a;
import java.nio.ByteBuffer;
import org.webrtc.ContextUtils;
import org.webrtc.Logging;
import org.webrtc.MediaStreamTrack;
import org.webrtc.ThreadUtils;
import org.webrtc.ThreadUtils$ThreadChecker;

/* JADX INFO: loaded from: classes3.dex */
public class WebRtcAudioTrack {
    private static final long AUDIO_TRACK_THREAD_JOIN_TIMEOUT_MS = 2000;
    private static final int BITS_PER_SAMPLE = 16;
    private static final int BUFFERS_PER_SECOND = 100;
    private static final int CALLBACK_BUFFER_SIZE_MS = 10;
    private static final boolean DEBUG = false;
    private static final int DEFAULT_USAGE;
    private static final String TAG = "WebRtcAudioTrack";

    @Nullable
    private static WebRtcAudioTrack$ErrorCallback errorCallback;

    @Nullable
    private static WebRtcAudioTrack$WebRtcAudioTrackErrorCallback errorCallbackOld;
    private static volatile boolean speakerMute;
    private static int usageAttribute;
    private final AudioManager audioManager;

    @Nullable
    private WebRtcAudioTrack$AudioTrackThread audioThread;

    @Nullable
    private AudioTrack audioTrack;
    private ByteBuffer byteBuffer;
    private byte[] emptyBytes;
    private final long nativeAudioTrack;
    private final ThreadUtils$ThreadChecker threadChecker;
    private final boolean useMediaTrack;

    static {
        int defaultUsageAttribute = getDefaultUsageAttribute();
        DEFAULT_USAGE = defaultUsageAttribute;
        usageAttribute = defaultUsageAttribute;
    }

    public WebRtcAudioTrack(long j, boolean z2) {
        ThreadUtils$ThreadChecker threadUtils$ThreadChecker = new ThreadUtils$ThreadChecker();
        this.threadChecker = threadUtils$ThreadChecker;
        threadUtils$ThreadChecker.checkIsOnValidThread();
        Logging.d(TAG, "ctor" + WebRtcAudioUtils.getThreadInfo());
        this.nativeAudioTrack = j;
        this.useMediaTrack = z2;
        this.audioManager = (AudioManager) ContextUtils.getApplicationContext().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
    }

    public static /* synthetic */ AudioTrack access$000(WebRtcAudioTrack webRtcAudioTrack) {
        return webRtcAudioTrack.audioTrack;
    }

    public static /* synthetic */ void access$100(boolean z2) {
        assertTrue(z2);
    }

    public static /* synthetic */ ByteBuffer access$200(WebRtcAudioTrack webRtcAudioTrack) {
        return webRtcAudioTrack.byteBuffer;
    }

    public static /* synthetic */ long access$300(WebRtcAudioTrack webRtcAudioTrack) {
        return webRtcAudioTrack.nativeAudioTrack;
    }

    public static /* synthetic */ void access$400(WebRtcAudioTrack webRtcAudioTrack, int i, long j) {
        webRtcAudioTrack.nativeGetPlayoutData(i, j);
    }

    public static /* synthetic */ boolean access$500() {
        return speakerMute;
    }

    public static /* synthetic */ byte[] access$600(WebRtcAudioTrack webRtcAudioTrack) {
        return webRtcAudioTrack.emptyBytes;
    }

    public static /* synthetic */ void access$700(WebRtcAudioTrack webRtcAudioTrack, String str) {
        webRtcAudioTrack.reportWebRtcAudioTrackError(str);
    }

    private static void assertTrue(boolean z2) {
        if (!z2) {
            throw new AssertionError("Expected condition to be true");
        }
    }

    private int channelCountToConfiguration(int i) {
        return i == 1 ? 4 : 12;
    }

    @TargetApi(21)
    private static AudioTrack createAudioTrackOnLollipopOrHigher(int i, int i2, int i3, boolean z2) {
        Logging.d(TAG, "createAudioTrackOnLollipopOrHigher");
        int nativeOutputSampleRate = AudioTrack.getNativeOutputSampleRate(getAudioManagerStreamType(z2));
        Logging.d(TAG, "nativeOutputSampleRate: " + nativeOutputSampleRate);
        if (i != nativeOutputSampleRate) {
            Logging.w(TAG, "Unable to use fast mode since requested sample rate is not native");
        }
        if (usageAttribute != DEFAULT_USAGE) {
            StringBuilder sbU = a.U("A non default usage attribute is used: ");
            sbU.append(usageAttribute);
            Logging.w(TAG, sbU.toString());
        }
        return new AudioTrack(new AudioAttributes$Builder().setUsage(z2 ? 1 : usageAttribute).setContentType(z2 ? 2 : 1).build(), new AudioFormat$Builder().setEncoding(2).setSampleRate(i).setChannelMask(i2).build(), i3, 1, 0);
    }

    private static AudioTrack createAudioTrackOnLowerThanLollipop(int i, int i2, int i3) {
        return new AudioTrack(0, i, i2, 2, i3, 1);
    }

    private int getAudioManagerStreamType() {
        return getAudioManagerStreamType(this.useMediaTrack);
    }

    private static int getAudioManagerStreamType(boolean z2) {
        return z2 ? 3 : 0;
    }

    private int getBufferSizeInFrames() {
        if (Build$VERSION.SDK_INT >= 23) {
            return this.audioTrack.getBufferSizeInFrames();
        }
        return -1;
    }

    private static int getDefaultUsageAttribute() {
        return 2;
    }

    private int getStreamMaxVolume() {
        this.threadChecker.checkIsOnValidThread();
        Logging.d(TAG, "getStreamMaxVolume");
        assertTrue(this.audioManager != null);
        return this.audioManager.getStreamMaxVolume(getAudioManagerStreamType());
    }

    private int getStreamVolume() {
        this.threadChecker.checkIsOnValidThread();
        Logging.d(TAG, "getStreamVolume");
        assertTrue(this.audioManager != null);
        return this.audioManager.getStreamVolume(getAudioManagerStreamType());
    }

    private int initPlayout(int i, int i2, double d) {
        this.threadChecker.checkIsOnValidThread();
        Logging.d(TAG, "initPlayout(sampleRate=" + i + ", channels=" + i2 + ", bufferSizeFactor=" + d + ")");
        this.byteBuffer = ByteBuffer.allocateDirect((i / 100) * i2 * 2);
        StringBuilder sbU = a.U("byteBuffer.capacity: ");
        sbU.append(this.byteBuffer.capacity());
        Logging.d(TAG, sbU.toString());
        this.emptyBytes = new byte[this.byteBuffer.capacity()];
        nativeCacheDirectBufferAddress(this.byteBuffer, this.nativeAudioTrack);
        int iChannelCountToConfiguration = channelCountToConfiguration(i2);
        int minBufferSize = (int) (((double) AudioTrack.getMinBufferSize(i, iChannelCountToConfiguration, 2)) * d);
        Logging.d(TAG, "minBufferSizeInBytes: " + minBufferSize);
        if (minBufferSize < this.byteBuffer.capacity()) {
            reportWebRtcAudioTrackInitError("AudioTrack.getMinBufferSize returns an invalid value.");
            return -1;
        }
        if (this.audioTrack != null) {
            reportWebRtcAudioTrackInitError("Conflict with existing AudioTrack.");
            return -1;
        }
        try {
            AudioTrack audioTrackCreateAudioTrackOnLollipopOrHigher = createAudioTrackOnLollipopOrHigher(i, iChannelCountToConfiguration, minBufferSize, this.useMediaTrack);
            this.audioTrack = audioTrackCreateAudioTrackOnLollipopOrHigher;
            if (audioTrackCreateAudioTrackOnLollipopOrHigher == null || audioTrackCreateAudioTrackOnLollipopOrHigher.getState() != 1) {
                reportWebRtcAudioTrackInitError("Initialization of audio track failed.");
                releaseAudioResources();
                return -1;
            }
            logMainParameters();
            logMainParametersExtended();
            return minBufferSize;
        } catch (IllegalArgumentException e) {
            reportWebRtcAudioTrackInitError(e.getMessage());
            releaseAudioResources();
            return -1;
        }
    }

    private boolean isVolumeFixed() {
        return this.audioManager.isVolumeFixed();
    }

    private void logBufferCapacityInFrames() {
        if (Build$VERSION.SDK_INT >= 24) {
            StringBuilder sbU = a.U("AudioTrack: buffer capacity in frames: ");
            sbU.append(this.audioTrack.getBufferCapacityInFrames());
            Logging.d(TAG, sbU.toString());
        }
    }

    private void logBufferSizeInFrames() {
        if (Build$VERSION.SDK_INT >= 23) {
            StringBuilder sbU = a.U("AudioTrack: buffer size in frames: ");
            sbU.append(this.audioTrack.getBufferSizeInFrames());
            Logging.d(TAG, sbU.toString());
        }
    }

    private void logMainParameters() {
        StringBuilder sbU = a.U("AudioTrack: session ID: ");
        sbU.append(this.audioTrack.getAudioSessionId());
        sbU.append(", channels: ");
        sbU.append(this.audioTrack.getChannelCount());
        sbU.append(", sample rate: ");
        sbU.append(this.audioTrack.getSampleRate());
        sbU.append(", max gain: ");
        sbU.append(AudioTrack.getMaxVolume());
        Logging.d(TAG, sbU.toString());
    }

    private void logMainParametersExtended() {
        logBufferSizeInFrames();
        logBufferCapacityInFrames();
    }

    private void logUnderrunCount() {
        if (Build$VERSION.SDK_INT >= 24) {
            StringBuilder sbU = a.U("underrun count: ");
            sbU.append(this.audioTrack.getUnderrunCount());
            Logging.d(TAG, sbU.toString());
        }
    }

    private native void nativeCacheDirectBufferAddress(ByteBuffer byteBuffer, long j);

    private native void nativeGetPlayoutData(int i, long j);

    private void releaseAudioResources() {
        Logging.d(TAG, "releaseAudioResources");
        AudioTrack audioTrack = this.audioTrack;
        if (audioTrack != null) {
            audioTrack.release();
            this.audioTrack = null;
        }
    }

    private void reportWebRtcAudioTrackError(String str) {
        Logging.e(TAG, "Run-time playback error: " + str);
        WebRtcAudioUtils.logAudioState(TAG);
        WebRtcAudioTrack$WebRtcAudioTrackErrorCallback webRtcAudioTrack$WebRtcAudioTrackErrorCallback = errorCallbackOld;
        if (webRtcAudioTrack$WebRtcAudioTrackErrorCallback != null) {
            webRtcAudioTrack$WebRtcAudioTrackErrorCallback.onWebRtcAudioTrackError(str);
        }
        WebRtcAudioTrack$ErrorCallback webRtcAudioTrack$ErrorCallback = errorCallback;
        if (webRtcAudioTrack$ErrorCallback != null) {
            webRtcAudioTrack$ErrorCallback.onWebRtcAudioTrackError(str);
        }
    }

    private void reportWebRtcAudioTrackInitError(String str) {
        Logging.e(TAG, "Init playout error: " + str);
        WebRtcAudioUtils.logAudioState(TAG);
        WebRtcAudioTrack$WebRtcAudioTrackErrorCallback webRtcAudioTrack$WebRtcAudioTrackErrorCallback = errorCallbackOld;
        if (webRtcAudioTrack$WebRtcAudioTrackErrorCallback != null) {
            webRtcAudioTrack$WebRtcAudioTrackErrorCallback.onWebRtcAudioTrackInitError(str);
        }
        WebRtcAudioTrack$ErrorCallback webRtcAudioTrack$ErrorCallback = errorCallback;
        if (webRtcAudioTrack$ErrorCallback != null) {
            webRtcAudioTrack$ErrorCallback.onWebRtcAudioTrackInitError(str);
        }
    }

    private void reportWebRtcAudioTrackStartError(WebRtcAudioTrack$AudioTrackStartErrorCode webRtcAudioTrack$AudioTrackStartErrorCode, String str) {
        Logging.e(TAG, "Start playout error: " + webRtcAudioTrack$AudioTrackStartErrorCode + ". " + str);
        WebRtcAudioUtils.logAudioState(TAG);
        WebRtcAudioTrack$WebRtcAudioTrackErrorCallback webRtcAudioTrack$WebRtcAudioTrackErrorCallback = errorCallbackOld;
        if (webRtcAudioTrack$WebRtcAudioTrackErrorCallback != null) {
            webRtcAudioTrack$WebRtcAudioTrackErrorCallback.onWebRtcAudioTrackStartError(str);
        }
        WebRtcAudioTrack$ErrorCallback webRtcAudioTrack$ErrorCallback = errorCallback;
        if (webRtcAudioTrack$ErrorCallback != null) {
            webRtcAudioTrack$ErrorCallback.onWebRtcAudioTrackStartError(webRtcAudioTrack$AudioTrackStartErrorCode, str);
        }
    }

    public static synchronized void setAudioTrackUsageAttribute(int i) {
        Logging.w(TAG, "Default usage attribute is changed from: " + DEFAULT_USAGE + " to " + i);
        usageAttribute = i;
    }

    @Deprecated
    public static void setErrorCallback(WebRtcAudioTrack$WebRtcAudioTrackErrorCallback webRtcAudioTrack$WebRtcAudioTrackErrorCallback) {
        Logging.d(TAG, "Set error callback (deprecated");
        errorCallbackOld = webRtcAudioTrack$WebRtcAudioTrackErrorCallback;
    }

    public static void setSpeakerMute(boolean z2) {
        Logging.w(TAG, "setSpeakerMute(" + z2 + ")");
        speakerMute = z2;
    }

    private boolean setStreamVolume(int i) {
        this.threadChecker.checkIsOnValidThread();
        Logging.d(TAG, "setStreamVolume(" + i + ")");
        assertTrue(this.audioManager != null);
        if (isVolumeFixed()) {
            Logging.e(TAG, "The device implements a fixed volume policy.");
            return false;
        }
        this.audioManager.setStreamVolume(getAudioManagerStreamType(), i, 0);
        return true;
    }

    private boolean startPlayout() {
        try {
            this.threadChecker.checkIsOnValidThread();
            Logging.d(TAG, "startPlayout");
            try {
                assertTrue(this.audioTrack != null);
                try {
                    assertTrue(this.audioThread == null);
                    try {
                        this.audioTrack.play();
                        if (this.audioTrack.getPlayState() == 3) {
                            WebRtcAudioTrack$AudioTrackThread webRtcAudioTrack$AudioTrackThread = new WebRtcAudioTrack$AudioTrackThread(this, "AudioTrackJavaThread");
                            this.audioThread = webRtcAudioTrack$AudioTrackThread;
                            webRtcAudioTrack$AudioTrackThread.start();
                            return true;
                        }
                        reportWebRtcAudioTrackStartError(WebRtcAudioTrack$AudioTrackStartErrorCode.AUDIO_TRACK_START_STATE_MISMATCH, "AudioTrack.play failed - incorrect state :" + this.audioTrack.getPlayState());
                        releaseAudioResources();
                        return false;
                    } catch (IllegalStateException e) {
                        reportWebRtcAudioTrackStartError(WebRtcAudioTrack$AudioTrackStartErrorCode.AUDIO_TRACK_START_EXCEPTION, "AudioTrack.play failed: " + e.getMessage());
                        releaseAudioResources();
                        return false;
                    }
                } catch (Throwable th) {
                    Logging.e(TAG, "startPlayout: audioThread != null!", th);
                    throw th;
                }
            } catch (Throwable th2) {
                Logging.e(TAG, "startPlayout: audioTrack == null!", th2);
                throw th2;
            }
        } catch (Throwable th3) {
            Logging.e(TAG, "WebRtcAudioTrack.startPlayout fail hard!", th3);
            throw th3;
        }
    }

    private boolean stopPlayout() {
        this.threadChecker.checkIsOnValidThread();
        Logging.d(TAG, "stopPlayout");
        assertTrue(this.audioThread != null);
        logUnderrunCount();
        this.audioThread.stopThread();
        Logging.d(TAG, "Stopping the AudioTrackThread...");
        this.audioThread.interrupt();
        if (!ThreadUtils.joinUninterruptibly(this.audioThread, AUDIO_TRACK_THREAD_JOIN_TIMEOUT_MS)) {
            Logging.e(TAG, "Join of AudioTrackThread timed out.");
            WebRtcAudioUtils.logAudioState(TAG);
        }
        Logging.d(TAG, "AudioTrackThread has now been stopped.");
        this.audioThread = null;
        releaseAudioResources();
        return true;
    }

    public static void setErrorCallback(WebRtcAudioTrack$ErrorCallback webRtcAudioTrack$ErrorCallback) {
        Logging.d(TAG, "Set extended error callback");
        errorCallback = webRtcAudioTrack$ErrorCallback;
    }
}
