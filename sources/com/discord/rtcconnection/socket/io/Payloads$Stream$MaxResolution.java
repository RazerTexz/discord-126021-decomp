package com.discord.rtcconnection.socket.io;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: Payloads.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class Payloads$Stream$MaxResolution {
    private final int height;
    private final Payloads$ResolutionType type;
    private final int width;

    public Payloads$Stream$MaxResolution(Payloads$ResolutionType payloads$ResolutionType, int i, int i2) {
        m.checkNotNullParameter(payloads$ResolutionType, "type");
        this.type = payloads$ResolutionType;
        this.width = i;
        this.height = i2;
    }

    public static /* synthetic */ Payloads$Stream$MaxResolution copy$default(Payloads$Stream$MaxResolution payloads$Stream$MaxResolution, Payloads$ResolutionType payloads$ResolutionType, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            payloads$ResolutionType = payloads$Stream$MaxResolution.type;
        }
        if ((i3 & 2) != 0) {
            i = payloads$Stream$MaxResolution.width;
        }
        if ((i3 & 4) != 0) {
            i2 = payloads$Stream$MaxResolution.height;
        }
        return payloads$Stream$MaxResolution.copy(payloads$ResolutionType, i, i2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Payloads$ResolutionType getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getWidth() {
        return this.width;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getHeight() {
        return this.height;
    }

    public final Payloads$Stream$MaxResolution copy(Payloads$ResolutionType type, int width, int height) {
        m.checkNotNullParameter(type, "type");
        return new Payloads$Stream$MaxResolution(type, width, height);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Payloads$Stream$MaxResolution)) {
            return false;
        }
        Payloads$Stream$MaxResolution payloads$Stream$MaxResolution = (Payloads$Stream$MaxResolution) other;
        return m.areEqual(this.type, payloads$Stream$MaxResolution.type) && this.width == payloads$Stream$MaxResolution.width && this.height == payloads$Stream$MaxResolution.height;
    }

    public final int getHeight() {
        return this.height;
    }

    public final Payloads$ResolutionType getType() {
        return this.type;
    }

    public final int getWidth() {
        return this.width;
    }

    public int hashCode() {
        Payloads$ResolutionType payloads$ResolutionType = this.type;
        return ((((payloads$ResolutionType != null ? payloads$ResolutionType.hashCode() : 0) * 31) + this.width) * 31) + this.height;
    }

    public String toString() {
        StringBuilder sbU = a.U("MaxResolution(type=");
        sbU.append(this.type);
        sbU.append(", width=");
        sbU.append(this.width);
        sbU.append(", height=");
        return a.B(sbU, this.height, ")");
    }
}
