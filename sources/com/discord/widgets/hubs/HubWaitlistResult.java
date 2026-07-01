package com.discord.widgets.hubs;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetHubWaitlist.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class HubWaitlistResult implements MultipleDomainResult {
    public static final Parcelable$Creator<HubWaitlistResult> CREATOR = new HubWaitlistResult$Creator();
    private final String school;

    public HubWaitlistResult(String str) {
        m.checkNotNullParameter(str, "school");
        this.school = str;
    }

    public static /* synthetic */ HubWaitlistResult copy$default(HubWaitlistResult hubWaitlistResult, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = hubWaitlistResult.school;
        }
        return hubWaitlistResult.copy(str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getSchool() {
        return this.school;
    }

    public final HubWaitlistResult copy(String school) {
        m.checkNotNullParameter(school, "school");
        return new HubWaitlistResult(school);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof HubWaitlistResult) && m.areEqual(this.school, ((HubWaitlistResult) other).school);
        }
        return true;
    }

    public final String getSchool() {
        return this.school;
    }

    public int hashCode() {
        String str = this.school;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return a.J(a.U("HubWaitlistResult(school="), this.school, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        m.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.school);
    }
}
