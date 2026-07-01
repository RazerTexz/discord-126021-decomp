package b.c.a;

import android.graphics.Rect;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import b.c.a.b0.Logger2;
import b.c.a.y.Font;
import b.c.a.y.FontCharacter;
import b.c.a.y.Marker2;
import b.c.a.y.m.Layer2;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: b.c.a.d, reason: use source file name */
/* JADX INFO: compiled from: LottieComposition.java */
/* JADX INFO: loaded from: classes.dex */
public class LottieComposition {
    public Map<String, List<Layer2>> c;
    public Map<String, LottieImageAsset> d;
    public Map<String, Font> e;
    public List<Marker2> f;
    public SparseArrayCompat<FontCharacter> g;
    public LongSparseArray<Layer2> h;
    public List<Layer2> i;
    public Rect j;
    public float k;
    public float l;
    public float m;
    public boolean n;
    public final PerformanceTracker a = new PerformanceTracker();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashSet<String> f351b = new HashSet<>();
    public int o = 0;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void a(String str) {
        Logger2.b(str);
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
    public Marker2 d(String str) {
        this.f.size();
        for (int i = 0; i < this.f.size(); i++) {
            Marker2 marker2 = this.f.get(i);
            boolean z2 = true;
            if (!marker2.a.equalsIgnoreCase(str)) {
                if (marker2.a.endsWith("\r")) {
                    String str2 = marker2.a;
                    if (!str2.substring(0, str2.length() - 1).equalsIgnoreCase(str)) {
                        z2 = false;
                    }
                } else {
                    z2 = false;
                }
            }
            if (z2) {
                return marker2;
            }
        }
        return null;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Layer2 e(long j) {
        return this.h.get(j);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("LottieComposition:\n");
        Iterator<Layer2> it = this.i.iterator();
        while (it.hasNext()) {
            sb.append(it.next().a("\t"));
        }
        return sb.toString();
    }
}
