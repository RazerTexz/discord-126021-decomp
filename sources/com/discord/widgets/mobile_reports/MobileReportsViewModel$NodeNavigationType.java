package com.discord.widgets.mobile_reports;

import com.discord.api.report.ReportNode;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: MobileReportsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class MobileReportsViewModel$NodeNavigationType {
    private final ReportNode node;

    private MobileReportsViewModel$NodeNavigationType(ReportNode reportNode) {
        this.node = reportNode;
    }

    public final ReportNode getNode() {
        return this.node;
    }

    public /* synthetic */ MobileReportsViewModel$NodeNavigationType(ReportNode reportNode, DefaultConstructorMarker defaultConstructorMarker) {
        this(reportNode);
    }
}
