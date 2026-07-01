package com.discord.widgets.user.usersheet;

import com.discord.widgets.stage.usersheet.UserProfileStageActionsView$ViewState;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.objectweb.asm.Opcodes;

/* JADX INFO: compiled from: WidgetUserSheetViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserSheetViewModel$setUserSuppressedInChannel$1 extends o implements Function1<Void, Unit> {
    public final /* synthetic */ WidgetUserSheetViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetUserSheetViewModel$setUserSuppressedInChannel$1(WidgetUserSheetViewModel widgetUserSheetViewModel) {
        super(1);
        this.this$0 = widgetUserSheetViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
        invoke2(r1);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Void r30) {
        WidgetUserSheetViewModel$ViewState widgetUserSheetViewModel$ViewStateAccess$getViewState$p = WidgetUserSheetViewModel.access$getViewState$p(this.this$0);
        if (!(widgetUserSheetViewModel$ViewStateAccess$getViewState$p instanceof WidgetUserSheetViewModel$ViewState$Loaded)) {
            widgetUserSheetViewModel$ViewStateAccess$getViewState$p = null;
        }
        WidgetUserSheetViewModel$ViewState$Loaded widgetUserSheetViewModel$ViewState$Loaded = (WidgetUserSheetViewModel$ViewState$Loaded) widgetUserSheetViewModel$ViewStateAccess$getViewState$p;
        if (widgetUserSheetViewModel$ViewState$Loaded != null) {
            WidgetUserSheetViewModel.access$updateViewState(this.this$0, WidgetUserSheetViewModel$ViewState$Loaded.copy$default(widgetUserSheetViewModel$ViewState$Loaded, null, false, false, null, null, null, null, null, null, UserProfileStageActionsView$ViewState.m51copyam1GJgw$default(widgetUserSheetViewModel$ViewState$Loaded.getStageViewState(), false, null, null, null, false, false, false, false, Opcodes.ATHROW, null), null, null, null, null, 0, null, null, null, false, null, false, null, null, null, 16776703, null));
            WidgetUserSheetViewModel.access$emitDismissSheetEvent(this.this$0);
        }
    }
}
