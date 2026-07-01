package com.discord.widgets.channels.memberlist.adapter;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.StringRes;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.databinding.WidgetChannelMembersListItemAddOrLeaveBinding;
import d0.z.d.Intrinsics3;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: ChannelMembersListViewHolderAdd.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChannelMembersListViewHolderAdd extends RecyclerView.ViewHolder {
    private final WidgetChannelMembersListItemAddOrLeaveBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelMembersListViewHolderAdd(WidgetChannelMembersListItemAddOrLeaveBinding widgetChannelMembersListItemAddOrLeaveBinding) {
        super(widgetChannelMembersListItemAddOrLeaveBinding.a);
        Intrinsics3.checkNotNullParameter(widgetChannelMembersListItemAddOrLeaveBinding, "binding");
        this.binding = widgetChannelMembersListItemAddOrLeaveBinding;
    }

    public final void bind(final Function0<Unit> onClicked, @StringRes int title) {
        Intrinsics3.checkNotNullParameter(onClicked, "onClicked");
        TextView textView = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.channelMembersListItemAddOrLeaveTitle");
        LinearLayout linearLayout = this.binding.a;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.root");
        textView.setText(linearLayout.getContext().getText(title));
        this.binding.f2258b.setImageResource(R.drawable.ic_add_person_16dp);
        this.binding.a.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.channels.memberlist.adapter.ChannelMembersListViewHolderAdd.bind.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                onClicked.invoke();
            }
        });
    }
}
