package com.discord.widgets.contact_sync;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.C5419R;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.ContactSyncUpsellSheetBinding;
import com.discord.i18n.Hook;
import com.discord.i18n.RenderContext;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.spans.ClickableSpan;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.CheckedSetting;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0863f0;
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12238m;
import p658rx.Subscription;

/* JADX INFO: compiled from: ContactSyncUpsellSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ContactSyncUpsellSheet extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(ContactSyncUpsellSheet.class, "binding", "getBinding()Lcom/discord/databinding/ContactSyncUpsellSheetBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: compiled from: ContactSyncUpsellSheet.kt */
    public static final class Companion {
        private Companion() {
        }

        public final ContactSyncUpsellSheet show(FragmentManager fragmentManager) {
            C12238m.checkNotNullParameter(fragmentManager, "fragmentManager");
            ContactSyncUpsellSheet contactSyncUpsellSheet = new ContactSyncUpsellSheet();
            contactSyncUpsellSheet.show(fragmentManager, ContactSyncUpsellSheet.class.getSimpleName());
            return contactSyncUpsellSheet;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.contact_sync.ContactSyncUpsellSheet$configureUI$2 */
    /* JADX INFO: compiled from: ContactSyncUpsellSheet.kt */
    public static final class C82182 extends AbstractC12240o implements Function1<RenderContext, Unit> {
        public C82182() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: com.discord.widgets.contact_sync.ContactSyncUpsellSheet$configureUI$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: ContactSyncUpsellSheet.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function1<Hook, Unit> {

            /* JADX INFO: renamed from: com.discord.widgets.contact_sync.ContactSyncUpsellSheet$configureUI$2$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: ContactSyncUpsellSheet.kt */
            public static final class C132841 extends AbstractC12240o implements Function1<View, Unit> {
                public C132841() {
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
                    AnalyticsTracker.INSTANCE.openPopout("Contact Sync", new Traits.Location("Contact Sync Learn More", null, null, null, null, 30, null));
                    ContactSyncPermissionsSheet.Companion companion = ContactSyncPermissionsSheet.INSTANCE;
                    FragmentManager parentFragmentManager = ContactSyncUpsellSheet.this.getParentFragmentManager();
                    C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                    companion.show(parentFragmentManager);
                }
            }

            public AnonymousClass1() {
                super(1);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Hook hook) {
                C12238m.checkNotNullParameter(hook, "$receiver");
                hook.styles.add(new ClickableSpan(Integer.valueOf(ColorCompat.getColor(ContactSyncUpsellSheet.this.getContext(), C5419R.color.link)), false, null, new C132841(), 4, null));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Hook hook) {
                invoke2(hook);
                return Unit.f27425a;
            }
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            C12238m.checkNotNullParameter(renderContext, "$receiver");
            renderContext.m8422a("learnMoreHook", new AnonymousClass1());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.contact_sync.ContactSyncUpsellSheet$onResume$1 */
    /* JADX INFO: compiled from: ContactSyncUpsellSheet.kt */
    public static final class C82211 extends AbstractC12240o implements Function1<WidgetContactSyncViewModel.ViewState, Unit> {
        public C82211() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetContactSyncViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetContactSyncViewModel.ViewState viewState) {
            C12238m.checkNotNullParameter(viewState, "it");
            ContactSyncUpsellSheet.this.configureUI(viewState);
        }
    }

    public ContactSyncUpsellSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, ContactSyncUpsellSheet$binding$2.INSTANCE, null, 2, null);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(WidgetContactSyncViewModel.class), new C8215xa183d636(this), new C0863f0(ContactSyncUpsellSheet$viewModel$2.INSTANCE));
    }

    private final void configureUI(final WidgetContactSyncViewModel.ViewState viewState) {
        final boolean z2 = viewState.getAllowPhone() || viewState.getAllowEmail();
        CheckedSetting checkedSetting = getBinding().f15033d.f1096c;
        C12238m.checkNotNullExpressionValue(checkedSetting, "binding.contactSyncUpsel…ontactSyncDiscoveryToggle");
        checkedSetting.setChecked(z2);
        getBinding().f15033d.f1096c.m8527e(new View.OnClickListener() { // from class: com.discord.widgets.contact_sync.ContactSyncUpsellSheet.configureUI.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetContactSyncViewModel viewModel = ContactSyncUpsellSheet.this.getViewModel();
                boolean z3 = z2;
                viewModel.onPermissionsToggle(!z3, !z3);
            }
        });
        LinkifiedTextView linkifiedTextView = getBinding().f15033d.f1095b;
        C12238m.checkNotNullExpressionValue(linkifiedTextView, "binding.contactSyncUpsel…contactSyncDiscoveryInfo2");
        C1107b.m221m(linkifiedTextView, C5419R.string.contact_sync_learn_more, new Object[0], new C82182());
        getBinding().f15032c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.contact_sync.ContactSyncUpsellSheet.configureUI.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ContactSyncUpsellSheet.this.getViewModel().skip();
                ContactSyncUpsellSheet.this.dismiss();
            }
        });
        getBinding().f15031b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.contact_sync.ContactSyncUpsellSheet.configureUI.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ContactSyncUpsellSheet.this.dismiss();
                WidgetContactSync.Companion.launch$default(WidgetContactSync.INSTANCE, C1643a.m885x(view, "it", "it.context"), null, true, viewState.getAllowPhone(), viewState.getAllowEmail(), 2, null);
            }
        });
    }

    private final ContactSyncUpsellSheetBinding getBinding() {
        return (ContactSyncUpsellSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetContactSyncViewModel getViewModel() {
        return (WidgetContactSyncViewModel) this.viewModel.getValue();
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return C5419R.layout.contact_sync_upsell_sheet;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        C12238m.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
        getViewModel().dismissUpsell();
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), (Class<?>) ContactSyncUpsellSheet.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C82211());
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setBottomSheetCollapsedStateDisabled();
    }
}
