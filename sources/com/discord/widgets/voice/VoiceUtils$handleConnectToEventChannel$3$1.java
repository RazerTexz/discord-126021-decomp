package com.discord.widgets.voice;

import android.content.Context;
import com.discord.stores.StoreStream;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.stage.StageChannelAPI;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: VoiceUtils.kt */
/* JADX INFO: loaded from: classes.dex */
public final class VoiceUtils$handleConnectToEventChannel$3$1 extends o implements Function0<Unit> {
    public final /* synthetic */ VoiceUtils$handleConnectToEventChannel$3 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VoiceUtils$handleConnectToEventChannel$3$1(VoiceUtils$handleConnectToEventChannel$3 voiceUtils$handleConnectToEventChannel$3) {
        super(0);
        this.this$0 = voiceUtils$handleConnectToEventChannel$3;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(StageChannelAPI.setUserSuppressedInChannel$default(StageChannelAPI.INSTANCE, this.this$0.$channel, StoreStream.Companion.getUsers().getMeSnapshot().getId(), false, 0L, 8, null), false, 1, null), VoiceUtils.INSTANCE.getClass(), (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, VoiceUtils$handleConnectToEventChannel$3$1$1.INSTANCE, 62, (Object) null);
        this.this$0.$onEventStarted.invoke();
    }
}
