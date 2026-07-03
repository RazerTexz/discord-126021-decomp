package org.webrtc.audio;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.os.Build;
import java.util.Arrays;
import org.webrtc.Logging;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: loaded from: classes3.dex */
public final class WebRtcAudioUtils {
    private static final String TAG = "WebRtcAudioUtilsExternal";

    @TargetApi(24)
    public static String audioEncodingToString(int i) {
        if (i == 0) {
            return "INVALID";
        }
        switch (i) {
            case 2:
                return "PCM_16BIT";
            case 3:
                return "PCM_8BIT";
            case 4:
                return "PCM_FLOAT";
            case 5:
            case 6:
                return "AC3";
            case 7:
                return "DTS";
            case 8:
                return "DTS_HD";
            case 9:
                return "MP3";
            default:
                return C1643a.m871q("Invalid encoding: ", i);
        }
    }

    @TargetApi(24)
    public static String audioSourceToString(int i) {
        switch (i) {
            case 0:
                return "DEFAULT";
            case 1:
                return "MIC";
            case 2:
                return "VOICE_UPLINK";
            case 3:
                return "VOICE_DOWNLINK";
            case 4:
                return "VOICE_CALL";
            case 5:
                return "CAMCORDER";
            case 6:
                return "VOICE_RECOGNITION";
            case 7:
                return "VOICE_COMMUNICATION";
            case 8:
            default:
                return "INVALID";
            case 9:
                return "UNPROCESSED";
            case 10:
                return "VOICE_PERFORMANCE";
        }
    }

    public static String channelMaskToString(int i) {
        if (i != 12) {
            return i != 16 ? "INVALID" : "IN_MONO";
        }
        return "IN_STEREO";
    }

    public static String deviceTypeToString(int i) {
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

    public static String getThreadInfo() {
        StringBuilder sbM833U = C1643a.m833U("@[name=");
        sbM833U.append(Thread.currentThread().getName());
        sbM833U.append(", id=");
        sbM833U.append(Thread.currentThread().getId());
        sbM833U.append("]");
        return sbM833U.toString();
    }

    private static boolean hasMicrophone(Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.microphone");
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
        Logging.m11027d(str, "Audio Devices: ");
        for (AudioDeviceInfo audioDeviceInfo : devices) {
            StringBuilder sbM833U = C1643a.m833U("  ");
            sbM833U.append(deviceTypeToString(audioDeviceInfo.getType()));
            sbM833U.append(audioDeviceInfo.isSource() ? "(in): " : "(out): ");
            if (audioDeviceInfo.getChannelCounts().length > 0) {
                sbM833U.append("channels=");
                sbM833U.append(Arrays.toString(audioDeviceInfo.getChannelCounts()));
                sbM833U.append(", ");
            }
            if (audioDeviceInfo.getEncodings().length > 0) {
                sbM833U.append("encodings=");
                sbM833U.append(Arrays.toString(audioDeviceInfo.getEncodings()));
                sbM833U.append(", ");
            }
            if (audioDeviceInfo.getSampleRates().length > 0) {
                sbM833U.append("sample rates=");
                sbM833U.append(Arrays.toString(audioDeviceInfo.getSampleRates()));
                sbM833U.append(", ");
            }
            sbM833U.append("id=");
            sbM833U.append(audioDeviceInfo.getId());
            Logging.m11027d(str, sbM833U.toString());
        }
    }

    public static void logAudioState(String str, Context context, AudioManager audioManager) {
        logDeviceInfo(str);
        logAudioStateBasic(str, context, audioManager);
        logAudioStateVolume(str, audioManager);
        logAudioDeviceInfo(str, audioManager);
    }

    private static void logAudioStateBasic(String str, Context context, AudioManager audioManager) {
        StringBuilder sbM833U = C1643a.m833U("Audio State: audio mode: ");
        sbM833U.append(modeToString(audioManager.getMode()));
        sbM833U.append(", has mic: ");
        sbM833U.append(hasMicrophone(context));
        sbM833U.append(", mic muted: ");
        sbM833U.append(audioManager.isMicrophoneMute());
        sbM833U.append(", music active: ");
        sbM833U.append(audioManager.isMusicActive());
        sbM833U.append(", speakerphone: ");
        sbM833U.append(audioManager.isSpeakerphoneOn());
        sbM833U.append(", BT SCO: ");
        sbM833U.append(audioManager.isBluetoothScoOn());
        Logging.m11027d(str, sbM833U.toString());
    }

    private static void logAudioStateVolume(String str, AudioManager audioManager) {
        int[] iArr = {0, 3, 2, 4, 5, 1};
        Logging.m11027d(str, "Audio State: ");
        boolean zIsVolumeFixed = isVolumeFixed(audioManager);
        Logging.m11027d(str, "  fixed volume=" + zIsVolumeFixed);
        if (zIsVolumeFixed) {
            return;
        }
        for (int i = 0; i < 6; i++) {
            int i2 = iArr[i];
            StringBuilder sb = new StringBuilder();
            StringBuilder sbM833U = C1643a.m833U("  ");
            sbM833U.append(streamTypeToString(i2));
            sbM833U.append(": ");
            sb.append(sbM833U.toString());
            sb.append("volume=");
            sb.append(audioManager.getStreamVolume(i2));
            sb.append(", max=");
            sb.append(audioManager.getStreamMaxVolume(i2));
            logIsStreamMute(str, audioManager, i2, sb);
            Logging.m11027d(str, sb.toString());
        }
    }

    public static void logDeviceInfo(String str) {
        StringBuilder sbM833U = C1643a.m833U("Android SDK: ");
        sbM833U.append(Build.VERSION.SDK_INT);
        sbM833U.append(", Release: ");
        sbM833U.append(Build.VERSION.RELEASE);
        sbM833U.append(", Brand: ");
        sbM833U.append(Build.BRAND);
        sbM833U.append(", Device: ");
        sbM833U.append(Build.DEVICE);
        sbM833U.append(", Id: ");
        sbM833U.append(Build.ID);
        sbM833U.append(", Hardware: ");
        sbM833U.append(Build.HARDWARE);
        sbM833U.append(", Manufacturer: ");
        sbM833U.append(Build.MANUFACTURER);
        sbM833U.append(", Model: ");
        sbM833U.append(Build.MODEL);
        sbM833U.append(", Product: ");
        sbM833U.append(Build.PRODUCT);
        Logging.m11027d(str, sbM833U.toString());
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
}
