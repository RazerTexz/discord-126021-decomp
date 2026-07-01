package com.discord.widgets.hubs;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable$Creator;
import androidx.core.app.NotificationCompat;
import b.d.b.a.a;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetHubAuthenticationlViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class HubAuthenticationArgs implements Parcelable {
    public static final Parcelable$Creator<HubAuthenticationArgs> CREATOR = new HubAuthenticationArgs$Creator();
    private final String email;
    private final Long guildId;

    public HubAuthenticationArgs() {
        this(null, null, 3, null);
    }

    public HubAuthenticationArgs(String str, Long l) {
        m.checkNotNullParameter(str, NotificationCompat.CATEGORY_EMAIL);
        this.email = str;
        this.guildId = l;
    }

    public static /* synthetic */ HubAuthenticationArgs copy$default(HubAuthenticationArgs hubAuthenticationArgs, String str, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            str = hubAuthenticationArgs.email;
        }
        if ((i & 2) != 0) {
            l = hubAuthenticationArgs.guildId;
        }
        return hubAuthenticationArgs.copy(str, l);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getEmail() {
        return this.email;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Long getGuildId() {
        return this.guildId;
    }

    public final HubAuthenticationArgs copy(String email, Long guildId) {
        m.checkNotNullParameter(email, NotificationCompat.CATEGORY_EMAIL);
        return new HubAuthenticationArgs(email, guildId);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HubAuthenticationArgs)) {
            return false;
        }
        HubAuthenticationArgs hubAuthenticationArgs = (HubAuthenticationArgs) other;
        return m.areEqual(this.email, hubAuthenticationArgs.email) && m.areEqual(this.guildId, hubAuthenticationArgs.guildId);
    }

    public final String getEmail() {
        return this.email;
    }

    public final Long getGuildId() {
        return this.guildId;
    }

    public int hashCode() {
        String str = this.email;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        Long l = this.guildId;
        return iHashCode + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("HubAuthenticationArgs(email=");
        sbU.append(this.email);
        sbU.append(", guildId=");
        return a.G(sbU, this.guildId, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        m.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.email);
        Long l = this.guildId;
        if (l == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeLong(l.longValue());
        }
    }

    public /* synthetic */ HubAuthenticationArgs(String str, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? null : l);
    }
}
