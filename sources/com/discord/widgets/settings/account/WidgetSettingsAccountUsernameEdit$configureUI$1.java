package com.discord.widgets.settings.account;

import android.view.View;
import android.view.View$OnFocusChangeListener;
import androidx.fragment.app.FragmentManager;
import b.a.a.b.c;
import b.a.a.b.c$b;
import com.discord.utilities.analytics.Traits$Location$Page;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetSettingsAccountUsernameEdit.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsAccountUsernameEdit$configureUI$1 implements View$OnFocusChangeListener {
    public final /* synthetic */ WidgetSettingsAccountUsernameEdit this$0;

    public WidgetSettingsAccountUsernameEdit$configureUI$1(WidgetSettingsAccountUsernameEdit widgetSettingsAccountUsernameEdit) {
        this.this$0 = widgetSettingsAccountUsernameEdit;
    }

    @Override // android.view.View$OnFocusChangeListener
    public final void onFocusChange(View view, boolean z2) {
        if (z2) {
            WidgetSettingsAccountUsernameEdit.access$getBinding$p(this.this$0).f2598b.post(new WidgetSettingsAccountUsernameEdit$configureUI$1$1(this));
            c$b c_b = c.k;
            FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
            m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            c$b.a(c_b, parentFragmentManager, 0, this.this$0.getString(2131894515), null, Traits$Location$Page.USER_SETTINGS, "Edit Account", null, null, false, false, 968);
        }
    }
}
