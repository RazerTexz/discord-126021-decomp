package com.esotericsoftware.kryo;

import b.e.b.b;
import com.esotericsoftware.kryo.util.Util;
import h0.b.a.a;

/* JADX INFO: loaded from: classes.dex */
public class Kryo$DefaultInstantiatorStrategy$1 implements a {
    public final /* synthetic */ Kryo$DefaultInstantiatorStrategy this$0;
    public final /* synthetic */ b val$access;
    public final /* synthetic */ Class val$type;

    public Kryo$DefaultInstantiatorStrategy$1(Kryo$DefaultInstantiatorStrategy kryo$DefaultInstantiatorStrategy, b bVar, Class cls) {
        this.this$0 = kryo$DefaultInstantiatorStrategy;
        this.val$access = bVar;
        this.val$type = cls;
    }

    @Override // h0.b.a.a
    public Object newInstance() {
        try {
            return this.val$access.c();
        } catch (Exception e) {
            StringBuilder sbU = b.d.b.a.a.U("Error constructing instance of class: ");
            sbU.append(Util.className(this.val$type));
            throw new KryoException(sbU.toString(), e);
        }
    }
}
