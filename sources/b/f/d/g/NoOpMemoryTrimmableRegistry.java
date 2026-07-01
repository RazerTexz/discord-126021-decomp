package b.f.d.g;

/* JADX INFO: renamed from: b.f.d.g.d, reason: use source file name */
/* JADX INFO: compiled from: NoOpMemoryTrimmableRegistry.java */
/* JADX INFO: loaded from: classes.dex */
public class NoOpMemoryTrimmableRegistry implements MemoryTrimmableRegistry {
    public static NoOpMemoryTrimmableRegistry a;

    public static synchronized NoOpMemoryTrimmableRegistry b() {
        if (a == null) {
            a = new NoOpMemoryTrimmableRegistry();
        }
        return a;
    }

    @Override // b.f.d.g.MemoryTrimmableRegistry
    public void a(MemoryTrimmable memoryTrimmable) {
    }
}
