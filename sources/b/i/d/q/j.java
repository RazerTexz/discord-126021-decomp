package b.i.d.q;

import b.d.b.a.outline;
import com.google.gson.JsonIOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.EnumSet;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: ConstructorConstructor.java */
/* JADX INFO: loaded from: classes3.dex */
public class j<T> implements ObjectConstructor<T> {
    public final /* synthetic */ Type a;

    public j(g gVar, Type type) {
        this.a = type;
    }

    @Override // b.i.d.q.ObjectConstructor
    public T a() {
        Type type = this.a;
        if (!(type instanceof ParameterizedType)) {
            StringBuilder sbU = outline.U("Invalid EnumSet type: ");
            sbU.append(this.a.toString());
            throw new JsonIOException(sbU.toString());
        }
        Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
        if (type2 instanceof Class) {
            return (T) EnumSet.noneOf((Class) type2);
        }
        StringBuilder sbU2 = outline.U("Invalid EnumSet type: ");
        sbU2.append(this.a.toString());
        throw new JsonIOException(sbU2.toString());
    }
}
