package d0.z.d;

import b.d.b.a.outline;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

/* JADX INFO: renamed from: d0.z.d.c0, reason: use source file name */
/* JADX INFO: compiled from: SpreadBuilder.java */
/* JADX INFO: loaded from: classes3.dex */
public class SpreadBuilder {
    public final ArrayList<Object> a;

    public SpreadBuilder(int i) {
        this.a = new ArrayList<>(i);
    }

    public void add(Object obj) {
        this.a.add(obj);
    }

    public void addSpread(Object obj) {
        if (obj == null) {
            return;
        }
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length > 0) {
                ArrayList<Object> arrayList = this.a;
                arrayList.ensureCapacity(arrayList.size() + objArr.length);
                Collections.addAll(this.a, objArr);
                return;
            }
            return;
        }
        if (obj instanceof Collection) {
            this.a.addAll((Collection) obj);
            return;
        }
        if (obj instanceof Iterable) {
            Iterator it = ((Iterable) obj).iterator();
            while (it.hasNext()) {
                this.a.add(it.next());
            }
            return;
        }
        if (!(obj instanceof Iterator)) {
            StringBuilder sbU = outline.U("Don't know how to spread ");
            sbU.append(obj.getClass());
            throw new UnsupportedOperationException(sbU.toString());
        }
        Iterator it2 = (Iterator) obj;
        while (it2.hasNext()) {
            this.a.add(it2.next());
        }
    }

    public int size() {
        return this.a.size();
    }

    public Object[] toArray(Object[] objArr) {
        return this.a.toArray(objArr);
    }
}
