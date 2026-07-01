package s.a;

import b.d.b.a.a;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: JobSupport.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h1$b implements z0 {
    public volatile Object _exceptionsHolder = null;
    public volatile int _isCompleting;
    public volatile Object _rootCause;
    public final m1 j;

    public h1$b(m1 m1Var, boolean z2, Throwable th) {
        this.j = m1Var;
        this._isCompleting = z2 ? 1 : 0;
        this._rootCause = th;
    }

    @Override // s.a.z0
    public boolean a() {
        return ((Throwable) this._rootCause) == null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b(Throwable th) {
        Throwable th2 = (Throwable) this._rootCause;
        if (th2 == null) {
            this._rootCause = th;
            return;
        }
        if (th == th2) {
            return;
        }
        Object obj = this._exceptionsHolder;
        if (obj == null) {
            this._exceptionsHolder = th;
            return;
        }
        if (!(obj instanceof Throwable)) {
            if (!(obj instanceof ArrayList)) {
                throw new IllegalStateException(a.v("State is ", obj).toString());
            }
            ((ArrayList) obj).add(th);
        } else {
            if (th == obj) {
                return;
            }
            ArrayList<Throwable> arrayListC = c();
            arrayListC.add(obj);
            arrayListC.add(th);
            this._exceptionsHolder = arrayListC;
        }
    }

    public final ArrayList<Throwable> c() {
        return new ArrayList<>(4);
    }

    public final boolean d() {
        return ((Throwable) this._rootCause) != null;
    }

    public final boolean e() {
        return this._exceptionsHolder == i1.e;
    }

    public final List<Throwable> f(Throwable th) {
        ArrayList arrayListC;
        Object obj = this._exceptionsHolder;
        if (obj == null) {
            arrayListC = c();
        } else if (obj instanceof Throwable) {
            ArrayList arrayListC2 = c();
            arrayListC2.add(obj);
            arrayListC = arrayListC2;
        } else {
            if (!(obj instanceof ArrayList)) {
                throw new IllegalStateException(a.v("State is ", obj).toString());
            }
            arrayListC = (ArrayList) obj;
        }
        Throwable th2 = (Throwable) this._rootCause;
        if (th2 != null) {
            arrayListC.add(0, th2);
        }
        if (th != null && (!d0.z.d.m.areEqual(th, th2))) {
            arrayListC.add(th);
        }
        this._exceptionsHolder = i1.e;
        return arrayListC;
    }

    @Override // s.a.z0
    public m1 getList() {
        return this.j;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [boolean, int] */
    public String toString() {
        StringBuilder sbU = a.U("Finishing[cancelling=");
        sbU.append(d());
        sbU.append(", completing=");
        sbU.append((boolean) this._isCompleting);
        sbU.append(", rootCause=");
        sbU.append((Throwable) this._rootCause);
        sbU.append(", exceptions=");
        sbU.append(this._exceptionsHolder);
        sbU.append(", list=");
        sbU.append(this.j);
        sbU.append(']');
        return sbU.toString();
    }
}
