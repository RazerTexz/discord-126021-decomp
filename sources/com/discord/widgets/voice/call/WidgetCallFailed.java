package com.discord.widgets.voice.call;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import b.a.d.o;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppDialog;
import com.discord.databinding.ViewDialogConfirmationBinding;
import com.discord.models.user.User;
import com.discord.stores.StoreStream;
import com.discord.utilities.captcha.CaptchaHelper$CaptchaPayload;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.google.android.material.button.MaterialButton;
import d0.z.d.m;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetCallFailed.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetCallFailed extends AppDialog {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetCallFailed.class, "binding", "getBinding()Lcom/discord/databinding/ViewDialogConfirmationBinding;", 0)};
    public static final WidgetCallFailed$Companion Companion = new WidgetCallFailed$Companion(null);
    private static final String INTENT_USER_ID = "INTENT_USER_ID";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    public WidgetCallFailed() {
        super(R$layout.view_dialog_confirmation);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetCallFailed$binding$2.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ void access$configureUI(WidgetCallFailed widgetCallFailed, User user) {
        widgetCallFailed.configureUI(user);
    }

    public static final /* synthetic */ void access$sendFriendRequest(WidgetCallFailed widgetCallFailed, long j, String str, CaptchaHelper$CaptchaPayload captchaHelper$CaptchaPayload) {
        widgetCallFailed.sendFriendRequest(j, str, captchaHelper$CaptchaPayload);
    }

    private final void configureUI(User user) {
        if (user == null) {
            dismiss();
            return;
        }
        TextView textView = getBinding().e;
        m.checkNotNullExpressionValue(textView, "binding.viewDialogConfirmationText");
        b.n(textView, 2131887381, new Object[]{user.getUsername()}, null, 4);
        getBinding().c.setOnClickListener(new WidgetCallFailed$configureUI$$inlined$let$lambda$1(this, user));
    }

    private final ViewDialogConfirmationBinding getBinding() {
        return (ViewDialogConfirmationBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final void sendFriendRequest(long userId, String username, CaptchaHelper$CaptchaPayload captchaPayload) {
        ObservableExtensionsKt.ui$default(RestAPI.addRelationship$default(RestAPI.Companion.getApi(), "Call", userId, null, null, captchaPayload, 8, null), this, null, 2, null).k(o.h(new WidgetCallFailed$sendFriendRequest$1(this), getAppActivity(), new WidgetCallFailed$sendFriendRequest$2(this, userId, username)));
    }

    public static /* synthetic */ void sendFriendRequest$default(WidgetCallFailed widgetCallFailed, long j, String str, CaptchaHelper$CaptchaPayload captchaHelper$CaptchaPayload, int i, Object obj) {
        if ((i & 4) != 0) {
            captchaHelper$CaptchaPayload = null;
        }
        widgetCallFailed.sendFriendRequest(j, str, captchaHelper$CaptchaPayload);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        TextView textView = getBinding().d;
        m.checkNotNullExpressionValue(textView, "binding.viewDialogConfirmationHeader");
        textView.setText(getString(2131895862));
        MaterialButton materialButton = getBinding().c;
        m.checkNotNullExpressionValue(materialButton, "binding.viewDialogConfirmationConfirm");
        materialButton.setText(getString(2131886326));
        MaterialButton materialButton2 = getBinding().f2185b;
        m.checkNotNullExpressionValue(materialButton2, "binding.viewDialogConfirmationCancel");
        materialButton2.setText(getString(2131893499));
        getBinding().f2185b.setOnClickListener(new WidgetCallFailed$onViewBound$1(this));
    }

    @Override // com.discord.app.AppDialog
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(StoreStream.Companion.getUsers().observeUser(getArgumentsOrDefault().getLong(INTENT_USER_ID)), this, null, 2, null), WidgetCallFailed.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetCallFailed$onViewBoundOrOnResume$1(this), 62, (Object) null);
    }
}
