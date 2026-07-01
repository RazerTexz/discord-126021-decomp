package d0.e0.p.d.m0.b;

import d0.e0.p.d.m0.m.LockBasedStorageManager;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: d0.e0.p.d.m0.b.e, reason: use source file name */
/* JADX INFO: compiled from: DefaultBuiltIns.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class DefaultBuiltIns extends KotlinBuiltIns {
    public static final a f = new a(null);
    public static final DefaultBuiltIns g = new DefaultBuiltIns(false, 1, null);

    /* JADX INFO: renamed from: d0.e0.p.d.m0.b.e$a */
    /* JADX INFO: compiled from: DefaultBuiltIns.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final DefaultBuiltIns getInstance() {
            return DefaultBuiltIns.g;
        }
    }

    public DefaultBuiltIns(boolean z2) {
        super(new LockBasedStorageManager("DefaultBuiltIns"));
        if (z2) {
            d(false);
        }
    }

    public static final DefaultBuiltIns getInstance() {
        return f.getInstance();
    }

    public /* synthetic */ DefaultBuiltIns(boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? true : z2);
    }
}
