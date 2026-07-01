package com.discord.widgets.user.usersheet;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetUserSheetViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserSheetViewModel$removeRelationship$1 extends o implements Function1<Void, Unit> {
    public final /* synthetic */ int $successMessageStringRes;
    public final /* synthetic */ WidgetUserSheetViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetUserSheetViewModel$removeRelationship$1(WidgetUserSheetViewModel widgetUserSheetViewModel, int i) {
        super(1);
        this.this$0 = widgetUserSheetViewModel;
        this.$successMessageStringRes = i;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
        invoke2(r1);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Void r2) {
        WidgetUserSheetViewModel.access$emitShowToastEvent(this.this$0, this.$successMessageStringRes);
    }
}
