package com.discord.widgets.auth;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.view.View;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetAuthLogin.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAuthLogin$onViewBound$5$1 extends o implements Function1<View, Unit> {
    public static final WidgetAuthLogin$onViewBound$5$1 INSTANCE = new WidgetAuthLogin$onViewBound$5$1();

    public WidgetAuthLogin$onViewBound$5$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        m.checkNotNullParameter(view, "it");
        try {
            view.getContext().startActivity(new Intent("android.settings.ACCESSIBILITY_SETTINGS"));
        } catch (ActivityNotFoundException unused) {
            b.a.d.m.g(view.getContext(), 2131893653, 0, null, 12);
        }
    }
}
