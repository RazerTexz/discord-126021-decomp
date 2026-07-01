package com.discord.widgets.servers.creator_monetization_eligibility;

import b.d.b.a.a;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;

/* JADX INFO: compiled from: EligibilityChecklistView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class EligibilityChecklistView$Requirement {
    private final CharSequence description;
    private final boolean isMet;
    private final CharSequence title;

    public EligibilityChecklistView$Requirement(CharSequence charSequence, CharSequence charSequence2, boolean z2) {
        m.checkNotNullParameter(charSequence, "title");
        m.checkNotNullParameter(charSequence2, ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION);
        this.title = charSequence;
        this.description = charSequence2;
        this.isMet = z2;
    }

    public static /* synthetic */ EligibilityChecklistView$Requirement copy$default(EligibilityChecklistView$Requirement eligibilityChecklistView$Requirement, CharSequence charSequence, CharSequence charSequence2, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            charSequence = eligibilityChecklistView$Requirement.title;
        }
        if ((i & 2) != 0) {
            charSequence2 = eligibilityChecklistView$Requirement.description;
        }
        if ((i & 4) != 0) {
            z2 = eligibilityChecklistView$Requirement.isMet;
        }
        return eligibilityChecklistView$Requirement.copy(charSequence, charSequence2, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final CharSequence getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final CharSequence getDescription() {
        return this.description;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsMet() {
        return this.isMet;
    }

    public final EligibilityChecklistView$Requirement copy(CharSequence title, CharSequence description, boolean isMet) {
        m.checkNotNullParameter(title, "title");
        m.checkNotNullParameter(description, ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION);
        return new EligibilityChecklistView$Requirement(title, description, isMet);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EligibilityChecklistView$Requirement)) {
            return false;
        }
        EligibilityChecklistView$Requirement eligibilityChecklistView$Requirement = (EligibilityChecklistView$Requirement) other;
        return m.areEqual(this.title, eligibilityChecklistView$Requirement.title) && m.areEqual(this.description, eligibilityChecklistView$Requirement.description) && this.isMet == eligibilityChecklistView$Requirement.isMet;
    }

    public final CharSequence getDescription() {
        return this.description;
    }

    public final CharSequence getTitle() {
        return this.title;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public int hashCode() {
        CharSequence charSequence = this.title;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.description;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        boolean z2 = this.isMet;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return iHashCode2 + r1;
    }

    public final boolean isMet() {
        return this.isMet;
    }

    public String toString() {
        StringBuilder sbU = a.U("Requirement(title=");
        sbU.append(this.title);
        sbU.append(", description=");
        sbU.append(this.description);
        sbU.append(", isMet=");
        return a.O(sbU, this.isMet, ")");
    }
}
