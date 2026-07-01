package b.a.y.k0;

import android.view.View;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: b.a.y.k0.b, reason: use source file name */
/* JADX INFO: compiled from: GuildChannelSideBarActionsView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildChannelSideBarActionsView3 implements View.OnClickListener {
    public final /* synthetic */ Function1 j;

    public GuildChannelSideBarActionsView3(Function1 function1) {
        this.j = function1;
    }

    @Override // android.view.View.OnClickListener
    public final /* synthetic */ void onClick(View view) {
        Intrinsics3.checkNotNullExpressionValue(this.j.invoke(view), "invoke(...)");
    }
}
