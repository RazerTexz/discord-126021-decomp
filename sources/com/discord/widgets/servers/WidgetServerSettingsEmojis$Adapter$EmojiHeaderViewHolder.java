package com.discord.widgets.servers;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.databinding.WidgetServerSettingsEmojisHeaderBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.google.android.material.button.MaterialButton;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetServerSettingsEmojis.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsEmojis$Adapter$EmojiHeaderViewHolder extends MGRecyclerViewHolder<WidgetServerSettingsEmojis$Adapter, WidgetServerSettingsEmojis$Item> {
    private final WidgetServerSettingsEmojisHeaderBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsEmojis$Adapter$EmojiHeaderViewHolder(WidgetServerSettingsEmojis$Adapter widgetServerSettingsEmojis$Adapter) {
        super(R$layout.widget_server_settings_emojis_header, widgetServerSettingsEmojis$Adapter);
        m.checkNotNullParameter(widgetServerSettingsEmojis$Adapter, "adapter");
        View view = this.itemView;
        int i = R$id.widget_server_settings_emojis_upload;
        MaterialButton materialButton = (MaterialButton) view.findViewById(R$id.widget_server_settings_emojis_upload);
        if (materialButton != null) {
            i = R$id.widget_server_settings_emojis_upload_description;
            TextView textView = (TextView) view.findViewById(R$id.widget_server_settings_emojis_upload_description);
            if (textView != null) {
                WidgetServerSettingsEmojisHeaderBinding widgetServerSettingsEmojisHeaderBinding = new WidgetServerSettingsEmojisHeaderBinding((LinearLayout) view, materialButton, textView);
                m.checkNotNullExpressionValue(widgetServerSettingsEmojisHeaderBinding, "WidgetServerSettingsEmoj…derBinding.bind(itemView)");
                this.binding = widgetServerSettingsEmojisHeaderBinding;
                return;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static final /* synthetic */ WidgetServerSettingsEmojis$Adapter access$getAdapter$p(WidgetServerSettingsEmojis$Adapter$EmojiHeaderViewHolder widgetServerSettingsEmojis$Adapter$EmojiHeaderViewHolder) {
        return (WidgetServerSettingsEmojis$Adapter) widgetServerSettingsEmojis$Adapter$EmojiHeaderViewHolder.adapter;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, WidgetServerSettingsEmojis$Item widgetServerSettingsEmojis$Item) {
        onConfigure2(i, widgetServerSettingsEmojis$Item);
    }

    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, WidgetServerSettingsEmojis$Item data) {
        m.checkNotNullParameter(data, "data");
        TextView textView = this.binding.c;
        m.checkNotNullExpressionValue(textView, "binding.widgetServerSett…gsEmojisUploadDescription");
        textView.setText(b.h(a.x(this.itemView, "itemView", "itemView.context"), 2131891173, new Object[]{String.valueOf(((WidgetServerSettingsEmojis$Item$EmojiHeader) data).getEmojiMax()), String.valueOf(256)}, null, 4));
        this.binding.f2564b.setOnClickListener(new WidgetServerSettingsEmojis$Adapter$EmojiHeaderViewHolder$onConfigure$1(this));
    }
}
