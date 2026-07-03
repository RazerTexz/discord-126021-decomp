package com.discord.widgets.hubs;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.C5419R;
import com.discord.api.hubs.EmailVerification;
import com.discord.api.hubs.EmailVerificationCode;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetHubAuthenticationBinding;
import com.discord.i18n.RenderContext;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreStream;
import com.discord.stores.utilities.RestCallStateKt;
import com.discord.stores.utilities.Success;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.CodeVerificationView;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0865g0;
import p007b.p008a.p018d.C0869i0;
import p007b.p008a.p018d.C0876m;
import p007b.p008a.p027k.C1107b;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12083g;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p658rx.Subscription;

/* JADX INFO: compiled from: WidgetHubAuthentication.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubAuthentication extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetHubAuthentication.class, "binding", "getBinding()Lcom/discord/databinding/WidgetHubAuthenticationBinding;", 0)};

    /* JADX INFO: renamed from: args$delegate, reason: from kotlin metadata */
    private final Lazy args;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: renamed from: com.discord.widgets.hubs.WidgetHubAuthentication$configureUi$1 */
    /* JADX INFO: compiled from: WidgetHubAuthentication.kt */
    public static final class C90001 extends AbstractC12240o implements Function1<Success<? extends EmailVerificationCode>, Unit> {
        public C90001() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Success<? extends EmailVerificationCode> success) {
            invoke2((Success<EmailVerificationCode>) success);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Success<EmailVerificationCode> success) {
            C12238m.checkNotNullParameter(success, "response");
            WidgetHubAuthentication widgetHubAuthentication = WidgetHubAuthentication.this;
            widgetHubAuthentication.hideKeyboard(widgetHubAuthentication.getView());
            EmailVerificationCode emailVerificationCodeInvoke = success.invoke();
            if (!emailVerificationCodeInvoke.getJoined()) {
                C0876m.m171i(WidgetHubAuthentication.this, C5419R.string.error_generic_title, 0, 4);
                return;
            }
            FragmentActivity fragmentActivityM95e = WidgetHubAuthentication.this.m95e();
            if (fragmentActivityM95e != null) {
                fragmentActivityM95e.setResult(-1, C1460d.m522g2(new AuthenticationResult(emailVerificationCodeInvoke.getGuild().getId())));
                fragmentActivityM95e.finish();
            }
            StoreStream.INSTANCE.getNux().updateNux(WidgetHubAuthentication$configureUi$1$1$2.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.hubs.WidgetHubAuthentication$configureUi$2 */
    /* JADX INFO: compiled from: WidgetHubAuthentication.kt */
    public static final class C90012 extends AbstractC12240o implements Function1<Success<? extends EmailVerification>, Unit> {
        public C90012() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Success<? extends EmailVerification> success) {
            invoke2((Success<EmailVerification>) success);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Success<EmailVerification> success) {
            C12238m.checkNotNullParameter(success, "it");
            C0876m.m171i(WidgetHubAuthentication.this, C5419R.string.member_verification_email_verification_email_sent, 0, 4);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.hubs.WidgetHubAuthentication$onViewBound$1 */
    /* JADX INFO: compiled from: WidgetHubAuthentication.kt */
    public static final class C90021 extends AbstractC12240o implements Function1<String, Unit> {
        public C90021() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            C12238m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_CODE);
            WidgetHubAuthentication.this.getViewModel().verifyCode(str);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.hubs.WidgetHubAuthentication$onViewBound$2 */
    /* JADX INFO: compiled from: WidgetHubAuthentication.kt */
    public static final class C90032 extends AbstractC12240o implements Function1<RenderContext, Unit> {

        /* JADX INFO: renamed from: com.discord.widgets.hubs.WidgetHubAuthentication$onViewBound$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetHubAuthentication.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function1<View, Unit> {
            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                C12238m.checkNotNullParameter(view, "it");
                WidgetHubAuthentication.this.getViewModel().resendEmail();
            }
        }

        public C90032() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            C12238m.checkNotNullParameter(renderContext, "$receiver");
            renderContext.m8423b("onClick", new AnonymousClass1());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.hubs.WidgetHubAuthentication$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetHubAuthentication.kt */
    public static final /* synthetic */ class C90041 extends C12236k implements Function1<HubAuthenticationState, Unit> {
        public C90041(WidgetHubAuthentication widgetHubAuthentication) {
            super(1, widgetHubAuthentication, WidgetHubAuthentication.class, "configureUi", "configureUi(Lcom/discord/widgets/hubs/HubAuthenticationState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(HubAuthenticationState hubAuthenticationState) {
            invoke2(hubAuthenticationState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(HubAuthenticationState hubAuthenticationState) {
            C12238m.checkNotNullParameter(hubAuthenticationState, "p1");
            ((WidgetHubAuthentication) this.receiver).configureUi(hubAuthenticationState);
        }
    }

    public WidgetHubAuthentication() {
        super(C5419R.layout.widget_hub_authentication);
        this.args = C12083g.lazy(new WidgetHubAuthentication$$special$$inlined$args$1(this, "intent_args_key"));
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetHubAuthentication$binding$2.INSTANCE, null, 2, null);
        WidgetHubAuthentication$viewModel$2 widgetHubAuthentication$viewModel$2 = new WidgetHubAuthentication$viewModel$2(this);
        C0865g0 c0865g0 = new C0865g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(WidgetHubAuthenticationViewModel.class), new WidgetHubAuthentication$appViewModels$$inlined$viewModels$1(c0865g0), new C0869i0(widgetHubAuthentication$viewModel$2));
    }

    private final void configureUi(HubAuthenticationState state) {
        Context context = getContext();
        if (context != null) {
            C12238m.checkNotNullExpressionValue(context, "context ?: return");
            RestCallStateKt.handleResponse$default(state.getAuthenticationAsync(), context, null, null, new C90001(), 6, null);
            RestCallStateKt.handleResponse$default(state.getResendEmailAsync(), context, null, null, new C90012(), 6, null);
        }
    }

    private final WidgetHubAuthenticationBinding getBinding() {
        return (WidgetHubAuthenticationBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetHubAuthenticationViewModel getViewModel() {
        return (WidgetHubAuthenticationViewModel) this.viewModel.getValue();
    }

    public final HubAuthenticationArgs getArgs() {
        return (HubAuthenticationArgs) this.args.getValue();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        getBinding().f17153c.setOnCodeEntered(new C90021());
        LinkifiedTextView linkifiedTextView = getBinding().f17152b;
        C12238m.checkNotNullExpressionValue(linkifiedTextView, "binding.description");
        linkifiedTextView.setText(C1107b.m213e(this, C5419R.string.hub_pin_description, new Object[]{getArgs().getEmail()}, new C90032()));
        CodeVerificationView codeVerificationView = getBinding().f17153c;
        C12238m.checkNotNullExpressionValue(codeVerificationView, "binding.verification");
        showKeyboard(codeVerificationView);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), (Class<?>) WidgetHubAuthentication.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C90041(this));
    }
}
