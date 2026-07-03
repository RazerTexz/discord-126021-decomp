package com.discord.models.domain;

import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ModelUserConsents.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class Consent {
    private final String changedAt;
    private final boolean consented;

    /* JADX WARN: Multi-variable type inference failed */
    public Consent() {
        this(false, null, 3, 0 == true ? 1 : 0);
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
        return this.consented == consent.consented && C12238m.areEqual(this.changedAt, consent.changedAt);
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
        StringBuilder sbM833U = C1643a.m833U("Consent(consented=");
        sbM833U.append(this.consented);
        sbM833U.append(", changedAt=");
        return C1643a.m822J(sbM833U, this.changedAt, ")");
    }

    public /* synthetic */ Consent(boolean z2, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z2, (i & 2) != 0 ? null : str);
    }
}
