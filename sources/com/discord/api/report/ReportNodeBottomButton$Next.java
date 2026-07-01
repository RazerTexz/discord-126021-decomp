package com.discord.api.report;

import b.d.b.a.a;

/* JADX INFO: compiled from: InAppReportsMenu.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ReportNodeBottomButton$Next extends ReportNodeBottomButton {
    private final int target;

    public ReportNodeBottomButton$Next(int i) {
        super("next", null);
        this.target = i;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final int getTarget() {
        return this.target;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof ReportNodeBottomButton$Next) && this.target == ((ReportNodeBottomButton$Next) other).target;
        }
        return true;
    }

    public int hashCode() {
        return this.target;
    }

    public String toString() {
        return a.B(a.U("Next(target="), this.target, ")");
    }
}
