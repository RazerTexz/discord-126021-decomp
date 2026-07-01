package com.discord.widgets.guilds.leave;

import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetLeaveGuildDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetLeaveGuildDialog$Companion {
    private WidgetLeaveGuildDialog$Companion() {
    }

    public final void show(FragmentManager fragmentManager, long guildId) {
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        Bundle bundle = new Bundle();
        bundle.putLong("com.discord.intent.extra.EXTRA_GUILD_ID", guildId);
        WidgetLeaveGuildDialog widgetLeaveGuildDialog = new WidgetLeaveGuildDialog();
        widgetLeaveGuildDialog.setArguments(bundle);
        widgetLeaveGuildDialog.show(fragmentManager, WidgetLeaveGuildDialog.class.getSimpleName());
    }

    public /* synthetic */ WidgetLeaveGuildDialog$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
