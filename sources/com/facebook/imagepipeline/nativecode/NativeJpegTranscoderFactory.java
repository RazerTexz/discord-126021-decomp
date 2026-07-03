package com.facebook.imagepipeline.nativecode;

import p007b.p109f.p115d.p119d.InterfaceC1680c;
import p007b.p109f.p160i.C1831b;
import p007b.p109f.p160i.C1832c;
import p007b.p109f.p161j.p184s.InterfaceC2032b;
import p007b.p109f.p161j.p184s.InterfaceC2033c;

/* JADX INFO: loaded from: classes3.dex */
@InterfaceC1680c
public class NativeJpegTranscoderFactory implements InterfaceC2033c {

    /* JADX INFO: renamed from: a */
    public final int f19571a;

    /* JADX INFO: renamed from: b */
    public final boolean f19572b;

    /* JADX INFO: renamed from: c */
    public final boolean f19573c;

    @InterfaceC1680c
    public NativeJpegTranscoderFactory(int i, boolean z2, boolean z3) {
        this.f19571a = i;
        this.f19572b = z2;
        this.f19573c = z3;
    }

    @Override // p007b.p109f.p161j.p184s.InterfaceC2033c
    @InterfaceC1680c
    public InterfaceC2032b createImageTranscoder(C1832c c1832c, boolean z2) {
        if (c1832c != C1831b.f3585a) {
            return null;
        }
        return new NativeJpegTranscoder(z2, this.f19571a, this.f19572b, this.f19573c);
    }
}
