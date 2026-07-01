package com.discord.widgets.tos;

import android.content.Context;
import android.content.Intent;
import b.a.d.j;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetTos.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetTos$Companion {
    private WidgetTos$Companion() {
    }

    public final void show(Context context, boolean isAck) {
        m.checkNotNullParameter(context, "context");
        Intent intent = new Intent();
        intent.putExtra("intent_args_key", isAck);
        j.d(context, WidgetTos.class, intent);
    }

    public /* synthetic */ WidgetTos$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
