package com.facebook.common.references;

import b.f.d.d.a;
import b.f.d.h.f;
import java.io.Closeable;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class CloseableReference$a implements f<Closeable> {
    @Override // b.f.d.h.f
    public void release(Closeable closeable) {
        try {
            a.a(closeable, true);
        } catch (IOException unused) {
        }
    }
}
