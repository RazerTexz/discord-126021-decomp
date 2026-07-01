package com.discord.utilities.media;

import d0.g;
import kotlin.Lazy;

/* JADX INFO: compiled from: AppSoundManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AppSoundManager$Provider {
    public static final AppSoundManager$Provider INSTANCE = new AppSoundManager$Provider();

    /* JADX INFO: renamed from: INSTANCE$delegate, reason: from kotlin metadata */
    private static final Lazy INSTANCE = g.lazy(AppSoundManager$Provider$INSTANCE$2.INSTANCE);

    private AppSoundManager$Provider() {
    }

    private final AppSoundManager getINSTANCE() {
        return (AppSoundManager) INSTANCE.getValue();
    }

    public final AppSoundManager get() {
        return getINSTANCE();
    }
}
