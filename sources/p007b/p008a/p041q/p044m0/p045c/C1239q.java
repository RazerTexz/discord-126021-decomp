package p007b.p008a.p041q.p044m0.p045c;

import com.hammerandchisel.libdiscord.Discord;
import java.util.List;
import p007b.p008a.p041q.p044m0.C1221a;
import p658rx.Emitter;
import p658rx.functions.Action1;

/* JADX INFO: renamed from: b.a.q.m0.c.q */
/* JADX INFO: compiled from: MediaEngineLegacy.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C1239q<T> implements Action1<Emitter<List<? extends C1221a>>> {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ C1233k f1753j;

    public C1239q(C1233k c1233k) {
        this.f1753j = c1233k;
    }

    @Override // p658rx.functions.Action1
    public void call(Emitter<List<? extends C1221a>> emitter) {
        Emitter<List<? extends C1221a>> emitter2 = emitter;
        Discord discord = this.f1753j.f1726f;
        if (discord != null) {
            discord.getSupportedVideoCodecs(new C1238p(this, emitter2));
        }
    }
}
