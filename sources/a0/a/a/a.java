package a0.a.a;

/* JADX INFO: loaded from: classes.dex */
public /* synthetic */ class a {
    public static /* synthetic */ int a(double d) {
        long jDoubleToLongBits = Double.doubleToLongBits(d);
        return (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
    }
}
