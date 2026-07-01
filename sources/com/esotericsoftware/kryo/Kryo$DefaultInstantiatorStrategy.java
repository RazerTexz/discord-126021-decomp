package com.esotericsoftware.kryo;

import b.e.b.b;
import com.esotericsoftware.kryo.util.Util;
import h0.b.b.a;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

/* JADX INFO: loaded from: classes.dex */
public class Kryo$DefaultInstantiatorStrategy implements a {
    private a fallbackStrategy;

    public Kryo$DefaultInstantiatorStrategy() {
    }

    public a getFallbackInstantiatorStrategy() {
        return this.fallbackStrategy;
    }

    @Override // h0.b.b.a
    public h0.b.a.a newInstantiatorOf(Class cls) {
        Constructor declaredConstructor;
        if (!Util.IS_ANDROID) {
            if (!((cls.getEnclosingClass() == null || !cls.isMemberClass() || Modifier.isStatic(cls.getModifiers())) ? false : true)) {
                try {
                    return new Kryo$DefaultInstantiatorStrategy$1(this, b.a(cls), cls);
                } catch (Exception unused) {
                }
            }
        }
        try {
            try {
                declaredConstructor = cls.getConstructor(null);
            } catch (Exception unused2) {
                declaredConstructor = cls.getDeclaredConstructor(null);
                declaredConstructor.setAccessible(true);
            }
            return new Kryo$DefaultInstantiatorStrategy$2(this, declaredConstructor, cls);
        } catch (Exception unused3) {
            a aVar = this.fallbackStrategy;
            if (aVar != null) {
                return aVar.newInstantiatorOf(cls);
            }
            if (cls.isMemberClass() && !Modifier.isStatic(cls.getModifiers())) {
                StringBuilder sbU = b.d.b.a.a.U("Class cannot be created (non-static member class): ");
                sbU.append(Util.className(cls));
                throw new KryoException(sbU.toString());
            }
            StringBuilder sbU2 = b.d.b.a.a.U("Class cannot be created (missing no-arg constructor): ");
            sbU2.append(Util.className(cls));
            StringBuilder sb = new StringBuilder(sbU2.toString());
            if (cls.getSimpleName().equals("")) {
                b.d.b.a.a.s0(sb, "\n\tThis is an anonymous class, which is not serializable by default in Kryo. Possible solutions: ", "1. Remove uses of anonymous classes, including double brace initialization, from the containing ", "class. This is the safest solution, as anonymous classes don't have predictable names for serialization.", "\n\t2. Register a FieldSerializer for the containing class and call ");
                sb.append("FieldSerializer#setIgnoreSyntheticFields(false) on it. This is not safe but may be sufficient temporarily. ");
                sb.append("Use at your own risk.");
            }
            throw new KryoException(sb.toString());
        }
    }

    public void setFallbackInstantiatorStrategy(a aVar) {
        this.fallbackStrategy = aVar;
    }

    public Kryo$DefaultInstantiatorStrategy(a aVar) {
        this.fallbackStrategy = aVar;
    }
}
