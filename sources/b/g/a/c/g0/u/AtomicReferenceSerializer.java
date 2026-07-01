package b.g.a.c.g0.u;

import b.g.a.c.BeanProperty;
import b.g.a.c.JsonSerializer;
import b.g.a.c.e0.TypeSerializer;
import b.g.a.c.h0.ReferenceType;
import b.g.a.c.i0.NameTransformer4;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: b.g.a.c.g0.u.c, reason: use source file name */
/* JADX INFO: compiled from: AtomicReferenceSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
public class AtomicReferenceSerializer extends ReferenceTypeSerializer<AtomicReference<?>> {
    private static final long serialVersionUID = 1;

    public AtomicReferenceSerializer(ReferenceType referenceType, boolean z2, TypeSerializer typeSerializer, JsonSerializer<Object> jsonSerializer) {
        super(referenceType, typeSerializer, jsonSerializer);
    }

    @Override // b.g.a.c.g0.u.ReferenceTypeSerializer
    public Object q(AtomicReference<?> atomicReference) {
        return atomicReference.get();
    }

    @Override // b.g.a.c.g0.u.ReferenceTypeSerializer
    public Object r(AtomicReference<?> atomicReference) {
        return atomicReference.get();
    }

    @Override // b.g.a.c.g0.u.ReferenceTypeSerializer
    public boolean s(AtomicReference<?> atomicReference) {
        return atomicReference.get() != null;
    }

    @Override // b.g.a.c.g0.u.ReferenceTypeSerializer
    public ReferenceTypeSerializer<AtomicReference<?>> t(Object obj, boolean z2) {
        return new AtomicReferenceSerializer(this, this._property, this._valueTypeSerializer, this._valueSerializer, this._unwrapper, obj, z2);
    }

    @Override // b.g.a.c.g0.u.ReferenceTypeSerializer
    public ReferenceTypeSerializer<AtomicReference<?>> u(BeanProperty beanProperty, TypeSerializer typeSerializer, JsonSerializer<?> jsonSerializer, NameTransformer4 nameTransformer4) {
        return new AtomicReferenceSerializer(this, beanProperty, typeSerializer, jsonSerializer, nameTransformer4, this._suppressableValue, this._suppressNulls);
    }

    public AtomicReferenceSerializer(AtomicReferenceSerializer atomicReferenceSerializer, BeanProperty beanProperty, TypeSerializer typeSerializer, JsonSerializer<?> jsonSerializer, NameTransformer4 nameTransformer4, Object obj, boolean z2) {
        super(atomicReferenceSerializer, beanProperty, typeSerializer, jsonSerializer, nameTransformer4, obj, z2);
    }
}
