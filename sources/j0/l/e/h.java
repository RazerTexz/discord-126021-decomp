package j0.l.e;

/* JADX INFO: compiled from: PlatformDependent.java */
/* JADX INFO: loaded from: classes3.dex */
public final class h {
    public static final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final boolean f3795b;

    static {
        int iIntValue;
        try {
            iIntValue = ((Integer) Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null)).intValue();
        } catch (Exception unused) {
            iIntValue = 0;
        }
        a = iIntValue;
        f3795b = iIntValue != 0;
    }
}
