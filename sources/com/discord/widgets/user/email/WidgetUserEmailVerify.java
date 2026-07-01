package com.discord.widgets.user.email;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.ActivityResultLauncher;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.databinding.WidgetUserEmailVerifyBinding;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.user.account.WidgetUserAccountVerifyBase;
import com.discord.widgets.user.account.WidgetUserAccountVerifyBase$Mode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetUserEmailVerify.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserEmailVerify extends WidgetUserAccountVerifyBase {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetUserEmailVerify.class, "binding", "getBinding()Lcom/discord/databinding/WidgetUserEmailVerifyBinding;", 0)};
    public static final WidgetUserEmailVerify$Companion Companion = new WidgetUserEmailVerify$Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final ActivityResultLauncher<Intent> emailUpdateLauncher;

    public WidgetUserEmailVerify() {
        super(R$layout.widget_user_email_verify);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetUserEmailVerify$binding$2.INSTANCE, null, 2, null);
        this.emailUpdateLauncher = WidgetUserEmailUpdate.Companion.registerForResult(this, new WidgetUserEmailVerify$emailUpdateLauncher$1(this));
    }

    public static final /* synthetic */ void access$configureUI(WidgetUserEmailVerify widgetUserEmailVerify, WidgetUserEmailVerify$Model widgetUserEmailVerify$Model) {
        widgetUserEmailVerify.configureUI(widgetUserEmailVerify$Model);
    }

    public static final /* synthetic */ WidgetUserAccountVerifyBase$Mode access$getMode$p(WidgetUserEmailVerify widgetUserEmailVerify) {
        return widgetUserEmailVerify.getMode();
    }

    public static final /* synthetic */ void access$setMode$p(WidgetUserEmailVerify widgetUserEmailVerify, WidgetUserAccountVerifyBase$Mode widgetUserAccountVerifyBase$Mode) {
        widgetUserEmailVerify.setMode(widgetUserAccountVerifyBase$Mode);
    }

    private final void configureUI(WidgetUserEmailVerify$Model model) {
        if (model.getVerified()) {
            requireActivity().setResult(-1);
            requireActivity().finish();
        } else if (model.getEmail() == null) {
            WidgetUserEmailUpdate.Companion.launch(requireContext(), getMode(), this.emailUpdateLauncher);
        } else {
            getBinding().f2681b.setOnClickListener(new WidgetUserEmailVerify$configureUI$1(this));
            getBinding().c.setOnClickListener(new WidgetUserEmailVerify$configureUI$2(this, model));
        }
    }

    private final WidgetUserEmailVerifyBinding getBinding() {
        return (WidgetUserEmailVerifyBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.widgets.user.account.WidgetUserAccountVerifyBase, com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(WidgetUserEmailVerify$Model.Companion.get(), this, null, 2, null), WidgetUserEmailVerify.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetUserEmailVerify$onViewBoundOrOnResume$1(this), 62, (Object) null);
    }
}
