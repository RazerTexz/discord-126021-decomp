package com.discord.widgets.bugreports;

import com.discord.api.bugreport.Feature;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetBugReport.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class BugReportFeatureAdapter$BugReportFeatureItem$HeaderItem extends BugReportFeatureAdapter$BugReportFeatureItem {
    private final Feature header;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BugReportFeatureAdapter$BugReportFeatureItem$HeaderItem(Feature feature) {
        super(null);
        m.checkNotNullParameter(feature, "header");
        this.header = feature;
    }

    public final Feature getHeader() {
        return this.header;
    }
}
