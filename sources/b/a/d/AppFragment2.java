package b.a.d;

import b.a.k.FormatUtils;
import com.discord.R;
import com.discord.app.AppFragment;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: b.a.d.e, reason: use source file name */
/* JADX INFO: compiled from: AppFragment.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AppFragment2 extends Lambda implements Function1<Exception, Unit> {
    public final /* synthetic */ AppFragment.d this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppFragment2(AppFragment.d dVar) {
        super(1);
        this.this$0 = dVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Exception exc) {
        Exception exc2 = exc;
        Intrinsics3.checkNotNullParameter(exc2, "e");
        AppFragment appFragment = AppFragment.this;
        AppToast.j(appFragment, FormatUtils.e(appFragment, R.string.unable_to_open_media_chooser, new Object[]{exc2.getMessage()}, (4 & 4) != 0 ? FormatUtils.a.j : null), 0, 4);
        return Unit.a;
    }
}
