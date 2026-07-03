package com.discord.widgets.auth;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetAuthResetPasswordBinding;
import com.discord.utilities.uri.UriHandler;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0870j;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetAuthResetPassword.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAuthResetPassword extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetAuthResetPassword.class, "binding", "getBinding()Lcom/discord/databinding/WidgetAuthResetPasswordBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_TOKEN = "INTENT_EXTRA_TOKEN";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private String token;

    /* JADX INFO: compiled from: WidgetAuthResetPassword.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void start(Context context, String token) {
            C12238m.checkNotNullParameter(context, "context");
            C12238m.checkNotNullParameter(token, "token");
            Intent intent = new Intent();
            intent.putExtra(WidgetAuthResetPassword.INTENT_EXTRA_TOKEN, token);
            C0870j.m156d(context, WidgetAuthResetPassword.class, intent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public WidgetAuthResetPassword() {
        super(C5419R.layout.widget_auth_reset_password);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetAuthResetPassword$binding$2.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ String access$getToken$p(WidgetAuthResetPassword widgetAuthResetPassword) {
        String str = widgetAuthResetPassword.token;
        if (str == null) {
            C12238m.throwUninitializedPropertyAccessException("token");
        }
        return str;
    }

    private final WidgetAuthResetPasswordBinding getBinding() {
        return (WidgetAuthResetPasswordBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        String stringExtra = getMostRecentIntent().getStringExtra(INTENT_EXTRA_TOKEN);
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.token = stringExtra;
        getBinding().f15718c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.auth.WidgetAuthResetPassword.onViewBound.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                UriHandler uriHandler = UriHandler.INSTANCE;
                Context contextRequireContext = WidgetAuthResetPassword.this.requireContext();
                StringBuilder sbM833U = C1643a.m833U("https://discord.com/reset#token=");
                sbM833U.append(WidgetAuthResetPassword.access$getToken$p(WidgetAuthResetPassword.this));
                UriHandler.handle$default(uriHandler, contextRequireContext, sbM833U.toString(), false, false, null, 28, null);
                WidgetAuthResetPassword.this.requireActivity().finish();
            }
        });
        getBinding().f15717b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.auth.WidgetAuthResetPassword.onViewBound.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetAuthResetPassword.this.requireActivity().finish();
            }
        });
    }
}
