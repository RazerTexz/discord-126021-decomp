package com.google.gson.internal;

import b.i.d.ExclusionStrategy;
import b.i.d.TypeAdapterFactory2;
import b.i.d.p.Since2;
import b.i.d.p.Until;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.objectweb.asm.Opcodes;

/* JADX INFO: loaded from: classes3.dex */
public final class Excluder implements TypeAdapterFactory2, Cloneable {
    public static final Excluder j = new Excluder();
    public double k = -1.0d;
    public int l = Opcodes.L2I;
    public boolean m = true;
    public List<ExclusionStrategy> n = Collections.emptyList();
    public List<ExclusionStrategy> o = Collections.emptyList();

    public final boolean b(Class<?> cls) {
        if (this.k == -1.0d || i((Since2) cls.getAnnotation(Since2.class), (Until) cls.getAnnotation(Until.class))) {
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

    @Override // b.i.d.TypeAdapterFactory2
    public <T> TypeAdapter<T> create(final Gson gson, final TypeToken<T> typeToken) {
        Class<? super T> rawType = typeToken.getRawType();
        boolean zB = b(rawType);
        final boolean z2 = zB || f(rawType, true);
        final boolean z3 = zB || f(rawType, false);
        if (z2 || z3) {
            return new TypeAdapter<T>() { // from class: com.google.gson.internal.Excluder.1
                public TypeAdapter<T> a;

                @Override // com.google.gson.TypeAdapter
                public T read(JsonReader jsonReader) throws IOException {
                    if (z3) {
                        jsonReader.U();
                        return null;
                    }
                    TypeAdapter<T> typeAdapterJ = this.a;
                    if (typeAdapterJ == null) {
                        typeAdapterJ = gson.j(Excluder.this, typeToken);
                        this.a = typeAdapterJ;
                    }
                    return typeAdapterJ.read(jsonReader);
                }

                @Override // com.google.gson.TypeAdapter
                public void write(JsonWriter jsonWriter, T t) throws IOException {
                    if (z2) {
                        jsonWriter.s();
                        return;
                    }
                    TypeAdapter<T> typeAdapterJ = this.a;
                    if (typeAdapterJ == null) {
                        typeAdapterJ = gson.j(Excluder.this, typeToken);
                        this.a = typeAdapterJ;
                    }
                    typeAdapterJ.write(jsonWriter, t);
                }
            };
        }
        return null;
    }

    public final boolean f(Class<?> cls, boolean z2) {
        Iterator<ExclusionStrategy> it = (z2 ? this.n : this.o).iterator();
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

    public final boolean i(Since2 since2, Until until) {
        if (since2 == null || since2.value() <= this.k) {
            return until == null || (until.value() > this.k ? 1 : (until.value() == this.k ? 0 : -1)) > 0;
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
