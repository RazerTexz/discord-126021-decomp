package p007b.p109f.p161j.p175j;

/* JADX INFO: renamed from: b.f.j.j.f */
/* JADX INFO: compiled from: EncodedImageOrigin.java */
/* JADX INFO: loaded from: classes.dex */
public enum EnumC1920f {
    NOT_SET("not_set"),
    NETWORK("network"),
    DISK("disk"),
    ENCODED_MEM_CACHE("encoded_mem_cache");

    private final String mOrigin;

    EnumC1920f(String str) {
        this.mOrigin = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.mOrigin;
    }
}
