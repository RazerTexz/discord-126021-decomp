package org.webrtc.audio;

import android.media.AudioManager;
import androidx.annotation.Nullable;
import java.util.Timer;
import java.util.TimerTask;
import org.webrtc.Logging;
import p007b.p100d.p104b.p105a.C1643a;

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
                StringBuilder sbM833U = C1643a.m833U("STREAM_RING stream volume: ");
                sbM833U.append(VolumeLogger.this.audioManager.getStreamVolume(2));
                sbM833U.append(" (max=");
                sbM833U.append(this.maxRingVolume);
                sbM833U.append(")");
                Logging.m11027d(VolumeLogger.TAG, sbM833U.toString());
                return;
            }
            if (mode == 3) {
                StringBuilder sbM833U2 = C1643a.m833U("VOICE_CALL stream volume: ");
                sbM833U2.append(VolumeLogger.this.audioManager.getStreamVolume(0));
                sbM833U2.append(" (max=");
                sbM833U2.append(this.maxVoiceCallVolume);
                sbM833U2.append(")");
                Logging.m11027d(VolumeLogger.TAG, sbM833U2.toString());
            }
        }
    }

    public VolumeLogger(AudioManager audioManager) {
        this.audioManager = audioManager;
    }

    public void start() {
        StringBuilder sbM833U = C1643a.m833U("start");
        sbM833U.append(WebRtcAudioUtils.getThreadInfo());
        Logging.m11027d(TAG, sbM833U.toString());
        if (this.timer != null) {
            return;
        }
        StringBuilder sbM833U2 = C1643a.m833U("audio mode is: ");
        sbM833U2.append(WebRtcAudioUtils.modeToString(this.audioManager.getMode()));
        Logging.m11027d(TAG, sbM833U2.toString());
        Timer timer = new Timer(THREAD_NAME);
        this.timer = timer;
        timer.schedule(new LogVolumeTask(this.audioManager.getStreamMaxVolume(2), this.audioManager.getStreamMaxVolume(0)), 0L, 30000L);
    }

    public void stop() {
        StringBuilder sbM833U = C1643a.m833U("stop");
        sbM833U.append(WebRtcAudioUtils.getThreadInfo());
        Logging.m11027d(TAG, sbM833U.toString());
        Timer timer = this.timer;
        if (timer != null) {
            timer.cancel();
            this.timer = null;
        }
    }
}
