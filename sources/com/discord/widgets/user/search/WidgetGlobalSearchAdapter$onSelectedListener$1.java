package com.discord.widgets.user.search;

import android.view.View;
import com.discord.widgets.user.search.WidgetGlobalSearchModel;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetGlobalSearchAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetGlobalSearchAdapter$onSelectedListener$1 extends AbstractC12240o implements Function4<View, Integer, WidgetGlobalSearchModel.ItemDataPayload, Boolean, Unit> {
    public static final WidgetGlobalSearchAdapter$onSelectedListener$1 INSTANCE = new WidgetGlobalSearchAdapter$onSelectedListener$1();

    public WidgetGlobalSearchAdapter$onSelectedListener$1() {
        super(4);
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ Unit invoke(View view, Integer num, WidgetGlobalSearchModel.ItemDataPayload itemDataPayload, Boolean bool) {
        invoke(view, num.intValue(), itemDataPayload, bool.booleanValue());
        return Unit.f27425a;
    }

    public final void invoke(View view, int i, WidgetGlobalSearchModel.ItemDataPayload itemDataPayload, boolean z2) {
        C12238m.checkNotNullParameter(view, "<anonymous parameter 0>");
        C12238m.checkNotNullParameter(itemDataPayload, "<anonymous parameter 2>");
    }
}
