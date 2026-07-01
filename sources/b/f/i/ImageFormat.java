package b.f.i;

/* JADX INFO: renamed from: b.f.i.c, reason: use source file name */
/* JADX INFO: compiled from: ImageFormat.java */
/* JADX INFO: loaded from: classes.dex */
public class ImageFormat {
    public static final ImageFormat a = new ImageFormat("UNKNOWN", null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f541b;

    /* JADX INFO: renamed from: b.f.i.c$a */
    /* JADX INFO: compiled from: ImageFormat.java */
    public interface a {
        int a();

        ImageFormat b(byte[] bArr, int i);
    }

    public ImageFormat(String str, String str2) {
        this.f541b = str;
    }

    public String toString() {
        return this.f541b;
    }
}
