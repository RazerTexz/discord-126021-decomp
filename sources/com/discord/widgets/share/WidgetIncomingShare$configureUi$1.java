package com.discord.widgets.share;

import android.content.Context;
import android.view.KeyEvent;
import android.widget.TextView;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: WidgetIncomingShare.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetIncomingShare$configureUi$1 extends o implements Function3<TextView, Integer, KeyEvent, Boolean> {
    public final /* synthetic */ WidgetIncomingShare$Model $this_configureUi;
    public final /* synthetic */ WidgetIncomingShare this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetIncomingShare$configureUi$1(WidgetIncomingShare widgetIncomingShare, WidgetIncomingShare$Model widgetIncomingShare$Model) {
        super(3);
        this.this$0 = widgetIncomingShare;
        this.$this_configureUi = widgetIncomingShare$Model;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Boolean invoke(TextView textView, Integer num, KeyEvent keyEvent) {
        return Boolean.valueOf(invoke(textView, num.intValue(), keyEvent));
    }

    public final boolean invoke(TextView textView, int i, KeyEvent keyEvent) {
        m.checkNotNullParameter(textView, "<anonymous parameter 0>");
        if (i != 4 || this.$this_configureUi.getReceiver() == null) {
            return false;
        }
        WidgetIncomingShare widgetIncomingShare = this.this$0;
        TextInputLayout textInputLayout = WidgetIncomingShare.access$getBinding$p(widgetIncomingShare).d;
        m.checkNotNullExpressionValue(textInputLayout, "binding.externalShareComment");
        Context context = textInputLayout.getContext();
        m.checkNotNullExpressionValue(context, "binding.externalShareComment.context");
        WidgetIncomingShare.onSendClicked$default(widgetIncomingShare, context, this.$this_configureUi.getReceiver(), this.$this_configureUi.getGameInviteModel(), this.$this_configureUi.getContentModel(), this.$this_configureUi.getIsOnCooldown(), this.$this_configureUi.getMaxFileSizeMB(), this.$this_configureUi.getIsUserPremium(), null, 128, null);
        return true;
    }
}
