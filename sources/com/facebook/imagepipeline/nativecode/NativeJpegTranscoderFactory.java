package com.facebook.imagepipeline.nativecode;

import b.f.d.d.c;
import b.f.j.s.b;

/* JADX INFO: loaded from: classes3.dex */
@c
public class NativeJpegTranscoderFactory implements b.f.j.s.c {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f2900b;
    public final boolean c;

    @c
    public NativeJpegTranscoderFactory(int i, boolean z2, boolean z3) {
        this.a = i;
        this.f2900b = z2;
        this.c = z3;
    }

    @Override // b.f.j.s.c
    @c
    public b createImageTranscoder(b.f.i.c cVar, boolean z2) {
        if (cVar != b.f.i.b.a) {
            return null;
        }
        return new NativeJpegTranscoder(z2, this.a, this.f2900b, this.c);
    }
}
