package com.discord.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventItemView;

/* JADX INFO: loaded from: classes.dex */
public final class VoiceUserListItemEventBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final FrameLayout f15619a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final GuildScheduledEventItemView f15620b;

    public VoiceUserListItemEventBinding(@NonNull FrameLayout frameLayout, @NonNull GuildScheduledEventItemView guildScheduledEventItemView) {
        this.f15619a = frameLayout;
        this.f15620b = guildScheduledEventItemView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15619a;
    }
}
