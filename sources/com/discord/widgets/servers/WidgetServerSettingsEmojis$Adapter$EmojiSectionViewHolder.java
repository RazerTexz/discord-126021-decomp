package com.discord.widgets.servers;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.R$plurals;
import com.discord.databinding.WidgetServerSettingsEmojisSectionBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.resources.StringResourceUtilsKt;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetServerSettingsEmojis.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsEmojis$Adapter$EmojiSectionViewHolder extends MGRecyclerViewHolder<WidgetServerSettingsEmojis$Adapter, WidgetServerSettingsEmojis$Item> {
    private final WidgetServerSettingsEmojisSectionBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsEmojis$Adapter$EmojiSectionViewHolder(WidgetServerSettingsEmojis$Adapter widgetServerSettingsEmojis$Adapter) {
        super(R$layout.widget_server_settings_emojis_section, widgetServerSettingsEmojis$Adapter);
        m.checkNotNullParameter(widgetServerSettingsEmojis$Adapter, "adapter");
        View view = this.itemView;
        TextView textView = (TextView) view.findViewById(R$id.widget_server_settings_emojis_section);
        if (textView == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R$id.widget_server_settings_emojis_section)));
        }
        WidgetServerSettingsEmojisSectionBinding widgetServerSettingsEmojisSectionBinding = new WidgetServerSettingsEmojisSectionBinding((LinearLayout) view, textView);
        m.checkNotNullExpressionValue(widgetServerSettingsEmojisSectionBinding, "WidgetServerSettingsEmoj…ionBinding.bind(itemView)");
        this.binding = widgetServerSettingsEmojisSectionBinding;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, WidgetServerSettingsEmojis$Item widgetServerSettingsEmojis$Item) {
        onConfigure2(i, widgetServerSettingsEmojis$Item);
    }

    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, WidgetServerSettingsEmojis$Item data) {
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        WidgetServerSettingsEmojis$Item$EmojiSection widgetServerSettingsEmojis$Item$EmojiSection = (WidgetServerSettingsEmojis$Item$EmojiSection) data;
        int emojiMax = widgetServerSettingsEmojis$Item$EmojiSection.getEmojiMax() - widgetServerSettingsEmojis$Item$EmojiSection.getEmojiLength();
        View view = this.itemView;
        m.checkNotNullExpressionValue(view, "itemView");
        Context context = view.getContext();
        m.checkNotNullExpressionValue(context, "itemView.context");
        Resources resources = context.getResources();
        m.checkNotNullExpressionValue(resources, "itemView.context.resources");
        CharSequence charSequenceH = b.h(a.x(this.itemView, "itemView", "itemView.context"), 2131888798, new Object[]{StringResourceUtilsKt.getQuantityString(resources, a.x(this.itemView, "itemView", "itemView.context"), R$plurals.emoji_slots_available_count, emojiMax, Integer.valueOf(emojiMax))}, null, 4);
        TextView textView = this.binding.f2566b;
        m.checkNotNullExpressionValue(textView, "binding.widgetServerSettingsEmojisSection");
        textView.setText(b.h(a.x(this.itemView, "itemView", "itemView.context"), 2131888797, new Object[]{b.h(a.x(this.itemView, "itemView", "itemView.context"), widgetServerSettingsEmojis$Item$EmojiSection.getTitleId(), new Object[0], null, 4), charSequenceH}, null, 4));
    }
}
