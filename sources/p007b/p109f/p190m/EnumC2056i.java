package p007b.p109f.p190m;

/* JADX INFO: renamed from: b.f.m.i */
/* JADX INFO: compiled from: MinElf.java */
/* JADX INFO: loaded from: classes3.dex */
public enum EnumC2056i {
    NOT_SO("not_so"),
    X86("x86"),
    ARM("armeabi-v7a"),
    X86_64("x86_64"),
    AARCH64("arm64-v8a"),
    OTHERS("others");

    private final String value;

    EnumC2056i(String str) {
        this.value = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }
}
