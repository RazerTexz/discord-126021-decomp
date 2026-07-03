package p637j0.p642l.p647e;

/* JADX INFO: renamed from: j0.l.e.h */
/* JADX INFO: compiled from: PlatformDependent.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12718h {

    /* JADX INFO: renamed from: a */
    public static final int f27281a;

    /* JADX INFO: renamed from: b */
    public static final boolean f27282b;

    static {
        int iIntValue;
        try {
            iIntValue = ((Integer) Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null)).intValue();
        } catch (Exception unused) {
            iIntValue = 0;
        }
        f27281a = iIntValue;
        f27282b = iIntValue != 0;
    }
}
