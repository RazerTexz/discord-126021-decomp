package com.discord.utilities;

import com.discord.stores.StoreUserGuildSettings$Event;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreUIEventHandler.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreUIEventHandler$subscribeToStoreEvents$2 extends o implements Function1<StoreUserGuildSettings$Event, Unit> {
    public final /* synthetic */ StoreUIEventHandler this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreUIEventHandler$subscribeToStoreEvents$2(StoreUIEventHandler storeUIEventHandler) {
        super(1);
        this.this$0 = storeUIEventHandler;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(StoreUserGuildSettings$Event storeUserGuildSettings$Event) {
        invoke2(storeUserGuildSettings$Event);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(StoreUserGuildSettings$Event storeUserGuildSettings$Event) {
        m.checkNotNullParameter(storeUserGuildSettings$Event, "event");
        StoreUIEventHandler.access$handleUserGuildSettingsEvent(this.this$0, storeUserGuildSettings$Event);
    }
}
