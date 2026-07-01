package com.discord.rtcconnection.mediaengine;


/* JADX INFO: compiled from: MediaEngineConnection.kt */
/* JADX INFO: loaded from: classes.dex */
public enum MediaEngineConnection$InputMode {
    VOICE_ACTIVITY(1),
    PUSH_TO_TALK(2);

    public static final MediaEngineConnection$InputMode$a Companion = new MediaEngineConnection$InputMode$a(null);
    private final int numeral;

    MediaEngineConnection$InputMode(int i) {
        this.numeral = i;
    }

    public final int getNumeral() {
        return this.numeral;
    }
}
