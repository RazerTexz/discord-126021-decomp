package com.discord.utilities.voice;

import com.discord.stores.StoreStream;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.utilities.voice.VoiceEngineServiceController$Companion$INSTANCE$2, reason: use source file name */
/* JADX INFO: compiled from: VoiceEngineServiceController.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class VoiceEngineServiceController2 extends Lambda implements Function0<VoiceEngineServiceController> {
    public static final VoiceEngineServiceController2 INSTANCE = new VoiceEngineServiceController2();

    public VoiceEngineServiceController2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final VoiceEngineServiceController invoke() {
        StoreStream.Companion companion = StoreStream.INSTANCE;
        return new VoiceEngineServiceController(companion.getAudioManagerV2(), companion.getMediaSettings(), companion.getVoiceChannelSelected(), companion.getRtcConnection());
    }
}
