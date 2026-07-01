package com.discord.stores;

import com.discord.models.domain.ModelLibraryApplication;
import d0.z.d.o;
import java.util.Map;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreLibrary.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreLibrary$observeApplications$1 extends o implements Function0<Map<Long, ? extends ModelLibraryApplication>> {
    public final /* synthetic */ StoreLibrary this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreLibrary$observeApplications$1(StoreLibrary storeLibrary) {
        super(0);
        this.this$0 = storeLibrary;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Map<Long, ? extends ModelLibraryApplication> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Map<Long, ? extends ModelLibraryApplication> invoke2() {
        return StoreLibrary.access$getLibraryApplicationSnapshot$p(this.this$0);
    }
}
