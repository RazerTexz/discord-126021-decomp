package d0.e0.p.d.m0.c;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.u0, reason: use source file name */
/* JADX INFO: compiled from: SourceElement.java */
/* JADX INFO: loaded from: classes3.dex */
public interface SourceElement {
    public static final SourceElement a = new a();

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.u0$a */
    /* JADX INFO: compiled from: SourceElement.java */
    public static class a implements SourceElement {
        @Override // d0.e0.p.d.m0.c.SourceElement
        public v0 getContainingFile() {
            return v0.a;
        }

        public String toString() {
            return "NO_SOURCE";
        }
    }

    v0 getContainingFile();
}
