package s.a;

import com.discord.widgets.chat.input.MentionUtils;
import kotlinx.coroutines.CoroutineDispatcher;
import s.a.a.MainDispatchers;

/* JADX INFO: renamed from: s.a.l1, reason: use source file name */
/* JADX INFO: compiled from: MainCoroutineDispatcher.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class MainCoroutineDispatcher extends CoroutineDispatcher {
    public abstract MainCoroutineDispatcher H();

    public final String I() {
        MainCoroutineDispatcher mainCoroutineDispatcherH;
        CoroutineDispatcher coroutineDispatcher = Dispatchers.a;
        MainCoroutineDispatcher mainCoroutineDispatcher = MainDispatchers.f3830b;
        if (this == mainCoroutineDispatcher) {
            return "Dispatchers.Main";
        }
        try {
            mainCoroutineDispatcherH = mainCoroutineDispatcher.H();
        } catch (UnsupportedOperationException unused) {
            mainCoroutineDispatcherH = null;
        }
        if (this == mainCoroutineDispatcherH) {
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
        return getClass().getSimpleName() + MentionUtils.MENTIONS_CHAR + b.i.a.f.e.o.f.l0(this);
    }
}
