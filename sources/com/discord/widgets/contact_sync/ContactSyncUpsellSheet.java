package com.discord.widgets.contact_sync;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.f0;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.ContactSyncUpsellSheetBinding;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.CheckedSetting;
import d0.z.d.a0;
import d0.z.d.m;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: ContactSyncUpsellSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ContactSyncUpsellSheet extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(ContactSyncUpsellSheet.class, "binding", "getBinding()Lcom/discord/databinding/ContactSyncUpsellSheetBinding;", 0)};
    public static final ContactSyncUpsellSheet$Companion Companion = new ContactSyncUpsellSheet$Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public ContactSyncUpsellSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, ContactSyncUpsellSheet$binding$2.INSTANCE, null, 2, null);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(WidgetContactSyncViewModel.class), new ContactSyncUpsellSheet$appActivityViewModels$$inlined$activityViewModels$1(this), new f0(ContactSyncUpsellSheet$viewModel$2.INSTANCE));
    }

    public static final /* synthetic */ void access$configureUI(ContactSyncUpsellSheet contactSyncUpsellSheet, WidgetContactSyncViewModel$ViewState widgetContactSyncViewModel$ViewState) {
        contactSyncUpsellSheet.configureUI(widgetContactSyncViewModel$ViewState);
    }

    public static final /* synthetic */ WidgetContactSyncViewModel access$getViewModel$p(ContactSyncUpsellSheet contactSyncUpsellSheet) {
        return contactSyncUpsellSheet.getViewModel();
    }

    private final void configureUI(WidgetContactSyncViewModel$ViewState viewState) {
        boolean z2 = viewState.getAllowPhone() || viewState.getAllowEmail();
        CheckedSetting checkedSetting = getBinding().d.c;
        m.checkNotNullExpressionValue(checkedSetting, "binding.contactSyncUpsel…ontactSyncDiscoveryToggle");
        checkedSetting.setChecked(z2);
        getBinding().d.c.e(new ContactSyncUpsellSheet$configureUI$1(this, z2));
        LinkifiedTextView linkifiedTextView = getBinding().d.f171b;
        m.checkNotNullExpressionValue(linkifiedTextView, "binding.contactSyncUpsel…contactSyncDiscoveryInfo2");
        b.m(linkifiedTextView, 2131887893, new Object[0], new ContactSyncUpsellSheet$configureUI$2(this));
        getBinding().c.setOnClickListener(new ContactSyncUpsellSheet$configureUI$3(this));
        getBinding().f2093b.setOnClickListener(new ContactSyncUpsellSheet$configureUI$4(this, viewState));
    }

    private final ContactSyncUpsellSheetBinding getBinding() {
        return (ContactSyncUpsellSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetContactSyncViewModel getViewModel() {
        return (WidgetContactSyncViewModel) this.viewModel.getValue();
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R$layout.contact_sync_upsell_sheet;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface$OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        m.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
        getViewModel().dismissUpsell();
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), ContactSyncUpsellSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new ContactSyncUpsellSheet$onResume$1(this), 62, (Object) null);
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setBottomSheetCollapsedStateDisabled();
    }
}
