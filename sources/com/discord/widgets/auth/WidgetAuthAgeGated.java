package com.discord.widgets.auth;

import android.view.View;
import androidx.fragment.app.Fragment;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppFragment;
import com.discord.app.LoggingConfig;
import com.discord.databinding.WidgetAuthAgeGatedBinding;
import com.discord.utilities.auth.RegistrationFlowRepo;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import d0.z.d.m;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetAuthAgeGated.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAuthAgeGated extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetAuthAgeGated.class, "binding", "getBinding()Lcom/discord/databinding/WidgetAuthAgeGatedBinding;", 0)};
    public static final WidgetAuthAgeGated$Companion Companion = new WidgetAuthAgeGated$Companion(null);
    private static final String INTENT_UNDERAGE_MESSAGE = "INTENT_UNDERAGE_MESSAGE";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final LoggingConfig loggingConfig;

    public WidgetAuthAgeGated() {
        super(R$layout.widget_auth_age_gated);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetAuthAgeGated$binding$2.INSTANCE, null, 2, null);
        this.loggingConfig = new LoggingConfig(false, null, WidgetAuthAgeGated$loggingConfig$1.INSTANCE, 3);
    }

    private final WidgetAuthAgeGatedBinding getBinding() {
        return (WidgetAuthAgeGatedBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger$a
    public LoggingConfig getLoggingConfig() {
        return this.loggingConfig;
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        RegistrationFlowRepo.trackTransition$default(RegistrationFlowRepo.Companion.getINSTANCE(), "Age Gate Underage", "viewed", null, 4, null);
        getBinding().f2229b.setOnClickListener(new WidgetAuthAgeGated$onViewBound$1(this));
    }
}
