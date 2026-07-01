package org.webrtc.voiceengine;

import android.media.AudioManager;
import androidx.annotation.Nullable;
import java.util.Timer;

/* JADX INFO: loaded from: classes3.dex */
public class WebRtcAudioManager$VolumeLogger {
    private static final String THREAD_NAME = "WebRtcVolumeLevelLoggerThread";
    private static final int TIMER_PERIOD_IN_SECONDS = 30;
    private final AudioManager audioManager;

    @Nullable
    private Timer timer;

    public WebRtcAudioManager$VolumeLogger(AudioManager audioManager) {
        this.audioManager = audioManager;
    }

    public static /* synthetic */ AudioManager access$000(WebRtcAudioManager$VolumeLogger webRtcAudioManager$VolumeLogger) {
        return webRtcAudioManager$VolumeLogger.audioManager;
    }

    public static /* synthetic */ void access$100(WebRtcAudioManager$VolumeLogger webRtcAudioManager$VolumeLogger) {
        webRtcAudioManager$VolumeLogger.stop();
    }

    private void stop() {
        Timer timer = this.timer;
        if (timer != null) {
            timer.cancel();
            this.timer = null;
        }
    }

    public void start() {
        Timer timer = new Timer(THREAD_NAME);
        this.timer = timer;
        timer.schedule(new WebRtcAudioManager$VolumeLogger$LogVolumeTask(this, this.audioManager.getStreamMaxVolume(2), this.audioManager.getStreamMaxVolume(0)), 0L, 30000L);
    }
}
