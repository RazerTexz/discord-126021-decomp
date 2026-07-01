package com.discord.widgets.settings.premium;

import a0.a.a.b;
import b.d.b.a.a;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;

/* JADX INFO: compiled from: SettingsGiftingViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class SettingsGiftingViewModel$OutboundPromoItem {
    private final ClaimStatus claimStatus;
    private final long id;
    private final String imageUrl;
    private final String terms;
    private final String title;

    public SettingsGiftingViewModel$OutboundPromoItem(ClaimStatus claimStatus, long j, String str, String str2, String str3) {
        m.checkNotNullParameter(claimStatus, "claimStatus");
        m.checkNotNullParameter(str, "title");
        m.checkNotNullParameter(str2, "terms");
        m.checkNotNullParameter(str3, "imageUrl");
        this.claimStatus = claimStatus;
        this.id = j;
        this.title = str;
        this.terms = str2;
        this.imageUrl = str3;
    }

    public static /* synthetic */ SettingsGiftingViewModel$OutboundPromoItem copy$default(SettingsGiftingViewModel$OutboundPromoItem settingsGiftingViewModel$OutboundPromoItem, ClaimStatus claimStatus, long j, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            claimStatus = settingsGiftingViewModel$OutboundPromoItem.claimStatus;
        }
        if ((i & 2) != 0) {
            j = settingsGiftingViewModel$OutboundPromoItem.id;
        }
        long j2 = j;
        if ((i & 4) != 0) {
            str = settingsGiftingViewModel$OutboundPromoItem.title;
        }
        String str4 = str;
        if ((i & 8) != 0) {
            str2 = settingsGiftingViewModel$OutboundPromoItem.terms;
        }
        String str5 = str2;
        if ((i & 16) != 0) {
            str3 = settingsGiftingViewModel$OutboundPromoItem.imageUrl;
        }
        return settingsGiftingViewModel$OutboundPromoItem.copy(claimStatus, j2, str4, str5, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ClaimStatus getClaimStatus() {
        return this.claimStatus;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getTerms() {
        return this.terms;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final SettingsGiftingViewModel$OutboundPromoItem copy(ClaimStatus claimStatus, long id2, String title, String terms, String imageUrl) {
        m.checkNotNullParameter(claimStatus, "claimStatus");
        m.checkNotNullParameter(title, "title");
        m.checkNotNullParameter(terms, "terms");
        m.checkNotNullParameter(imageUrl, "imageUrl");
        return new SettingsGiftingViewModel$OutboundPromoItem(claimStatus, id2, title, terms, imageUrl);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SettingsGiftingViewModel$OutboundPromoItem)) {
            return false;
        }
        SettingsGiftingViewModel$OutboundPromoItem settingsGiftingViewModel$OutboundPromoItem = (SettingsGiftingViewModel$OutboundPromoItem) other;
        return m.areEqual(this.claimStatus, settingsGiftingViewModel$OutboundPromoItem.claimStatus) && this.id == settingsGiftingViewModel$OutboundPromoItem.id && m.areEqual(this.title, settingsGiftingViewModel$OutboundPromoItem.title) && m.areEqual(this.terms, settingsGiftingViewModel$OutboundPromoItem.terms) && m.areEqual(this.imageUrl, settingsGiftingViewModel$OutboundPromoItem.imageUrl);
    }

    public final ClaimStatus getClaimStatus() {
        return this.claimStatus;
    }

    public final long getId() {
        return this.id;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final String getTerms() {
        return this.terms;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        ClaimStatus claimStatus = this.claimStatus;
        int iA = (b.a(this.id) + ((claimStatus != null ? claimStatus.hashCode() : 0) * 31)) * 31;
        String str = this.title;
        int iHashCode = (iA + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.terms;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.imageUrl;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("OutboundPromoItem(claimStatus=");
        sbU.append(this.claimStatus);
        sbU.append(", id=");
        sbU.append(this.id);
        sbU.append(", title=");
        sbU.append(this.title);
        sbU.append(", terms=");
        sbU.append(this.terms);
        sbU.append(", imageUrl=");
        return a.J(sbU, this.imageUrl, ")");
    }
}
