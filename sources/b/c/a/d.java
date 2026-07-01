package b.c.a;

import android.graphics.Rect;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo$Scope;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: LottieComposition.java */
/* JADX INFO: loaded from: classes.dex */
public class d {
    public Map<String, List<b.c.a.y.m.e>> c;
    public Map<String, k> d;
    public Map<String, b.c.a.y.d> e;
    public List<b.c.a.y.i> f;
    public SparseArrayCompat<b.c.a.y.e> g;
    public LongSparseArray<b.c.a.y.m.e> h;
    public List<b.c.a.y.m.e> i;
    public Rect j;
    public float k;
    public float l;
    public float m;
    public boolean n;
    public final s a = new s();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashSet<String> f351b = new HashSet<>();
    public int o = 0;

    @RestrictTo({RestrictTo$Scope.LIBRARY})
    public void a(String str) {
        b.c.a.b0.c.b(str);
        this.f351b.add(str);
    }

    public float b() {
        return (long) ((c() / this.m) * 1000.0f);
    }

    public float c() {
        return this.l - this.k;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x003d  */
    @Nullable
    public b.c.a.y.i d(String str) {
        this.f.size();
        for (int i = 0; i < this.f.size(); i++) {
            b.c.a.y.i iVar = this.f.get(i);
            boolean z2 = true;
            if (!iVar.a.equalsIgnoreCase(str)) {
                if (iVar.a.endsWith("\r")) {
                    String str2 = iVar.a;
                    if (!str2.substring(0, str2.length() - 1).equalsIgnoreCase(str)) {
                        z2 = false;
                    }
                } else {
                    z2 = false;
                }
            }
            if (z2) {
                return iVar;
            }
        }
        return null;
    }

    @RestrictTo({RestrictTo$Scope.LIBRARY})
    public b.c.a.y.m.e e(long j) {
        return this.h.get(j);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("LottieComposition:\n");
        Iterator<b.c.a.y.m.e> it = this.i.iterator();
        while (it.hasNext()) {
            sb.append(it.next().a("\t"));
        }
        return sb.toString();
    }
}
