package com.discord.widgets.guilds.invite;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View$OnClickListener;
import androidx.activity.result.ActivityResultLauncher;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetGuildInviteShareSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildInviteShareSheet$configureNormalUI$$inlined$with$lambda$3 implements View$OnClickListener {
    public final /* synthetic */ GuildInvite $invite;
    public final /* synthetic */ String $searchQuery$inlined;
    public final /* synthetic */ GuildInviteShareSheetViewModel$ViewState $viewState$inlined;
    public final /* synthetic */ WidgetGuildInviteShareSheet this$0;

    public WidgetGuildInviteShareSheet$configureNormalUI$$inlined$with$lambda$3(GuildInvite guildInvite, WidgetGuildInviteShareSheet widgetGuildInviteShareSheet, String str, GuildInviteShareSheetViewModel$ViewState guildInviteShareSheetViewModel$ViewState) {
        this.$invite = guildInvite;
        this.this$0 = widgetGuildInviteShareSheet;
        this.$searchQuery$inlined = str;
        this.$viewState$inlined = guildInviteShareSheetViewModel$ViewState;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetGuildInviteSettings$Companion widgetGuildInviteSettings$Companion = WidgetGuildInviteSettings.Companion;
        Context contextRequireContext = this.this$0.requireContext();
        m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        ActivityResultLauncher<Intent> activityResultLauncherAccess$getGuildInviteSettingsLauncher$p = WidgetGuildInviteShareSheet.access$getGuildInviteSettingsLauncher$p(this.this$0);
        GuildInvite guildInvite = this.$invite;
        widgetGuildInviteSettings$Companion.launch(contextRequireContext, activityResultLauncherAccess$getGuildInviteSettingsLauncher$p, guildInvite != null ? guildInvite.getChannelId() : null, WidgetGuildInviteShareSheet.access$getViewModel$p(this.this$0).getGuildId(), "Instant Invite Action Sheet");
    }
}
