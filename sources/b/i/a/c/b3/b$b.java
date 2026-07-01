package b.i.a.c.b3;

import android.graphics.Bitmap;
import android.text.Layout$Alignment;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;

/* JADX INFO: compiled from: Cue.java */
/* JADX INFO: loaded from: classes3.dex */
public final class b$b {

    @Nullable
    public CharSequence a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public Bitmap f842b;

    @Nullable
    public Layout$Alignment c;

    @Nullable
    public Layout$Alignment d;
    public float e;
    public int f;
    public int g;
    public float h;
    public int i;
    public int j;
    public float k;
    public float l;
    public float m;
    public boolean n;

    @ColorInt
    public int o;
    public int p;
    public float q;

    public b$b() {
        this.a = null;
        this.f842b = null;
        this.c = null;
        this.d = null;
        this.e = -3.4028235E38f;
        this.f = Integer.MIN_VALUE;
        this.g = Integer.MIN_VALUE;
        this.h = -3.4028235E38f;
        this.i = Integer.MIN_VALUE;
        this.j = Integer.MIN_VALUE;
        this.k = -3.4028235E38f;
        this.l = -3.4028235E38f;
        this.m = -3.4028235E38f;
        this.n = false;
        this.o = ViewCompat.MEASURED_STATE_MASK;
        this.p = Integer.MIN_VALUE;
    }

    public b a() {
        return new b(this.a, this.c, this.d, this.f842b, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, this.q, null);
    }

    public b$b(b bVar, b$a b_a) {
        this.a = bVar.l;
        this.f842b = bVar.o;
        this.c = bVar.m;
        this.d = bVar.n;
        this.e = bVar.p;
        this.f = bVar.q;
        this.g = bVar.r;
        this.h = bVar.f838s;
        this.i = bVar.t;
        this.j = bVar.f840y;
        this.k = bVar.f841z;
        this.l = bVar.u;
        this.m = bVar.v;
        this.n = bVar.w;
        this.o = bVar.f839x;
        this.p = bVar.A;
        this.q = bVar.B;
    }
}
