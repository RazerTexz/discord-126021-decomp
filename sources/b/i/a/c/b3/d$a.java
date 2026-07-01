package b.i.a.c.b3;

/* JADX INFO: compiled from: ExoplayerCuesDecoder.java */
/* JADX INFO: loaded from: classes3.dex */
public class d$a extends k {
    public final /* synthetic */ d n;

    public d$a(d dVar) {
        this.n = dVar;
    }

    @Override // b.i.a.c.v2.f
    public void p() {
        d dVar = this.n;
        b.c.a.a0.d.D(dVar.c.size() < 2);
        b.c.a.a0.d.j(!dVar.c.contains(this));
        q();
        dVar.c.addFirst(this);
    }
}
