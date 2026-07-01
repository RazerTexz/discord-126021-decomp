package com.discord.widgets.auth;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.fragment.app.Fragment;
import b.a.d.AppScreen2;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetAuthResetPasswordBinding;
import com.discord.utilities.uri.UriHandler;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import d0.z.d.Intrinsics3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetAuthResetPassword.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAuthResetPassword extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetAuthResetPassword.class, "binding", "getBinding()Lcom/discord/databinding/WidgetAuthResetPasswordBinding;", 0)};

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
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(token, "token");
            Intent intent = new Intent();
            intent.putExtra(WidgetAuthResetPassword.INTENT_EXTRA_TOKEN, token);
            AppScreen2.d(context, WidgetAuthResetPassword.class, intent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public WidgetAuthResetPassword() {
        super(R.layout.widget_auth_reset_password);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetAuthResetPassword2.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ String access$getToken$p(WidgetAuthResetPassword widgetAuthResetPassword) {
        String str = widgetAuthResetPassword.token;
        if (str == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("token");
        }
        return str;
    }

    private final WidgetAuthResetPasswordBinding getBinding() {
        return (WidgetAuthResetPasswordBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        String stringExtra = getMostRecentIntent().getStringExtra(INTENT_EXTRA_TOKEN);
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.token = stringExtra;
        getBinding().c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.auth.WidgetAuthResetPassword.onViewBound.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                UriHandler uriHandler = UriHandler.INSTANCE;
                Context contextRequireContext = WidgetAuthResetPassword.this.requireContext();
                StringBuilder sbU = outline.U("https://discord.com/reset#token=");
                sbU.append(WidgetAuthResetPassword.access$getToken$p(WidgetAuthResetPassword.this));
                UriHandler.handle$default(uriHandler, contextRequireContext, sbU.toString(), false, false, null, 28, null);
                WidgetAuthResetPassword.this.requireActivity().finish();
            }
        });
        getBinding().f2238b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.auth.WidgetAuthResetPassword.onViewBound.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetAuthResetPassword.this.requireActivity().finish();
            }
        });
    }
}
