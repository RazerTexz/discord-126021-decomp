package com.discord.stores;

import android.content.Context;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;

/* JADX INFO: compiled from: StoreUserProfile.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreUserProfile$fetchProfile$1 extends o implements Function0<Unit> {
    public final /* synthetic */ Long $guildId;
    public final /* synthetic */ Function1 $onFetchSuccess;
    public final /* synthetic */ long $userId;
    public final /* synthetic */ boolean $withMutualGuilds;
    public final /* synthetic */ StoreUserProfile this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreUserProfile$fetchProfile$1(StoreUserProfile storeUserProfile, long j, Long l, boolean z2, Function1 function1) {
        super(0);
        this.this$0 = storeUserProfile;
        this.$userId = j;
        this.$guildId = l;
        this.$withMutualGuilds = z2;
        this.$onFetchSuccess = function1;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        if (StoreUserProfile.access$getProfilesLoading$p(this.this$0).contains(Long.valueOf(this.$userId))) {
            return;
        }
        StoreUserProfile.access$getProfilesLoading$p(this.this$0).add(Long.valueOf(this.$userId));
        Observable observableR = ObservableExtensionsKt.restSubscribeOn$default(StoreUserProfile.access$getRestAPI$p(this.this$0).userProfileGet(this.$userId, this.$withMutualGuilds, this.$guildId), false, 1, null).r();
        m.checkNotNullExpressionValue(observableR, "restAPI\n          .userP…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(observableR, this.this$0.getClass(), (Context) null, (Function1) null, new StoreUserProfile$fetchProfile$1$2(this), (Function0) null, (Function0) null, new StoreUserProfile$fetchProfile$1$1(this), 54, (Object) null);
    }
}
