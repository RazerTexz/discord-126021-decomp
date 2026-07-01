package b.o.a.n;

import androidx.annotation.NonNull;
import com.otaliastudios.cameraview.CameraView$b;
import java.util.Iterator;

/* JADX INFO: compiled from: Camera2Engine.java */
/* JADX INFO: loaded from: classes3.dex */
public class d$l$a extends b.o.a.n.o.f {
    public final /* synthetic */ b.o.a.n.r.g a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d$l f1923b;

    public d$l$a(d$l d_l, b.o.a.n.r.g gVar) {
        this.f1923b = d_l;
        this.a = gVar;
    }

    @Override // b.o.a.n.o.f
    public void b(@NonNull b.o.a.n.o.a aVar) {
        boolean z2;
        d$l d_l = this.f1923b;
        i$g i_g = d_l.m.m;
        b.o.a.q.a aVar2 = d_l.j;
        Iterator<b.o.a.n.r.a> it = this.a.f.iterator();
        while (true) {
            z2 = true;
            if (!it.hasNext()) {
                b.o.a.n.r.g.e.a(1, "isSuccessful:", "returning true.");
                break;
            } else if (!it.next().g) {
                b.o.a.n.r.g.e.a(1, "isSuccessful:", "returning false.");
                z2 = false;
                break;
            }
        }
        ((CameraView$b) i_g).d(aVar2, z2, this.f1923b.k);
        this.f1923b.m.n.e("reset metering", 0);
        if (this.f1923b.m.a1()) {
            d dVar = this.f1923b.m;
            b.o.a.n.v.f fVar = dVar.n;
            fVar.c("reset metering", true, dVar.W, new b.o.a.n.v.i(fVar, b.o.a.n.v.e.PREVIEW, new d$l$a$a(this)));
        }
    }
}
