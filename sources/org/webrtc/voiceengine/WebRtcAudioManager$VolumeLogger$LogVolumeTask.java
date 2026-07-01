package org.webrtc.voiceengine;

import b.d.b.a.a;
import java.util.TimerTask;
import org.webrtc.Logging;

/* JADX INFO: loaded from: classes3.dex */
public class WebRtcAudioManager$VolumeLogger$LogVolumeTask extends TimerTask {
    private final int maxRingVolume;
    private final int maxVoiceCallVolume;
    public final /* synthetic */ WebRtcAudioManager$VolumeLogger this$0;

    public WebRtcAudioManager$VolumeLogger$LogVolumeTask(WebRtcAudioManager$VolumeLogger webRtcAudioManager$VolumeLogger, int i, int i2) {
        this.this$0 = webRtcAudioManager$VolumeLogger;
        this.maxRingVolume = i;
        this.maxVoiceCallVolume = i2;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        int mode = WebRtcAudioManager$VolumeLogger.access$000(this.this$0).getMode();
        if (mode == 1) {
            StringBuilder sbU = a.U("STREAM_RING stream volume: ");
            sbU.append(WebRtcAudioManager$VolumeLogger.access$000(this.this$0).getStreamVolume(2));
            sbU.append(" (max=");
            sbU.append(this.maxRingVolume);
            sbU.append(")");
            Logging.d("WebRtcAudioManager", sbU.toString());
            return;
        }
        if (mode == 3) {
            StringBuilder sbU2 = a.U("VOICE_CALL stream volume: ");
            sbU2.append(WebRtcAudioManager$VolumeLogger.access$000(this.this$0).getStreamVolume(0));
            sbU2.append(" (max=");
            sbU2.append(this.maxVoiceCallVolume);
            sbU2.append(")");
            Logging.d("WebRtcAudioManager", sbU2.toString());
        }
    }
}
