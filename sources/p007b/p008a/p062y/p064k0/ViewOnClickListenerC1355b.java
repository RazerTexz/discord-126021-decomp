package p007b.p008a.p062y.p064k0;

import android.view.View;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.y.k0.b */
/* JADX INFO: compiled from: GuildChannelSideBarActionsView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ViewOnClickListenerC1355b implements View.OnClickListener {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ Function1 f2041j;

    public ViewOnClickListenerC1355b(Function1 function1) {
        this.f2041j = function1;
    }

    @Override // android.view.View.OnClickListener
    public final /* synthetic */ void onClick(View view) {
        C12238m.checkNotNullExpressionValue(this.f2041j.invoke(view), "invoke(...)");
    }
}
