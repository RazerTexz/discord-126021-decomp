package org.webrtc.voiceengine;

import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.os.Build;
import b.d.b.a.outline;
import java.util.Arrays;
import java.util.List;
import org.webrtc.ContextUtils;
import org.webrtc.Logging;
import org.webrtc.MediaStreamTrack;

/* JADX INFO: loaded from: classes3.dex */
public final class WebRtcAudioUtils {
    private static final int DEFAULT_SAMPLE_RATE_HZ = 16000;
    private static final String TAG = "WebRtcAudioUtils";
    private static int defaultSampleRateHz = 16000;
    private static boolean isDefaultSampleRateOverridden;
    private static boolean useWebRtcBasedAcousticEchoCanceler;
    private static boolean useWebRtcBasedNoiseSuppressor;
    private static final String[] BLACKLISTED_OPEN_SL_ES_MODELS = new String[0];
    private static final String[] BLACKLISTED_AEC_MODELS = new String[0];
    private static final String[] BLACKLISTED_NS_MODELS = new String[0];

    public static boolean deviceIsBlacklistedForOpenSLESUsage() {
        return Arrays.asList(BLACKLISTED_OPEN_SL_ES_MODELS).contains(Build.MODEL);
    }

    private static String deviceTypeToString(int i) {
        switch (i) {
            case 1:
                return "TYPE_BUILTIN_EARPIECE";
            case 2:
                return "TYPE_BUILTIN_SPEAKER";
            case 3:
                return "TYPE_WIRED_HEADSET";
            case 4:
                return "TYPE_WIRED_HEADPHONES";
            case 5:
                return "TYPE_LINE_ANALOG";
            case 6:
                return "TYPE_LINE_DIGITAL";
            case 7:
                return "TYPE_BLUETOOTH_SCO";
            case 8:
                return "TYPE_BLUETOOTH_A2DP";
            case 9:
                return "TYPE_HDMI";
            case 10:
                return "TYPE_HDMI_ARC";
            case 11:
                return "TYPE_USB_DEVICE";
            case 12:
                return "TYPE_USB_ACCESSORY";
            case 13:
                return "TYPE_DOCK";
            case 14:
                return "TYPE_FM";
            case 15:
                return "TYPE_BUILTIN_MIC";
            case 16:
                return "TYPE_FM_TUNER";
            case 17:
                return "TYPE_TV_TUNER";
            case 18:
                return "TYPE_TELEPHONY";
            case 19:
                return "TYPE_AUX_LINE";
            case 20:
                return "TYPE_IP";
            case 21:
                return "TYPE_BUS";
            case 22:
                return "TYPE_USB_HEADSET";
            default:
                return "TYPE_UNKNOWN";
        }
    }

    public static List<String> getBlackListedModelsForAecUsage() {
        return Arrays.asList(BLACKLISTED_AEC_MODELS);
    }

    public static List<String> getBlackListedModelsForNsUsage() {
        return Arrays.asList(BLACKLISTED_NS_MODELS);
    }

    public static synchronized int getDefaultSampleRateHz() {
        return defaultSampleRateHz;
    }

    public static String getThreadInfo() {
        StringBuilder sbU = outline.U("@[name=");
        sbU.append(Thread.currentThread().getName());
        sbU.append(", id=");
        sbU.append(Thread.currentThread().getId());
        sbU.append("]");
        return sbU.toString();
    }

    private static boolean hasMicrophone() {
        return ContextUtils.getApplicationContext().getPackageManager().hasSystemFeature("android.hardware.microphone");
    }

    public static boolean isAcousticEchoCancelerSupported() {
        return WebRtcAudioEffects.canUseAcousticEchoCanceler();
    }

    public static boolean isAutomaticGainControlSupported() {
        return false;
    }

    public static synchronized boolean isDefaultSampleRateOverridden() {
        return isDefaultSampleRateOverridden;
    }

    public static boolean isNoiseSuppressorSupported() {
        return WebRtcAudioEffects.canUseNoiseSuppressor();
    }

    private static boolean isVolumeFixed(AudioManager audioManager) {
        return audioManager.isVolumeFixed();
    }

    private static void logAudioDeviceInfo(String str, AudioManager audioManager) {
        if (Build.VERSION.SDK_INT < 23) {
            return;
        }
        AudioDeviceInfo[] devices = audioManager.getDevices(3);
        if (devices.length == 0) {
            return;
        }
        Logging.d(str, "Audio Devices: ");
        for (AudioDeviceInfo audioDeviceInfo : devices) {
            StringBuilder sbU = outline.U("  ");
            sbU.append(deviceTypeToString(audioDeviceInfo.getType()));
            sbU.append(audioDeviceInfo.isSource() ? "(in): " : "(out): ");
            if (audioDeviceInfo.getChannelCounts().length > 0) {
                sbU.append("channels=");
                sbU.append(Arrays.toString(audioDeviceInfo.getChannelCounts()));
                sbU.append(", ");
            }
            if (audioDeviceInfo.getEncodings().length > 0) {
                sbU.append("encodings=");
                sbU.append(Arrays.toString(audioDeviceInfo.getEncodings()));
                sbU.append(", ");
            }
            if (audioDeviceInfo.getSampleRates().length > 0) {
                sbU.append("sample rates=");
                sbU.append(Arrays.toString(audioDeviceInfo.getSampleRates()));
                sbU.append(", ");
            }
            sbU.append("id=");
            sbU.append(audioDeviceInfo.getId());
            Logging.d(str, sbU.toString());
        }
    }

