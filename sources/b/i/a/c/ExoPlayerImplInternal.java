package b.i.a.c;

import b.i.a.c.Renderer2;

/* JADX INFO: renamed from: b.i.a.c.g1, reason: use source file name */
/* JADX INFO: compiled from: ExoPlayerImplInternal.java */
/* JADX INFO: loaded from: classes3.dex */
public class ExoPlayerImplInternal implements Renderer2.a {
    public final /* synthetic */ ExoPlayerImplInternal2 a;

    public ExoPlayerImplInternal(ExoPlayerImplInternal2 exoPlayerImplInternal2) {
        this.a = exoPlayerImplInternal2;
    }

    @Override // b.i.a.c.Renderer2.a
    public void a() {
        this.a.q.f(2);
    }

    @Override // b.i.a.c.Renderer2.a
    public void b(long j) {
        if (j >= 2000) {
            this.a.Q = true;
        }
    }
}
