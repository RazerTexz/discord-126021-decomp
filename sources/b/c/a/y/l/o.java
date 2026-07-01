package b.c.a.y.l;

import androidx.annotation.Nullable;
import b.c.a.w.b.r;
import java.util.List;

/* JADX INFO: compiled from: ShapeStroke.java */
/* JADX INFO: loaded from: classes.dex */
public class o implements b {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final b.c.a.y.k.b f428b;
    public final List<b.c.a.y.k.b> c;
    public final b.c.a.y.k.a d;
    public final b.c.a.y.k.d e;
    public final b.c.a.y.k.b f;
    public final int g;
    public final int h;
    public final float i;
    public final boolean j;

    /* JADX WARN: Incorrect types in method signature: (Ljava/lang/String;Lb/c/a/y/k/b;Ljava/util/List<Lb/c/a/y/k/b;>;Lb/c/a/y/k/a;Lb/c/a/y/k/d;Lb/c/a/y/k/b;Ljava/lang/Object;Ljava/lang/Object;FZ)V */
    public o(String str, @Nullable b.c.a.y.k.b bVar, List list, b.c.a.y.k.a aVar, b.c.a.y.k.d dVar, b.c.a.y.k.b bVar2, int i, int i2, float f, boolean z2) {
        this.a = str;
        this.f428b = bVar;
        this.c = list;
        this.d = aVar;
        this.e = dVar;
        this.f = bVar2;
        this.g = i;
        this.h = i2;
        this.i = f;
        this.j = z2;
    }

    @Override // b.c.a.y.l.b
    public b.c.a.w.b.c a(b.c.a.j jVar, b.c.a.y.m.b bVar) {
        return new r(jVar, bVar, this);
    }
}
