package org.webrtc.audio;

import android.media.AudioTrack;
import android.os.Process;
import java.nio.ByteBuffer;
import org.webrtc.Logging;

/* JADX INFO: loaded from: classes3.dex */
public class WebRtcAudioTrack$AudioTrackThread extends Thread {
    private LowLatencyAudioBufferManager bufferManager;
    private volatile boolean keepAlive;
    public final /* synthetic */ WebRtcAudioTrack this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebRtcAudioTrack$AudioTrackThread(WebRtcAudioTrack webRtcAudioTrack, String str) {
        super(str);
        this.this$0 = webRtcAudioTrack;
        this.keepAlive = true;
        this.bufferManager = new LowLatencyAudioBufferManager();
    }

    private int writeBytes(AudioTrack audioTrack, ByteBuffer byteBuffer, int i) {
        return audioTrack.write(byteBuffer, i, 0);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Process.setThreadPriority(-19);
        Logging.d("WebRtcAudioTrackExternal", "AudioTrackThread" + WebRtcAudioUtils.getThreadInfo());
        WebRtcAudioTrack.access$100(WebRtcAudioTrack.access$000(this.this$0).getPlayState() == 3);
        WebRtcAudioTrack.access$200(this.this$0, 0);
        int iCapacity = WebRtcAudioTrack.access$300(this.this$0).capacity();
        while (this.keepAlive) {
            WebRtcAudioTrack.access$500(WebRtcAudioTrack.access$400(this.this$0), iCapacity);
            WebRtcAudioTrack.access$100(iCapacity <= WebRtcAudioTrack.access$300(this.this$0).remaining());
            if (WebRtcAudioTrack.access$600(this.this$0)) {
                WebRtcAudioTrack.access$300(this.this$0).clear();
                WebRtcAudioTrack.access$300(this.this$0).put(WebRtcAudioTrack.access$700(this.this$0));
                WebRtcAudioTrack.access$300(this.this$0).position(0);
            }
            int iWriteBytes = writeBytes(WebRtcAudioTrack.access$000(this.this$0), WebRtcAudioTrack.access$300(this.this$0), iCapacity);
            if (iWriteBytes != iCapacity) {
                Logging.e("WebRtcAudioTrackExternal", "AudioTrack.write played invalid number of bytes: " + iWriteBytes);
                if (iWriteBytes < 0) {
                    this.keepAlive = false;
                    WebRtcAudioTrack.access$800(this.this$0, "AudioTrack.write failed: " + iWriteBytes);
                }
            }
            if (WebRtcAudioTrack.access$900(this.this$0)) {
                this.bufferManager.maybeAdjustBufferSize(WebRtcAudioTrack.access$000(this.this$0));
            }
            WebRtcAudioTrack.access$300(this.this$0).rewind();
        }
    }

    public void stopThread() {
        Logging.d("WebRtcAudioTrackExternal", "stopThread");
        this.keepAlive = false;
    }
}
