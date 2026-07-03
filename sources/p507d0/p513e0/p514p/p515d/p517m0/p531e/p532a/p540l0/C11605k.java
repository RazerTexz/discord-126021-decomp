package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p540l0;

import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.l0.k */
/* JADX INFO: compiled from: predefinedEnhancementInfo.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11605k {

    /* JADX INFO: renamed from: a */
    public final C11617w f23470a;

    /* JADX INFO: renamed from: b */
    public final List<C11617w> f23471b;

    /* JADX WARN: Multi-variable type inference failed */
    public C11605k() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public C11605k(C11617w c11617w, List<C11617w> list) {
        C12238m.checkNotNullParameter(list, "parametersInfo");
        this.f23470a = c11617w;
        this.f23471b = list;
    }

    public final List<C11617w> getParametersInfo() {
        return this.f23471b;
    }

    public final C11617w getReturnTypeInfo() {
        return this.f23470a;
    }

    public /* synthetic */ C11605k(C11617w c11617w, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : c11617w, (i & 2) != 0 ? C12147n.emptyList() : list);
    }
}
