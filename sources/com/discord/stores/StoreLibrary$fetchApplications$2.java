package com.discord.stores;

import com.discord.models.domain.ModelLibraryApplication;
import d0.z.d.m;
import d0.z.d.o;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreLibrary.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreLibrary$fetchApplications$2 extends o implements Function1<List<? extends ModelLibraryApplication>, Unit> {
    public final /* synthetic */ StoreLibrary this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreLibrary$fetchApplications$2(StoreLibrary storeLibrary) {
        super(1);
        this.this$0 = storeLibrary;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends ModelLibraryApplication> list) {
        invoke2((List<ModelLibraryApplication>) list);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<ModelLibraryApplication> list) {
        m.checkNotNullParameter(list, "libraryApps");
        this.this$0.getDispatcher().schedule(new StoreLibrary$fetchApplications$2$1(this, list));
    }
}
