package b.a.y.k0;

import android.view.View;
import android.view.View$OnClickListener;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: GuildChannelSideBarActionsView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a implements View$OnClickListener {
    public final /* synthetic */ Function1 j;

    public a(Function1 function1) {
        this.j = function1;
    }

    @Override // android.view.View$OnClickListener
    public final /* synthetic */ void onClick(View view) {
        m.checkNotNullExpressionValue(this.j.invoke(view), "invoke(...)");
    }
}
