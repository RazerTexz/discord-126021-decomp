package com.discord.widgets.bugreports;

import b.d.b.a.a;
import com.discord.api.bugreport.Feature;
import d0.t.n;
import d0.z.d.m;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: BugReportViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class BugReportViewModel$ViewState$SelectFeature extends BugReportViewModel$ViewState {
    private final List<Feature> features;
    private final boolean loadingFeatures;
    private final String query;

    public BugReportViewModel$ViewState$SelectFeature() {
        this(null, false, null, 7, null);
    }

    public /* synthetic */ BugReportViewModel$ViewState$SelectFeature(String str, boolean z2, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? true : z2, (i & 4) != 0 ? n.emptyList() : list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BugReportViewModel$ViewState$SelectFeature copy$default(BugReportViewModel$ViewState$SelectFeature bugReportViewModel$ViewState$SelectFeature, String str, boolean z2, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = bugReportViewModel$ViewState$SelectFeature.query;
        }
        if ((i & 2) != 0) {
            z2 = bugReportViewModel$ViewState$SelectFeature.loadingFeatures;
        }
        if ((i & 4) != 0) {
            list = bugReportViewModel$ViewState$SelectFeature.features;
        }
        return bugReportViewModel$ViewState$SelectFeature.copy(str, z2, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getQuery() {
        return this.query;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getLoadingFeatures() {
        return this.loadingFeatures;
    }

    public final List<Feature> component3() {
        return this.features;
    }

    public final BugReportViewModel$ViewState$SelectFeature copy(String query, boolean loadingFeatures, List<Feature> features) {
        m.checkNotNullParameter(features, "features");
        return new BugReportViewModel$ViewState$SelectFeature(query, loadingFeatures, features);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BugReportViewModel$ViewState$SelectFeature)) {
            return false;
        }
        BugReportViewModel$ViewState$SelectFeature bugReportViewModel$ViewState$SelectFeature = (BugReportViewModel$ViewState$SelectFeature) other;
        return m.areEqual(this.query, bugReportViewModel$ViewState$SelectFeature.query) && this.loadingFeatures == bugReportViewModel$ViewState$SelectFeature.loadingFeatures && m.areEqual(this.features, bugReportViewModel$ViewState$SelectFeature.features);
    }

    public final List<Feature> getFeatures() {
        return this.features;
    }

    public final boolean getLoadingFeatures() {
        return this.loadingFeatures;
    }

    public final String getQuery() {
        return this.query;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    public int hashCode() {
        String str = this.query;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        boolean z2 = this.loadingFeatures;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i = (iHashCode + r2) * 31;
        List<Feature> list = this.features;
        return i + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("SelectFeature(query=");
        sbU.append(this.query);
        sbU.append(", loadingFeatures=");
        sbU.append(this.loadingFeatures);
        sbU.append(", features=");
        return a.L(sbU, this.features, ")");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BugReportViewModel$ViewState$SelectFeature(String str, boolean z2, List<Feature> list) {
        super(null);
        m.checkNotNullParameter(list, "features");
        this.query = str;
        this.loadingFeatures = z2;
        this.features = list;
    }
}
