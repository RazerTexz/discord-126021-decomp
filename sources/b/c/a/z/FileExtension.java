package b.c.a.z;

/* JADX INFO: renamed from: b.c.a.z.a, reason: use source file name */
/* JADX INFO: compiled from: FileExtension.java */
/* JADX INFO: loaded from: classes.dex */
public enum FileExtension {
    JSON(".json"),
    ZIP(".zip");

    public final String extension;

    FileExtension(String str) {
        this.extension = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.extension;
    }
}
