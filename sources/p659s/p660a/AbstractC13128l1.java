package p659s.p660a;

import com.discord.widgets.chat.input.MentionUtilsKt;
import kotlinx.coroutines.CoroutineDispatcher;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p659s.p660a.p661a.C13031n;

/* JADX INFO: renamed from: s.a.l1 */
/* JADX INFO: compiled from: MainCoroutineDispatcher.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC13128l1 extends CoroutineDispatcher {
    /* JADX INFO: renamed from: H */
    public abstract AbstractC13128l1 mo11194H();

    /* JADX INFO: renamed from: I */
    public final String m11332I() {
        AbstractC13128l1 abstractC13128l1Mo11194H;
        CoroutineDispatcher coroutineDispatcher = C13124k0.f27866a;
        AbstractC13128l1 abstractC13128l1 = C13031n.f27700b;
        if (this == abstractC13128l1) {
            return "Dispatchers.Main";
        }
        try {
            abstractC13128l1Mo11194H = abstractC13128l1.mo11194H();
        } catch (UnsupportedOperationException unused) {
            abstractC13128l1Mo11194H = null;
        }
        if (this == abstractC13128l1Mo11194H) {
            return "Dispatchers.Main.immediate";
        }
        return null;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public String toString() {
        String strM11332I = m11332I();
        if (strM11332I != null) {
            return strM11332I;
        }
        return getClass().getSimpleName() + MentionUtilsKt.MENTIONS_CHAR + C3404f.m4312l0(this);
    }
}
