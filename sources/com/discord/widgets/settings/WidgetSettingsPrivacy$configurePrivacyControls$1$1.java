package com.discord.widgets.settings;

import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function5;

/* JADX INFO: compiled from: WidgetSettingsPrivacy.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsPrivacy$configurePrivacyControls$1$1 extends o implements Function5<AlertDialog, TextView, TextView, TextView, TextView, Unit> {
    public final /* synthetic */ Boolean $consented;
    public final /* synthetic */ WidgetSettingsPrivacy$configurePrivacyControls$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsPrivacy$configurePrivacyControls$1$1(WidgetSettingsPrivacy$configurePrivacyControls$1 widgetSettingsPrivacy$configurePrivacyControls$1, Boolean bool) {
        super(5);
        this.this$0 = widgetSettingsPrivacy$configurePrivacyControls$1;
        this.$consented = bool;
    }

    @Override // kotlin.jvm.functions.Function5
    public /* bridge */ /* synthetic */ Unit invoke(AlertDialog alertDialog, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        invoke2(alertDialog, textView, textView2, textView3, textView4);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(AlertDialog alertDialog, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        m.checkNotNullParameter(alertDialog, "dialog");
        m.checkNotNullParameter(textView, "dialogHeader");
        m.checkNotNullParameter(textView2, "dialogBody");
        m.checkNotNullParameter(textView3, "dialogCancel");
        m.checkNotNullParameter(textView4, "dialogConfirm");
        textView.setText(2131896693);
        textView2.setText(2131896690);
        textView3.setText(2131896691);
        textView3.setOnClickListener(new WidgetSettingsPrivacy$configurePrivacyControls$1$1$1(this, alertDialog));
        textView4.setText(2131896692);
        textView4.setOnClickListener(new WidgetSettingsPrivacy$configurePrivacyControls$1$1$2(this, alertDialog));
    }
}
