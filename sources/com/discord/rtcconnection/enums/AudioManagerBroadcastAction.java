package com.discord.rtcconnection.enums;

import android.os.Build;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: AudioManagerBroadcastAction.kt */
/* JADX INFO: loaded from: classes.dex */
public enum AudioManagerBroadcastAction {
    AudioBecomingNoisy("android.media.AUDIO_BECOMING_NOISY"),
    HeadsetPlug("android.intent.action.HEADSET_PLUG"),
    ScoAudioStateUpdated("android.media.ACTION_SCO_AUDIO_STATE_UPDATED"),
    MicrophoneMuteChanged("android.media.action.MICROPHONE_MUTE_CHANGED"),
    SpeakerphoneStateChanged("android.media.action.SPEAKERPHONE_STATE_CHANGED");


    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private final String action;

    /* JADX INFO: renamed from: com.discord.rtcconnection.enums.AudioManagerBroadcastAction$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: AudioManagerBroadcastAction.kt */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        INSTANCE = new Companion(null);
    }

    AudioManagerBroadcastAction(String str) {
        this.action = str;
    }

    public final String getAction() {
        return this.action;
    }
}
