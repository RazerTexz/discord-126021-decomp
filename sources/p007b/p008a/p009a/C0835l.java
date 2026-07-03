package p007b.p008a.p009a;

import android.view.View;
import com.discord.C5419R;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.a.l */
/* JADX INFO: compiled from: FriendRequestDialogs.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C0835l extends AbstractC12240o implements Function1<View, Unit> {
    public final /* synthetic */ Function1 $onConfirm;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0835l(Function1 function1) {
        super(1);
        this.$onConfirm = function1;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(View view) {
        C12238m.checkNotNullParameter(view, "<anonymous parameter 0>");
        this.$onConfirm.invoke(Integer.valueOf(C5419R.string.friend_request_cancelled));
        return Unit.f27425a;
    }
}
