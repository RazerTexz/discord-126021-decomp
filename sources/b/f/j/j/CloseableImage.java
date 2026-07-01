package b.f.j.j;

import b.f.d.e.FLog;
import com.facebook.imagepipeline.image.ImageInfo;
import java.io.Closeable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: renamed from: b.f.j.j.c, reason: use source file name */
/* JADX INFO: compiled from: CloseableImage.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class CloseableImage implements Closeable, ImageInfo {
    public static final Set<String> j = new HashSet(Arrays.asList("encoded_size", "encoded_width", "encoded_height", "uri_source", "image_format", "bitmap_config", "is_rounded"));
    public Map<String, Object> k = new HashMap();

    @Override // b.f.j.j.HasImageMetadata
    public Map<String, Object> a() {
        return this.k;
    }

    public QualityInfo b() {
        return ImmutableQualityInfo.a;
    }

    public abstract int c();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public abstract void close();

    public boolean d() {
        return false;
    }

    public void e(Map<String, Object> map) {
        if (map == null) {
            return;
        }
        for (String str : j) {
            Object obj = map.get(str);
            if (obj != null) {
                this.k.put(str, obj);
            }
        }
    }

    public void finalize() throws Throwable {
        if (isClosed()) {
            return;
        }
        FLog.o("CloseableImage", "finalize: %s %x still open.", getClass().getSimpleName(), Integer.valueOf(System.identityHashCode(this)));
        try {
            close();
        } finally {
            super.finalize();
        }
    }

    public abstract boolean isClosed();
}
