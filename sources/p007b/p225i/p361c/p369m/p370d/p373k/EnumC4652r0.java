package p007b.p225i.p361c.p369m.p370d.p373k;

/* JADX INFO: renamed from: b.i.c.m.d.k.r0 */
/* JADX INFO: compiled from: DeliveryMechanism.java */
/* JADX INFO: loaded from: classes3.dex */
public enum EnumC4652r0 {
    DEVELOPER(1),
    USER_SIDELOAD(2),
    TEST_DISTRIBUTION(3),
    APP_STORE(4);


    /* JADX INFO: renamed from: id */
    private final int f12385id;

    EnumC4652r0(int i) {
        this.f12385id = i;
    }

    /* JADX INFO: renamed from: f */
    public static EnumC4652r0 m6452f(String str) {
        return str != null ? APP_STORE : DEVELOPER;
    }

    /* JADX INFO: renamed from: g */
    public int m6453g() {
        return this.f12385id;
    }

    @Override // java.lang.Enum
    public String toString() {
        return Integer.toString(this.f12385id);
    }
}
