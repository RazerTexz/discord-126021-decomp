package com.facebook.imagepipeline.memory;

import android.annotation.TargetApi;
import b.f.d.d.c;
import b.f.j.l.a;
import b.f.j.l.r;
import b.f.j.l.s;
import b.f.j.l.y;
import b.f.j.l.z;

/* JADX INFO: loaded from: classes3.dex */
@c
@TargetApi(27)
public class AshmemMemoryChunkPool extends s {
    @c
    public AshmemMemoryChunkPool(b.f.d.g.c cVar, y yVar, z zVar) {
        super(cVar, yVar, zVar);
    }

    @Override // b.f.j.l.s, com.facebook.imagepipeline.memory.BasePool
    public r e(int i) {
        return new a(i);
    }

    @Override // b.f.j.l.s
    public r s(int i) {
        return new a(i);
    }
}
