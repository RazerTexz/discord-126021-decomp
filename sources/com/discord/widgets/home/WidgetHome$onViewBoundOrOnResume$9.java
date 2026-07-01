package com.discord.widgets.home;

import com.discord.stores.StoreNux$NuxState;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetHome.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHome$onViewBoundOrOnResume$9 extends o implements Function1<StoreNux$NuxState, Unit> {
    public final /* synthetic */ WidgetHome this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHome$onViewBoundOrOnResume$9(WidgetHome widgetHome) {
        super(1);
        this.this$0 = widgetHome;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(StoreNux$NuxState storeNux$NuxState) {
        invoke2(storeNux$NuxState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(StoreNux$NuxState storeNux$NuxState) {
        WidgetHome.access$configureFirstOpen(this.this$0);
    }
}
