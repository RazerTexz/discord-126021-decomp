package b.g.a.c.g0;

import b.g.a.c.BeanProperty;
import b.g.a.c.JsonSerializer;
import b.g.a.c.SerializerProvider;
import com.fasterxml.jackson.databind.JsonMappingException;

/* JADX INFO: renamed from: b.g.a.c.g0.i, reason: use source file name */
/* JADX INFO: compiled from: ContextualSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
public interface ContextualSerializer {
    JsonSerializer<?> a(SerializerProvider serializerProvider, BeanProperty beanProperty) throws JsonMappingException;
}
