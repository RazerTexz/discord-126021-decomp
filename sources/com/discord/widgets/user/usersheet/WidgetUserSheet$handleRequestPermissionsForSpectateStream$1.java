package com.discord.widgets.user.usersheet;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetUserSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserSheet$handleRequestPermissionsForSpectateStream$1 extends o implements Function0<Unit> {
    public final /* synthetic */ WidgetUserSheetViewModel$Event$RequestPermissionsForSpectateStream $event;
    public final /* synthetic */ WidgetUserSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetUserSheet$handleRequestPermissionsForSpectateStream$1(WidgetUserSheet widgetUserSheet, WidgetUserSheetViewModel$Event$RequestPermissionsForSpectateStream widgetUserSheetViewModel$Event$RequestPermissionsForSpectateStream) {
        super(0);
        this.this$0 = widgetUserSheet;
        this.$event = widgetUserSheetViewModel$Event$RequestPermissionsForSpectateStream;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        WidgetUserSheet.access$getViewModel$p(this.this$0).onSpectatePermissionsGranted(this.$event.getStream());
    }
}
