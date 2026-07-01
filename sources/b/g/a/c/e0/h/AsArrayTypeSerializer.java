package b.g.a.c.e0.h;

import b.g.a.a.JsonTypeInfo;
import b.g.a.c.BeanProperty;
import b.g.a.c.e0.TypeIdResolver;

/* JADX INFO: renamed from: b.g.a.c.e0.h.a, reason: use source file name */
/* JADX INFO: compiled from: AsArrayTypeSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
public class AsArrayTypeSerializer extends TypeSerializerBase {
    public AsArrayTypeSerializer(TypeIdResolver typeIdResolver, BeanProperty beanProperty) {
        super(typeIdResolver, beanProperty);
    }

    @Override // b.g.a.c.e0.TypeSerializer
    public JsonTypeInfo.a c() {
        return JsonTypeInfo.a.WRAPPER_ARRAY;
    }

    @Override // b.g.a.c.e0.TypeSerializer
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public AsArrayTypeSerializer a(BeanProperty beanProperty) {
        return this.f699b == beanProperty ? this : new AsArrayTypeSerializer(this.a, beanProperty);
    }
}
