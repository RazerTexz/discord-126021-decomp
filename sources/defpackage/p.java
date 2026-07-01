package defpackage;

import com.discord.views.OverlayMenuBubbleDialog;
import com.discord.views.SearchInputView;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: kotlin-style lambda group */
/* JADX INFO: loaded from: classes2.dex */
public final class p extends Lambda implements Function0<Unit> {
    public final /* synthetic */ int j;
    public final /* synthetic */ Object k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(int i, Object obj) {
        super(0);
        this.j = i;
        this.k = obj;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Unit invoke() {
        int i = this.j;
        if (i == 0) {
            ((OverlayMenuBubbleDialog) this.k).g();
            return Unit.a;
        }
        if (i != 1) {
            throw null;
        }
        ((SearchInputView) this.k).binding.c.setText("");
        return Unit.a;
    }
}
