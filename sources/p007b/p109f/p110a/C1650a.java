package p007b.p109f.p110a;

import java.io.File;
import java.util.Objects;

/* JADX INFO: renamed from: b.f.a.a */
/* JADX INFO: compiled from: FileBinaryResource.java */
/* JADX INFO: loaded from: classes.dex */
public class C1650a {

    /* JADX INFO: renamed from: a */
    public final File f3016a;

    public C1650a(File file) {
        Objects.requireNonNull(file);
        this.f3016a = file;
    }

    /* JADX INFO: renamed from: a */
    public long m928a() {
        return this.f3016a.length();
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof C1650a)) {
            return false;
        }
        return this.f3016a.equals(((C1650a) obj).f3016a);
    }

    public int hashCode() {
        return this.f3016a.hashCode();
    }
}
