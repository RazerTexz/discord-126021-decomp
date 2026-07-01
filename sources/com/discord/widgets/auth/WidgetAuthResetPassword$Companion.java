package com.discord.widgets.auth;

import android.content.Context;
import android.content.Intent;
import b.a.d.j;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetAuthResetPassword.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAuthResetPassword$Companion {
    private WidgetAuthResetPassword$Companion() {
    }

    public final void start(Context context, String token) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(token, "token");
        Intent intent = new Intent();
        intent.putExtra("INTENT_EXTRA_TOKEN", token);
        j.d(context, WidgetAuthResetPassword.class, intent);
    }

    public /* synthetic */ WidgetAuthResetPassword$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
