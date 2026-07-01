package com.discord.widgets.debugging;

import androidx.core.app.NotificationCompat;
import com.discord.app.AppLog$LoggedItem;
import d0.z.d.m;
import j0.k.b;
import java.util.List;

/* JADX INFO: compiled from: WidgetDebugging.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetDebugging$onViewBoundOrOnResume$1<T, R> implements b<List<AppLog$LoggedItem>, Boolean> {
    public static final WidgetDebugging$onViewBoundOrOnResume$1 INSTANCE = new WidgetDebugging$onViewBoundOrOnResume$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Boolean call(List<AppLog$LoggedItem> list) {
        return call2(list);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Boolean call2(List<AppLog$LoggedItem> list) {
        m.checkNotNullExpressionValue(list, "it");
        return Boolean.valueOf(!list.isEmpty());
    }
}
