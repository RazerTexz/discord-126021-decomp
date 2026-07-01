package org.webrtc.audio;

import android.os.Process;
import b.d.b.a.a;
import java.util.Arrays;
import org.webrtc.Logging;

/* JADX INFO: loaded from: classes3.dex */
public class WebRtcAudioRecord$AudioRecordThread extends Thread {
    private volatile boolean keepAlive;
    public final /* synthetic */ WebRtcAudioRecord this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebRtcAudioRecord$AudioRecordThread(WebRtcAudioRecord webRtcAudioRecord, String str) {
        super(str);
        this.this$0 = webRtcAudioRecord;
        this.keepAlive = true;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Process.setThreadPriority(-19);
        Logging.d("WebRtcAudioRecordExternal", "AudioRecordThread" + WebRtcAudioUtils.getThreadInfo());
        WebRtcAudioRecord.access$100(WebRtcAudioRecord.access$000(this.this$0).getRecordingState() == 3);
        WebRtcAudioRecord.access$200(this.this$0, 0);
        System.nanoTime();
        while (this.keepAlive) {
            int i = WebRtcAudioRecord.access$000(this.this$0).read(WebRtcAudioRecord.access$300(this.this$0), WebRtcAudioRecord.access$300(this.this$0).capacity());
            if (i == WebRtcAudioRecord.access$300(this.this$0).capacity()) {
                if (WebRtcAudioRecord.access$400(this.this$0)) {
                    WebRtcAudioRecord.access$300(this.this$0).clear();
                    WebRtcAudioRecord.access$300(this.this$0).put(WebRtcAudioRecord.access$500(this.this$0));
                }
                if (this.keepAlive) {
                    WebRtcAudioRecord webRtcAudioRecord = this.this$0;
                    WebRtcAudioRecord.access$700(webRtcAudioRecord, WebRtcAudioRecord.access$600(webRtcAudioRecord), i);
                }
                if (WebRtcAudioRecord.access$800(this.this$0) != null) {
                    WebRtcAudioRecord.access$800(this.this$0).onWebRtcAudioRecordSamplesReady(new JavaAudioDeviceModule$AudioSamples(WebRtcAudioRecord.access$000(this.this$0).getAudioFormat(), WebRtcAudioRecord.access$000(this.this$0).getChannelCount(), WebRtcAudioRecord.access$000(this.this$0).getSampleRate(), Arrays.copyOfRange(WebRtcAudioRecord.access$300(this.this$0).array(), WebRtcAudioRecord.access$300(this.this$0).arrayOffset(), WebRtcAudioRecord.access$300(this.this$0).arrayOffset() + WebRtcAudioRecord.access$300(this.this$0).capacity())));
                }
            } else {
                String str = "AudioRecord.read failed: " + i;
                Logging.e("WebRtcAudioRecordExternal", str);
                if (i == -3) {
                    this.keepAlive = false;
                    WebRtcAudioRecord.access$900(this.this$0, str);
                }
            }
        }
        try {
            if (WebRtcAudioRecord.access$000(this.this$0) != null) {
                WebRtcAudioRecord.access$000(this.this$0).stop();
                WebRtcAudioRecord.access$200(this.this$0, 1);
            }
        } catch (IllegalStateException e) {
            StringBuilder sbU = a.U("AudioRecord.stop failed: ");
            sbU.append(e.getMessage());
            Logging.e("WebRtcAudioRecordExternal", sbU.toString());
        }
    }

    public void stopThread() {
        Logging.d("WebRtcAudioRecordExternal", "stopThread");
        this.keepAlive = false;
    }
}
