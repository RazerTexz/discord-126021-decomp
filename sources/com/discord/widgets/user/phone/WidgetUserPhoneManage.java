package com.discord.widgets.user.phone;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.a.d.AppScreen2;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.databinding.WidgetUserPhoneManageBinding;
import com.discord.models.phone.PhoneCountryCode;
import com.discord.models.user.MeUser;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StorePhone;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.captcha.CaptchaHelper;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.error.Error;
import com.discord.utilities.features.GrowthTeamFeatures;
import com.discord.utilities.intent.IntentUtilsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.user.UserUtils;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.captcha.WidgetCaptcha;
import com.discord.widgets.notice.WidgetNoticeDialog;
import com.discord.widgets.user.WidgetUserPasswordVerify;
import com.discord.widgets.user.account.WidgetUserAccountVerifyBase;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.button.MaterialButton;
import d0.Tuples;
import d0.g0.StringsJVM;
import d0.t.MapsJVM;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Collection;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Subscription;

/* JADX INFO: compiled from: WidgetUserPhoneManage.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserPhoneManage extends WidgetUserAccountVerifyBase {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetUserPhoneManage.class, "binding", "getBinding()Lcom/discord/databinding/WidgetUserPhoneManageBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final ActivityResultLauncher<Intent> captchaLauncher;
    private final ActivityResultLauncher<Intent> passwordVerifyLauncher;
    private final ActivityResultLauncher<Intent> phoneVerificationLauncher;
    private String source;

    /* JADX INFO: compiled from: WidgetUserPhoneManage.kt */
    public static final class Companion {

        /* JADX INFO: compiled from: WidgetUserPhoneManage.kt */
        public enum Source {
            USER_ACTION_REQUIRED("user_action_required"),
            USER_SETTINGS_UPDATE("user_settings_update"),
            GUILD_PHONE_REQUIRED("guild_phone_required"),
            MFA_PHONE_UPDATE("mfa_phone_update"),
            CONTACT_SYNC("contact_sync"),
            DEFAULT("update_phone");

            private final String source;

            Source(String str) {
                this.source = str;
            }

            public final String getSource() {
                return this.source;
            }
        }

        private Companion() {
        }

        public final void launch(Context context, WidgetUserAccountVerifyBase.Mode mode, Source source) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(mode, "mode");
            Intrinsics3.checkNotNullParameter(source, "source");
            Intent launchIntent = WidgetUserAccountVerifyBase.INSTANCE.getLaunchIntent(mode, true, false);
            if (mode == WidgetUserAccountVerifyBase.Mode.NO_HISTORY_FROM_USER_SETTINGS) {
                launchIntent.addFlags(BasicMeasure.EXACTLY);
            }
            launchIntent.putExtra("intent_args_key", source.getSource());
            AppScreen2.d(context, WidgetUserPhoneManage.class, launchIntent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.phone.WidgetUserPhoneManage$onViewBound$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetUserPhoneManage.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<PhoneCountryCode> {
        public final /* synthetic */ StorePhone $phoneStore;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(StorePhone storePhone) {
            super(0);
            this.$phoneStore = storePhone;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final PhoneCountryCode invoke() {
            return this.$phoneStore.getCountryCode();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.phone.WidgetUserPhoneManage$onViewBound$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetUserPhoneManage.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<PhoneCountryCode, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(PhoneCountryCode phoneCountryCode) {
            invoke2(phoneCountryCode);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(PhoneCountryCode phoneCountryCode) {
            Intrinsics3.checkNotNullParameter(phoneCountryCode, "it");
            WidgetUserPhoneManage.this.getBinding().f.setCountryCode(phoneCountryCode);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.phone.WidgetUserPhoneManage$onViewBound$3, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetUserPhoneManage.kt */
    public static final class AnonymousClass3 extends Lambda implements Function0<Unit> {
        public AnonymousClass3() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetUserPhoneManage.this.handlePhoneNumberTextChanged();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.phone.WidgetUserPhoneManage$onViewBoundOrOnResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetUserPhoneManage.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<MeUser, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(MeUser meUser) {
            invoke2(meUser);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(MeUser meUser) {
            Intrinsics3.checkNotNullParameter(meUser, "it");
            WidgetUserPhoneManage.this.configureUI(meUser);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.phone.WidgetUserPhoneManage$removePhoneNumber$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetUserPhoneManage.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<View, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            Intrinsics3.checkNotNullParameter(view, "it");
            WidgetUserPasswordVerify.INSTANCE.launchRemovePhoneNumber(WidgetUserPhoneManage.this.requireContext(), WidgetUserPhoneManage.this.passwordVerifyLauncher);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.phone.WidgetUserPhoneManage$updatePhoneNumber$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetUserPhoneManage.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Error, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "error");
            if (GrowthTeamFeatures.INSTANCE.isPhoneVerifyCaptchaEnabled()) {
                WidgetCaptcha.Companion companion = WidgetCaptcha.INSTANCE;
                Context contextRequireContext = WidgetUserPhoneManage.this.requireContext();
                ActivityResultLauncher<Intent> activityResultLauncher = WidgetUserPhoneManage.this.captchaLauncher;
                Error.Response response = error.getResponse();
                Intrinsics3.checkNotNullExpressionValue(response, "error.response");
                companion.processErrorsForCaptcha(contextRequireContext, activityResultLauncher, _Collections.toMutableList((Collection) response.getMessages().keySet()), error);
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.phone.WidgetUserPhoneManage$updatePhoneNumber$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetUserPhoneManage.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Void, Unit> {
        public final /* synthetic */ String $phoneNumber;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(String str) {
            super(1);
            this.$phoneNumber = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r7) {
            WidgetUserPhoneVerify.INSTANCE.launch(WidgetUserPhoneManage.this.requireContext(), WidgetUserPhoneManage.this.phoneVerificationLauncher, WidgetUserPhoneManage.this.getMode(), this.$phoneNumber, WidgetUserPhoneManage.access$getSource$p(WidgetUserPhoneManage.this));
        }
    }

    public WidgetUserPhoneManage() {
        super(R.layout.widget_user_phone_manage);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetUserPhoneManage2.INSTANCE, null, 2, null);
        this.passwordVerifyLauncher = WidgetUserPasswordVerify.INSTANCE.registerForResult(this, new WidgetUserPhoneManage4(this));
        this.phoneVerificationLauncher = WidgetUserPhoneVerify.INSTANCE.registerForResult(this, new WidgetUserPhoneManage5(this));
        this.captchaLauncher = WidgetCaptcha.INSTANCE.registerForResult(this, new WidgetUserPhoneManage3(this));
    }

    public static final /* synthetic */ String access$getSource$p(WidgetUserPhoneManage widgetUserPhoneManage) {
        String str = widgetUserPhoneManage.source;
        if (str == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("source");
        }
        return str;
    }

    private final void configureUI(MeUser meUser) {
        if (meUser.getPhoneNumber() != null) {
            getBinding().g.setText(R.string.phone_verification_update_title);
            TextView textView = getBinding().d;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.userPhoneAddDescriptionNote");
            FormatUtils.m(textView, R.string.phone_verification_current_phone, new Object[]{meUser.getPhoneNumber()}, (4 & 4) != 0 ? FormatUtils.g.j : null);
            TextView textView2 = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.removePhone");
            textView2.setVisibility(0);
        } else {
            getBinding().g.setText(R.string.enter_phone_title);
            getBinding().d.setText(R.string.enter_phone_description);
            TextView textView3 = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(textView3, "binding.removePhone");
            textView3.setVisibility(8);
        }
        if (meUser.getEmail() == null) {
            TextView textView4 = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(textView4, "binding.removePhone");
            textView4.setVisibility(8);
        }
    }

    private final WidgetUserPhoneManageBinding getBinding() {
        return (WidgetUserPhoneManageBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final void handlePhoneNumberTextChanged() {
        String textOrEmpty = getBinding().f.getTextOrEmpty();
        MaterialButton materialButton = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.userPhoneAddNext");
        materialButton.setEnabled((textOrEmpty.length() > 0) && StringsJVM.startsWith$default(textOrEmpty, BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX, false, 2, null));
    }

    private final void removePhoneNumber() {
        if (!UserUtils.INSTANCE.isMfaSMSEnabled(StoreStream.INSTANCE.getUsers().getMeSnapshot())) {
            WidgetUserPasswordVerify.INSTANCE.launchRemovePhoneNumber(requireContext(), this.passwordVerifyLauncher);
            return;
        }
        WidgetNoticeDialog.Companion companion = WidgetNoticeDialog.INSTANCE;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        Resources resources = getResources();
        Intrinsics3.checkNotNullExpressionValue(resources, "resources");
        CharSequence charSequenceC = FormatUtils.c(resources, R.string.user_settings_account_remove_phone_number_warning_title, new Object[0], (4 & 4) != 0 ? FormatUtils.d.j : null);
        Resources resources2 = getResources();
        Intrinsics3.checkNotNullExpressionValue(resources2, "resources");
        CharSequence charSequenceC2 = FormatUtils.c(resources2, R.string.user_settings_account_remove_phone_number_warning_body, new Object[0], (4 & 4) != 0 ? FormatUtils.d.j : null);
        Resources resources3 = getResources();
        Intrinsics3.checkNotNullExpressionValue(resources3, "resources");
        CharSequence charSequenceC3 = FormatUtils.c(resources3, R.string.remove, new Object[0], (4 & 4) != 0 ? FormatUtils.d.j : null);
        Resources resources4 = getResources();
        Intrinsics3.checkNotNullExpressionValue(resources4, "resources");
        WidgetNoticeDialog.Companion.show$default(companion, parentFragmentManager, charSequenceC, charSequenceC2, charSequenceC3, FormatUtils.c(resources4, R.string.cancel, new Object[0], (4 & 4) != 0 ? FormatUtils.d.j : null), MapsJVM.mapOf(Tuples.to(Integer.valueOf(R.id.notice_ok), new AnonymousClass1())), null, null, null, Integer.valueOf(R.attr.notice_theme_positive_red), null, null, 0, null, 15808, null);
    }

    private final void updatePhoneNumber(CaptchaHelper.CaptchaPayload captchaPayload) {
        String textOrEmpty = getBinding().f.getTextOrEmpty();
        RestAPI api = RestAPI.INSTANCE.getApi();
        String str = this.source;
        if (str == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("source");
        }
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.withDimmer$default(ObservableExtensionsKt.restSubscribeOn$default(api.userAddPhone(new RestAPIParams.Phone(textOrEmpty, str, captchaPayload != null ? captchaPayload.getCaptchaKey() : null, captchaPayload != null ? captchaPayload.getCaptchaRqtoken() : null)), false, 1, null), getBinding().f2687b, 0L, 2, null), this, null, 2, null), (Class<?>) WidgetUserPhoneManage.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new AnonymousClass1()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2(textOrEmpty));
    }

    public static /* synthetic */ void updatePhoneNumber$default(WidgetUserPhoneManage widgetUserPhoneManage, CaptchaHelper.CaptchaPayload captchaPayload, int i, Object obj) {
        if ((i & 1) != 0) {
            captchaPayload = null;
        }
        widgetUserPhoneManage.updatePhoneNumber(captchaPayload);
    }

    @Override // com.discord.widgets.user.account.WidgetUserAccountVerifyBase, com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setActionBarDisplayHomeAsUpEnabled(!isForced(), Integer.valueOf(DrawableCompat.getThemedDrawableRes$default(view, R.attr.ic_action_bar_close, 0, 2, (Object) null)), !isForced() ? Integer.valueOf(R.string.close) : null);
        this.source = IntentUtilsKt.getStringExtraOrDefault(getMostRecentIntent(), "intent_args_key", Companion.Source.DEFAULT.getSource());
        getBinding().f.b(this);
        StorePhone phone = StoreStream.INSTANCE.getPhone();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservationDeck.connectRx$default(ObservationDeck4.get(), new ObservationDeck.UpdateSource[]{phone}, false, null, null, new AnonymousClass1(phone), 14, null), this, null, 2, null), (Class<?>) WidgetUserPhoneManage.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2());
        getBinding().f.a(this, new AnonymousClass3());
        getBinding().e.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.user.phone.WidgetUserPhoneManage.onViewBound.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetUserPhoneManage.updatePhoneNumber$default(WidgetUserPhoneManage.this, null, 1, null);
            }
        });
        getBinding().c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.user.phone.WidgetUserPhoneManage.onViewBound.5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetUserPhoneManage.this.removePhoneNumber();
            }
        });
    }

    @Override // com.discord.widgets.user.account.WidgetUserAccountVerifyBase, com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(StoreUser.observeMe$default(StoreStream.INSTANCE.getUsers(), false, 1, null), this, null, 2, null), (Class<?>) WidgetUserPhoneManage.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
    }
}
