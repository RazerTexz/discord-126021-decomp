package com.discord.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventItemView;

/* JADX INFO: loaded from: classes.dex */
public final class VoiceUserListItemEventBinding implements ViewBinding {

    @NonNull
    public final FrameLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final GuildScheduledEventItemView f2220b;

    public VoiceUserListItemEventBinding(@NonNull FrameLayout frameLayout, @NonNull GuildScheduledEventItemView guildScheduledEventItemView) {
        this.a = frameLayout;
        this.f2220b = guildScheduledEventItemView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
