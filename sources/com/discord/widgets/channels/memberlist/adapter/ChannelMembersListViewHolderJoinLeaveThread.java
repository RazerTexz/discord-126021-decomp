package com.discord.widgets.channels.memberlist.adapter;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.databinding.WidgetChannelMembersListItemAddOrLeaveBinding;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.drawable.DrawableCompat;
import d0.z.d.Intrinsics3;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: ChannelMembersListViewHolderJoinLeaveThread.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChannelMembersListViewHolderJoinLeaveThread extends RecyclerView.ViewHolder {
    private final WidgetChannelMembersListItemAddOrLeaveBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelMembersListViewHolderJoinLeaveThread(WidgetChannelMembersListItemAddOrLeaveBinding widgetChannelMembersListItemAddOrLeaveBinding) {
        super(widgetChannelMembersListItemAddOrLeaveBinding.a);
        Intrinsics3.checkNotNullParameter(widgetChannelMembersListItemAddOrLeaveBinding, "binding");
        this.binding = widgetChannelMembersListItemAddOrLeaveBinding;
    }

    public final void bind(final Function0<Unit> onClicked, boolean isThreadJoined) {
        Intrinsics3.checkNotNullParameter(onClicked, "onClicked");
        LinearLayout linearLayout = this.binding.a;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.root");
        Context context = linearLayout.getContext();
        this.binding.a.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.channels.memberlist.adapter.ChannelMembersListViewHolderJoinLeaveThread.bind.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                onClicked.invoke();
            }
        });
        if (isThreadJoined) {
            TextView textView = this.binding.c;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.channelMembersListItemAddOrLeaveTitle");
            textView.setText(context.getString(R.string.leave_thread));
            ImageView imageView = this.binding.f2258b;
            Intrinsics3.checkNotNullExpressionValue(context, "context");
            imageView.setImageResource(DrawableCompat.getThemedDrawableRes$default(context, R.attr.ic_exit_to_app, 0, 2, (Object) null));
            ImageView imageView2 = this.binding.f2258b;
            Intrinsics3.checkNotNullExpressionValue(imageView2, "binding.channelMembersListItemAddOrLeave");
            imageView2.setImageTintList(ColorStateList.valueOf(ColorCompat.getThemedColor(context, R.attr.colorTextDanger)));
            return;
        }
        TextView textView2 = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.channelMembersListItemAddOrLeaveTitle");
        textView2.setText(context.getString(R.string.join_thread));
        ImageView imageView3 = this.binding.f2258b;
        Intrinsics3.checkNotNullExpressionValue(context, "context");
        imageView3.setImageResource(DrawableCompat.getThemedDrawableRes$default(context, R.attr.ic_person_add, 0, 2, (Object) null));
        ImageView imageView4 = this.binding.f2258b;
        Intrinsics3.checkNotNullExpressionValue(imageView4, "binding.channelMembersListItemAddOrLeave");
        imageView4.setImageTintList(ColorStateList.valueOf(ColorCompat.getThemedColor(context, R.attr.colorInteractiveNormal)));
    }
}
