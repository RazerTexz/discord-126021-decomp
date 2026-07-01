package com.discord.widgets.channels.memberlist.adapter;

import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.StringRes;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import com.discord.databinding.WidgetChannelMembersListItemAddOrLeaveBinding;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: ChannelMembersListViewHolderAdd.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChannelMembersListViewHolderAdd extends RecyclerView$ViewHolder {
    private final WidgetChannelMembersListItemAddOrLeaveBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelMembersListViewHolderAdd(WidgetChannelMembersListItemAddOrLeaveBinding widgetChannelMembersListItemAddOrLeaveBinding) {
        super(widgetChannelMembersListItemAddOrLeaveBinding.a);
        m.checkNotNullParameter(widgetChannelMembersListItemAddOrLeaveBinding, "binding");
        this.binding = widgetChannelMembersListItemAddOrLeaveBinding;
    }

    public final void bind(Function0<Unit> onClicked, @StringRes int title) {
        m.checkNotNullParameter(onClicked, "onClicked");
        TextView textView = this.binding.c;
        m.checkNotNullExpressionValue(textView, "binding.channelMembersListItemAddOrLeaveTitle");
        LinearLayout linearLayout = this.binding.a;
        m.checkNotNullExpressionValue(linearLayout, "binding.root");
        textView.setText(linearLayout.getContext().getText(title));
        this.binding.f2258b.setImageResource(2131231508);
        this.binding.a.setOnClickListener(new ChannelMembersListViewHolderAdd$bind$1(onClicked));
    }
}
