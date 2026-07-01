package com.discord.widgets.settings.guildboost;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import b.a.k.b;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.R$plurals;
import com.discord.databinding.ViewSettingsBoostedGuildListitemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages$ChangeDetector;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.resources.StringResourceUtilsKt;
import com.discord.views.guildboost.GuildBoostProgressView;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetSettingsGuildBoostSubscriptionAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsGuildBoostSubscriptionAdapter$GuildListItem extends MGRecyclerViewHolder<WidgetSettingsGuildBoostSubscriptionAdapter, WidgetSettingsGuildBoostSubscriptionAdapter$Item> {
    private final ViewSettingsBoostedGuildListitemBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsGuildBoostSubscriptionAdapter$GuildListItem(WidgetSettingsGuildBoostSubscriptionAdapter widgetSettingsGuildBoostSubscriptionAdapter) {
        super(R$layout.view_settings_boosted_guild_listitem, widgetSettingsGuildBoostSubscriptionAdapter);
        m.checkNotNullParameter(widgetSettingsGuildBoostSubscriptionAdapter, "adapter");
        View view = this.itemView;
        int i = R$id.boosted_guild_banner;
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R$id.boosted_guild_banner);
        if (simpleDraweeView != null) {
            i = R$id.boosted_guild_gradient;
            View viewFindViewById = view.findViewById(R$id.boosted_guild_gradient);
            if (viewFindViewById != null) {
                i = R$id.boosted_guild_progress_view;
                GuildBoostProgressView guildBoostProgressView = (GuildBoostProgressView) view.findViewById(R$id.boosted_guild_progress_view);
                if (guildBoostProgressView != null) {
                    i = R$id.boosted_sample_guild_count;
                    TextView textView = (TextView) view.findViewById(R$id.boosted_sample_guild_count);
                    if (textView != null) {
                        i = R$id.boosted_sample_guild_icon;
                        SimpleDraweeView simpleDraweeView2 = (SimpleDraweeView) view.findViewById(R$id.boosted_sample_guild_icon);
                        if (simpleDraweeView2 != null) {
                            i = R$id.boosted_sample_guild_name;
                            TextView textView2 = (TextView) view.findViewById(R$id.boosted_sample_guild_name);
                            if (textView2 != null) {
                                ViewSettingsBoostedGuildListitemBinding viewSettingsBoostedGuildListitemBinding = new ViewSettingsBoostedGuildListitemBinding((LinearLayout) view, simpleDraweeView, viewFindViewById, guildBoostProgressView, textView, simpleDraweeView2, textView2);
                                m.checkNotNullExpressionValue(viewSettingsBoostedGuildListitemBinding, "ViewSettingsBoostedGuild…temBinding.bind(itemView)");
                                this.binding = viewSettingsBoostedGuildListitemBinding;
                                return;
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, WidgetSettingsGuildBoostSubscriptionAdapter$Item widgetSettingsGuildBoostSubscriptionAdapter$Item) throws Exception {
        onConfigure2(i, widgetSettingsGuildBoostSubscriptionAdapter$Item);
    }

    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, WidgetSettingsGuildBoostSubscriptionAdapter$Item data) throws Exception {
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        if (data instanceof WidgetSettingsGuildBoostSubscriptionAdapter$Item$GuildItem) {
            WidgetSettingsGuildBoostSubscriptionAdapter$Item$GuildItem widgetSettingsGuildBoostSubscriptionAdapter$Item$GuildItem = (WidgetSettingsGuildBoostSubscriptionAdapter$Item$GuildItem) data;
            if (widgetSettingsGuildBoostSubscriptionAdapter$Item$GuildItem.getGuild() != null) {
                View view = this.itemView;
                m.checkNotNullExpressionValue(view, "itemView");
                Context context = view.getContext();
                if (widgetSettingsGuildBoostSubscriptionAdapter$Item$GuildItem.getGuild().getBanner() != null) {
                    SimpleDraweeView simpleDraweeView = this.binding.f2213b;
                    IconUtils iconUtils = IconUtils.INSTANCE;
                    Guild guild = widgetSettingsGuildBoostSubscriptionAdapter$Item$GuildItem.getGuild();
                    m.checkNotNullExpressionValue(context, "context");
                    simpleDraweeView.setImageURI(IconUtils.getBannerForGuild$default(iconUtils, guild, Integer.valueOf(context.getResources().getDimensionPixelSize(2131165700)), false, 4, null));
                    View view2 = this.binding.c;
                    m.checkNotNullExpressionValue(view2, "binding.boostedGuildGradient");
                    view2.setVisibility(0);
                } else {
                    SimpleDraweeView simpleDraweeView2 = this.binding.f2213b;
                    m.checkNotNullExpressionValue(context, "context");
                    simpleDraweeView2.setBackgroundResource(DrawableCompat.getThemedDrawableRes$default(context, 2130968721, 0, 2, (Object) null));
                    View view3 = this.binding.c;
                    m.checkNotNullExpressionValue(view3, "binding.boostedGuildGradient");
                    view3.setVisibility(8);
                }
                SimpleDraweeView simpleDraweeView3 = this.binding.f;
                m.checkNotNullExpressionValue(simpleDraweeView3, "binding.boostedSampleGuildIcon");
                IconUtils.setIcon$default(simpleDraweeView3, IconUtils.getForGuild$default(widgetSettingsGuildBoostSubscriptionAdapter$Item$GuildItem.getGuild(), null, false, null, 14, null), 0, (Function1) null, (MGImages$ChangeDetector) null, 28, (Object) null);
                TextView textView = this.binding.g;
                m.checkNotNullExpressionValue(textView, "binding.boostedSampleGuildName");
                textView.setText(widgetSettingsGuildBoostSubscriptionAdapter$Item$GuildItem.getGuild().getName());
                CharSequence i18nPluralString = StringResourceUtilsKt.getI18nPluralString(context, R$plurals.premium_guild_subscription_guild_subsription_subtitle_numSubscriptions, widgetSettingsGuildBoostSubscriptionAdapter$Item$GuildItem.getBoostCount(), Integer.valueOf(widgetSettingsGuildBoostSubscriptionAdapter$Item$GuildItem.getBoostCount()));
                TextView textView2 = this.binding.e;
                m.checkNotNullExpressionValue(textView2, "binding.boostedSampleGuildCount");
                textView2.setText(b.h(context, 2131894110, new Object[]{i18nPluralString}, null, 4));
                this.binding.d.a(widgetSettingsGuildBoostSubscriptionAdapter$Item$GuildItem.getGuild().getId(), widgetSettingsGuildBoostSubscriptionAdapter$Item$GuildItem.getGuild().getPremiumTier(), widgetSettingsGuildBoostSubscriptionAdapter$Item$GuildItem.getGuild().getPremiumSubscriptionCount());
                return;
            }
        }
        throw new Exception("Incorrect List Item Type or null data");
    }
}
