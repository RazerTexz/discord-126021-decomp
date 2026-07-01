package com.discord.api.bugreport;

import b.d.b.a.a;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: BugReportConfig.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class BugReportConfig {
    private final List<Feature> features;

    public final List<Feature> a() {
        return this.features;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof BugReportConfig) && m.areEqual(this.features, ((BugReportConfig) other).features);
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
        return a.L(a.U("BugReportConfig(features="), this.features, ")");
    }
}
