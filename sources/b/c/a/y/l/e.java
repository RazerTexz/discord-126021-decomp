package b.c.a.y.l;

import androidx.annotation.Nullable;
import java.util.List;

/* JADX INFO: compiled from: GradientStroke.java */
/* JADX INFO: loaded from: classes.dex */
public class e implements b {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f418b;
    public final b.c.a.y.k.c c;
    public final b.c.a.y.k.d d;
    public final b.c.a.y.k.f e;
    public final b.c.a.y.k.f f;
    public final b.c.a.y.k.b g;
    public final int h;
    public final int i;
    public final float j;
    public final List<b.c.a.y.k.b> k;

    @Nullable
    public final b.c.a.y.k.b l;
    public final boolean m;

    /* JADX WARN: Incorrect types in method signature: (Ljava/lang/String;Ljava/lang/Object;Lb/c/a/y/k/c;Lb/c/a/y/k/d;Lb/c/a/y/k/f;Lb/c/a/y/k/f;Lb/c/a/y/k/b;Ljava/lang/Object;Ljava/lang/Object;FLjava/util/List<Lb/c/a/y/k/b;>;Lb/c/a/y/k/b;Z)V */
    public e(String str, int i, b.c.a.y.k.c cVar, b.c.a.y.k.d dVar, b.c.a.y.k.f fVar, b.c.a.y.k.f fVar2, b.c.a.y.k.b bVar, int i2, int i3, float f, List list, @Nullable b.c.a.y.k.b bVar2, boolean z2) {
        this.a = str;
        this.f418b = i;
        this.c = cVar;
        this.d = dVar;
        this.e = fVar;
        this.f = fVar2;
        this.g = bVar;
        this.h = i2;
        this.i = i3;
        this.j = f;
        this.k = list;
        this.l = bVar2;
        this.m = z2;
    }

    @Override // b.c.a.y.l.b
    public b.c.a.w.b.c a(b.c.a.j jVar, b.c.a.y.m.b bVar) {
        return new b.c.a.w.b.i(jVar, bVar, this);
    }
}
