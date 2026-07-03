package com.discord.widgets.hubs;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.app.NotificationCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetHubDomains.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class HubDomainArgs implements Parcelable {
    public static final Parcelable.Creator<HubDomainArgs> CREATOR = new Creator();
    private final String email;
    private final List<DomainGuildInfo> guildInfos;

    public static class Creator implements Parcelable.Creator<HubDomainArgs> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final HubDomainArgs createFromParcel(Parcel parcel) {
            C12238m.checkNotNullParameter(parcel, "in");
            String string = parcel.readString();
            int i = parcel.readInt();
            ArrayList arrayList = new ArrayList(i);
            while (i != 0) {
                arrayList.add(DomainGuildInfo.CREATOR.createFromParcel(parcel));
                i--;
            }
            return new HubDomainArgs(string, arrayList);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final HubDomainArgs[] newArray(int i) {
            return new HubDomainArgs[i];
        }
    }

    public HubDomainArgs(String str, List<DomainGuildInfo> list) {
        C12238m.checkNotNullParameter(str, NotificationCompat.CATEGORY_EMAIL);
        C12238m.checkNotNullParameter(list, "guildInfos");
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
        C12238m.checkNotNullParameter(email, NotificationCompat.CATEGORY_EMAIL);
        C12238m.checkNotNullParameter(guildInfos, "guildInfos");
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
        return C12238m.areEqual(this.email, hubDomainArgs.email) && C12238m.areEqual(this.guildInfos, hubDomainArgs.guildInfos);
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
        StringBuilder sbM833U = C1643a.m833U("HubDomainArgs(email=");
        sbM833U.append(this.email);
        sbM833U.append(", guildInfos=");
        return C1643a.m824L(sbM833U, this.guildInfos, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        C12238m.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.email);
        List<DomainGuildInfo> list = this.guildInfos;
        parcel.writeInt(list.size());
        Iterator<DomainGuildInfo> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(parcel, 0);
        }
    }
}
