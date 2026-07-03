package p007b.p225i.p226a.p288f.p330i.p332b;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.C1460d;

/* JADX INFO: renamed from: b.i.a.f.i.b.a4 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3973a4 {

    /* JADX INFO: renamed from: A */
    public long f10509A;

    /* JADX INFO: renamed from: B */
    public long f10510B;

    /* JADX INFO: renamed from: C */
    public long f10511C;

    /* JADX INFO: renamed from: D */
    public String f10512D;

    /* JADX INFO: renamed from: E */
    public boolean f10513E;

    /* JADX INFO: renamed from: F */
    public long f10514F;

    /* JADX INFO: renamed from: G */
    public long f10515G;

    /* JADX INFO: renamed from: a */
    public final C4202u4 f10516a;

    /* JADX INFO: renamed from: b */
    public final String f10517b;

    /* JADX INFO: renamed from: c */
    public String f10518c;

    /* JADX INFO: renamed from: d */
    public String f10519d;

    /* JADX INFO: renamed from: e */
    public String f10520e;

    /* JADX INFO: renamed from: f */
    public String f10521f;

    /* JADX INFO: renamed from: g */
    public long f10522g;

    /* JADX INFO: renamed from: h */
    public long f10523h;

    /* JADX INFO: renamed from: i */
    public long f10524i;

    /* JADX INFO: renamed from: j */
    public String f10525j;

    /* JADX INFO: renamed from: k */
    public long f10526k;

    /* JADX INFO: renamed from: l */
    public String f10527l;

    /* JADX INFO: renamed from: m */
    public long f10528m;

    /* JADX INFO: renamed from: n */
    public long f10529n;

    /* JADX INFO: renamed from: o */
    public boolean f10530o;

    /* JADX INFO: renamed from: p */
    public long f10531p;

    /* JADX INFO: renamed from: q */
    public boolean f10532q;

    /* JADX INFO: renamed from: r */
    public boolean f10533r;

    /* JADX INFO: renamed from: s */
    public String f10534s;

    /* JADX INFO: renamed from: t */
    public Boolean f10535t;

    /* JADX INFO: renamed from: u */
    public long f10536u;

    /* JADX INFO: renamed from: v */
    public List<String> f10537v;

    /* JADX INFO: renamed from: w */
    public String f10538w;

    /* JADX INFO: renamed from: x */
    public long f10539x;

    /* JADX INFO: renamed from: y */
    public long f10540y;

    /* JADX INFO: renamed from: z */
    public long f10541z;

    @WorkerThread
    public C3973a4(C4202u4 c4202u4, String str) {
        Objects.requireNonNull(c4202u4, "null reference");
        C1460d.m583w(str);
        this.f10516a = c4202u4;
        this.f10517b = str;
        c4202u4.mo5725f().mo5848b();
    }

    @WorkerThread
    /* JADX INFO: renamed from: A */
    public final void m5447A(String str) {
        this.f10516a.mo5725f().mo5848b();
        this.f10513E |= !C4196t9.m5884q0(this.f10521f, str);
        this.f10521f = str;
    }

    @WorkerThread
    /* JADX INFO: renamed from: B */
    public final String m5448B() {
        this.f10516a.mo5725f().mo5848b();
        return this.f10538w;
    }

    @WorkerThread
    /* JADX INFO: renamed from: C */
    public final void m5449C(long j) {
        C1460d.m539l(j >= 0);
        this.f10516a.mo5725f().mo5848b();
        this.f10513E = (this.f10522g != j) | this.f10513E;
        this.f10522g = j;
    }

    @WorkerThread
    /* JADX INFO: renamed from: D */
    public final void m5450D(String str) {
        this.f10516a.mo5725f().mo5848b();
        this.f10513E |= !C4196t9.m5884q0(this.f10525j, str);
        this.f10525j = str;
    }

    @WorkerThread
    /* JADX INFO: renamed from: E */
    public final String m5451E() {
        this.f10516a.mo5725f().mo5848b();
        return this.f10520e;
    }

    @WorkerThread
    /* JADX INFO: renamed from: F */
    public final void m5452F(long j) {
        this.f10516a.mo5725f().mo5848b();
        this.f10513E |= this.f10514F != j;
        this.f10514F = j;
    }

    @WorkerThread
    /* JADX INFO: renamed from: G */
    public final void m5453G(String str) {
        this.f10516a.mo5725f().mo5848b();
        this.f10513E |= !C4196t9.m5884q0(this.f10527l, str);
        this.f10527l = str;
    }

    @WorkerThread
    /* JADX INFO: renamed from: H */
    public final String m5454H() {
        this.f10516a.mo5725f().mo5848b();
        return this.f10521f;
    }

    @WorkerThread
    /* JADX INFO: renamed from: I */
    public final void m5455I(long j) {
        this.f10516a.mo5725f().mo5848b();
        this.f10513E |= this.f10515G != j;
        this.f10515G = j;
    }

    @WorkerThread
    /* JADX INFO: renamed from: J */
    public final void m5456J(String str) {
        this.f10516a.mo5725f().mo5848b();
        this.f10513E |= !C4196t9.m5884q0(this.f10512D, str);
        this.f10512D = str;
    }

    @WorkerThread
    /* JADX INFO: renamed from: K */
    public final long m5457K() {
        this.f10516a.mo5725f().mo5848b();
        return this.f10523h;
    }

    @WorkerThread
    /* JADX INFO: renamed from: L */
    public final long m5458L() {
        this.f10516a.mo5725f().mo5848b();
        return this.f10524i;
    }

    @WorkerThread
    /* JADX INFO: renamed from: M */
    public final String m5459M() {
        this.f10516a.mo5725f().mo5848b();
        return this.f10525j;
    }

    @WorkerThread
    /* JADX INFO: renamed from: N */
    public final long m5460N() {
        this.f10516a.mo5725f().mo5848b();
        return this.f10526k;
    }

    @WorkerThread
    /* JADX INFO: renamed from: O */
    public final String m5461O() {
        this.f10516a.mo5725f().mo5848b();
        return this.f10527l;
    }

    @WorkerThread
    /* JADX INFO: renamed from: P */
    public final long m5462P() {
        this.f10516a.mo5725f().mo5848b();
        return this.f10528m;
    }

    @WorkerThread
    /* JADX INFO: renamed from: Q */
    public final long m5463Q() {
        this.f10516a.mo5725f().mo5848b();
        return this.f10529n;
    }

    @WorkerThread
    /* JADX INFO: renamed from: R */
    public final void m5464R(long j) {
        this.f10516a.mo5725f().mo5848b();
        this.f10513E |= this.f10531p != j;
        this.f10531p = j;
    }

    @WorkerThread
    /* JADX INFO: renamed from: S */
    public final long m5465S() {
        this.f10516a.mo5725f().mo5848b();
        return this.f10536u;
    }

    @WorkerThread
    /* JADX INFO: renamed from: T */
    public final boolean m5466T() {
        this.f10516a.mo5725f().mo5848b();
        return this.f10530o;
    }

    @WorkerThread
    /* JADX INFO: renamed from: U */
    public final long m5467U() {
        this.f10516a.mo5725f().mo5848b();
        return this.f10522g;
    }

    @WorkerThread
    /* JADX INFO: renamed from: V */
    public final long m5468V() {
        this.f10516a.mo5725f().mo5848b();
        return this.f10514F;
    }

    @WorkerThread
    /* JADX INFO: renamed from: W */
    public final long m5469W() {
        this.f10516a.mo5725f().mo5848b();
        return this.f10515G;
    }

    @WorkerThread
    /* JADX INFO: renamed from: X */
    public final void m5470X() {
        this.f10516a.mo5725f().mo5848b();
        long j = this.f10522g + 1;
        if (j > 2147483647L) {
            this.f10516a.mo5726g().f11144i.m5861b("Bundle index overflow. appId", C4157q3.m5788s(this.f10517b));
            j = 0;
        }
        this.f10513E = true;
        this.f10522g = j;
    }

    @WorkerThread
    /* JADX INFO: renamed from: a */
    public final void m5471a(long j) {
        this.f10516a.mo5725f().mo5848b();
        this.f10513E |= this.f10523h != j;
        this.f10523h = j;
    }

    @WorkerThread
    /* JADX INFO: renamed from: b */
    public final void m5472b(Boolean bool) {
        boolean zEquals;
        this.f10516a.mo5725f().mo5848b();
        boolean z2 = this.f10513E;
        Boolean bool2 = this.f10535t;
        if (bool2 == null && bool == null) {
            zEquals = true;
        } else {
            zEquals = bool2 == null ? false : bool2.equals(bool);
        }
        this.f10513E = z2 | (!zEquals);
        this.f10535t = bool;
    }

    @WorkerThread
    /* JADX INFO: renamed from: c */
    public final void m5473c(String str) {
        this.f10516a.mo5725f().mo5848b();
        this.f10513E |= !C4196t9.m5884q0(this.f10518c, str);
        this.f10518c = str;
    }

    @WorkerThread
    /* JADX INFO: renamed from: d */
    public final void m5474d(@Nullable List<String> list) {
        boolean zEquals;
        this.f10516a.mo5725f().mo5848b();
        List<String> list2 = this.f10537v;
        if (list2 == null && list == null) {
            zEquals = true;
        } else {
            zEquals = list2 == null ? false : list2.equals(list);
        }
        if (zEquals) {
            return;
        }
        this.f10513E = true;
        this.f10537v = list != null ? new ArrayList(list) : null;
    }

    @WorkerThread
    /* JADX INFO: renamed from: e */
    public final void m5475e(boolean z2) {
        this.f10516a.mo5725f().mo5848b();
        this.f10513E |= this.f10530o != z2;
        this.f10530o = z2;
    }

    @WorkerThread
    /* JADX INFO: renamed from: f */
    public final String m5476f() {
        this.f10516a.mo5725f().mo5848b();
        String str = this.f10512D;
        m5456J(null);
        return str;
    }

    @WorkerThread
    /* JADX INFO: renamed from: g */
    public final long m5477g() {
        this.f10516a.mo5725f().mo5848b();
        return this.f10531p;
    }

    @WorkerThread
    /* JADX INFO: renamed from: h */
    public final boolean m5478h() {
        this.f10516a.mo5725f().mo5848b();
        return this.f10532q;
    }

    @WorkerThread
    /* JADX INFO: renamed from: i */
    public final boolean m5479i() {
        this.f10516a.mo5725f().mo5848b();
        return this.f10533r;
    }

    @WorkerThread
    /* JADX INFO: renamed from: j */
    public final Boolean m5480j() {
        this.f10516a.mo5725f().mo5848b();
        return this.f10535t;
    }

    @Nullable
    @WorkerThread
    /* JADX INFO: renamed from: k */
    public final List<String> m5481k() {
        this.f10516a.mo5725f().mo5848b();
        return this.f10537v;
    }

    @WorkerThread
    /* JADX INFO: renamed from: l */
    public final void m5482l(long j) {
        this.f10516a.mo5725f().mo5848b();
        this.f10513E |= this.f10524i != j;
        this.f10524i = j;
    }

    @WorkerThread
    /* JADX INFO: renamed from: m */
    public final void m5483m(String str) {
        this.f10516a.mo5725f().mo5848b();
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        this.f10513E |= !C4196t9.m5884q0(this.f10519d, str);
        this.f10519d = str;
    }

    @WorkerThread
    /* JADX INFO: renamed from: n */
    public final void m5484n(boolean z2) {
        this.f10516a.mo5725f().mo5848b();
        this.f10513E |= this.f10532q != z2;
        this.f10532q = z2;
    }

    @WorkerThread
    /* JADX INFO: renamed from: o */
    public final String m5485o() {
        this.f10516a.mo5725f().mo5848b();
        return this.f10517b;
    }

    @WorkerThread
    /* JADX INFO: renamed from: p */
    public final void m5486p(long j) {
        this.f10516a.mo5725f().mo5848b();
        this.f10513E |= this.f10526k != j;
        this.f10526k = j;
    }

    @WorkerThread
    /* JADX INFO: renamed from: q */
    public final void m5487q(String str) {
        this.f10516a.mo5725f().mo5848b();
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        this.f10513E |= !C4196t9.m5884q0(this.f10534s, str);
        this.f10534s = str;
    }

    @WorkerThread
    /* JADX INFO: renamed from: r */
    public final void m5488r(boolean z2) {
        this.f10516a.mo5725f().mo5848b();
        this.f10513E |= this.f10533r != z2;
        this.f10533r = z2;
    }

    @WorkerThread
    /* JADX INFO: renamed from: s */
    public final String m5489s() {
        this.f10516a.mo5725f().mo5848b();
        return this.f10518c;
    }

    @WorkerThread
    /* JADX INFO: renamed from: t */
    public final void m5490t(long j) {
        this.f10516a.mo5725f().mo5848b();
        this.f10513E |= this.f10528m != j;
        this.f10528m = j;
    }

    @WorkerThread
    /* JADX INFO: renamed from: u */
    public final void m5491u(String str) {
        this.f10516a.mo5725f().mo5848b();
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        this.f10513E |= !C4196t9.m5884q0(this.f10538w, str);
        this.f10538w = str;
    }

    @WorkerThread
    /* JADX INFO: renamed from: v */
    public final String m5492v() {
        this.f10516a.mo5725f().mo5848b();
        return this.f10519d;
    }

    @WorkerThread
    /* JADX INFO: renamed from: w */
    public final void m5493w(long j) {
        this.f10516a.mo5725f().mo5848b();
        this.f10513E |= this.f10529n != j;
        this.f10529n = j;
    }

    @WorkerThread
    /* JADX INFO: renamed from: x */
    public final void m5494x(String str) {
        this.f10516a.mo5725f().mo5848b();
        this.f10513E |= !C4196t9.m5884q0(this.f10520e, str);
        this.f10520e = str;
    }

    @WorkerThread
    /* JADX INFO: renamed from: y */
    public final String m5495y() {
        this.f10516a.mo5725f().mo5848b();
        return this.f10534s;
    }

    @WorkerThread
    /* JADX INFO: renamed from: z */
    public final void m5496z(long j) {
        this.f10516a.mo5725f().mo5848b();
        this.f10513E |= this.f10536u != j;
        this.f10536u = j;
    }
}
