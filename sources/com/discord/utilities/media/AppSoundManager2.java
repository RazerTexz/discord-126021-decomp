package com.discord.utilities.media;

import com.discord.utilities.lifecycle.ApplicationProvider;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.utilities.media.AppSoundManager$Provider$INSTANCE$2, reason: use source file name */
/* JADX INFO: compiled from: AppSoundManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AppSoundManager2 extends Lambda implements Function0<AppSoundManager> {
    public static final AppSoundManager2 INSTANCE = new AppSoundManager2();

    public AppSoundManager2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final AppSoundManager invoke() {
        return new AppSoundManager(ApplicationProvider.INSTANCE.get());
    }
}
