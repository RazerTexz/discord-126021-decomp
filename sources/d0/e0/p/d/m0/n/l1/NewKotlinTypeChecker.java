package d0.e0.p.d.m0.n.l1;

import d0.e0.p.d.m0.k.OverridingUtil;
import d0.e0.p.d.m0.n.l1.KotlinTypeRefiner;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.l1.l, reason: use source file name */
/* JADX INFO: compiled from: NewKotlinTypeChecker.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface NewKotlinTypeChecker extends KotlinTypeChecker {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f3529b = a.a;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.n.l1.l$a */
    /* JADX INFO: compiled from: NewKotlinTypeChecker.kt */
    public static final class a {
        public static final /* synthetic */ a a = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final NewKotlinTypeChecker2 f3530b = new NewKotlinTypeChecker2(KotlinTypeRefiner.a.a);

        public final NewKotlinTypeChecker2 getDefault() {
            return f3530b;
        }
    }

    KotlinTypeRefiner getKotlinTypeRefiner();

    OverridingUtil getOverridingUtil();
}
