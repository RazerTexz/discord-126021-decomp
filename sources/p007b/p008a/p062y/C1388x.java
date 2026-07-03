package p007b.p008a.p062y;

import com.discord.widgets.user.search.WidgetGlobalSearchModel;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.y.x */
/* JADX INFO: compiled from: OverlayVoiceSelectorBubbleDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C1388x extends AbstractC12240o implements Function2<List<? extends WidgetGlobalSearchModel.ItemDataPayload>, List<? extends WidgetGlobalSearchModel.ItemDataPayload>, Unit> {
    public final /* synthetic */ WidgetGlobalSearchModel $searchModel$inlined;
    public final /* synthetic */ C1390z this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1388x(C1390z c1390z, WidgetGlobalSearchModel widgetGlobalSearchModel) {
        super(2);
        this.this$0 = c1390z;
        this.$searchModel$inlined = widgetGlobalSearchModel;
    }

    @Override // kotlin.jvm.functions.Function2
    public Unit invoke(List<? extends WidgetGlobalSearchModel.ItemDataPayload> list, List<? extends WidgetGlobalSearchModel.ItemDataPayload> list2) {
        C12238m.checkNotNullParameter(list, "<anonymous parameter 0>");
        C12238m.checkNotNullParameter(list2, "<anonymous parameter 1>");
        if (!C12238m.areEqual(this.this$0.f2079C, this.$searchModel$inlined.getFilter())) {
            this.this$0.f2080z.f701f.scrollToPosition(0);
            this.this$0.f2079C = this.$searchModel$inlined.getFilter();
        }
        return Unit.f27425a;
    }
}
