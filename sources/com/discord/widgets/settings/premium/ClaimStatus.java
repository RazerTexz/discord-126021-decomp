package com.discord.widgets.settings.premium;

import a0.a.a.b;
import android.os.Parcel;
import android.os.Parcelable;
import b.d.b.a.outline;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.Parcelers;
import d0.z.d.Intrinsics3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ClaimStatus.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class ClaimStatus implements Parcelable {

    /* JADX INFO: compiled from: ClaimStatus.kt */
    public static final /* data */ class Claimed extends ClaimStatus {
        public static final Parcelable.Creator<Claimed> CREATOR = new Creator();
        private final String body;
        private final String code;
        private final String link;
        private final long promoId;
        private final UtcDateTime redeemBy;

        public static class Creator implements Parcelable.Creator<Claimed> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Claimed createFromParcel(Parcel parcel) {
                Intrinsics3.checkNotNullParameter(parcel, "in");
                return new Claimed(parcel.readLong(), parcel.readString(), parcel.readString(), parcel.readString(), Parcelers.INSTANCE.create(parcel));
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Claimed[] newArray(int i) {
                return new Claimed[i];
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Claimed(long j, String str, String str2, String str3, UtcDateTime utcDateTime) {
            super(null);
            Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_CODE);
            Intrinsics3.checkNotNullParameter(str2, "body");
            Intrinsics3.checkNotNullParameter(str3, "link");
            Intrinsics3.checkNotNullParameter(utcDateTime, "redeemBy");
            this.promoId = j;
            this.code = str;
            this.body = str2;
            this.link = str3;
            this.redeemBy = utcDateTime;
        }

        public static /* synthetic */ Claimed copy$default(Claimed claimed, long j, String str, String str2, String str3, UtcDateTime utcDateTime, int i, Object obj) {
            if ((i & 1) != 0) {
                j = claimed.promoId;
            }
            long j2 = j;
            if ((i & 2) != 0) {
                str = claimed.code;
            }
            String str4 = str;
            if ((i & 4) != 0) {
                str2 = claimed.body;
            }
            String str5 = str2;
            if ((i & 8) != 0) {
                str3 = claimed.link;
            }
            String str6 = str3;
            if ((i & 16) != 0) {
                utcDateTime = claimed.redeemBy;
            }
            return claimed.copy(j2, str4, str5, str6, utcDateTime);
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

        public final Claimed copy(long promoId, String code, String body, String link, UtcDateTime redeemBy) {
            Intrinsics3.checkNotNullParameter(code, ModelAuditLogEntry.CHANGE_KEY_CODE);
            Intrinsics3.checkNotNullParameter(body, "body");
            Intrinsics3.checkNotNullParameter(link, "link");
            Intrinsics3.checkNotNullParameter(redeemBy, "redeemBy");
            return new Claimed(promoId, code, body, link, redeemBy);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Claimed)) {
                return false;
            }
            Claimed claimed = (Claimed) other;
            return this.promoId == claimed.promoId && Intrinsics3.areEqual(this.code, claimed.code) && Intrinsics3.areEqual(this.body, claimed.body) && Intrinsics3.areEqual(this.link, claimed.link) && Intrinsics3.areEqual(this.redeemBy, claimed.redeemBy);
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
            StringBuilder sbU = outline.U("Claimed(promoId=");
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
            Intrinsics3.checkNotNullParameter(parcel, "parcel");
            parcel.writeLong(this.promoId);
            parcel.writeString(this.code);
            parcel.writeString(this.body);
            parcel.writeString(this.link);
            Parcelers.INSTANCE.write(this.redeemBy, parcel, flags);
        }
    }

    /* JADX INFO: compiled from: ClaimStatus.kt */
    public static final /* data */ class Unclaimed extends ClaimStatus {
        public static final Parcelable.Creator<Unclaimed> CREATOR = new Creator();
        private final UtcDateTime claimBy;
        private final long promoId;

        public static class Creator implements Parcelable.Creator<Unclaimed> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Unclaimed createFromParcel(Parcel parcel) {
                Intrinsics3.checkNotNullParameter(parcel, "in");
                return new Unclaimed(parcel.readLong(), Parcelers.INSTANCE.create(parcel));
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Unclaimed[] newArray(int i) {
                return new Unclaimed[i];
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Unclaimed(long j, UtcDateTime utcDateTime) {
            super(null);
            Intrinsics3.checkNotNullParameter(utcDateTime, "claimBy");
            this.promoId = j;
            this.claimBy = utcDateTime;
        }

        public static /* synthetic */ Unclaimed copy$default(Unclaimed unclaimed, long j, UtcDateTime utcDateTime, int i, Object obj) {
            if ((i & 1) != 0) {
                j = unclaimed.promoId;
            }
            if ((i & 2) != 0) {
                utcDateTime = unclaimed.claimBy;
            }
            return unclaimed.copy(j, utcDateTime);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getPromoId() {
            return this.promoId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final UtcDateTime getClaimBy() {
            return this.claimBy;
        }

        public final Unclaimed copy(long promoId, UtcDateTime claimBy) {
            Intrinsics3.checkNotNullParameter(claimBy, "claimBy");
            return new Unclaimed(promoId, claimBy);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Unclaimed)) {
                return false;
            }
            Unclaimed unclaimed = (Unclaimed) other;
            return this.promoId == unclaimed.promoId && Intrinsics3.areEqual(this.claimBy, unclaimed.claimBy);
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
            StringBuilder sbU = outline.U("Unclaimed(promoId=");
            sbU.append(this.promoId);
            sbU.append(", claimBy=");
            sbU.append(this.claimBy);
            sbU.append(")");
            return sbU.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics3.checkNotNullParameter(parcel, "parcel");
            parcel.writeLong(this.promoId);
            Parcelers.INSTANCE.write(this.claimBy, parcel, flags);
        }
    }

    private ClaimStatus() {
    }

    public /* synthetic */ ClaimStatus(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
