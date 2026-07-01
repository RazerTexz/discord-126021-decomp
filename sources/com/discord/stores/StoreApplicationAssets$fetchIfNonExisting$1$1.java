package com.discord.stores;

import com.discord.api.application.ApplicationAsset;
import d0.z.d.m;
import d0.z.d.o;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreApplicationAssets.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreApplicationAssets$fetchIfNonExisting$1$1 extends o implements Function1<List<? extends ApplicationAsset>, Unit> {
    public final /* synthetic */ StoreApplicationAssets$fetchIfNonExisting$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreApplicationAssets$fetchIfNonExisting$1$1(StoreApplicationAssets$fetchIfNonExisting$1 storeApplicationAssets$fetchIfNonExisting$1) {
        super(1);
        this.this$0 = storeApplicationAssets$fetchIfNonExisting$1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends ApplicationAsset> list) {
        invoke2((List<ApplicationAsset>) list);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<ApplicationAsset> list) {
        m.checkNotNullParameter(list, "applicationAssets");
        StoreApplicationAssets.access$getDispatcher$p(this.this$0.this$0).schedule(new StoreApplicationAssets$fetchIfNonExisting$1$1$1(this, list));
    }
}
