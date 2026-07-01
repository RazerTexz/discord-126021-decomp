package com.discord.widgets.guilds;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetGuildFolderSettingsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetGuildFolderSettingsViewModel$ViewState$Loaded extends WidgetGuildFolderSettingsViewModel$ViewState {
    private final WidgetGuildFolderSettingsViewModel$FormState formState;
    private final boolean showSave;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildFolderSettingsViewModel$ViewState$Loaded(WidgetGuildFolderSettingsViewModel$FormState widgetGuildFolderSettingsViewModel$FormState, boolean z2) {
        super(null);
        m.checkNotNullParameter(widgetGuildFolderSettingsViewModel$FormState, "formState");
        this.formState = widgetGuildFolderSettingsViewModel$FormState;
        this.showSave = z2;
    }

    public static /* synthetic */ WidgetGuildFolderSettingsViewModel$ViewState$Loaded copy$default(WidgetGuildFolderSettingsViewModel$ViewState$Loaded widgetGuildFolderSettingsViewModel$ViewState$Loaded, WidgetGuildFolderSettingsViewModel$FormState widgetGuildFolderSettingsViewModel$FormState, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            widgetGuildFolderSettingsViewModel$FormState = widgetGuildFolderSettingsViewModel$ViewState$Loaded.formState;
        }
        if ((i & 2) != 0) {
            z2 = widgetGuildFolderSettingsViewModel$ViewState$Loaded.showSave;
        }
        return widgetGuildFolderSettingsViewModel$ViewState$Loaded.copy(widgetGuildFolderSettingsViewModel$FormState, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final WidgetGuildFolderSettingsViewModel$FormState getFormState() {
        return this.formState;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getShowSave() {
        return this.showSave;
    }

    public final WidgetGuildFolderSettingsViewModel$ViewState$Loaded copy(WidgetGuildFolderSettingsViewModel$FormState formState, boolean showSave) {
        m.checkNotNullParameter(formState, "formState");
        return new WidgetGuildFolderSettingsViewModel$ViewState$Loaded(formState, showSave);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetGuildFolderSettingsViewModel$ViewState$Loaded)) {
            return false;
        }
        WidgetGuildFolderSettingsViewModel$ViewState$Loaded widgetGuildFolderSettingsViewModel$ViewState$Loaded = (WidgetGuildFolderSettingsViewModel$ViewState$Loaded) other;
        return m.areEqual(this.formState, widgetGuildFolderSettingsViewModel$ViewState$Loaded.formState) && this.showSave == widgetGuildFolderSettingsViewModel$ViewState$Loaded.showSave;
    }

    public final WidgetGuildFolderSettingsViewModel$FormState getFormState() {
        return this.formState;
    }

    public final boolean getShowSave() {
        return this.showSave;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    public int hashCode() {
        WidgetGuildFolderSettingsViewModel$FormState widgetGuildFolderSettingsViewModel$FormState = this.formState;
        int iHashCode = (widgetGuildFolderSettingsViewModel$FormState != null ? widgetGuildFolderSettingsViewModel$FormState.hashCode() : 0) * 31;
        boolean z2 = this.showSave;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return iHashCode + r1;
    }

    public String toString() {
        StringBuilder sbU = a.U("Loaded(formState=");
        sbU.append(this.formState);
        sbU.append(", showSave=");
        return a.O(sbU, this.showSave, ")");
    }
}
