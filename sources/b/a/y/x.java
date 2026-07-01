package b.a.y;

import com.discord.widgets.user.search.WidgetGlobalSearchModel;
import com.discord.widgets.user.search.WidgetGlobalSearchModel$ItemDataPayload;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: OverlayVoiceSelectorBubbleDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class x extends d0.z.d.o implements Function2<List<? extends WidgetGlobalSearchModel$ItemDataPayload>, List<? extends WidgetGlobalSearchModel$ItemDataPayload>, Unit> {
    public final /* synthetic */ WidgetGlobalSearchModel $searchModel$inlined;
    public final /* synthetic */ z this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(z zVar, WidgetGlobalSearchModel widgetGlobalSearchModel) {
        super(2);
        this.this$0 = zVar;
        this.$searchModel$inlined = widgetGlobalSearchModel;
    }

    @Override // kotlin.jvm.functions.Function2
    public Unit invoke(List<? extends WidgetGlobalSearchModel$ItemDataPayload> list, List<? extends WidgetGlobalSearchModel$ItemDataPayload> list2) {
        d0.z.d.m.checkNotNullParameter(list, "<anonymous parameter 0>");
        d0.z.d.m.checkNotNullParameter(list2, "<anonymous parameter 1>");
        if (!d0.z.d.m.areEqual(this.this$0.C, this.$searchModel$inlined.getFilter())) {
            this.this$0.f318z.f.scrollToPosition(0);
            this.this$0.C = this.$searchModel$inlined.getFilter();
        }
        return Unit.a;
    }
}
