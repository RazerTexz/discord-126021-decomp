package org.webrtc.audio;

import android.media.AudioManager;
import androidx.annotation.Nullable;
import b.d.b.a.a;
import java.util.Timer;
import org.webrtc.Logging;

/* JADX INFO: loaded from: classes3.dex */
public class VolumeLogger {
    private static final String TAG = "VolumeLogger";
    private static final String THREAD_NAME = "WebRtcVolumeLevelLoggerThread";
    private static final int TIMER_PERIOD_IN_SECONDS = 30;
    private final AudioManager audioManager;

    @Nullable
    private Timer timer;

    public VolumeLogger(AudioManager audioManager) {
        this.audioManager = audioManager;
    }

    public static /* synthetic */ AudioManager access$000(VolumeLogger volumeLogger) {
        return volumeLogger.audioManager;
    }

    public void start() {
        StringBuilder sbU = a.U("start");
        sbU.append(WebRtcAudioUtils.getThreadInfo());
        Logging.d(TAG, sbU.toString());
        if (this.timer != null) {
            return;
        }
        StringBuilder sbU2 = a.U("audio mode is: ");
        sbU2.append(WebRtcAudioUtils.modeToString(this.audioManager.getMode()));
        Logging.d(TAG, sbU2.toString());
        Timer timer = new Timer(THREAD_NAME);
        this.timer = timer;
        timer.schedule(new VolumeLogger$LogVolumeTask(this, this.audioManager.getStreamMaxVolume(2), this.audioManager.getStreamMaxVolume(0)), 0L, 30000L);
    }

    public void stop() {
        StringBuilder sbU = a.U("stop");
        sbU.append(WebRtcAudioUtils.getThreadInfo());
        Logging.d(TAG, sbU.toString());
        Timer timer = this.timer;
        if (timer != null) {
            timer.cancel();
            this.timer = null;
        }
    }
}
