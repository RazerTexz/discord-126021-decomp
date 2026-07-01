package co.discord.media_engine;

import android.media.AudioRecord;
import android.os.Process;
import android.util.Log;
import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.DefaultConstructorMarker;
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

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "SoundshareAudioSource";
    private static volatile boolean microphoneMute;
    private AudioRecord audioRecord;
    private AudioRecordThread audioThread;
    private ByteBuffer byteBuffer;
    private final long nativeInstance = nativeCreateInstance();
    private boolean released;

    /* JADX INFO: compiled from: SoundshareAudioSource.kt */
    public final class AudioRecordThread extends Thread {
        private final AudioRecord audioRecord;
        private final ByteBuffer byteBuffer;
        private final byte[] emptyBytes;
        private volatile boolean keepAlive;
        public final /* synthetic */ SoundshareAudioSource this$0;
        private long timestamp;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AudioRecordThread(SoundshareAudioSource soundshareAudioSource, String str, AudioRecord audioRecord, ByteBuffer byteBuffer, long j) {
            super(str);
            Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
            Intrinsics3.checkNotNullParameter(audioRecord, "audioRecord");
            Intrinsics3.checkNotNullParameter(byteBuffer, "byteBuffer");
            this.this$0 = soundshareAudioSource;
            this.audioRecord = audioRecord;
            this.byteBuffer = byteBuffer;
            this.timestamp = j;
            this.keepAlive = true;
            this.emptyBytes = new byte[byteBuffer.capacity()];
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Process.setThreadPriority(-19);
            SoundshareAudioSource.INSTANCE.assertTrue(this.audioRecord.getRecordingState() == 3);
            while (this.keepAlive) {
                AudioRecord audioRecord = this.audioRecord;
                ByteBuffer byteBuffer = this.byteBuffer;
                int i = audioRecord.read(byteBuffer, byteBuffer.capacity());
                this.timestamp = TimestampAligner.getRtcTimeNanos();
                if (i == this.byteBuffer.capacity()) {
                    if (SoundshareAudioSource.microphoneMute) {
                        this.byteBuffer.clear();
                        this.byteBuffer.put(this.emptyBytes);
                    }
                    if (this.keepAlive) {
                        this.this$0.dataIsRecorded(i, this.timestamp);
                    }
                } else {
                    String str = "AudioRecord.read failed: " + i;
                    Log.e(SoundshareAudioSource.TAG, str);
                    if (i == -3) {
                        this.keepAlive = false;
                        this.this$0.reportSoundshareAudioSourceError(str);
                    }
                }
            }
            try {
                this.audioRecord.stop();
            } catch (IllegalStateException e) {
                StringBuilder sbU = outline.U("AudioRecord.stop failed: ");
                sbU.append(e.getMessage());
                Log.e(SoundshareAudioSource.TAG, sbU.toString());
            }
        }

        public final void stopThread() {
            this.keepAlive = false;
        }
    }

    /* JADX INFO: compiled from: SoundshareAudioSource.kt */
    public static final class Companion {
        private Companion() {
        }

        private final void assertTrue(boolean condition) {
            if (!condition) {
                throw new AssertionError("Expected condition to be true");
            }
        }

        public final void setMicrophoneMute(boolean mute) {
            Log.w(SoundshareAudioSource.TAG, "setMicrophoneMute(" + mute + ')');
            SoundshareAudioSource.microphoneMute = mute;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
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
        Intrinsics3.checkNotNullParameter(audioRecord, "audioRecord");
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
            reportSoundshareAudioSourceInitError(outline.q("AudioRecord.getMinBufferSize failed: ", minBufferSize));
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
                INSTANCE.assertTrue(this.audioThread == null);
                long rtcTimeNanos = TimestampAligner.getRtcTimeNanos();
                try {
                    audioRecord.startRecording();
                    if (audioRecord.getRecordingState() != 3) {
                        reportSoundshareAudioSourceStartError("AudioRecord.startRecording failed - incorrect state :" + audioRecord.getRecordingState());
                        return false;
                    }
                    Intrinsics3.checkNotNullExpressionValue(byteBufferAllocateDirect, "byteBuffer");
                    AudioRecordThread audioRecordThread = new AudioRecordThread(this, "SoundshareThread", audioRecord, byteBufferAllocateDirect, rtcTimeNanos);
                    this.audioThread = audioRecordThread;
                    Intrinsics3.checkNotNull(audioRecordThread);
                    audioRecordThread.start();
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
        AudioRecordThread audioRecordThread = this.audioThread;
        if (audioRecordThread == null) {
            return false;
        }
        audioRecordThread.stopThread();
        if (!ThreadUtils.joinUninterruptibly(audioRecordThread, AUDIO_RECORD_THREAD_JOIN_TIMEOUT_MS)) {
            Log.e(TAG, "Join of SoundshareThread timed out");
        }
        this.audioThread = null;
        return true;
    }
}
