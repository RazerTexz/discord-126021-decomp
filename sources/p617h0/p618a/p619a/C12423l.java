package p617h0.p618a.p619a;

import org.objectweb.asm.Opcodes;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;

/* JADX INFO: renamed from: h0.a.a.l */
/* JADX INFO: compiled from: FieldWriter.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12423l extends AbstractC12422k {

    /* JADX INFO: renamed from: b */
    public final C12433v f26217b;

    /* JADX INFO: renamed from: c */
    public final int f26218c;

    /* JADX INFO: renamed from: d */
    public final int f26219d;

    /* JADX INFO: renamed from: e */
    public final int f26220e;

    /* JADX INFO: renamed from: f */
    public int f26221f;

    /* JADX INFO: renamed from: g */
    public int f26222g;

    /* JADX INFO: renamed from: h */
    public C12412a f26223h;

    /* JADX INFO: renamed from: i */
    public C12412a f26224i;

    /* JADX INFO: renamed from: j */
    public C12412a f26225j;

    /* JADX INFO: renamed from: k */
    public C12412a f26226k;

    /* JADX INFO: renamed from: l */
    public C12413b f26227l;

    public C12423l(C12433v c12433v, int i, String str, String str2, String str3, Object obj) {
        super(Opcodes.ASM7);
        this.f26217b = c12433v;
        this.f26218c = i;
        this.f26219d = c12433v.m10637l(str);
        this.f26220e = c12433v.m10637l(str2);
        if (str3 != null) {
            this.f26221f = c12433v.m10637l(str3);
        }
        if (obj != null) {
            this.f26222g = c12433v.m10627b(obj).f26340a;
        }
    }

    /* JADX INFO: renamed from: a */
    public C12412a m10570a(String str, boolean z2) {
        C12414c c12414c = new C12414c();
        c12414c.m10538j(this.f26217b.m10637l(str));
        c12414c.m10538j(0);
        if (z2) {
            C12412a c12412a = new C12412a(this.f26217b, true, c12414c, this.f26223h);
            this.f26223h = c12412a;
            return c12412a;
        }
        C12412a c12412a2 = new C12412a(this.f26217b, true, c12414c, this.f26224i);
        this.f26224i = c12412a2;
        return c12412a2;
    }

    /* JADX INFO: renamed from: b */
    public C12412a m10571b(int i, C12435x c12435x, String str, boolean z2) {
        C12414c c12414c = new C12414c();
        C3404f.m4256W0(i, c12414c);
        C12435x.m10655a(c12435x, c12414c);
        c12414c.m10538j(this.f26217b.m10637l(str));
        c12414c.m10538j(0);
        if (z2) {
            C12412a c12412a = new C12412a(this.f26217b, true, c12414c, this.f26225j);
            this.f26225j = c12412a;
            return c12412a;
        }
        C12412a c12412a2 = new C12412a(this.f26217b, true, c12414c, this.f26226k);
        this.f26226k = c12412a2;
        return c12412a2;
    }
}
