package com.discord.stores;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable$Creator;
import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: StoreInviteSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StoreInviteSettings$InviteCode implements Parcelable {
    public static final Parcelable$Creator<StoreInviteSettings$InviteCode> CREATOR = new StoreInviteSettings$InviteCode$Creator();
    private final Long eventId;
    private final String inviteCode;
    private final String source;

    public StoreInviteSettings$InviteCode(String str, String str2, Long l) {
        m.checkNotNullParameter(str, "inviteCode");
        m.checkNotNullParameter(str2, "source");
        this.inviteCode = str;
        this.source = str2;
        this.eventId = l;
    }

    public static /* synthetic */ StoreInviteSettings$InviteCode copy$default(StoreInviteSettings$InviteCode storeInviteSettings$InviteCode, String str, String str2, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            str = storeInviteSettings$InviteCode.inviteCode;
        }
        if ((i & 2) != 0) {
            str2 = storeInviteSettings$InviteCode.source;
        }
        if ((i & 4) != 0) {
            l = storeInviteSettings$InviteCode.eventId;
        }
        return storeInviteSettings$InviteCode.copy(str, str2, l);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getInviteCode() {
        return this.inviteCode;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSource() {
        return this.source;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Long getEventId() {
        return this.eventId;
    }

    public final StoreInviteSettings$InviteCode copy(String inviteCode, String source, Long eventId) {
        m.checkNotNullParameter(inviteCode, "inviteCode");
        m.checkNotNullParameter(source, "source");
        return new StoreInviteSettings$InviteCode(inviteCode, source, eventId);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StoreInviteSettings$InviteCode)) {
            return false;
        }
        StoreInviteSettings$InviteCode storeInviteSettings$InviteCode = (StoreInviteSettings$InviteCode) other;
        return m.areEqual(this.inviteCode, storeInviteSettings$InviteCode.inviteCode) && m.areEqual(this.source, storeInviteSettings$InviteCode.source) && m.areEqual(this.eventId, storeInviteSettings$InviteCode.eventId);
    }

    public final Long getEventId() {
        return this.eventId;
    }

    public final String getInviteCode() {
        return this.inviteCode;
    }

    public final String getSource() {
        return this.source;
    }

    public int hashCode() {
        String str = this.inviteCode;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.source;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Long l = this.eventId;
        return iHashCode2 + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("InviteCode(inviteCode=");
        sbU.append(this.inviteCode);
        sbU.append(", source=");
        sbU.append(this.source);
        sbU.append(", eventId=");
        return a.G(sbU, this.eventId, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        m.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.inviteCode);
        parcel.writeString(this.source);
        Long l = this.eventId;
        if (l == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeLong(l.longValue());
        }
    }
}
