package s.a;

import androidx.recyclerview.widget.RecyclerView;
import com.discord.api.permission.Permission;
import java.util.Objects;
import kotlinx.coroutines.CoroutineDispatcher;

/* JADX INFO: compiled from: EventLoop.common.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class q0 extends CoroutineDispatcher {
    public static final /* synthetic */ int j = 0;
    public long k;
    public boolean l;
    public s.a.a.b<j0<?>> m;

    public final void H(boolean z2) {
        long jI = this.k - I(z2);
        this.k = jI;
        if (jI <= 0 && this.l) {
            shutdown();
        }
    }

    public final long I(boolean z2) {
        if (z2) {
            return Permission.REQUEST_TO_SPEAK;
        }
        return 1L;
    }

    public final void J(j0<?> j0Var) {
        s.a.a.b<j0<?>> bVar = this.m;
        if (bVar == null) {
            bVar = new s.a.a.b<>();
            this.m = bVar;
        }
        Object[] objArr = bVar.a;
        int i = bVar.c;
        objArr[i] = j0Var;
        int length = (objArr.length - 1) & (i + 1);
        bVar.c = length;
        int i2 = bVar.f3826b;
        if (length == i2) {
            int length2 = objArr.length;
            Object[] objArr2 = new Object[length2 << 1];
            d0.t.j.copyInto$default(objArr, objArr2, 0, i2, 0, 10, (Object) null);
            Object[] objArr3 = bVar.a;
            int length3 = objArr3.length;
            int i3 = bVar.f3826b;
            d0.t.j.copyInto$default(objArr3, objArr2, length3 - i3, 0, i3, 4, (Object) null);
            bVar.a = objArr2;
            bVar.f3826b = 0;
            bVar.c = length2;
        }
    }

    public final void L(boolean z2) {
        this.k = I(z2) + this.k;
        if (z2) {
            return;
        }
        this.l = true;
    }

    public final boolean N() {
        return this.k >= I(true);
    }

    public long O() {
        if (R()) {
            return 0L;
        }
        return RecyclerView.FOREVER_NS;
    }

    public final boolean R() {
        s.a.a.b<j0<?>> bVar = this.m;
        if (bVar != null) {
            int i = bVar.f3826b;
            Object obj = null;
            if (i != bVar.c) {
                Object[] objArr = bVar.a;
                Object obj2 = objArr[i];
                objArr[i] = null;
                bVar.f3826b = (i + 1) & (objArr.length - 1);
                Objects.requireNonNull(obj2, "null cannot be cast to non-null type T");
                obj = obj2;
            }
            j0 j0Var = (j0) obj;
            if (j0Var != null) {
                j0Var.run();
                return true;
            }
        }
        return false;
    }

    public void shutdown() {
    }
}
