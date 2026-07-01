package b.a.a.a;

import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;
import com.discord.models.domain.ModelSubscription;
import com.discord.utilities.premium.GuildBoostUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: java-style lambda group */
/* JADX INFO: loaded from: classes2.dex */
public final class b$a implements View$OnClickListener {
    public final /* synthetic */ int j;
    public final /* synthetic */ Object k;

    public b$a(int i, Object obj) {
        this.j = i;
        this.k = obj;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        ModelSubscription modelSubscription;
        int i = this.j;
        if (i == 0) {
            f fVar = (f) ((b) this.k).viewModel.getValue();
            f$c viewState = fVar.getViewState();
            if ((viewState instanceof f$c$f) || (viewState instanceof f$c$a)) {
                return;
            }
            if ((viewState instanceof f$c$e) || (viewState instanceof f$c$d) || (viewState instanceof f$c$b)) {
                fVar.updateViewState(new f$c$c(null, 1));
                return;
            }
            return;
        }
        if (i != 1) {
            throw null;
        }
        f fVar2 = (f) ((b) this.k).viewModel.getValue();
        f$c viewState2 = fVar2.getViewState();
        if ((viewState2 instanceof f$c$f) || (viewState2 instanceof f$c$a)) {
            return;
        }
        if (!(viewState2 instanceof f$c$e) && !(viewState2 instanceof f$c$d)) {
            if (viewState2 instanceof f$c$b) {
                fVar2.updateViewState(new f$c$c(null, 1));
                return;
            }
            return;
        }
        f$c viewState3 = fVar2.getViewState();
        if (viewState3 instanceof f$c$e) {
            modelSubscription = ((f$c$e) viewState3).f;
        } else {
            modelSubscription = viewState3 instanceof f$c$d ? ((f$c$d) viewState3).f : null;
        }
        if (modelSubscription != null) {
            fVar2.updateViewState(new f$c$a(modelSubscription));
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(GuildBoostUtils.INSTANCE.cancelGuildBoostSlot(fVar2.n, fVar2.k, modelSubscription, fVar2.l), fVar2, null, 2, null), f.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new g(fVar2, modelSubscription), 62, (Object) null);
        }
    }
}
