package com.discord.stores;

import com.discord.models.domain.ModelReadState;
import d0.z.d.m;
import d0.z.d.o;
import java.util.HashSet;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreMentions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMentions$handleConnectionOpen$3 extends o implements Function1<ModelReadState, Boolean> {
    public final /* synthetic */ HashSet $newReadStateChannelIds;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreMentions$handleConnectionOpen$3(HashSet hashSet) {
        super(1);
        this.$newReadStateChannelIds = hashSet;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(ModelReadState modelReadState) {
        return Boolean.valueOf(invoke2(modelReadState));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(ModelReadState modelReadState) {
        m.checkNotNullParameter(modelReadState, "readState");
        return this.$newReadStateChannelIds.contains(Long.valueOf(modelReadState.getChannelId()));
    }
}
