package b.f.a;

import java.io.File;
import java.util.Objects;

/* JADX INFO: renamed from: b.f.a.a, reason: use source file name */
/* JADX INFO: compiled from: FileBinaryResource.java */
/* JADX INFO: loaded from: classes.dex */
public class FileBinaryResource {
    public final File a;

    public FileBinaryResource(File file) {
        Objects.requireNonNull(file);
        this.a = file;
    }

    public long a() {
        return this.a.length();
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof FileBinaryResource)) {
            return false;
        }
        return this.a.equals(((FileBinaryResource) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }
}
