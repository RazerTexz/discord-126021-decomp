package com.discord.widgets.user.account;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import b.a.d.f;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetUserAccountVerifyBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import d0.z.d.m;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetUserAccountVerify.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserAccountVerify extends WidgetUserAccountVerifyBase {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetUserAccountVerify.class, "binding", "getBinding()Lcom/discord/databinding/WidgetUserAccountVerifyBinding;", 0)};
    public static final WidgetUserAccountVerify$Companion Companion = new WidgetUserAccountVerify$Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    public WidgetUserAccountVerify() {
        super(R$layout.widget_user_account_verify);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetUserAccountVerify$binding$2.INSTANCE, null, 2, null);
    }

    private final WidgetUserAccountVerifyBinding getBinding() {
        return (WidgetUserAccountVerifyBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.widgets.user.account.WidgetUserAccountVerifyBase, com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setOnBackPressed$default(this, new WidgetUserAccountVerify$sam$rx_functions_Func0$0(new WidgetUserAccountVerify$onViewBound$1(this)), 0, 2, null);
        WidgetUserAccountVerifyBinding binding = getBinding();
        TextView textView = binding.e;
        m.checkNotNullExpressionValue(textView, "verifyAccountTextBody");
        textView.setText(b.k(this, 2131897031, new Object[0], null, 4));
        LinkifiedTextView linkifiedTextView = binding.d;
        m.checkNotNullExpressionValue(linkifiedTextView, "verifyAccountSupport");
        linkifiedTextView.setText(b.k(this, 2131897040, new Object[]{f.c()}, null, 4));
        RelativeLayout relativeLayout = binding.f2679b;
        relativeLayout.setVisibility(getIsEmailAllowed() ? 0 : 8);
        relativeLayout.setOnClickListener(new WidgetUserAccountVerify$onViewBound$$inlined$with$lambda$1(this));
        RelativeLayout relativeLayout2 = binding.c;
        relativeLayout2.setVisibility(getIsPhoneAllowed() ? 0 : 8);
        relativeLayout2.setOnClickListener(new WidgetUserAccountVerify$onViewBound$$inlined$with$lambda$2(this));
    }
}
