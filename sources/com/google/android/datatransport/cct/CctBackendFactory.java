package com.google.android.datatransport.cct;

import androidx.annotation.Keep;
import b.i.a.b.j.q.d;
import b.i.a.b.j.q.h;
import b.i.a.b.j.q.m;

/* JADX INFO: loaded from: classes3.dex */
@Keep
public class CctBackendFactory implements d {
    @Override // b.i.a.b.j.q.d
    public m create(h hVar) {
        return new b.i.a.b.i.d(hVar.a(), hVar.d(), hVar.c());
    }
}
