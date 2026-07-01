package com.discord.widgets.hubs;

import android.os.Parcel;
import android.os.Parcelable;
import b.d.b.a.outline;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.widgets.hubs.HubWaitlistResult, reason: use source file name */
/* JADX INFO: compiled from: WidgetHubWaitlist.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetHubWaitlist2 implements WidgetHubDomains5 {
    public static final Parcelable.Creator<WidgetHubWaitlist2> CREATOR = new Creator();
    private final String school;

    /* JADX INFO: renamed from: com.discord.widgets.hubs.HubWaitlistResult$Creator */
    public static class Creator implements Parcelable.Creator<WidgetHubWaitlist2> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final WidgetHubWaitlist2 createFromParcel(Parcel parcel) {
            Intrinsics3.checkNotNullParameter(parcel, "in");
            return new WidgetHubWaitlist2(parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final WidgetHubWaitlist2[] newArray(int i) {
            return new WidgetHubWaitlist2[i];
        }
    }

    public WidgetHubWaitlist2(String str) {
        Intrinsics3.checkNotNullParameter(str, "school");
        this.school = str;
    }

    public static /* synthetic */ WidgetHubWaitlist2 copy$default(WidgetHubWaitlist2 widgetHubWaitlist2, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = widgetHubWaitlist2.school;
        }
        return widgetHubWaitlist2.copy(str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getSchool() {
        return this.school;
    }

    public final WidgetHubWaitlist2 copy(String school) {
        Intrinsics3.checkNotNullParameter(school, "school");
        return new WidgetHubWaitlist2(school);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof WidgetHubWaitlist2) && Intrinsics3.areEqual(this.school, ((WidgetHubWaitlist2) other).school);
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
        return outline.J(outline.U("HubWaitlistResult(school="), this.school, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics3.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.school);
    }
}
