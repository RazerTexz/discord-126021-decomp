package com.discord.stores;

import android.content.Context;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreApplicationAssets.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreApplicationAssets$fetchIfNonExisting$1 extends o implements Function0<Unit> {
    public final /* synthetic */ long $appId;
    public final /* synthetic */ StoreApplicationAssets this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreApplicationAssets$fetchIfNonExisting$1(StoreApplicationAssets storeApplicationAssets, long j) {
        super(0);
        this.this$0 = storeApplicationAssets;
        this.$appId = j;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        if (StoreApplicationAssets.access$getEmbeddedAppBackgrounds$p(this.this$0).containsKey(Long.valueOf(this.$appId)) || StoreApplicationAssets.access$getEmbeddedAppBackgroundsLoading$p(this.this$0).contains(Long.valueOf(this.$appId))) {
            return;
        }
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(StoreApplicationAssets.access$getRestApi$p(this.this$0).getApplicationAssets(this.$appId), false, 1, null), this.this$0.getClass(), (Context) null, (Function1) null, new StoreApplicationAssets$fetchIfNonExisting$1$2(this), (Function0) null, (Function0) null, new StoreApplicationAssets$fetchIfNonExisting$1$1(this), 54, (Object) null);
    }
}
