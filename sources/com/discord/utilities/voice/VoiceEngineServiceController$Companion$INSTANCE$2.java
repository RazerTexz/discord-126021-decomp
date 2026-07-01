package com.discord.utilities.voice;

import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: VoiceEngineServiceController.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class VoiceEngineServiceController$Companion$INSTANCE$2 extends o implements Function0<VoiceEngineServiceController> {
    public static final VoiceEngineServiceController$Companion$INSTANCE$2 INSTANCE = new VoiceEngineServiceController$Companion$INSTANCE$2();

    public VoiceEngineServiceController$Companion$INSTANCE$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ VoiceEngineServiceController invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final VoiceEngineServiceController invoke() {
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        return new VoiceEngineServiceController(storeStream$Companion.getAudioManagerV2(), storeStream$Companion.getMediaSettings(), storeStream$Companion.getVoiceChannelSelected(), storeStream$Companion.getRtcConnection());
    }
}
