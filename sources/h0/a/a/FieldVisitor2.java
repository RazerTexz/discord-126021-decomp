package h0.a.a;

/* JADX INFO: renamed from: h0.a.a.k, reason: use source file name */
/* JADX INFO: compiled from: FieldVisitor.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class FieldVisitor2 {
    public FieldVisitor2 a;

    public FieldVisitor2(int i) {
        if (i != 393216 && i != 327680 && i != 262144 && i != 458752) {
            throw new IllegalArgumentException();
        }
        this.a = null;
    }
}
