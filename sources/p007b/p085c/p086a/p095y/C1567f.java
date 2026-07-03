package p007b.p085c.p086a.p095y;

import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: b.c.a.y.f */
/* JADX INFO: compiled from: KeyPath.java */
/* JADX INFO: loaded from: classes.dex */
public class C1567f {

    /* JADX INFO: renamed from: a */
    public static final C1567f f2712a = new C1567f("COMPOSITION");

    /* JADX INFO: renamed from: b */
    public final List<String> f2713b;

    /* JADX INFO: renamed from: c */
    @Nullable
    public InterfaceC1568g f2714c;

    public C1567f(String... strArr) {
        this.f2713b = Arrays.asList(strArr);
    }

    @CheckResult
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* JADX INFO: renamed from: a */
    public C1567f m766a(String str) {
        C1567f c1567f = new C1567f(this);
        c1567f.f2713b.add(str);
        return c1567f;
    }

    /* JADX INFO: renamed from: b */
    public final boolean m767b() {
        List<String> list = this.f2713b;
        return list.get(list.size() - 1).equals("**");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* JADX INFO: renamed from: c */
    public boolean m768c(String str, int i) {
        if (i >= this.f2713b.size()) {
            return false;
        }
        boolean z2 = i == this.f2713b.size() - 1;
        String str2 = this.f2713b.get(i);
        if (!str2.equals("**")) {
            return (z2 || (i == this.f2713b.size() + (-2) && m767b())) && (str2.equals(str) || str2.equals("*"));
        }
        if (!z2 && this.f2713b.get(i + 1).equals(str)) {
            return i == this.f2713b.size() + (-2) || (i == this.f2713b.size() + (-3) && m767b());
        }
        if (z2) {
            return true;
        }
        int i2 = i + 1;
        if (i2 < this.f2713b.size() - 1) {
            return false;
        }
        return this.f2713b.get(i2).equals(str);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* JADX INFO: renamed from: d */
    public int m769d(String str, int i) {
        if ("__container".equals(str)) {
            return 0;
        }
        if (this.f2713b.get(i).equals("**")) {
            return (i != this.f2713b.size() - 1 && this.f2713b.get(i + 1).equals(str)) ? 2 : 0;
        }
        return 1;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* JADX INFO: renamed from: e */
    public boolean m770e(String str, int i) {
        if ("__container".equals(str)) {
            return true;
        }
        if (i >= this.f2713b.size()) {
            return false;
        }
        return this.f2713b.get(i).equals(str) || this.f2713b.get(i).equals("**") || this.f2713b.get(i).equals("*");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* JADX INFO: renamed from: f */
    public boolean m771f(String str, int i) {
        return "__container".equals(str) || i < this.f2713b.size() - 1 || this.f2713b.get(i).equals("**");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* JADX INFO: renamed from: g */
    public C1567f m772g(InterfaceC1568g interfaceC1568g) {
        C1567f c1567f = new C1567f(this);
        c1567f.f2714c = interfaceC1568g;
        return c1567f;
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("KeyPath{keys=");
        sbM833U.append(this.f2713b);
        sbM833U.append(",resolved=");
        sbM833U.append(this.f2714c != null);
        sbM833U.append('}');
        return sbM833U.toString();
    }

    public C1567f(C1567f c1567f) {
        this.f2713b = new ArrayList(c1567f.f2713b);
        this.f2714c = c1567f.f2714c;
    }
}
