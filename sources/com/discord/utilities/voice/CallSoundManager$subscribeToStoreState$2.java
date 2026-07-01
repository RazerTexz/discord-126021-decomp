package com.discord.utilities.voice;

import com.discord.utilities.media.AppSound;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: CallSoundManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class CallSoundManager$subscribeToStoreState$2 extends o implements Function0<Unit> {
    public final /* synthetic */ CallSoundManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CallSoundManager$subscribeToStoreState$2(CallSoundManager callSoundManager) {
        super(0);
        this.this$0 = callSoundManager;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        CallSoundManager.access$getAppSoundManager$p(this.this$0).stop(AppSound.Companion.getSOUND_CALL_CALLING());
    }
}
