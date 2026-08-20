package com.discord.widgets.share;

import android.view.View;
import androidx.fragment.app.FragmentManager;
import com.discord.widgets.user.search.WidgetGlobalSearchModel;
import com.discord.widgets.user.usersheet.WidgetUserSheet;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetIncomingShare.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetIncomingShare$configureUi$$inlined$apply$lambda$2 extends AbstractC12240o implements Function4<View, Integer, WidgetGlobalSearchModel.ItemDataPayload, Boolean, Unit> {
    public final /* synthetic */ WidgetIncomingShare.Model $this_configureUi$inlined;
    public final /* synthetic */ WidgetIncomingShare this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetIncomingShare$configureUi$$inlined$apply$lambda$2(WidgetIncomingShare widgetIncomingShare, WidgetIncomingShare.Model model) {
        super(4);
        this.this$0 = widgetIncomingShare;
        this.$this_configureUi$inlined = model;
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ Unit invoke(View view, Integer num, WidgetGlobalSearchModel.ItemDataPayload itemDataPayload, Boolean bool) {
        invoke(view, num.intValue(), itemDataPayload, bool.booleanValue());
        return Unit.f27425a;
    }

    public final void invoke(View view, int i, WidgetGlobalSearchModel.ItemDataPayload itemDataPayload, boolean z2) {
        C12238m.checkNotNullParameter(view, "<anonymous parameter 0>");
        C12238m.checkNotNullParameter(itemDataPayload, "data");
        if ((itemDataPayload instanceof WidgetGlobalSearchModel.ItemUser) && z2) {
            WidgetUserSheet.Companion companion = WidgetUserSheet.INSTANCE;
            long id2 = ((WidgetGlobalSearchModel.ItemUser) itemDataPayload).getUser().getId();
            FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
            C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            WidgetUserSheet.Companion.show$default(companion, id2, null, parentFragmentManager, null, null, null, null, 122, null);
        }
        if ((itemDataPayload instanceof WidgetGlobalSearchModel.ItemHeader) || z2) {
            return;
        }
        this.this$0.getBinding().f17201j.post(new Runnable() { // from class: com.discord.widgets.share.WidgetIncomingShare$configureUi$$inlined$apply$lambda$2.1
            @Override // java.lang.Runnable
            public final void run() {
                WidgetIncomingShare$configureUi$$inlined$apply$lambda$2.this.this$0.getBinding().f17201j.scrollTo(0, 0);
            }
        });
        this.this$0.selectedReceiverPublisher.onNext(itemDataPayload);
    }
}
