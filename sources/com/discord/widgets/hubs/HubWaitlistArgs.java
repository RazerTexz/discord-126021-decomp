package com.discord.widgets.hubs;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable$Creator;
import androidx.core.app.NotificationCompat;
import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetHubWaitlistViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class HubWaitlistArgs implements Parcelable {
    public static final Parcelable$Creator<HubWaitlistArgs> CREATOR = new HubWaitlistArgs$Creator();
    private final String email;

    public HubWaitlistArgs(String str) {
        m.checkNotNullParameter(str, NotificationCompat.CATEGORY_EMAIL);
        this.email = str;
    }

    public static /* synthetic */ HubWaitlistArgs copy$default(HubWaitlistArgs hubWaitlistArgs, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = hubWaitlistArgs.email;
        }
        return hubWaitlistArgs.copy(str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getEmail() {
        return this.email;
    }

    public final HubWaitlistArgs copy(String email) {
        m.checkNotNullParameter(email, NotificationCompat.CATEGORY_EMAIL);
        return new HubWaitlistArgs(email);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof HubWaitlistArgs) && m.areEqual(this.email, ((HubWaitlistArgs) other).email);
        }
        return true;
    }

    public final String getEmail() {
        return this.email;
    }

    public int hashCode() {
        String str = this.email;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return a.J(a.U("HubWaitlistArgs(email="), this.email, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        m.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.email);
    }
}
