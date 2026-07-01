package com.discord.widgets.tos;

import a0.a.a.b;
import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetTosReportViolation.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class WidgetTosReportViolation$Companion$Arguments {
    private final long channelId;
    private final long messageId;
    private final String target;

    public WidgetTosReportViolation$Companion$Arguments(String str, long j, long j2) {
        m.checkNotNullParameter(str, "target");
        this.target = str;
        this.channelId = j;
        this.messageId = j2;
    }

    public static /* synthetic */ WidgetTosReportViolation$Companion$Arguments copy$default(WidgetTosReportViolation$Companion$Arguments widgetTosReportViolation$Companion$Arguments, String str, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = widgetTosReportViolation$Companion$Arguments.target;
        }
        if ((i & 2) != 0) {
            j = widgetTosReportViolation$Companion$Arguments.channelId;
        }
        long j3 = j;
        if ((i & 4) != 0) {
            j2 = widgetTosReportViolation$Companion$Arguments.messageId;
        }
        return widgetTosReportViolation$Companion$Arguments.copy(str, j3, j2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getTarget() {
        return this.target;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getChannelId() {
        return this.channelId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getMessageId() {
        return this.messageId;
    }

    public final WidgetTosReportViolation$Companion$Arguments copy(String target, long channelId, long messageId) {
        m.checkNotNullParameter(target, "target");
        return new WidgetTosReportViolation$Companion$Arguments(target, channelId, messageId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetTosReportViolation$Companion$Arguments)) {
            return false;
        }
        WidgetTosReportViolation$Companion$Arguments widgetTosReportViolation$Companion$Arguments = (WidgetTosReportViolation$Companion$Arguments) other;
        return m.areEqual(this.target, widgetTosReportViolation$Companion$Arguments.target) && this.channelId == widgetTosReportViolation$Companion$Arguments.channelId && this.messageId == widgetTosReportViolation$Companion$Arguments.messageId;
    }

    public final long getChannelId() {
        return this.channelId;
    }

    public final long getMessageId() {
        return this.messageId;
    }

    public final String getTarget() {
        return this.target;
    }

    public int hashCode() {
        String str = this.target;
        return b.a(this.messageId) + ((b.a(this.channelId) + ((str != null ? str.hashCode() : 0) * 31)) * 31);
    }

    public String toString() {
        StringBuilder sbU = a.U("Arguments(target=");
        sbU.append(this.target);
        sbU.append(", channelId=");
        sbU.append(this.channelId);
        sbU.append(", messageId=");
        return a.C(sbU, this.messageId, ")");
    }
}
