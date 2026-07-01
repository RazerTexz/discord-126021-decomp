package b.a.q.m0.c;

import com.hammerandchisel.libdiscord.Discord;
import java.util.List;
import rx.Emitter;
import rx.functions.Action1;

/* JADX INFO: compiled from: MediaEngineLegacy.kt */
/* JADX INFO: loaded from: classes.dex */
public final class q<T> implements Action1<Emitter<List<? extends b.a.q.m0.a>>> {
    public final /* synthetic */ k j;

    public q(k kVar) {
        this.j = kVar;
    }

    @Override // rx.functions.Action1
    public void call(Emitter<List<? extends b.a.q.m0.a>> emitter) {
        Emitter<List<? extends b.a.q.m0.a>> emitter2 = emitter;
        Discord discord = this.j.f;
        if (discord != null) {
            discord.getSupportedVideoCodecs(new p(this, emitter2));
        }
    }
}
