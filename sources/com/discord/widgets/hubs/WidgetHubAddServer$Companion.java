package com.discord.widgets.hubs;

import b.a.d.j;
import com.discord.app.AppFragment;
import com.discord.utilities.hubs.HubUtilsKt;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetHubAddServer.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubAddServer$Companion {
    private WidgetHubAddServer$Companion() {
    }

    public final void startScreenForResult(AppFragment fragment) {
        m.checkNotNullParameter(fragment, "fragment");
        j.g.f(fragment.requireContext(), HubUtilsKt.getAddServerActivityResultHandler(fragment), WidgetHubAddServer.class, null);
    }

    public /* synthetic */ WidgetHubAddServer$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
