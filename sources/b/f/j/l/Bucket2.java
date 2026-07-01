package b.f.j.l;

import android.util.Log;
import androidx.annotation.VisibleForTesting;
import b.c.a.a0.AnimatableValueParser;
import b.f.d.e.FLog;
import java.util.LinkedList;
import java.util.Queue;

/* JADX INFO: renamed from: b.f.j.l.f, reason: use source file name */
/* JADX INFO: compiled from: Bucket.java */
/* JADX INFO: loaded from: classes3.dex */
@VisibleForTesting
public class Bucket2<V> {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f594b;
    public final Queue c;
    public final boolean d;
    public int e;

    public Bucket2(int i, int i2, int i3, boolean z2) {
        AnimatableValueParser.B(i > 0);
        AnimatableValueParser.B(i2 >= 0);
        AnimatableValueParser.B(i3 >= 0);
        this.a = i;
        this.f594b = i2;
        this.c = new LinkedList();
        this.e = i3;
        this.d = z2;
    }

    public void a(V v) {
        this.c.add(v);
    }

    public void b() {
        AnimatableValueParser.B(this.e > 0);
        this.e--;
    }

    public V c() {
        return (V) this.c.poll();
    }

    public void d(V v) {
        if (this.d) {
            AnimatableValueParser.B(this.e > 0);
            this.e--;
            a(v);
            return;
        }
        int i = this.e;
        if (i > 0) {
            this.e = i - 1;
            a(v);
        } else {
            Object[] objArr = {v};
            int i2 = FLog.a;
            Log.println(6, "unknown:BUCKET", FLog.g("Tried to release value %s from an empty bucket!", objArr));
        }
    }
}
