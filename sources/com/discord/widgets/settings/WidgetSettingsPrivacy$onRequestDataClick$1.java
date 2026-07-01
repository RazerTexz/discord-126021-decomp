package com.discord.widgets.settings;

import android.content.Context;
import androidx.fragment.app.FragmentManager;
import com.discord.models.domain.Harvest;
import com.discord.utilities.rest.RestAPI$HarvestState$LastRequested;
import com.discord.widgets.notice.WidgetNoticeDialog$Builder;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetSettingsPrivacy.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsPrivacy$onRequestDataClick$1 extends o implements Function1<Harvest, Unit> {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ WidgetSettingsPrivacy this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsPrivacy$onRequestDataClick$1(WidgetSettingsPrivacy widgetSettingsPrivacy, Context context) {
        super(1);
        this.this$0 = widgetSettingsPrivacy;
        this.$context = context;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Harvest harvest) {
        invoke2(harvest);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Harvest harvest) {
        m.checkNotNullParameter(harvest, "requestedHarvest");
        WidgetNoticeDialog$Builder positiveButton$default = WidgetNoticeDialog$Builder.setPositiveButton$default(new WidgetNoticeDialog$Builder(this.$context).setTitle(2131888346).setMessage(2131888345), 2131893499, (Function1) null, 2, (Object) null);
        FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        positiveButton$default.show(parentFragmentManager);
        WidgetSettingsPrivacy.access$configureRequestDataButton(this.this$0, true, new RestAPI$HarvestState$LastRequested(harvest));
    }
}
