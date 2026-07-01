package com.discord.stores;

import com.discord.models.presence.Presence;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreUserPresence.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreUserPresence$observeLocalPresence$1 extends o implements Function0<Presence> {
    public final /* synthetic */ StoreUserPresence this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreUserPresence$observeLocalPresence$1(StoreUserPresence storeUserPresence) {
        super(0);
        this.this$0 = storeUserPresence;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Presence invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Presence invoke() {
        return StoreUserPresence.access$getLocalPresenceSnapshot$p(this.this$0);
    }
}
