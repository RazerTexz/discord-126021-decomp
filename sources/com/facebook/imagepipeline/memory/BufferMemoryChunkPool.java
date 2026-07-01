package com.facebook.imagepipeline.memory;

import b.f.d.d.c;
import b.f.j.l.i;
import b.f.j.l.r;
import b.f.j.l.s;
import b.f.j.l.y;
import b.f.j.l.z;

/* JADX INFO: loaded from: classes3.dex */
@c
public class BufferMemoryChunkPool extends s {
    @c
    public BufferMemoryChunkPool(b.f.d.g.c cVar, y yVar, z zVar) {
        super(cVar, yVar, zVar);
    }

    @Override // b.f.j.l.s, com.facebook.imagepipeline.memory.BasePool
    public r e(int i) {
        return new i(i);
    }

    @Override // b.f.j.l.s
    public r s(int i) {
        return new i(i);
    }
}
