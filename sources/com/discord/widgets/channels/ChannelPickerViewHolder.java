package com.discord.widgets.channels;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.api.channel.ChannelUtils;
import com.discord.databinding.ViewGuildRoleSubscriptionChannelItemBinding;
import com.discord.utilities.channel.GuildChannelIconUtilsKt;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.color.ColorCompatKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetChannelPickerAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class ChannelPickerViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: compiled from: WidgetChannelPickerAdapter.kt */
    public static final class ChannelItemViewHolder extends ChannelPickerViewHolder {
        private final ViewGuildRoleSubscriptionChannelItemBinding binding;
        private ChannelPickerAdapterItem.ChannelItem item;

        /* JADX WARN: Illegal instructions before constructor call */
        public ChannelItemViewHolder(ViewGuildRoleSubscriptionChannelItemBinding viewGuildRoleSubscriptionChannelItemBinding, final Function1<? super ChannelPickerAdapterItem.ChannelItem, Unit> function1) {
            C12238m.checkNotNullParameter(viewGuildRoleSubscriptionChannelItemBinding, "binding");
            C12238m.checkNotNullParameter(function1, "onItemClickListener");
            LinearLayout linearLayout = viewGuildRoleSubscriptionChannelItemBinding.f15464a;
            C12238m.checkNotNullExpressionValue(linearLayout, "binding.root");
            super(linearLayout, null);
            this.binding = viewGuildRoleSubscriptionChannelItemBinding;
            this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.channels.ChannelPickerViewHolder.ChannelItemViewHolder.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ChannelPickerAdapterItem.ChannelItem channelItem = ChannelItemViewHolder.this.item;
                    if (channelItem != null) {
                        function1.invoke(channelItem);
                    }
                }
            });
        }

        public final void configure(ChannelPickerAdapterItem adapterItem) {
            C12238m.checkNotNullParameter(adapterItem, "adapterItem");
            ChannelPickerAdapterItem.ChannelItem channelItem = (ChannelPickerAdapterItem.ChannelItem) adapterItem;
            this.item = channelItem;
            if (channelItem != null) {
                TextView textView = this.binding.f15465b;
                C12238m.checkNotNullExpressionValue(textView, "binding.channelItemName");
                textView.setText(ChannelUtils.m7679c(channelItem.getChannel()));
                this.binding.f15467d.setImageResource(GuildChannelIconUtilsKt.guildChannelIcon(channelItem.getChannel()));
                ImageView imageView = this.binding.f15466c;
                C12238m.checkNotNullExpressionValue(imageView, "binding.channelItemSelected");
                imageView.setVisibility(channelItem.isSelected() ? 0 : 8);
            }
        }
    }

    /* JADX INFO: compiled from: WidgetChannelPickerAdapter.kt */
    @SuppressLint({"SetTextI18n"})
    public static final class CreateChannelViewHolder extends ChannelPickerViewHolder {
        /* JADX WARN: Illegal instructions before constructor call */
        /* JADX WARN: Multi-variable type inference failed */
        public CreateChannelViewHolder(ViewGuildRoleSubscriptionChannelItemBinding viewGuildRoleSubscriptionChannelItemBinding, final Function0<Unit> function0) {
            C12238m.checkNotNullParameter(viewGuildRoleSubscriptionChannelItemBinding, "binding");
            C12238m.checkNotNullParameter(function0, "onItemClickListener");
            LinearLayout linearLayout = viewGuildRoleSubscriptionChannelItemBinding.f15464a;
            C12238m.checkNotNullExpressionValue(linearLayout, "binding.root");
            Drawable drawable = null;
            super(linearLayout, 0 == true ? 1 : 0);
            viewGuildRoleSubscriptionChannelItemBinding.f15465b.setText(C5419R.string.guild_role_subscription_tier_benefits_create_a_channel_label);
            View view = this.itemView;
            C12238m.checkNotNullExpressionValue(view, "itemView");
            int themedColor = ColorCompat.getThemedColor(view, C5419R.attr.colorTextLink);
            viewGuildRoleSubscriptionChannelItemBinding.f15465b.setTextColor(themedColor);
            View view2 = this.itemView;
            C12238m.checkNotNullExpressionValue(view2, "itemView");
            Drawable drawable2 = ContextCompat.getDrawable(view2.getContext(), C5419R.drawable.ic_add_24dp);
            if (drawable2 != null) {
                C12238m.checkNotNullExpressionValue(drawable2, "drawable");
                ColorCompatKt.setTint(drawable2, themedColor, false);
                drawable = drawable2;
            }
            viewGuildRoleSubscriptionChannelItemBinding.f15467d.setImageDrawable(drawable);
            ImageView imageView = viewGuildRoleSubscriptionChannelItemBinding.f15466c;
            C12238m.checkNotNullExpressionValue(imageView, "binding.channelItemSelected");
            imageView.setVisibility(8);
            this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.channels.ChannelPickerViewHolder.CreateChannelViewHolder.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    function0.invoke();
                }
            });
        }
    }

    private ChannelPickerViewHolder(View view) {
        super(view);
    }

    public /* synthetic */ ChannelPickerViewHolder(View view, DefaultConstructorMarker defaultConstructorMarker) {
        this(view);
    }
}
