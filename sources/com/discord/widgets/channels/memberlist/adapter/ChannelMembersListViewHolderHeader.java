package com.discord.widgets.channels.memberlist.adapter;

import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.databinding.WidgetChannelMembersListItemHeaderBinding;
import com.discord.widgets.channels.memberlist.adapter.ChannelMembersListAdapter;
import d0.z.d.Intrinsics3;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: compiled from: ChannelMembersListViewHolderHeader.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChannelMembersListViewHolderHeader extends RecyclerView.ViewHolder {
    private final WidgetChannelMembersListItemHeaderBinding binding;

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            ChannelMembersListAdapter.Item.Header.Type.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            iArr[ChannelMembersListAdapter.Item.Header.Type.ONLINE.ordinal()] = 1;
            iArr[ChannelMembersListAdapter.Item.Header.Type.OFFLINE.ordinal()] = 2;
            iArr[ChannelMembersListAdapter.Item.Header.Type.GROUP_DM.ordinal()] = 3;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelMembersListViewHolderHeader(WidgetChannelMembersListItemHeaderBinding widgetChannelMembersListItemHeaderBinding) {
        super(widgetChannelMembersListItemHeaderBinding.a);
        Intrinsics3.checkNotNullParameter(widgetChannelMembersListItemHeaderBinding, "binding");
        this.binding = widgetChannelMembersListItemHeaderBinding;
    }

    public final void bind(ChannelMembersListAdapter.Item.Header data) {
        int i;
        Intrinsics3.checkNotNullParameter(data, "data");
        int iOrdinal = data.getHeaderType().ordinal();
        if (iOrdinal == 0) {
            i = R.string.status_online;
        } else if (iOrdinal == 1) {
            i = R.string.status_offline;
        } else {
            if (iOrdinal != 2) {
                throw new NoWhenBranchMatchedException();
            }
            i = R.string.members;
        }
        TextView textView = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.channelMembersListItemHeaderText");
        CharSequence text = textView.getContext().getText(i);
        Intrinsics3.checkNotNullExpressionValue(text, "binding.channelMembersLi….getText(statusTextResId)");
        TextView textView2 = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.channelMembersListItemHeaderText");
        textView2.setText(text + " — " + data.getMemberCount());
    }
}
