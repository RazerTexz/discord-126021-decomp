package com.facebook.fresco.animation.factory;

import android.graphics.Bitmap$Config;
import b.f.h.a.d.d;
import b.f.j.h.b;
import b.f.j.j.c;
import b.f.j.j.e;
import b.f.j.j.i;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class AnimatedFactoryV2Impl$b implements b {
    public final /* synthetic */ AnimatedFactoryV2Impl a;

    public AnimatedFactoryV2Impl$b(AnimatedFactoryV2Impl animatedFactoryV2Impl) {
        this.a = animatedFactoryV2Impl;
    }

    @Override // b.f.j.h.b
    public c a(e eVar, int i, i iVar, b.f.j.d.b bVar) {
        AnimatedFactoryV2Impl animatedFactoryV2Impl = this.a;
        if (animatedFactoryV2Impl.e == null) {
            animatedFactoryV2Impl.e = new b.f.j.a.b.e(new d(animatedFactoryV2Impl), animatedFactoryV2Impl.a);
        }
        b.f.j.a.b.d dVar = animatedFactoryV2Impl.e;
        Bitmap$Config bitmap$Config = bVar.e;
        b.f.j.a.b.e eVar2 = (b.f.j.a.b.e) dVar;
        Objects.requireNonNull(eVar2);
        if (b.f.j.a.b.e.f547b == null) {
            throw new UnsupportedOperationException("To encode animated webp please add the dependency to the animated-webp module");
        }
        CloseableReference<PooledByteBuffer> closeableReferenceC = eVar.c();
        Objects.requireNonNull(closeableReferenceC);
        try {
            PooledByteBuffer pooledByteBufferU = closeableReferenceC.u();
            return eVar2.a(bVar, pooledByteBufferU.getByteBuffer() != null ? b.f.j.a.b.e.f547b.c(pooledByteBufferU.getByteBuffer(), bVar) : b.f.j.a.b.e.f547b.h(pooledByteBufferU.k(), pooledByteBufferU.size(), bVar), bitmap$Config);
        } finally {
            closeableReferenceC.close();
        }
    }
}
