package b.a.a;

import android.widget.TextView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetUrgentMessageDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class t$c extends d0.z.d.o implements Function1<x$d, Unit> {
    public final /* synthetic */ t this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t$c(t tVar) {
        super(1);
        this.this$0 = tVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(x$d x_d) {
        x$d x_d2 = x_d;
        d0.z.d.m.checkNotNullParameter(x_d2, "viewState");
        t tVar = this.this$0;
        KProperty[] kPropertyArr = t.j;
        TextView textView = tVar.g().c;
        d0.z.d.m.checkNotNullExpressionValue(textView, "binding.viewDialogConfirmationHeader");
        textView.setText(tVar.getString(2131896167));
        TextView textView2 = tVar.g().d;
        d0.z.d.m.checkNotNullExpressionValue(textView2, "binding.viewDialogConfirmationText");
        textView2.setText(tVar.getString(2131896166));
        tVar.g().f108b.setText(tVar.getString(2131893499));
        tVar.g().f108b.setIsLoading(x_d2.f50b);
        tVar.g().f108b.setOnClickListener(new u(tVar));
        return Unit.a;
    }
}
