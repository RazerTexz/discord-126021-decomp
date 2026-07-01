package com.discord.widgets.user;

import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetPruneUsers.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetPruneUsers$Companion {
    private WidgetPruneUsers$Companion() {
    }

    public final void create(long guildId, FragmentManager fragmentManager) {
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        WidgetPruneUsers widgetPruneUsers = new WidgetPruneUsers();
        Bundle bundle = new Bundle();
        bundle.putLong("ARG_GUILD_ID", guildId);
        widgetPruneUsers.setArguments(bundle);
        widgetPruneUsers.show(fragmentManager, WidgetPruneUsers.class.getName());
    }

    public /* synthetic */ WidgetPruneUsers$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
