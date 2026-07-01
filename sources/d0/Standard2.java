package d0;

import d0.z.d.Intrinsics3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: d0.j, reason: use source file name */
/* JADX INFO: compiled from: Standard.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Standard2 extends Error {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Standard2(String str) {
        super(str);
        Intrinsics3.checkNotNullParameter(str, "message");
    }

    public /* synthetic */ Standard2(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "An operation is not implemented." : str);
    }
}
