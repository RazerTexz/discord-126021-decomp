package com.discord.widgets.stage.sheet;

import android.os.Bundle;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetEndStageBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEndStageBottomSheet$Companion$registerForResult$1 extends AbstractC12240o implements Function2<String, Bundle, Unit> {
    public final /* synthetic */ Function0 $onActionTaken;
    public final /* synthetic */ String $requestKey;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetEndStageBottomSheet$Companion$registerForResult$1(String str, Function0 function0) {
        super(2);
        this.$requestKey = str;
        this.$onActionTaken = function0;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(String str, Bundle bundle) {
        invoke2(str, bundle);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String str, Bundle bundle) {
        C12238m.checkNotNullParameter(str, "resultRequestKey");
        C12238m.checkNotNullParameter(bundle, "<anonymous parameter 1>");
        if (C12238m.areEqual(this.$requestKey, str)) {
            this.$onActionTaken.invoke();
        }
    }
}
