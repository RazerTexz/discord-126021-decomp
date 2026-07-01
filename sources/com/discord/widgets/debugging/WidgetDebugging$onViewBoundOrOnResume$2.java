package com.discord.widgets.debugging;

import androidx.core.app.NotificationCompat;
import com.discord.app.AppLog$LoggedItem;
import d0.t.u;
import d0.z.d.m;
import java.util.Collection;
import java.util.List;
import rx.functions.Func2;

/* JADX INFO: compiled from: WidgetDebugging.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetDebugging$onViewBoundOrOnResume$2<T1, T2, R> implements Func2<List<? extends AppLog$LoggedItem>, List<AppLog$LoggedItem>, List<? extends AppLog$LoggedItem>> {
    public static final WidgetDebugging$onViewBoundOrOnResume$2 INSTANCE = new WidgetDebugging$onViewBoundOrOnResume$2();

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ List<? extends AppLog$LoggedItem> call(List<? extends AppLog$LoggedItem> list, List<AppLog$LoggedItem> list2) {
        return call2((List<AppLog$LoggedItem>) list, list2);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final List<AppLog$LoggedItem> call2(List<AppLog$LoggedItem> list, List<AppLog$LoggedItem> list2) {
        m.checkNotNullExpressionValue(list, "existingLogs");
        m.checkNotNullExpressionValue(list2, "newLogs");
        return u.plus((Collection) list, (Iterable) list2);
    }
}
