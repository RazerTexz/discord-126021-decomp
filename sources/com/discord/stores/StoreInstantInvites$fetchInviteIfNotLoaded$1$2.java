package com.discord.stores;

import com.discord.models.domain.ModelInvite;
import com.discord.utilities.analytics.AnalyticsTracker;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreInstantInvites.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreInstantInvites$fetchInviteIfNotLoaded$1$2 extends o implements Function1<ModelInvite, Unit> {
    public final /* synthetic */ StoreInstantInvites$fetchInviteIfNotLoaded$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreInstantInvites$fetchInviteIfNotLoaded$1$2(StoreInstantInvites$fetchInviteIfNotLoaded$1 storeInstantInvites$fetchInviteIfNotLoaded$1) {
        super(1);
        this.this$0 = storeInstantInvites$fetchInviteIfNotLoaded$1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ModelInvite modelInvite) {
        invoke2(modelInvite);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ModelInvite modelInvite) {
        m.checkNotNullParameter(modelInvite, "it");
        StoreInstantInvites.access$getDispatcher$p(this.this$0.this$0).schedule(new StoreInstantInvites$fetchInviteIfNotLoaded$1$2$1(this, modelInvite));
        String str = this.this$0.$location;
        if (str != null) {
            AnalyticsTracker.INSTANCE.inviteResolved(modelInvite, str);
        }
    }
}
