package d0;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: Standard.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class j extends Error {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(String str) {
        super(str);
        d0.z.d.m.checkNotNullParameter(str, "message");
    }

    public /* synthetic */ j(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "An operation is not implemented." : str);
    }
}
