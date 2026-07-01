package com.discord.widgets.channels.memberlist.adapter;

import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import com.discord.databinding.WidgetChannelMembersListItemHeaderBinding;
import d0.z.d.m;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: compiled from: ChannelMembersListViewHolderHeader.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChannelMembersListViewHolderHeader extends RecyclerView$ViewHolder {
    private final WidgetChannelMembersListItemHeaderBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelMembersListViewHolderHeader(WidgetChannelMembersListItemHeaderBinding widgetChannelMembersListItemHeaderBinding) {
        super(widgetChannelMembersListItemHeaderBinding.a);
        m.checkNotNullParameter(widgetChannelMembersListItemHeaderBinding, "binding");
        this.binding = widgetChannelMembersListItemHeaderBinding;
    }

    public final void bind(ChannelMembersListAdapter$Item$Header data) {
        int i;
        m.checkNotNullParameter(data, "data");
        int iOrdinal = data.getHeaderType().ordinal();
        if (iOrdinal == 0) {
            i = 2131895916;
        } else if (iOrdinal == 1) {
            i = 2131895915;
        } else {
            if (iOrdinal != 2) {
                throw new NoWhenBranchMatchedException();
            }
            i = 2131892934;
        }
        TextView textView = this.binding.c;
        m.checkNotNullExpressionValue(textView, "binding.channelMembersListItemHeaderText");
        CharSequence text = textView.getContext().getText(i);
        m.checkNotNullExpressionValue(text, "binding.channelMembersLi….getText(statusTextResId)");
        TextView textView2 = this.binding.c;
        m.checkNotNullExpressionValue(textView2, "binding.channelMembersListItemHeaderText");
        textView2.setText(text + " — " + data.getMemberCount());
    }
}
