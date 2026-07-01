package b.g.a.c.g0;

import b.g.a.c.BeanDescription;
import b.g.a.c.JsonSerializer;
import b.g.a.c.MapperFeature;
import b.g.a.c.SerializationConfig;
import b.g.a.c.c0.AnnotatedMember;
import b.g.a.c.g0.t.ObjectIdWriter;
import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: b.g.a.c.g0.e, reason: use source file name */
/* JADX INFO: compiled from: BeanSerializerBuilder.java */
/* JADX INFO: loaded from: classes3.dex */
public class BeanSerializerBuilder {
    public static final BeanPropertyWriter[] a = new BeanPropertyWriter[0];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BeanDescription f701b;
    public SerializationConfig c;
    public List<BeanPropertyWriter> d = Collections.emptyList();
    public BeanPropertyWriter[] e;
    public AnyGetterWriter f;
    public Object g;
    public AnnotatedMember h;
    public ObjectIdWriter i;

    public BeanSerializerBuilder(BeanDescription beanDescription) {
        this.f701b = beanDescription;
    }

    public JsonSerializer<?> a() {
        BeanPropertyWriter[] beanPropertyWriterArr;
        if (this.h != null && this.c.q(MapperFeature.CAN_OVERRIDE_ACCESS_MODIFIERS)) {
            this.h.f(this.c.q(MapperFeature.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
        }
        AnyGetterWriter anyGetterWriter = this.f;
        if (anyGetterWriter != null) {
            anyGetterWriter.f700b.f(this.c.q(MapperFeature.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
        }
        List<BeanPropertyWriter> list = this.d;
        if (list == null || list.isEmpty()) {
            if (this.f == null && this.i == null) {
                return null;
            }
            beanPropertyWriterArr = a;
        } else {
            List<BeanPropertyWriter> list2 = this.d;
            beanPropertyWriterArr = (BeanPropertyWriter[]) list2.toArray(new BeanPropertyWriter[list2.size()]);
            if (this.c.q(MapperFeature.CAN_OVERRIDE_ACCESS_MODIFIERS)) {
                for (BeanPropertyWriter beanPropertyWriter : beanPropertyWriterArr) {
                    beanPropertyWriter._member.f(this.c.q(MapperFeature.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
                }
            }
        }
        BeanPropertyWriter[] beanPropertyWriterArr2 = this.e;
        if (beanPropertyWriterArr2 == null || beanPropertyWriterArr2.length == this.d.size()) {
            return new BeanSerializer2(this.f701b.a, this, beanPropertyWriterArr, this.e);
        }
        throw new IllegalStateException(String.format("Mismatch between `properties` size (%d), `filteredProperties` (%s): should have as many (or `null` for latter)", Integer.valueOf(this.d.size()), Integer.valueOf(this.e.length)));
    }
}
