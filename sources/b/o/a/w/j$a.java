package b.o.a.w;

import android.view.TextureView;

/* JADX INFO: compiled from: TextureCameraPreview.java */
/* JADX INFO: loaded from: classes3.dex */
public class j$a implements Runnable {
    public final /* synthetic */ a$b j;
    public final /* synthetic */ j k;

    public j$a(j jVar, a$b a_b) {
        this.k = jVar;
        this.j = a_b;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        int i2;
        float fI;
        j jVar = this.k;
        if (jVar.h == 0 || jVar.g == 0 || (i = jVar.f) == 0 || (i2 = jVar.e) == 0) {
            a$b a_b = this.j;
            if (a_b != null) {
                a_b.a();
                return;
            }
            return;
        }
        b.o.a.x.a aVarF = b.o.a.x.a.f(i2, i);
        j jVar2 = this.k;
        b.o.a.x.a aVarF2 = b.o.a.x.a.f(jVar2.g, jVar2.h);
        float fI2 = 1.0f;
        if (aVarF.i() >= aVarF2.i()) {
            fI = aVarF.i() / aVarF2.i();
        } else {
            fI2 = aVarF2.i() / aVarF.i();
            fI = 1.0f;
        }
        ((TextureView) this.k.c).setScaleX(fI2);
        ((TextureView) this.k.c).setScaleY(fI);
        this.k.d = fI2 > 1.02f || fI > 1.02f;
        b.o.a.b bVar = a.a;
        bVar.a(1, "crop:", "applied scaleX=", Float.valueOf(fI2));
        bVar.a(1, "crop:", "applied scaleY=", Float.valueOf(fI));
        a$b a_b2 = this.j;
        if (a_b2 != null) {
            a_b2.a();
        }
    }
}
