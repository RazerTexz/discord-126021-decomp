package com.discord.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.channelsidebar.GuildChannelSideBarActionsView;
import com.discord.views.channelsidebar.PrivateChannelSideBarActionsView;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetChannelSidebarActionsBinding implements ViewBinding {

    @NonNull
    public final FrameLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final GuildChannelSideBarActionsView f2280b;

    @NonNull
    public final PrivateChannelSideBarActionsView c;

    public WidgetChannelSidebarActionsBinding(@NonNull FrameLayout frameLayout, @NonNull GuildChannelSideBarActionsView guildChannelSideBarActionsView, @NonNull PrivateChannelSideBarActionsView privateChannelSideBarActionsView) {
        this.a = frameLayout;
        this.f2280b = guildChannelSideBarActionsView;
        this.c = privateChannelSideBarActionsView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
