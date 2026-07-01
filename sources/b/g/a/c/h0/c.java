package b.g.a.c.h0;

import java.util.ArrayList;

/* JADX INFO: compiled from: ClassStack.java */
/* JADX INFO: loaded from: classes3.dex */
public final class c {
    public final c a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Class<?> f719b;
    public ArrayList<j> c;

    public c(c cVar, Class<?> cls) {
        this.a = cVar;
        this.f719b = cls;
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("[ClassStack (self-refs: ");
        ArrayList<j> arrayList = this.c;
        sbU.append(arrayList == null ? "0" : String.valueOf(arrayList.size()));
        sbU.append(')');
        for (c cVar = this; cVar != null; cVar = cVar.a) {
            sbU.append(' ');
            sbU.append(cVar.f719b.getName());
        }
        sbU.append(']');
        return sbU.toString();
    }

    public c(Class<?> cls) {
        this.a = null;
        this.f719b = cls;
    }
}
