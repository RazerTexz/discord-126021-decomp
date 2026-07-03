package com.discord.widgets.auth;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.app.LoggingConfig;
import com.discord.databinding.WidgetAuthAgeGatedBinding;
import com.discord.utilities.auth.RegistrationFlowRepo;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0870j;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetAuthAgeGated.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAuthAgeGated extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetAuthAgeGated.class, "binding", "getBinding()Lcom/discord/databinding/WidgetAuthAgeGatedBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_UNDERAGE_MESSAGE = "INTENT_UNDERAGE_MESSAGE";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final LoggingConfig loggingConfig;

    /* JADX INFO: compiled from: WidgetAuthAgeGated.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void start(Context context, String message) {
            C12238m.checkNotNullParameter(context, "context");
            C12238m.checkNotNullParameter(message, "message");
            Bundle bundle = new Bundle();
            bundle.putString(WidgetAuthAgeGated.INTENT_UNDERAGE_MESSAGE, message);
            C0870j.m156d(context, WidgetAuthAgeGated.class, new Intent().putExtras(bundle));
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public WidgetAuthAgeGated() {
        super(C5419R.layout.widget_auth_age_gated);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetAuthAgeGated$binding$2.INSTANCE, null, 2, null);
        this.loggingConfig = new LoggingConfig(false, null, WidgetAuthAgeGated$loggingConfig$1.INSTANCE, 3);
    }

    private final WidgetAuthAgeGatedBinding getBinding() {
        return (WidgetAuthAgeGatedBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger.InterfaceC5455a
    public LoggingConfig getLoggingConfig() {
        return this.loggingConfig;
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        RegistrationFlowRepo.trackTransition$default(RegistrationFlowRepo.INSTANCE.getINSTANCE(), "Age Gate Underage", "viewed", null, 4, null);
        getBinding().f15669b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.auth.WidgetAuthAgeGated.onViewBound.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetAuthAgeGated.this.requireActivity().finish();
            }
        });
    }
}
