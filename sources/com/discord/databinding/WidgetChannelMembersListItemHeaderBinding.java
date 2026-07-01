package com.discord.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.discord.R;
import com.discord.widgets.roles.RoleIconView;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetChannelMembersListItemHeaderBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final RoleIconView f2259b;

    @NonNull
    public final TextView c;

    public WidgetChannelMembersListItemHeaderBinding(@NonNull LinearLayout linearLayout, @NonNull RoleIconView roleIconView, @NonNull TextView textView) {
        this.a = linearLayout;
        this.f2259b = roleIconView;
        this.c = textView;
    }

    @NonNull
    public static WidgetChannelMembersListItemHeaderBinding a(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z2) {
        View viewInflate = layoutInflater.inflate(R.layout.widget_channel_members_list_item_header, viewGroup, false);
        if (z2) {
            viewGroup.addView(viewInflate);
        }
        int i = R.id.channel_members_list_item_header_role_icon;
        RoleIconView roleIconView = (RoleIconView) viewInflate.findViewById(R.id.channel_members_list_item_header_role_icon);
        if (roleIconView != null) {
            i = R.id.channel_members_list_item_header_text;
            TextView textView = (TextView) viewInflate.findViewById(R.id.channel_members_list_item_header_text);
            if (textView != null) {
                return new WidgetChannelMembersListItemHeaderBinding((LinearLayout) viewInflate, roleIconView, textView);
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
