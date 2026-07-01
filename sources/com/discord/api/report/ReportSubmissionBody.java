package com.discord.api.report;

import b.d.b.a.a;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: InAppReportsMenu.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ReportSubmissionBody {
    public static final ReportSubmissionBody$Companion Companion = new ReportSubmissionBody$Companion(null);
    private final List<Integer> breadcrumbs;
    private final Long channelId;
    private final Map<String, List<String>> elements;
    private final Long guildId;
    private final Long guildScheduledEventId;
    private final Long hubId;
    private final long id;
    private final String language;
    private final Long messageId;
    private final String name;
    private final String variant;
    private final String version;

    public ReportSubmissionBody(long j, Long l, Long l2, Long l3, Long l4, Long l5, String str, String str2, String str3, String str4, List list, Map map, int i) {
        Long l6 = (i & 2) != 0 ? null : l;
        Long l7 = (i & 4) != 0 ? null : l2;
        Long l8 = (i & 8) != 0 ? null : l3;
        Long l9 = (i & 16) != 0 ? null : l4;
        Long l10 = (i & 32) == 0 ? l5 : null;
        m.checkNotNullParameter(str, "language");
        m.checkNotNullParameter(str2, "variant");
        m.checkNotNullParameter(str3, ModelAuditLogEntry.CHANGE_KEY_NAME);
        m.checkNotNullParameter(str4, "version");
        m.checkNotNullParameter(list, "breadcrumbs");
        m.checkNotNullParameter(map, "elements");
        this.id = j;
        this.messageId = l6;
        this.channelId = l7;
        this.guildId = l8;
        this.hubId = l9;
        this.guildScheduledEventId = l10;
        this.language = str;
        this.variant = str2;
        this.name = str3;
        this.version = str4;
        this.breadcrumbs = list;
        this.elements = map;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ReportSubmissionBody)) {
            return false;
        }
        ReportSubmissionBody reportSubmissionBody = (ReportSubmissionBody) other;
        return this.id == reportSubmissionBody.id && m.areEqual(this.messageId, reportSubmissionBody.messageId) && m.areEqual(this.channelId, reportSubmissionBody.channelId) && m.areEqual(this.guildId, reportSubmissionBody.guildId) && m.areEqual(this.hubId, reportSubmissionBody.hubId) && m.areEqual(this.guildScheduledEventId, reportSubmissionBody.guildScheduledEventId) && m.areEqual(this.language, reportSubmissionBody.language) && m.areEqual(this.variant, reportSubmissionBody.variant) && m.areEqual(this.name, reportSubmissionBody.name) && m.areEqual(this.version, reportSubmissionBody.version) && m.areEqual(this.breadcrumbs, reportSubmissionBody.breadcrumbs) && m.areEqual(this.elements, reportSubmissionBody.elements);
    }

    public int hashCode() {
        long j = this.id;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        Long l = this.messageId;
        int iHashCode = (i + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.channelId;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.guildId;
        int iHashCode3 = (iHashCode2 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.hubId;
        int iHashCode4 = (iHashCode3 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.guildScheduledEventId;
        int iHashCode5 = (iHashCode4 + (l5 != null ? l5.hashCode() : 0)) * 31;
        String str = this.language;
        int iHashCode6 = (iHashCode5 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.variant;
        int iHashCode7 = (iHashCode6 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.name;
        int iHashCode8 = (iHashCode7 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.version;
        int iHashCode9 = (iHashCode8 + (str4 != null ? str4.hashCode() : 0)) * 31;
        List<Integer> list = this.breadcrumbs;
        int iHashCode10 = (iHashCode9 + (list != null ? list.hashCode() : 0)) * 31;
        Map<String, List<String>> map = this.elements;
        return iHashCode10 + (map != null ? map.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("ReportSubmissionBody(id=");
        sbU.append(this.id);
        sbU.append(", messageId=");
        sbU.append(this.messageId);
        sbU.append(", channelId=");
        sbU.append(this.channelId);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", hubId=");
        sbU.append(this.hubId);
        sbU.append(", guildScheduledEventId=");
        sbU.append(this.guildScheduledEventId);
        sbU.append(", language=");
        sbU.append(this.language);
        sbU.append(", variant=");
        sbU.append(this.variant);
        sbU.append(", name=");
        sbU.append(this.name);
        sbU.append(", version=");
        sbU.append(this.version);
        sbU.append(", breadcrumbs=");
        sbU.append(this.breadcrumbs);
        sbU.append(", elements=");
        return a.M(sbU, this.elements, ")");
    }
}
