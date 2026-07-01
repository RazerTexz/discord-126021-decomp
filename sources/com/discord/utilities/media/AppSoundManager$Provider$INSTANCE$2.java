package com.discord.utilities.media;

import com.discord.utilities.lifecycle.ApplicationProvider;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: AppSoundManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AppSoundManager$Provider$INSTANCE$2 extends o implements Function0<AppSoundManager> {
    public static final AppSoundManager$Provider$INSTANCE$2 INSTANCE = new AppSoundManager$Provider$INSTANCE$2();

    public AppSoundManager$Provider$INSTANCE$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ AppSoundManager invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final AppSoundManager invoke() {
        return new AppSoundManager(ApplicationProvider.INSTANCE.get());
    }
}
