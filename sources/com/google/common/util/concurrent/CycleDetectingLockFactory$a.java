package com.google.common.util.concurrent;

import b.i.a.f.e.o.f;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class CycleDetectingLockFactory$a extends ThreadLocal<ArrayList<CycleDetectingLockFactory$c>> {
    @Override // java.lang.ThreadLocal
    public ArrayList<CycleDetectingLockFactory$c> initialValue() {
        f.A(3, "initialArraySize");
        return new ArrayList<>(3);
    }
}
