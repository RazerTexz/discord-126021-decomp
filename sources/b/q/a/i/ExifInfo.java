package b.q.a.i;

/* JADX INFO: renamed from: b.q.a.i.b, reason: use source file name */
/* JADX INFO: compiled from: ExifInfo.java */
/* JADX INFO: loaded from: classes3.dex */
public class ExifInfo {
    public int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1979b;
    public int c;

    public ExifInfo(int i, int i2, int i3) {
        this.a = i;
        this.f1979b = i2;
        this.c = i3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ExifInfo.class != obj.getClass()) {
            return false;
        }
        ExifInfo exifInfo = (ExifInfo) obj;
        return this.a == exifInfo.a && this.f1979b == exifInfo.f1979b && this.c == exifInfo.c;
    }

    public int hashCode() {
        return (((this.a * 31) + this.f1979b) * 31) + this.c;
    }
}
