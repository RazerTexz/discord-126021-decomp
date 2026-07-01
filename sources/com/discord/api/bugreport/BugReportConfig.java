package com.discord.api.bugreport;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import java.util.List;

/* JADX INFO: compiled from: BugReportConfig.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class BugReportConfig {
    private final List<BugReportConfig2> features;

    public final List<BugReportConfig2> a() {
        return this.features;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof BugReportConfig) && Intrinsics3.areEqual(this.features, ((BugReportConfig) other).features);
        }
        return true;
    }

    public int hashCode() {
        List<BugReportConfig2> list = this.features;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }

    public String toString() {
        return outline.L(outline.U("BugReportConfig(features="), this.features, ")");
    }
}
