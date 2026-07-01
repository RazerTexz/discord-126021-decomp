package org.webrtc.voiceengine;

import android.media.AudioTrack;
import android.os.Process;
import b.d.b.a.a;
import java.nio.ByteBuffer;
import org.webrtc.Logging;

/* JADX INFO: loaded from: classes3.dex */
public class WebRtcAudioTrack$AudioTrackThread extends Thread {
    private volatile boolean keepAlive;
    public final /* synthetic */ WebRtcAudioTrack this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebRtcAudioTrack$AudioTrackThread(WebRtcAudioTrack webRtcAudioTrack, String str) {
        super(str);
        this.this$0 = webRtcAudioTrack;
        this.keepAlive = true;
    }

    private int writeBytes(AudioTrack audioTrack, ByteBuffer byteBuffer, int i) {
        return audioTrack.write(byteBuffer, i, 0);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Process.setThreadPriority(-19);
        Logging.d("WebRtcAudioTrack", "AudioTrackThread" + WebRtcAudioUtils.getThreadInfo());
        WebRtcAudioTrack.access$100(WebRtcAudioTrack.access$000(this.this$0).getPlayState() == 3);
        int iCapacity = WebRtcAudioTrack.access$200(this.this$0).capacity();
        while (this.keepAlive) {
            WebRtcAudioTrack webRtcAudioTrack = this.this$0;
            WebRtcAudioTrack.access$400(webRtcAudioTrack, iCapacity, WebRtcAudioTrack.access$300(webRtcAudioTrack));
            WebRtcAudioTrack.access$100(iCapacity <= WebRtcAudioTrack.access$200(this.this$0).remaining());
            if (WebRtcAudioTrack.access$500()) {
                WebRtcAudioTrack.access$200(this.this$0).clear();
                WebRtcAudioTrack.access$200(this.this$0).put(WebRtcAudioTrack.access$600(this.this$0));
                WebRtcAudioTrack.access$200(this.this$0).position(0);
            }
            int iWriteBytes = writeBytes(WebRtcAudioTrack.access$000(this.this$0), WebRtcAudioTrack.access$200(this.this$0), iCapacity);
            if (iWriteBytes != iCapacity) {
                Logging.e("WebRtcAudioTrack", "AudioTrack.write played invalid number of bytes: " + iWriteBytes);
                if (iWriteBytes < 0) {
                    this.keepAlive = false;
                    WebRtcAudioTrack.access$700(this.this$0, "AudioTrack.write failed: " + iWriteBytes);
                }
            }
            WebRtcAudioTrack.access$200(this.this$0).rewind();
        }
        if (WebRtcAudioTrack.access$000(this.this$0) != null) {
            Logging.d("WebRtcAudioTrack", "Calling AudioTrack.stop...");
            try {
                WebRtcAudioTrack.access$000(this.this$0).stop();
                Logging.d("WebRtcAudioTrack", "AudioTrack.stop is done.");
            } catch (IllegalStateException e) {
                StringBuilder sbU = a.U("AudioTrack.stop failed: ");
                sbU.append(e.getMessage());
                Logging.e("WebRtcAudioTrack", sbU.toString());
            }
        }
    }

    public void stopThread() {
        Logging.d("WebRtcAudioTrack", "stopThread");
        this.keepAlive = false;
    }
}
