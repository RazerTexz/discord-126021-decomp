package com.discord.widgets.user.email;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.activity.result.ActivityResultLauncher;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import b.a.d.AppScreen2;
import b.a.d.AppToast;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.analytics.generated.events.network_action.TrackNetworkActionUserVerifyResend;
import com.discord.analytics.generated.traits.TrackNetworkMetadata2;
import com.discord.databinding.WidgetUserEmailVerifyBinding;
import com.discord.models.user.MeUser;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.utilities.RestCallState5;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.user.account.WidgetUserAccountVerifyBase;
import com.discord.widgets.user.email.WidgetUserEmailUpdate;
import com.discord.widgets.user.email.WidgetUserEmailVerify;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.Subscription;

/* JADX INFO: compiled from: WidgetUserEmailVerify.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserEmailVerify extends WidgetUserAccountVerifyBase {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetUserEmailVerify.class, "binding", "getBinding()Lcom/discord/databinding/WidgetUserEmailVerifyBinding;", 0)};

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
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(mode, "mode");
            AppScreen2.d(context, WidgetUserEmailVerify.class, WidgetUserAccountVerifyBase.INSTANCE.getLaunchIntent(mode, false, true));
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
                Observable<Model> observableR = StoreUser.observeMe$default(StoreStream.INSTANCE.getUsers(), false, 1, null).G(new Func1<MeUser, Model>() { // from class: com.discord.widgets.user.email.WidgetUserEmailVerify$Model$Companion$get$1
                    @Override // j0.k.Func1
                    public final WidgetUserEmailVerify.Model call(MeUser meUser) {
                        Intrinsics3.checkNotNullExpressionValue(meUser, "me");
                        return new WidgetUserEmailVerify.Model(meUser);
                    }
                }).r();
                Intrinsics3.checkNotNullExpressionValue(observableR, "getUsers()\n            .…  .distinctUntilChanged()");
                return observableR;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Model(MeUser meUser) {
            Intrinsics3.checkNotNullParameter(meUser, "me");
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
            Intrinsics3.checkNotNullParameter(me2, "me");
            return new Model(me2);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof Model) && Intrinsics3.areEqual(this.me, ((Model) other).me);
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
            StringBuilder sbU = outline.U("Model(me=");
            sbU.append(this.me);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.email.WidgetUserEmailVerify$onViewBoundOrOnResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetUserEmailVerify.kt */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Model, Unit> {
        public AnonymousClass1(WidgetUserEmailVerify widgetUserEmailVerify) {
            super(1, widgetUserEmailVerify, WidgetUserEmailVerify.class, "configureUI", "configureUI(Lcom/discord/widgets/user/email/WidgetUserEmailVerify$Model;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            Intrinsics3.checkNotNullParameter(model, "p1");
            ((WidgetUserEmailVerify) this.receiver).configureUI(model);
        }
    }

    public WidgetUserEmailVerify() {
        super(R.layout.widget_user_email_verify);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetUserEmailVerify3.INSTANCE, null, 2, null);
        this.emailUpdateLauncher = WidgetUserEmailUpdate.INSTANCE.registerForResult(this, new WidgetUserEmailVerify4(this));
    }

    private final void configureUI(final Model model) {
        if (model.getVerified()) {
            requireActivity().setResult(-1);
            requireActivity().finish();
        } else if (model.getEmail() == null) {
            WidgetUserEmailUpdate.INSTANCE.launch(requireContext(), getMode(), this.emailUpdateLauncher);
        } else {
            getBinding().f2681b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.user.email.WidgetUserEmailVerify.configureUI.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WidgetUserEmailUpdate.Companion.launch$default(WidgetUserEmailUpdate.INSTANCE, outline.x(view, "it", "it.context"), WidgetUserEmailVerify.this.getMode(), null, 4, null);
                }
            });
            getBinding().c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.user.email.WidgetUserEmailVerify.configureUI.2

                /* JADX INFO: renamed from: com.discord.widgets.user.email.WidgetUserEmailVerify$configureUI$2$1, reason: invalid class name */
                /* JADX INFO: compiled from: WidgetUserEmailVerify.kt */
                public static final class AnonymousClass1 extends Lambda implements Function1<Void, TrackNetworkMetadata2> {
                    public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

                    public AnonymousClass1() {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final TrackNetworkMetadata2 invoke(Void r1) {
                        return new TrackNetworkActionUserVerifyResend();
                    }
                }

                /* JADX INFO: renamed from: com.discord.widgets.user.email.WidgetUserEmailVerify$configureUI$2$2, reason: invalid class name and collision with other inner class name */
                /* JADX INFO: compiled from: WidgetUserEmailVerify.kt */
                public static final class C03512 extends Lambda implements Function1<Void, Unit> {
                    public C03512() {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
                        invoke2(r1);
                        return Unit.a;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Void r6) {
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        WidgetUserEmailVerify widgetUserEmailVerify = WidgetUserEmailVerify.this;
                        AppToast.j(widgetUserEmailVerify, FormatUtils.e(widgetUserEmailVerify, R.string.verification_email_body, new Object[]{model.getEmail()}, (4 & 4) != 0 ? FormatUtils.a.j : null), 0, 4);
                    }
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(RestCallState5.logNetworkAction(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().postAuthVerifyResend(new RestAPIParams.EmptyBody()), false, 1, null), AnonymousClass1.INSTANCE), WidgetUserEmailVerify.this, null, 2, null), (Class<?>) WidgetUserEmailVerify.this.getClass(), (58 & 2) != 0 ? null : WidgetUserEmailVerify.this.getContext(), (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new C03512());
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
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(Model.INSTANCE.get(), this, null, 2, null), (Class<?>) WidgetUserEmailVerify.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1(this));
    }
}
