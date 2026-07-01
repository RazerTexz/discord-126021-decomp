package com.discord.widgets.guilds.list;

import android.view.View;
import android.widget.FrameLayout;
import com.discord.R$id;
import com.discord.databinding.WidgetGuildsListItemHubVerificationBinding;
import com.discord.tooltips.SparkleView;
import d0.z.d.m;

/* JADX INFO: compiled from: GuildListViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildListViewHolder$DiscordHubViewHolder extends GuildListViewHolder {
    private final WidgetGuildsListItemHubVerificationBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildListViewHolder$DiscordHubViewHolder(View view) {
        super(view, null);
        m.checkNotNullParameter(view, "view");
        SparkleView sparkleView = (SparkleView) view.findViewById(R$id.guild_item_sparkle);
        if (sparkleView == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R$id.guild_item_sparkle)));
        }
        WidgetGuildsListItemHubVerificationBinding widgetGuildsListItemHubVerificationBinding = new WidgetGuildsListItemHubVerificationBinding((FrameLayout) view, sparkleView);
        m.checkNotNullExpressionValue(widgetGuildsListItemHubVerificationBinding, "WidgetGuildsListItemHubV…icationBinding.bind(view)");
        this.binding = widgetGuildsListItemHubVerificationBinding;
    }

    public final void configure(GuildListItem$HubItem item) {
        m.checkNotNullParameter(item, "item");
        SparkleView sparkleView = this.binding.f2463b;
        if (!item.getShowSparkle()) {
            sparkleView.b();
        }
        sparkleView.setVisibility(item.getShowSparkle() ? 0 : 8);
    }

    public final WidgetGuildsListItemHubVerificationBinding getBinding() {
        return this.binding;
    }
}
