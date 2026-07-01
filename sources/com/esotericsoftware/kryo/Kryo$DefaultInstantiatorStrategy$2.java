package com.esotericsoftware.kryo;

import com.esotericsoftware.kryo.util.Util;
import h0.b.a.a;
import java.lang.reflect.Constructor;

/* JADX INFO: loaded from: classes.dex */
public class Kryo$DefaultInstantiatorStrategy$2 implements a {
    public final /* synthetic */ Kryo$DefaultInstantiatorStrategy this$0;
    public final /* synthetic */ Constructor val$constructor;
    public final /* synthetic */ Class val$type;

    public Kryo$DefaultInstantiatorStrategy$2(Kryo$DefaultInstantiatorStrategy kryo$DefaultInstantiatorStrategy, Constructor constructor, Class cls) {
        this.this$0 = kryo$DefaultInstantiatorStrategy;
        this.val$constructor = constructor;
        this.val$type = cls;
    }

    @Override // h0.b.a.a
    public Object newInstance() {
        try {
            return this.val$constructor.newInstance(new Object[0]);
        } catch (Exception e) {
            StringBuilder sbU = b.d.b.a.a.U("Error constructing instance of class: ");
            sbU.append(Util.className(this.val$type));
            throw new KryoException(sbU.toString(), e);
        }
    }
}
