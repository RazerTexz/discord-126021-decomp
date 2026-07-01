package b.f.b.b;

import androidx.annotation.VisibleForTesting;
import java.io.File;
import java.util.Objects;

/* JADX INFO: compiled from: DefaultDiskStorage.java */
/* JADX INFO: loaded from: classes.dex */
@VisibleForTesting
public class a$c implements c$a {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b.f.a.a f459b;
    public long c;
    public long d;

    public a$c(String str, File file, a$a a_a) {
        Objects.requireNonNull(str);
        this.a = str;
        this.f459b = new b.f.a.a(file);
        this.c = -1L;
        this.d = -1L;
    }

    @Override // b.f.b.b.c$a
    public long a() {
        if (this.d < 0) {
            this.d = this.f459b.a.lastModified();
        }
        return this.d;
    }

    @Override // b.f.b.b.c$a
    public String getId() {
        return this.a;
    }

    @Override // b.f.b.b.c$a
    public long getSize() {
        if (this.c < 0) {
            this.c = this.f459b.a();
        }
        return this.c;
    }
}
