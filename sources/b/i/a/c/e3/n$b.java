package b.i.a.c.e3;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.util.Map;

/* JADX INFO: compiled from: DataSpec.java */
/* JADX INFO: loaded from: classes3.dex */
public final class n$b {

    @Nullable
    public Uri a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f943b;
    public int c;

    @Nullable
    public byte[] d;
    public Map<String, String> e;
    public long f;
    public long g;

    @Nullable
    public String h;
    public int i;

    @Nullable
    public Object j;

    public n$b(n nVar, n$a n_a) {
        this.a = nVar.a;
        this.f943b = nVar.f942b;
        this.c = nVar.c;
        this.d = nVar.d;
        this.e = nVar.e;
        this.f = nVar.f;
        this.g = nVar.g;
        this.h = nVar.h;
        this.i = nVar.i;
        this.j = nVar.j;
    }

    public n a() {
        if (this.a != null) {
            return new n(this.a, this.f943b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j);
        }
        throw new IllegalStateException("The uri must be set.");
    }
}
