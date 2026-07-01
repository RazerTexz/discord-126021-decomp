package com.discord.stores;

import com.discord.api.application.ApplicationAsset;
import d0.z.d.o;
import java.util.Map;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreApplicationAssets.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreApplicationAssets$observeEmbeddedAppBackgrounds$1 extends o implements Function0<Map<Long, ? extends ApplicationAsset>> {
    public final /* synthetic */ StoreApplicationAssets this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreApplicationAssets$observeEmbeddedAppBackgrounds$1(StoreApplicationAssets storeApplicationAssets) {
        super(0);
        this.this$0 = storeApplicationAssets;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Map<Long, ? extends ApplicationAsset> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Map<Long, ? extends ApplicationAsset> invoke2() {
        return this.this$0.getEmbeddedAppBackgrounds();
    }
}
