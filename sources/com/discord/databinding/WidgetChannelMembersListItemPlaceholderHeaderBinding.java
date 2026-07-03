package com.discord.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.discord.C5419R;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetChannelMembersListItemPlaceholderHeaderBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final FrameLayout f15861a;

    public WidgetChannelMembersListItemPlaceholderHeaderBinding(@NonNull FrameLayout frameLayout, @NonNull View view) {
        this.f15861a = frameLayout;
    }

    @NonNull
    /* JADX INFO: renamed from: a */
    public static WidgetChannelMembersListItemPlaceholderHeaderBinding m8405a(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z2) {
        View viewInflate = layoutInflater.inflate(C5419R.layout.widget_channel_members_list_item_placeholder_header, viewGroup, false);
        if (z2) {
            viewGroup.addView(viewInflate);
        }
        View viewFindViewById = viewInflate.findViewById(C5419R.id.channel_members_list_item_header_placeholder);
        if (viewFindViewById != null) {
            return new WidgetChannelMembersListItemPlaceholderHeaderBinding((FrameLayout) viewInflate, viewFindViewById);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(C5419R.id.channel_members_list_item_header_placeholder)));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15861a;
    }
}
