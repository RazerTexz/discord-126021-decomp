package com.discord.utilities.voice;

import kotlin.Lazy;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: VoiceEngineServiceController.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class VoiceEngineServiceController$Companion {
    private VoiceEngineServiceController$Companion() {
    }

    public final VoiceEngineServiceController getINSTANCE() {
        Lazy lazyAccess$getINSTANCE$cp = VoiceEngineServiceController.access$getINSTANCE$cp();
        VoiceEngineServiceController$Companion voiceEngineServiceController$Companion = VoiceEngineServiceController.Companion;
        return (VoiceEngineServiceController) lazyAccess$getINSTANCE$cp.getValue();
    }

    public /* synthetic */ VoiceEngineServiceController$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
