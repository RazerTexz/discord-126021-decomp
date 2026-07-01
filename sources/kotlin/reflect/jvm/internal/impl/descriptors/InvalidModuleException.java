package kotlin.reflect.jvm.internal.impl.descriptors;

import d0.z.d.m;

/* JADX INFO: compiled from: InvalidModuleException.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class InvalidModuleException extends IllegalStateException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InvalidModuleException(String str) {
        super(str);
        m.checkNotNullParameter(str, "message");
    }
}
