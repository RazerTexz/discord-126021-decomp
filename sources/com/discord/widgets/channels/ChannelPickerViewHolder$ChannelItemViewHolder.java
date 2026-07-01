package com.discord.widgets.channels;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.discord.api.channel.ChannelUtils;
import com.discord.databinding.ViewGuildRoleSubscriptionChannelItemBinding;
import com.discord.utilities.channel.GuildChannelIconUtilsKt;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChannelPickerAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChannelPickerViewHolder$ChannelItemViewHolder extends ChannelPickerViewHolder {
    private final ViewGuildRoleSubscriptionChannelItemBinding binding;
    private ChannelPickerAdapterItem$ChannelItem item;

    /* JADX WARN: Illegal instructions before constructor call */
    public ChannelPickerViewHolder$ChannelItemViewHolder(ViewGuildRoleSubscriptionChannelItemBinding viewGuildRoleSubscriptionChannelItemBinding, Function1<? super ChannelPickerAdapterItem$ChannelItem, Unit> function1) {
        m.checkNotNullParameter(viewGuildRoleSubscriptionChannelItemBinding, "binding");
        m.checkNotNullParameter(function1, "onItemClickListener");
        LinearLayout linearLayout = viewGuildRoleSubscriptionChannelItemBinding.a;
        m.checkNotNullExpressionValue(linearLayout, "binding.root");
        super(linearLayout, null);
        this.binding = viewGuildRoleSubscriptionChannelItemBinding;
        this.itemView.setOnClickListener(new ChannelPickerViewHolder$ChannelItemViewHolder$1(this, function1));
    }

    public static final /* synthetic */ ChannelPickerAdapterItem$ChannelItem access$getItem$p(ChannelPickerViewHolder$ChannelItemViewHolder channelPickerViewHolder$ChannelItemViewHolder) {
        return channelPickerViewHolder$ChannelItemViewHolder.item;
    }

    public static final /* synthetic */ void access$setItem$p(ChannelPickerViewHolder$ChannelItemViewHolder channelPickerViewHolder$ChannelItemViewHolder, ChannelPickerAdapterItem$ChannelItem channelPickerAdapterItem$ChannelItem) {
        channelPickerViewHolder$ChannelItemViewHolder.item = channelPickerAdapterItem$ChannelItem;
    }

    public final void configure(ChannelPickerAdapterItem adapterItem) {
        m.checkNotNullParameter(adapterItem, "adapterItem");
        ChannelPickerAdapterItem$ChannelItem channelPickerAdapterItem$ChannelItem = (ChannelPickerAdapterItem$ChannelItem) adapterItem;
        this.item = channelPickerAdapterItem$ChannelItem;
        if (channelPickerAdapterItem$ChannelItem != null) {
            TextView textView = this.binding.f2193b;
            m.checkNotNullExpressionValue(textView, "binding.channelItemName");
            textView.setText(ChannelUtils.c(channelPickerAdapterItem$ChannelItem.getChannel()));
            this.binding.d.setImageResource(GuildChannelIconUtilsKt.guildChannelIcon(channelPickerAdapterItem$ChannelItem.getChannel()));
            ImageView imageView = this.binding.c;
            m.checkNotNullExpressionValue(imageView, "binding.channelItemSelected");
            imageView.setVisibility(channelPickerAdapterItem$ChannelItem.isSelected() ? 0 : 8);
        }
    }
}
