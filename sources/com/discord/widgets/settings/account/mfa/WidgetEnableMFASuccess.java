package com.discord.widgets.settings.account.mfa;

import android.view.View;
import androidx.fragment.app.Fragment;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetSettingsEnableMfaSuccessBinding;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.user.account.WidgetUserAccountVerifyBase;
import com.discord.widgets.user.phone.WidgetUserPhoneManage;
import d0.z.d.Intrinsics3;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetEnableMFASuccess.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEnableMFASuccess extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetEnableMFASuccess.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsEnableMfaSuccessBinding;", 0)};

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    public WidgetEnableMFASuccess() {
        super(R.layout.widget_settings_enable_mfa_success);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetEnableMFASuccess2.INSTANCE, null, 2, null);
    }

    private final WidgetSettingsEnableMfaSuccessBinding getBinding() {
        return (WidgetSettingsEnableMfaSuccessBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        getBinding().f2619b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.account.mfa.WidgetEnableMFASuccess.onViewBound.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetUserPhoneManage.INSTANCE.launch(outline.x(view2, "it", "it.context"), WidgetUserAccountVerifyBase.Mode.NO_HISTORY_FROM_USER_SETTINGS, WidgetUserPhoneManage.Companion.Source.MFA_PHONE_UPDATE);
                WidgetEnableMFASuccess.this.requireActivity().finish();
            }
        });
    }
}
