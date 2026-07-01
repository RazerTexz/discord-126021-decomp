package com.discord.widgets.home;

import android.view.View;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.home.WidgetHome$onGuildListAddHintCreate$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetHome.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHome3 extends Lambda implements Function1<View, Unit> {
    public static final WidgetHome3 INSTANCE = new WidgetHome3();

    public WidgetHome3() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "it");
    }
}
