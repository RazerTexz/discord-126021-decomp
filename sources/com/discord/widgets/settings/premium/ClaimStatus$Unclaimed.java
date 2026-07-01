package com.discord.widgets.settings.premium;

import a0.a.a.b;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import b.d.b.a.a;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.utilities.UtcDateTimeParceler;
import d0.z.d.m;

/* JADX INFO: compiled from: ClaimStatus.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ClaimStatus$Unclaimed extends ClaimStatus {
    public static final Parcelable$Creator<ClaimStatus$Unclaimed> CREATOR = new ClaimStatus$Unclaimed$Creator();
    private final UtcDateTime claimBy;
    private final long promoId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClaimStatus$Unclaimed(long j, UtcDateTime utcDateTime) {
        super(null);
        m.checkNotNullParameter(utcDateTime, "claimBy");
        this.promoId = j;
        this.claimBy = utcDateTime;
    }

    public static /* synthetic */ ClaimStatus$Unclaimed copy$default(ClaimStatus$Unclaimed claimStatus$Unclaimed, long j, UtcDateTime utcDateTime, int i, Object obj) {
        if ((i & 1) != 0) {
            j = claimStatus$Unclaimed.promoId;
        }
        if ((i & 2) != 0) {
            utcDateTime = claimStatus$Unclaimed.claimBy;
        }
        return claimStatus$Unclaimed.copy(j, utcDateTime);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getPromoId() {
        return this.promoId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final UtcDateTime getClaimBy() {
        return this.claimBy;
    }

    public final ClaimStatus$Unclaimed copy(long promoId, UtcDateTime claimBy) {
        m.checkNotNullParameter(claimBy, "claimBy");
        return new ClaimStatus$Unclaimed(promoId, claimBy);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ClaimStatus$Unclaimed)) {
            return false;
        }
        ClaimStatus$Unclaimed claimStatus$Unclaimed = (ClaimStatus$Unclaimed) other;
        return this.promoId == claimStatus$Unclaimed.promoId && m.areEqual(this.claimBy, claimStatus$Unclaimed.claimBy);
    }

    public final UtcDateTime getClaimBy() {
        return this.claimBy;
    }

    public final long getPromoId() {
        return this.promoId;
    }

    public int hashCode() {
        int iA = b.a(this.promoId) * 31;
        UtcDateTime utcDateTime = this.claimBy;
        return iA + (utcDateTime != null ? utcDateTime.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("Unclaimed(promoId=");
        sbU.append(this.promoId);
        sbU.append(", claimBy=");
        sbU.append(this.claimBy);
        sbU.append(")");
        return sbU.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        m.checkNotNullParameter(parcel, "parcel");
        parcel.writeLong(this.promoId);
        UtcDateTimeParceler.INSTANCE.write(this.claimBy, parcel, flags);
    }
}
