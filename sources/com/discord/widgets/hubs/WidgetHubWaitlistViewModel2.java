package com.discord.widgets.hubs;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.widgets.hubs.HubWaitlistArgs, reason: use source file name */
/* JADX INFO: compiled from: WidgetHubWaitlistViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetHubWaitlistViewModel2 implements Parcelable {
    public static final Parcelable.Creator<WidgetHubWaitlistViewModel2> CREATOR = new Creator();
    private final String email;

    /* JADX INFO: renamed from: com.discord.widgets.hubs.HubWaitlistArgs$Creator */
    public static class Creator implements Parcelable.Creator<WidgetHubWaitlistViewModel2> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final WidgetHubWaitlistViewModel2 createFromParcel(Parcel parcel) {
            Intrinsics3.checkNotNullParameter(parcel, "in");
            return new WidgetHubWaitlistViewModel2(parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final WidgetHubWaitlistViewModel2[] newArray(int i) {
            return new WidgetHubWaitlistViewModel2[i];
        }
    }

    public WidgetHubWaitlistViewModel2(String str) {
        Intrinsics3.checkNotNullParameter(str, NotificationCompat.CATEGORY_EMAIL);
        this.email = str;
    }

    public static /* synthetic */ WidgetHubWaitlistViewModel2 copy$default(WidgetHubWaitlistViewModel2 widgetHubWaitlistViewModel2, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = widgetHubWaitlistViewModel2.email;
        }
        return widgetHubWaitlistViewModel2.copy(str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getEmail() {
        return this.email;
    }

    public final WidgetHubWaitlistViewModel2 copy(String email) {
        Intrinsics3.checkNotNullParameter(email, NotificationCompat.CATEGORY_EMAIL);
        return new WidgetHubWaitlistViewModel2(email);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof WidgetHubWaitlistViewModel2) && Intrinsics3.areEqual(this.email, ((WidgetHubWaitlistViewModel2) other).email);
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
        return outline.J(outline.U("HubWaitlistArgs(email="), this.email, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics3.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.email);
    }
}
