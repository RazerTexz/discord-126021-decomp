package com.discord.widgets.user.email;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.activity.result.ActivityResultLauncher;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import com.discord.C5419R;
import com.discord.analytics.generated.events.network_action.TrackNetworkActionUserVerifyResend;
import com.discord.analytics.generated.traits.TrackNetworkMetadataReceiver;
import com.discord.databinding.WidgetUserEmailVerifyBinding;
import com.discord.models.user.MeUser;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.utilities.RestCallStateKt;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.user.account.WidgetUserAccountVerifyBase;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0870j;
import p007b.p008a.p018d.C0876m;
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p658rx.Observable;
import p658rx.Subscription;

/* JADX INFO: compiled from: WidgetUserEmailVerify.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserEmailVerify extends WidgetUserAccountVerifyBase {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetUserEmailVerify.class, "binding", "getBinding()Lcom/discord/databinding/WidgetUserEmailVerifyBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final ActivityResultLauncher<Intent> emailUpdateLauncher;

    /* JADX INFO: compiled from: WidgetUserEmailVerify.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context, WidgetUserAccountVerifyBase.Mode mode) {
            C12238m.checkNotNullParameter(context, "context");
            C12238m.checkNotNullParameter(mode, "mode");
            C0870j.m156d(context, WidgetUserEmailVerify.class, WidgetUserAccountVerifyBase.INSTANCE.getLaunchIntent(mode, false, true));
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetUserEmailVerify.kt */
    public static final /* data */ class Model {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String email;
        private final MeUser me;
        private final boolean verified;

        /* JADX INFO: compiled from: WidgetUserEmailVerify.kt */
        public static final class Companion {
            private Companion() {
            }

            public final Observable<Model> get() {
                Observable<Model> observableM11112r = StoreUser.observeMe$default(StoreStream.INSTANCE.getUsers(), false, 1, null).m11083G(new InterfaceC12589b<MeUser, Model>() { // from class: com.discord.widgets.user.email.WidgetUserEmailVerify$Model$Companion$get$1
                    @Override // p637j0.p641k.InterfaceC12589b
                    public final WidgetUserEmailVerify.Model call(MeUser meUser) {
                        C12238m.checkNotNullExpressionValue(meUser, "me");
                        return new WidgetUserEmailVerify.Model(meUser);
                    }
                }).m11112r();
                C12238m.checkNotNullExpressionValue(observableM11112r, "getUsers()\n            .…  .distinctUntilChanged()");
                return observableM11112r;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Model(MeUser meUser) {
            C12238m.checkNotNullParameter(meUser, "me");
            this.me = meUser;
            this.email = meUser.getEmail();
            this.verified = meUser.isVerified();
        }

        public static /* synthetic */ Model copy$default(Model model, MeUser meUser, int i, Object obj) {
            if ((i & 1) != 0) {
                meUser = model.me;
            }
            return model.copy(meUser);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final MeUser getMe() {
            return this.me;
        }

        public final Model copy(MeUser me2) {
            C12238m.checkNotNullParameter(me2, "me");
            return new Model(me2);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof Model) && C12238m.areEqual(this.me, ((Model) other).me);
            }
            return true;
        }

        public final String getEmail() {
            return this.email;
        }

        public final MeUser getMe() {
            return this.me;
        }

        public final boolean getVerified() {
            return this.verified;
        }

        public int hashCode() {
            MeUser meUser = this.me;
            if (meUser != null) {
                return meUser.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("Model(me=");
            sbM833U.append(this.me);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.email.WidgetUserEmailVerify$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetUserEmailVerify.kt */
    public static final /* synthetic */ class C102581 extends C12236k implements Function1<Model, Unit> {
        public C102581(WidgetUserEmailVerify widgetUserEmailVerify) {
            super(1, widgetUserEmailVerify, WidgetUserEmailVerify.class, "configureUI", "configureUI(Lcom/discord/widgets/user/email/WidgetUserEmailVerify$Model;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            C12238m.checkNotNullParameter(model, "p1");
            ((WidgetUserEmailVerify) this.receiver).configureUI(model);
        }
    }

    public WidgetUserEmailVerify() {
        super(C5419R.layout.widget_user_email_verify);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetUserEmailVerify$binding$2.INSTANCE, null, 2, null);
        this.emailUpdateLauncher = WidgetUserEmailUpdate.INSTANCE.registerForResult(this, new WidgetUserEmailVerify$emailUpdateLauncher$1(this));
    }

    private final void configureUI(final Model model) {
        if (model.getVerified()) {
            requireActivity().setResult(-1);
            requireActivity().finish();
        } else if (model.getEmail() == null) {
            WidgetUserEmailUpdate.INSTANCE.launch(requireContext(), getMode(), this.emailUpdateLauncher);
        } else {
            getBinding().f18331b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.user.email.WidgetUserEmailVerify.configureUI.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WidgetUserEmailUpdate.Companion.launch$default(WidgetUserEmailUpdate.INSTANCE, C1643a.m885x(view, "it", "it.context"), WidgetUserEmailVerify.this.getMode(), null, 4, null);
                }
            });
            getBinding().f18332c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.user.email.WidgetUserEmailVerify.configureUI.2

                /* JADX INFO: renamed from: com.discord.widgets.user.email.WidgetUserEmailVerify$configureUI$2$1, reason: invalid class name */
                /* JADX INFO: compiled from: WidgetUserEmailVerify.kt */
                public static final class AnonymousClass1 extends AbstractC12240o implements Function1<Void, TrackNetworkMetadataReceiver> {
                    public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

                    public AnonymousClass1() {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final TrackNetworkMetadataReceiver invoke(Void r1) {
                        return new TrackNetworkActionUserVerifyResend();
                    }
                }

                /* JADX INFO: renamed from: com.discord.widgets.user.email.WidgetUserEmailVerify$configureUI$2$2, reason: invalid class name */
                /* JADX INFO: compiled from: WidgetUserEmailVerify.kt */
                public static final class AnonymousClass2 extends AbstractC12240o implements Function1<Void, Unit> {
                    public AnonymousClass2() {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
                        invoke2(r1);
                        return Unit.f27425a;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Void r6) {
                        ViewOnClickListenerC102572 viewOnClickListenerC102572 = ViewOnClickListenerC102572.this;
                        WidgetUserEmailVerify widgetUserEmailVerify = WidgetUserEmailVerify.this;
                        C0876m.m172j(widgetUserEmailVerify, C1107b.m213e(widgetUserEmailVerify, C5419R.string.verification_email_body, new Object[]{model.getEmail()}, (4 & 4) != 0 ? C1107b.a.f1490j : null), 0, 4);
                    }
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(RestCallStateKt.logNetworkAction(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().postAuthVerifyResend(new RestAPIParams.EmptyBody()), false, 1, null), AnonymousClass1.INSTANCE), WidgetUserEmailVerify.this, null, 2, null), (Class<?>) WidgetUserEmailVerify.this.getClass(), (58 & 2) != 0 ? null : WidgetUserEmailVerify.this.getContext(), (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new AnonymousClass2());
                }
            });
        }
    }

    private final WidgetUserEmailVerifyBinding getBinding() {
        return (WidgetUserEmailVerifyBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.widgets.user.account.WidgetUserAccountVerifyBase, com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(Model.INSTANCE.get(), this, null, 2, null), (Class<?>) WidgetUserEmailVerify.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C102581(this));
    }
}
