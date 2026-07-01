package com.discord.stores;

import com.discord.stores.utilities.RestCallState;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreDirectories.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreDirectories$fetchDirectoriesForChannel$2$1 extends o implements Function0<Unit> {
    public final /* synthetic */ RestCallState $entriesResponse;
    public final /* synthetic */ StoreDirectories$fetchDirectoriesForChannel$2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreDirectories$fetchDirectoriesForChannel$2$1(StoreDirectories$fetchDirectoriesForChannel$2 storeDirectories$fetchDirectoriesForChannel$2, RestCallState restCallState) {
        super(0);
        this.this$0 = storeDirectories$fetchDirectoriesForChannel$2;
        this.$entriesResponse = restCallState;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreDirectories.access$getDirectoriesMap$p(this.this$0.this$0).put(Long.valueOf(this.this$0.$channelId), this.$entriesResponse);
        this.this$0.this$0.markChanged();
    }
}
