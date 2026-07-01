package com.discord.views.steps;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import b.d.b.a.a;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StepsView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StepsView$b$a extends StepsView$b {
    public final Class<? extends Fragment> j;
    public final int k;
    public final int l;
    public final int m;
    public final Bundle n;
    public final Function1<View, Unit> o;
    public final Function1<View, Unit> p;
    public final Function1<View, Unit> q;
    public final boolean r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final boolean f2844s;
    public final boolean t;

    /* JADX WARN: Illegal instructions before constructor call */
    public StepsView$b$a(Class cls, int i, int i2, int i3, Bundle bundle, Function1 function1, Function1 function2, Function1 function3, boolean z2, boolean z3, boolean z4, int i4) {
        int i5 = (i4 & 2) != 0 ? 2131893214 : i;
        int i6 = (i4 & 4) != 0 ? 2131886994 : i2;
        int i7 = (i4 & 8) != 0 ? 2131888587 : i3;
        Bundle bundle2 = (i4 & 16) != 0 ? null : bundle;
        Function1 function4 = (i4 & 32) != 0 ? null : function1;
        int i8 = i4 & 64;
        Function1 function5 = (i4 & 128) == 0 ? function3 : null;
        boolean z5 = (i4 & 256) != 0 ? true : z2;
        boolean z6 = (i4 & 512) != 0 ? true : z3;
        boolean z7 = (i4 & 1024) == 0 ? z4 : true;
        m.checkNotNullParameter(cls, "fragment");
        super(i5, i6, i7, function4, null, function5, z5, z6, z7, null);
        this.j = cls;
        this.k = i5;
        this.l = i6;
        this.m = i7;
        this.n = bundle2;
        this.o = function4;
        this.p = null;
        this.q = function5;
        this.r = z5;
        this.f2844s = z6;
        this.t = z7;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StepsView$b$a)) {
            return false;
        }
        StepsView$b$a stepsView$b$a = (StepsView$b$a) obj;
        return m.areEqual(this.j, stepsView$b$a.j) && this.k == stepsView$b$a.k && this.l == stepsView$b$a.l && this.m == stepsView$b$a.m && m.areEqual(this.n, stepsView$b$a.n) && m.areEqual(this.o, stepsView$b$a.o) && m.areEqual(this.p, stepsView$b$a.p) && m.areEqual(this.q, stepsView$b$a.q) && this.r == stepsView$b$a.r && this.f2844s == stepsView$b$a.f2844s && this.t == stepsView$b$a.t;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v18, types: [int] */
    /* JADX WARN: Type inference failed for: r0v20, types: [int] */
    /* JADX WARN: Type inference failed for: r0v22, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14, types: [int] */
    /* JADX WARN: Type inference failed for: r2v15 */
    public int hashCode() {
        Class<? extends Fragment> cls = this.j;
        int iHashCode = (((((((cls != null ? cls.hashCode() : 0) * 31) + this.k) * 31) + this.l) * 31) + this.m) * 31;
        Bundle bundle = this.n;
        int iHashCode2 = (iHashCode + (bundle != null ? bundle.hashCode() : 0)) * 31;
        Function1<View, Unit> function1 = this.o;
        int iHashCode3 = (iHashCode2 + (function1 != null ? function1.hashCode() : 0)) * 31;
        Function1<View, Unit> function2 = this.p;
        int iHashCode4 = (iHashCode3 + (function2 != null ? function2.hashCode() : 0)) * 31;
        Function1<View, Unit> function3 = this.q;
        int iHashCode5 = (iHashCode4 + (function3 != null ? function3.hashCode() : 0)) * 31;
        boolean z2 = this.r;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        int i = (iHashCode5 + r1) * 31;
        boolean z3 = this.f2844s;
        ?? r2 = z3;
        if (z3) {
            r2 = 1;
        }
        int i2 = (i + r2) * 31;
        boolean z4 = this.t;
        return i2 + (z4 ? 1 : z4);
    }

    public String toString() {
        StringBuilder sbU = a.U("FragmentStep(fragment=");
        sbU.append(this.j);
        sbU.append(", nextText=");
        sbU.append(this.k);
        sbU.append(", cancelText=");
        sbU.append(this.l);
        sbU.append(", doneText=");
        sbU.append(this.m);
        sbU.append(", arguments=");
        sbU.append(this.n);
        sbU.append(", onNext=");
        sbU.append(this.o);
        sbU.append(", onCancel=");
        sbU.append(this.p);
        sbU.append(", onDone=");
        sbU.append(this.q);
        sbU.append(", canNext=");
        sbU.append(this.r);
        sbU.append(", canCancel=");
        sbU.append(this.f2844s);
        sbU.append(", allowScroll=");
        return a.O(sbU, this.t, ")");
    }
}
