package b.a.k.f;

import android.view.View;
import com.discord.i18n.Hook$a;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: HookNode.kt */
/* JADX INFO: loaded from: classes.dex */
public final class b extends o implements Function1<View, Unit> {
    public final /* synthetic */ Hook$a $clickHandler;
    public final /* synthetic */ c this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(c cVar, Hook$a hook$a) {
        super(1);
        this.this$0 = cVar;
        this.$clickHandler = hook$a;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(View view) {
        View view2 = view;
        m.checkNotNullParameter(view2, "view");
        this.$clickHandler.f2709b.invoke(this.this$0.a, view2);
        return Unit.a;
    }
}
