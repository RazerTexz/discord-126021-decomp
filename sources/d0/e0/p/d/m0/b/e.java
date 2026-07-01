package d0.e0.p.d.m0.b;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: DefaultBuiltIns.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e extends h {
    public static final e$a f = new e$a(null);
    public static final e g = new e(false, 1, null);

    public e(boolean z2) {
        super(new d0.e0.p.d.m0.m.f("DefaultBuiltIns"));
        if (z2) {
            d(false);
        }
    }

    public static final /* synthetic */ e access$getInstance$cp() {
        return g;
    }

    public static final e getInstance() {
        return f.getInstance();
    }

    public /* synthetic */ e(boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? true : z2);
    }
}
