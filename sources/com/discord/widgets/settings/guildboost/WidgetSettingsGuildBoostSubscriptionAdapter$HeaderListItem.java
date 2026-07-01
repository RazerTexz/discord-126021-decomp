package com.discord.widgets.settings.guildboost;

import android.view.View;
import android.widget.TextView;
import com.discord.R$layout;
import com.discord.databinding.ViewSettingsBoostedHeaderListitemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import d0.z.d.m;
import java.util.Objects;

/* JADX INFO: compiled from: WidgetSettingsGuildBoostSubscriptionAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsGuildBoostSubscriptionAdapter$HeaderListItem extends MGRecyclerViewHolder<WidgetSettingsGuildBoostSubscriptionAdapter, WidgetSettingsGuildBoostSubscriptionAdapter$Item> {
    private final ViewSettingsBoostedHeaderListitemBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsGuildBoostSubscriptionAdapter$HeaderListItem(WidgetSettingsGuildBoostSubscriptionAdapter widgetSettingsGuildBoostSubscriptionAdapter) {
        super(R$layout.view_settings_boosted_header_listitem, widgetSettingsGuildBoostSubscriptionAdapter);
        m.checkNotNullParameter(widgetSettingsGuildBoostSubscriptionAdapter, "adapter");
        View view = this.itemView;
        Objects.requireNonNull(view, "rootView");
        TextView textView = (TextView) view;
        ViewSettingsBoostedHeaderListitemBinding viewSettingsBoostedHeaderListitemBinding = new ViewSettingsBoostedHeaderListitemBinding(textView, textView);
        m.checkNotNullExpressionValue(viewSettingsBoostedHeaderListitemBinding, "ViewSettingsBoostedHeade…temBinding.bind(itemView)");
        this.binding = viewSettingsBoostedHeaderListitemBinding;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, WidgetSettingsGuildBoostSubscriptionAdapter$Item widgetSettingsGuildBoostSubscriptionAdapter$Item) throws Exception {
        onConfigure2(i, widgetSettingsGuildBoostSubscriptionAdapter$Item);
    }

    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, WidgetSettingsGuildBoostSubscriptionAdapter$Item data) throws Exception {
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        if (!(data instanceof WidgetSettingsGuildBoostSubscriptionAdapter$Item$HeaderItem)) {
            throw new Exception("Incorrect List Item Type or null data");
        }
        TextView textView = this.binding.f2214b;
        m.checkNotNullExpressionValue(textView, "binding.boostedHeader");
        View view = this.itemView;
        m.checkNotNullExpressionValue(view, "itemView");
        textView.setText(view.getContext().getString(((WidgetSettingsGuildBoostSubscriptionAdapter$Item$HeaderItem) data).getHeaderStringId()));
    }
}
