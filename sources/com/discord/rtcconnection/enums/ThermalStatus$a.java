package com.discord.rtcconnection.enums;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ThermalStatus.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ThermalStatus$a {
    public ThermalStatus$a(DefaultConstructorMarker defaultConstructorMarker) {
    }

    /* JADX WARN: Code duplicated, block: B:15:0x001e  */
    /* JADX WARN: Code duplicated, block: B:19:? A[RETURN, SYNTHETIC] */
    public final ThermalStatus a(int i) {
        ThermalStatus thermalStatus;
        ThermalStatus[] thermalStatusArrValues = ThermalStatus.values();
        for (int i2 = 0; i2 < 7; i2++) {
            thermalStatus = thermalStatusArrValues[i2];
            if (thermalStatus.getValue() == i) {
                if (thermalStatus != null) {
                    return thermalStatus;
                }
                return ThermalStatus.None;
            }
        }
        thermalStatus = null;
        if (thermalStatus != null) {
            return thermalStatus;
        }
        return ThermalStatus.None;
    }
}
