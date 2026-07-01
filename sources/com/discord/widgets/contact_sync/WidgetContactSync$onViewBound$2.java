package com.discord.widgets.contact_sync;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: WidgetContactSync.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetContactSync$onViewBound$2 extends o implements Function2<Long, Boolean, Unit> {
    public final /* synthetic */ WidgetContactSync this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetContactSync$onViewBound$2(WidgetContactSync widgetContactSync) {
        super(2);
        this.this$0 = widgetContactSync;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Long l, Boolean bool) {
        invoke(l.longValue(), bool.booleanValue());
        return Unit.a;
    }

    public final void invoke(long j, boolean z2) {
        WidgetContactSync.access$getViewModel$p(this.this$0).handleToggleFriendSuggestionSelected(j, z2);
    }
}
