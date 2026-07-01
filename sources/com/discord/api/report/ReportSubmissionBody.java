package com.discord.api.report;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.Tuples;
import d0.t.Iterables2;
import d0.t.Maps6;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Tuples2;
import kotlin.jvm.internal.DefaultConstructorMarker;

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

        public final Tuples2<List<Integer>, Map<String, List<String>>> a(List<NodeResult> results) {
            Tuples2 tuples2;
            Intrinsics3.checkNotNullParameter(results, "results");
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
                    List<ReportNodeElementData> listA = elementResult.a();
                    ArrayList arrayList3 = new ArrayList(Iterables2.collectionSizeOrDefault(listA, 10));
                    Iterator<T> it3 = listA.iterator();
                    while (it3.hasNext()) {
                        arrayList3.add(((ReportNodeElementData) it3.next()).getElementKey());
                    }
                    tuples2 = Tuples.to(key, arrayList3);
                } else {
                    tuples2 = null;
                }
                if (tuples2 != null) {
                    arrayList2.add(tuples2);
                }
            }
            return Tuples.to(arrayList, Maps6.toMap(arrayList2));
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
        Intrinsics3.checkNotNullParameter(str, "language");
        Intrinsics3.checkNotNullParameter(str2, "variant");
        Intrinsics3.checkNotNullParameter(str3, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(str4, "version");
        Intrinsics3.checkNotNullParameter(list, "breadcrumbs");
        Intrinsics3.checkNotNullParameter(map, "elements");
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
        return this.id == reportSubmissionBody.id && Intrinsics3.areEqual(this.messageId, reportSubmissionBody.messageId) && Intrinsics3.areEqual(this.channelId, reportSubmissionBody.channelId) && Intrinsics3.areEqual(this.guildId, reportSubmissionBody.guildId) && Intrinsics3.areEqual(this.hubId, reportSubmissionBody.hubId) && Intrinsics3.areEqual(this.guildScheduledEventId, reportSubmissionBody.guildScheduledEventId) && Intrinsics3.areEqual(this.language, reportSubmissionBody.language) && Intrinsics3.areEqual(this.variant, reportSubmissionBody.variant) && Intrinsics3.areEqual(this.name, reportSubmissionBody.name) && Intrinsics3.areEqual(this.version, reportSubmissionBody.version) && Intrinsics3.areEqual(this.breadcrumbs, reportSubmissionBody.breadcrumbs) && Intrinsics3.areEqual(this.elements, reportSubmissionBody.elements);
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
        StringBuilder sbU = outline.U("ReportSubmissionBody(id=");
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
        return outline.M(sbU, this.elements, ")");
    }
}
