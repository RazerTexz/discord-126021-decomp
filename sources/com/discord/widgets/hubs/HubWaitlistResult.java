package com.discord.widgets.hubs;

import android.os.Parcel;
import android.os.Parcelable;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetHubWaitlist.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class HubWaitlistResult implements MultipleDomainResult {
    public static final Parcelable.Creator<HubWaitlistResult> CREATOR = new Creator();
    private final String school;

    public static class Creator implements Parcelable.Creator<HubWaitlistResult> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final HubWaitlistResult createFromParcel(Parcel parcel) {
            C12238m.checkNotNullParameter(parcel, "in");
            return new HubWaitlistResult(parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final HubWaitlistResult[] newArray(int i) {
            return new HubWaitlistResult[i];
        }
    }

    public HubWaitlistResult(String str) {
        C12238m.checkNotNullParameter(str, "school");
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
        C12238m.checkNotNullParameter(school, "school");
        return new HubWaitlistResult(school);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof HubWaitlistResult) && C12238m.areEqual(this.school, ((HubWaitlistResult) other).school);
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
        return C1643a.m822J(C1643a.m833U("HubWaitlistResult(school="), this.school, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        C12238m.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.school);
    }
}
