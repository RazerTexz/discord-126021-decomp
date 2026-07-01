package com.facebook.common.references;

import android.graphics.Bitmap;
import b.c.a.a0.d;
import b.f.d.e.a;
import b.f.d.h.c;
import b.f.d.h.f;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class SharedReference<T> {
    public static final Map<Object, Integer> a = new IdentityHashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public T f2884b;
    public int c;
    public final f<T> d;

    public SharedReference(T t, f<T> fVar) {
        Objects.requireNonNull(t);
        this.f2884b = t;
        Objects.requireNonNull(fVar);
        this.d = fVar;
        this.c = 1;
        if ((CloseableReference.k == 3) && ((t instanceof Bitmap) || (t instanceof c))) {
            return;
        }
        Map<Object, Integer> map = a;
        synchronized (map) {
            Integer num = map.get(t);
            if (num == null) {
                map.put(t, 1);
            } else {
                map.put(t, Integer.valueOf(num.intValue() + 1));
            }
        }
    }

    public void a() {
        int i;
        T t;
        synchronized (this) {
            b();
            d.i(Boolean.valueOf(this.c > 0));
            i = this.c - 1;
            this.c = i;
        }
        if (i == 0) {
            synchronized (this) {
                t = this.f2884b;
                this.f2884b = null;
            }
            if (t != null) {
                this.d.release(t);
                Map<Object, Integer> map = a;
                synchronized (map) {
                    Integer num = map.get(t);
                    if (num == null) {
                        a.p("SharedReference", "No entry in sLiveObjects for value of type %s", t.getClass());
                    } else if (num.intValue() == 1) {
                        map.remove(t);
                    } else {
                        map.put(t, Integer.valueOf(num.intValue() - 1));
                    }
                }
            }
        }
    }

    public final void b() {
        boolean z2;
        synchronized (this) {
            z2 = this.c > 0;
        }
        if (!(z2)) {
            throw new SharedReference$NullReferenceException();
        }
    }

    public synchronized T c() {
        return this.f2884b;
    }
}
