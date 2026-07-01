package com.discord.models.domain;

import b.d.b.a.a;
import com.discord.restapi.RestAPIParams$Consents$Type;
import d0.z.d.m;

/* JADX INFO: compiled from: ModelUserConsents.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class Consents {
    public static final Consents$Companion Companion = new Consents$Companion(null);
    private static final Consents DEFAULT = new Consents(new Consent(false, null, 3, null), new Consent(false, null, 3, null));
    private final Consent personalization;
    private final Consent usageStatistics;

    public Consents(Consent consent, Consent consent2) {
        m.checkNotNullParameter(consent, "usageStatistics");
        m.checkNotNullParameter(consent2, RestAPIParams$Consents$Type.PERSONALIZATION);
        this.usageStatistics = consent;
        this.personalization = consent2;
    }

    public static final /* synthetic */ Consents access$getDEFAULT$cp() {
        return DEFAULT;
    }

    public static /* synthetic */ Consents copy$default(Consents consents, Consent consent, Consent consent2, int i, Object obj) {
        if ((i & 1) != 0) {
            consent = consents.usageStatistics;
        }
        if ((i & 2) != 0) {
            consent2 = consents.personalization;
        }
        return consents.copy(consent, consent2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Consent getUsageStatistics() {
        return this.usageStatistics;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Consent getPersonalization() {
        return this.personalization;
    }

    public final Consents copy(Consent usageStatistics, Consent personalization) {
        m.checkNotNullParameter(usageStatistics, "usageStatistics");
        m.checkNotNullParameter(personalization, RestAPIParams$Consents$Type.PERSONALIZATION);
        return new Consents(usageStatistics, personalization);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Consents)) {
            return false;
        }
        Consents consents = (Consents) other;
        return m.areEqual(this.usageStatistics, consents.usageStatistics) && m.areEqual(this.personalization, consents.personalization);
    }

    public final Consent getPersonalization() {
        return this.personalization;
    }

    public final Consent getUsageStatistics() {
        return this.usageStatistics;
    }

    public int hashCode() {
        Consent consent = this.usageStatistics;
        int iHashCode = (consent != null ? consent.hashCode() : 0) * 31;
        Consent consent2 = this.personalization;
        return iHashCode + (consent2 != null ? consent2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("Consents(usageStatistics=");
        sbU.append(this.usageStatistics);
        sbU.append(", personalization=");
        sbU.append(this.personalization);
        sbU.append(")");
        return sbU.toString();
    }
}
