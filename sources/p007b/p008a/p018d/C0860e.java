package p007b.p008a.p018d;

import com.discord.C5419R;
import com.discord.app.AppFragment;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p027k.C1107b;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.d.e */
/* JADX INFO: compiled from: AppFragment.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C0860e extends AbstractC12240o implements Function1<Exception, Unit> {
    public final /* synthetic */ AppFragment.C5450d this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0860e(AppFragment.C5450d c5450d) {
        super(1);
        this.this$0 = c5450d;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Exception exc) {
        Exception exc2 = exc;
        C12238m.checkNotNullParameter(exc2, "e");
        AppFragment appFragment = AppFragment.this;
        C0876m.m172j(appFragment, C1107b.m213e(appFragment, C5419R.string.unable_to_open_media_chooser, new Object[]{exc2.getMessage()}, (4 & 4) != 0 ? C1107b.a.f1490j : null), 0, 4);
        return Unit.f27425a;
    }
}
