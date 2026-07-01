package b.a.q.m0.c;

import com.discord.rtcconnection.mediaengine.MediaEngine;
import com.hammerandchisel.libdiscord.Discord;
import d0.z.d.Intrinsics3;
import rx.Emitter;

/* JADX INFO: compiled from: MediaEngineLegacy.kt */
/* JADX INFO: loaded from: classes.dex */
public final class o implements Discord.GetAudioSubsystemCallback {
    public final /* synthetic */ Emitter a;

    public o(Emitter emitter) {
        this.a = emitter;
    }

    @Override // com.hammerandchisel.libdiscord.Discord.GetAudioSubsystemCallback
    public final void onAudioSubsystem(String str, String str2) {
        Intrinsics3.checkNotNullParameter(str, "audioSubsystem");
        Intrinsics3.checkNotNullParameter(str2, "audioLayer");
        this.a.onNext(new MediaEngine.AudioInfo(str, str2));
        this.a.onCompleted();
    }
}
