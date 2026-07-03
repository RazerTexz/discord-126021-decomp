package com.discord.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.discord.C5419R;
import com.discord.widgets.roles.RoleIconView;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetChannelMembersListItemHeaderBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f15856a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final RoleIconView f15857b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f15858c;

    public WidgetChannelMembersListItemHeaderBinding(@NonNull LinearLayout linearLayout, @NonNull RoleIconView roleIconView, @NonNull TextView textView) {
        this.f15856a = linearLayout;
        this.f15857b = roleIconView;
        this.f15858c = textView;
    }

    @NonNull
    /* JADX INFO: renamed from: a */
    public static WidgetChannelMembersListItemHeaderBinding m8404a(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z2) {
        View viewInflate = layoutInflater.inflate(C5419R.layout.widget_channel_members_list_item_header, viewGroup, false);
        if (z2) {
            viewGroup.addView(viewInflate);
        }
        int i = C5419R.id.channel_members_list_item_header_role_icon;
        RoleIconView roleIconView = (RoleIconView) viewInflate.findViewById(C5419R.id.channel_members_list_item_header_role_icon);
        if (roleIconView != null) {
            i = C5419R.id.channel_members_list_item_header_text;
            TextView textView = (TextView) viewInflate.findViewById(C5419R.id.channel_members_list_item_header_text);
            if (textView != null) {
                return new WidgetChannelMembersListItemHeaderBinding((LinearLayout) viewInflate, roleIconView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15856a;
    }
}
