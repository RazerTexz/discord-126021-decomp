package com.discord.models.domain;

import b.d.b.a.a;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ModelUserConsents.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class Consent {
    private final String changedAt;
    private final boolean consented;

    public Consent() {
        this(false, null, 3, null);
    }

    public Consent(boolean z2, String str) {
        this.consented = z2;
        this.changedAt = str;
    }

    public static /* synthetic */ Consent copy$default(Consent consent, boolean z2, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = consent.consented;
        }
        if ((i & 2) != 0) {
            str = consent.changedAt;
        }
        return consent.copy(z2, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getConsented() {
        return this.consented;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getChangedAt() {
        return this.changedAt;
    }

    public final Consent copy(boolean consented, String changedAt) {
        return new Consent(consented, changedAt);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Consent)) {
            return false;
        }
        Consent consent = (Consent) other;
        return this.consented == consent.consented && m.areEqual(this.changedAt, consent.changedAt);
    }

    public final String getChangedAt() {
        return this.changedAt;
    }

    public final boolean getConsented() {
        return this.consented;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z2 = this.consented;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = r0 * 31;
        String str = this.changedAt;
        return i + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("Consent(consented=");
        sbU.append(this.consented);
        sbU.append(", changedAt=");
        return a.J(sbU, this.changedAt, ")");
    }

    public /* synthetic */ Consent(boolean z2, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z2, (i & 2) != 0 ? null : str);
    }
}
