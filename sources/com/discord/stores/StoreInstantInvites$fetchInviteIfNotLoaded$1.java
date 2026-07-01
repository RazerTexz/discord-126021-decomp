package com.discord.stores;

import android.content.Context;
import com.discord.stores.utilities.RestCallStateKt;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreInstantInvites.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreInstantInvites$fetchInviteIfNotLoaded$1 extends o implements Function0<Unit> {
    public final /* synthetic */ Long $eventId;
    public final /* synthetic */ String $inviteCode;
    public final /* synthetic */ String $inviteKey;
    public final /* synthetic */ Boolean $inviteResolved;
    public final /* synthetic */ String $location;
    public final /* synthetic */ Function0 $onError;
    public final /* synthetic */ StoreInstantInvites this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreInstantInvites$fetchInviteIfNotLoaded$1(StoreInstantInvites storeInstantInvites, String str, String str2, Long l, Boolean bool, String str3, Function0 function0) {
        super(0);
        this.this$0 = storeInstantInvites;
        this.$inviteKey = str;
        this.$inviteCode = str2;
        this.$eventId = l;
        this.$inviteResolved = bool;
        this.$location = str3;
        this.$onError = function0;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        if (!StoreInstantInvites.access$getKnownInvites$p(this.this$0).containsKey(this.$inviteKey) || (StoreInstantInvites.access$getKnownInvites$p(this.this$0).get(this.$inviteKey) instanceof StoreInstantInvites$InviteState$LoadFailed)) {
            AnalyticsTracker.inviteOpened(this.$inviteCode);
            StoreInstantInvites storeInstantInvites = this.this$0;
            String str = this.$inviteKey;
            m.checkNotNullExpressionValue(str, "inviteKey");
            StoreInstantInvites.access$setChatInvites(storeInstantInvites, str, StoreInstantInvites$InviteState$Loading.INSTANCE);
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(RestCallStateKt.logNetworkAction(StoreInstantInvites.access$getRestAPI$p(this.this$0).getInviteCode(this.$inviteCode, true, this.$eventId), new StoreInstantInvites$fetchInviteIfNotLoaded$1$1(this)), false, 1, null), this.this$0.getClass(), (Context) null, (Function1) null, new StoreInstantInvites$fetchInviteIfNotLoaded$1$3(this), (Function0) null, (Function0) null, new StoreInstantInvites$fetchInviteIfNotLoaded$1$2(this), 54, (Object) null);
        }
    }
}
