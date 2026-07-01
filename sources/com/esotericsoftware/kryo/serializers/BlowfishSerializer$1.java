package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.io.Output;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
public class BlowfishSerializer$1 extends Output {
    public final /* synthetic */ BlowfishSerializer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BlowfishSerializer$1(BlowfishSerializer blowfishSerializer, OutputStream outputStream, int i) {
        super(outputStream, i);
        this.this$0 = blowfishSerializer;
    }

    @Override // com.esotericsoftware.kryo.io.Output, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws KryoException {
    }
}