    public static void logAudioState(String str) {
        logDeviceInfo(str);
        AudioManager audioManager = (AudioManager) ContextUtils.getApplicationContext().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
        logAudioStateBasic(str, audioManager);
        logAudioStateVolume(str, audioManager);
        logAudioDeviceInfo(str, audioManager);
    }

    private static void logAudioStateBasic(String str, AudioManager audioManager) {
        StringBuilder sbU = outline.U("Audio State: audio mode: ");
        sbU.append(modeToString(audioManager.getMode()));
        sbU.append(", has mic: ");
        sbU.append(hasMicrophone());
        sbU.append(", mic muted: ");
        sbU.append(audioManager.isMicrophoneMute());
        sbU.append(", music active: ");
        sbU.append(audioManager.isMusicActive());
        sbU.append(", speakerphone: ");
        sbU.append(audioManager.isSpeakerphoneOn());
        sbU.append(", BT SCO: ");
        sbU.append(audioManager.isBluetoothScoOn());
        Logging.d(str, sbU.toString());
    }

    private static void logAudioStateVolume(String str, AudioManager audioManager) {
        int[] iArr = {0, 3, 2, 4, 5, 1};
        Logging.d(str, "Audio State: ");
        boolean zIsVolumeFixed = isVolumeFixed(audioManager);
        Logging.d(str, "  fixed volume=" + zIsVolumeFixed);
        if (zIsVolumeFixed) {
            return;
        }
        for (int i = 0; i < 6; i++) {
            int i2 = iArr[i];
            StringBuilder sb = new StringBuilder();
            StringBuilder sbU = outline.U("  ");
            sbU.append(streamTypeToString(i2));
            sbU.append(": ");
            sb.append(sbU.toString());
            sb.append("volume=");
            sb.append(audioManager.getStreamVolume(i2));
            sb.append(", max=");
            sb.append(audioManager.getStreamMaxVolume(i2));
            logIsStreamMute(str, audioManager, i2, sb);
            Logging.d(str, sb.toString());
        }
    }

    public static void logDeviceInfo(String str) {
        StringBuilder sbU = outline.U("Android SDK: ");
        sbU.append(Build.VERSION.SDK_INT);
        sbU.append(", Release: ");
        sbU.append(Build.VERSION.RELEASE);
        sbU.append(", Brand: ");
        sbU.append(Build.BRAND);
        sbU.append(", Device: ");
        sbU.append(Build.DEVICE);
        sbU.append(", Id: ");
        sbU.append(Build.ID);
        sbU.append(", Hardware: ");
        sbU.append(Build.HARDWARE);
        sbU.append(", Manufacturer: ");
        sbU.append(Build.MANUFACTURER);
        sbU.append(", Model: ");
        sbU.append(Build.MODEL);
        sbU.append(", Product: ");
        sbU.append(Build.PRODUCT);
        Logging.d(str, sbU.toString());
    }

    private static void logIsStreamMute(String str, AudioManager audioManager, int i, StringBuilder sb) {
        if (Build.VERSION.SDK_INT >= 23) {
            sb.append(", muted=");
            sb.append(audioManager.isStreamMute(i));
        }
    }

    public static String modeToString(int i) {
        if (i == 0) {
            return "MODE_NORMAL";
        }
        if (i == 1) {
            return "MODE_RINGTONE";
        }
        if (i != 2) {
            return i != 3 ? "MODE_INVALID" : "MODE_IN_COMMUNICATION";
        }
        return "MODE_IN_CALL";
    }

    public static boolean runningOnEmulator() {
        return Build.HARDWARE.equals("goldfish") && Build.BRAND.startsWith("generic_");
    }

    public static synchronized void setDefaultSampleRateHz(int i) {
        isDefaultSampleRateOverridden = true;
        defaultSampleRateHz = i;
    }

    public static synchronized void setWebRtcBasedAcousticEchoCanceler(boolean z2) {
        useWebRtcBasedAcousticEchoCanceler = z2;
    }

    public static synchronized void setWebRtcBasedAutomaticGainControl(boolean z2) {
        Logging.w(TAG, "setWebRtcBasedAutomaticGainControl() is deprecated");
    }

    public static synchronized void setWebRtcBasedNoiseSuppressor(boolean z2) {
        useWebRtcBasedNoiseSuppressor = z2;
    }

    private static String streamTypeToString(int i) {
        if (i == 0) {
            return "STREAM_VOICE_CALL";
        }
        if (i == 1) {
            return "STREAM_SYSTEM";
        }
        if (i == 2) {
            return "STREAM_RING";
        }
        if (i == 3) {
            return "STREAM_MUSIC";
        }
        if (i != 4) {
            return i != 5 ? "STREAM_INVALID" : "STREAM_NOTIFICATION";
        }
        return "STREAM_ALARM";
    }

    public static synchronized boolean useWebRtcBasedAcousticEchoCanceler() {
        if (useWebRtcBasedAcousticEchoCanceler) {
            Logging.w(TAG, "Overriding default behavior; now using WebRTC AEC!");
        }
        return useWebRtcBasedAcousticEchoCanceler;
    }

    public static synchronized boolean useWebRtcBasedAutomaticGainControl() {
        return true;
    }

    public static synchronized boolean useWebRtcBasedNoiseSuppressor() {
        if (useWebRtcBasedNoiseSuppressor) {
            Logging.w(TAG, "Overriding default behavior; now using WebRTC NS!");
        }
        return useWebRtcBasedNoiseSuppressor;
    }
}
