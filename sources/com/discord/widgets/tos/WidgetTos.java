package com.discord.widgets.tos;

import android.content.Context;
import android.content.Intent;
import android.text.format.DateUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import b.a.d.AppScreen2;
import b.a.d.o;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetTosBinding;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreStream;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.google.android.material.button.MaterialButton;
import d0.LazyJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.functions.Action2;
import rx.functions.Func0;

/* JADX INFO: compiled from: WidgetTos.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetTos extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetTos.class, "binding", "getBinding()Lcom/discord/databinding/WidgetTosBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: isAcknowledgement$delegate, reason: from kotlin metadata */
    private final Lazy isAcknowledgement;

    /* JADX INFO: compiled from: WidgetTos.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(Context context, boolean isAck) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intent intent = new Intent();
            intent.putExtra("intent_args_key", isAck);
            AppScreen2.d(context, WidgetTos.class, intent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.tos.WidgetTos$isAcknowledgement$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetTos.kt */
    public static final class AnonymousClass2 extends Lambda implements Function0<Boolean> {
        public AnonymousClass2() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Boolean invoke() {
            return Boolean.valueOf(invoke2());
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2() {
            return WidgetTos.this.getMostRecentIntent().getBooleanExtra("intent_args_key", false);
        }
    }

    public WidgetTos() {
        super(R.layout.widget_tos);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetTos2.INSTANCE, null, 2, null);
        this.isAcknowledgement = LazyJVM.lazy(new AnonymousClass2());
    }

    private final void configureAcknowledgementUI() {
        configureCommonTosModalUI();
        WidgetTosBinding binding = getBinding();
        TextView textView = binding.h;
        Intrinsics3.checkNotNullExpressionValue(textView, "alertTosTextDescriptionTop");
        FormatUtils.m(textView, R.string.terms_acknowledgement_description_1, new Object[]{DateUtils.formatDateTime(requireContext(), 1648454400000L, 4)}, (4 & 4) != 0 ? FormatUtils.g.j : null);
        TextView textView2 = binding.g;
        Intrinsics3.checkNotNullExpressionValue(textView2, "alertTosTextDescriptionBottom");
        FormatUtils.m(textView2, R.string.terms_acknowledgement_description_2, new Object[0], (4 & 4) != 0 ? FormatUtils.g.j : null);
    }

    private final void configureAgreementUI() {
        configureCommonTosModalUI();
        WidgetTosBinding binding = getBinding();
        binding.f2674b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.tos.WidgetTos$configureAgreementUI$$inlined$with$lambda$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().userAgreements(RestAPIParams.UserAgreements.INSTANCE.agree()), false, 1, null), this.this$0, null, 2, null).k(o.a.g(this.this$0.getContext(), WidgetTos4.INSTANCE, null));
                this.this$0.requireActivity().finish();
            }
        });
        TextView textView = binding.h;
        Intrinsics3.checkNotNullExpressionValue(textView, "alertTosTextDescriptionTop");
        FormatUtils.m(textView, R.string.terms_agreement_description_1, new Object[0], (4 & 4) != 0 ? FormatUtils.g.j : null);
        TextView textView2 = binding.g;
        Intrinsics3.checkNotNullExpressionValue(textView2, "alertTosTextDescriptionBottom");
        FormatUtils.m(textView2, R.string.terms_agreement_description_2, new Object[0], (4 & 4) != 0 ? FormatUtils.g.j : null);
        MaterialButton materialButton = binding.f2674b;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "alertTosAckContinue");
        FormatUtils.m(materialButton, R.string.got_it, new Object[0], (4 & 4) != 0 ? FormatUtils.g.j : null);
    }

    private final void configureCommonTosModalUI() {
        MaterialButton materialButton = getBinding().f2674b;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.alertTosAckContinue");
        FormatUtils.m(materialButton, R.string.got_it, new Object[0], (4 & 4) != 0 ? FormatUtils.g.j : null);
        final RestAPIParams.UserAgreements userAgreementsAcknowledge = isAcknowledgement() ? RestAPIParams.UserAgreements.INSTANCE.acknowledge() : RestAPIParams.UserAgreements.INSTANCE.agree();
        getBinding().f2674b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.tos.WidgetTos.configureCommonTosModalUI.1

            /* JADX INFO: renamed from: com.discord.widgets.tos.WidgetTos$configureCommonTosModalUI$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: WidgetTos.kt */
            public static final class C03491 extends Lambda implements Function1<Void, Unit> {
                public static final C03491 INSTANCE = new C03491();

                public C03491() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
                    invoke2(r1);
                    return Unit.a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Void r1) {
                }
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().userAgreements(userAgreementsAcknowledge), false, 1, null), WidgetTos.this, null, 2, null).k(o.a.g(WidgetTos.this.getContext(), C03491.INSTANCE, null));
                WidgetTos.this.requireActivity().finish();
            }
        });
    }

    private final void configureCommonUI() {
        WidgetTosBinding binding = getBinding();
        LinkifiedTextView linkifiedTextView = binding.f;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "alertTosTermsOfService");
        FormatUtils.m(linkifiedTextView, R.string.terms_of_service, new Object[]{getString(R.string.terms_of_service_url)}, (4 & 4) != 0 ? FormatUtils.g.j : null);
        LinkifiedTextView linkifiedTextView2 = binding.e;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView2, "alertTosPrivacyPolicy");
        FormatUtils.m(linkifiedTextView2, R.string.privacy_policy, new Object[]{getString(R.string.privacy_policy_url)}, (4 & 4) != 0 ? FormatUtils.g.j : null);
        LinkifiedTextView linkifiedTextView3 = binding.d;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView3, "alertTosCommunityGuidelines");
        FormatUtils.m(linkifiedTextView3, R.string.community_guidelines, new Object[]{getString(R.string.community_guidelines_url)}, (4 & 4) != 0 ? FormatUtils.g.j : null);
        LinkifiedTextView linkifiedTextView4 = binding.c;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView4, "alertTosBlogPost");
        FormatUtils.m(linkifiedTextView4, R.string.blog_post, new Object[]{getString(R.string.important_updates_url)}, (4 & 4) != 0 ? FormatUtils.g.j : null);
    }

    private final void configureUI() {
        configureCommonUI();
        if (isAcknowledgement()) {
            configureAcknowledgementUI();
        } else {
            configureAgreementUI();
        }
    }

    private final WidgetTosBinding getBinding() {
        return (WidgetTosBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final boolean isAcknowledgement() {
        return ((Boolean) this.isAcknowledgement.getValue()).booleanValue();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setOnBackPressed$default(this, new Func0<Boolean>() { // from class: com.discord.widgets.tos.WidgetTos.onViewBound.1
            @Override // rx.functions.Func0, java.util.concurrent.Callable
            public final Boolean call() {
                return Boolean.TRUE;
            }
        }, 0, 2, null);
        AppFragment.setActionBarOptionsMenu$default(this, R.menu.menu_settings_logout, new Action2<MenuItem, Context>() { // from class: com.discord.widgets.tos.WidgetTos.onViewBound.2
            @Override // rx.functions.Action2
            public final void call(MenuItem menuItem, Context context) {
                Intrinsics3.checkNotNullExpressionValue(menuItem, "menuItem");
                if (menuItem.getItemId() != R.id.menu_settings_log_out) {
                    return;
                }
                StoreStream.INSTANCE.getAuthentication().logout();
            }
        }, null, 4, null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        configureUI();
    }
}
