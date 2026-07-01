package b.g.a.c.g0;

import b.g.a.b.JsonGenerator;
import b.g.a.c.BeanProperty;
import b.g.a.c.JsonSerializer;
import b.g.a.c.SerializerProvider;
import b.g.a.c.c0.AnnotatedMember;
import b.g.a.c.g0.u.MapSerializer2;
import java.util.Map;

/* JADX INFO: renamed from: b.g.a.c.g0.a, reason: use source file name */
/* JADX INFO: compiled from: AnyGetterWriter.java */
/* JADX INFO: loaded from: classes3.dex */
public class AnyGetterWriter {
    public final BeanProperty a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AnnotatedMember f700b;
    public JsonSerializer<Object> c;
    public MapSerializer2 d;

    public AnyGetterWriter(BeanProperty beanProperty, AnnotatedMember annotatedMember, JsonSerializer<?> jsonSerializer) {
        this.f700b = annotatedMember;
        this.a = beanProperty;
        this.c = jsonSerializer;
        if (jsonSerializer instanceof MapSerializer2) {
            this.d = (MapSerializer2) jsonSerializer;
        }
    }

    public void a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws Exception {
        Object objJ = this.f700b.j(obj);
        if (objJ == null) {
            return;
        }
        if (!(objJ instanceof Map)) {
            serializerProvider.f(this.a.getType(), String.format("Value returned by 'any-getter' %s() not java.util.Map but %s", this.f700b.c(), objJ.getClass().getName()));
            throw null;
        }
        MapSerializer2 mapSerializer2 = this.d;
        if (mapSerializer2 != null) {
            mapSerializer2.u((Map) objJ, jsonGenerator, serializerProvider);
        } else {
            this.c.f(objJ, jsonGenerator, serializerProvider);
        }
    }
}
