package com.discord.widgets.servers;

import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetServerDeleteDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerDeleteDialog$Companion {
    private WidgetServerDeleteDialog$Companion() {
    }

    public final void show(FragmentManager fragmentManager, long guildId) {
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        WidgetServerDeleteDialog widgetServerDeleteDialog = new WidgetServerDeleteDialog();
        Bundle bundle = new Bundle();
        bundle.putLong("INTENT_GUILD_ID", guildId);
        widgetServerDeleteDialog.setArguments(bundle);
        widgetServerDeleteDialog.show(fragmentManager, WidgetServerDeleteDialog.class.getSimpleName());
    }

    public /* synthetic */ WidgetServerDeleteDialog$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
