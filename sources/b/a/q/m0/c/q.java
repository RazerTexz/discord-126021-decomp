package b.a.q.m0.c;

import b.a.q.m0.Codec2;
import com.hammerandchisel.libdiscord.Discord;
import java.util.List;
import rx.Emitter;
import rx.functions.Action1;

/* JADX INFO: compiled from: MediaEngineLegacy.kt */
/* JADX INFO: loaded from: classes.dex */
public final class q<T> implements Action1<Emitter<List<? extends Codec2>>> {
    public final /* synthetic */ k j;

    public q(k kVar) {
        this.j = kVar;
    }

    @Override // rx.functions.Action1
    public void call(Emitter<List<? extends Codec2>> emitter) {
        Emitter<List<? extends Codec2>> emitter2 = emitter;
        Discord discord = this.j.f;
        if (discord != null) {
            discord.getSupportedVideoCodecs(new p(this, emitter2));
        }
    }
}
