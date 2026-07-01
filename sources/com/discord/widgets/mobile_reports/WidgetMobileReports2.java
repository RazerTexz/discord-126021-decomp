package com.discord.widgets.mobile_reports;

import a0.a.a.b;
import android.os.Parcel;
import android.os.Parcelable;
import b.d.b.a.outline;
import com.discord.api.report.ReportType;
import d0.z.d.Intrinsics3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: com.discord.widgets.mobile_reports.MobileReportArgs, reason: use source file name */
/* JADX INFO: compiled from: WidgetMobileReports.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class WidgetMobileReports2 implements Parcelable {
    private final long channelId;
    private final ReportType reportType;

    /* JADX INFO: renamed from: com.discord.widgets.mobile_reports.MobileReportArgs$DirectoryServer */
    /* JADX INFO: compiled from: WidgetMobileReports.kt */
    public static final /* data */ class DirectoryServer extends WidgetMobileReports2 {
        public static final Parcelable.Creator<DirectoryServer> CREATOR = new Creator();
        private final long channelId;
        private final long guildId;
        private final long hubId;

        /* JADX INFO: renamed from: com.discord.widgets.mobile_reports.MobileReportArgs$DirectoryServer$Creator */
        public static class Creator implements Parcelable.Creator<DirectoryServer> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final DirectoryServer createFromParcel(Parcel parcel) {
                Intrinsics3.checkNotNullParameter(parcel, "in");
                return new DirectoryServer(parcel.readLong(), parcel.readLong(), parcel.readLong());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final DirectoryServer[] newArray(int i) {
                return new DirectoryServer[i];
            }
        }

        public DirectoryServer(long j, long j2, long j3) {
            super(ReportType.DirectoryServer, j3, null);
            this.guildId = j;
            this.hubId = j2;
            this.channelId = j3;
        }

        public static /* synthetic */ DirectoryServer copy$default(DirectoryServer directoryServer, long j, long j2, long j3, int i, Object obj) {
            if ((i & 1) != 0) {
                j = directoryServer.guildId;
            }
            long j4 = j;
            if ((i & 2) != 0) {
                j2 = directoryServer.hubId;
            }
            long j5 = j2;
            if ((i & 4) != 0) {
                j3 = directoryServer.getChannelId();
            }
            return directoryServer.copy(j4, j5, j3);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getGuildId() {
            return this.guildId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final long getHubId() {
            return this.hubId;
        }

        public final long component3() {
            return getChannelId();
        }

        public final DirectoryServer copy(long guildId, long hubId, long channelId) {
            return new DirectoryServer(guildId, hubId, channelId);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DirectoryServer)) {
                return false;
            }
            DirectoryServer directoryServer = (DirectoryServer) other;
            return this.guildId == directoryServer.guildId && this.hubId == directoryServer.hubId && getChannelId() == directoryServer.getChannelId();
        }

        @Override // com.discord.widgets.mobile_reports.WidgetMobileReports2
        public long getChannelId() {
            return this.channelId;
        }

        public final long getGuildId() {
            return this.guildId;
        }

        public final long getHubId() {
            return this.hubId;
        }

        public int hashCode() {
            return b.a(getChannelId()) + ((b.a(this.hubId) + (b.a(this.guildId) * 31)) * 31);
        }

        public String toString() {
            StringBuilder sbU = outline.U("DirectoryServer(guildId=");
            sbU.append(this.guildId);
            sbU.append(", hubId=");
            sbU.append(this.hubId);
            sbU.append(", channelId=");
            sbU.append(getChannelId());
            sbU.append(")");
            return sbU.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics3.checkNotNullParameter(parcel, "parcel");
            parcel.writeLong(this.guildId);
            parcel.writeLong(this.hubId);
            parcel.writeLong(this.channelId);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.mobile_reports.MobileReportArgs$GuildScheduledEvent */
    /* JADX INFO: compiled from: WidgetMobileReports.kt */
    public static final /* data */ class GuildScheduledEvent extends WidgetMobileReports2 {
        public static final Parcelable.Creator<GuildScheduledEvent> CREATOR = new Creator();
        private final long eventId;
        private final long guildId;

        /* JADX INFO: renamed from: com.discord.widgets.mobile_reports.MobileReportArgs$GuildScheduledEvent$Creator */
        public static class Creator implements Parcelable.Creator<GuildScheduledEvent> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final GuildScheduledEvent createFromParcel(Parcel parcel) {
                Intrinsics3.checkNotNullParameter(parcel, "in");
                return new GuildScheduledEvent(parcel.readLong(), parcel.readLong());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final GuildScheduledEvent[] newArray(int i) {
                return new GuildScheduledEvent[i];
            }
        }

        public GuildScheduledEvent(long j, long j2) {
            super(ReportType.GuildScheduledEvent, -1L, null);
            this.guildId = j;
            this.eventId = j2;
        }

        public static /* synthetic */ GuildScheduledEvent copy$default(GuildScheduledEvent guildScheduledEvent, long j, long j2, int i, Object obj) {
            if ((i & 1) != 0) {
                j = guildScheduledEvent.guildId;
            }
            if ((i & 2) != 0) {
                j2 = guildScheduledEvent.eventId;
            }
            return guildScheduledEvent.copy(j, j2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getGuildId() {
            return this.guildId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final long getEventId() {
            return this.eventId;
        }

        public final GuildScheduledEvent copy(long guildId, long eventId) {
            return new GuildScheduledEvent(guildId, eventId);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GuildScheduledEvent)) {
                return false;
            }
            GuildScheduledEvent guildScheduledEvent = (GuildScheduledEvent) other;
            return this.guildId == guildScheduledEvent.guildId && this.eventId == guildScheduledEvent.eventId;
        }

        public final long getEventId() {
            return this.eventId;
        }

        public final long getGuildId() {
            return this.guildId;
        }

        public int hashCode() {
            return b.a(this.eventId) + (b.a(this.guildId) * 31);
        }

        public String toString() {
            StringBuilder sbU = outline.U("GuildScheduledEvent(guildId=");
            sbU.append(this.guildId);
            sbU.append(", eventId=");
            return outline.C(sbU, this.eventId, ")");
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics3.checkNotNullParameter(parcel, "parcel");
            parcel.writeLong(this.guildId);
            parcel.writeLong(this.eventId);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.mobile_reports.MobileReportArgs$Message */
    /* JADX INFO: compiled from: WidgetMobileReports.kt */
    public static final /* data */ class Message extends WidgetMobileReports2 {
        public static final Parcelable.Creator<Message> CREATOR = new Creator();
        private final long channelId;
        private final long messageId;

        /* JADX INFO: renamed from: com.discord.widgets.mobile_reports.MobileReportArgs$Message$Creator */
        public static class Creator implements Parcelable.Creator<Message> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Message createFromParcel(Parcel parcel) {
                Intrinsics3.checkNotNullParameter(parcel, "in");
                return new Message(parcel.readLong(), parcel.readLong());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Message[] newArray(int i) {
                return new Message[i];
            }
        }

        public Message(long j, long j2) {
            super(ReportType.Message, j2, null);
            this.messageId = j;
            this.channelId = j2;
        }

        public static /* synthetic */ Message copy$default(Message message, long j, long j2, int i, Object obj) {
            if ((i & 1) != 0) {
                j = message.messageId;
            }
            if ((i & 2) != 0) {
                j2 = message.getChannelId();
            }
            return message.copy(j, j2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getMessageId() {
            return this.messageId;
        }

        public final long component2() {
            return getChannelId();
        }

        public final Message copy(long messageId, long channelId) {
            return new Message(messageId, channelId);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Message)) {
                return false;
            }
            Message message = (Message) other;
            return this.messageId == message.messageId && getChannelId() == message.getChannelId();
        }

        @Override // com.discord.widgets.mobile_reports.WidgetMobileReports2
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
            StringBuilder sbU = outline.U("Message(messageId=");
            sbU.append(this.messageId);
            sbU.append(", channelId=");
            sbU.append(getChannelId());
            sbU.append(")");
            return sbU.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics3.checkNotNullParameter(parcel, "parcel");
            parcel.writeLong(this.messageId);
            parcel.writeLong(this.channelId);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.mobile_reports.MobileReportArgs$StageChannel */
    /* JADX INFO: compiled from: WidgetMobileReports.kt */
    public static final /* data */ class StageChannel extends WidgetMobileReports2 {
        public static final Parcelable.Creator<StageChannel> CREATOR = new Creator();
        private final long channelId;

        /* JADX INFO: renamed from: com.discord.widgets.mobile_reports.MobileReportArgs$StageChannel$Creator */
        public static class Creator implements Parcelable.Creator<StageChannel> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final StageChannel createFromParcel(Parcel parcel) {
                Intrinsics3.checkNotNullParameter(parcel, "in");
                return new StageChannel(parcel.readLong());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final StageChannel[] newArray(int i) {
                return new StageChannel[i];
            }
        }

        public StageChannel(long j) {
            super(ReportType.StageChannel, j, null);
            this.channelId = j;
        }

        public static /* synthetic */ StageChannel copy$default(StageChannel stageChannel, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                j = stageChannel.getChannelId();
            }
            return stageChannel.copy(j);
        }

        public final long component1() {
            return getChannelId();
        }

        public final StageChannel copy(long channelId) {
            return new StageChannel(channelId);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof StageChannel) && getChannelId() == ((StageChannel) other).getChannelId();
            }
            return true;
        }

        @Override // com.discord.widgets.mobile_reports.WidgetMobileReports2
        public long getChannelId() {
            return this.channelId;
        }

        public int hashCode() {
            return b.a(getChannelId());
        }

        public String toString() {
            StringBuilder sbU = outline.U("StageChannel(channelId=");
            sbU.append(getChannelId());
            sbU.append(")");
            return sbU.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics3.checkNotNullParameter(parcel, "parcel");
            parcel.writeLong(this.channelId);
        }
    }

    private WidgetMobileReports2(ReportType reportType, long j) {
        this.reportType = reportType;
        this.channelId = j;
    }

    public long getChannelId() {
        return this.channelId;
    }

    public final ReportType getReportType() {
        return this.reportType;
    }

    public /* synthetic */ WidgetMobileReports2(ReportType reportType, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(reportType, j);
    }
}
