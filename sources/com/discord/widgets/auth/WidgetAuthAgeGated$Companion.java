package com.discord.widgets.auth;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import b.a.d.j;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetAuthAgeGated.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAuthAgeGated$Companion {
    private WidgetAuthAgeGated$Companion() {
    }

    public final void start(Context context, String message) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(message, "message");
        Bundle bundle = new Bundle();
        bundle.putString("INTENT_UNDERAGE_MESSAGE", message);
        j.d(context, WidgetAuthAgeGated.class, new Intent().putExtras(bundle));
    }

    public /* synthetic */ WidgetAuthAgeGated$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
