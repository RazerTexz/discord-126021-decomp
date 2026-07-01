package com.discord.widgets.settings.account;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.AppScreen2;
import b.a.d.AppToast;
import b.a.d.o;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.auth.mfa.BackupCode;
import com.discord.api.auth.mfa.GetBackupCodesResponse;
import com.discord.api.auth.mfa.GetBackupCodesSendVerificationKeyRequestBody;
import com.discord.api.auth.mfa.GetBackupCodesSendVerificationKeyResponse;
import com.discord.api.auth.mfa.GetBackupCodesVerificationRequestBody;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetSettingsAccountBackupCodesBinding;
import com.discord.databinding.WidgetSettingsItemBackupCodeBinding;
import com.discord.databinding.WidgetSettingsItemBackupCodeHeaderBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreNotices;
import com.discord.utilities.error.Error;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.notice.WidgetNoticeDialog;
import com.discord.widgets.settings.account.WidgetSettingsAccountBackupCodes;
import d0.t.Iterables2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.functions.Action1;

/* JADX INFO: compiled from: WidgetSettingsAccountBackupCodes.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsAccountBackupCodes extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetSettingsAccountBackupCodes.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsAccountBackupCodesBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private Adapter backupCodesAdapter;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private String nonce;
    private String password;
    private String regenerateNonce;
    private String verificationKey;

    /* JADX INFO: compiled from: WidgetSettingsAccountBackupCodes.kt */
    public static final class Adapter extends MGRecyclerAdapterSimple<MGRecyclerDataPayload> {

        /* JADX INFO: compiled from: WidgetSettingsAccountBackupCodes.kt */
        public static final class BackupCodeHeaderViewHolder extends MGRecyclerViewHolder<Adapter, MGRecyclerDataPayload> {
            private final WidgetSettingsItemBackupCodeHeaderBinding binding;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public BackupCodeHeaderViewHolder(@LayoutRes int i, Adapter adapter) {
                super(i, adapter);
                Intrinsics3.checkNotNullParameter(adapter, "adapter");
                View view = this.itemView;
                Objects.requireNonNull(view, "rootView");
                TextView textView = (TextView) view;
                WidgetSettingsItemBackupCodeHeaderBinding widgetSettingsItemBackupCodeHeaderBinding = new WidgetSettingsItemBackupCodeHeaderBinding(textView, textView);
                Intrinsics3.checkNotNullExpressionValue(widgetSettingsItemBackupCodeHeaderBinding, "WidgetSettingsItemBackup…derBinding.bind(itemView)");
                this.binding = widgetSettingsItemBackupCodeHeaderBinding;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
            public void onConfigure(int position, MGRecyclerDataPayload data) {
                Intrinsics3.checkNotNullParameter(data, "data");
                super.onConfigure(position, data);
                TextView textView = this.binding.f2624b;
                Intrinsics3.checkNotNullExpressionValue(textView, "binding.itemHeader");
                textView.setText(((BackupCodeItemHeader) data).getHeaderText());
            }
        }

        /* JADX INFO: compiled from: WidgetSettingsAccountBackupCodes.kt */
        public static final class BackupCodeViewHolder extends MGRecyclerViewHolder<Adapter, MGRecyclerDataPayload> {
            private final WidgetSettingsItemBackupCodeBinding binding;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public BackupCodeViewHolder(@LayoutRes int i, Adapter adapter) {
                super(i, adapter);
                Intrinsics3.checkNotNullParameter(adapter, "adapter");
                View view = this.itemView;
                Objects.requireNonNull(view, "rootView");
                TextView textView = (TextView) view;
                WidgetSettingsItemBackupCodeBinding widgetSettingsItemBackupCodeBinding = new WidgetSettingsItemBackupCodeBinding(textView, textView);
                Intrinsics3.checkNotNullExpressionValue(widgetSettingsItemBackupCodeBinding, "WidgetSettingsItemBackupCodeBinding.bind(itemView)");
                this.binding = widgetSettingsItemBackupCodeBinding;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
            public void onConfigure(int position, final MGRecyclerDataPayload data) {
                Intrinsics3.checkNotNullParameter(data, "data");
                super.onConfigure(position, data);
                BackupCodeItem backupCodeItem = (BackupCodeItem) data;
                TextView textView = this.binding.f2623b;
                Intrinsics3.checkNotNullExpressionValue(textView, "binding.itemBackupCodeTv");
                String code = backupCodeItem.getBackupCode().getCode();
                Objects.requireNonNull(code, "null cannot be cast to non-null type java.lang.String");
                String strSubstring = code.substring(0, 4);
                Intrinsics3.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                String code2 = backupCodeItem.getBackupCode().getCode();
                Objects.requireNonNull(code2, "null cannot be cast to non-null type java.lang.String");
                String strSubstring2 = code2.substring(4);
                Intrinsics3.checkNotNullExpressionValue(strSubstring2, "(this as java.lang.String).substring(startIndex)");
                FormatUtils.m(textView, R.string.backup_codes_dash, new Object[]{strSubstring, strSubstring2}, (4 & 4) != 0 ? FormatUtils.g.j : null);
                if (backupCodeItem.getBackupCode().getConsumed()) {
                    this.binding.f2623b.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_check_brand_24dp, 0);
                    this.binding.f2623b.setOnClickListener(null);
                } else {
                    this.binding.f2623b.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    this.binding.f2623b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.account.WidgetSettingsAccountBackupCodes$Adapter$BackupCodeViewHolder$onConfigure$1
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            Intrinsics3.checkNotNullExpressionValue(view, "it");
                            ClipboardManager clipboardManager = (ClipboardManager) view.getContext().getSystemService("clipboard");
                            ClipData clipDataNewPlainText = ClipData.newPlainText("backup code", ((WidgetSettingsAccountBackupCodes.BackupCodeItem) data).getBackupCode().getCode());
                            if (clipboardManager != null) {
                                clipboardManager.setPrimaryClip(clipDataNewPlainText);
                            }
                            AppToast.g(view.getContext(), R.string.copied_text, 0, null, 12);
                        }
                    });
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Adapter(RecyclerView recyclerView) {
            super(recyclerView, false, 2, null);
            Intrinsics3.checkNotNullParameter(recyclerView, "recyclerView");
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public MGRecyclerViewHolder<Adapter, MGRecyclerDataPayload> onCreateViewHolder(ViewGroup parent, int viewType) {
            Intrinsics3.checkNotNullParameter(parent, "parent");
            if (viewType != 0) {
                return viewType != 1 ? new MGRecyclerViewHolder<>(0, this) : new BackupCodeViewHolder(R.layout.widget_settings_item_backup_code, this);
            }
            return new BackupCodeHeaderViewHolder(R.layout.widget_settings_item_backup_code_header, this);
        }
    }

    /* JADX INFO: compiled from: WidgetSettingsAccountBackupCodes.kt */
    public static final /* data */ class BackupCodeItem implements MGRecyclerDataPayload {
        private final BackupCode backupCode;
        private final String key;
        private final int type;

        public BackupCodeItem(BackupCode backupCode) {
            Intrinsics3.checkNotNullParameter(backupCode, "backupCode");
            this.backupCode = backupCode;
            this.type = 1;
            this.key = backupCode.getCode();
        }

        public static /* synthetic */ BackupCodeItem copy$default(BackupCodeItem backupCodeItem, BackupCode backupCode, int i, Object obj) {
            if ((i & 1) != 0) {
                backupCode = backupCodeItem.backupCode;
            }
            return backupCodeItem.copy(backupCode);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final BackupCode getBackupCode() {
            return this.backupCode;
        }

        public final BackupCodeItem copy(BackupCode backupCode) {
            Intrinsics3.checkNotNullParameter(backupCode, "backupCode");
            return new BackupCodeItem(backupCode);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof BackupCodeItem) && Intrinsics3.areEqual(this.backupCode, ((BackupCodeItem) other).backupCode);
            }
            return true;
        }

        public final BackupCode getBackupCode() {
            return this.backupCode;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
        public int getType() {
            return this.type;
        }

        public int hashCode() {
            BackupCode backupCode = this.backupCode;
            if (backupCode != null) {
                return backupCode.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sbU = outline.U("BackupCodeItem(backupCode=");
            sbU.append(this.backupCode);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* JADX INFO: compiled from: WidgetSettingsAccountBackupCodes.kt */
    public static final /* data */ class BackupCodeItemHeader implements MGRecyclerDataPayload {
        private final CharSequence headerText;
        private final String key;
        private final int type;

        public BackupCodeItemHeader(CharSequence charSequence) {
            Intrinsics3.checkNotNullParameter(charSequence, "headerText");
            this.headerText = charSequence;
            this.key = charSequence.toString();
        }

        public static /* synthetic */ BackupCodeItemHeader copy$default(BackupCodeItemHeader backupCodeItemHeader, CharSequence charSequence, int i, Object obj) {
            if ((i & 1) != 0) {
                charSequence = backupCodeItemHeader.headerText;
            }
            return backupCodeItemHeader.copy(charSequence);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final CharSequence getHeaderText() {
            return this.headerText;
        }

        public final BackupCodeItemHeader copy(CharSequence headerText) {
            Intrinsics3.checkNotNullParameter(headerText, "headerText");
            return new BackupCodeItemHeader(headerText);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof BackupCodeItemHeader) && Intrinsics3.areEqual(this.headerText, ((BackupCodeItemHeader) other).headerText);
            }
            return true;
        }

        public final CharSequence getHeaderText() {
            return this.headerText;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
        public int getType() {
            return this.type;
        }

        public int hashCode() {
            CharSequence charSequence = this.headerText;
            if (charSequence != null) {
                return charSequence.hashCode();
            }
            return 0;
        }

        public String toString() {
            return outline.E(outline.U("BackupCodeItemHeader(headerText="), this.headerText, ")");
        }
    }

    /* JADX INFO: compiled from: WidgetSettingsAccountBackupCodes.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context) {
            Intrinsics3.checkNotNullParameter(context, "context");
            AppScreen2.d(context, WidgetSettingsAccountBackupCodes.class, new Intent());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.account.WidgetSettingsAccountBackupCodes$getBackupCodes$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetSettingsAccountBackupCodes.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<GetBackupCodesResponse, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GetBackupCodesResponse getBackupCodesResponse) {
            invoke2(getBackupCodesResponse);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GetBackupCodesResponse getBackupCodesResponse) {
            List<BackupCode> listA = getBackupCodesResponse.a();
            ArrayList arrayList = new ArrayList();
            for (Object obj : listA) {
                if (!((BackupCode) obj).getConsumed()) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = new ArrayList();
            for (Object obj2 : listA) {
                if (((BackupCode) obj2).getConsumed()) {
                    arrayList2.add(obj2);
                }
            }
            ArrayList arrayList3 = new ArrayList();
            if (!arrayList.isEmpty()) {
                arrayList3.add(new BackupCodeItemHeader(FormatUtils.b(WidgetSettingsAccountBackupCodes.this.requireContext(), R.string.user_settings_available_codes, new Object[0], (4 & 4) != 0 ? FormatUtils.b.j : null)));
                ArrayList arrayList4 = new ArrayList(Iterables2.collectionSizeOrDefault(arrayList, 10));
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    arrayList4.add(new BackupCodeItem((BackupCode) it.next()));
                }
                arrayList3.addAll(arrayList4);
            }
            if (!arrayList2.isEmpty()) {
                arrayList3.add(new BackupCodeItemHeader(FormatUtils.b(WidgetSettingsAccountBackupCodes.this.requireContext(), R.string.user_settings_used_backup_codes, new Object[0], (4 & 4) != 0 ? FormatUtils.b.j : null)));
                ArrayList arrayList5 = new ArrayList(Iterables2.collectionSizeOrDefault(arrayList2, 10));
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    arrayList5.add(new BackupCodeItem((BackupCode) it2.next()));
                }
                arrayList3.addAll(arrayList5);
            }
            WidgetSettingsAccountBackupCodes.this.configureUI(arrayList3);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.account.WidgetSettingsAccountBackupCodes$sendVerificationKey$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetSettingsAccountBackupCodes.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<GetBackupCodesSendVerificationKeyResponse, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GetBackupCodesSendVerificationKeyResponse getBackupCodesSendVerificationKeyResponse) {
            invoke2(getBackupCodesSendVerificationKeyResponse);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GetBackupCodesSendVerificationKeyResponse getBackupCodesSendVerificationKeyResponse) {
            WidgetSettingsAccountBackupCodes.this.nonce = getBackupCodesSendVerificationKeyResponse.getNonce();
            WidgetSettingsAccountBackupCodes.this.regenerateNonce = getBackupCodesSendVerificationKeyResponse.getRegenerateNonce();
            WidgetSettingsAccountBackupCodes.this.showVerificationKeyModal();
        }
    }

    public WidgetSettingsAccountBackupCodes() {
        super(R.layout.widget_settings_account_backup_codes);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetSettingsAccountBackupCodes3.INSTANCE, null, 2, null);
        this.password = "";
        this.nonce = "";
        this.regenerateNonce = "";
        this.verificationKey = "";
    }

    private final void configureUI(List<? extends MGRecyclerDataPayload> data) {
        Adapter adapter = this.backupCodesAdapter;
        if (adapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("backupCodesAdapter");
        }
        adapter.setData(data);
    }

    private final void getBackupCodes(boolean regenerate) {
        ObservableExtensionsKt.restSubscribeOn$default(ObservableExtensionsKt.withDimmer(ObservableExtensionsKt.ui$default(RestAPI.INSTANCE.getApi().getBackupCodesVerification(new GetBackupCodesVerificationRequestBody(this.verificationKey, regenerate ? this.regenerateNonce : this.nonce, regenerate)), this, null, 2, null), getBinding().f2590b, 100L), false, 1, null).k(o.a.g(getContext(), new AnonymousClass1(), null));
    }

    public static /* synthetic */ void getBackupCodes$default(WidgetSettingsAccountBackupCodes widgetSettingsAccountBackupCodes, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = false;
        }
        widgetSettingsAccountBackupCodes.getBackupCodes(z2);
    }

    private final WidgetSettingsAccountBackupCodesBinding getBinding() {
        return (WidgetSettingsAccountBackupCodesBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final void sendVerificationKey() {
        ObservableExtensionsKt.restSubscribeOn$default(ObservableExtensionsKt.ui$default(RestAPI.INSTANCE.getApi().getBackupCodesSendVerificationKey(new GetBackupCodesSendVerificationKeyRequestBody(this.password)), this, null, 2, null), false, 1, null).k(o.a.g(getContext(), new AnonymousClass1(), new Action1<Error>() { // from class: com.discord.widgets.settings.account.WidgetSettingsAccountBackupCodes.sendVerificationKey.2
            @Override // rx.functions.Action1
            public final void call(Error error) {
                WidgetSettingsAccountBackupCodes.this.showPasswordModal();
            }
        }));
    }

    private final void showPasswordModal() {
        AppActivity appActivity = getAppActivity();
        if (appActivity != null) {
            WidgetNoticeDialog.Companion companion = WidgetNoticeDialog.INSTANCE;
            CharSequence charSequenceB = FormatUtils.b(requireContext(), R.string.user_settings_enter_password_view_codes, new Object[0], (4 & 4) != 0 ? FormatUtils.b.j : null);
            CharSequence charSequenceB2 = FormatUtils.b(requireContext(), R.string.form_label_password, new Object[0], (4 & 4) != 0 ? FormatUtils.b.j : null);
            companion.showInputModal(appActivity, FormatUtils.b(requireContext(), R.string.two_fa_backup_codes_label, new Object[0], (4 & 4) != 0 ? FormatUtils.b.j : null), charSequenceB, charSequenceB2, new WidgetSettingsAccountBackupCodes4(this), (640 & 32) != 0 ? null : new WidgetSettingsAccountBackupCodes5(this), (640 & 64) != 0 ? null : Boolean.FALSE, (640 & 128) != 0 ? StoreNotices.InputDialog.Type.PASSWORD : null, (640 & 256) != 0 ? null : FormatUtils.b(requireContext(), R.string.two_fa_backup_codes_next_action, new Object[0], (4 & 4) != 0 ? FormatUtils.b.j : null), (640 & 512) != 0 ? false : false);
        }
    }

    private final void showVerificationKeyModal() {
        AppActivity appActivity = getAppActivity();
        if (appActivity != null) {
            WidgetNoticeDialog.INSTANCE.showInputModal(appActivity, FormatUtils.b(requireContext(), R.string.two_fa_confirm_view_backup_codes_label, new Object[0], (4 & 4) != 0 ? FormatUtils.b.j : null), FormatUtils.b(requireContext(), R.string.two_fa_confirm_view_backup_codes_body, new Object[0], (4 & 4) != 0 ? FormatUtils.b.j : null), FormatUtils.b(requireContext(), R.string.two_fa_confirm_view_backup_codes_input_label, new Object[0], (4 & 4) != 0 ? FormatUtils.b.j : null), new WidgetSettingsAccountBackupCodes6(this), (640 & 32) != 0 ? null : new WidgetSettingsAccountBackupCodes7(this), (640 & 64) != 0 ? null : Boolean.FALSE, (640 & 128) != 0 ? StoreNotices.InputDialog.Type.PASSWORD : StoreNotices.InputDialog.Type.TEXT_NO_SUGGESTIONS, (640 & 256) != 0 ? null : null, (640 & 512) != 0 ? false : true);
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setActionBarSubtitle(R.string.user_settings);
        setActionBarTitle(R.string.two_fa_backup_codes_label);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        TextView textView = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.settingsBackupCodesInfo");
        FormatUtils.m(textView, R.string.two_fa_backup_codes_body, new Object[0], (4 & 4) != 0 ? FormatUtils.g.j : null);
        RecyclerView recyclerView = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.settingsBackupCodesRv");
        this.backupCodesAdapter = new Adapter(recyclerView);
        if (e() != null) {
            MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
            RecyclerView recyclerView2 = getBinding().e;
            Intrinsics3.checkNotNullExpressionValue(recyclerView2, "binding.settingsBackupCodesRv");
            this.backupCodesAdapter = (Adapter) companion.configure(new Adapter(recyclerView2));
        }
        getBinding().c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.account.WidgetSettingsAccountBackupCodes.onViewBound.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetSettingsAccountBackupCodes.this.getBackupCodes(true);
            }
        });
        getBinding().f2590b.setDimmed(true, true);
        showPasswordModal();
    }
}
