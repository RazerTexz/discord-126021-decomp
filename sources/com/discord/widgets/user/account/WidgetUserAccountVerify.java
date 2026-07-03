package com.discord.widgets.user.account;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetUserAccountVerifyBinding;
import com.discord.models.requiredaction.RequiredAction;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.user.account.WidgetUserAccountVerifyBase;
import com.discord.widgets.user.email.WidgetUserEmailVerify;
import com.discord.widgets.user.phone.WidgetUserPhoneManage;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0862f;
import p007b.p008a.p018d.C0870j;
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;
import p507d0.p592z.p594d.C12248w;
import p658rx.functions.Func0;

/* JADX INFO: compiled from: WidgetUserAccountVerify.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserAccountVerify extends WidgetUserAccountVerifyBase {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetUserAccountVerify.class, "binding", "getBinding()Lcom/discord/databinding/WidgetUserAccountVerifyBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: compiled from: WidgetUserAccountVerify.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context, RequiredAction action) {
            C12238m.checkNotNullParameter(context, "context");
            C12238m.checkNotNullParameter(action, "action");
            Intent launchIntent = WidgetUserAccountVerifyBase.INSTANCE.getLaunchIntent(WidgetUserAccountVerifyBase.Mode.FORCED, action == RequiredAction.REQUIRE_VERIFIED_PHONE || action == RequiredAction.REQUIRE_VERIFIED_EMAIL || action == RequiredAction.REQUIRE_CAPTCHA, action == RequiredAction.REQUIRE_VERIFIED_EMAIL);
            AnalyticsTracker.openModal$default("Suspicious Activity", "", null, 4, null);
            C0870j.m156d(context, WidgetUserAccountVerify.class, launchIntent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public WidgetUserAccountVerify() {
        super(C5419R.layout.widget_user_account_verify);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetUserAccountVerify$binding$2.INSTANCE, null, 2, null);
    }

    private final WidgetUserAccountVerifyBinding getBinding() {
        return (WidgetUserAccountVerifyBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.widgets.user.account.WidgetUserAccountVerifyBase, com.discord.app.AppFragment
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        final C12248w c12248w = new C12248w(this) { // from class: com.discord.widgets.user.account.WidgetUserAccountVerify.onViewBound.1
            @Override // p507d0.p592z.p594d.C12248w, kotlin.reflect.KProperty0
            public Object get() {
                return Boolean.valueOf(((WidgetUserAccountVerify) this.receiver).isForced());
            }
        };
        AppFragment.setOnBackPressed$default(this, new Func0() { // from class: com.discord.widgets.user.account.WidgetUserAccountVerify$sam$rx_functions_Func0$0
            @Override // p658rx.functions.Func0, java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                return c12248w.invoke();
            }
        }, 0, 2, null);
        WidgetUserAccountVerifyBinding binding = getBinding();
        TextView textView = binding.f18324e;
        C12238m.checkNotNullExpressionValue(textView, "verifyAccountTextBody");
        textView.setText(C1107b.m213e(this, C5419R.string.verification_body, new Object[0], (4 & 4) != 0 ? C1107b.a.f1490j : null));
        LinkifiedTextView linkifiedTextView = binding.f18323d;
        C12238m.checkNotNullExpressionValue(linkifiedTextView, "verifyAccountSupport");
        linkifiedTextView.setText(C1107b.m213e(this, C5419R.string.verification_footer_support, new Object[]{C0862f.m148c()}, (4 & 4) != 0 ? C1107b.a.f1490j : null));
        RelativeLayout relativeLayout = binding.f18321b;
        relativeLayout.setVisibility(getIsEmailAllowed() ? 0 : 8);
        relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.user.account.WidgetUserAccountVerify$onViewBound$$inlined$with$lambda$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                C12238m.checkNotNullParameter(view2, "v");
                WidgetUserEmailVerify.Companion companion = WidgetUserEmailVerify.INSTANCE;
                Context context = view2.getContext();
                C12238m.checkNotNullExpressionValue(context, "v.context");
                companion.launch(context, this.this$0.getMode());
            }
        });
        RelativeLayout relativeLayout2 = binding.f18322c;
        relativeLayout2.setVisibility(getIsPhoneAllowed() ? 0 : 8);
        relativeLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.user.account.WidgetUserAccountVerify$onViewBound$$inlined$with$lambda$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                C12238m.checkNotNullParameter(view2, "v");
                WidgetUserPhoneManage.Companion companion = WidgetUserPhoneManage.INSTANCE;
                Context context = view2.getContext();
                C12238m.checkNotNullExpressionValue(context, "v.context");
                companion.launch(context, this.this$0.getMode(), WidgetUserPhoneManage.Companion.Source.USER_ACTION_REQUIRED);
            }
        });
    }
}
