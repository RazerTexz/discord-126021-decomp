package co.discord.media_engine;

import android.media.AudioRecord;
import android.util.Log;
import b.d.b.a.a;
import d0.z.d.m;
import java.nio.ByteBuffer;
import org.webrtc.ThreadUtils;
import org.webrtc.TimestampAligner;

/* JADX INFO: compiled from: SoundshareAudioSource.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SoundshareAudioSource {
    private static final long AUDIO_RECORD_THREAD_JOIN_TIMEOUT_MS = 2000;
    private static final int BITS_PER_SAMPLE = 16;
    private static final int BUFFERS_PER_SECOND = 100;
    private static final int BUFFER_SIZE_FACTOR = 2;
    private static final int CALLBACK_BUFFER_SIZE_MS = 10;
    public static final SoundshareAudioSource$Companion Companion = new SoundshareAudioSource$Companion(null);
    private static final String TAG = "SoundshareAudioSource";
    private static volatile boolean microphoneMute;
    private AudioRecord audioRecord;
    private SoundshareAudioSource$AudioRecordThread audioThread;
    private ByteBuffer byteBuffer;
    private final long nativeInstance = nativeCreateInstance();
    private boolean released;

    public static final /* synthetic */ void access$dataIsRecorded(SoundshareAudioSource soundshareAudioSource, int i, long j) {
        soundshareAudioSource.dataIsRecorded(i, j);
    }

    public static final /* synthetic */ boolean access$getMicrophoneMute$cp() {
        return microphoneMute;
    }

    public static final /* synthetic */ void access$reportSoundshareAudioSourceError(SoundshareAudioSource soundshareAudioSource, String str) {
        soundshareAudioSource.reportSoundshareAudioSourceError(str);
    }

    public static final /* synthetic */ void access$setMicrophoneMute$cp(boolean z2) {
        microphoneMute = z2;
    }

    private final int channelCountToConfiguration(int channels) {
        return channels == 1 ? 16 : 12;
    }

    private final synchronized void dataIsRecorded(int bytes, long timestampNanos) {
        if (!this.released) {
            nativeDataIsRecorded(this.nativeInstance, bytes, timestampNanos);
        }
    }

    private final native synchronized void nativeCacheDirectBufferAddress(long nativeInstance, ByteBuffer byteBuffer);

    private final native synchronized long nativeCreateInstance();

    private final native void nativeDataIsRecorded(long nativeInstance, int bytes, long timestampNanos);

    private final native synchronized void nativeDestroyInstance(long nativeInstance);

    private final native void nativeSetSampleFormat(long nativeInstance, int sampleRate, int bitDepth, int channels);

    private final void reportSoundshareAudioSourceError(String errorMessage) {
        Log.e(TAG, "Run-time recording error: " + errorMessage);
    }

    private final void reportSoundshareAudioSourceInitError(String errorMessage) {
        Log.e(TAG, "Init recording error: " + errorMessage);
    }

    private final void reportSoundshareAudioSourceStartError(String errorMessage) {
        Log.e(TAG, "Start recording error: " + errorMessage);
    }

    public final long getNativeInstance() {
        return this.nativeInstance;
    }

    public final synchronized void release() {
        if (!this.released) {
            AudioRecord audioRecord = this.audioRecord;
            if (audioRecord != null) {
                audioRecord.release();
            }
            this.audioRecord = null;
            nativeDestroyInstance(this.nativeInstance);
            this.released = true;
        }
    }

    public final void setSampleFormat(int sampleRate, int bitDepth, int channels) {
        nativeSetSampleFormat(this.nativeInstance, sampleRate, bitDepth, channels);
    }

    public final boolean startRecording(AudioRecord audioRecord) {
        m.checkNotNullParameter(audioRecord, "audioRecord");
        int channelCount = audioRecord.getChannelCount();
        int sampleRate = audioRecord.getSampleRate();
        if (this.audioRecord != null) {
            reportSoundshareAudioSourceInitError("StartRecording called twice without StopRecording.");
            return false;
        }
        this.audioRecord = audioRecord;
        setSampleFormat(sampleRate, 16, channelCount);
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect((sampleRate / 100) * channelCount * 2);
        this.byteBuffer = byteBufferAllocateDirect;
        nativeCacheDirectBufferAddress(this.nativeInstance, byteBufferAllocateDirect);
        int minBufferSize = AudioRecord.getMinBufferSize(sampleRate, channelCountToConfiguration(channelCount), 2);
        if (minBufferSize == -1 || minBufferSize == -2) {
            reportSoundshareAudioSourceInitError(a.q("AudioRecord.getMinBufferSize failed: ", minBufferSize));
            return false;
        }
        Math.max(minBufferSize * 2, byteBufferAllocateDirect.capacity());
        if (audioRecord.getState() != 1) {
            reportSoundshareAudioSourceInitError("Failed to create a new AudioRecord instance");
            release();
            return false;
        }
        try {
            try {
                SoundshareAudioSource$Companion.access$assertTrue(Companion, this.audioThread == null);
                long rtcTimeNanos = TimestampAligner.getRtcTimeNanos();
                try {
                    audioRecord.startRecording();
                    if (audioRecord.getRecordingState() != 3) {
                        reportSoundshareAudioSourceStartError("AudioRecord.startRecording failed - incorrect state :" + audioRecord.getRecordingState());
                        return false;
                    }
                    m.checkNotNullExpressionValue(byteBufferAllocateDirect, "byteBuffer");
                    SoundshareAudioSource$AudioRecordThread soundshareAudioSource$AudioRecordThread = new SoundshareAudioSource$AudioRecordThread(this, "SoundshareThread", audioRecord, byteBufferAllocateDirect, rtcTimeNanos);
                    this.audioThread = soundshareAudioSource$AudioRecordThread;
                    m.checkNotNull(soundshareAudioSource$AudioRecordThread);
                    soundshareAudioSource$AudioRecordThread.start();
                    return true;
                } catch (IllegalStateException e) {
                    reportSoundshareAudioSourceStartError("AudioRecord.startRecording failed: " + e.getMessage());
                    return false;
                }
            } catch (Throwable th) {
                Log.e(TAG, "WebrtcAudioRecord.startRecording: audioThread != null!", th);
                throw th;
            }
        } catch (Throwable th2) {
            Log.e(TAG, "SoundshareAudioSource.startRecording fail hard!", th2);
            throw th2;
        }
    }

    public final boolean stopRecording() {
        SoundshareAudioSource$AudioRecordThread soundshareAudioSource$AudioRecordThread = this.audioThread;
        if (soundshareAudioSource$AudioRecordThread == null) {
            return false;
        }
        soundshareAudioSource$AudioRecordThread.stopThread();
        if (!ThreadUtils.joinUninterruptibly(soundshareAudioSource$AudioRecordThread, AUDIO_RECORD_THREAD_JOIN_TIMEOUT_MS)) {
            Log.e(TAG, "Join of SoundshareThread timed out");
        }
        this.audioThread = null;
        return true;
    }
}
