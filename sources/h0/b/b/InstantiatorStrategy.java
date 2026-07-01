package h0.b.b;

import h0.b.a.ObjectInstantiator;

/* JADX INFO: renamed from: h0.b.b.a, reason: use source file name */
/* JADX INFO: compiled from: InstantiatorStrategy.java */
/* JADX INFO: loaded from: classes3.dex */
public interface InstantiatorStrategy {
    <T> ObjectInstantiator<T> newInstantiatorOf(Class<T> cls);
}
