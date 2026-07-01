package com.discord.stores;

import com.discord.models.domain.ModelGuildFolder;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreGuildsSorted.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuildsSorted$ensureValidPositions$6 extends o implements Function1<ModelGuildFolder, Boolean> {
    public static final StoreGuildsSorted$ensureValidPositions$6 INSTANCE = new StoreGuildsSorted$ensureValidPositions$6();

    public StoreGuildsSorted$ensureValidPositions$6() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(ModelGuildFolder modelGuildFolder) {
        return Boolean.valueOf(invoke2(modelGuildFolder));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(ModelGuildFolder modelGuildFolder) {
        m.checkNotNullParameter(modelGuildFolder, "it");
        return modelGuildFolder.getGuildIds().isEmpty();
    }
}
