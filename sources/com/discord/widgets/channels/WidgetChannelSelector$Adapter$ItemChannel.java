package com.discord.widgets.channels;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import b.a.k.b;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.databinding.WidgetChannelSelectorItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import d0.z.d.m;
import java.util.Objects;

/* JADX INFO: compiled from: WidgetChannelSelector.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelSelector$Adapter$ItemChannel extends MGRecyclerViewHolder<WidgetChannelSelector$Adapter, WidgetChannelSelector$Model$Item> {
    private final WidgetChannelSelectorItemBinding binding;
    private final int noChannelStringId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelSelector$Adapter$ItemChannel(@LayoutRes int i, WidgetChannelSelector$Adapter widgetChannelSelector$Adapter, int i2) {
        super(i, widgetChannelSelector$Adapter);
        m.checkNotNullParameter(widgetChannelSelector$Adapter, "adapter");
        this.noChannelStringId = i2;
        View view = this.itemView;
        Objects.requireNonNull(view, "rootView");
        TextView textView = (TextView) view;
        WidgetChannelSelectorItemBinding widgetChannelSelectorItemBinding = new WidgetChannelSelectorItemBinding(textView, textView);
        m.checkNotNullExpressionValue(widgetChannelSelectorItemBinding, "WidgetChannelSelectorItemBinding.bind(itemView)");
        this.binding = widgetChannelSelectorItemBinding;
    }

    public static final /* synthetic */ WidgetChannelSelector$Adapter access$getAdapter$p(WidgetChannelSelector$Adapter$ItemChannel widgetChannelSelector$Adapter$ItemChannel) {
        return (WidgetChannelSelector$Adapter) widgetChannelSelector$Adapter$ItemChannel.adapter;
    }

    public final int getNoChannelStringId() {
        return this.noChannelStringId;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, WidgetChannelSelector$Model$Item widgetChannelSelector$Model$Item) {
        onConfigure2(i, widgetChannelSelector$Model$Item);
    }

    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, WidgetChannelSelector$Model$Item data) {
        CharSequence charSequenceJ;
        int i;
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        this.binding.a.setOnClickListener(new WidgetChannelSelector$Adapter$ItemChannel$onConfigure$1(this, data));
        TextView textView = this.binding.f2268b;
        m.checkNotNullExpressionValue(textView, "binding.itemName");
        Channel channel = data.getChannel();
        if (channel != null) {
            charSequenceJ = ChannelUtils.c(channel);
        } else {
            TextView textView2 = this.binding.f2268b;
            m.checkNotNullExpressionValue(textView2, "binding.itemName");
            charSequenceJ = b.j(textView2, this.noChannelStringId, new Object[0], null, 4);
        }
        textView.setText(charSequenceJ);
        View view = this.itemView;
        m.checkNotNullExpressionValue(view, "itemView");
        Channel channel2 = data.getChannel();
        Integer numValueOf = channel2 != null ? Integer.valueOf(channel2.getType()) : null;
        if (numValueOf != null && numValueOf.intValue() == 2) {
            i = 2130969567;
        } else if (numValueOf != null && numValueOf.intValue() == 13) {
            i = 2130969477;
        } else {
            i = (numValueOf != null && numValueOf.intValue() == 0) ? 2130969478 : 0;
        }
        int themedDrawableRes$default = DrawableCompat.getThemedDrawableRes$default(view, i, 0, 2, (Object) null);
        TextView textView3 = this.binding.f2268b;
        m.checkNotNullExpressionValue(textView3, "binding.itemName");
        DrawableCompat.setCompoundDrawablesCompat$default(textView3, themedDrawableRes$default, 0, 0, 0, 14, (Object) null);
    }
}
