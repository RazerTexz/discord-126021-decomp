package com.discord.widgets.hubs;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.app.NotificationCompat;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetHubAuthenticationlViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class HubAuthenticationArgs implements Parcelable {
    public static final Parcelable.Creator<HubAuthenticationArgs> CREATOR = new Creator();
    private final String email;
    private final Long guildId;

    public static class Creator implements Parcelable.Creator<HubAuthenticationArgs> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final HubAuthenticationArgs createFromParcel(Parcel parcel) {
            C12238m.checkNotNullParameter(parcel, "in");
            return new HubAuthenticationArgs(parcel.readString(), parcel.readInt() != 0 ? Long.valueOf(parcel.readLong()) : null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final HubAuthenticationArgs[] newArray(int i) {
            return new HubAuthenticationArgs[i];
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public HubAuthenticationArgs() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public HubAuthenticationArgs(String str, Long l) {
        C12238m.checkNotNullParameter(str, NotificationCompat.CATEGORY_EMAIL);
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
        C12238m.checkNotNullParameter(email, NotificationCompat.CATEGORY_EMAIL);
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
        return C12238m.areEqual(this.email, hubAuthenticationArgs.email) && C12238m.areEqual(this.guildId, hubAuthenticationArgs.guildId);
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
        StringBuilder sbM833U = C1643a.m833U("HubAuthenticationArgs(email=");
        sbM833U.append(this.email);
        sbM833U.append(", guildId=");
        return C1643a.m819G(sbM833U, this.guildId, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        C12238m.checkNotNullParameter(parcel, "parcel");
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
