package com.discord.stores;

import com.discord.models.domain.ModelInvite;
import d0.z.d.m;
import d0.z.d.o;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreInstantInvites.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreInstantInvites$fetchGuildInvites$1 extends o implements Function1<List<? extends ModelInvite>, Unit> {
    public final /* synthetic */ StoreInstantInvites this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreInstantInvites$fetchGuildInvites$1(StoreInstantInvites storeInstantInvites) {
        super(1);
        this.this$0 = storeInstantInvites;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends ModelInvite> list) {
        invoke2(list);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<? extends ModelInvite> list) {
        m.checkNotNullParameter(list, "invites");
        StoreInstantInvites.access$getDispatcher$p(this.this$0).schedule(new StoreInstantInvites$fetchGuildInvites$1$1(this, list));
    }
}
