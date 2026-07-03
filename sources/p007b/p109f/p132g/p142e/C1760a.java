package p007b.p109f.p132g.p142e;

import android.graphics.drawable.Drawable;

/* JADX INFO: renamed from: b.f.g.e.a */
/* JADX INFO: compiled from: ArrayDrawable.java */
/* JADX INFO: loaded from: classes.dex */
public class C1760a implements InterfaceC1766d {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ int f3323j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ C1762b f3324k;

    public C1760a(C1762b c1762b, int i) {
        this.f3324k = c1762b;
        this.f3323j = i;
    }

    @Override // p007b.p109f.p132g.p142e.InterfaceC1766d
    /* JADX INFO: renamed from: g */
    public Drawable mo1090g(Drawable drawable) {
        return this.f3324k.m1095c(this.f3323j, drawable);
    }

    @Override // p007b.p109f.p132g.p142e.InterfaceC1766d
    /* JADX INFO: renamed from: l */
    public Drawable mo1091l() {
        return this.f3324k.m1093a(this.f3323j);
    }
}
