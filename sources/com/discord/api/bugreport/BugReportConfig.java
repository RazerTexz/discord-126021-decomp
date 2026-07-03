package com.discord.api.bugreport;

import java.util.List;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: BugReportConfig.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class BugReportConfig {
    private final List<Feature> features;

    /* JADX INFO: renamed from: a */
    public final List<Feature> m7625a() {
        return this.features;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof BugReportConfig) && C12238m.areEqual(this.features, ((BugReportConfig) other).features);
        }
        return true;
    }

    public int hashCode() {
        List<Feature> list = this.features;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }

    public String toString() {
        return C1643a.m824L(C1643a.m833U("BugReportConfig(features="), this.features, ")");
    }
}
