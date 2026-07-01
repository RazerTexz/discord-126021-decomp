package com.discord.widgets.settings.guildboost;

import android.content.Context;
import android.text.format.DateFormat;
import android.view.ContextThemeWrapper;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.TextView;
import b.a.k.b;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.R$menu;
import com.discord.databinding.ViewSettingsBoostedBoostListitemBinding;
import com.discord.models.domain.ModelAppliedGuildBoost;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelGuildBoostSlot;
import com.discord.utilities.SnowflakeUtils;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.time.TimeUtils;
import com.discord.utilities.view.extensions.ViewExtensions;
import d0.g0.t;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetSettingsGuildBoostSubscriptionAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsGuildBoostSubscriptionAdapter$GuildBoostListItem extends MGRecyclerViewHolder<WidgetSettingsGuildBoostSubscriptionAdapter, WidgetSettingsGuildBoostSubscriptionAdapter$Item> {
    private final ViewSettingsBoostedBoostListitemBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsGuildBoostSubscriptionAdapter$GuildBoostListItem(WidgetSettingsGuildBoostSubscriptionAdapter widgetSettingsGuildBoostSubscriptionAdapter) {
        super(R$layout.view_settings_boosted_boost_listitem, widgetSettingsGuildBoostSubscriptionAdapter);
        m.checkNotNullParameter(widgetSettingsGuildBoostSubscriptionAdapter, "adapter");
        View view = this.itemView;
        int i = R$id.boosted_boost_action;
        TextView textView = (TextView) view.findViewById(R$id.boosted_boost_action);
        if (textView != null) {
            i = R$id.boosted_boost_cancelled;
            ImageView imageView = (ImageView) view.findViewById(R$id.boosted_boost_cancelled);
            if (imageView != null) {
                i = R$id.boosted_boost_cooldown;
                TextView textView2 = (TextView) view.findViewById(R$id.boosted_boost_cooldown);
                if (textView2 != null) {
                    i = R$id.boosted_boost_date;
                    TextView textView3 = (TextView) view.findViewById(R$id.boosted_boost_date);
                    if (textView3 != null) {
                        ViewSettingsBoostedBoostListitemBinding viewSettingsBoostedBoostListitemBinding = new ViewSettingsBoostedBoostListitemBinding((RelativeLayout) view, textView, imageView, textView2, textView3);
                        m.checkNotNullExpressionValue(viewSettingsBoostedBoostListitemBinding, "ViewSettingsBoostedBoost…temBinding.bind(itemView)");
                        this.binding = viewSettingsBoostedBoostListitemBinding;
                        return;
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static final /* synthetic */ WidgetSettingsGuildBoostSubscriptionAdapter access$getAdapter$p(WidgetSettingsGuildBoostSubscriptionAdapter$GuildBoostListItem widgetSettingsGuildBoostSubscriptionAdapter$GuildBoostListItem) {
        return (WidgetSettingsGuildBoostSubscriptionAdapter) widgetSettingsGuildBoostSubscriptionAdapter$GuildBoostListItem.adapter;
    }

    public static final /* synthetic */ void access$showGuildBoostPopup(WidgetSettingsGuildBoostSubscriptionAdapter$GuildBoostListItem widgetSettingsGuildBoostSubscriptionAdapter$GuildBoostListItem, View view, boolean z2, boolean z3, boolean z4, WidgetSettingsGuildBoostSubscriptionAdapter$Item$GuildBoostItem widgetSettingsGuildBoostSubscriptionAdapter$Item$GuildBoostItem) {
        widgetSettingsGuildBoostSubscriptionAdapter$GuildBoostListItem.showGuildBoostPopup(view, z2, z3, z4, widgetSettingsGuildBoostSubscriptionAdapter$Item$GuildBoostItem);
    }

    private final void showGuildBoostPopup(View sourceView, boolean hasCooldown, boolean canBeCancelled, boolean canBeUncancelled, WidgetSettingsGuildBoostSubscriptionAdapter$Item$GuildBoostItem data) {
        PopupMenu popupMenu = new PopupMenu(new ContextThemeWrapper(sourceView.getContext(), 2131951663), sourceView);
        popupMenu.getMenuInflater().inflate(R$menu.menu_settings_premium_guild_sub, popupMenu.getMenu());
        MenuItem menuItemFindItem = popupMenu.getMenu().findItem(R$id.menu_settings_premium_guild_sub_transfer);
        MenuItem menuItemFindItem2 = popupMenu.getMenu().findItem(R$id.menu_settings_premium_guild_sub_cancel);
        MenuItem menuItemFindItem3 = popupMenu.getMenu().findItem(R$id.menu_settings_premium_guild_sub_uncancel);
        boolean canceled = data.getBoostSlot().getCanceled();
        m.checkNotNullExpressionValue(menuItemFindItem, "transfer");
        menuItemFindItem.setVisible(!hasCooldown);
        m.checkNotNullExpressionValue(menuItemFindItem2, "cancel");
        menuItemFindItem2.setVisible(!canceled && canBeCancelled);
        m.checkNotNullExpressionValue(menuItemFindItem3, "uncancel");
        menuItemFindItem3.setVisible(canceled && canBeUncancelled);
        menuItemFindItem.setOnMenuItemClickListener(new WidgetSettingsGuildBoostSubscriptionAdapter$GuildBoostListItem$showGuildBoostPopup$1(this, data));
        menuItemFindItem2.setOnMenuItemClickListener(new WidgetSettingsGuildBoostSubscriptionAdapter$GuildBoostListItem$showGuildBoostPopup$2(this, data));
        menuItemFindItem3.setOnMenuItemClickListener(new WidgetSettingsGuildBoostSubscriptionAdapter$GuildBoostListItem$showGuildBoostPopup$3(this, data));
        popupMenu.show();
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, WidgetSettingsGuildBoostSubscriptionAdapter$Item widgetSettingsGuildBoostSubscriptionAdapter$Item) throws Exception {
        onConfigure2(i, widgetSettingsGuildBoostSubscriptionAdapter$Item);
    }

    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, WidgetSettingsGuildBoostSubscriptionAdapter$Item data) throws Exception {
        CharSequence string;
        int i;
        char c;
        String strReplace$default;
        String str;
        CharSequence charSequenceH;
        int themedDrawableRes$default;
        String boostEndsAt;
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        if (!(data instanceof WidgetSettingsGuildBoostSubscriptionAdapter$Item$GuildBoostItem)) {
            throw new Exception("Incorrect List Item Type or null data");
        }
        View view = this.itemView;
        m.checkNotNullExpressionValue(view, "itemView");
        Context context = view.getContext();
        long jCurrentTimeMillis = ClockFactory.get().currentTimeMillis();
        WidgetSettingsGuildBoostSubscriptionAdapter$Item$GuildBoostItem widgetSettingsGuildBoostSubscriptionAdapter$Item$GuildBoostItem = (WidgetSettingsGuildBoostSubscriptionAdapter$Item$GuildBoostItem) data;
        ModelGuildBoostSlot boostSlot = widgetSettingsGuildBoostSubscriptionAdapter$Item$GuildBoostItem.getBoostSlot();
        ModelAppliedGuildBoost premiumGuildSubscription = boostSlot.getPremiumGuildSubscription();
        boolean z2 = (premiumGuildSubscription != null ? Long.valueOf(premiumGuildSubscription.getGuildId()) : null) != null;
        boolean z3 = boostSlot.getCooldownExpiresAtTimestamp() > jCurrentTimeMillis;
        ModelAppliedGuildBoost premiumGuildSubscription2 = boostSlot.getPremiumGuildSubscription();
        Long lValueOf = premiumGuildSubscription2 != null ? Long.valueOf((premiumGuildSubscription2.getId() >>> 22) + SnowflakeUtils.DISCORD_EPOCH) : null;
        boolean canceled = boostSlot.getCanceled();
        ImageView imageView = this.binding.c;
        m.checkNotNullExpressionValue(imageView, "binding.boostedBoostCancelled");
        imageView.setVisibility(canceled ? 0 : 8);
        TextView textView = this.binding.e;
        m.checkNotNullExpressionValue(textView, "binding.boostedBoostDate");
        if (lValueOf == null || (string = DateFormat.format("MMMM dd, yyy", lValueOf.longValue())) == null) {
            string = context.getString(2131894158);
        }
        textView.setText(string);
        if (!canceled || (boostEndsAt = widgetSettingsGuildBoostSubscriptionAdapter$Item$GuildBoostItem.getBoostEndsAt()) == null) {
            i = 0;
            c = 1;
            strReplace$default = null;
        } else {
            m.checkNotNullExpressionValue(context, "context");
            i = 0;
            c = 1;
            strReplace$default = t.replace$default(b.h(context, 2131894140, new Object[]{TimeUtils.renderUtcDate$default(TimeUtils.INSTANCE, boostEndsAt, context, (String) null, (java.text.DateFormat) null, 0, 28, (Object) null)}, null, 4).toString(), "*", "", false, 4, (Object) null);
        }
        if (z3) {
            long jMax = Math.max(boostSlot.getCooldownExpiresAtTimestamp() - jCurrentTimeMillis, 0L);
            long j = jMax / 86400000;
            long j2 = jMax - (86400000 * j);
            long j3 = j2 / 3600000;
            str = "context";
            m.checkNotNullExpressionValue(context, str);
            Object[] objArr = new Object[3];
            objArr[i] = String.valueOf(j);
            objArr[c] = String.valueOf(j3);
            objArr[2] = String.valueOf((j2 - (3600000 * j3)) / 60000);
            charSequenceH = b.h(context, 2131894003, objArr, null, 4);
        } else {
            str = r10;
            charSequenceH = null;
        }
        if (strReplace$default == null && charSequenceH == null) {
            TextView textView2 = this.binding.d;
            m.checkNotNullExpressionValue(textView2, "binding.boostedBoostCooldown");
            textView2.setVisibility(8);
        } else if (strReplace$default != null && charSequenceH != null) {
            TextView textView3 = this.binding.d;
            m.checkNotNullExpressionValue(textView3, "binding.boostedBoostCooldown");
            ViewExtensions.setTextAndVisibilityBy(textView3, charSequenceH + " - " + strReplace$default);
        } else if (strReplace$default != null && charSequenceH == null) {
            TextView textView4 = this.binding.d;
            m.checkNotNullExpressionValue(textView4, "binding.boostedBoostCooldown");
            ViewExtensions.setTextAndVisibilityBy(textView4, strReplace$default);
        } else if (strReplace$default == null && charSequenceH != null) {
            TextView textView5 = this.binding.d;
            m.checkNotNullExpressionValue(textView5, "binding.boostedBoostCooldown");
            ViewExtensions.setTextAndVisibilityBy(textView5, charSequenceH);
        }
        TextView textView6 = this.binding.f2212b;
        m.checkNotNullExpressionValue(textView6, "binding.boostedBoostAction");
        textView6.setText((z2 || z3) ? "" : context.getString(2131894145));
        if (!z3 || (!canceled && WidgetSettingsGuildBoostSubscriptionAdapter.access$getCanCancelBoosts$p((WidgetSettingsGuildBoostSubscriptionAdapter) this.adapter)) || (canceled && WidgetSettingsGuildBoostSubscriptionAdapter.access$getCanUncancelBoosts$p((WidgetSettingsGuildBoostSubscriptionAdapter) this.adapter))) {
            m.checkNotNullExpressionValue(context, str);
            themedDrawableRes$default = DrawableCompat.getThemedDrawableRes$default(context, 2130969525, i, 2, (Object) null);
        } else {
            themedDrawableRes$default = 0;
        }
        this.binding.f2212b.setCompoundDrawablesWithIntrinsicBounds(i, i, themedDrawableRes$default, i);
        this.binding.f2212b.setOnClickListener(new WidgetSettingsGuildBoostSubscriptionAdapter$GuildBoostListItem$onConfigure$2(this, z2, z3, data, boostSlot));
    }
}
