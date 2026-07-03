package p007b.p225i.p408d.p410q;

import com.google.gson.JsonIOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.EnumSet;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: renamed from: b.i.d.q.j */
/* JADX INFO: compiled from: ConstructorConstructor.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4925j<T> implements InterfaceC4933r<T> {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ Type f13122a;

    public C4925j(C4922g c4922g, Type type) {
        this.f13122a = type;
    }

    @Override // p007b.p225i.p408d.p410q.InterfaceC4933r
    /* JADX INFO: renamed from: a */
    public T mo6869a() {
        Type type = this.f13122a;
        if (!(type instanceof ParameterizedType)) {
            StringBuilder sbM833U = C1643a.m833U("Invalid EnumSet type: ");
            sbM833U.append(this.f13122a.toString());
            throw new JsonIOException(sbM833U.toString());
        }
        Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
        if (type2 instanceof Class) {
            return (T) EnumSet.noneOf((Class) type2);
        }
        StringBuilder sbM833U2 = C1643a.m833U("Invalid EnumSet type: ");
        sbM833U2.append(this.f13122a.toString());
        throw new JsonIOException(sbM833U2.toString());
    }
}
