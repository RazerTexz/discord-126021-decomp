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

    /* JADX INFO: renamed from: a */
    @NonNull
    public final ConstraintLayout f16794a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final MaterialButton f16795b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final GuildScheduledEventItemView f16796c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final WidgetInviteInfo f16797d;

    public WidgetGuildInvitePageBinding(@NonNull ConstraintLayout constraintLayout, @NonNull LinearLayout linearLayout, @NonNull MaterialButton materialButton, @NonNull GuildScheduledEventItemView guildScheduledEventItemView, @NonNull WidgetInviteInfo widgetInviteInfo, @NonNull NestedScrollView nestedScrollView, @NonNull AppBarLayout appBarLayout) {
        this.f16794a = constraintLayout;
        this.f16795b = materialButton;
        this.f16796c = guildScheduledEventItemView;
        this.f16797d = widgetInviteInfo;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16794a;
    }
}
