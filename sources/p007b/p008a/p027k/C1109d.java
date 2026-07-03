package p007b.p008a.p027k;

import android.view.View;
import com.discord.i18n.RenderContext;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.k.d */
/* JADX INFO: compiled from: RenderContext.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C1109d extends AbstractC12240o implements Function2<String, View, Unit> {
    public final /* synthetic */ RenderContext.C5526a this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1109d(RenderContext.C5526a c5526a) {
        super(2);
        this.this$0 = c5526a;
    }

    @Override // kotlin.jvm.functions.Function2
    public Unit invoke(String str, View view) {
        View view2 = view;
        C12238m.checkNotNullParameter(str, "<anonymous parameter 0>");
        C12238m.checkNotNullParameter(view2, "view");
        this.this$0.$onClick.invoke(view2);
        return Unit.f27425a;
    }
}
