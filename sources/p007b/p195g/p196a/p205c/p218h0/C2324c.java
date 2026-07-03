package p007b.p195g.p196a.p205c.p218h0;

import java.util.ArrayList;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: b.g.a.c.h0.c */
/* JADX INFO: compiled from: ClassStack.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2324c {

    /* JADX INFO: renamed from: a */
    public final C2324c f4902a;

    /* JADX INFO: renamed from: b */
    public final Class<?> f4903b;

    /* JADX INFO: renamed from: c */
    public ArrayList<C2331j> f4904c;

    public C2324c(C2324c c2324c, Class<?> cls) {
        this.f4902a = c2324c;
        this.f4903b = cls;
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("[ClassStack (self-refs: ");
        ArrayList<C2331j> arrayList = this.f4904c;
        sbM833U.append(arrayList == null ? "0" : String.valueOf(arrayList.size()));
        sbM833U.append(')');
        for (C2324c c2324c = this; c2324c != null; c2324c = c2324c.f4902a) {
            sbM833U.append(' ');
            sbM833U.append(c2324c.f4903b.getName());
        }
        sbM833U.append(']');
        return sbM833U.toString();
    }

    public C2324c(Class<?> cls) {
        this.f4902a = null;
        this.f4903b = cls;
    }
}
