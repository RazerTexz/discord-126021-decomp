package com.discord.widgets.user.phone;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.databinding.WidgetUserPhoneManageBinding;
import com.discord.models.user.MeUser;
import com.discord.restapi.RestAPIParams$Phone;
import com.discord.stores.StorePhone;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.captcha.CaptchaHelper$CaptchaPayload;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.intent.IntentUtilsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.user.UserUtils;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.captcha.WidgetCaptcha;
import com.discord.widgets.notice.WidgetNoticeDialog;
import com.discord.widgets.notice.WidgetNoticeDialog$Companion;
import com.discord.widgets.user.WidgetUserPasswordVerify;
import com.discord.widgets.user.account.WidgetUserAccountVerifyBase;
import com.discord.widgets.user.account.WidgetUserAccountVerifyBase$Mode;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.button.MaterialButton;
import d0.g0.t;
import d0.o;
import d0.t.g0;
import d0.z.d.m;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetUserPhoneManage.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserPhoneManage extends WidgetUserAccountVerifyBase {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetUserPhoneManage.class, "binding", "getBinding()Lcom/discord/databinding/WidgetUserPhoneManageBinding;", 0)};
    public static final WidgetUserPhoneManage$Companion Companion = new WidgetUserPhoneManage$Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final ActivityResultLauncher<Intent> captchaLauncher;
    private final ActivityResultLauncher<Intent> passwordVerifyLauncher;
    private final ActivityResultLauncher<Intent> phoneVerificationLauncher;
    private String source;

    public WidgetUserPhoneManage() {
        super(R$layout.widget_user_phone_manage);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetUserPhoneManage$binding$2.INSTANCE, null, 2, null);
        this.passwordVerifyLauncher = WidgetUserPasswordVerify.Companion.registerForResult(this, new WidgetUserPhoneManage$passwordVerifyLauncher$1(this));
        this.phoneVerificationLauncher = WidgetUserPhoneVerify.Companion.registerForResult(this, new WidgetUserPhoneManage$phoneVerificationLauncher$1(this));
        this.captchaLauncher = WidgetCaptcha.Companion.registerForResult(this, new WidgetUserPhoneManage$captchaLauncher$1(this));
    }

    public static final /* synthetic */ void access$configureUI(WidgetUserPhoneManage widgetUserPhoneManage, MeUser meUser) {
        widgetUserPhoneManage.configureUI(meUser);
    }

    public static final /* synthetic */ WidgetUserPhoneManageBinding access$getBinding$p(WidgetUserPhoneManage widgetUserPhoneManage) {
        return widgetUserPhoneManage.getBinding();
    }

    public static final /* synthetic */ ActivityResultLauncher access$getCaptchaLauncher$p(WidgetUserPhoneManage widgetUserPhoneManage) {
        return widgetUserPhoneManage.captchaLauncher;
    }

    public static final /* synthetic */ WidgetUserAccountVerifyBase$Mode access$getMode$p(WidgetUserPhoneManage widgetUserPhoneManage) {
        return widgetUserPhoneManage.getMode();
    }

    public static final /* synthetic */ ActivityResultLauncher access$getPasswordVerifyLauncher$p(WidgetUserPhoneManage widgetUserPhoneManage) {
        return widgetUserPhoneManage.passwordVerifyLauncher;
    }

    public static final /* synthetic */ ActivityResultLauncher access$getPhoneVerificationLauncher$p(WidgetUserPhoneManage widgetUserPhoneManage) {
        return widgetUserPhoneManage.phoneVerificationLauncher;
    }

    public static final /* synthetic */ String access$getSource$p(WidgetUserPhoneManage widgetUserPhoneManage) {
        String str = widgetUserPhoneManage.source;
        if (str == null) {
            m.throwUninitializedPropertyAccessException("source");
        }
        return str;
    }

    public static final /* synthetic */ void access$handlePhoneNumberTextChanged(WidgetUserPhoneManage widgetUserPhoneManage) {
        widgetUserPhoneManage.handlePhoneNumberTextChanged();
    }

    public static final /* synthetic */ void access$removePhoneNumber(WidgetUserPhoneManage widgetUserPhoneManage) {
        widgetUserPhoneManage.removePhoneNumber();
    }

    public static final /* synthetic */ void access$setMode$p(WidgetUserPhoneManage widgetUserPhoneManage, WidgetUserAccountVerifyBase$Mode widgetUserAccountVerifyBase$Mode) {
        widgetUserPhoneManage.setMode(widgetUserAccountVerifyBase$Mode);
    }

    public static final /* synthetic */ void access$setSource$p(WidgetUserPhoneManage widgetUserPhoneManage, String str) {
        widgetUserPhoneManage.source = str;
    }

    public static final /* synthetic */ void access$updatePhoneNumber(WidgetUserPhoneManage widgetUserPhoneManage, CaptchaHelper$CaptchaPayload captchaHelper$CaptchaPayload) {
        widgetUserPhoneManage.updatePhoneNumber(captchaHelper$CaptchaPayload);
    }

    private final void configureUI(MeUser meUser) {
        if (meUser.getPhoneNumber() != null) {
            getBinding().g.setText(2131893795);
            TextView textView = getBinding().d;
            m.checkNotNullExpressionValue(textView, "binding.userPhoneAddDescriptionNote");
            b.n(textView, 2131893791, new Object[]{meUser.getPhoneNumber()}, null, 4);
            TextView textView2 = getBinding().c;
            m.checkNotNullExpressionValue(textView2, "binding.removePhone");
            textView2.setVisibility(0);
        } else {
            getBinding().g.setText(2131888879);
            getBinding().d.setText(2131888876);
            TextView textView3 = getBinding().c;
            m.checkNotNullExpressionValue(textView3, "binding.removePhone");
            textView3.setVisibility(8);
        }
        if (meUser.getEmail() == null) {
            TextView textView4 = getBinding().c;
            m.checkNotNullExpressionValue(textView4, "binding.removePhone");
            textView4.setVisibility(8);
        }
    }

    private final WidgetUserPhoneManageBinding getBinding() {
        return (WidgetUserPhoneManageBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final void handlePhoneNumberTextChanged() {
        String textOrEmpty = getBinding().f.getTextOrEmpty();
        MaterialButton materialButton = getBinding().e;
        m.checkNotNullExpressionValue(materialButton, "binding.userPhoneAddNext");
        materialButton.setEnabled((textOrEmpty.length() > 0) && t.startsWith$default(textOrEmpty, BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX, false, 2, null));
    }

    private final void removePhoneNumber() {
        if (!UserUtils.INSTANCE.isMfaSMSEnabled(StoreStream.Companion.getUsers().getMeSnapshot())) {
            WidgetUserPasswordVerify.Companion.launchRemovePhoneNumber(requireContext(), this.passwordVerifyLauncher);
            return;
        }
        WidgetNoticeDialog$Companion widgetNoticeDialog$Companion = WidgetNoticeDialog.Companion;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        Resources resources = getResources();
        m.checkNotNullExpressionValue(resources, "resources");
        CharSequence charSequenceI = b.i(resources, 2131896832, new Object[0], null, 4);
        Resources resources2 = getResources();
        m.checkNotNullExpressionValue(resources2, "resources");
        CharSequence charSequenceI2 = b.i(resources2, 2131896831, new Object[0], null, 4);
        Resources resources3 = getResources();
        m.checkNotNullExpressionValue(resources3, "resources");
        CharSequence charSequenceI3 = b.i(resources3, 2131894737, new Object[0], null, 4);
        Resources resources4 = getResources();
        m.checkNotNullExpressionValue(resources4, "resources");
        WidgetNoticeDialog$Companion.show$default(widgetNoticeDialog$Companion, parentFragmentManager, charSequenceI, charSequenceI2, charSequenceI3, b.i(resources4, 2131887437, new Object[0], null, 4), g0.mapOf(o.to(2131364555, new WidgetUserPhoneManage$removePhoneNumber$1(this))), null, null, null, 2130969885, null, null, 0, null, 15808, null);
    }

    private final void updatePhoneNumber(CaptchaHelper$CaptchaPayload captchaPayload) {
        String textOrEmpty = getBinding().f.getTextOrEmpty();
        RestAPI api = RestAPI.Companion.getApi();
        String str = this.source;
        if (str == null) {
            m.throwUninitializedPropertyAccessException("source");
        }
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.withDimmer$default(ObservableExtensionsKt.restSubscribeOn$default(api.userAddPhone(new RestAPIParams$Phone(textOrEmpty, str, captchaPayload != null ? captchaPayload.getCaptchaKey() : null, captchaPayload != null ? captchaPayload.getCaptchaRqtoken() : null)), false, 1, null), getBinding().f2687b, 0L, 2, null), this, null, 2, null), WidgetUserPhoneManage.class, (Context) null, (Function1) null, new WidgetUserPhoneManage$updatePhoneNumber$1(this), (Function0) null, (Function0) null, new WidgetUserPhoneManage$updatePhoneNumber$2(this, textOrEmpty), 54, (Object) null);
    }

    public static /* synthetic */ void updatePhoneNumber$default(WidgetUserPhoneManage widgetUserPhoneManage, CaptchaHelper$CaptchaPayload captchaHelper$CaptchaPayload, int i, Object obj) {
        if ((i & 1) != 0) {
            captchaHelper$CaptchaPayload = null;
        }
        widgetUserPhoneManage.updatePhoneNumber(captchaHelper$CaptchaPayload);
    }

    @Override // com.discord.widgets.user.account.WidgetUserAccountVerifyBase, com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setActionBarDisplayHomeAsUpEnabled(!isForced(), Integer.valueOf(DrawableCompat.getThemedDrawableRes$default(view, 2130969455, 0, 2, (Object) null)), !isForced() ? 2131887680 : null);
        this.source = IntentUtilsKt.getStringExtraOrDefault(getMostRecentIntent(), "intent_args_key", WidgetUserPhoneManage$Companion$Source.DEFAULT.getSource());
        getBinding().f.b(this);
        StorePhone phone = StoreStream.Companion.getPhone();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservationDeck.connectRx$default(ObservationDeckProvider.get(), new ObservationDeck$UpdateSource[]{phone}, false, null, null, new WidgetUserPhoneManage$onViewBound$1(phone), 14, null), this, null, 2, null), WidgetUserPhoneManage.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetUserPhoneManage$onViewBound$2(this), 62, (Object) null);
        getBinding().f.a(this, new WidgetUserPhoneManage$onViewBound$3(this));
        getBinding().e.setOnClickListener(new WidgetUserPhoneManage$onViewBound$4(this));
        getBinding().c.setOnClickListener(new WidgetUserPhoneManage$onViewBound$5(this));
    }

    @Override // com.discord.widgets.user.account.WidgetUserAccountVerifyBase, com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(StoreUser.observeMe$default(StoreStream.Companion.getUsers(), false, 1, null), this, null, 2, null), WidgetUserPhoneManage.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetUserPhoneManage$onViewBoundOrOnResume$1(this), 62, (Object) null);
    }
}
