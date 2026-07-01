package com.discord.rtcconnection.enums;

import android.os.Build$VERSION;

/* JADX INFO: compiled from: AudioManagerBroadcastAction.kt */
/* JADX INFO: loaded from: classes.dex */
public enum AudioManagerBroadcastAction {
    AudioBecomingNoisy("android.media.AUDIO_BECOMING_NOISY"),
    HeadsetPlug("android.intent.action.HEADSET_PLUG"),
    ScoAudioStateUpdated("android.media.ACTION_SCO_AUDIO_STATE_UPDATED"),
    MicrophoneMuteChanged("android.media.action.MICROPHONE_MUTE_CHANGED"),
    SpeakerphoneStateChanged("android.media.action.SPEAKERPHONE_STATE_CHANGED");

    public static final AudioManagerBroadcastAction$a Companion;
    private final String action;

    static {
        int i = Build$VERSION.SDK_INT;
        Companion = new AudioManagerBroadcastAction$a(null);
    }

    AudioManagerBroadcastAction(String str) {
        this.action = str;
    }

    public final String getAction() {
        return this.action;
    }
}
