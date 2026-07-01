package com.discord.widgets.user.usersheet;

import d0.z.d.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetUserSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WidgetUserSheet$configureProfileActionButtons$8$1 extends k implements Function1<Integer, Unit> {
    public WidgetUserSheet$configureProfileActionButtons$8$1(WidgetUserSheetViewModel widgetUserSheetViewModel) {
        super(1, widgetUserSheetViewModel, WidgetUserSheetViewModel.class, "removeRelationship", "removeRelationship(I)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        invoke(num.intValue());
        return Unit.a;
    }

    public final void invoke(int i) {
        ((WidgetUserSheetViewModel) this.receiver).removeRelationship(i);
    }
}
