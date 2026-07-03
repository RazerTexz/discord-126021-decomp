package p007b.p452o.p453a.p471v;

import android.annotation.TargetApi;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Objects;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p452o.p453a.C5113l;
import p007b.p452o.p453a.p464o.InterfaceC5184b;
import p007b.p452o.p453a.p467r.C5202c;
import p007b.p452o.p453a.p467r.C5206g;
import p007b.p452o.p453a.p470u.C5214b;
import p007b.p452o.p453a.p470u.C5215c;
import p007b.p452o.p453a.p470u.InterfaceC5213a;
import p007b.p452o.p453a.p471v.AbstractC5219d;
import p007b.p452o.p453a.p472w.InterfaceC5229e;
import p007b.p452o.p453a.p472w.InterfaceC5230f;
import p007b.p452o.p453a.p473x.C5235a;
import p007b.p452o.p453a.p473x.C5236b;
import p007b.p452o.p475b.p481f.C5269b;

/* JADX INFO: renamed from: b.o.a.v.g */
/* JADX INFO: compiled from: SnapshotGlPictureRecorder.java */
/* JADX INFO: loaded from: classes3.dex */
public class C5222g extends AbstractC5224i {

    /* JADX INFO: renamed from: n */
    public InterfaceC5229e f14192n;

    /* JADX INFO: renamed from: o */
    public C5235a f14193o;

    /* JADX INFO: renamed from: p */
    public InterfaceC5213a f14194p;

    /* JADX INFO: renamed from: q */
    public boolean f14195q;

    /* JADX INFO: renamed from: r */
    public C5214b f14196r;

    /* JADX INFO: renamed from: s */
    public C5202c f14197s;

    /* JADX INFO: renamed from: b.o.a.v.g$a */
    /* JADX INFO: compiled from: SnapshotGlPictureRecorder.java */
    public class a implements InterfaceC5230f {
        public a() {
        }

        @Override // p007b.p452o.p453a.p472w.InterfaceC5230f
        /* JADX INFO: renamed from: a */
        public void mo7422a(@NonNull SurfaceTexture surfaceTexture, int i, float f, float f2) {
            C5222g.this.f14192n.mo7446d(this);
            C5222g c5222g = C5222g.this;
            Objects.requireNonNull(c5222g);
            C5206g.m7402a(new RunnableC5223h(c5222g, surfaceTexture, i, f, f2, EGL14.eglGetCurrentContext()));
        }

        @Override // p007b.p452o.p453a.p472w.InterfaceC5230f
        /* JADX INFO: renamed from: b */
        public void mo7423b(int i) {
            C5222g c5222g = C5222g.this;
            Objects.requireNonNull(c5222g);
            c5222g.f14197s = new C5202c(new C5269b(33984, 36197, Integer.valueOf(i)));
            Rect rectM4222L = C3404f.m4222L(c5222g.f14172j.f13718d, c5222g.f14193o);
            c5222g.f14172j.f13718d = new C5236b(rectM4222L.width(), rectM4222L.height());
            if (c5222g.f14195q) {
                c5222g.f14196r = new C5214b(c5222g.f14194p, c5222g.f14172j.f13718d);
            }
        }

        @Override // p007b.p452o.p453a.p472w.InterfaceC5230f
        /* JADX INFO: renamed from: c */
        public void mo7424c(@NonNull InterfaceC5184b interfaceC5184b) {
            C5222g.this.f14197s.f14108d = interfaceC5184b.mo7369a();
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    public C5222g(@NonNull C5113l.a aVar, @Nullable AbstractC5219d.a aVar2, @NonNull InterfaceC5229e interfaceC5229e, @NonNull C5235a c5235a, @Nullable InterfaceC5213a interfaceC5213a) {
        boolean z2;
        super(aVar, aVar2);
        this.f14192n = interfaceC5229e;
        this.f14193o = c5235a;
        this.f14194p = interfaceC5213a;
        if (interfaceC5213a != null) {
            if (((C5215c) interfaceC5213a).m7413b(InterfaceC5213a.a.PICTURE_SNAPSHOT)) {
                z2 = true;
            } else {
                z2 = false;
            }
        } else {
            z2 = false;
        }
        this.f14195q = z2;
    }

    @Override // p007b.p452o.p453a.p471v.AbstractC5219d
    /* JADX INFO: renamed from: b */
    public void mo7416b() {
        this.f14193o = null;
        super.mo7416b();
    }

    @Override // p007b.p452o.p453a.p471v.AbstractC5219d
    @TargetApi(19)
    /* JADX INFO: renamed from: c */
    public void mo7417c() {
        this.f14192n.mo7445b(new a());
    }
}
