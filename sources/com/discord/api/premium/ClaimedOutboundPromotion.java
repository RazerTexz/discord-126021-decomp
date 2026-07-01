package com.discord.api.premium;

import b.d.b.a.outline;
import com.adjust.sdk.Constants;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.g0.StringsJVM;
import d0.z.d.Intrinsics3;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.concurrent.TimeUnit;

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

    public final UtcDateTime c() {
        return new UtcDateTime(TimeUnit.DAYS.toMillis(30L) + this.promotion.getEndDate().getDateTimeMillis());
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0022  */
    public final String d() throws UnsupportedEncodingException {
        String outboundRedemptionPageLink;
        String outboundRedemptionUrlFormat = this.promotion.getOutboundRedemptionUrlFormat();
        if (outboundRedemptionUrlFormat != null) {
            String strEncode = URLEncoder.encode(this.code, Constants.ENCODING);
            Intrinsics3.checkNotNullExpressionValue(strEncode, "URLEncoder.encode(code, \"UTF-8\")");
            outboundRedemptionPageLink = StringsJVM.replace$default(outboundRedemptionUrlFormat, "{code}", strEncode, false, 4, (Object) null);
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
        return Intrinsics3.areEqual(this.code, claimedOutboundPromotion.code) && this.userId == claimedOutboundPromotion.userId && Intrinsics3.areEqual(this.claimedAt, claimedOutboundPromotion.claimedAt) && Intrinsics3.areEqual(this.promotion, claimedOutboundPromotion.promotion);
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
        StringBuilder sbU = outline.U("ClaimedOutboundPromotion(code=");
        sbU.append(this.code);
        sbU.append(", userId=");
        sbU.append(this.userId);
        sbU.append(", claimedAt=");
        sbU.append(this.claimedAt);
        sbU.append(", promotion=");
        sbU.append(this.promotion);
        sbU.append(")");
        return sbU.toString();
    }
}
