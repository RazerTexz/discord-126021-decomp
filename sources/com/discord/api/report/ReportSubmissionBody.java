package com.discord.api.report;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12116o;
import p507d0.p580t.C12136h0;
import p507d0.p580t.C12149o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: InAppReportsMenu.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ReportSubmissionBody {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
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

    /* JADX INFO: compiled from: InAppReportsMenu.kt */
    public static final class Companion {
        public Companion() {
        }

        /* JADX INFO: renamed from: a */
        public final Pair<List<Integer>, Map<String, List<String>>> m8190a(List<NodeResult> results) {
            Pair pairM10073to;
            C12238m.checkNotNullParameter(results, "results");
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = results.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ReportNodeChild destination = ((NodeResult) it.next()).getDestination();
                Integer numValueOf = destination != null ? Integer.valueOf(destination.getRef()) : null;
                if (numValueOf != null) {
                    arrayList.add(numValueOf);
                }
            }
            ArrayList arrayList2 = new ArrayList();
            Iterator<T> it2 = results.iterator();
            while (it2.hasNext()) {
                NodeElementResult elementResult = ((NodeResult) it2.next()).getElementResult();
                if (elementResult != null) {
                    String key = elementResult.getKey();
                    List<ReportNodeElementData> listM8166a = elementResult.m8166a();
                    ArrayList arrayList3 = new ArrayList(C12149o.collectionSizeOrDefault(listM8166a, 10));
                    Iterator<T> it3 = listM8166a.iterator();
                    while (it3.hasNext()) {
                        arrayList3.add(((ReportNodeElementData) it3.next()).getElementKey());
                    }
                    pairM10073to = C12116o.m10073to(key, arrayList3);
                } else {
                    pairM10073to = null;
                }
                if (pairM10073to != null) {
                    arrayList2.add(pairM10073to);
                }
            }
            return C12116o.m10073to(arrayList, C12136h0.toMap(arrayList2));
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    public ReportSubmissionBody(long j, Long l, Long l2, Long l3, Long l4, Long l5, String str, String str2, String str3, String str4, List list, Map map, int i) {
        Long l6 = (i & 2) != 0 ? null : l;
        Long l7 = (i & 4) != 0 ? null : l2;
        Long l8 = (i & 8) != 0 ? null : l3;
        Long l9 = (i & 16) != 0 ? null : l4;
        Long l10 = (i & 32) == 0 ? l5 : null;
        C12238m.checkNotNullParameter(str, "language");
        C12238m.checkNotNullParameter(str2, "variant");
        C12238m.checkNotNullParameter(str3, ModelAuditLogEntry.CHANGE_KEY_NAME);
        C12238m.checkNotNullParameter(str4, "version");
        C12238m.checkNotNullParameter(list, "breadcrumbs");
        C12238m.checkNotNullParameter(map, "elements");
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
        return this.id == reportSubmissionBody.id && C12238m.areEqual(this.messageId, reportSubmissionBody.messageId) && C12238m.areEqual(this.channelId, reportSubmissionBody.channelId) && C12238m.areEqual(this.guildId, reportSubmissionBody.guildId) && C12238m.areEqual(this.hubId, reportSubmissionBody.hubId) && C12238m.areEqual(this.guildScheduledEventId, reportSubmissionBody.guildScheduledEventId) && C12238m.areEqual(this.language, reportSubmissionBody.language) && C12238m.areEqual(this.variant, reportSubmissionBody.variant) && C12238m.areEqual(this.name, reportSubmissionBody.name) && C12238m.areEqual(this.version, reportSubmissionBody.version) && C12238m.areEqual(this.breadcrumbs, reportSubmissionBody.breadcrumbs) && C12238m.areEqual(this.elements, reportSubmissionBody.elements);
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
        StringBuilder sbM833U = C1643a.m833U("ReportSubmissionBody(id=");
        sbM833U.append(this.id);
        sbM833U.append(", messageId=");
        sbM833U.append(this.messageId);
        sbM833U.append(", channelId=");
        sbM833U.append(this.channelId);
        sbM833U.append(", guildId=");
        sbM833U.append(this.guildId);
        sbM833U.append(", hubId=");
        sbM833U.append(this.hubId);
        sbM833U.append(", guildScheduledEventId=");
        sbM833U.append(this.guildScheduledEventId);
        sbM833U.append(", language=");
        sbM833U.append(this.language);
        sbM833U.append(", variant=");
        sbM833U.append(this.variant);
        sbM833U.append(", name=");
        sbM833U.append(this.name);
        sbM833U.append(", version=");
        sbM833U.append(this.version);
        sbM833U.append(", breadcrumbs=");
        sbM833U.append(this.breadcrumbs);
        sbM833U.append(", elements=");
        return C1643a.m825M(sbM833U, this.elements, ")");
    }
}
