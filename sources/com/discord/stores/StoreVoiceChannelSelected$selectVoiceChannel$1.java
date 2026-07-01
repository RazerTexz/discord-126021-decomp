package com.discord.stores;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: StoreVoiceChannelSelected.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreVoiceChannelSelected$selectVoiceChannel$1 extends o implements Function0<Unit> {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ PublishSubject $resultSubject;
    public final /* synthetic */ StoreVoiceChannelSelected this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreVoiceChannelSelected$selectVoiceChannel$1(StoreVoiceChannelSelected storeVoiceChannelSelected, long j, PublishSubject publishSubject) {
        super(0);
        this.this$0 = storeVoiceChannelSelected;
        this.$channelId = j;
        this.$resultSubject = publishSubject;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.$resultSubject.k.onNext((T) StoreVoiceChannelSelected.access$selectVoiceChannelInternal(this.this$0, this.$channelId, false));
        this.$resultSubject.k.onCompleted();
    }
}
