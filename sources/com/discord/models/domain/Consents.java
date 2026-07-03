package com.discord.models.domain;

import com.discord.restapi.RestAPIParams;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ModelUserConsents.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class Consents {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Consents DEFAULT = new Consents(new Consent(false, null, 3, null), new Consent(false, null, 3, null));
    private final Consent personalization;
    private final Consent usageStatistics;

    /* JADX INFO: compiled from: ModelUserConsents.kt */
    public static final class Companion {
        private Companion() {
        }

        public final Consents getDEFAULT() {
            return Consents.DEFAULT;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public Consents(Consent consent, Consent consent2) {
        C12238m.checkNotNullParameter(consent, "usageStatistics");
        C12238m.checkNotNullParameter(consent2, RestAPIParams.Consents.Type.PERSONALIZATION);
        this.usageStatistics = consent;
        this.personalization = consent2;
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
        C12238m.checkNotNullParameter(usageStatistics, "usageStatistics");
        C12238m.checkNotNullParameter(personalization, RestAPIParams.Consents.Type.PERSONALIZATION);
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
        return C12238m.areEqual(this.usageStatistics, consents.usageStatistics) && C12238m.areEqual(this.personalization, consents.personalization);
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
        StringBuilder sbM833U = C1643a.m833U("Consents(usageStatistics=");
        sbM833U.append(this.usageStatistics);
        sbM833U.append(", personalization=");
        sbM833U.append(this.personalization);
        sbM833U.append(")");
        return sbM833U.toString();
    }
}
