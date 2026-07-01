package com.discord.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.discord.R$id;
import com.discord.R$layout;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetChannelMembersListItemPlaceholderHeaderBinding implements ViewBinding {

    @NonNull
    public final FrameLayout a;

    public WidgetChannelMembersListItemPlaceholderHeaderBinding(@NonNull FrameLayout frameLayout, @NonNull View view) {
        this.a = frameLayout;
    }

    @NonNull
    public static WidgetChannelMembersListItemPlaceholderHeaderBinding a(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z2) {
        View viewInflate = layoutInflater.inflate(R$layout.widget_channel_members_list_item_placeholder_header, viewGroup, false);
        if (z2) {
            viewGroup.addView(viewInflate);
        }
        View viewFindViewById = viewInflate.findViewById(R$id.channel_members_list_item_header_placeholder);
        if (viewFindViewById != null) {
            return new WidgetChannelMembersListItemPlaceholderHeaderBinding((FrameLayout) viewInflate, viewFindViewById);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(R$id.channel_members_list_item_header_placeholder)));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
