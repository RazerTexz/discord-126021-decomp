package kotlin.reflect.jvm.internal.impl.descriptors;

import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: InvalidModuleException.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class InvalidModuleException extends IllegalStateException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InvalidModuleException(String str) {
        super(str);
        C12238m.checkNotNullParameter(str, "message");
    }
}
