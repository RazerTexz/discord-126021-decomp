package p507d0;

import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.j */
/* JADX INFO: compiled from: Standard.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12111j extends Error {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C12111j(String str) {
        super(str);
        C12238m.checkNotNullParameter(str, "message");
    }

    public /* synthetic */ C12111j(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "An operation is not implemented." : str);
    }
}
