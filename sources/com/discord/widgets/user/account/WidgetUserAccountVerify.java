package com.discord.widgets.user.account;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import b.a.d.AppHelpDesk;
import b.a.d.AppScreen2;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetUserAccountVerifyBinding;
import com.discord.models.requiredaction.RequiredAction;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.user.account.WidgetUserAccountVerifyBase;
import com.discord.widgets.user.email.WidgetUserEmailVerify;
import com.discord.widgets.user.phone.WidgetUserPhoneManage;
import d0.z.d.Intrinsics3;
import d0.z.d.PropertyReference0Impl;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.functions.Func0;

/* JADX INFO: compiled from: WidgetUserAccountVerify.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserAccountVerify extends WidgetUserAccountVerifyBase {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetUserAccountVerify.class, "binding", "getBinding()Lcom/discord/databinding/WidgetUserAccountVerifyBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: compiled from: WidgetUserAccountVerify.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context, RequiredAction action) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(action, "action");
            Intent launchIntent = WidgetUserAccountVerifyBase.INSTANCE.getLaunchIntent(WidgetUserAccountVerifyBase.Mode.FORCED, action == RequiredAction.REQUIRE_VERIFIED_PHONE || action == RequiredAction.REQUIRE_VERIFIED_EMAIL || action == RequiredAction.REQUIRE_CAPTCHA, action == RequiredAction.REQUIRE_VERIFIED_EMAIL);
            AnalyticsTracker.openModal$default("Suspicious Activity", "", null, 4, null);
            AppScreen2.d(context, WidgetUserAccountVerify.class, launchIntent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public WidgetUserAccountVerify() {
        super(R.layout.widget_user_account_verify);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetUserAccountVerify2.INSTANCE, null, 2, null);
    }

    private final WidgetUserAccountVerifyBinding getBinding() {
        return (WidgetUserAccountVerifyBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.widgets.user.account.WidgetUserAccountVerifyBase, com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        final PropertyReference0Impl propertyReference0Impl = new PropertyReference0Impl(this) { // from class: com.discord.widgets.user.account.WidgetUserAccountVerify.onViewBound.1
            @Override // d0.z.d.PropertyReference0Impl, kotlin.reflect.KProperty6
            public Object get() {
                return Boolean.valueOf(((WidgetUserAccountVerify) this.receiver).isForced());
            }
        };
        AppFragment.setOnBackPressed$default(this, new Func0() { // from class: com.discord.widgets.user.account.WidgetUserAccountVerify$sam$rx_functions_Func0$0
            @Override // rx.functions.Func0, java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                return propertyReference0Impl.invoke();
            }
        }, 0, 2, null);
        WidgetUserAccountVerifyBinding binding = getBinding();
        TextView textView = binding.e;
        Intrinsics3.checkNotNullExpressionValue(textView, "verifyAccountTextBody");
        textView.setText(FormatUtils.e(this, R.string.verification_body, new Object[0], (4 & 4) != 0 ? FormatUtils.a.j : null));
        LinkifiedTextView linkifiedTextView = binding.d;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "verifyAccountSupport");
        linkifiedTextView.setText(FormatUtils.e(this, R.string.verification_footer_support, new Object[]{AppHelpDesk.c()}, (4 & 4) != 0 ? FormatUtils.a.j : null));
        RelativeLayout relativeLayout = binding.f2679b;
        relativeLayout.setVisibility(getIsEmailAllowed() ? 0 : 8);
        relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.user.account.WidgetUserAccountVerify$onViewBound$$inlined$with$lambda$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                Intrinsics3.checkNotNullParameter(view2, "v");
                WidgetUserEmailVerify.Companion companion = WidgetUserEmailVerify.INSTANCE;
                Context context = view2.getContext();
                Intrinsics3.checkNotNullExpressionValue(context, "v.context");
                companion.launch(context, this.this$0.getMode());
            }
        });
        RelativeLayout relativeLayout2 = binding.c;
        relativeLayout2.setVisibility(getIsPhoneAllowed() ? 0 : 8);
        relativeLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.user.account.WidgetUserAccountVerify$onViewBound$$inlined$with$lambda$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                Intrinsics3.checkNotNullParameter(view2, "v");
                WidgetUserPhoneManage.Companion companion = WidgetUserPhoneManage.INSTANCE;
                Context context = view2.getContext();
                Intrinsics3.checkNotNullExpressionValue(context, "v.context");
                companion.launch(context, this.this$0.getMode(), WidgetUserPhoneManage.Companion.Source.USER_ACTION_REQUIRED);
            }
        });
    }
}
