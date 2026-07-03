package com.discord.api.premium;

import com.adjust.sdk.Constants;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.models.domain.ModelAuditLogEntry;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.concurrent.TimeUnit;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p579g0.C12103t;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ClaimedOutboundPromotion.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ClaimedOutboundPromotion {
    private final UtcDateTime claimedAt;
    private final String code;
    private final OutboundPromotion promotion;
    private final long userId;

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getCode() {
        return this.code;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final OutboundPromotion getPromotion() {
        return this.promotion;
    }

    /* JADX INFO: renamed from: c */
    public final UtcDateTime m8135c() {
        return new UtcDateTime(TimeUnit.DAYS.toMillis(30L) + this.promotion.getEndDate().getDateTimeMillis());
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0022  */
    /* JADX INFO: renamed from: d */
    public final String m8136d() throws UnsupportedEncodingException {
        String outboundRedemptionPageLink;
        String outboundRedemptionUrlFormat = this.promotion.getOutboundRedemptionUrlFormat();
        if (outboundRedemptionUrlFormat != null) {
            String strEncode = URLEncoder.encode(this.code, Constants.ENCODING);
            C12238m.checkNotNullExpressionValue(strEncode, "URLEncoder.encode(code, \"UTF-8\")");
            outboundRedemptionPageLink = C12103t.replace$default(outboundRedemptionUrlFormat, "{code}", strEncode, false, 4, (Object) null);
            if (outboundRedemptionPageLink == null) {
                outboundRedemptionPageLink = this.promotion.getOutboundRedemptionPageLink();
            }
        } else {
            outboundRedemptionPageLink = this.promotion.getOutboundRedemptionPageLink();
        }
        return outboundRedemptionPageLink != null ? outboundRedemptionPageLink : "";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ClaimedOutboundPromotion)) {
            return false;
        }
        ClaimedOutboundPromotion claimedOutboundPromotion = (ClaimedOutboundPromotion) other;
        return C12238m.areEqual(this.code, claimedOutboundPromotion.code) && this.userId == claimedOutboundPromotion.userId && C12238m.areEqual(this.claimedAt, claimedOutboundPromotion.claimedAt) && C12238m.areEqual(this.promotion, claimedOutboundPromotion.promotion);
    }

    public int hashCode() {
        String str = this.code;
        int iHashCode = str != null ? str.hashCode() : 0;
        long j = this.userId;
        int i = ((iHashCode * 31) + ((int) (j ^ (j >>> 32)))) * 31;
        UtcDateTime utcDateTime = this.claimedAt;
        int iHashCode2 = (i + (utcDateTime != null ? utcDateTime.hashCode() : 0)) * 31;
        OutboundPromotion outboundPromotion = this.promotion;
        return iHashCode2 + (outboundPromotion != null ? outboundPromotion.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("ClaimedOutboundPromotion(code=");
        sbM833U.append(this.code);
        sbM833U.append(", userId=");
        sbM833U.append(this.userId);
        sbM833U.append(", claimedAt=");
        sbM833U.append(this.claimedAt);
        sbM833U.append(", promotion=");
        sbM833U.append(this.promotion);
        sbM833U.append(")");
        return sbM833U.toString();
    }
}
