package com.discord.api.report;

import b.d.b.a.outline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: InAppReportsMenu.kt */
/* JADX INFO: loaded from: classes.dex */
public abstract class ReportNodeBottomButton {
    private final String type;

    /* JADX INFO: compiled from: InAppReportsMenu.kt */
    public static final class Cancel extends ReportNodeBottomButton {
        public static final Cancel INSTANCE = new Cancel();

        public Cancel() {
            super("cancel", null);
        }
    }

    /* JADX INFO: compiled from: InAppReportsMenu.kt */
    public static final class Done extends ReportNodeBottomButton {
        public static final Done INSTANCE = new Done();

        public Done() {
            super("done", null);
        }
    }

    /* JADX INFO: compiled from: InAppReportsMenu.kt */
    public static final /* data */ class Next extends ReportNodeBottomButton {
        private final int target;

        public Next(int i) {
            super("next", null);
            this.target = i;
        }

        /* JADX INFO: renamed from: b, reason: from getter */
        public final int getTarget() {
            return this.target;
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof Next) && this.target == ((Next) other).target;
            }
            return true;
        }

        public int hashCode() {
            return this.target;
        }

        public String toString() {
            return outline.B(outline.U("Next(target="), this.target, ")");
        }
    }

    /* JADX INFO: compiled from: InAppReportsMenu.kt */
    public static final class Submit extends ReportNodeBottomButton {
        public static final Submit INSTANCE = new Submit();

        public Submit() {
            super("submit", null);
        }
    }

    public ReportNodeBottomButton(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this.type = str;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getType() {
        return this.type;
    }
}
