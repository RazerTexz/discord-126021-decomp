package com.discord.widgets.mobile_reports;

import a0.a.a.b;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import b.d.b.a.a;
import com.discord.api.report.ReportType;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetMobileReports.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class MobileReportArgs$StageChannel extends MobileReportArgs {
    public static final Parcelable$Creator<MobileReportArgs$StageChannel> CREATOR = new MobileReportArgs$StageChannel$Creator();
    private final long channelId;

    public MobileReportArgs$StageChannel(long j) {
        super(ReportType.StageChannel, j, null);
        this.channelId = j;
    }

    public static /* synthetic */ MobileReportArgs$StageChannel copy$default(MobileReportArgs$StageChannel mobileReportArgs$StageChannel, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = mobileReportArgs$StageChannel.getChannelId();
        }
        return mobileReportArgs$StageChannel.copy(j);
    }

    public final long component1() {
        return getChannelId();
    }

    public final MobileReportArgs$StageChannel copy(long channelId) {
        return new MobileReportArgs$StageChannel(channelId);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof MobileReportArgs$StageChannel) && getChannelId() == ((MobileReportArgs$StageChannel) other).getChannelId();
        }
        return true;
    }

    @Override // com.discord.widgets.mobile_reports.MobileReportArgs
    public long getChannelId() {
        return this.channelId;
    }

    public int hashCode() {
        return b.a(getChannelId());
    }

    public String toString() {
        StringBuilder sbU = a.U("StageChannel(channelId=");
        sbU.append(getChannelId());
        sbU.append(")");
        return sbU.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        m.checkNotNullParameter(parcel, "parcel");
        parcel.writeLong(this.channelId);
    }
}
