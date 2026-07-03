package com.discord.widgets.hubs;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.app.NotificationCompat;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetHubWaitlistViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class HubWaitlistArgs implements Parcelable {
    public static final Parcelable.Creator<HubWaitlistArgs> CREATOR = new Creator();
    private final String email;

    public static class Creator implements Parcelable.Creator<HubWaitlistArgs> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final HubWaitlistArgs createFromParcel(Parcel parcel) {
            C12238m.checkNotNullParameter(parcel, "in");
            return new HubWaitlistArgs(parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final HubWaitlistArgs[] newArray(int i) {
            return new HubWaitlistArgs[i];
        }
    }

    public HubWaitlistArgs(String str) {
        C12238m.checkNotNullParameter(str, NotificationCompat.CATEGORY_EMAIL);
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
        C12238m.checkNotNullParameter(email, NotificationCompat.CATEGORY_EMAIL);
        return new HubWaitlistArgs(email);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof HubWaitlistArgs) && C12238m.areEqual(this.email, ((HubWaitlistArgs) other).email);
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
        return C1643a.m822J(C1643a.m833U("HubWaitlistArgs(email="), this.email, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        C12238m.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.email);
    }
}
