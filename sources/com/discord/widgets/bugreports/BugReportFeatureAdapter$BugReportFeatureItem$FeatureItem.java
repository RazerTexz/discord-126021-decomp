package com.discord.widgets.bugreports;

import com.discord.api.bugreport.Feature;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetBugReport.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class BugReportFeatureAdapter$BugReportFeatureItem$FeatureItem extends BugReportFeatureAdapter$BugReportFeatureItem {
    private final Feature feature;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BugReportFeatureAdapter$BugReportFeatureItem$FeatureItem(Feature feature) {
        super(null);
        m.checkNotNullParameter(feature, "feature");
        this.feature = feature;
    }

    public final Feature getFeature() {
        return this.feature;
    }
}
