package p007b.p008a.p062y.p064k0;

import android.view.View;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.y.k0.a */
/* JADX INFO: compiled from: GuildChannelSideBarActionsView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ViewOnClickListenerC1354a implements View.OnClickListener {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ Function1 f2040j;

    public ViewOnClickListenerC1354a(Function1 function1) {
        this.f2040j = function1;
    }

    @Override // android.view.View.OnClickListener
    public final /* synthetic */ void onClick(View view) {
        C12238m.checkNotNullExpressionValue(this.f2040j.invoke(view), "invoke(...)");
    }
}
