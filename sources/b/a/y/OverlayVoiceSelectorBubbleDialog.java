package b.a.y;

import com.discord.widgets.user.search.WidgetGlobalSearchModel;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: renamed from: b.a.y.x, reason: use source file name */
/* JADX INFO: compiled from: OverlayVoiceSelectorBubbleDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class OverlayVoiceSelectorBubbleDialog extends Lambda implements Function2<List<? extends WidgetGlobalSearchModel.ItemDataPayload>, List<? extends WidgetGlobalSearchModel.ItemDataPayload>, Unit> {
    public final /* synthetic */ WidgetGlobalSearchModel $searchModel$inlined;
    public final /* synthetic */ OverlayVoiceSelectorBubbleDialog3 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OverlayVoiceSelectorBubbleDialog(OverlayVoiceSelectorBubbleDialog3 overlayVoiceSelectorBubbleDialog3, WidgetGlobalSearchModel widgetGlobalSearchModel) {
        super(2);
        this.this$0 = overlayVoiceSelectorBubbleDialog3;
        this.$searchModel$inlined = widgetGlobalSearchModel;
    }

    @Override // kotlin.jvm.functions.Function2
    public Unit invoke(List<? extends WidgetGlobalSearchModel.ItemDataPayload> list, List<? extends WidgetGlobalSearchModel.ItemDataPayload> list2) {
        Intrinsics3.checkNotNullParameter(list, "<anonymous parameter 0>");
        Intrinsics3.checkNotNullParameter(list2, "<anonymous parameter 1>");
        if (!Intrinsics3.areEqual(this.this$0.C, this.$searchModel$inlined.getFilter())) {
            this.this$0.f318z.f.scrollToPosition(0);
            this.this$0.C = this.$searchModel$inlined.getFilter();
        }
        return Unit.a;
    }
}
