package com.discord.widgets.settings;

import android.content.Context;
import androidx.fragment.app.FragmentManager;
import com.discord.widgets.notice.WidgetNoticeDialog$Builder;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetSettingsPrivacy.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsPrivacy$onRequestDataClick$4 extends o implements Function0<Unit> {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ WidgetSettingsPrivacy$onRequestDataClick$3 $requestHarvest$3;
    public final /* synthetic */ WidgetSettingsPrivacy this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsPrivacy$onRequestDataClick$4(WidgetSettingsPrivacy widgetSettingsPrivacy, Context context, WidgetSettingsPrivacy$onRequestDataClick$3 widgetSettingsPrivacy$onRequestDataClick$3) {
        super(0);
        this.this$0 = widgetSettingsPrivacy;
        this.$context = context;
        this.$requestHarvest$3 = widgetSettingsPrivacy$onRequestDataClick$3;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        WidgetNoticeDialog$Builder negativeButton$default = WidgetNoticeDialog$Builder.setNegativeButton$default(new WidgetNoticeDialog$Builder(this.$context).setTitle(2131888336).setMessage(2131888341).setPositiveButton(2131893499, new WidgetSettingsPrivacy$onRequestDataClick$4$1(this)), 2131887437, (Function1) null, 2, (Object) null);
        FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        negativeButton$default.show(parentFragmentManager);
    }
}
