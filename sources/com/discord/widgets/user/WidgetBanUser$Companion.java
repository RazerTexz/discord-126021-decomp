package com.discord.widgets.user;

import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetBanUser.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetBanUser$Companion {
    private WidgetBanUser$Companion() {
    }

    public final void launch(String userName, long guildId, long userId, FragmentManager fragmentManager) {
        m.checkNotNullParameter(userName, "userName");
        if (fragmentManager == null) {
            return;
        }
        WidgetBanUser widgetBanUser = new WidgetBanUser();
        Bundle bundle = new Bundle();
        bundle.putString("com.discord.intent.extra.EXTRA_USER_NAME", userName);
        bundle.putLong("com.discord.intent.extra.EXTRA_GUILD_ID", guildId);
        bundle.putLong("com.discord.intent.extra.EXTRA_USER_ID", userId);
        widgetBanUser.setArguments(bundle);
        widgetBanUser.show(fragmentManager, WidgetBanUser.class.getSimpleName());
    }

    public /* synthetic */ WidgetBanUser$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
