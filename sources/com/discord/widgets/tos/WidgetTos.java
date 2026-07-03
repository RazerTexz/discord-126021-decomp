package com.discord.widgets.tos;

import android.content.Context;
import android.content.Intent;
import android.text.format.DateUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetTosBinding;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreStream;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.google.android.material.button.MaterialButton;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0870j;
import p007b.p008a.p018d.C0879o;
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12083g;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.functions.Action2;
import p658rx.functions.Func0;

/* JADX INFO: compiled from: WidgetTos.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetTos extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetTos.class, "binding", "getBinding()Lcom/discord/databinding/WidgetTosBinding;", 0)};

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
            C12238m.checkNotNullParameter(context, "context");
            Intent intent = new Intent();
            intent.putExtra("intent_args_key", isAck);
            C0870j.m156d(context, WidgetTos.class, intent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.tos.WidgetTos$isAcknowledgement$2 */
    /* JADX INFO: compiled from: WidgetTos.kt */
    public static final class C101702 extends AbstractC12240o implements Function0<Boolean> {
        public C101702() {
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
        super(C5419R.layout.widget_tos);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetTos$binding$2.INSTANCE, null, 2, null);
        this.isAcknowledgement = C12083g.lazy(new C101702());
    }

    private final void configureAcknowledgementUI() {
        configureCommonTosModalUI();
        WidgetTosBinding binding = getBinding();
        TextView textView = binding.f18300h;
        C12238m.checkNotNullExpressionValue(textView, "alertTosTextDescriptionTop");
        C1107b.m221m(textView, C5419R.string.terms_acknowledgement_description_1, new Object[]{DateUtils.formatDateTime(requireContext(), 1648454400000L, 4)}, (4 & 4) != 0 ? C1107b.g.f1495j : null);
        TextView textView2 = binding.f18299g;
        C12238m.checkNotNullExpressionValue(textView2, "alertTosTextDescriptionBottom");
        C1107b.m221m(textView2, C5419R.string.terms_acknowledgement_description_2, new Object[0], (4 & 4) != 0 ? C1107b.g.f1495j : null);
    }

    private final void configureAgreementUI() {
        configureCommonTosModalUI();
        WidgetTosBinding binding = getBinding();
        binding.f18294b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.tos.WidgetTos$configureAgreementUI$$inlined$with$lambda$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().userAgreements(RestAPIParams.UserAgreements.INSTANCE.agree()), false, 1, null), this.this$0, null, 2, null).m11108k(C0879o.f566a.m184g(this.this$0.getContext(), WidgetTos$configureAgreementUI$1$1$1.INSTANCE, null));
                this.this$0.requireActivity().finish();
            }
        });
        TextView textView = binding.f18300h;
        C12238m.checkNotNullExpressionValue(textView, "alertTosTextDescriptionTop");
        C1107b.m221m(textView, C5419R.string.terms_agreement_description_1, new Object[0], (4 & 4) != 0 ? C1107b.g.f1495j : null);
        TextView textView2 = binding.f18299g;
        C12238m.checkNotNullExpressionValue(textView2, "alertTosTextDescriptionBottom");
        C1107b.m221m(textView2, C5419R.string.terms_agreement_description_2, new Object[0], (4 & 4) != 0 ? C1107b.g.f1495j : null);
        MaterialButton materialButton = binding.f18294b;
        C12238m.checkNotNullExpressionValue(materialButton, "alertTosAckContinue");
        C1107b.m221m(materialButton, C5419R.string.got_it, new Object[0], (4 & 4) != 0 ? C1107b.g.f1495j : null);
    }

    private final void configureCommonTosModalUI() {
        MaterialButton materialButton = getBinding().f18294b;
        C12238m.checkNotNullExpressionValue(materialButton, "binding.alertTosAckContinue");
        C1107b.m221m(materialButton, C5419R.string.got_it, new Object[0], (4 & 4) != 0 ? C1107b.g.f1495j : null);
        final RestAPIParams.UserAgreements userAgreementsAcknowledge = isAcknowledgement() ? RestAPIParams.UserAgreements.INSTANCE.acknowledge() : RestAPIParams.UserAgreements.INSTANCE.agree();
        getBinding().f18294b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.tos.WidgetTos.configureCommonTosModalUI.1

            /* JADX INFO: renamed from: com.discord.widgets.tos.WidgetTos$configureCommonTosModalUI$1$1, reason: invalid class name */
            /* JADX INFO: compiled from: WidgetTos.kt */
            public static final class AnonymousClass1 extends AbstractC12240o implements Function1<Void, Unit> {
                public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

                public AnonymousClass1() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
                    invoke2(r1);
                    return Unit.f27425a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Void r1) {
                }
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().userAgreements(userAgreementsAcknowledge), false, 1, null), WidgetTos.this, null, 2, null).m11108k(C0879o.f566a.m184g(WidgetTos.this.getContext(), AnonymousClass1.INSTANCE, null));
                WidgetTos.this.requireActivity().finish();
            }
        });
    }

    private final void configureCommonUI() {
        WidgetTosBinding binding = getBinding();
        LinkifiedTextView linkifiedTextView = binding.f18298f;
        C12238m.checkNotNullExpressionValue(linkifiedTextView, "alertTosTermsOfService");
        C1107b.m221m(linkifiedTextView, C5419R.string.terms_of_service, new Object[]{getString(C5419R.string.terms_of_service_url)}, (4 & 4) != 0 ? C1107b.g.f1495j : null);
        LinkifiedTextView linkifiedTextView2 = binding.f18297e;
        C12238m.checkNotNullExpressionValue(linkifiedTextView2, "alertTosPrivacyPolicy");
        C1107b.m221m(linkifiedTextView2, C5419R.string.privacy_policy, new Object[]{getString(C5419R.string.privacy_policy_url)}, (4 & 4) != 0 ? C1107b.g.f1495j : null);
        LinkifiedTextView linkifiedTextView3 = binding.f18296d;
        C12238m.checkNotNullExpressionValue(linkifiedTextView3, "alertTosCommunityGuidelines");
        C1107b.m221m(linkifiedTextView3, C5419R.string.community_guidelines, new Object[]{getString(C5419R.string.community_guidelines_url)}, (4 & 4) != 0 ? C1107b.g.f1495j : null);
        LinkifiedTextView linkifiedTextView4 = binding.f18295c;
        C12238m.checkNotNullExpressionValue(linkifiedTextView4, "alertTosBlogPost");
        C1107b.m221m(linkifiedTextView4, C5419R.string.blog_post, new Object[]{getString(C5419R.string.important_updates_url)}, (4 & 4) != 0 ? C1107b.g.f1495j : null);
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
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setOnBackPressed$default(this, new Func0<Boolean>() { // from class: com.discord.widgets.tos.WidgetTos.onViewBound.1
            @Override // p658rx.functions.Func0, java.util.concurrent.Callable
            public final Boolean call() {
                return Boolean.TRUE;
            }
        }, 0, 2, null);
        AppFragment.setActionBarOptionsMenu$default(this, C5419R.menu.menu_settings_logout, new Action2<MenuItem, Context>() { // from class: com.discord.widgets.tos.WidgetTos.onViewBound.2
            @Override // p658rx.functions.Action2
            public final void call(MenuItem menuItem, Context context) {
                C12238m.checkNotNullExpressionValue(menuItem, "menuItem");
                if (menuItem.getItemId() != C5419R.id.menu_settings_log_out) {
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
