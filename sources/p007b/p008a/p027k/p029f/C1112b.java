package p007b.p008a.p027k.p029f;

import android.view.View;
import com.discord.i18n.Hook;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.k.f.b */
/* JADX INFO: compiled from: HookNode.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C1112b extends AbstractC12240o implements Function1<View, Unit> {
    public final /* synthetic */ Hook.C5524a $clickHandler;
    public final /* synthetic */ C1113c this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1112b(C1113c c1113c, Hook.C5524a c5524a) {
        super(1);
        this.this$0 = c1113c;
        this.$clickHandler = c5524a;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(View view) {
        View view2 = view;
        C12238m.checkNotNullParameter(view2, "view");
        this.$clickHandler.f18547b.invoke(this.this$0.f1500a, view2);
        return Unit.f27425a;
    }
}
