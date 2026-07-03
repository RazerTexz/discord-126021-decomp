package com.facebook.imagepipeline.memory;

import p007b.p109f.p115d.p119d.InterfaceC1680c;
import p007b.p109f.p115d.p122g.InterfaceC1696c;
import p007b.p109f.p161j.p177l.AbstractC1947s;
import p007b.p109f.p161j.p177l.C1937i;
import p007b.p109f.p161j.p177l.C1953y;
import p007b.p109f.p161j.p177l.InterfaceC1946r;
import p007b.p109f.p161j.p177l.InterfaceC1954z;

/* JADX INFO: loaded from: classes3.dex */
@InterfaceC1680c
public class BufferMemoryChunkPool extends AbstractC1947s {
    @InterfaceC1680c
    public BufferMemoryChunkPool(InterfaceC1696c interfaceC1696c, C1953y c1953y, InterfaceC1954z interfaceC1954z) {
        super(interfaceC1696c, c1953y, interfaceC1954z);
    }

    @Override // p007b.p109f.p161j.p177l.AbstractC1947s, com.facebook.imagepipeline.memory.BasePool
    /* JADX INFO: renamed from: e */
    public InterfaceC1946r mo1382e(int i) {
        return new C1937i(i);
    }

    @Override // p007b.p109f.p161j.p177l.AbstractC1947s
    /* JADX INFO: renamed from: s */
    public InterfaceC1946r mo1382e(int i) {
        return new C1937i(i);
    }
}
