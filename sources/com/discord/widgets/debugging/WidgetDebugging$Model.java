package com.discord.widgets.debugging;

import b.d.b.a.a;
import com.discord.app.AppLog$LoggedItem;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: WidgetDebugging.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetDebugging$Model {
    private final boolean isFiltered;
    private final List<AppLog$LoggedItem> logs;

    public WidgetDebugging$Model(List<AppLog$LoggedItem> list, boolean z2) {
        m.checkNotNullParameter(list, "logs");
        this.logs = list;
        this.isFiltered = z2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetDebugging$Model copy$default(WidgetDebugging$Model widgetDebugging$Model, List list, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = widgetDebugging$Model.logs;
        }
        if ((i & 2) != 0) {
            z2 = widgetDebugging$Model.isFiltered;
        }
        return widgetDebugging$Model.copy(list, z2);
    }

    public final List<AppLog$LoggedItem> component1() {
        return this.logs;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsFiltered() {
        return this.isFiltered;
    }

    public final WidgetDebugging$Model copy(List<AppLog$LoggedItem> logs, boolean isFiltered) {
        m.checkNotNullParameter(logs, "logs");
        return new WidgetDebugging$Model(logs, isFiltered);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetDebugging$Model)) {
            return false;
        }
        WidgetDebugging$Model widgetDebugging$Model = (WidgetDebugging$Model) other;
        return m.areEqual(this.logs, widgetDebugging$Model.logs) && this.isFiltered == widgetDebugging$Model.isFiltered;
    }

    public final List<AppLog$LoggedItem> getLogs() {
        return this.logs;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    public int hashCode() {
        List<AppLog$LoggedItem> list = this.logs;
        int iHashCode = (list != null ? list.hashCode() : 0) * 31;
        boolean z2 = this.isFiltered;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return iHashCode + r1;
    }

    public final boolean isFiltered() {
        return this.isFiltered;
    }

    public String toString() {
        StringBuilder sbU = a.U("Model(logs=");
        sbU.append(this.logs);
        sbU.append(", isFiltered=");
        return a.O(sbU, this.isFiltered, ")");
    }
}
