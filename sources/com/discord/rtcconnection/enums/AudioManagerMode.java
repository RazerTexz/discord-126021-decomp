package com.discord.rtcconnection.enums;

import android.os.Build;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: AudioManagerMode.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AudioManagerMode {
    private static final /* synthetic */ AudioManagerMode[] $VALUES;
    public static final AudioManagerMode CallScreening;
    public static final AudioManagerMode Current;
    public static final AudioManagerMode InCall;
    public static final AudioManagerMode InCommunication;
    public static final AudioManagerMode Invalid;
    public static final AudioManagerMode Normal;
    public static final AudioManagerMode Ringtone;
    private final int value;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.discord.rtcconnection.enums.AudioManagerMode$a] */
    static {
        AudioManagerMode[] audioManagerModeArr = new AudioManagerMode[7];
        AudioManagerMode audioManagerMode = new AudioManagerMode("Current", 0, -1);
        Current = audioManagerMode;
        audioManagerModeArr[0] = audioManagerMode;
        AudioManagerMode audioManagerMode2 = new AudioManagerMode("Invalid", 1, -2);
        Invalid = audioManagerMode2;
        audioManagerModeArr[1] = audioManagerMode2;
        AudioManagerMode audioManagerMode3 = new AudioManagerMode("Normal", 2, 0);
        Normal = audioManagerMode3;
        audioManagerModeArr[2] = audioManagerMode3;
        AudioManagerMode audioManagerMode4 = new AudioManagerMode("Ringtone", 3, 1);
        Ringtone = audioManagerMode4;
        audioManagerModeArr[3] = audioManagerMode4;
        AudioManagerMode audioManagerMode5 = new AudioManagerMode("InCall", 4, 2);
        InCall = audioManagerMode5;
        audioManagerModeArr[4] = audioManagerMode5;
        AudioManagerMode audioManagerMode6 = new AudioManagerMode("InCommunication", 5, 3);
        InCommunication = audioManagerMode6;
        audioManagerModeArr[5] = audioManagerMode6;
        AudioManagerMode audioManagerMode7 = new AudioManagerMode("CallScreening", 6, Build.VERSION.SDK_INT >= 30 ? 4 : 2);
        CallScreening = audioManagerMode7;
        audioManagerModeArr[6] = audioManagerMode7;
        $VALUES = audioManagerModeArr;
        INSTANCE = new Object(null) { // from class: com.discord.rtcconnection.enums.AudioManagerMode.a
        };
    }

    private AudioManagerMode(String str, int i, int i2) {
        super(str, i);
        this.value = i2;
    }

    public static AudioManagerMode valueOf(String str) {
        return (AudioManagerMode) Enum.valueOf(AudioManagerMode.class, str);
    }

    public static AudioManagerMode[] values() {
        return (AudioManagerMode[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }
}
