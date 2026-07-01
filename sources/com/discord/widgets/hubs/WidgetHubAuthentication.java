package com.discord.widgets.hubs;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.AppToast;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.a.k.FormatUtils;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.hubs.EmailVerification;
import com.discord.api.hubs.EmailVerification2;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetHubAuthenticationBinding;
import com.discord.i18n.RenderContext;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreStream;
import com.discord.stores.utilities.RestCallState5;
import com.discord.stores.utilities.RestCallState6;
import com.discord.utilities.error.Error;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.CodeVerificationView;
import d0.LazyJVM;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.Subscription;

/* JADX INFO: compiled from: WidgetHubAuthentication.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubAuthentication extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetHubAuthentication.class, "binding", "getBinding()Lcom/discord/databinding/WidgetHubAuthenticationBinding;", 0)};

    /* JADX INFO: renamed from: args$delegate, reason: from kotlin metadata */
    private final Lazy args;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: renamed from: com.discord.widgets.hubs.WidgetHubAuthentication$configureUi$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetHubAuthentication.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<RestCallState6<? extends EmailVerification2>, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RestCallState6<? extends EmailVerification2> restCallState6) {
            invoke2((RestCallState6<EmailVerification2>) restCallState6);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RestCallState6<EmailVerification2> restCallState6) {
            Intrinsics3.checkNotNullParameter(restCallState6, "response");
            WidgetHubAuthentication widgetHubAuthentication = WidgetHubAuthentication.this;
            widgetHubAuthentication.hideKeyboard(widgetHubAuthentication.getView());
            EmailVerification2 emailVerification2Invoke = restCallState6.invoke();
            if (!emailVerification2Invoke.getJoined()) {
                AppToast.i(WidgetHubAuthentication.this, R.string.error_generic_title, 0, 4);
                return;
            }
            FragmentActivity fragmentActivityE = WidgetHubAuthentication.this.e();
            if (fragmentActivityE != null) {
                fragmentActivityE.setResult(-1, AnimatableValueParser.g2(new WidgetHubAuthenticationlViewModel(emailVerification2Invoke.getGuild().getId())));
                fragmentActivityE.finish();
            }
            StoreStream.INSTANCE.getNux().updateNux(WidgetHubAuthentication3.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.hubs.WidgetHubAuthentication$configureUi$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetHubAuthentication.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<RestCallState6<? extends EmailVerification>, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RestCallState6<? extends EmailVerification> restCallState6) {
            invoke2((RestCallState6<EmailVerification>) restCallState6);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RestCallState6<EmailVerification> restCallState6) {
            Intrinsics3.checkNotNullParameter(restCallState6, "it");
            AppToast.i(WidgetHubAuthentication.this, R.string.member_verification_email_verification_email_sent, 0, 4);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.hubs.WidgetHubAuthentication$onViewBound$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetHubAuthentication.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<String, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_CODE);
            WidgetHubAuthentication.this.getViewModel().verifyCode(str);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.hubs.WidgetHubAuthentication$onViewBound$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetHubAuthentication.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<RenderContext, Unit> {

        /* JADX INFO: renamed from: com.discord.widgets.hubs.WidgetHubAuthentication$onViewBound$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetHubAuthentication.kt */
        public static final class AnonymousClass1 extends Lambda implements Function1<View, Unit> {
            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                Intrinsics3.checkNotNullParameter(view, "it");
                WidgetHubAuthentication.this.getViewModel().resendEmail();
            }
        }

        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
            renderContext.b("onClick", new AnonymousClass1());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.hubs.WidgetHubAuthentication$onViewBoundOrOnResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetHubAuthentication.kt */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<WidgetHubAuthenticationlViewModel3, Unit> {
        public AnonymousClass1(WidgetHubAuthentication widgetHubAuthentication) {
            super(1, widgetHubAuthentication, WidgetHubAuthentication.class, "configureUi", "configureUi(Lcom/discord/widgets/hubs/HubAuthenticationState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetHubAuthenticationlViewModel3 widgetHubAuthenticationlViewModel3) {
            invoke2(widgetHubAuthenticationlViewModel3);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetHubAuthenticationlViewModel3 widgetHubAuthenticationlViewModel3) {
            Intrinsics3.checkNotNullParameter(widgetHubAuthenticationlViewModel3, "p1");
            ((WidgetHubAuthentication) this.receiver).configureUi(widgetHubAuthenticationlViewModel3);
        }
    }

    public WidgetHubAuthentication() {
        super(R.layout.widget_hub_authentication);
        this.args = LazyJVM.lazy(new WidgetHubAuthentication$$special$$inlined$args$1(this, "intent_args_key"));
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetHubAuthentication2.INSTANCE, null, 2, null);
        WidgetHubAuthentication4 widgetHubAuthentication4 = new WidgetHubAuthentication4(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetHubAuthenticationlViewModel4.class), new WidgetHubAuthentication$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetHubAuthentication4));
    }

    private final void configureUi(WidgetHubAuthenticationlViewModel3 state) {
        Context context = getContext();
        if (context != null) {
            Intrinsics3.checkNotNullExpressionValue(context, "context ?: return");
            RestCallState5.handleResponse$default(state.getAuthenticationAsync(), context, null, null, new AnonymousClass1(), 6, null);
            RestCallState5.handleResponse$default(state.getResendEmailAsync(), context, null, null, new AnonymousClass2(), 6, null);
        }
    }

    private final WidgetHubAuthenticationBinding getBinding() {
        return (WidgetHubAuthenticationBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetHubAuthenticationlViewModel4 getViewModel() {
        return (WidgetHubAuthenticationlViewModel4) this.viewModel.getValue();
    }

    public final WidgetHubAuthenticationlViewModel2 getArgs() {
        return (WidgetHubAuthenticationlViewModel2) this.args.getValue();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        getBinding().c.setOnCodeEntered(new AnonymousClass1());
        LinkifiedTextView linkifiedTextView = getBinding().f2469b;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "binding.description");
        linkifiedTextView.setText(FormatUtils.e(this, R.string.hub_pin_description, new Object[]{getArgs().getEmail()}, new AnonymousClass2()));
        CodeVerificationView codeVerificationView = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(codeVerificationView, "binding.verification");
        showKeyboard(codeVerificationView);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), (Class<?>) WidgetHubAuthentication.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1(this));
    }
}
