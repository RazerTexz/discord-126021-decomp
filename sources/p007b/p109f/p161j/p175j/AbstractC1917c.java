package p007b.p109f.p161j.p175j;

import com.facebook.imagepipeline.image.ImageInfo;
import java.io.Closeable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import p007b.p109f.p115d.p120e.C1691a;

/* JADX INFO: renamed from: b.f.j.j.c */
/* JADX INFO: compiled from: CloseableImage.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1917c implements Closeable, ImageInfo {

    /* JADX INFO: renamed from: j */
    public static final Set<String> f3884j = new HashSet(Arrays.asList("encoded_size", "encoded_width", "encoded_height", "uri_source", "image_format", "bitmap_config", "is_rounded"));

    /* JADX INFO: renamed from: k */
    public Map<String, Object> f3885k = new HashMap();

    @Override // p007b.p109f.p161j.p175j.InterfaceC1921g
    /* JADX INFO: renamed from: a */
    public Map<String, Object> mo1333a() {
        return this.f3885k;
    }

    /* JADX INFO: renamed from: b */
    public InterfaceC1923i mo1334b() {
        return C1922h.f3908a;
    }

    /* JADX INFO: renamed from: c */
    public abstract int mo1330c();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public abstract void close();

    /* JADX INFO: renamed from: d */
    public boolean mo1331d() {
        return false;
    }

    /* JADX INFO: renamed from: e */
    public void m1335e(Map<String, Object> map) {
        if (map == null) {
            return;
        }
        for (String str : f3884j) {
            Object obj = map.get(str);
            if (obj != null) {
                this.f3885k.put(str, obj);
            }
        }
    }

    public void finalize() throws Throwable {
        if (isClosed()) {
            return;
        }
        C1691a.m987o("CloseableImage", "finalize: %s %x still open.", getClass().getSimpleName(), Integer.valueOf(System.identityHashCode(this)));
        try {
            close();
        } finally {
            super.finalize();
        }
    }

    public abstract boolean isClosed();
}
