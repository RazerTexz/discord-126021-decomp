package com.discord.widgets.user;

import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetKickUser.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetKickUser$Companion {
    private WidgetKickUser$Companion() {
    }

    public final void launch(String userName, long guildId, long userId, FragmentManager fragmentManager) {
        m.checkNotNullParameter(userName, "userName");
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        WidgetKickUser widgetKickUser = new WidgetKickUser();
        Bundle bundle = new Bundle();
        bundle.putString("com.discord.intent.extra.EXTRA_USER_NAME", userName);
        bundle.putLong("com.discord.intent.extra.EXTRA_GUILD_ID", guildId);
        bundle.putLong("com.discord.intent.extra.EXTRA_USER_ID", userId);
        widgetKickUser.setArguments(bundle);
        widgetKickUser.show(fragmentManager, WidgetKickUser.class.getSimpleName());
    }

    public /* synthetic */ WidgetKickUser$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
