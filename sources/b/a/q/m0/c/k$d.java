package b.a.q.m0.c;

import com.discord.rtcconnection.mediaengine.MediaEngine$AudioInfo;
import com.hammerandchisel.libdiscord.Discord;
import rx.Emitter;
import rx.functions.Action1;

/* JADX INFO: compiled from: MediaEngineLegacy.kt */
/* JADX INFO: loaded from: classes.dex */
public final class k$d<T> implements Action1<Emitter<MediaEngine$AudioInfo>> {
    public final /* synthetic */ k j;

    public k$d(k kVar) {
        this.j = kVar;
    }

    @Override // rx.functions.Action1
    public void call(Emitter<MediaEngine$AudioInfo> emitter) {
        Emitter<MediaEngine$AudioInfo> emitter2 = emitter;
        Discord discord = this.j.f;
        if (discord != null) {
            discord.getAudioSubsystem(new o(emitter2));
        }
    }
}
