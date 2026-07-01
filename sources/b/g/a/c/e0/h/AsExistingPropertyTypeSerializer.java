package b.g.a.c.e0.h;

import b.g.a.a.JsonTypeInfo;
import b.g.a.c.BeanProperty;
import b.g.a.c.e0.TypeIdResolver;

/* JADX INFO: renamed from: b.g.a.c.e0.h.b, reason: use source file name */
/* JADX INFO: compiled from: AsExistingPropertyTypeSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
public class AsExistingPropertyTypeSerializer extends AsPropertyTypeSerializer {
    public AsExistingPropertyTypeSerializer(TypeIdResolver typeIdResolver, BeanProperty beanProperty, String str) {
        super(typeIdResolver, beanProperty, str);
    }

    @Override // b.g.a.c.e0.h.AsPropertyTypeSerializer, b.g.a.c.e0.h.AsArrayTypeSerializer, b.g.a.c.e0.TypeSerializer
    public JsonTypeInfo.a c() {
        return JsonTypeInfo.a.EXISTING_PROPERTY;
    }

    @Override // b.g.a.c.e0.h.AsPropertyTypeSerializer
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public AsExistingPropertyTypeSerializer a(BeanProperty beanProperty) {
        return this.f699b == beanProperty ? this : new AsExistingPropertyTypeSerializer(this.a, beanProperty, this.c);
    }
}
