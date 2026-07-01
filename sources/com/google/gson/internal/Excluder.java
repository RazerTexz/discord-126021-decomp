package com.google.gson.internal;

import b.i.d.a;
import b.i.d.o;
import b.i.d.p.c;
import b.i.d.p.d;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.objectweb.asm.Opcodes;

/* JADX INFO: loaded from: classes3.dex */
public final class Excluder implements o, Cloneable {
    public static final Excluder j = new Excluder();
    public double k = -1.0d;
    public int l = Opcodes.L2I;
    public boolean m = true;
    public List<a> n = Collections.emptyList();
    public List<a> o = Collections.emptyList();

    public final boolean b(Class<?> cls) {
        if (this.k == -1.0d || i((c) cls.getAnnotation(c.class), (d) cls.getAnnotation(d.class))) {
            return (!this.m && h(cls)) || g(cls);
        }
        return true;
    }

    public Object clone() throws CloneNotSupportedException {
        try {
            return (Excluder) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    @Override // b.i.d.o
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        Class<? super T> rawType = typeToken.getRawType();
        boolean zB = b(rawType);
        boolean z2 = zB || f(rawType, true);
        boolean z3 = zB || f(rawType, false);
        if (z2 || z3) {
            return new Excluder$1(this, z3, z2, gson, typeToken);
        }
        return null;
    }

    public final boolean f(Class<?> cls, boolean z2) {
        Iterator<a> it = (z2 ? this.n : this.o).iterator();
        while (it.hasNext()) {
            if (it.next().b(cls)) {
                return true;
            }
        }
        return false;
    }

    public final boolean g(Class<?> cls) {
        return !Enum.class.isAssignableFrom(cls) && (cls.isAnonymousClass() || cls.isLocalClass());
    }

    public final boolean h(Class<?> cls) {
        if (cls.isMemberClass()) {
            if (!((cls.getModifiers() & 8) != 0)) {
                return true;
            }
        }
        return false;
    }

    public final boolean i(c cVar, d dVar) {
        if (cVar == null || cVar.value() <= this.k) {
            return dVar == null || (dVar.value() > this.k ? 1 : (dVar.value() == this.k ? 0 : -1)) > 0;
        }
        return false;
    }

    public Excluder j(int... iArr) {
        try {
            Excluder excluder = (Excluder) super.clone();
            excluder.l = 0;
            for (int i : iArr) {
                excluder.l = i | excluder.l;
            }
            return excluder;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }
}
