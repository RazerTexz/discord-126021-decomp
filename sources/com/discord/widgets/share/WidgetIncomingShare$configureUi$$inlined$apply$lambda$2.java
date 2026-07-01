package com.discord.widgets.share;

import android.view.View;
import androidx.fragment.app.FragmentManager;
import com.discord.widgets.user.search.WidgetGlobalSearchModel$ItemDataPayload;
import com.discord.widgets.user.search.WidgetGlobalSearchModel$ItemHeader;
import com.discord.widgets.user.search.WidgetGlobalSearchModel$ItemUser;
import com.discord.widgets.user.usersheet.WidgetUserSheet;
import com.discord.widgets.user.usersheet.WidgetUserSheet$Companion;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;

/* JADX INFO: compiled from: WidgetIncomingShare.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetIncomingShare$configureUi$$inlined$apply$lambda$2 extends o implements Function4<View, Integer, WidgetGlobalSearchModel$ItemDataPayload, Boolean, Unit> {
    public final /* synthetic */ WidgetIncomingShare$Model $this_configureUi$inlined;
    public final /* synthetic */ WidgetIncomingShare this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetIncomingShare$configureUi$$inlined$apply$lambda$2(WidgetIncomingShare widgetIncomingShare, WidgetIncomingShare$Model widgetIncomingShare$Model) {
        super(4);
        this.this$0 = widgetIncomingShare;
        this.$this_configureUi$inlined = widgetIncomingShare$Model;
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ Unit invoke(View view, Integer num, WidgetGlobalSearchModel$ItemDataPayload widgetGlobalSearchModel$ItemDataPayload, Boolean bool) {
        invoke(view, num.intValue(), widgetGlobalSearchModel$ItemDataPayload, bool.booleanValue());
        return Unit.a;
    }

    public final void invoke(View view, int i, WidgetGlobalSearchModel$ItemDataPayload widgetGlobalSearchModel$ItemDataPayload, boolean z2) {
        m.checkNotNullParameter(view, "<anonymous parameter 0>");
        m.checkNotNullParameter(widgetGlobalSearchModel$ItemDataPayload, "data");
        if ((widgetGlobalSearchModel$ItemDataPayload instanceof WidgetGlobalSearchModel$ItemUser) && z2) {
            WidgetUserSheet$Companion widgetUserSheet$Companion = WidgetUserSheet.Companion;
            long id2 = ((WidgetGlobalSearchModel$ItemUser) widgetGlobalSearchModel$ItemDataPayload).getUser().getId();
            FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
            m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            WidgetUserSheet$Companion.show$default(widgetUserSheet$Companion, id2, null, parentFragmentManager, null, null, null, null, 122, null);
        }
        if ((widgetGlobalSearchModel$ItemDataPayload instanceof WidgetGlobalSearchModel$ItemHeader) || z2) {
            return;
        }
        WidgetIncomingShare.access$getBinding$p(this.this$0).j.post(new WidgetIncomingShare$configureUi$$inlined$apply$lambda$2$1(this));
        WidgetIncomingShare.access$getSelectedReceiverPublisher$p(this.this$0).onNext(widgetGlobalSearchModel$ItemDataPayload);
    }
}
