package com.discord.widgets.contact_sync;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.C5419R;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.ContactSyncPermissionsSheetBinding;
import com.discord.i18n.Hook;
import com.discord.i18n.RenderContext;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.spans.ClickableSpan;
import com.discord.utilities.uri.UriHandler;
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
import p007b.p008a.p018d.C0862f;
import p007b.p008a.p018d.C0863f0;
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12238m;
import p658rx.Subscription;

/* JADX INFO: compiled from: ContactSyncPermissionsSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ContactSyncPermissionsSheet extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(ContactSyncPermissionsSheet.class, "binding", "getBinding()Lcom/discord/databinding/ContactSyncPermissionsSheetBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: compiled from: ContactSyncPermissionsSheet.kt */
    public static final class Companion {
        private Companion() {
        }

        public final ContactSyncPermissionsSheet show(FragmentManager fragmentManager) {
            C12238m.checkNotNullParameter(fragmentManager, "fragmentManager");
            ContactSyncPermissionsSheet contactSyncPermissionsSheet = new ContactSyncPermissionsSheet();
            contactSyncPermissionsSheet.show(fragmentManager, ContactSyncPermissionsSheet.class.getSimpleName());
            return contactSyncPermissionsSheet;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.contact_sync.ContactSyncPermissionsSheet$configureUI$1 */
    /* JADX INFO: compiled from: ContactSyncPermissionsSheet.kt */
    public static final class C82091 extends AbstractC12240o implements Function1<RenderContext, Unit> {
        public C82091() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: com.discord.widgets.contact_sync.ContactSyncPermissionsSheet$configureUI$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: ContactSyncPermissionsSheet.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function1<Hook, Unit> {

            /* JADX INFO: renamed from: com.discord.widgets.contact_sync.ContactSyncPermissionsSheet$configureUI$1$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: ContactSyncPermissionsSheet.kt */
            public static final class C132831 extends AbstractC12240o implements Function1<View, Unit> {
                public static final C132831 INSTANCE = new C132831();

                public C132831() {
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
                    UriHandler uriHandler = UriHandler.INSTANCE;
                    Context context = view.getContext();
                    C12238m.checkNotNullExpressionValue(context, "it.context");
                    UriHandler.handle$default(uriHandler, context, C0862f.f507a.m149a(360061878534L, null), false, false, null, 28, null);
                }
            }

            public AnonymousClass1() {
                super(1);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Hook hook) {
                C12238m.checkNotNullParameter(hook, "$receiver");
                hook.styles.add(new ClickableSpan(Integer.valueOf(ColorCompat.getColor(ContactSyncPermissionsSheet.this.getContext(), C5419R.color.link)), false, null, C132831.INSTANCE, 4, null));
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

    /* JADX INFO: renamed from: com.discord.widgets.contact_sync.ContactSyncPermissionsSheet$onResume$1 */
    /* JADX INFO: compiled from: ContactSyncPermissionsSheet.kt */
    public static final class C82131 extends AbstractC12240o implements Function1<WidgetContactSyncViewModel.ViewState, Unit> {
        public C82131() {
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
            ContactSyncPermissionsSheet.this.configureUI(viewState);
        }
    }

    public ContactSyncPermissionsSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, ContactSyncPermissionsSheet$binding$2.INSTANCE, null, 2, null);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(WidgetContactSyncViewModel.class), new C8207x6c1a5d95(this), new C0863f0(new ContactSyncPermissionsSheet$viewModel$2(this)));
    }

    private final void configureUI(final WidgetContactSyncViewModel.ViewState viewState) {
        final boolean z2 = viewState.getAllowPhone() || viewState.getAllowEmail();
        CheckedSetting checkedSetting = getBinding().f15026b;
        C12238m.checkNotNullExpressionValue(checkedSetting, "binding.contactSyncPermissionsDiscoverableToggle");
        checkedSetting.setChecked(z2);
        CheckedSetting checkedSetting2 = getBinding().f15029e;
        C12238m.checkNotNullExpressionValue(checkedSetting2, "binding.contactSyncPermissionsPhoneToggle");
        checkedSetting2.setChecked(viewState.getAllowPhone());
        CheckedSetting checkedSetting3 = getBinding().f15027c;
        C12238m.checkNotNullExpressionValue(checkedSetting3, "binding.contactSyncPermissionsEmailToggle");
        checkedSetting3.setChecked(viewState.getAllowEmail());
        LinkifiedTextView linkifiedTextView = getBinding().f15028d;
        C12238m.checkNotNullExpressionValue(linkifiedTextView, "binding.contactSyncPermissionsLearnMore");
        C1107b.m221m(linkifiedTextView, C5419R.string.contact_sync_learn_more, new Object[0], new C82091());
        getBinding().f15026b.m8527e(new View.OnClickListener() { // from class: com.discord.widgets.contact_sync.ContactSyncPermissionsSheet.configureUI.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetContactSyncViewModel viewModel = ContactSyncPermissionsSheet.this.getViewModel();
                boolean z3 = z2;
                viewModel.onPermissionsToggle(!z3, !z3);
            }
        });
        getBinding().f15029e.m8527e(new View.OnClickListener() { // from class: com.discord.widgets.contact_sync.ContactSyncPermissionsSheet.configureUI.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ContactSyncPermissionsSheet.this.getViewModel().onPermissionsToggle(!viewState.getAllowPhone(), viewState.getAllowEmail());
            }
        });
        getBinding().f15027c.m8527e(new View.OnClickListener() { // from class: com.discord.widgets.contact_sync.ContactSyncPermissionsSheet.configureUI.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ContactSyncPermissionsSheet.this.getViewModel().onPermissionsToggle(viewState.getAllowPhone(), !viewState.getAllowEmail());
            }
        });
    }

    private final ContactSyncPermissionsSheetBinding getBinding() {
        return (ContactSyncPermissionsSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetContactSyncViewModel getViewModel() {
        return (WidgetContactSyncViewModel) this.viewModel.getValue();
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return C5419R.layout.contact_sync_permissions_sheet;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), (Class<?>) ContactSyncPermissionsSheet.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C82131());
    }
}
