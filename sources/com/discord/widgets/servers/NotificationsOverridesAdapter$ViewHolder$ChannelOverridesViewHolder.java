package com.discord.widgets.servers;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import b.a.k.b;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.databinding.ViewChannelOverrideItemBinding;
import com.discord.utilities.view.extensions.ViewExtensions;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: NotificationsOverridesAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class NotificationsOverridesAdapter$ViewHolder$ChannelOverridesViewHolder extends NotificationsOverridesAdapter$ViewHolder {
    private final ViewChannelOverrideItemBinding binding;

    /* JADX WARN: Illegal instructions before constructor call */
    public NotificationsOverridesAdapter$ViewHolder$ChannelOverridesViewHolder(ViewChannelOverrideItemBinding viewChannelOverrideItemBinding, Function2<? super View, ? super NotificationsOverridesAdapter$Item, Unit> function2) {
        m.checkNotNullParameter(viewChannelOverrideItemBinding, "binding");
        m.checkNotNullParameter(function2, "onClick");
        ConstraintLayout constraintLayout = viewChannelOverrideItemBinding.a;
        m.checkNotNullExpressionValue(constraintLayout, "binding.root");
        super(constraintLayout, function2, null);
        this.binding = viewChannelOverrideItemBinding;
    }

    @Override // com.discord.widgets.servers.NotificationsOverridesAdapter$ViewHolder
    public void onBind(NotificationsOverridesAdapter$Item data) {
        m.checkNotNullParameter(data, "data");
        super.onBind(data);
        TextView textView = this.binding.c;
        m.checkNotNullExpressionValue(textView, "binding.channelOverrideName");
        textView.setText(ChannelUtils.c(data.getChannel()));
        TextView textView2 = this.binding.f2176b;
        m.checkNotNullExpressionValue(textView2, "binding.channelOverrideCategoryName");
        Channel parent = data.getParent();
        ViewExtensions.setTextAndVisibilityBy(textView2, parent != null ? ChannelUtils.c(parent) : null);
        int iMessageNotificationToString = data.getOverrideSettings().isMuted() ? 2131889223 : messageNotificationToString(data.getOverrideSettings().getMessageNotifications());
        TextView textView3 = this.binding.d;
        m.checkNotNullExpressionValue(textView3, "binding.channelOverrideStatus");
        b.n(textView3, iMessageNotificationToString, new Object[0], null, 4);
    }
}
