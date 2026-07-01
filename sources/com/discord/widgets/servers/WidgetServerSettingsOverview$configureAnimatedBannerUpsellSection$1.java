package com.discord.widgets.servers;

import android.view.View;
import android.view.View$OnClickListener;
import b.d.b.a.a;
import com.discord.models.guild.Guild;
import com.discord.widgets.servers.guildboost.WidgetGuildBoost;

/* JADX INFO: compiled from: WidgetServerSettingsOverview.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsOverview$configureAnimatedBannerUpsellSection$1 implements View$OnClickListener {
    public final /* synthetic */ Guild $guild;

    public WidgetServerSettingsOverview$configureAnimatedBannerUpsellSection$1(Guild guild) {
        this.$guild = guild;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetGuildBoost.Companion.create(a.x(view, "it", "it.context"), this.$guild.getId());
    }
}
