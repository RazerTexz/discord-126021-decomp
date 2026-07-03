package com.discord.widgets.voice.call;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.discord.C5419R;
import com.discord.app.AppDialog;
import com.discord.app.AppFragment;
import com.discord.databinding.ViewDialogConfirmationBinding;
import com.discord.models.user.User;
import com.discord.stores.StoreStream;
import com.discord.utilities.captcha.CaptchaErrorBody;
import com.discord.utilities.captcha.CaptchaHelper;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rest.RestAPIAbortMessages;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.captcha.WidgetCaptchaBottomSheet;
import com.discord.widgets.captcha.WidgetCaptchaKt;
import com.google.android.material.button.MaterialButton;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0876m;
import p007b.p008a.p018d.C0879o;
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Subscription;
import p658rx.functions.Action1;

/* JADX INFO: compiled from: WidgetCallFailed.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetCallFailed extends AppDialog {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetCallFailed.class, "binding", "getBinding()Lcom/discord/databinding/ViewDialogConfirmationBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_USER_ID = "INTENT_USER_ID";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: compiled from: WidgetCallFailed.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(FragmentManager fragmentManager, long userId) {
            C12238m.checkNotNullParameter(fragmentManager, "fragmentManager");
            WidgetCallFailed widgetCallFailed = new WidgetCallFailed();
            Bundle bundle = new Bundle();
            bundle.putLong(WidgetCallFailed.INTENT_USER_ID, userId);
            widgetCallFailed.setArguments(bundle);
            widgetCallFailed.show(fragmentManager, WidgetCallFailed.class.getSimpleName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.call.WidgetCallFailed$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetCallFailed.kt */
    public static final class C104121 extends AbstractC12240o implements Function1<User, Unit> {
        public C104121() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(User user) {
            invoke2(user);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(User user) {
            WidgetCallFailed.this.configureUI(user);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.call.WidgetCallFailed$sendFriendRequest$2 */
    /* JADX INFO: compiled from: WidgetCallFailed.kt */
    public static final class C104142<T> implements Action1<Error> {
        public final /* synthetic */ long $userId;
        public final /* synthetic */ String $username;

        /* JADX INFO: renamed from: com.discord.widgets.voice.call.WidgetCallFailed$sendFriendRequest$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetCallFailed.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function0<Unit> {
            public final /* synthetic */ Error $error;

            /* JADX INFO: renamed from: com.discord.widgets.voice.call.WidgetCallFailed$sendFriendRequest$2$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: WidgetCallFailed.kt */
            public static final class C132971 extends AbstractC12240o implements Function2<AppFragment, CaptchaHelper.CaptchaPayload, Unit> {
                public C132971() {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(AppFragment appFragment, CaptchaHelper.CaptchaPayload captchaPayload) {
                    invoke2(appFragment, captchaPayload);
                    return Unit.f27425a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(AppFragment appFragment, CaptchaHelper.CaptchaPayload captchaPayload) {
                    C12238m.checkNotNullParameter(appFragment, "<anonymous parameter 0>");
                    C12238m.checkNotNullParameter(captchaPayload, "captchaPayload");
                    C104142 c104142 = C104142.this;
                    WidgetCallFailed.this.sendFriendRequest(c104142.$userId, c104142.$username, captchaPayload);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(Error error) {
                super(0);
                this.$error = error;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Error error = this.$error;
                C12238m.checkNotNullExpressionValue(error, "error");
                if (WidgetCaptchaKt.isCaptchaError(error)) {
                    WidgetCaptchaBottomSheet.Companion companion = WidgetCaptchaBottomSheet.INSTANCE;
                    C132971 c132971 = new C132971();
                    CaptchaErrorBody.Companion companion2 = CaptchaErrorBody.INSTANCE;
                    Error error2 = this.$error;
                    C12238m.checkNotNullExpressionValue(error2, "error");
                    WidgetCaptchaBottomSheet.Companion.enqueue$default(companion, "Add Friend Captcha", c132971, null, companion2.createFromError(error2), 4, null);
                    return;
                }
                RestAPIAbortMessages.ResponseResolver responseResolver = RestAPIAbortMessages.ResponseResolver.INSTANCE;
                Context context = WidgetCallFailed.this.getContext();
                Error error3 = this.$error;
                C12238m.checkNotNullExpressionValue(error3, "error");
                Error.Response response = error3.getResponse();
                C12238m.checkNotNullExpressionValue(response, "error.response");
                C0876m.m170h(WidgetCallFailed.this.getContext(), responseResolver.getRelationshipResponse(context, response.getCode(), C104142.this.$username), 0, null, 12);
            }
        }

        public C104142(long j, String str) {
            this.$userId = j;
            this.$username = str;
        }

        @Override // p658rx.functions.Action1
        public final void call(Error error) {
            RestAPIAbortMessages restAPIAbortMessages = RestAPIAbortMessages.INSTANCE;
            C12238m.checkNotNullExpressionValue(error, "error");
            RestAPIAbortMessages.handleAbortCodeOrDefault$default(restAPIAbortMessages, error, new AnonymousClass1(error), null, 4, null);
        }
    }

    public WidgetCallFailed() {
        super(C5419R.layout.view_dialog_confirmation);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetCallFailed$binding$2.INSTANCE, null, 2, null);
    }

    private final void configureUI(final User user) {
        if (user == null) {
            dismiss();
            return;
        }
        TextView textView = getBinding().f15424e;
        C12238m.checkNotNullExpressionValue(textView, "binding.viewDialogConfirmationText");
        C1107b.m221m(textView, C5419R.string.call_invite_not_friends, new Object[]{user.getUsername()}, (4 & 4) != 0 ? C1107b.g.f1495j : null);
        getBinding().f15422c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.voice.call.WidgetCallFailed$configureUI$$inlined$let$lambda$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetCallFailed.sendFriendRequest$default(this.this$0, user.getId(), user.getUsername(), null, 4, null);
            }
        });
    }

    private final ViewDialogConfirmationBinding getBinding() {
        return (ViewDialogConfirmationBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final void sendFriendRequest(long userId, String username, CaptchaHelper.CaptchaPayload captchaPayload) {
        ObservableExtensionsKt.ui$default(RestAPI.INSTANCE.getApi().addRelationship("Call", userId, (28 & 4) != 0 ? null : null, (28 & 8) != 0 ? null : null, (28 & 16) != 0 ? null : captchaPayload), this, null, 2, null).m11108k(C0879o.m181h(new Action1<Void>() { // from class: com.discord.widgets.voice.call.WidgetCallFailed.sendFriendRequest.1
            @Override // p658rx.functions.Action1
            public final void call(Void r4) {
                C0876m.m171i(WidgetCallFailed.this, C5419R.string.friend_request_sent, 0, 4);
                WidgetCallFailed.this.dismiss();
            }
        }, getAppActivity(), new C104142(userId, username)));
    }

    public static /* synthetic */ void sendFriendRequest$default(WidgetCallFailed widgetCallFailed, long j, String str, CaptchaHelper.CaptchaPayload captchaPayload, int i, Object obj) {
        if ((i & 4) != 0) {
            captchaPayload = null;
        }
        widgetCallFailed.sendFriendRequest(j, str, captchaPayload);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        TextView textView = getBinding().f15423d;
        C12238m.checkNotNullExpressionValue(textView, "binding.viewDialogConfirmationHeader");
        textView.setText(getString(C5419R.string.start_call));
        MaterialButton materialButton = getBinding().f15422c;
        C12238m.checkNotNullExpressionValue(materialButton, "binding.viewDialogConfirmationConfirm");
        materialButton.setText(getString(C5419R.string.add_friend_button));
        MaterialButton materialButton2 = getBinding().f15421b;
        C12238m.checkNotNullExpressionValue(materialButton2, "binding.viewDialogConfirmationCancel");
        materialButton2.setText(getString(C5419R.string.okay));
        getBinding().f15421b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.voice.call.WidgetCallFailed.onViewBound.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetCallFailed.this.dismiss();
            }
        });
    }

    @Override // com.discord.app.AppDialog
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(StoreStream.INSTANCE.getUsers().observeUser(getArgumentsOrDefault().getLong(INTENT_USER_ID)), this, null, 2, null), (Class<?>) WidgetCallFailed.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C104121());
    }
}
