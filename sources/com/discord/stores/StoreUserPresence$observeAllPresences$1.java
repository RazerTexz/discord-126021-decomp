package com.discord.stores;

import com.discord.models.presence.Presence;
import d0.z.d.o;
import java.util.Map;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreUserPresence.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreUserPresence$observeAllPresences$1 extends o implements Function0<Map<Long, ? extends Presence>> {
    public final /* synthetic */ StoreUserPresence this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreUserPresence$observeAllPresences$1(StoreUserPresence storeUserPresence) {
        super(0);
        this.this$0 = storeUserPresence;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Map<Long, ? extends Presence> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Map<Long, ? extends Presence> invoke2() {
        return this.this$0.m19getPresences();
    }
}
