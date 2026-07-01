package b.i.a.c.x2;

/* JADX INFO: renamed from: b.i.a.c.x2.j, reason: use source file name */
/* JADX INFO: compiled from: ExtractorOutput.java */
/* JADX INFO: loaded from: classes3.dex */
public interface ExtractorOutput {
    public static final ExtractorOutput d = new a();

    /* JADX INFO: renamed from: b.i.a.c.x2.j$a */
    /* JADX INFO: compiled from: ExtractorOutput.java */
    public class a implements ExtractorOutput {
        @Override // b.i.a.c.x2.ExtractorOutput
        public void a(SeekMap seekMap) {
            throw new UnsupportedOperationException();
        }

        @Override // b.i.a.c.x2.ExtractorOutput
        public void j() {
            throw new UnsupportedOperationException();
        }

        @Override // b.i.a.c.x2.ExtractorOutput
        public TrackOutput2 p(int i, int i2) {
            throw new UnsupportedOperationException();
        }
    }

    void a(SeekMap seekMap);

    void j();

    TrackOutput2 p(int i, int i2);
}
