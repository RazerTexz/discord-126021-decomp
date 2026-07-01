package com.discord.widgets.servers;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import b.a.k.b;
import com.discord.api.channel.ChannelUtils;
import com.discord.databinding.ViewCategoryOverrideItemBinding;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: NotificationsOverridesAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class NotificationsOverridesAdapter$ViewHolder$CategoryOverridesViewHolder extends NotificationsOverridesAdapter$ViewHolder {
    private final ViewCategoryOverrideItemBinding binding;

    /* JADX WARN: Illegal instructions before constructor call */
    public NotificationsOverridesAdapter$ViewHolder$CategoryOverridesViewHolder(ViewCategoryOverrideItemBinding viewCategoryOverrideItemBinding, Function2<? super View, ? super NotificationsOverridesAdapter$Item, Unit> function2) {
        m.checkNotNullParameter(viewCategoryOverrideItemBinding, "binding");
        m.checkNotNullParameter(function2, "onClick");
        ConstraintLayout constraintLayout = viewCategoryOverrideItemBinding.a;
        m.checkNotNullExpressionValue(constraintLayout, "binding.root");
        super(constraintLayout, function2, null);
        this.binding = viewCategoryOverrideItemBinding;
    }

    @Override // com.discord.widgets.servers.NotificationsOverridesAdapter$ViewHolder
    public void onBind(NotificationsOverridesAdapter$Item data) {
        m.checkNotNullParameter(data, "data");
        super.onBind(data);
        TextView textView = this.binding.f2175b;
        m.checkNotNullExpressionValue(textView, "binding.categoryOverrideName");
        textView.setText(ChannelUtils.c(data.getChannel()));
        int iMessageNotificationToString = data.getOverrideSettings().isMuted() ? 2131889223 : messageNotificationToString(data.getOverrideSettings().getMessageNotifications());
        TextView textView2 = this.binding.c;
        m.checkNotNullExpressionValue(textView2, "binding.categoryOverrideStatus");
        b.n(textView2, iMessageNotificationToString, new Object[0], null, 4);
    }
}
