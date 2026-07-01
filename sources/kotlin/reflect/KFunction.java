package kotlin.reflect;

import d0.Function3;

/* JADX INFO: compiled from: KFunction.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface KFunction<R> extends KCallable<R>, Function3<R> {
    boolean isExternal();

    boolean isInfix();

    boolean isInline();

    boolean isOperator();

    boolean isSuspend();
}
