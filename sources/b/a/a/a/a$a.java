package b.a.a.a;

import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;
import com.discord.utilities.premium.GuildBoostUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import java.util.Objects;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: java-style lambda group */
/* JADX INFO: loaded from: classes.dex */
public final class a$a implements View$OnClickListener {
    public final /* synthetic */ int j;
    public final /* synthetic */ Object k;

    public a$a(int i, Object obj) {
        this.j = i;
        this.k = obj;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        int i = this.j;
        if (i == 0) {
            k kVar = (k) ((a) this.k).viewModel.getValue();
            k$c viewState = kVar.getViewState();
            if (m.areEqual(viewState, k$c$c.a)) {
                return;
            }
            if ((viewState instanceof k$c$b) || (viewState instanceof k$c$a)) {
                kVar.updateViewState(new k$c$a(null, 1));
                return;
            }
            return;
        }
        if (i != 1) {
            throw null;
        }
        k kVar2 = (k) ((a) this.k).viewModel.getValue();
        k$c viewState2 = kVar2.getViewState();
        if (m.areEqual(viewState2, k$c$c.a)) {
            return;
        }
        if (!(viewState2 instanceof k$c$b)) {
            if ((viewState2 instanceof k$c$d) || (viewState2 instanceof k$c$a)) {
                kVar2.updateViewState(new k$c$a(null, 1));
                return;
            }
            return;
        }
        k$c viewState3 = kVar2.getViewState();
        Objects.requireNonNull(viewState3, "null cannot be cast to non-null type com.discord.dialogs.guildboost.GuildBoostUncancelViewModel.ViewState.Loaded");
        if (((k$c$b) viewState3).f43b) {
            return;
        }
        k$c viewState4 = kVar2.getViewState();
        if (!(viewState4 instanceof k$c$b)) {
            viewState4 = null;
        }
        k$c$b k_c_b = (k$c$b) viewState4;
        if (k_c_b != null) {
            kVar2.updateViewState(k$c$b.a(k_c_b, null, true, false, 5));
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(GuildBoostUtils.INSTANCE.uncancelGuildBoostSlot(kVar2.n, kVar2.k, k_c_b.a, kVar2.m), kVar2, null, 2, null), k.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new l(kVar2, k_c_b), 62, (Object) null);
        }
    }
}
