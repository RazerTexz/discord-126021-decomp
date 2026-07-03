package p007b.p085c.p086a.p099z;

/* JADX INFO: renamed from: b.c.a.z.a */
/* JADX INFO: compiled from: FileExtension.java */
/* JADX INFO: loaded from: classes.dex */
public enum EnumC1611a {
    JSON(".json"),
    ZIP(".zip");

    public final String extension;

    EnumC1611a(String str) {
        this.extension = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.extension;
    }
}
