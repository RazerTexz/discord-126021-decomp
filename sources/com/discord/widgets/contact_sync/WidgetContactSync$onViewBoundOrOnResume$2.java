package com.discord.widgets.contact_sync;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetContactSync.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetContactSync$onViewBoundOrOnResume$2 extends o implements Function1<WidgetContactSyncViewModel$Event, Unit> {
    public final /* synthetic */ WidgetContactSync this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetContactSync$onViewBoundOrOnResume$2(WidgetContactSync widgetContactSync) {
        super(1);
        this.this$0 = widgetContactSync;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetContactSyncViewModel$Event widgetContactSyncViewModel$Event) {
        invoke2(widgetContactSyncViewModel$Event);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetContactSyncViewModel$Event widgetContactSyncViewModel$Event) {
        m.checkNotNullParameter(widgetContactSyncViewModel$Event, "it");
        WidgetContactSync.access$handleEvent(this.this$0, widgetContactSyncViewModel$Event);
    }
}
