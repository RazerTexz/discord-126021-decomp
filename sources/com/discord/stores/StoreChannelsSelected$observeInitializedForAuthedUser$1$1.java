package com.discord.stores;

import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreChannelsSelected.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreChannelsSelected$observeInitializedForAuthedUser$1$1 extends o implements Function0<Boolean> {
    public final /* synthetic */ StoreChannelsSelected$observeInitializedForAuthedUser$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreChannelsSelected$observeInitializedForAuthedUser$1$1(StoreChannelsSelected$observeInitializedForAuthedUser$1 storeChannelsSelected$observeInitializedForAuthedUser$1) {
        super(0);
        this.this$0 = storeChannelsSelected$observeInitializedForAuthedUser$1;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Boolean invoke() {
        return Boolean.valueOf(invoke2());
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2() {
        return StoreChannelsSelected.access$getInitializedForAuthedUser$p(this.this$0.this$0);
    }
}
