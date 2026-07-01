package com.discord.widgets.settings.premium;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: ClaimOutboundPromoViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ClaimOutboundPromoViewModel$Event$OpenRedemptionUrl extends ClaimOutboundPromoViewModel$Event {
    private final String url;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClaimOutboundPromoViewModel$Event$OpenRedemptionUrl(String str) {
        super(null);
        m.checkNotNullParameter(str, "url");
        this.url = str;
    }

    public static /* synthetic */ ClaimOutboundPromoViewModel$Event$OpenRedemptionUrl copy$default(ClaimOutboundPromoViewModel$Event$OpenRedemptionUrl claimOutboundPromoViewModel$Event$OpenRedemptionUrl, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = claimOutboundPromoViewModel$Event$OpenRedemptionUrl.url;
        }
        return claimOutboundPromoViewModel$Event$OpenRedemptionUrl.copy(str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    public final ClaimOutboundPromoViewModel$Event$OpenRedemptionUrl copy(String url) {
        m.checkNotNullParameter(url, "url");
        return new ClaimOutboundPromoViewModel$Event$OpenRedemptionUrl(url);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof ClaimOutboundPromoViewModel$Event$OpenRedemptionUrl) && m.areEqual(this.url, ((ClaimOutboundPromoViewModel$Event$OpenRedemptionUrl) other).url);
        }
        return true;
    }

    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        String str = this.url;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return a.J(a.U("OpenRedemptionUrl(url="), this.url, ")");
    }
}
