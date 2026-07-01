package com.discord.widgets.guilds.create;

import com.discord.databinding.WidgetGuildCloneBinding;
import com.discord.databinding.WidgetGuildCreateBinding;
import d0.z.d.m;

/* JADX INFO: compiled from: GuildCreateCloneViews.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildCreateCloneViews$Companion {
    public static final /* synthetic */ GuildCreateCloneViews$Companion $$INSTANCE = new GuildCreateCloneViews$Companion();

    private GuildCreateCloneViews$Companion() {
    }

    public final GuildCreateCloneViews from(WidgetGuildCreateBinding binding) {
        m.checkNotNullParameter(binding, "binding");
        return new GuildCreateCloneViews$GuildCreateViews(binding);
    }

    public final GuildCreateCloneViews from(WidgetGuildCloneBinding binding) {
        m.checkNotNullParameter(binding, "binding");
        return new GuildCreateCloneViews$GuildCloneViews(binding);
    }
}
