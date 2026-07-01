package com.facebook.common.references;

import b.f.d.e.a;

/* JADX INFO: loaded from: classes.dex */
public class CloseableReference$b implements CloseableReference$c {
    @Override // com.facebook.common.references.CloseableReference$c
    public void a(SharedReference<Object> sharedReference, Throwable th) {
        Object objC = sharedReference.c();
        Class<CloseableReference> cls = CloseableReference.j;
        Class<CloseableReference> cls2 = CloseableReference.j;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(System.identityHashCode(this));
        objArr[1] = Integer.valueOf(System.identityHashCode(sharedReference));
        objArr[2] = objC == null ? null : objC.getClass().getName();
        a.m(cls2, "Finalized without closing: %x %x (type = %s)", objArr);
    }

    @Override // com.facebook.common.references.CloseableReference$c
    public boolean b() {
        return false;
    }
}
