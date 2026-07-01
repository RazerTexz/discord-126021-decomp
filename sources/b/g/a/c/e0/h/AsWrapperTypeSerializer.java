package b.g.a.c.e0.h;

import b.g.a.a.JsonTypeInfo;
import b.g.a.c.BeanProperty;
import b.g.a.c.e0.TypeIdResolver;
import b.g.a.c.e0.TypeSerializer;

/* JADX INFO: renamed from: b.g.a.c.e0.h.e, reason: use source file name */
/* JADX INFO: compiled from: AsWrapperTypeSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
public class AsWrapperTypeSerializer extends TypeSerializerBase {
    public AsWrapperTypeSerializer(TypeIdResolver typeIdResolver, BeanProperty beanProperty) {
        super(typeIdResolver, beanProperty);
    }

    @Override // b.g.a.c.e0.TypeSerializer
    public TypeSerializer a(BeanProperty beanProperty) {
        return this.f699b == beanProperty ? this : new AsWrapperTypeSerializer(this.a, beanProperty);
    }

    @Override // b.g.a.c.e0.TypeSerializer
    public JsonTypeInfo.a c() {
        return JsonTypeInfo.a.WRAPPER_OBJECT;
    }
}
