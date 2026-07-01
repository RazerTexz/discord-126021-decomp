package com.discord.models.domain;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: com.discord.models.domain.Consent, reason: use source file name */
/* JADX INFO: compiled from: ModelUserConsents.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ModelUserConsents {
    private final String changedAt;
    private final boolean consented;

    /* JADX WARN: Multi-variable type inference failed */
    public ModelUserConsents() {
        this(false, null, 3, 0 == true ? 1 : 0);
    }

    public ModelUserConsents(boolean z2, String str) {
        this.consented = z2;
        this.changedAt = str;
    }

    public static /* synthetic */ ModelUserConsents copy$default(ModelUserConsents modelUserConsents, boolean z2, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = modelUserConsents.consented;
        }
        if ((i & 2) != 0) {
            str = modelUserConsents.changedAt;
        }
        return modelUserConsents.copy(z2, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getConsented() {
        return this.consented;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getChangedAt() {
        return this.changedAt;
    }

    public final ModelUserConsents copy(boolean consented, String changedAt) {
        return new ModelUserConsents(consented, changedAt);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelUserConsents)) {
            return false;
        }
        ModelUserConsents modelUserConsents = (ModelUserConsents) other;
        return this.consented == modelUserConsents.consented && Intrinsics3.areEqual(this.changedAt, modelUserConsents.changedAt);
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
        StringBuilder sbU = outline.U("Consent(consented=");
        sbU.append(this.consented);
        sbU.append(", changedAt=");
        return outline.J(sbU, this.changedAt, ")");
    }

    public /* synthetic */ ModelUserConsents(boolean z2, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z2, (i & 2) != 0 ? null : str);
    }
}
