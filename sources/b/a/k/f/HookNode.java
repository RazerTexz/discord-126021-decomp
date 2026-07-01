package b.a.k.f;

import android.view.View;
import com.discord.i18n.Hook;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: b.a.k.f.b, reason: use source file name */
/* JADX INFO: compiled from: HookNode.kt */
/* JADX INFO: loaded from: classes.dex */
public final class HookNode extends Lambda implements Function1<View, Unit> {
    public final /* synthetic */ Hook.a $clickHandler;
    public final /* synthetic */ HookNode2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HookNode(HookNode2 hookNode2, Hook.a aVar) {
        super(1);
        this.this$0 = hookNode2;
        this.$clickHandler = aVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(View view) {
        View view2 = view;
        Intrinsics3.checkNotNullParameter(view2, "view");
        this.$clickHandler.f2709b.invoke(this.this$0.a, view2);
        return Unit.a;
    }
}
