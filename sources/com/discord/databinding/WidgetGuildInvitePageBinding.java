package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import com.discord.widgets.guilds.invite.WidgetInviteInfo;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventItemView;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetGuildInvitePageBinding implements ViewBinding {

    @NonNull
    public final ConstraintLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final MaterialButton f2416b;

    @NonNull
    public final GuildScheduledEventItemView c;

    @NonNull
    public final WidgetInviteInfo d;

    public WidgetGuildInvitePageBinding(@NonNull ConstraintLayout constraintLayout, @NonNull LinearLayout linearLayout, @NonNull MaterialButton materialButton, @NonNull GuildScheduledEventItemView guildScheduledEventItemView, @NonNull WidgetInviteInfo widgetInviteInfo, @NonNull NestedScrollView nestedScrollView, @NonNull AppBarLayout appBarLayout) {
        this.a = constraintLayout;
        this.f2416b = materialButton;
        this.c = guildScheduledEventItemView;
        this.d = widgetInviteInfo;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
