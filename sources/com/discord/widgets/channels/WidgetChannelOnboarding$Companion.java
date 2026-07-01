package com.discord.widgets.channels;

import androidx.fragment.app.FragmentManager;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetChannelOnboarding.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelOnboarding$Companion {
    private WidgetChannelOnboarding$Companion() {
    }

    public final void show(FragmentManager fragmentManager) {
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        new WidgetChannelOnboarding().show(fragmentManager, "javaClass");
    }

    public /* synthetic */ WidgetChannelOnboarding$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
