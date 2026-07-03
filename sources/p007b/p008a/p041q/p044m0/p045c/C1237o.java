package p007b.p008a.p041q.p044m0.p045c;

import com.discord.rtcconnection.mediaengine.MediaEngine;
import com.hammerandchisel.libdiscord.Discord;
import p507d0.p592z.p594d.C12238m;
import p658rx.Emitter;

/* JADX INFO: renamed from: b.a.q.m0.c.o */
/* JADX INFO: compiled from: MediaEngineLegacy.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C1237o implements Discord.GetAudioSubsystemCallback {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ Emitter f1750a;

    public C1237o(Emitter emitter) {
        this.f1750a = emitter;
    }

    @Override // com.hammerandchisel.libdiscord.Discord.GetAudioSubsystemCallback
    public final void onAudioSubsystem(String str, String str2) {
        C12238m.checkNotNullParameter(str, "audioSubsystem");
        C12238m.checkNotNullParameter(str2, "audioLayer");
        this.f1750a.onNext(new MediaEngine.AudioInfo(str, str2));
        this.f1750a.onCompleted();
    }
}
