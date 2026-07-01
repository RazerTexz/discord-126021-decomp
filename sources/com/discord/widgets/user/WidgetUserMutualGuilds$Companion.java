package com.discord.widgets.user;

import android.content.Context;
import android.content.Intent;
import b.a.d.j;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetUserMutualGuilds.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserMutualGuilds$Companion {
    private WidgetUserMutualGuilds$Companion() {
    }

    public final void show(Context context, long userId) {
        m.checkNotNullParameter(context, "context");
        Intent intent = new Intent();
        intent.putExtra("com.discord.intent.extra.EXTRA_USER_ID", userId);
        j.d(context, WidgetUserMutualGuilds.class, intent);
    }

    public /* synthetic */ WidgetUserMutualGuilds$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
