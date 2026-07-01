package b.i.a.c.b3;

/* JADX INFO: compiled from: SimpleSubtitleDecoder.java */
/* JADX INFO: loaded from: classes3.dex */
public class e extends k {
    public final /* synthetic */ f n;

    public e(f fVar) {
        this.n = fVar;
    }

    @Override // b.i.a.c.v2.f
    public void p() {
        f fVar = this.n;
        synchronized (fVar.f1145b) {
            q();
            O[] oArr = fVar.f;
            int i = fVar.h;
            fVar.h = i + 1;
            oArr[i] = this;
            fVar.g();
        }
    }
}
