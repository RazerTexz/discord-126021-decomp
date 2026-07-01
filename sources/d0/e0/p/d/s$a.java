package d0.e0.p.d;

import d0.e0.p.d.m0.c.m0;
import kotlin.reflect.KFunction;

/* JADX INFO: compiled from: KPropertyImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class s$a<PropertyType, ReturnType> extends f<ReturnType> implements KFunction<ReturnType> {
    @Override // d0.e0.p.d.f
    public i getContainer() {
        return getProperty().getContainer();
    }

    @Override // d0.e0.p.d.f
    public d0.e0.p.d.l0.d<?> getDefaultCaller() {
        return null;
    }

    @Override // d0.e0.p.d.f
    public abstract m0 getDescriptor();

    public abstract s<PropertyType> getProperty();

    @Override // d0.e0.p.d.f
    public boolean isBound() {
        return getProperty().isBound();
    }

    @Override // kotlin.reflect.KFunction
    public boolean isExternal() {
        return getDescriptor().isExternal();
    }

    @Override // kotlin.reflect.KFunction
    public boolean isInfix() {
        return getDescriptor().isInfix();
    }

    @Override // kotlin.reflect.KFunction
    public boolean isInline() {
        return getDescriptor().isInline();
    }

    @Override // kotlin.reflect.KFunction
    public boolean isOperator() {
        return getDescriptor().isOperator();
    }

    @Override // kotlin.reflect.KCallable, kotlin.reflect.KFunction
    public boolean isSuspend() {
        return getDescriptor().isSuspend();
    }
}
