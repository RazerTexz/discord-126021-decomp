package com.discord.widgets.settings.account.mfa;

import android.content.ClipData;
import android.content.ClipData$Item;
import android.content.ClipboardManager;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.f0;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetSettingsEnableMfaInputBinding;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import d0.z.d.a0;
import d0.z.d.m;
import kotlin.Lazy;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetEnableMFAInput.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEnableMFAInput extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetEnableMFAInput.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsEnableMfaInputBinding;", 0)};

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public WidgetEnableMFAInput() {
        super(R$layout.widget_settings_enable_mfa_input);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetEnableMFAInput$binding$2.INSTANCE, null, 2, null);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(WidgetEnableMFAViewModel.class), new WidgetEnableMFAInput$appActivityViewModels$$inlined$activityViewModels$1(this), new f0(WidgetEnableMFAInput$viewModel$2.INSTANCE));
    }

    public static final /* synthetic */ WidgetEnableMFAViewModel access$getViewModel$p(WidgetEnableMFAInput widgetEnableMFAInput) {
        return widgetEnableMFAInput.getViewModel();
    }

    private final WidgetSettingsEnableMfaInputBinding getBinding() {
        return (WidgetSettingsEnableMfaInputBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetEnableMFAViewModel getViewModel() {
        return (WidgetEnableMFAViewModel) this.viewModel.getValue();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        getBinding().f2617b.setOnCodeEntered(new WidgetEnableMFAInput$onViewBound$1(this, view));
    }

    @Override // androidx.fragment.app.Fragment
    public void setMenuVisibility(boolean menuVisible) {
        Context context;
        ClipData primaryClip;
        super.setMenuVisibility(menuVisible);
        if (!menuVisible || (context = getContext()) == null) {
            return;
        }
        m.checkNotNullExpressionValue(context, "context ?: return");
        Object systemService = context.getSystemService("clipboard");
        if (!(systemService instanceof ClipboardManager)) {
            systemService = null;
        }
        ClipboardManager clipboardManager = (ClipboardManager) systemService;
        if (clipboardManager == null || (primaryClip = clipboardManager.getPrimaryClip()) == null) {
            return;
        }
        m.checkNotNullExpressionValue(primaryClip, "clipboard.primaryClip ?: return");
        if (primaryClip.getItemCount() > 0) {
            ClipData$Item itemAt = primaryClip.getItemAt(0);
            m.checkNotNullExpressionValue(itemAt, "clipData.getItemAt(0)");
            CharSequence text = itemAt.getText();
            if (text != null && text.length() == 6 && TextUtils.isDigitsOnly(text)) {
                getBinding().f2617b.setCode(text);
            }
        }
    }
}
