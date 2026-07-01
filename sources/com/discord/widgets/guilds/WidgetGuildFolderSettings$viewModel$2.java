package com.discord.widgets.guilds;

import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetGuildFolderSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildFolderSettings$viewModel$2 extends o implements Function0<WidgetGuildFolderSettingsViewModel> {
    public final /* synthetic */ WidgetGuildFolderSettings this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildFolderSettings$viewModel$2(WidgetGuildFolderSettings widgetGuildFolderSettings) {
        super(0);
        this.this$0 = widgetGuildFolderSettings;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ WidgetGuildFolderSettingsViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetGuildFolderSettingsViewModel invoke() {
        return new WidgetGuildFolderSettingsViewModel(this.this$0.getMostRecentIntent().getLongExtra("com.discord.intent.extra.EXTRA_GUILD_FOLDER_ID", -1L), null, null, 6, null);
    }
}
