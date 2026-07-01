package com.discord.widgets.friends;

import b.d.b.a.a;
import com.discord.models.domain.ModelAuditLogEntry;

/* JADX INFO: compiled from: NearbyManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class NearbyManager$NearbyState$Disconnected extends NearbyManager$NearbyState {
    private final int code;

    public NearbyManager$NearbyState$Disconnected(int i) {
        super(null);
        this.code = i;
    }

    public static /* synthetic */ NearbyManager$NearbyState$Disconnected copy$default(NearbyManager$NearbyState$Disconnected nearbyManager$NearbyState$Disconnected, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = nearbyManager$NearbyState$Disconnected.code;
        }
        return nearbyManager$NearbyState$Disconnected.copy(i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getCode() {
        return this.code;
    }

    public final NearbyManager$NearbyState$Disconnected copy(int code) {
        return new NearbyManager$NearbyState$Disconnected(code);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof NearbyManager$NearbyState$Disconnected) && this.code == ((NearbyManager$NearbyState$Disconnected) other).code;
        }
        return true;
    }

    public final int getCode() {
        return this.code;
    }

    public int hashCode() {
        return this.code;
    }

    public String toString() {
        return a.B(a.U("Disconnected(code="), this.code, ")");
    }
}
