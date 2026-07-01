package kotlin.reflect;

import d0.c;

/* JADX INFO: compiled from: KFunction.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface KFunction<R> extends KCallable<R>, c<R> {
    boolean isExternal();

    boolean isInfix();

    boolean isInline();

    boolean isOperator();

    boolean isSuspend();
}
