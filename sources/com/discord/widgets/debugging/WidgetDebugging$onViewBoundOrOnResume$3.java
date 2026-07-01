package com.discord.widgets.debugging;

import androidx.core.app.NotificationCompat;
import b.d.b.a.a;
import com.discord.app.AppLog$LoggedItem;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.List;
import rx.functions.Func2;

/* JADX INFO: compiled from: WidgetDebugging.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetDebugging$onViewBoundOrOnResume$3<T1, T2, R> implements Func2<List<? extends AppLog$LoggedItem>, Boolean, WidgetDebugging$Model> {
    public static final WidgetDebugging$onViewBoundOrOnResume$3 INSTANCE = new WidgetDebugging$onViewBoundOrOnResume$3();

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ WidgetDebugging$Model call(List<? extends AppLog$LoggedItem> list, Boolean bool) {
        return call2((List<AppLog$LoggedItem>) list, bool);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetDebugging$Model call2(List<AppLog$LoggedItem> list, Boolean bool) {
        m.checkNotNullExpressionValue(bool, "isFiltered");
        if (bool.booleanValue()) {
            ArrayList arrayListA0 = a.a0(list, "logs");
            for (Object obj : list) {
                if (((AppLog$LoggedItem) obj).priority > 2) {
                    arrayListA0.add(obj);
                }
            }
            list = arrayListA0;
        }
        m.checkNotNullExpressionValue(list, "filteredLogs");
        return new WidgetDebugging$Model(list, bool.booleanValue());
    }
}
