package com.discord.widgets.hubs.events;

import com.discord.api.directory.DirectoryEntryEvent;
import com.discord.stores.utilities.Success;
import d0.z.d.m;
import d0.z.d.o;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetHubEventsPage.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubEventsPage$configUI$3 extends o implements Function1<Success<? extends List<? extends DirectoryEntryEvent>>, Unit> {
    public final /* synthetic */ WidgetHubEventsPage this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubEventsPage$configUI$3(WidgetHubEventsPage widgetHubEventsPage) {
        super(1);
        this.this$0 = widgetHubEventsPage;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Success<? extends List<? extends DirectoryEntryEvent>> success) {
        invoke2((Success<? extends List<DirectoryEntryEvent>>) success);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Success<? extends List<DirectoryEntryEvent>> success) {
        m.checkNotNullParameter(success, "it");
        this.this$0.getBinding().f2477b.smoothScrollToPosition(0);
        this.this$0.getViewModel().reset();
    }
}
