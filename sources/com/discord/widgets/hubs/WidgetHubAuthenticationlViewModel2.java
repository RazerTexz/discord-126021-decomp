package com.discord.widgets.hubs;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: com.discord.widgets.hubs.HubAuthenticationArgs, reason: use source file name */
/* JADX INFO: compiled from: WidgetHubAuthenticationlViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetHubAuthenticationlViewModel2 implements Parcelable {
    public static final Parcelable.Creator<WidgetHubAuthenticationlViewModel2> CREATOR = new Creator();
    private final String email;
    private final Long guildId;

    /* JADX INFO: renamed from: com.discord.widgets.hubs.HubAuthenticationArgs$Creator */
    public static class Creator implements Parcelable.Creator<WidgetHubAuthenticationlViewModel2> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final WidgetHubAuthenticationlViewModel2 createFromParcel(Parcel parcel) {
            Intrinsics3.checkNotNullParameter(parcel, "in");
            return new WidgetHubAuthenticationlViewModel2(parcel.readString(), parcel.readInt() != 0 ? Long.valueOf(parcel.readLong()) : null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final WidgetHubAuthenticationlViewModel2[] newArray(int i) {
            return new WidgetHubAuthenticationlViewModel2[i];
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public WidgetHubAuthenticationlViewModel2() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public WidgetHubAuthenticationlViewModel2(String str, Long l) {
        Intrinsics3.checkNotNullParameter(str, NotificationCompat.CATEGORY_EMAIL);
        this.email = str;
        this.guildId = l;
    }

    public static /* synthetic */ WidgetHubAuthenticationlViewModel2 copy$default(WidgetHubAuthenticationlViewModel2 widgetHubAuthenticationlViewModel2, String str, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            str = widgetHubAuthenticationlViewModel2.email;
        }
        if ((i & 2) != 0) {
            l = widgetHubAuthenticationlViewModel2.guildId;
        }
        return widgetHubAuthenticationlViewModel2.copy(str, l);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getEmail() {
        return this.email;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Long getGuildId() {
        return this.guildId;
    }

    public final WidgetHubAuthenticationlViewModel2 copy(String email, Long guildId) {
        Intrinsics3.checkNotNullParameter(email, NotificationCompat.CATEGORY_EMAIL);
        return new WidgetHubAuthenticationlViewModel2(email, guildId);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetHubAuthenticationlViewModel2)) {
            return false;
        }
        WidgetHubAuthenticationlViewModel2 widgetHubAuthenticationlViewModel2 = (WidgetHubAuthenticationlViewModel2) other;
        return Intrinsics3.areEqual(this.email, widgetHubAuthenticationlViewModel2.email) && Intrinsics3.areEqual(this.guildId, widgetHubAuthenticationlViewModel2.guildId);
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
        StringBuilder sbU = outline.U("HubAuthenticationArgs(email=");
        sbU.append(this.email);
        sbU.append(", guildId=");
        return outline.G(sbU, this.guildId, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics3.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.email);
        Long l = this.guildId;
        if (l == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeLong(l.longValue());
        }
    }

    public /* synthetic */ WidgetHubAuthenticationlViewModel2(String str, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? null : l);
    }
}
