package b.f.j.e;

import b.f.d.d.Suppliers;
import b.f.j.e.ImagePipelineConfig2;
import com.facebook.common.internal.Supplier;
import java.util.Objects;

/* JADX INFO: renamed from: b.f.j.e.l, reason: use source file name */
/* JADX INFO: compiled from: ImagePipelineExperiments.java */
/* JADX INFO: loaded from: classes.dex */
public class ImagePipelineExperiments {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f575b;
    public final boolean c;
    public final Supplier<Boolean> d;
    public boolean e;
    public final boolean f;
    public final int g;

    /* JADX INFO: renamed from: b.f.j.e.l$b */
    /* JADX INFO: compiled from: ImagePipelineExperiments.java */
    public static class b {
        public final ImagePipelineConfig2.a a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f576b;
        public Supplier<Boolean> c = new Suppliers(Boolean.FALSE);

        public b(ImagePipelineConfig2.a aVar) {
            this.a = aVar;
        }
    }

    /* JADX INFO: renamed from: b.f.j.e.l$c */
    /* JADX INFO: compiled from: ImagePipelineExperiments.java */
    public static class c implements d {
    }

    /* JADX INFO: renamed from: b.f.j.e.l$d */
    /* JADX INFO: compiled from: ImagePipelineExperiments.java */
    public interface d {
    }

    public ImagePipelineExperiments(b bVar, a aVar) {
        Objects.requireNonNull(bVar);
        this.a = 2048;
        this.f575b = new c();
        this.c = bVar.f576b;
        this.d = bVar.c;
        this.e = true;
        this.f = true;
        this.g = 20;
    }
}
