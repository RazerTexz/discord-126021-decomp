package com.discord.utilities.media;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: AppSoundManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AppSoundManager$play$1 extends o implements Function0<Unit> {
    public final /* synthetic */ AppSound $sound;
    public final /* synthetic */ AppSoundManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppSoundManager$play$1(AppSoundManager appSoundManager, AppSound appSound) {
        super(0);
        this.this$0 = appSoundManager;
        this.$sound = appSound;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        if (this.$sound.getShouldLoop()) {
            return;
        }
        this.this$0.stop(this.$sound);
    }
}
