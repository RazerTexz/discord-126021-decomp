package com.discord.widgets.friends;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.core.app.NotificationCompat$MessagingStyle$Message;
import androidx.fragment.app.Fragment;
import b.a.d.o;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetFriendsAddByIdBinding;
import com.discord.models.user.MeUser;
import com.discord.models.user.User;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.captcha.CaptchaErrorBody;
import com.discord.utilities.captcha.CaptchaHelper$CaptchaPayload;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.user.UserUtils;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.captcha.WidgetCaptcha;
import com.google.android.material.textfield.TextInputLayout;
import d0.g0.t;
import d0.z.d.m;
import kotlin.reflect.KProperty;
import kotlin.text.Regex;

/* JADX INFO: compiled from: WidgetFriendsAddById.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetFriendsAddById extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetFriendsAddById.class, "binding", "getBinding()Lcom/discord/databinding/WidgetFriendsAddByIdBinding;", 0)};
    public static final WidgetFriendsAddById$Companion Companion = new WidgetFriendsAddById$Companion(null);
    private static final Regex PATTERN_USERNAME = new Regex("^(.*)#(\\d{4})$");

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final ActivityResultLauncher<Intent> captchaLauncher;

    public WidgetFriendsAddById() {
        super(R$layout.widget_friends_add_by_id);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetFriendsAddById$binding$2.INSTANCE, null, 2, null);
        this.captchaLauncher = WidgetCaptcha.Companion.registerForResult(this, new WidgetFriendsAddById$captchaLauncher$1(this));
    }

    public static final /* synthetic */ void access$extractTargetAndSendFriendRequest(WidgetFriendsAddById widgetFriendsAddById, CaptchaHelper$CaptchaPayload captchaHelper$CaptchaPayload) {
        widgetFriendsAddById.extractTargetAndSendFriendRequest(captchaHelper$CaptchaPayload);
    }

    public static final /* synthetic */ WidgetFriendsAddByIdBinding access$getBinding$p(WidgetFriendsAddById widgetFriendsAddById) {
        return widgetFriendsAddById.getBinding();
    }

    public static final /* synthetic */ Regex access$getPATTERN_USERNAME$cp() {
        return PATTERN_USERNAME;
    }

    public static final /* synthetic */ void access$launchCaptchaFlow(WidgetFriendsAddById widgetFriendsAddById, Error error) {
        widgetFriendsAddById.launchCaptchaFlow(error);
    }

    public static final /* synthetic */ void access$setInputEditError(WidgetFriendsAddById widgetFriendsAddById, CharSequence charSequence) {
        widgetFriendsAddById.setInputEditError(charSequence);
    }

    private final void extractTargetAndSendFriendRequest(CaptchaHelper$CaptchaPayload captchaPayload) {
        TextInputLayout textInputLayout = getBinding().e;
        m.checkNotNullExpressionValue(textInputLayout, "binding.friendsAddTextEditWrap");
        String textOrEmpty = ViewExtensions.getTextOrEmpty(textInputLayout);
        WidgetFriendsAddById$Companion$UserNameDiscriminator widgetFriendsAddById$Companion$UserNameDiscriminatorAccess$extractUsernameAndDiscriminator = WidgetFriendsAddById$Companion.access$extractUsernameAndDiscriminator(Companion, textOrEmpty);
        if (widgetFriendsAddById$Companion$UserNameDiscriminatorAccess$extractUsernameAndDiscriminator.getDiscriminator() != null) {
            sendFriendRequest(widgetFriendsAddById$Companion$UserNameDiscriminatorAccess$extractUsernameAndDiscriminator.getUsername(), widgetFriendsAddById$Companion$UserNameDiscriminatorAccess$extractUsernameAndDiscriminator.getDiscriminator().intValue(), captchaPayload);
            return;
        }
        Context context = getContext();
        setInputEditError(context != null ? b.h(context, 2131886336, new Object[]{widgetFriendsAddById$Companion$UserNameDiscriminatorAccess$extractUsernameAndDiscriminator.getUsername()}, null, 4) : null);
        AnalyticsTracker.INSTANCE.friendRequestFailed(textOrEmpty, widgetFriendsAddById$Companion$UserNameDiscriminatorAccess$extractUsernameAndDiscriminator.getUsername(), widgetFriendsAddById$Companion$UserNameDiscriminatorAccess$extractUsernameAndDiscriminator.getDiscriminator(), "Invalid Username");
    }

    public static /* synthetic */ void extractTargetAndSendFriendRequest$default(WidgetFriendsAddById widgetFriendsAddById, CaptchaHelper$CaptchaPayload captchaHelper$CaptchaPayload, int i, Object obj) {
        if ((i & 1) != 0) {
            captchaHelper$CaptchaPayload = null;
        }
        widgetFriendsAddById.extractTargetAndSendFriendRequest(captchaHelper$CaptchaPayload);
    }

    private final WidgetFriendsAddByIdBinding getBinding() {
        return (WidgetFriendsAddByIdBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final SpannableStringBuilder getUsernameIndicatorText(User user) {
        Resources resources = getResources();
        m.checkNotNullExpressionValue(resources, "resources");
        UserUtils userUtils = UserUtils.INSTANCE;
        CharSequence charSequenceI = b.i(resources, 2131895413, new Object[]{UserUtils.getUserNameWithDiscriminator$default(userUtils, user, null, null, 3, null)}, null, 4);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequenceI);
        SpannableStringBuilder spannableStringBuilder2 = (SpannableStringBuilder) charSequenceI;
        spannableStringBuilder.setSpan(new ForegroundColorSpan(ColorCompat.getThemedColor(requireContext(), 2130968989)), spannableStringBuilder2.length() - UserUtils.getUserNameWithDiscriminator$default(userUtils, user, null, null, 3, null).length(), spannableStringBuilder2.length(), 33);
        return spannableStringBuilder;
    }

    private final void launchCaptchaFlow(Error error) {
        WidgetCaptcha.Companion.launch(requireContext(), this.captchaLauncher, CaptchaErrorBody.Companion.createFromError(error));
    }

    private final void sendFriendRequest(String username, int discriminator, CaptchaHelper$CaptchaPayload captchaPayload) {
        ObservableExtensionsKt.ui$default(RestAPI.Companion.getApi().sendRelationshipRequest("Search - Add Friend Search", username, discriminator, captchaPayload), this, null, 2, null).k(o.h(new WidgetFriendsAddById$sendFriendRequest$1(this, username), getAppActivity(), new WidgetFriendsAddById$sendFriendRequest$2(this, username, discriminator)));
    }

    public static /* synthetic */ void sendFriendRequest$default(WidgetFriendsAddById widgetFriendsAddById, String str, int i, CaptchaHelper$CaptchaPayload captchaHelper$CaptchaPayload, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            captchaHelper$CaptchaPayload = null;
        }
        widgetFriendsAddById.sendFriendRequest(str, i, captchaHelper$CaptchaPayload);
    }

    private final void setInputEditError(CharSequence error) {
        TextInputLayout textInputLayout = getBinding().e;
        m.checkNotNullExpressionValue(textInputLayout, "binding.friendsAddTextEditWrap");
        textInputLayout.setError(error);
        TextInputLayout textInputLayout2 = getBinding().e;
        m.checkNotNullExpressionValue(textInputLayout2, "binding.friendsAddTextEditWrap");
        textInputLayout2.setErrorEnabled(!(error == null || t.isBlank(error)));
    }

    private final void setInputText(String text) {
        if (text == null || t.isBlank(text)) {
            return;
        }
        TextInputLayout textInputLayout = getBinding().e;
        m.checkNotNullExpressionValue(textInputLayout, "binding.friendsAddTextEditWrap");
        ViewExtensions.setText(textInputLayout, text);
        TextInputLayout textInputLayout2 = getBinding().e;
        m.checkNotNullExpressionValue(textInputLayout2, "binding.friendsAddTextEditWrap");
        ViewExtensions.setSelectionEnd(textInputLayout2);
    }

    @Override // com.discord.app.AppFragment
    public void hideKeyboard(View view) {
        super.hideKeyboard(view);
        getBinding().e.clearFocus();
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        AppFragment.hideKeyboard$default(this, null, 1, null);
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        AnalyticsTracker.INSTANCE.friendAddViewed("Id");
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        getBinding().d.setOnClickListener(new WidgetFriendsAddById$onViewBound$1(this));
        TextInputLayout textInputLayout = getBinding().e;
        m.checkNotNullExpressionValue(textInputLayout, "binding.friendsAddTextEditWrap");
        ViewExtensions.addBindedTextWatcher(textInputLayout, this, new WidgetFriendsAddById$onViewBound$2(this));
        TextInputLayout textInputLayout2 = getBinding().e;
        m.checkNotNullExpressionValue(textInputLayout2, "binding.friendsAddTextEditWrap");
        ViewExtensions.setOnImeActionDone$default(textInputLayout2, false, new WidgetFriendsAddById$onViewBound$3(this), 1, null);
        getBinding().c.setOnClickListener(new WidgetFriendsAddById$onViewBound$4(this));
        Bundle extras = getMostRecentIntent().getExtras();
        setInputText(extras != null ? extras.getString("android.intent.extra.TEXT") : null);
        MeUser meSnapshot = StoreStream.Companion.getUsers().getMeSnapshot();
        TextView textView = getBinding().f2391b;
        m.checkNotNullExpressionValue(textView, "binding.friendAddUsernameIndicator");
        textView.setVisibility(0);
        TextView textView2 = getBinding().f2391b;
        m.checkNotNullExpressionValue(textView2, "binding.friendAddUsernameIndicator");
        textView2.setText(getUsernameIndicatorText(meSnapshot));
    }
}
