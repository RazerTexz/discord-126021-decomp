package b.g.a.c.h0;

import b.d.b.a.outline;
import java.util.ArrayList;

/* JADX INFO: renamed from: b.g.a.c.h0.c, reason: use source file name */
/* JADX INFO: compiled from: ClassStack.java */
/* JADX INFO: loaded from: classes3.dex */
public final class ClassStack {
    public final ClassStack a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Class<?> f719b;
    public ArrayList<ResolvedRecursiveType> c;

    public ClassStack(ClassStack classStack, Class<?> cls) {
        this.a = classStack;
        this.f719b = cls;
    }

    public String toString() {
        StringBuilder sbU = outline.U("[ClassStack (self-refs: ");
        ArrayList<ResolvedRecursiveType> arrayList = this.c;
        sbU.append(arrayList == null ? "0" : String.valueOf(arrayList.size()));
        sbU.append(')');
        for (ClassStack classStack = this; classStack != null; classStack = classStack.a) {
            sbU.append(' ');
            sbU.append(classStack.f719b.getName());
        }
        sbU.append(']');
        return sbU.toString();
    }

    public ClassStack(Class<?> cls) {
        this.a = null;
        this.f719b = cls;
    }
}
