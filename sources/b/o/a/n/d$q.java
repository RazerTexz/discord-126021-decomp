package b.o.a.n;

import androidx.annotation.NonNull;
import b.o.a.l$a;

/* JADX INFO: compiled from: Camera2Engine.java */
/* JADX INFO: loaded from: classes3.dex */
public class d$q extends b.o.a.n.o.f {
    public final /* synthetic */ l$a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f1926b;

    public d$q(d dVar, l$a l_a) {
        this.f1926b = dVar;
        this.a = l_a;
    }

    @Override // b.o.a.n.o.f
    public void b(@NonNull b.o.a.n.o.a aVar) {
        d dVar = this.f1926b;
        dVar.H = false;
        dVar.P0(this.a);
        this.f1926b.H = true;
    }
}
