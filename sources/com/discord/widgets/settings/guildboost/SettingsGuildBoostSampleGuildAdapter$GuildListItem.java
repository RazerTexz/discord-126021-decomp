package com.discord.widgets.settings.guildboost;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import b.d.b.a.a;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.R$plurals;
import com.discord.databinding.ViewSettingsBoostedSampleGuildBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages$ChangeDetector;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.resources.StringResourceUtilsKt;
import com.discord.views.guildboost.GuildBoostProgressView;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.m;

/* JADX INFO: compiled from: SettingsGuildBoostSampleGuildAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SettingsGuildBoostSampleGuildAdapter$GuildListItem extends MGRecyclerViewHolder<SettingsGuildBoostSampleGuildAdapter, SettingsGuildBoostSampleGuildAdapter$Item> {
    private final ViewSettingsBoostedSampleGuildBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsGuildBoostSampleGuildAdapter$GuildListItem(SettingsGuildBoostSampleGuildAdapter settingsGuildBoostSampleGuildAdapter) {
        super(R$layout.view_settings_boosted_sample_guild, settingsGuildBoostSampleGuildAdapter);
        m.checkNotNullParameter(settingsGuildBoostSampleGuildAdapter, "adapter");
        View view = this.itemView;
        int i = R$id.boosted_sample_guild_count;
        TextView textView = (TextView) view.findViewById(R$id.boosted_sample_guild_count);
        if (textView != null) {
            i = R$id.boosted_sample_guild_icon;
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R$id.boosted_sample_guild_icon);
            if (simpleDraweeView != null) {
                i = R$id.boosted_sample_guild_name;
                TextView textView2 = (TextView) view.findViewById(R$id.boosted_sample_guild_name);
                if (textView2 != null) {
                    i = R$id.boosted_sample_guild_progress;
                    GuildBoostProgressView guildBoostProgressView = (GuildBoostProgressView) view.findViewById(R$id.boosted_sample_guild_progress);
                    if (guildBoostProgressView != null) {
                        ViewSettingsBoostedSampleGuildBinding viewSettingsBoostedSampleGuildBinding = new ViewSettingsBoostedSampleGuildBinding((CardView) view, textView, simpleDraweeView, textView2, guildBoostProgressView);
                        m.checkNotNullExpressionValue(viewSettingsBoostedSampleGuildBinding, "ViewSettingsBoostedSampl…ildBinding.bind(itemView)");
                        this.binding = viewSettingsBoostedSampleGuildBinding;
                        return;
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static final /* synthetic */ SettingsGuildBoostSampleGuildAdapter access$getAdapter$p(SettingsGuildBoostSampleGuildAdapter$GuildListItem settingsGuildBoostSampleGuildAdapter$GuildListItem) {
        return (SettingsGuildBoostSampleGuildAdapter) settingsGuildBoostSampleGuildAdapter$GuildListItem.adapter;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, SettingsGuildBoostSampleGuildAdapter$Item settingsGuildBoostSampleGuildAdapter$Item) {
        onConfigure2(i, settingsGuildBoostSampleGuildAdapter$Item);
    }

    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, SettingsGuildBoostSampleGuildAdapter$Item data) {
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        int premiumSubscriptionCount = data.getGuild().getPremiumSubscriptionCount();
        SimpleDraweeView simpleDraweeView = this.binding.c;
        m.checkNotNullExpressionValue(simpleDraweeView, "binding.boostedSampleGuildIcon");
        IconUtils.setIcon$default((ImageView) simpleDraweeView, data.getGuild(), 0, (MGImages$ChangeDetector) null, false, 28, (Object) null);
        TextView textView = this.binding.d;
        m.checkNotNullExpressionValue(textView, "binding.boostedSampleGuildName");
        textView.setText(data.getGuild().getName());
        TextView textView2 = this.binding.f2215b;
        m.checkNotNullExpressionValue(textView2, "binding.boostedSampleGuildCount");
        textView2.setText(StringResourceUtilsKt.getI18nPluralString(a.x(this.itemView, "itemView", "itemView.context"), R$plurals.premium_guild_subscription_available_numSubscriptions, premiumSubscriptionCount, Integer.valueOf(premiumSubscriptionCount)));
        this.binding.e.a(data.getGuild().getId(), data.getGuild().getPremiumTier(), premiumSubscriptionCount);
        this.itemView.setOnClickListener(new SettingsGuildBoostSampleGuildAdapter$GuildListItem$onConfigure$1(this, data));
    }
}
