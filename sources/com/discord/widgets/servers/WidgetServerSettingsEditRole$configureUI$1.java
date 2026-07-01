package com.discord.widgets.servers;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.app.AppFragment;
import com.discord.restapi.RestAPIParams$Role;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetServerSettingsEditRole.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsEditRole$configureUI$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetServerSettingsEditRole$Model $data;
    public final /* synthetic */ WidgetServerSettingsEditRole this$0;

    public WidgetServerSettingsEditRole$configureUI$1(WidgetServerSettingsEditRole widgetServerSettingsEditRole, WidgetServerSettingsEditRole$Model widgetServerSettingsEditRole$Model) {
        this.this$0 = widgetServerSettingsEditRole;
        this.$data = widgetServerSettingsEditRole$Model;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        TextInputLayout textInputLayout = WidgetServerSettingsEditRole.access$getBinding$p(this.this$0).f2371b;
        m.checkNotNullExpressionValue(textInputLayout, "binding.editRoleName");
        String textOrEmpty = ViewExtensions.getTextOrEmpty(textInputLayout);
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
        String string = textOrEmpty.subSequence(i, length + 1).toString();
        if (!(string.length() > 0)) {
            b.a.d.m.i(this.this$0, 2131889251, 0, 4);
            return;
        }
        TextInputLayout textInputLayout2 = WidgetServerSettingsEditRole.access$getBinding$p(this.this$0).f2371b;
        m.checkNotNullExpressionValue(textInputLayout2, "binding.editRoleName");
        textInputLayout2.setSelected(false);
        RestAPIParams$Role restAPIParams$RoleCreateWithRole = RestAPIParams$Role.Companion.createWithRole(this.$data.getRole());
        restAPIParams$RoleCreateWithRole.setName(string);
        WidgetServerSettingsEditRole.access$patchRole(this.this$0, this.$data.getGuildId(), restAPIParams$RoleCreateWithRole);
        AppFragment.hideKeyboard$default(this.this$0, null, 1, null);
    }
}
