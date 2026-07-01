package com.discord.stores;

import com.discord.models.domain.ModelReadState;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreMentions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMentions$handleConnectionOpen$5 extends o implements Function1<ModelReadState, Boolean> {
    public final /* synthetic */ StoreMentions this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreMentions$handleConnectionOpen$5(StoreMentions storeMentions) {
        super(1);
        this.this$0 = storeMentions;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(ModelReadState modelReadState) {
        return Boolean.valueOf(invoke2(modelReadState));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(ModelReadState modelReadState) {
        m.checkNotNullParameter(modelReadState, "readState");
        return !StoreMentions.access$getStoreChannels$p(this.this$0).getChannelNamesInternal$app_productionGoogleRelease().containsKey(Long.valueOf(modelReadState.getChannelId()));
    }
}
