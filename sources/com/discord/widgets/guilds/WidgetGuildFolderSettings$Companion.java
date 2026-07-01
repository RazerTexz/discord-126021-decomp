package com.discord.widgets.guilds;

import android.content.Context;
import android.content.Intent;
import b.a.d.j;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetGuildFolderSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildFolderSettings$Companion {
    private WidgetGuildFolderSettings$Companion() {
    }

    public final void create(Context context, long folderId) {
        m.checkNotNullParameter(context, "context");
        j.d(context, WidgetGuildFolderSettings.class, new Intent().putExtra("com.discord.intent.extra.EXTRA_GUILD_FOLDER_ID", folderId));
    }

    public /* synthetic */ WidgetGuildFolderSettings$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
