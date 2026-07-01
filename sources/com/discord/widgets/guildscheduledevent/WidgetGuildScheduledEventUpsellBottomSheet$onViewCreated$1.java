package com.discord.widgets.guildscheduledevent;

import android.view.View;
import android.view.View$OnClickListener;
import androidx.fragment.app.FragmentManager;
import com.discord.api.guild.GuildFeature;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreStream;
import com.discord.widgets.guilds.profile.WidgetGuildProfileSheet;
import com.discord.widgets.guilds.profile.WidgetGuildProfileSheet$Companion;
import d0.z.d.m;
import java.util.Set;

/* JADX INFO: compiled from: WidgetGuildScheduledEventUpsellBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildScheduledEventUpsellBottomSheet$onViewCreated$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetGuildScheduledEventUpsellBottomSheet this$0;

    public WidgetGuildScheduledEventUpsellBottomSheet$onViewCreated$1(WidgetGuildScheduledEventUpsellBottomSheet widgetGuildScheduledEventUpsellBottomSheet) {
        this.this$0 = widgetGuildScheduledEventUpsellBottomSheet;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        Set<GuildFeature> features;
        Guild guild = StoreStream.Companion.getGuilds().getGuild(WidgetGuildScheduledEventUpsellBottomSheet.access$getGuildId$p(this.this$0));
        if (guild == null || (features = guild.getFeatures()) == null || !features.contains(GuildFeature.COMMUNITY)) {
            WidgetGuildProfileSheet$Companion widgetGuildProfileSheet$Companion = WidgetGuildProfileSheet.Companion;
            FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
            m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            WidgetGuildProfileSheet$Companion.show$default(widgetGuildProfileSheet$Companion, parentFragmentManager, true, WidgetGuildScheduledEventUpsellBottomSheet.access$getGuildId$p(this.this$0), 0L, true, 8, null);
        } else {
            WidgetGuildScheduledEventListBottomSheet$Companion widgetGuildScheduledEventListBottomSheet$Companion = WidgetGuildScheduledEventListBottomSheet.Companion;
            FragmentManager parentFragmentManager2 = this.this$0.getParentFragmentManager();
            m.checkNotNullExpressionValue(parentFragmentManager2, "parentFragmentManager");
            WidgetGuildScheduledEventListBottomSheet$Companion.show$default(widgetGuildScheduledEventListBottomSheet$Companion, parentFragmentManager2, WidgetGuildScheduledEventUpsellBottomSheet.access$getGuildId$p(this.this$0), null, 4, null);
        }
        this.this$0.dismiss();
    }
}
