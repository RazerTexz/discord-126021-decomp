package com.discord.rtcconnection.enums;

import androidx.annotation.RequiresApi;
import kotlin.jvm.internal.DefaultConstructorMarker;

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


    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int value;

    /* JADX INFO: renamed from: com.discord.rtcconnection.enums.ThermalStatus$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: ThermalStatus.kt */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
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

    ThermalStatus(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }
}
