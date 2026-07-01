package com.discord.widgets.settings.account.mfa;

import android.view.View;
import androidx.fragment.app.Fragment;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetSettingsEnableMfaSuccessBinding;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import d0.z.d.m;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetEnableMFASuccess.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEnableMFASuccess extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetEnableMFASuccess.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsEnableMfaSuccessBinding;", 0)};

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    public WidgetEnableMFASuccess() {
        super(R$layout.widget_settings_enable_mfa_success);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetEnableMFASuccess$binding$2.INSTANCE, null, 2, null);
    }

    private final WidgetSettingsEnableMfaSuccessBinding getBinding() {
        return (WidgetSettingsEnableMfaSuccessBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        getBinding().f2619b.setOnClickListener(new WidgetEnableMFASuccess$onViewBound$1(this));
    }
}
