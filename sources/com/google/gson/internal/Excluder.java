package com.google.gson.internal;

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
import p007b.p225i.p408d.InterfaceC4897a;
import p007b.p225i.p408d.InterfaceC4911o;
import p007b.p225i.p408d.p409p.InterfaceC4914c;
import p007b.p225i.p408d.p409p.InterfaceC4915d;

/* JADX INFO: loaded from: classes3.dex */
public final class Excluder implements InterfaceC4911o, Cloneable {

    /* JADX INFO: renamed from: j */
    public static final Excluder f21483j = new Excluder();

    /* JADX INFO: renamed from: k */
    public double f21484k = -1.0d;

    /* JADX INFO: renamed from: l */
    public int f21485l = Opcodes.L2I;

    /* JADX INFO: renamed from: m */
    public boolean f21486m = true;

    /* JADX INFO: renamed from: n */
    public List<InterfaceC4897a> f21487n = Collections.emptyList();

    /* JADX INFO: renamed from: o */
    public List<InterfaceC4897a> f21488o = Collections.emptyList();

    /* JADX INFO: renamed from: b */
    public final boolean m9217b(Class<?> cls) {
        if (this.f21484k == -1.0d || m9221i((InterfaceC4914c) cls.getAnnotation(InterfaceC4914c.class), (InterfaceC4915d) cls.getAnnotation(InterfaceC4915d.class))) {
            return (!this.f21486m && m9220h(cls)) || m9219g(cls);
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

    @Override // p007b.p225i.p408d.InterfaceC4911o
    public <T> TypeAdapter<T> create(final Gson gson, final TypeToken<T> typeToken) {
        Class<? super T> rawType = typeToken.getRawType();
        boolean zM9217b = m9217b(rawType);
        final boolean z2 = zM9217b || m9218f(rawType, true);
        final boolean z3 = zM9217b || m9218f(rawType, false);
        if (z2 || z3) {
            return new TypeAdapter<T>() { // from class: com.google.gson.internal.Excluder.1

                /* JADX INFO: renamed from: a */
                public TypeAdapter<T> f21489a;

                @Override // com.google.gson.TypeAdapter
                public T read(JsonReader jsonReader) throws IOException {
                    if (z3) {
                        jsonReader.mo6879U();
                        return null;
                    }
                    TypeAdapter<T> typeAdapterM9206j = this.f21489a;
                    if (typeAdapterM9206j == null) {
                        typeAdapterM9206j = gson.m9206j(Excluder.this, typeToken);
                        this.f21489a = typeAdapterM9206j;
                    }
                    return typeAdapterM9206j.read(jsonReader);
                }

                @Override // com.google.gson.TypeAdapter
                public void write(JsonWriter jsonWriter, T t) throws IOException {
                    if (z2) {
                        jsonWriter.mo6905s();
                        return;
                    }
                    TypeAdapter<T> typeAdapterM9206j = this.f21489a;
                    if (typeAdapterM9206j == null) {
                        typeAdapterM9206j = gson.m9206j(Excluder.this, typeToken);
                        this.f21489a = typeAdapterM9206j;
                    }
                    typeAdapterM9206j.write(jsonWriter, t);
                }
            };
        }
        return null;
    }

    /* JADX INFO: renamed from: f */
    public final boolean m9218f(Class<?> cls, boolean z2) {
        Iterator<InterfaceC4897a> it = (z2 ? this.f21487n : this.f21488o).iterator();
        while (it.hasNext()) {
            if (it.next().m6847b(cls)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: g */
    public final boolean m9219g(Class<?> cls) {
        return !Enum.class.isAssignableFrom(cls) && (cls.isAnonymousClass() || cls.isLocalClass());
    }

    /* JADX INFO: renamed from: h */
    public final boolean m9220h(Class<?> cls) {
        if (cls.isMemberClass()) {
            if (!((cls.getModifiers() & 8) != 0)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: i */
    public final boolean m9221i(InterfaceC4914c interfaceC4914c, InterfaceC4915d interfaceC4915d) {
        if (interfaceC4914c == null || interfaceC4914c.value() <= this.f21484k) {
            return interfaceC4915d == null || (interfaceC4915d.value() > this.f21484k ? 1 : (interfaceC4915d.value() == this.f21484k ? 0 : -1)) > 0;
        }
        return false;
    }

    /* JADX INFO: renamed from: j */
    public Excluder m9222j(int... iArr) {
        try {
            Excluder excluder = (Excluder) super.clone();
            excluder.f21485l = 0;
            for (int i : iArr) {
                excluder.f21485l = i | excluder.f21485l;
            }
            return excluder;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }
}
