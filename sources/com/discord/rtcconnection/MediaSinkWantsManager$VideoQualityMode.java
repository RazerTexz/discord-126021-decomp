package com.discord.rtcconnection;


/* JADX INFO: compiled from: MediaSinkWantsManager.kt */
/* JADX INFO: loaded from: classes.dex */
public enum MediaSinkWantsManager$VideoQualityMode {
    AUTO(1),
    FULL(2);

    public static final MediaSinkWantsManager$VideoQualityMode$a Companion = new MediaSinkWantsManager$VideoQualityMode$a(null);
    private final int numeral;

    MediaSinkWantsManager$VideoQualityMode(int i) {
        this.numeral = i;
    }

    public final int getNumeral() {
        return this.numeral;
    }
}
