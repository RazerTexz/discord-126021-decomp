package p007b.p109f.p132g.p140d.p141b;

import android.graphics.drawable.Animatable;
import p007b.p109f.p132g.p139c.C1755c;
import p007b.p109f.p132g.p140d.C1757a;

/* JADX INFO: renamed from: b.f.g.d.b.a */
/* JADX INFO: compiled from: ImageLoadingTimeControllerListener.java */
/* JADX INFO: loaded from: classes.dex */
public class C1758a extends C1755c {

    /* JADX INFO: renamed from: a */
    public long f3320a = -1;

    /* JADX INFO: renamed from: b */
    public long f3321b = -1;

    /* JADX INFO: renamed from: c */
    public InterfaceC1759b f3322c;

    public C1758a(InterfaceC1759b interfaceC1759b) {
        this.f3322c = interfaceC1759b;
    }

    @Override // p007b.p109f.p132g.p139c.C1755c, com.facebook.drawee.controller.ControllerListener
    public void onFinalImageSet(String str, Object obj, Animatable animatable) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.f3321b = jCurrentTimeMillis;
        InterfaceC1759b interfaceC1759b = this.f3322c;
        if (interfaceC1759b != null) {
            C1757a c1757a = (C1757a) interfaceC1759b;
            c1757a.f3300B = jCurrentTimeMillis - this.f3320a;
            c1757a.invalidateSelf();
        }
    }

    @Override // p007b.p109f.p132g.p139c.C1755c, com.facebook.drawee.controller.ControllerListener
    public void onSubmit(String str, Object obj) {
        this.f3320a = System.currentTimeMillis();
    }
}
