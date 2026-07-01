package b.f.g.d.b;

import android.graphics.drawable.Animatable;
import b.f.g.c.c;

/* JADX INFO: compiled from: ImageLoadingTimeControllerListener.java */
/* JADX INFO: loaded from: classes.dex */
public class a extends c {
    public long a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f505b = -1;
    public b c;

    public a(b bVar) {
        this.c = bVar;
    }

    @Override // b.f.g.c.c, com.facebook.drawee.controller.ControllerListener
    public void onFinalImageSet(String str, Object obj, Animatable animatable) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.f505b = jCurrentTimeMillis;
        b bVar = this.c;
        if (bVar != null) {
            b.f.g.d.a aVar = (b.f.g.d.a) bVar;
            aVar.B = jCurrentTimeMillis - this.a;
            aVar.invalidateSelf();
        }
    }

    @Override // b.f.g.c.c, com.facebook.drawee.controller.ControllerListener
    public void onSubmit(String str, Object obj) {
        this.a = System.currentTimeMillis();
    }
}
