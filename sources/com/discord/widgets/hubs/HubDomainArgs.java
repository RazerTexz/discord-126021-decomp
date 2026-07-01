package com.discord.widgets.hubs;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable$Creator;
import androidx.core.app.NotificationCompat;
import b.d.b.a.a;
import d0.z.d.m;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: WidgetHubDomains.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class HubDomainArgs implements Parcelable {
    public static final Parcelable$Creator<HubDomainArgs> CREATOR = new HubDomainArgs$Creator();
    private final String email;
    private final List<DomainGuildInfo> guildInfos;

    public HubDomainArgs(String str, List<DomainGuildInfo> list) {
        m.checkNotNullParameter(str, NotificationCompat.CATEGORY_EMAIL);
        m.checkNotNullParameter(list, "guildInfos");
        this.email = str;
        this.guildInfos = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HubDomainArgs copy$default(HubDomainArgs hubDomainArgs, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = hubDomainArgs.email;
        }
        if ((i & 2) != 0) {
            list = hubDomainArgs.guildInfos;
        }
        return hubDomainArgs.copy(str, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getEmail() {
        return this.email;
    }

    public final List<DomainGuildInfo> component2() {
        return this.guildInfos;
    }

    public final HubDomainArgs copy(String email, List<DomainGuildInfo> guildInfos) {
        m.checkNotNullParameter(email, NotificationCompat.CATEGORY_EMAIL);
        m.checkNotNullParameter(guildInfos, "guildInfos");
        return new HubDomainArgs(email, guildInfos);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HubDomainArgs)) {
            return false;
        }
        HubDomainArgs hubDomainArgs = (HubDomainArgs) other;
        return m.areEqual(this.email, hubDomainArgs.email) && m.areEqual(this.guildInfos, hubDomainArgs.guildInfos);
    }

    public final String getEmail() {
        return this.email;
    }

    public final List<DomainGuildInfo> getGuildInfos() {
        return this.guildInfos;
    }

    public int hashCode() {
        String str = this.email;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        List<DomainGuildInfo> list = this.guildInfos;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("HubDomainArgs(email=");
        sbU.append(this.email);
        sbU.append(", guildInfos=");
        return a.L(sbU, this.guildInfos, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        m.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.email);
        List<DomainGuildInfo> list = this.guildInfos;
        parcel.writeInt(list.size());
        Iterator<DomainGuildInfo> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(parcel, 0);
        }
    }
}
