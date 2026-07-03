package p007b.p452o.p453a.p455n.p461t;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p452o.p453a.C5103b;
import p007b.p452o.p453a.p454m.EnumC5118e;

/* JADX INFO: renamed from: b.o.a.n.t.a */
/* JADX INFO: compiled from: Angles.java */
/* JADX INFO: loaded from: classes3.dex */
public class C5170a {

    /* JADX INFO: renamed from: a */
    public static final C5103b f13995a = new C5103b(C5170a.class.getSimpleName());

    /* JADX INFO: renamed from: b */
    public EnumC5118e f13996b;

    /* JADX INFO: renamed from: c */
    @VisibleForTesting
    public int f13997c = 0;

    /* JADX INFO: renamed from: d */
    @VisibleForTesting
    public int f13998d = 0;

    /* JADX INFO: renamed from: e */
    @VisibleForTesting
    public int f13999e = 0;

    /* JADX INFO: renamed from: a */
    public final int m7356a(@NonNull EnumC5171b enumC5171b, @NonNull EnumC5171b enumC5171b2) {
        if (enumC5171b == enumC5171b2) {
            return 0;
        }
        EnumC5171b enumC5171b3 = EnumC5171b.BASE;
        if (enumC5171b2 == enumC5171b3) {
            return ((360 - m7356a(enumC5171b2, enumC5171b)) + 360) % 360;
        }
        if (enumC5171b != enumC5171b3) {
            return ((m7356a(enumC5171b3, enumC5171b2) - m7356a(enumC5171b3, enumC5171b)) + 360) % 360;
        }
        int iOrdinal = enumC5171b2.ordinal();
        if (iOrdinal == 1) {
            return ((360 - this.f13997c) + 360) % 360;
        }
        if (iOrdinal == 2) {
            return ((360 - this.f13998d) + 360) % 360;
        }
        if (iOrdinal == 3) {
            return (this.f13999e + 360) % 360;
        }
        throw new RuntimeException("Unknown reference: " + enumC5171b2);
    }

    /* JADX INFO: renamed from: b */
    public boolean m7357b(@NonNull EnumC5171b enumC5171b, @NonNull EnumC5171b enumC5171b2) {
        return m7358c(enumC5171b, enumC5171b2, 1) % 180 != 0;
    }

    /* JADX INFO: renamed from: c */
    public int m7358c(@NonNull EnumC5171b enumC5171b, @NonNull EnumC5171b enumC5171b2, @NonNull int i) {
        int iM7356a = m7356a(enumC5171b, enumC5171b2);
        return (i == 2 && this.f13996b == EnumC5118e.FRONT) ? ((360 - iM7356a) + 360) % 360 : iM7356a;
    }

    /* JADX INFO: renamed from: d */
    public final void m7359d() {
        f13995a.m7159a(1, "Angles changed:", "sensorOffset:", Integer.valueOf(this.f13997c), "displayOffset:", Integer.valueOf(this.f13998d), "deviceOrientation:", Integer.valueOf(this.f13999e));
    }

    /* JADX INFO: renamed from: e */
    public final void m7360e(int i) {
        if (i != 0 && i != 90 && i != 180 && i != 270) {
            throw new IllegalStateException(C1643a.m871q("This value is not sanitized: ", i));
        }
    }

    /* JADX INFO: renamed from: f */
    public void m7361f(@NonNull EnumC5118e enumC5118e, int i) {
        m7360e(i);
        this.f13996b = enumC5118e;
        this.f13997c = i;
        if (enumC5118e == EnumC5118e.FRONT) {
            this.f13997c = ((360 - i) + 360) % 360;
        }
        m7359d();
    }
}
