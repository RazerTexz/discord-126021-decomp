package com.discord.widgets.notice;

import android.view.View;
import b.i.c.m.d.k.CommonUtils;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetNoticeDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetNoticeDialog$Companion$showInputModal$2 extends Lambda implements Function1<View, Unit> {
    public final /* synthetic */ Function0 $onCancelClicked;
    public final /* synthetic */ boolean $shouldHideKeyboard;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetNoticeDialog$Companion$showInputModal$2(Function0 function0, boolean z2) {
        super(1);
        this.$onCancelClicked = function0;
        this.$shouldHideKeyboard = z2;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        this.$onCancelClicked.invoke();
        if (this.$shouldHideKeyboard) {
            CommonUtils.r(view.getContext(), view);
        }
    }
}
