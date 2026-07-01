package com.discord.widgets.hubs;

import a0.a.a.b;
import android.os.Parcel;
import android.os.Parcelable;
import b.d.b.a.outline;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.widgets.hubs.AuthenticationResult, reason: use source file name */
/* JADX INFO: compiled from: WidgetHubAuthenticationlViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetHubAuthenticationlViewModel implements WidgetHubDomains5 {
    public static final Parcelable.Creator<WidgetHubAuthenticationlViewModel> CREATOR = new Creator();
    private final long guildId;

    /* JADX INFO: renamed from: com.discord.widgets.hubs.AuthenticationResult$Creator */
    public static class Creator implements Parcelable.Creator<WidgetHubAuthenticationlViewModel> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final WidgetHubAuthenticationlViewModel createFromParcel(Parcel parcel) {
            Intrinsics3.checkNotNullParameter(parcel, "in");
            return new WidgetHubAuthenticationlViewModel(parcel.readLong());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final WidgetHubAuthenticationlViewModel[] newArray(int i) {
            return new WidgetHubAuthenticationlViewModel[i];
        }
    }

    public WidgetHubAuthenticationlViewModel(long j) {
        this.guildId = j;
    }

    public static /* synthetic */ WidgetHubAuthenticationlViewModel copy$default(WidgetHubAuthenticationlViewModel widgetHubAuthenticationlViewModel, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = widgetHubAuthenticationlViewModel.guildId;
        }
        return widgetHubAuthenticationlViewModel.copy(j);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    public final WidgetHubAuthenticationlViewModel copy(long guildId) {
        return new WidgetHubAuthenticationlViewModel(guildId);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof WidgetHubAuthenticationlViewModel) && this.guildId == ((WidgetHubAuthenticationlViewModel) other).guildId;
        }
        return true;
    }

    public final long getGuildId() {
        return this.guildId;
    }

    public int hashCode() {
        return b.a(this.guildId);
    }

    public String toString() {
        return outline.C(outline.U("AuthenticationResult(guildId="), this.guildId, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics3.checkNotNullParameter(parcel, "parcel");
        parcel.writeLong(this.guildId);
    }
}
