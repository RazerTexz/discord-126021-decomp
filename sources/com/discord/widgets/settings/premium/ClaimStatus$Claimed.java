package com.discord.widgets.settings.premium;

import a0.a.a.b;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import b.d.b.a.a;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.UtcDateTimeParceler;
import d0.z.d.m;

/* JADX INFO: compiled from: ClaimStatus.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ClaimStatus$Claimed extends ClaimStatus {
    public static final Parcelable$Creator<ClaimStatus$Claimed> CREATOR = new ClaimStatus$Claimed$Creator();
    private final String body;
    private final String code;
    private final String link;
    private final long promoId;
    private final UtcDateTime redeemBy;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClaimStatus$Claimed(long j, String str, String str2, String str3, UtcDateTime utcDateTime) {
        super(null);
        m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_CODE);
        m.checkNotNullParameter(str2, "body");
        m.checkNotNullParameter(str3, "link");
        m.checkNotNullParameter(utcDateTime, "redeemBy");
        this.promoId = j;
        this.code = str;
        this.body = str2;
        this.link = str3;
        this.redeemBy = utcDateTime;
    }

    public static /* synthetic */ ClaimStatus$Claimed copy$default(ClaimStatus$Claimed claimStatus$Claimed, long j, String str, String str2, String str3, UtcDateTime utcDateTime, int i, Object obj) {
        if ((i & 1) != 0) {
            j = claimStatus$Claimed.promoId;
        }
        long j2 = j;
        if ((i & 2) != 0) {
            str = claimStatus$Claimed.code;
        }
        String str4 = str;
        if ((i & 4) != 0) {
            str2 = claimStatus$Claimed.body;
        }
        String str5 = str2;
        if ((i & 8) != 0) {
            str3 = claimStatus$Claimed.link;
        }
        String str6 = str3;
        if ((i & 16) != 0) {
            utcDateTime = claimStatus$Claimed.redeemBy;
        }
        return claimStatus$Claimed.copy(j2, str4, str5, str6, utcDateTime);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getPromoId() {
        return this.promoId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getCode() {
        return this.code;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getBody() {
        return this.body;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getLink() {
        return this.link;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final UtcDateTime getRedeemBy() {
        return this.redeemBy;
    }

    public final ClaimStatus$Claimed copy(long promoId, String code, String body, String link, UtcDateTime redeemBy) {
        m.checkNotNullParameter(code, ModelAuditLogEntry.CHANGE_KEY_CODE);
        m.checkNotNullParameter(body, "body");
        m.checkNotNullParameter(link, "link");
        m.checkNotNullParameter(redeemBy, "redeemBy");
        return new ClaimStatus$Claimed(promoId, code, body, link, redeemBy);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ClaimStatus$Claimed)) {
            return false;
        }
        ClaimStatus$Claimed claimStatus$Claimed = (ClaimStatus$Claimed) other;
        return this.promoId == claimStatus$Claimed.promoId && m.areEqual(this.code, claimStatus$Claimed.code) && m.areEqual(this.body, claimStatus$Claimed.body) && m.areEqual(this.link, claimStatus$Claimed.link) && m.areEqual(this.redeemBy, claimStatus$Claimed.redeemBy);
    }

    public final String getBody() {
        return this.body;
    }

    public final String getCode() {
        return this.code;
    }

    public final String getLink() {
        return this.link;
    }

    public final long getPromoId() {
        return this.promoId;
    }

    public final UtcDateTime getRedeemBy() {
        return this.redeemBy;
    }

    public int hashCode() {
        int iA = b.a(this.promoId) * 31;
        String str = this.code;
        int iHashCode = (iA + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.body;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.link;
        int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        UtcDateTime utcDateTime = this.redeemBy;
        return iHashCode3 + (utcDateTime != null ? utcDateTime.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("Claimed(promoId=");
        sbU.append(this.promoId);
        sbU.append(", code=");
        sbU.append(this.code);
        sbU.append(", body=");
        sbU.append(this.body);
        sbU.append(", link=");
        sbU.append(this.link);
        sbU.append(", redeemBy=");
        sbU.append(this.redeemBy);
        sbU.append(")");
        return sbU.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        m.checkNotNullParameter(parcel, "parcel");
        parcel.writeLong(this.promoId);
        parcel.writeString(this.code);
        parcel.writeString(this.body);
        parcel.writeString(this.link);
        UtcDateTimeParceler.INSTANCE.write(this.redeemBy, parcel, flags);
    }
}
