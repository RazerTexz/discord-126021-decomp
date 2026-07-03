package p007b.p008a.p009a;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.discord.C5419R;
import com.discord.api.auth.mfa.EnableMfaResponse;
import com.discord.app.AppDialog;
import com.discord.restapi.RestAPIParams;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.LoadingButton;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p025i.C0973h5;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p658rx.Subscription;

/* JADX INFO: renamed from: b.a.a.s */
/* JADX INFO: compiled from: WidgetEnableTwoFactorPasswordDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C0842s extends AppDialog {

    /* JADX INFO: renamed from: j */
    public static final /* synthetic */ KProperty[] f428j = {C1643a.m846d0(C0842s.class, "binding", "getBinding()Lcom/discord/databinding/WidgetEnableTwoFactorPasswordDialogBinding;", 0)};

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public Function1<? super String, Unit> onValidPasswordEntered;

    /* JADX INFO: renamed from: b.a.a.s$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: WidgetEnableTwoFactorPasswordDialog.kt */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* JADX INFO: renamed from: b.a.a.s$b */
    /* JADX INFO: compiled from: WidgetEnableTwoFactorPasswordDialog.kt */
    public static final /* synthetic */ class b extends C12236k implements Function1<View, C0973h5> {

        /* JADX INFO: renamed from: j */
        public static final b f432j = new b();

        public b() {
            super(1, C0973h5.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetEnableTwoFactorPasswordDialogBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public C0973h5 invoke(View view) {
            View view2 = view;
            C12238m.checkNotNullParameter(view2, "p1");
            int i = C5419R.id.enable_two_factor_password_body_container;
            LinearLayout linearLayout = (LinearLayout) view2.findViewById(C5419R.id.enable_two_factor_password_body_container);
            if (linearLayout != null) {
                i = C5419R.id.enable_two_factor_password_body_text;
                TextView textView = (TextView) view2.findViewById(C5419R.id.enable_two_factor_password_body_text);
                if (textView != null) {
                    i = C5419R.id.enable_two_factor_password_cancel;
                    MaterialButton materialButton = (MaterialButton) view2.findViewById(C5419R.id.enable_two_factor_password_cancel);
                    if (materialButton != null) {
                        i = C5419R.id.enable_two_factor_password_header;
                        TextView textView2 = (TextView) view2.findViewById(C5419R.id.enable_two_factor_password_header);
                        if (textView2 != null) {
                            i = C5419R.id.enable_two_factor_password_header_container;
                            LinearLayout linearLayout2 = (LinearLayout) view2.findViewById(C5419R.id.enable_two_factor_password_header_container);
                            if (linearLayout2 != null) {
                                i = C5419R.id.enable_two_factor_password_ok;
                                LoadingButton loadingButton = (LoadingButton) view2.findViewById(C5419R.id.enable_two_factor_password_ok);
                                if (loadingButton != null) {
                                    i = C5419R.id.enable_two_factor_password_view_input;
                                    TextInputLayout textInputLayout = (TextInputLayout) view2.findViewById(C5419R.id.enable_two_factor_password_view_input);
                                    if (textInputLayout != null) {
                                        return new C0973h5((LinearLayout) view2, linearLayout, textView, materialButton, textView2, linearLayout2, loadingButton, textInputLayout);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
        }
    }

    /* JADX INFO: renamed from: b.a.a.s$c */
    /* JADX INFO: compiled from: WidgetEnableTwoFactorPasswordDialog.kt */
    public static final class c extends AbstractC12240o implements Function1<String, Unit> {

        /* JADX INFO: renamed from: j */
        public static final c f433j = new c();

        public c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(String str) {
            C12238m.checkNotNullParameter(str, "it");
            return Unit.f27425a;
        }
    }

    /* JADX INFO: renamed from: b.a.a.s$d */
    /* JADX INFO: compiled from: WidgetEnableTwoFactorPasswordDialog.kt */
    public static final class d implements View.OnClickListener {

        /* JADX INFO: renamed from: k */
        public final /* synthetic */ View f435k;

        /* JADX INFO: renamed from: b.a.a.s$d$a */
        /* JADX INFO: compiled from: WidgetEnableTwoFactorPasswordDialog.kt */
        public static final class a extends AbstractC12240o implements Function1<EnableMfaResponse, Unit> {

            /* JADX INFO: renamed from: j */
            public static final a f436j = new a();

            public a() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(EnableMfaResponse enableMfaResponse) {
                C12238m.checkNotNullParameter(enableMfaResponse, "it");
                return Unit.f27425a;
            }
        }

        /* JADX INFO: renamed from: b.a.a.s$d$b */
        /* JADX INFO: compiled from: WidgetEnableTwoFactorPasswordDialog.kt */
        public static final class b extends AbstractC12240o implements Function1<Error, Unit> {
            public b() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(Error error) {
                Error error2 = error;
                C12238m.checkNotNullParameter(error2, "error");
                C0842s c0842s = C0842s.this;
                KProperty[] kPropertyArr = C0842s.f428j;
                c0842s.m144g().f933c.setIsLoading(false);
                Error.Response response = error2.getResponse();
                C12238m.checkNotNullExpressionValue(response, "error.response");
                if (response.getCode() == 60005) {
                    error2.setShowErrorToasts(false);
                    C0842s.this.dismiss();
                    C0842s c0842s2 = C0842s.this;
                    Function1<? super String, Unit> function1 = c0842s2.onValidPasswordEntered;
                    TextInputLayout textInputLayout = c0842s2.m144g().f934d;
                    C12238m.checkNotNullExpressionValue(textInputLayout, "binding.enableTwoFactorPasswordViewInput");
                    function1.invoke(ViewExtensions.getTextOrEmpty(textInputLayout));
                }
                return Unit.f27425a;
            }
        }

        public d(View view) {
            this.f435k = view;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            C0842s c0842s = C0842s.this;
            KProperty[] kPropertyArr = C0842s.f428j;
            TextInputLayout textInputLayout = c0842s.m144g().f934d;
            C12238m.checkNotNullExpressionValue(textInputLayout, "binding.enableTwoFactorPasswordViewInput");
            String textOrEmpty = ViewExtensions.getTextOrEmpty(textInputLayout);
            C0842s.this.m144g().f933c.setIsLoading(true);
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().enableMFA(new RestAPIParams.EnableMFA("random code", "random secret", textOrEmpty)), false, 1, null), C0842s.this, null, 2, null), (Class<?>) C0842s.this.getClass(), (58 & 2) != 0 ? null : this.f435k.getContext(), (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new b()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), a.f436j);
        }
    }

    /* JADX INFO: renamed from: b.a.a.s$e */
    /* JADX INFO: compiled from: WidgetEnableTwoFactorPasswordDialog.kt */
    public static final class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            FragmentActivity fragmentActivityM95e = C0842s.this.m95e();
            if (fragmentActivityM95e != null) {
                fragmentActivityM95e.onBackPressed();
            }
        }
    }

    public C0842s() {
        super(C5419R.layout.widget_enable_two_factor_password_dialog);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, b.f432j, null, 2, null);
        this.onValidPasswordEntered = c.f433j;
    }

    /* JADX INFO: renamed from: g */
    public final C0973h5 m144g() {
        return (C0973h5) this.binding.getValue((Fragment) this, f428j[0]);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setCancelable(false);
        m144g().f933c.setIsLoading(false);
        m144g().f933c.setOnClickListener(new d(view));
        m144g().f932b.setOnClickListener(new e());
    }
}
