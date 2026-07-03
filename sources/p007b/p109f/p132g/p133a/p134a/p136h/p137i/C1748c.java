package p007b.p109f.p132g.p133a.p134a.p136h.p137i;

import com.facebook.imagepipeline.request.ImageRequest;
import p007b.p109f.p115d.p126k.InterfaceC1714b;
import p007b.p109f.p132g.p133a.p134a.p136h.C1745h;
import p007b.p109f.p161j.p176k.C1924a;

/* JADX INFO: renamed from: b.f.g.a.a.h.i.c */
/* JADX INFO: compiled from: ImagePerfRequestListener.java */
/* JADX INFO: loaded from: classes.dex */
public class C1748c extends C1924a {

    /* JADX INFO: renamed from: a */
    public final InterfaceC1714b f3251a;

    /* JADX INFO: renamed from: b */
    public final C1745h f3252b;

    public C1748c(InterfaceC1714b interfaceC1714b, C1745h c1745h) {
        this.f3251a = interfaceC1714b;
        this.f3252b = c1745h;
    }

    @Override // p007b.p109f.p161j.p176k.C1924a, p007b.p109f.p161j.p176k.InterfaceC1928e
    /* JADX INFO: renamed from: a */
    public void mo1079a(ImageRequest imageRequest, Object obj, String str, boolean z2) {
        this.f3252b.f3229n = this.f3251a.now();
        C1745h c1745h = this.f3252b;
        c1745h.f3218c = imageRequest;
        c1745h.f3219d = obj;
        c1745h.f3217b = str;
        c1745h.f3233r = z2;
    }

    @Override // p007b.p109f.p161j.p176k.C1924a, p007b.p109f.p161j.p176k.InterfaceC1928e
    /* JADX INFO: renamed from: c */
    public void mo1080c(ImageRequest imageRequest, String str, boolean z2) {
        this.f3252b.f3230o = this.f3251a.now();
        C1745h c1745h = this.f3252b;
        c1745h.f3218c = imageRequest;
        c1745h.f3217b = str;
        c1745h.f3233r = z2;
    }

    @Override // p007b.p109f.p161j.p176k.C1924a, p007b.p109f.p161j.p176k.InterfaceC1928e
    /* JADX INFO: renamed from: g */
    public void mo1081g(ImageRequest imageRequest, String str, Throwable th, boolean z2) {
        this.f3252b.f3230o = this.f3251a.now();
        C1745h c1745h = this.f3252b;
        c1745h.f3218c = imageRequest;
        c1745h.f3217b = str;
        c1745h.f3233r = z2;
    }

    @Override // p007b.p109f.p161j.p176k.C1924a, p007b.p109f.p161j.p176k.InterfaceC1928e
    /* JADX INFO: renamed from: k */
    public void mo1082k(String str) {
        this.f3252b.f3230o = this.f3251a.now();
        this.f3252b.f3217b = str;
    }
}
