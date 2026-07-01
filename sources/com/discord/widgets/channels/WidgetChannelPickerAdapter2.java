package com.discord.widgets.channels;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.api.channel.ChannelUtils;
import com.discord.databinding.ViewGuildRoleSubscriptionChannelItemBinding;
import com.discord.utilities.channel.GuildChannelIconUtils2;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.color.ColorCompat2;
import com.discord.widgets.channels.WidgetChannelPickerAdapter;
import d0.z.d.Intrinsics3;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: com.discord.widgets.channels.ChannelPickerViewHolder, reason: use source file name */
/* JADX INFO: compiled from: WidgetChannelPickerAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class WidgetChannelPickerAdapter2 extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: com.discord.widgets.channels.ChannelPickerViewHolder$ChannelItemViewHolder */
    /* JADX INFO: compiled from: WidgetChannelPickerAdapter.kt */
    public static final class ChannelItemViewHolder extends WidgetChannelPickerAdapter2 {
        private final ViewGuildRoleSubscriptionChannelItemBinding binding;
        private WidgetChannelPickerAdapter.ChannelItem item;

        /* JADX WARN: Illegal instructions before constructor call */
        public ChannelItemViewHolder(ViewGuildRoleSubscriptionChannelItemBinding viewGuildRoleSubscriptionChannelItemBinding, final Function1<? super WidgetChannelPickerAdapter.ChannelItem, Unit> function1) {
            Intrinsics3.checkNotNullParameter(viewGuildRoleSubscriptionChannelItemBinding, "binding");
            Intrinsics3.checkNotNullParameter(function1, "onItemClickListener");
            LinearLayout linearLayout = viewGuildRoleSubscriptionChannelItemBinding.a;
            Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.root");
            super(linearLayout, null);
            this.binding = viewGuildRoleSubscriptionChannelItemBinding;
            this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.channels.ChannelPickerViewHolder.ChannelItemViewHolder.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WidgetChannelPickerAdapter.ChannelItem channelItem = ChannelItemViewHolder.this.item;
                    if (channelItem != null) {
                        function1.invoke(channelItem);
                    }
                }
            });
        }

        public final void configure(WidgetChannelPickerAdapter adapterItem) {
            Intrinsics3.checkNotNullParameter(adapterItem, "adapterItem");
            WidgetChannelPickerAdapter.ChannelItem channelItem = (WidgetChannelPickerAdapter.ChannelItem) adapterItem;
            this.item = channelItem;
            if (channelItem != null) {
                TextView textView = this.binding.f2193b;
                Intrinsics3.checkNotNullExpressionValue(textView, "binding.channelItemName");
                textView.setText(ChannelUtils.c(channelItem.getChannel()));
                this.binding.d.setImageResource(GuildChannelIconUtils2.guildChannelIcon(channelItem.getChannel()));
                ImageView imageView = this.binding.c;
                Intrinsics3.checkNotNullExpressionValue(imageView, "binding.channelItemSelected");
                imageView.setVisibility(channelItem.isSelected() ? 0 : 8);
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.ChannelPickerViewHolder$CreateChannelViewHolder */
    /* JADX INFO: compiled from: WidgetChannelPickerAdapter.kt */
    @SuppressLint({"SetTextI18n"})
    public static final class CreateChannelViewHolder extends WidgetChannelPickerAdapter2 {
        /* JADX WARN: Illegal instructions before constructor call */
        /* JADX WARN: Multi-variable type inference failed */
        public CreateChannelViewHolder(ViewGuildRoleSubscriptionChannelItemBinding viewGuildRoleSubscriptionChannelItemBinding, final Function0<Unit> function0) {
            Intrinsics3.checkNotNullParameter(viewGuildRoleSubscriptionChannelItemBinding, "binding");
            Intrinsics3.checkNotNullParameter(function0, "onItemClickListener");
            LinearLayout linearLayout = viewGuildRoleSubscriptionChannelItemBinding.a;
            Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.root");
            Drawable drawable = null;
            super(linearLayout, 0 == true ? 1 : 0);
            viewGuildRoleSubscriptionChannelItemBinding.f2193b.setText(R.string.guild_role_subscription_tier_benefits_create_a_channel_label);
            View view = this.itemView;
            Intrinsics3.checkNotNullExpressionValue(view, "itemView");
            int themedColor = ColorCompat.getThemedColor(view, R.attr.colorTextLink);
            viewGuildRoleSubscriptionChannelItemBinding.f2193b.setTextColor(themedColor);
            View view2 = this.itemView;
            Intrinsics3.checkNotNullExpressionValue(view2, "itemView");
            Drawable drawable2 = ContextCompat.getDrawable(view2.getContext(), R.drawable.ic_add_24dp);
            if (drawable2 != null) {
                Intrinsics3.checkNotNullExpressionValue(drawable2, "drawable");
                ColorCompat2.setTint(drawable2, themedColor, false);
                drawable = drawable2;
            }
            viewGuildRoleSubscriptionChannelItemBinding.d.setImageDrawable(drawable);
            ImageView imageView = viewGuildRoleSubscriptionChannelItemBinding.c;
            Intrinsics3.checkNotNullExpressionValue(imageView, "binding.channelItemSelected");
            imageView.setVisibility(8);
            this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.channels.ChannelPickerViewHolder.CreateChannelViewHolder.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    function0.invoke();
                }
            });
        }
    }

    private WidgetChannelPickerAdapter2(View view) {
        super(view);
    }

    public /* synthetic */ WidgetChannelPickerAdapter2(View view, DefaultConstructorMarker defaultConstructorMarker) {
        this(view);
    }
}
