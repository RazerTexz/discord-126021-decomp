package com.discord.widgets.guilds;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.guilds.WidgetGuildFolderSettings$viewModel$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetGuildFolderSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildFolderSettings3 extends Lambda implements Function0<WidgetGuildFolderSettingsViewModel> {
    public final /* synthetic */ WidgetGuildFolderSettings this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildFolderSettings3(WidgetGuildFolderSettings widgetGuildFolderSettings) {
        super(0);
        this.this$0 = widgetGuildFolderSettings;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetGuildFolderSettingsViewModel invoke() {
        return new WidgetGuildFolderSettingsViewModel(this.this$0.getMostRecentIntent().getLongExtra("com.discord.intent.extra.EXTRA_GUILD_FOLDER_ID", -1L), null, null, 6, null);
    }
}
