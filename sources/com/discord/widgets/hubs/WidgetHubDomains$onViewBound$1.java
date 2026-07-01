package com.discord.widgets.hubs;

import android.content.Context;
import android.view.MenuItem;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentManager;
import b.a.d.j;
import d0.z.d.m;
import rx.functions.Action2;

/* JADX INFO: compiled from: WidgetHubDomains.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubDomains$onViewBound$1<T1, T2> implements Action2<MenuItem, Context> {
    public final /* synthetic */ WidgetHubDomains this$0;

    public WidgetHubDomains$onViewBound$1(WidgetHubDomains widgetHubDomains) {
        this.this$0 = widgetHubDomains;
    }

    @Override // rx.functions.Action2
    public /* bridge */ /* synthetic */ void call(MenuItem menuItem, Context context) {
        call2(menuItem, context);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(MenuItem menuItem, Context context) {
        m.checkNotNullExpressionValue(menuItem, "item");
        if (menuItem.getItemId() == 2131365057) {
            j jVar = j.g;
            FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
            m.checkNotNullExpressionValue(context, "context");
            j.g(jVar, parentFragmentManager, context, WidgetHubDomainSearch.class, 0, true, null, null, 104);
        }
    }
}
