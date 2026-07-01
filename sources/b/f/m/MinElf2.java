package b.f.m;

/* JADX INFO: renamed from: b.f.m.i, reason: use source file name */
/* JADX INFO: compiled from: MinElf.java */
/* JADX INFO: loaded from: classes3.dex */
public enum MinElf2 {
    NOT_SO("not_so"),
    X86("x86"),
    ARM("armeabi-v7a"),
    X86_64("x86_64"),
    AARCH64("arm64-v8a"),
    OTHERS("others");

    private final String value;

    MinElf2(String str) {
        this.value = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }
}
