package b.g.a.c.e0.h;

import b.g.a.a.JsonTypeInfo;
import b.g.a.c.BeanProperty;
import b.g.a.c.e0.TypeIdResolver;
import b.g.a.c.e0.TypeSerializer;

/* JADX INFO: renamed from: b.g.a.c.e0.h.c, reason: use source file name */
/* JADX INFO: compiled from: AsExternalTypeSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
public class AsExternalTypeSerializer extends TypeSerializerBase {
    public final String c;

    public AsExternalTypeSerializer(TypeIdResolver typeIdResolver, BeanProperty beanProperty, String str) {
        super(typeIdResolver, beanProperty);
        this.c = str;
    }

    @Override // b.g.a.c.e0.TypeSerializer
    public TypeSerializer a(BeanProperty beanProperty) {
        return this.f699b == beanProperty ? this : new AsExternalTypeSerializer(this.a, beanProperty, this.c);
    }

    @Override // b.g.a.c.e0.h.TypeSerializerBase, b.g.a.c.e0.TypeSerializer
    public String b() {
        return this.c;
    }

    @Override // b.g.a.c.e0.TypeSerializer
    public JsonTypeInfo.a c() {
        return JsonTypeInfo.a.EXTERNAL_PROPERTY;
    }
}
