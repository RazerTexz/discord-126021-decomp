package com.discord.rtcconnection;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: com.discord.rtcconnection.EncodeQuality, reason: use source file name */
/* JADX INFO: compiled from: MediaSinkWantsManager.kt */
/* JADX INFO: loaded from: classes.dex */
public enum MediaSinkWantsManager9 {
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


    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int value;

    /* JADX INFO: renamed from: com.discord.rtcconnection.EncodeQuality$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: MediaSinkWantsManager.kt */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    MediaSinkWantsManager9(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }
}
