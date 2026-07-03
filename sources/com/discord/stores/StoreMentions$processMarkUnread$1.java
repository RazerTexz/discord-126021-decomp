package com.discord.stores;

import com.discord.models.domain.ModelReadState;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: StoreMentions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMentions$processMarkUnread$1 extends AbstractC12240o implements Function1<ModelReadState, Boolean> {
    public final /* synthetic */ long $channelId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreMentions$processMarkUnread$1(long j) {
        super(1);
        this.$channelId = j;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(ModelReadState modelReadState) {
        return Boolean.valueOf(invoke2(modelReadState));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(ModelReadState modelReadState) {
        C12238m.checkNotNullParameter(modelReadState, "it");
        return modelReadState.getChannelId() == this.$channelId;
    }
}
