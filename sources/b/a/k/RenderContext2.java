package b.a.k;

import android.view.View;
import com.discord.i18n.RenderContext;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: renamed from: b.a.k.d, reason: use source file name */
/* JADX INFO: compiled from: RenderContext.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RenderContext2 extends Lambda implements Function2<String, View, Unit> {
    public final /* synthetic */ RenderContext.a this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RenderContext2(RenderContext.a aVar) {
        super(2);
        this.this$0 = aVar;
    }

    @Override // kotlin.jvm.functions.Function2
    public Unit invoke(String str, View view) {
        View view2 = view;
        Intrinsics3.checkNotNullParameter(str, "<anonymous parameter 0>");
        Intrinsics3.checkNotNullParameter(view2, "view");
        this.this$0.$onClick.invoke(view2);
        return Unit.a;
    }
}
