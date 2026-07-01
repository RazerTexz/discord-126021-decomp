package com.discord.rtcconnection;


/* JADX INFO: compiled from: MediaSinkWantsManager.kt */
/* JADX INFO: loaded from: classes.dex */
public enum EncodeQuality {
    Zero(0),
    Ten(10),
    Twenty(20),
    Thirty(30),
    Forty(40),
    Fifty(50),
    Sixty(60),
    Seventy(70),
    Eighty(80),
    Ninety(90),
    Hundred(100);

    public static final EncodeQuality$a Companion = new EncodeQuality$a(null);
    private final int value;

    EncodeQuality(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }
}
