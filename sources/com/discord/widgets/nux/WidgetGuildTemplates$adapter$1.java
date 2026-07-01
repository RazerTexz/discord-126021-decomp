package com.discord.widgets.nux;

import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.widgets.guilds.create.StockGuildTemplate;
import com.discord.widgets.guilds.create.WidgetCreationIntent;
import com.discord.widgets.guilds.create.WidgetCreationIntent$Companion;
import com.discord.widgets.guilds.create.WidgetGuildCreate;
import com.discord.widgets.guilds.create.WidgetGuildCreate$Options;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetGuildTemplates.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildTemplates$adapter$1 implements GuildTemplatesAdapter$Callbacks {
    public final /* synthetic */ WidgetGuildTemplates this$0;

    public WidgetGuildTemplates$adapter$1(WidgetGuildTemplates widgetGuildTemplates) {
        this.this$0 = widgetGuildTemplates;
    }

    @Override // com.discord.widgets.nux.GuildTemplatesAdapter$Callbacks
    public void onTemplateClick(GuildTemplate guildTemplate) {
        m.checkNotNullParameter(guildTemplate, "guildTemplate");
        WidgetGuildCreate$Options widgetGuildCreate$Options = new WidgetGuildCreate$Options(WidgetGuildTemplates.access$getArgs$p(this.this$0).getLocation(), guildTemplate.getTemplateType(), guildTemplate.getTemplateType() == StockGuildTemplate.CREATE, this.this$0.getString(2131890000), WidgetGuildTemplates.access$getArgs$p(this.this$0).getCloseWithResult());
        if (WidgetGuildTemplates.access$getArgs$p(this.this$0).getGuildTemplate().getSkipCreationIntent()) {
            AnalyticsTracker.openModal$default("Create Guild Step 2", widgetGuildCreate$Options.getAnalyticsLocation(), null, 4, null);
            WidgetGuildCreate.Companion.showFragment(this.this$0, widgetGuildCreate$Options);
        } else {
            WidgetGuildTemplates.access$trackPostRegistrationTransition(this.this$0, GuildTemplateAnalytics.STEP_GUILD_TEMPLATE, GuildTemplateAnalytics.STEP_CREATION_INTENT);
            WidgetCreationIntent$Companion widgetCreationIntent$Companion = WidgetCreationIntent.Companion;
            WidgetGuildTemplates widgetGuildTemplates = this.this$0;
            widgetCreationIntent$Companion.show(widgetGuildTemplates, WidgetGuildTemplates.access$getArgs$p(widgetGuildTemplates).getTrigger(), widgetGuildCreate$Options);
        }
    }
}
