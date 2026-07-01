package s.a;

import com.discord.widgets.chat.input.MentionUtilsKt;
import kotlinx.coroutines.CoroutineDispatcher;

/* JADX INFO: compiled from: MainCoroutineDispatcher.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class l1 extends CoroutineDispatcher {
    public abstract l1 H();

    public final String I() {
        l1 l1VarH;
        CoroutineDispatcher coroutineDispatcher = k0.a;
        l1 l1Var = s.a.a.n.f3830b;
        if (this == l1Var) {
            return "Dispatchers.Main";
        }
        try {
            l1VarH = l1Var.H();
        } catch (UnsupportedOperationException unused) {
            l1VarH = null;
        }
        if (this == l1VarH) {
            return "Dispatchers.Main.immediate";
        }
        return null;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public String toString() {
        String strI = I();
        if (strI != null) {
            return strI;
        }
        return getClass().getSimpleName() + MentionUtilsKt.MENTIONS_CHAR + b.i.a.f.e.o.f.l0(this);
    }
}
