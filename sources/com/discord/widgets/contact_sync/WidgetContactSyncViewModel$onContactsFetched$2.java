package com.discord.widgets.contact_sync;

import com.discord.api.friendsuggestions.BulkFriendSuggestions;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetContactSyncViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetContactSyncViewModel$onContactsFetched$2 extends o implements Function1<BulkFriendSuggestions, Unit> {
    public final /* synthetic */ WidgetContactSyncViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetContactSyncViewModel$onContactsFetched$2(WidgetContactSyncViewModel widgetContactSyncViewModel) {
        super(1);
        this.this$0 = widgetContactSyncViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(BulkFriendSuggestions bulkFriendSuggestions) {
        invoke2(bulkFriendSuggestions);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(BulkFriendSuggestions bulkFriendSuggestions) {
        m.checkNotNullParameter(bulkFriendSuggestions, "it");
        WidgetContactSyncViewModel.access$handleFriendSuggestions(this.this$0, bulkFriendSuggestions);
    }
}
