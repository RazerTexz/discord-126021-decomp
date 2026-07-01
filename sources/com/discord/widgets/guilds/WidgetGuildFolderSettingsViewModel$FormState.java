package com.discord.widgets.guilds;

import b.d.b.a.a;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetGuildFolderSettingsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetGuildFolderSettingsViewModel$FormState {
    private final Integer color;
    private final String name;

    public WidgetGuildFolderSettingsViewModel$FormState(String str, Integer num) {
        this.name = str;
        this.color = num;
    }

    public static /* synthetic */ WidgetGuildFolderSettingsViewModel$FormState copy$default(WidgetGuildFolderSettingsViewModel$FormState widgetGuildFolderSettingsViewModel$FormState, String str, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            str = widgetGuildFolderSettingsViewModel$FormState.name;
        }
        if ((i & 2) != 0) {
            num = widgetGuildFolderSettingsViewModel$FormState.color;
        }
        return widgetGuildFolderSettingsViewModel$FormState.copy(str, num);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Integer getColor() {
        return this.color;
    }

    public final WidgetGuildFolderSettingsViewModel$FormState copy(String name, Integer color) {
        return new WidgetGuildFolderSettingsViewModel$FormState(name, color);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetGuildFolderSettingsViewModel$FormState)) {
            return false;
        }
        WidgetGuildFolderSettingsViewModel$FormState widgetGuildFolderSettingsViewModel$FormState = (WidgetGuildFolderSettingsViewModel$FormState) other;
        return m.areEqual(this.name, widgetGuildFolderSettingsViewModel$FormState.name) && m.areEqual(this.color, widgetGuildFolderSettingsViewModel$FormState.color);
    }

    public final Integer getColor() {
        return this.color;
    }

    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        String str = this.name;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        Integer num = this.color;
        return iHashCode + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("FormState(name=");
        sbU.append(this.name);
        sbU.append(", color=");
        return a.F(sbU, this.color, ")");
    }
}
