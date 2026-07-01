package com.discord.api.report;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: InAppReportsMenu.kt */
/* JADX INFO: loaded from: classes.dex */
public abstract class ReportNodeBottomButton {
    private final String type;

    public ReportNodeBottomButton(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this.type = str;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getType() {
        return this.type;
    }
}
