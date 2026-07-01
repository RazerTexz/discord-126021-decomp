package b.o.a.v;

import android.annotation.TargetApi;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.o.a.l$a;

/* JADX INFO: compiled from: SnapshotGlPictureRecorder.java */
/* JADX INFO: loaded from: classes3.dex */
public class g extends i {
    public b.o.a.w.e n;
    public b.o.a.x.a o;
    public b.o.a.u.a p;
    public boolean q;
    public b.o.a.u.b r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public b.o.a.r.c f1956s;

    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    public g(@NonNull l$a l_a, @Nullable d$a d_a, @NonNull b.o.a.w.e eVar, @NonNull b.o.a.x.a aVar, @Nullable b.o.a.u.a aVar2) {
        boolean z2;
        super(l_a, d_a);
        this.n = eVar;
        this.o = aVar;
        this.p = aVar2;
        if (aVar2 != null) {
            if (((b.o.a.u.c) aVar2).b(b.o.a.u.a$a.PICTURE_SNAPSHOT)) {
                z2 = true;
            } else {
                z2 = false;
            }
        } else {
            z2 = false;
        }
        this.q = z2;
    }

    @Override // b.o.a.v.d
    public void b() {
        this.o = null;
        super.b();
    }

    @Override // b.o.a.v.d
    @TargetApi(19)
    public void c() {
        this.n.b(new g$a(this));
    }
}
