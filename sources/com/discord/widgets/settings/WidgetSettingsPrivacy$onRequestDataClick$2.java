package com.discord.widgets.settings;

import android.content.Context;
import androidx.fragment.app.FragmentManager;
import b.a.k.b;
import com.discord.widgets.notice.WidgetNoticeDialog$Builder;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetSettingsPrivacy.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsPrivacy$onRequestDataClick$2 extends o implements Function1<String, Unit> {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ WidgetSettingsPrivacy this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsPrivacy$onRequestDataClick$2(WidgetSettingsPrivacy widgetSettingsPrivacy, Context context) {
        super(1);
        this.this$0 = widgetSettingsPrivacy;
        this.$context = context;
    }

    public static /* synthetic */ void invoke$default(WidgetSettingsPrivacy$onRequestDataClick$2 widgetSettingsPrivacy$onRequestDataClick$2, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        widgetSettingsPrivacy$onRequestDataClick$2.invoke2(str);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String str) {
        invoke2(str);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String str) {
        WidgetNoticeDialog$Builder title = new WidgetNoticeDialog$Builder(this.$context).setTitle(2131888338);
        CharSequence charSequenceH = str;
        if (str == null) {
            charSequenceH = b.h(this.$context, 2131888337, new Object[0], null, 4);
        }
        WidgetNoticeDialog$Builder positiveButton$default = WidgetNoticeDialog$Builder.setPositiveButton$default(title.setMessage(charSequenceH), 2131893499, (Function1) null, 2, (Object) null);
        FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        positiveButton$default.show(parentFragmentManager);
    }
}
