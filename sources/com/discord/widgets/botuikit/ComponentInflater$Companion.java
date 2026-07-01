package com.discord.widgets.botuikit;

import android.content.Context;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ComponentInflater.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ComponentInflater$Companion {
    private ComponentInflater$Companion() {
    }

    public final ComponentInflater from(Context context) {
        m.checkNotNullParameter(context, "context");
        return new ComponentInflater(context);
    }

    public /* synthetic */ ComponentInflater$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
