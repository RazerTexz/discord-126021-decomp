package com.discord.widgets.settings.account.mfa;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetSettingsEnableMfaInputBinding;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0863f0;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetEnableMFAInput.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEnableMFAInput extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetEnableMFAInput.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsEnableMfaInputBinding;", 0)};

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: renamed from: com.discord.widgets.settings.account.mfa.WidgetEnableMFAInput$onViewBound$1 */
    /* JADX INFO: compiled from: WidgetEnableMFAInput.kt */
    public static final class C97881 extends AbstractC12240o implements Function1<String, Unit> {
        public final /* synthetic */ View $view;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C97881(View view) {
            super(1);
            this.$view = view;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            C12238m.checkNotNullParameter(str, "verificationCode");
            WidgetEnableMFAViewModel viewModel = WidgetEnableMFAInput.this.getViewModel();
            Context context = this.$view.getContext();
            C12238m.checkNotNullExpressionValue(context, "view.context");
            viewModel.enableMFA(context, str);
        }
    }

    public WidgetEnableMFAInput() {
        super(C5419R.layout.widget_settings_enable_mfa_input);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetEnableMFAInput$binding$2.INSTANCE, null, 2, null);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(WidgetEnableMFAViewModel.class), new C9786x16bb66e8(this), new C0863f0(WidgetEnableMFAInput$viewModel$2.INSTANCE));
    }

    private final WidgetSettingsEnableMfaInputBinding getBinding() {
        return (WidgetSettingsEnableMfaInputBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetEnableMFAViewModel getViewModel() {
        return (WidgetEnableMFAViewModel) this.viewModel.getValue();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        getBinding().f17946b.setOnCodeEntered(new C97881(view));
    }

    @Override // androidx.fragment.app.Fragment
    public void setMenuVisibility(boolean menuVisible) {
        Context context;
        ClipData primaryClip;
        super.setMenuVisibility(menuVisible);
        if (!menuVisible || (context = getContext()) == null) {
            return;
        }
        C12238m.checkNotNullExpressionValue(context, "context ?: return");
        Object systemService = context.getSystemService("clipboard");
        if (!(systemService instanceof ClipboardManager)) {
            systemService = null;
        }
        ClipboardManager clipboardManager = (ClipboardManager) systemService;
        if (clipboardManager == null || (primaryClip = clipboardManager.getPrimaryClip()) == null) {
            return;
        }
        C12238m.checkNotNullExpressionValue(primaryClip, "clipboard.primaryClip ?: return");
        if (primaryClip.getItemCount() > 0) {
            ClipData.Item itemAt = primaryClip.getItemAt(0);
            C12238m.checkNotNullExpressionValue(itemAt, "clipData.getItemAt(0)");
            CharSequence text = itemAt.getText();
            if (text != null && text.length() == 6 && TextUtils.isDigitsOnly(text)) {
                getBinding().f17946b.setCode(text);
            }
        }
    }
}
