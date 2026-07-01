package com.discord.widgets.channels;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import com.discord.databinding.ViewGuildRoleSubscriptionChannelItemBinding;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.color.ColorCompatKt;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetChannelPickerAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"SetTextI18n"})
public final class ChannelPickerViewHolder$CreateChannelViewHolder extends ChannelPickerViewHolder {
    /* JADX WARN: Illegal instructions before constructor call */
    public ChannelPickerViewHolder$CreateChannelViewHolder(ViewGuildRoleSubscriptionChannelItemBinding viewGuildRoleSubscriptionChannelItemBinding, Function0<Unit> function0) {
        m.checkNotNullParameter(viewGuildRoleSubscriptionChannelItemBinding, "binding");
        m.checkNotNullParameter(function0, "onItemClickListener");
        LinearLayout linearLayout = viewGuildRoleSubscriptionChannelItemBinding.a;
        m.checkNotNullExpressionValue(linearLayout, "binding.root");
        Drawable drawable = null;
        super(linearLayout, null);
        viewGuildRoleSubscriptionChannelItemBinding.f2193b.setText(2131890650);
        View view = this.itemView;
        m.checkNotNullExpressionValue(view, "itemView");
        int themedColor = ColorCompat.getThemedColor(view, 2130969054);
        viewGuildRoleSubscriptionChannelItemBinding.f2193b.setTextColor(themedColor);
        View view2 = this.itemView;
        m.checkNotNullExpressionValue(view2, "itemView");
        Drawable drawable2 = ContextCompat.getDrawable(view2.getContext(), 2131231500);
        if (drawable2 != null) {
            m.checkNotNullExpressionValue(drawable2, "drawable");
            ColorCompatKt.setTint(drawable2, themedColor, false);
            drawable = drawable2;
        }
        viewGuildRoleSubscriptionChannelItemBinding.d.setImageDrawable(drawable);
        ImageView imageView = viewGuildRoleSubscriptionChannelItemBinding.c;
        m.checkNotNullExpressionValue(imageView, "binding.channelItemSelected");
        imageView.setVisibility(8);
        this.itemView.setOnClickListener(new ChannelPickerViewHolder$CreateChannelViewHolder$1(function0));
    }
}
