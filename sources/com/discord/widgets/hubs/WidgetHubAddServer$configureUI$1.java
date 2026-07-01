package com.discord.widgets.hubs;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View$OnClickListener;
import androidx.activity.result.ActivityResultLauncher;
import b.a.d.j;
import b.a.k.b;
import com.discord.widgets.guilds.create.CreateGuildTrigger;
import com.discord.widgets.nux.GuildCreateArgs;
import com.discord.widgets.nux.GuildTemplateAnalytics;
import com.discord.widgets.nux.GuildTemplateArgs;
import com.discord.widgets.nux.GuildTemplateTypes;
import com.discord.widgets.nux.WidgetHubGuildTemplates;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetHubAddServer.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubAddServer$configureUI$1 implements View$OnClickListener {
    public final /* synthetic */ HubAddServerState $state;
    public final /* synthetic */ WidgetHubAddServer this$0;

    public WidgetHubAddServer$configureUI$1(WidgetHubAddServer widgetHubAddServer, HubAddServerState hubAddServerState) {
        this.this$0 = widgetHubAddServer;
        this.$state = hubAddServerState;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        Context context = this.this$0.getContext();
        if (context != null) {
            m.checkNotNullExpressionValue(context, "context ?: return@setOnClickListener");
            j jVar = j.g;
            ActivityResultLauncher<Intent> activityResultLauncherAccess$getLauncher$p = WidgetHubAddServer.access$getLauncher$p(this.this$0);
            CreateGuildTrigger createGuildTrigger = CreateGuildTrigger.DIRECTORY_CHANNEL;
            String string = b.h(context, 2131891755, new Object[]{this.$state.getHubName()}, null, 4).toString();
            String string2 = context.getString(2131891754);
            m.checkNotNullExpressionValue(string2, "context.getString(R.stri…te_or_add_guild_subtitle)");
            jVar.f(context, activityResultLauncherAccess$getLauncher$p, WidgetHubGuildTemplates.class, new GuildCreateArgs(false, GuildTemplateAnalytics.IN_APP_LOCATION_TEMPLATE, createGuildTrigger, new GuildTemplateArgs(string, string2, GuildTemplateTypes.INSTANCE.getHUB(), false, true), true));
        }
    }
}
