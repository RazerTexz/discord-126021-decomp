package com.discord.widgets.user.usersheet;

import com.discord.utilities.error.Error;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetUserSheetViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserSheetViewModel$launchVideoCall$2 extends o implements Function1<Error, Unit> {
    public final /* synthetic */ WidgetUserSheetViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetUserSheetViewModel$launchVideoCall$2(WidgetUserSheetViewModel widgetUserSheetViewModel) {
        super(1);
        this.this$0 = widgetUserSheetViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Error error) {
        invoke2(error);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Error error) {
        m.checkNotNullParameter(error, "it");
        WidgetUserSheetViewModel.access$emitShowToastEvent(this.this$0, 2131888366);
    }
}
