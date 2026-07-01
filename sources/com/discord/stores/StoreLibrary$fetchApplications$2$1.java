package com.discord.stores;

import com.discord.models.domain.ModelLibraryApplication;
import d0.z.d.o;
import java.util.HashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreLibrary.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreLibrary$fetchApplications$2$1 extends o implements Function0<Unit> {
    public final /* synthetic */ List $libraryApps;
    public final /* synthetic */ StoreLibrary$fetchApplications$2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreLibrary$fetchApplications$2$1(StoreLibrary$fetchApplications$2 storeLibrary$fetchApplications$2, List list) {
        super(0);
        this.this$0 = storeLibrary$fetchApplications$2;
        this.$libraryApps = list;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        HashMap map = new HashMap();
        for (ModelLibraryApplication modelLibraryApplication : this.$libraryApps) {
            map.put(Long.valueOf(modelLibraryApplication.getSkuId()), modelLibraryApplication);
        }
        StoreLibrary.access$getLibraryApplications$p(this.this$0.this$0).clear();
        StoreLibrary.access$getLibraryApplications$p(this.this$0.this$0).putAll(map);
        this.this$0.this$0.markChanged();
    }
}
