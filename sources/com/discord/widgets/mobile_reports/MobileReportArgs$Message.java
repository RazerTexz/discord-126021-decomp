package com.discord.widgets.mobile_reports;

import a0.a.a.b;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import b.d.b.a.a;
import com.discord.api.report.ReportType;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetMobileReports.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class MobileReportArgs$Message extends MobileReportArgs {
    public static final Parcelable$Creator<MobileReportArgs$Message> CREATOR = new MobileReportArgs$Message$Creator();
    private final long channelId;
    private final long messageId;

    public MobileReportArgs$Message(long j, long j2) {
        super(ReportType.Message, j2, null);
        this.messageId = j;
        this.channelId = j2;
    }

    public static /* synthetic */ MobileReportArgs$Message copy$default(MobileReportArgs$Message mobileReportArgs$Message, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = mobileReportArgs$Message.messageId;
        }
        if ((i & 2) != 0) {
            j2 = mobileReportArgs$Message.getChannelId();
        }
        return mobileReportArgs$Message.copy(j, j2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getMessageId() {
        return this.messageId;
    }

    public final long component2() {
        return getChannelId();
    }

    public final MobileReportArgs$Message copy(long messageId, long channelId) {
        return new MobileReportArgs$Message(messageId, channelId);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MobileReportArgs$Message)) {
            return false;
        }
        MobileReportArgs$Message mobileReportArgs$Message = (MobileReportArgs$Message) other;
        return this.messageId == mobileReportArgs$Message.messageId && getChannelId() == mobileReportArgs$Message.getChannelId();
    }

    @Override // com.discord.widgets.mobile_reports.MobileReportArgs
    public long getChannelId() {
        return this.channelId;
    }

    public final long getMessageId() {
        return this.messageId;
    }

    public int hashCode() {
        return b.a(getChannelId()) + (b.a(this.messageId) * 31);
    }

    public String toString() {
        StringBuilder sbU = a.U("Message(messageId=");
        sbU.append(this.messageId);
        sbU.append(", channelId=");
        sbU.append(getChannelId());
        sbU.append(")");
        return sbU.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        m.checkNotNullParameter(parcel, "parcel");
        parcel.writeLong(this.messageId);
        parcel.writeLong(this.channelId);
    }
}
