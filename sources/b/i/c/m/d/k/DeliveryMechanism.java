package b.i.c.m.d.k;

/* JADX INFO: renamed from: b.i.c.m.d.k.r0, reason: use source file name */
/* JADX INFO: compiled from: DeliveryMechanism.java */
/* JADX INFO: loaded from: classes3.dex */
public enum DeliveryMechanism {
    DEVELOPER(1),
    USER_SIDELOAD(2),
    TEST_DISTRIBUTION(3),
    APP_STORE(4);


    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final int f1694id;

    DeliveryMechanism(int i) {
        this.f1694id = i;
    }

    public static DeliveryMechanism f(String str) {
        return str != null ? APP_STORE : DEVELOPER;
    }

    public int g() {
        return this.f1694id;
    }

    @Override // java.lang.Enum
    public String toString() {
        return Integer.toString(this.f1694id);
    }
}
