package p001a0.p002a.p003a;

/* JADX INFO: renamed from: a0.a.a.a */
/* JADX INFO: loaded from: classes.dex */
public /* synthetic */ class C0001a {
    /* JADX INFO: renamed from: a */
    public static /* synthetic */ int m2a(double d) {
        long jDoubleToLongBits = Double.doubleToLongBits(d);
        return (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
    }
}
