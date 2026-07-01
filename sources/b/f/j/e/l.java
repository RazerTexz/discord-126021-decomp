package b.f.j.e;

import com.facebook.common.internal.Supplier;
import java.util.Objects;

/* JADX INFO: compiled from: ImagePipelineExperiments.java */
/* JADX INFO: loaded from: classes.dex */
public class l {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l$d f575b;
    public final boolean c;
    public final Supplier<Boolean> d;
    public boolean e;
    public final boolean f;
    public final int g;

    public l(l$b l_b, l$a l_a) {
        Objects.requireNonNull(l_b);
        this.a = 2048;
        this.f575b = new l$c();
        this.c = l_b.f576b;
        this.d = l_b.c;
        this.e = true;
        this.f = true;
        this.g = 20;
    }
}
