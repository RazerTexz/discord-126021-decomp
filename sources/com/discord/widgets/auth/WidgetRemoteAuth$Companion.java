package com.discord.widgets.auth;

import android.content.Context;
import android.content.Intent;
import b.a.d.j;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetRemoteAuth.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetRemoteAuth$Companion {
    private WidgetRemoteAuth$Companion() {
    }

    public final void launch(Context context, String fingerprint) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(fingerprint, "fingerprint");
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.putExtra("REMOTE_AUTH_FINGERPRINT", fingerprint);
        j.d(context, WidgetRemoteAuth.class, intent);
    }

    public /* synthetic */ WidgetRemoteAuth$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
