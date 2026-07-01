package com.discord.widgets.user.search;

import android.view.View;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;

/* JADX INFO: compiled from: WidgetGlobalSearchAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetGlobalSearchAdapter$onSelectedListener$1 extends o implements Function4<View, Integer, WidgetGlobalSearchModel$ItemDataPayload, Boolean, Unit> {
    public static final WidgetGlobalSearchAdapter$onSelectedListener$1 INSTANCE = new WidgetGlobalSearchAdapter$onSelectedListener$1();

    public WidgetGlobalSearchAdapter$onSelectedListener$1() {
        super(4);
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ Unit invoke(View view, Integer num, WidgetGlobalSearchModel$ItemDataPayload widgetGlobalSearchModel$ItemDataPayload, Boolean bool) {
        invoke(view, num.intValue(), widgetGlobalSearchModel$ItemDataPayload, bool.booleanValue());
        return Unit.a;
    }

    public final void invoke(View view, int i, WidgetGlobalSearchModel$ItemDataPayload widgetGlobalSearchModel$ItemDataPayload, boolean z2) {
        m.checkNotNullParameter(view, "<anonymous parameter 0>");
        m.checkNotNullParameter(widgetGlobalSearchModel$ItemDataPayload, "<anonymous parameter 2>");
    }
}
