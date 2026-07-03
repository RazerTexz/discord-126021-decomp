package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventItemView;

/* JADX INFO: loaded from: classes.dex */
public final class GuildScheduledEventListItemBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final GuildScheduledEventItemView f15150a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final GuildScheduledEventItemView f15151b;

    public GuildScheduledEventListItemBinding(@NonNull GuildScheduledEventItemView guildScheduledEventItemView, @NonNull GuildScheduledEventItemView guildScheduledEventItemView2) {
        this.f15150a = guildScheduledEventItemView;
        this.f15151b = guildScheduledEventItemView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15150a;
    }
}
