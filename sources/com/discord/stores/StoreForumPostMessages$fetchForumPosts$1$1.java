package com.discord.stores;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreForumPostMessages.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreForumPostMessages$fetchForumPosts$1$1 extends o implements Function0<Unit> {
    public final /* synthetic */ StoreForumPostMessages$fetchForumPosts$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreForumPostMessages$fetchForumPosts$1$1(StoreForumPostMessages$fetchForumPosts$1 storeForumPostMessages$fetchForumPosts$1) {
        super(0);
        this.this$0 = storeForumPostMessages$fetchForumPosts$1;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.this$0.$onTerminated.invoke();
    }
}
