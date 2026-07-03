package com.discord.utilities.voice;

import com.discord.stores.StoreStream;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: VoiceEngineServiceController.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class VoiceEngineServiceController$Companion$INSTANCE$2 extends AbstractC12240o implements Function0<VoiceEngineServiceController> {
    public static final VoiceEngineServiceController$Companion$INSTANCE$2 INSTANCE = new VoiceEngineServiceController$Companion$INSTANCE$2();

    public VoiceEngineServiceController$Companion$INSTANCE$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final VoiceEngineServiceController invoke() {
        StoreStream.Companion companion = StoreStream.INSTANCE;
        return new VoiceEngineServiceController(companion.getAudioManagerV2(), companion.getMediaSettings(), companion.getVoiceChannelSelected(), companion.getRtcConnection());
    }
}
