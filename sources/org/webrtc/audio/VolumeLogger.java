package org.webrtc.audio;

import android.media.AudioManager;
import androidx.annotation.Nullable;
import b.d.b.a.outline;
import java.util.Timer;
import java.util.TimerTask;
import org.webrtc.Logging;

/* JADX INFO: loaded from: classes3.dex */
public class VolumeLogger {
    private static final String TAG = "VolumeLogger";
    private static final String THREAD_NAME = "WebRtcVolumeLevelLoggerThread";
    private static final int TIMER_PERIOD_IN_SECONDS = 30;
    private final AudioManager audioManager;

    @Nullable
    private Timer timer;

    public class LogVolumeTask extends TimerTask {
        private final int maxRingVolume;
        private final int maxVoiceCallVolume;

        public LogVolumeTask(int i, int i2) {
            this.maxRingVolume = i;
            this.maxVoiceCallVolume = i2;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            int mode = VolumeLogger.this.audioManager.getMode();
            if (mode == 1) {
                StringBuilder sbU = outline.U("STREAM_RING stream volume: ");
                sbU.append(VolumeLogger.this.audioManager.getStreamVolume(2));
                sbU.append(" (max=");
                sbU.append(this.maxRingVolume);
                sbU.append(")");
                Logging.d(VolumeLogger.TAG, sbU.toString());
                return;
            }
            if (mode == 3) {
                StringBuilder sbU2 = outline.U("VOICE_CALL stream volume: ");
                sbU2.append(VolumeLogger.this.audioManager.getStreamVolume(0));
                sbU2.append(" (max=");
                sbU2.append(this.maxVoiceCallVolume);
                sbU2.append(")");
                Logging.d(VolumeLogger.TAG, sbU2.toString());
            }
        }
    }

    public VolumeLogger(AudioManager audioManager) {
        this.audioManager = audioManager;
    }

    public void start() {
        StringBuilder sbU = outline.U("start");
        sbU.append(WebRtcAudioUtils.getThreadInfo());
        Logging.d(TAG, sbU.toString());
        if (this.timer != null) {
            return;
        }
        StringBuilder sbU2 = outline.U("audio mode is: ");
        sbU2.append(WebRtcAudioUtils.modeToString(this.audioManager.getMode()));
        Logging.d(TAG, sbU2.toString());
        Timer timer = new Timer(THREAD_NAME);
        this.timer = timer;
        timer.schedule(new LogVolumeTask(this.audioManager.getStreamMaxVolume(2), this.audioManager.getStreamMaxVolume(0)), 0L, 30000L);
    }

    public void stop() {
        StringBuilder sbU = outline.U("stop");
        sbU.append(WebRtcAudioUtils.getThreadInfo());
        Logging.d(TAG, sbU.toString());
        Timer timer = this.timer;
        if (timer != null) {
            timer.cancel();
            this.timer = null;
        }
    }
}
