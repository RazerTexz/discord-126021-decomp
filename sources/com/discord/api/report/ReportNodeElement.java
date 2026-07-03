package com.discord.api.report;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: InAppReportsMenu.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ReportNodeElement {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final List<ReportNodeElementData> data;
    private final String name;
    private final boolean should_submit_data;
    private final String type;

    /* JADX INFO: compiled from: InAppReportsMenu.kt */
    public static final class Companion {
        public Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* JADX INFO: renamed from: a */
    public final List<ReportNodeElementData> m8182a() {
        return this.data;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final String getType() {
        return this.type;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ReportNodeElement)) {
            return false;
        }
        ReportNodeElement reportNodeElement = (ReportNodeElement) other;
        return C12238m.areEqual(this.type, reportNodeElement.type) && C12238m.areEqual(this.name, reportNodeElement.name) && C12238m.areEqual(this.data, reportNodeElement.data) && this.should_submit_data == reportNodeElement.should_submit_data;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public int hashCode() {
        String str = this.type;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.name;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        List<ReportNodeElementData> list = this.data;
        int iHashCode3 = (iHashCode2 + (list != null ? list.hashCode() : 0)) * 31;
        boolean z2 = this.should_submit_data;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return iHashCode3 + r1;
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("ReportNodeElement(type=");
        sbM833U.append(this.type);
        sbM833U.append(", name=");
        sbM833U.append(this.name);
        sbM833U.append(", data=");
        sbM833U.append(this.data);
        sbM833U.append(", should_submit_data=");
        return C1643a.m827O(sbM833U, this.should_submit_data, ")");
    }
}
