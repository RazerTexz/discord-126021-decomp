package co.discord.media_engine;

import android.media.AudioRecord;
import android.os.Process;
import android.util.Log;
import b.d.b.a.a;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;
import java.nio.ByteBuffer;
import org.webrtc.TimestampAligner;

/* JADX INFO: compiled from: SoundshareAudioSource.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SoundshareAudioSource$AudioRecordThread extends Thread {
    private final AudioRecord audioRecord;
    private final ByteBuffer byteBuffer;
    private final byte[] emptyBytes;
    private volatile boolean keepAlive;
    public final /* synthetic */ SoundshareAudioSource this$0;
    private long timestamp;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SoundshareAudioSource$AudioRecordThread(SoundshareAudioSource soundshareAudioSource, String str, AudioRecord audioRecord, ByteBuffer byteBuffer, long j) {
        super(str);
        m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        m.checkNotNullParameter(audioRecord, "audioRecord");
        m.checkNotNullParameter(byteBuffer, "byteBuffer");
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
        SoundshareAudioSource$Companion.access$assertTrue(SoundshareAudioSource.Companion, this.audioRecord.getRecordingState() == 3);
        while (this.keepAlive) {
            AudioRecord audioRecord = this.audioRecord;
            ByteBuffer byteBuffer = this.byteBuffer;
            int i = audioRecord.read(byteBuffer, byteBuffer.capacity());
            this.timestamp = TimestampAligner.getRtcTimeNanos();
            if (i == this.byteBuffer.capacity()) {
                if (SoundshareAudioSource.access$getMicrophoneMute$cp()) {
                    this.byteBuffer.clear();
                    this.byteBuffer.put(this.emptyBytes);
                }
                if (this.keepAlive) {
                    SoundshareAudioSource.access$dataIsRecorded(this.this$0, i, this.timestamp);
                }
            } else {
                String str = "AudioRecord.read failed: " + i;
                Log.e("SoundshareAudioSource", str);
                if (i == -3) {
                    this.keepAlive = false;
                    SoundshareAudioSource.access$reportSoundshareAudioSourceError(this.this$0, str);
                }
            }
        }
        try {
            this.audioRecord.stop();
        } catch (IllegalStateException e) {
            StringBuilder sbU = a.U("AudioRecord.stop failed: ");
            sbU.append(e.getMessage());
            Log.e("SoundshareAudioSource", sbU.toString());
        }
    }

    public final void stopThread() {
        this.keepAlive = false;
    }
}
