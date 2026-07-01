package com.discord.widgets.notice;

import android.view.View;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetNoticeDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetNoticeDialog$Builder$setPositiveButton$2 extends Lambda implements Function1<View, Unit> {
    public static final WidgetNoticeDialog$Builder$setPositiveButton$2 INSTANCE = new WidgetNoticeDialog$Builder$setPositiveButton$2();

    public WidgetNoticeDialog$Builder$setPositiveButton$2() {
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
