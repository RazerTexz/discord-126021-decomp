package com.discord.rtcconnection.enums;

import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: ThermalStatus.kt */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(29)
public enum ThermalStatus {
    None(0),
    Light(1),
    Moderate(2),
    Severe(3),
    Critical(4),
    Emergency(5),
    Shutdown(6);

    public static final ThermalStatus$a Companion = new ThermalStatus$a(null);
    private final int value;

    ThermalStatus(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }
}
