package com.discord.widgets.share;

import android.view.View;
import androidx.fragment.app.FragmentManager;
import com.discord.widgets.share.WidgetIncomingShare;
import com.discord.widgets.user.search.WidgetGlobalSearchModel;
import com.discord.widgets.user.usersheet.WidgetUserSheet;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;

/* JADX INFO: renamed from: com.discord.widgets.share.WidgetIncomingShare$configureUi$$inlined$apply$lambda$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetIncomingShare.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetIncomingShare5 extends Lambda implements Function4<View, Integer, WidgetGlobalSearchModel.ItemDataPayload, Boolean, Unit> {
    public final /* synthetic */ WidgetIncomingShare.Model $this_configureUi$inlined;
    public final /* synthetic */ WidgetIncomingShare this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetIncomingShare5(WidgetIncomingShare widgetIncomingShare, WidgetIncomingShare.Model model) {
        super(4);
        this.this$0 = widgetIncomingShare;
        this.$this_configureUi$inlined = model;
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ Unit invoke(View view, Integer num, WidgetGlobalSearchModel.ItemDataPayload itemDataPayload, Boolean bool) {
        invoke(view, num.intValue(), itemDataPayload, bool.booleanValue());
        return Unit.a;
    }

    public final void invoke(View view, int i, WidgetGlobalSearchModel.ItemDataPayload itemDataPayload, boolean z2) {
        Intrinsics3.checkNotNullParameter(view, "<anonymous parameter 0>");
        Intrinsics3.checkNotNullParameter(itemDataPayload, "data");
        if ((itemDataPayload instanceof WidgetGlobalSearchModel.ItemUser) && z2) {
            WidgetUserSheet.Companion companion = WidgetUserSheet.INSTANCE;
            long id2 = ((WidgetGlobalSearchModel.ItemUser) itemDataPayload).getUser().getId();
            FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            WidgetUserSheet.Companion.show$default(companion, id2, null, parentFragmentManager, null, null, null, null, 122, null);
        }
        if ((itemDataPayload instanceof WidgetGlobalSearchModel.ItemHeader) || z2) {
            return;
        }
        this.this$0.getBinding().j.post(new Runnable() { // from class: com.discord.widgets.share.WidgetIncomingShare$configureUi$$inlined$apply$lambda$2.1
            @Override // java.lang.Runnable
            public final void run() {
                WidgetIncomingShare5.this.this$0.getBinding().j.scrollTo(0, 0);
            }
        });
        this.this$0.selectedReceiverPublisher.onNext(itemDataPayload);
    }
}
