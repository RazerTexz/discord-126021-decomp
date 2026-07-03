package p659s.p660a;

import androidx.recyclerview.widget.RecyclerView;
import com.discord.api.permission.Permission;
import java.util.Objects;
import kotlinx.coroutines.CoroutineDispatcher;
import p507d0.p580t.C12139j;
import p659s.p660a.p661a.C13019b;

/* JADX INFO: renamed from: s.a.q0 */
/* JADX INFO: compiled from: EventLoop.common.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC13142q0 extends CoroutineDispatcher {

    /* JADX INFO: renamed from: j */
    public static final /* synthetic */ int f27883j = 0;

    /* JADX INFO: renamed from: k */
    public long f27884k;

    /* JADX INFO: renamed from: l */
    public boolean f27885l;

    /* JADX INFO: renamed from: m */
    public C13019b<AbstractC13121j0<?>> f27886m;

    /* JADX INFO: renamed from: H */
    public final void m11334H(boolean z2) {
        long jM11335I = this.f27884k - m11335I(z2);
        this.f27884k = jM11335I;
        if (jM11335I <= 0 && this.f27885l) {
            shutdown();
        }
    }

    /* JADX INFO: renamed from: I */
    public final long m11335I(boolean z2) {
        if (z2) {
            return Permission.REQUEST_TO_SPEAK;
        }
        return 1L;
    }

    /* JADX INFO: renamed from: J */
    public final void m11336J(AbstractC13121j0<?> abstractC13121j0) {
        C13019b<AbstractC13121j0<?>> c13019b = this.f27886m;
        if (c13019b == null) {
            c13019b = new C13019b<>();
            this.f27886m = c13019b;
        }
        Object[] objArr = c13019b.f27668a;
        int i = c13019b.f27670c;
        objArr[i] = abstractC13121j0;
        int length = (objArr.length - 1) & (i + 1);
        c13019b.f27670c = length;
        int i2 = c13019b.f27669b;
        if (length == i2) {
            int length2 = objArr.length;
            Object[] objArr2 = new Object[length2 << 1];
            C12139j.copyInto$default(objArr, objArr2, 0, i2, 0, 10, (Object) null);
            Object[] objArr3 = c13019b.f27668a;
            int length3 = objArr3.length;
            int i3 = c13019b.f27669b;
            C12139j.copyInto$default(objArr3, objArr2, length3 - i3, 0, i3, 4, (Object) null);
            c13019b.f27668a = objArr2;
            c13019b.f27669b = 0;
            c13019b.f27670c = length2;
        }
    }

    /* JADX INFO: renamed from: L */
    public final void m11337L(boolean z2) {
        this.f27884k = m11335I(z2) + this.f27884k;
        if (z2) {
            return;
        }
        this.f27885l = true;
    }

    /* JADX INFO: renamed from: N */
    public final boolean m11338N() {
        return this.f27884k >= m11335I(true);
    }

    /* JADX INFO: renamed from: O */
    public long mo11339O() {
        if (m11340R()) {
            return 0L;
        }
        return RecyclerView.FOREVER_NS;
    }

    /* JADX INFO: renamed from: R */
    public final boolean m11340R() {
        C13019b<AbstractC13121j0<?>> c13019b = this.f27886m;
        if (c13019b != null) {
            int i = c13019b.f27669b;
            Object obj = null;
            if (i != c13019b.f27670c) {
                Object[] objArr = c13019b.f27668a;
                Object obj2 = objArr[i];
                objArr[i] = null;
                c13019b.f27669b = (i + 1) & (objArr.length - 1);
                Objects.requireNonNull(obj2, "null cannot be cast to non-null type T");
                obj = obj2;
            }
            AbstractC13121j0 abstractC13121j0 = (AbstractC13121j0) obj;
            if (abstractC13121j0 != null) {
                abstractC13121j0.run();
                return true;
            }
        }
        return false;
    }

    public void shutdown() {
    }
}
