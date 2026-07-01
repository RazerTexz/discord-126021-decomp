package com.discord.widgets.auth;

import android.view.View;
import androidx.fragment.app.Fragment;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetAuthUndeleteAccountBinding;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.ScreenTitleView;
import d0.z.d.m;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetAuthUndeleteAccount.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAuthUndeleteAccount extends AppFragment {
    private static final String ARG_DISABLED_KEY = "ARG_DISABLED_KEY";
    private static final String RESULT_EXTRA_UNDELETE = "RESULT_EXTRA_UNDELETE";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetAuthUndeleteAccount.class, "binding", "getBinding()Lcom/discord/databinding/WidgetAuthUndeleteAccountBinding;", 0)};
    public static final WidgetAuthUndeleteAccount$Companion Companion = new WidgetAuthUndeleteAccount$Companion(null);

    public WidgetAuthUndeleteAccount() {
        super(R$layout.widget_auth_undelete_account);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetAuthUndeleteAccount$binding$2.INSTANCE, null, 2, null);
    }

    private final WidgetAuthUndeleteAccountBinding getBinding() {
        return (WidgetAuthUndeleteAccountBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        if (getMostRecentIntent().getBooleanExtra(ARG_DISABLED_KEY, false)) {
            ScreenTitleView screenTitleView = getBinding().d;
            String string = getString(2131886200);
            m.checkNotNullExpressionValue(string, "getString(R.string.account_disabled_title)");
            screenTitleView.setTitle(string);
            getBinding().d.setSubtitle(getString(2131886199));
        } else {
            ScreenTitleView screenTitleView2 = getBinding().d;
            String string2 = getString(2131886205);
            m.checkNotNullExpressionValue(string2, "getString(R.string.accou…duled_for_deletion_title)");
            screenTitleView2.setTitle(string2);
            getBinding().d.setSubtitle(getString(2131886204));
        }
        getBinding().c.setOnClickListener(WidgetAuthUndeleteAccount$onViewBoundOrOnResume$1.INSTANCE);
        getBinding().f2239b.setOnClickListener(new WidgetAuthUndeleteAccount$onViewBoundOrOnResume$2(this));
    }
}
