package d0.e0.p.d.m0.b.q;

import d0.e0.p.d.m0.b.KotlinBuiltIns;
import d0.e0.p.d.m0.c.h1.PlatformDependentDeclarationFilter;
import d0.e0.p.d.m0.m.LockBasedStorageManager;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: d0.e0.p.d.m0.b.q.b, reason: use source file name */
/* JADX INFO: compiled from: JvmBuiltInsCustomizer.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class JvmBuiltInsCustomizer extends KotlinBuiltIns {
    public static final a f = new a(null);
    public static final KotlinBuiltIns g = new JvmBuiltInsCustomizer();

    /* JADX INFO: renamed from: d0.e0.p.d.m0.b.q.b$a */
    /* JADX INFO: compiled from: JvmBuiltInsCustomizer.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final KotlinBuiltIns getInstance() {
            return JvmBuiltInsCustomizer.g;
        }
    }

    public JvmBuiltInsCustomizer() {
        super(new LockBasedStorageManager("FallbackBuiltIns"));
        d(true);
    }

    @Override // d0.e0.p.d.m0.b.KotlinBuiltIns
    public /* bridge */ /* synthetic */ PlatformDependentDeclarationFilter h() {
        return PlatformDependentDeclarationFilter.a.a;
    }
}
