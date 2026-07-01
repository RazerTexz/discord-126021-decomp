package com.discord.widgets.servers;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetServerSettingsEditMember.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsEditMember$configureUI$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetServerSettingsEditMember$Model $data;
    public final /* synthetic */ WidgetServerSettingsEditMember this$0;

    public WidgetServerSettingsEditMember$configureUI$1(WidgetServerSettingsEditMember widgetServerSettingsEditMember, WidgetServerSettingsEditMember$Model widgetServerSettingsEditMember$Model) {
        this.this$0 = widgetServerSettingsEditMember;
        this.$data = widgetServerSettingsEditMember$Model;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        TextInputLayout textInputLayout = WidgetServerSettingsEditMember.access$getBinding$p(this.this$0).e;
        m.checkNotNullExpressionValue(textInputLayout, "binding.editMemberNickname");
        TextInputLayout textInputLayout2 = WidgetServerSettingsEditMember.access$getBinding$p(this.this$0).e;
        m.checkNotNullExpressionValue(textInputLayout2, "binding.editMemberNickname");
        String textOrEmpty = ViewExtensions.getTextOrEmpty(textInputLayout2);
        int length = textOrEmpty.length() - 1;
        int i = 0;
        boolean z2 = false;
        while (i <= length) {
            boolean z3 = m.compare(textOrEmpty.charAt(!z2 ? i : length), 32) <= 0;
            if (z2) {
                if (!z3) {
                    break;
                } else {
                    length--;
                }
            } else if (z3) {
                i++;
            } else {
                z2 = true;
            }
        }
        ViewExtensions.setText(textInputLayout, textOrEmpty.subSequence(i, length + 1).toString());
        WidgetServerSettingsEditMember widgetServerSettingsEditMember = this.this$0;
        WidgetServerSettingsEditMember$Model widgetServerSettingsEditMember$Model = this.$data;
        TextInputLayout textInputLayout3 = WidgetServerSettingsEditMember.access$getBinding$p(widgetServerSettingsEditMember).e;
        m.checkNotNullExpressionValue(textInputLayout3, "binding.editMemberNickname");
        WidgetServerSettingsEditMember.access$changeNickname(widgetServerSettingsEditMember, widgetServerSettingsEditMember$Model, ViewExtensions.getTextOrEmpty(textInputLayout3));
    }
}
