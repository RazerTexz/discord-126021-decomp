package com.discord.widgets.guilds;

import b.k.a.a.f;
import com.discord.utilities.color.ColorCompat;

/* JADX INFO: compiled from: WidgetGuildFolderSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildFolderSettings$launchColorPicker$1 implements f {
    public final /* synthetic */ WidgetGuildFolderSettings this$0;

    public WidgetGuildFolderSettings$launchColorPicker$1(WidgetGuildFolderSettings widgetGuildFolderSettings) {
        this.this$0 = widgetGuildFolderSettings;
    }

    @Override // b.k.a.a.f
    public void onColorReset(int dialogId) {
        WidgetGuildFolderSettings.access$getViewModel$p(this.this$0).setColor(Integer.valueOf(WidgetGuildFolderSettings.access$argbColorToRGB(this.this$0, ColorCompat.getThemedColor(this.this$0.getContext(), 2130969062))));
    }

    @Override // b.k.a.a.f
    public void onColorSelected(int dialogId, int selectedColor) {
        WidgetGuildFolderSettings.access$getViewModel$p(this.this$0).setColor(Integer.valueOf(WidgetGuildFolderSettings.access$argbColorToRGB(this.this$0, selectedColor)));
    }

    @Override // b.k.a.a.f
    public void onDialogDismissed(int dialogId) {
    }
}
