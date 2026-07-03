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
import com.discord.C5419R;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetChannelMembersListItemAddOrLeaveBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f15853a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final ImageView f15854b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f15855c;

    public WidgetChannelMembersListItemAddOrLeaveBinding(@NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull TextView textView) {
        this.f15853a = linearLayout;
        this.f15854b = imageView;
        this.f15855c = textView;
    }

    @NonNull
    /* JADX INFO: renamed from: a */
    public static WidgetChannelMembersListItemAddOrLeaveBinding m8403a(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z2) {
        View viewInflate = layoutInflater.inflate(C5419R.layout.widget_channel_members_list_item_add_or_leave, viewGroup, false);
        if (z2) {
            viewGroup.addView(viewInflate);
        }
        int i = C5419R.id.channel_members_list_item_add_or_leave;
        ImageView imageView = (ImageView) viewInflate.findViewById(C5419R.id.channel_members_list_item_add_or_leave);
        if (imageView != null) {
            i = C5419R.id.channel_members_list_item_add_or_leave_title;
            TextView textView = (TextView) viewInflate.findViewById(C5419R.id.channel_members_list_item_add_or_leave_title);
            if (textView != null) {
                return new WidgetChannelMembersListItemAddOrLeaveBinding((LinearLayout) viewInflate, imageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15853a;
    }
}
