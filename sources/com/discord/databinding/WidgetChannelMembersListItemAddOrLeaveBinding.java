package com.discord.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.discord.R$id;
import com.discord.R$layout;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetChannelMembersListItemAddOrLeaveBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f2258b;

    @NonNull
    public final TextView c;

    public WidgetChannelMembersListItemAddOrLeaveBinding(@NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull TextView textView) {
        this.a = linearLayout;
        this.f2258b = imageView;
        this.c = textView;
    }

    @NonNull
    public static WidgetChannelMembersListItemAddOrLeaveBinding a(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z2) {
        View viewInflate = layoutInflater.inflate(R$layout.widget_channel_members_list_item_add_or_leave, viewGroup, false);
        if (z2) {
            viewGroup.addView(viewInflate);
        }
        int i = R$id.channel_members_list_item_add_or_leave;
        ImageView imageView = (ImageView) viewInflate.findViewById(R$id.channel_members_list_item_add_or_leave);
        if (imageView != null) {
            i = R$id.channel_members_list_item_add_or_leave_title;
            TextView textView = (TextView) viewInflate.findViewById(R$id.channel_members_list_item_add_or_leave_title);
            if (textView != null) {
                return new WidgetChannelMembersListItemAddOrLeaveBinding((LinearLayout) viewInflate, imageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
