package com.discord.utilities.media;

import com.discord.utilities.lifecycle.ApplicationProvider;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: AppSoundManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AppSoundManager$Provider$INSTANCE$2 extends AbstractC12240o implements Function0<AppSoundManager> {
    public static final AppSoundManager$Provider$INSTANCE$2 INSTANCE = new AppSoundManager$Provider$INSTANCE$2();

    public AppSoundManager$Provider$INSTANCE$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final AppSoundManager invoke() {
        return new AppSoundManager(ApplicationProvider.INSTANCE.get());
    }
}
