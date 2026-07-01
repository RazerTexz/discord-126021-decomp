package com.discord.widgets.auth;

import android.content.Context;
import android.content.Intent;
import b.a.d.j;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetAuthMfa.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAuthMfa$Companion {
    private WidgetAuthMfa$Companion() {
    }

    public final void start(Context context, String ticket) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(ticket, "ticket");
        Intent intent = new Intent();
        intent.putExtra("INTENT_TICKET", ticket);
        j.d(context, WidgetAuthMfa.class, intent);
    }

    public /* synthetic */ WidgetAuthMfa$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
