package com.discord.utilities.systemlog;

import d0.g0.w;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: SystemLogCapture.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SystemLogCapture$Companion {
    private SystemLogCapture$Companion() {
    }

    public final boolean shouldIncludeLogLine$app_productionGoogleRelease(String line) {
        m.checkNotNullParameter(line, "line");
        return !w.contains$default((CharSequence) line, (CharSequence) "chatty  : uid=", false, 2, (Object) null);
    }

    public /* synthetic */ SystemLogCapture$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
