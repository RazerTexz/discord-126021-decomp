package com.discord.widgets.channels.memberlist.adapter;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.StringRes;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.databinding.WidgetChannelMembersListItemAddOrLeaveBinding;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ChannelMembersListViewHolderAdd.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChannelMembersListViewHolderAdd extends RecyclerView.ViewHolder {
    private final WidgetChannelMembersListItemAddOrLeaveBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelMembersListViewHolderAdd(WidgetChannelMembersListItemAddOrLeaveBinding widgetChannelMembersListItemAddOrLeaveBinding) {
        super(widgetChannelMembersListItemAddOrLeaveBinding.f15853a);
        C12238m.checkNotNullParameter(widgetChannelMembersListItemAddOrLeaveBinding, "binding");
        this.binding = widgetChannelMembersListItemAddOrLeaveBinding;
    }

    public final void bind(final Function0<Unit> onClicked, @StringRes int title) {
        C12238m.checkNotNullParameter(onClicked, "onClicked");
        TextView textView = this.binding.f15855c;
        C12238m.checkNotNullExpressionValue(textView, "binding.channelMembersListItemAddOrLeaveTitle");
        LinearLayout linearLayout = this.binding.f15853a;
        C12238m.checkNotNullExpressionValue(linearLayout, "binding.root");
        textView.setText(linearLayout.getContext().getText(title));
        this.binding.f15854b.setImageResource(C5419R.drawable.ic_add_person_16dp);
        this.binding.f15853a.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.channels.memberlist.adapter.ChannelMembersListViewHolderAdd.bind.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                onClicked.invoke();
            }
        });
    }
}
