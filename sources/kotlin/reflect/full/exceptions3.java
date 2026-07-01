package kotlin.reflect.full;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: kotlin.reflect.full.NoSuchPropertyException, reason: use source file name */
/* JADX INFO: compiled from: exceptions.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class exceptions3 extends Exception {
    /* JADX WARN: Multi-variable type inference failed */
    public exceptions3() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public exceptions3(Exception exc) {
        super(exc);
    }

    public /* synthetic */ exceptions3(Exception exc, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : exc);
    }
}
