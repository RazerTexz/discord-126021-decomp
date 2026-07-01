package b.a.a;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import b.a.i.WidgetEnableTwoFactorPasswordDialogBinding;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.auth.mfa.EnableMfaResponse;
import com.discord.app.AppDialog;
import com.discord.restapi.RestAPIParams;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.LoadingButton;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Subscription;

/* JADX INFO: renamed from: b.a.a.s, reason: use source file name */
/* JADX INFO: compiled from: WidgetEnableTwoFactorPasswordDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetEnableTwoFactorPasswordDialog extends AppDialog {
    public static final /* synthetic */ KProperty[] j = {outline.d0(WidgetEnableTwoFactorPasswordDialog.class, "binding", "getBinding()Lcom/discord/databinding/WidgetEnableTwoFactorPasswordDialogBinding;", 0)};

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
    public static final /* synthetic */ class b extends FunctionReferenceImpl implements Function1<View, WidgetEnableTwoFactorPasswordDialogBinding> {
        public static final b j = new b();

        public b() {
            super(1, WidgetEnableTwoFactorPasswordDialogBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetEnableTwoFactorPasswordDialogBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public WidgetEnableTwoFactorPasswordDialogBinding invoke(View view) {
            View view2 = view;
            Intrinsics3.checkNotNullParameter(view2, "p1");
            int i = R.id.enable_two_factor_password_body_container;
            LinearLayout linearLayout = (LinearLayout) view2.findViewById(R.id.enable_two_factor_password_body_container);
            if (linearLayout != null) {
                i = R.id.enable_two_factor_password_body_text;
                TextView textView = (TextView) view2.findViewById(R.id.enable_two_factor_password_body_text);
                if (textView != null) {
                    i = R.id.enable_two_factor_password_cancel;
                    MaterialButton materialButton = (MaterialButton) view2.findViewById(R.id.enable_two_factor_password_cancel);
                    if (materialButton != null) {
                        i = R.id.enable_two_factor_password_header;
                        TextView textView2 = (TextView) view2.findViewById(R.id.enable_two_factor_password_header);
                        if (textView2 != null) {
                            i = R.id.enable_two_factor_password_header_container;
                            LinearLayout linearLayout2 = (LinearLayout) view2.findViewById(R.id.enable_two_factor_password_header_container);
                            if (linearLayout2 != null) {
                                i = R.id.enable_two_factor_password_ok;
                                LoadingButton loadingButton = (LoadingButton) view2.findViewById(R.id.enable_two_factor_password_ok);
                                if (loadingButton != null) {
                                    i = R.id.enable_two_factor_password_view_input;
                                    TextInputLayout textInputLayout = (TextInputLayout) view2.findViewById(R.id.enable_two_factor_password_view_input);
                                    if (textInputLayout != null) {
                                        return new WidgetEnableTwoFactorPasswordDialogBinding((LinearLayout) view2, linearLayout, textView, materialButton, textView2, linearLayout2, loadingButton, textInputLayout);
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
    public static final class c extends Lambda implements Function1<String, Unit> {
        public static final c j = new c();

        public c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(String str) {
            Intrinsics3.checkNotNullParameter(str, "it");
            return Unit.a;
        }
    }

    /* JADX INFO: renamed from: b.a.a.s$d */
    /* JADX INFO: compiled from: WidgetEnableTwoFactorPasswordDialog.kt */
    public static final class d implements View.OnClickListener {
        public final /* synthetic */ View k;

        /* JADX INFO: renamed from: b.a.a.s$d$a */
        /* JADX INFO: compiled from: WidgetEnableTwoFactorPasswordDialog.kt */
        public static final class a extends Lambda implements Function1<EnableMfaResponse, Unit> {
            public static final a j = new a();

            public a() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(EnableMfaResponse enableMfaResponse) {
                Intrinsics3.checkNotNullParameter(enableMfaResponse, "it");
                return Unit.a;
            }
        }

        /* JADX INFO: renamed from: b.a.a.s$d$b */
        /* JADX INFO: compiled from: WidgetEnableTwoFactorPasswordDialog.kt */
        public static final class b extends Lambda implements Function1<Error, Unit> {
            public b() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(Error error) {
                Error error2 = error;
                Intrinsics3.checkNotNullParameter(error2, "error");
                WidgetEnableTwoFactorPasswordDialog widgetEnableTwoFactorPasswordDialog = WidgetEnableTwoFactorPasswordDialog.this;
                KProperty[] kPropertyArr = WidgetEnableTwoFactorPasswordDialog.j;
                widgetEnableTwoFactorPasswordDialog.g().c.setIsLoading(false);
                Error.Response response = error2.getResponse();
                Intrinsics3.checkNotNullExpressionValue(response, "error.response");
                if (response.getCode() == 60005) {
                    error2.setShowErrorToasts(false);
                    WidgetEnableTwoFactorPasswordDialog.this.dismiss();
                    WidgetEnableTwoFactorPasswordDialog widgetEnableTwoFactorPasswordDialog2 = WidgetEnableTwoFactorPasswordDialog.this;
                    Function1<? super String, Unit> function1 = widgetEnableTwoFactorPasswordDialog2.onValidPasswordEntered;
                    TextInputLayout textInputLayout = widgetEnableTwoFactorPasswordDialog2.g().d;
                    Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.enableTwoFactorPasswordViewInput");
                    function1.invoke(ViewExtensions.getTextOrEmpty(textInputLayout));
                }
                return Unit.a;
            }
        }

        public d(View view) {
            this.k = view;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetEnableTwoFactorPasswordDialog widgetEnableTwoFactorPasswordDialog = WidgetEnableTwoFactorPasswordDialog.this;
            KProperty[] kPropertyArr = WidgetEnableTwoFactorPasswordDialog.j;
            TextInputLayout textInputLayout = widgetEnableTwoFactorPasswordDialog.g().d;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.enableTwoFactorPasswordViewInput");
            String textOrEmpty = ViewExtensions.getTextOrEmpty(textInputLayout);
            WidgetEnableTwoFactorPasswordDialog.this.g().c.setIsLoading(true);
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().enableMFA(new RestAPIParams.EnableMFA("random code", "random secret", textOrEmpty)), false, 1, null), WidgetEnableTwoFactorPasswordDialog.this, null, 2, null), (Class<?>) WidgetEnableTwoFactorPasswordDialog.this.getClass(), (58 & 2) != 0 ? null : this.k.getContext(), (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new b()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), a.j);
        }
    }

    /* JADX INFO: renamed from: b.a.a.s$e */
    /* JADX INFO: compiled from: WidgetEnableTwoFactorPasswordDialog.kt */
    public static final class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            FragmentActivity fragmentActivityE = WidgetEnableTwoFactorPasswordDialog.this.e();
            if (fragmentActivityE != null) {
                fragmentActivityE.onBackPressed();
            }
        }
    }

    public WidgetEnableTwoFactorPasswordDialog() {
        super(R.layout.widget_enable_two_factor_password_dialog);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, b.j, null, 2, null);
        this.onValidPasswordEntered = c.j;
    }

    public final WidgetEnableTwoFactorPasswordDialogBinding g() {
        return (WidgetEnableTwoFactorPasswordDialogBinding) this.binding.getValue((Fragment) this, j[0]);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setCancelable(false);
        g().c.setIsLoading(false);
        g().c.setOnClickListener(new d(view));
        g().f129b.setOnClickListener(new e());
    }
}
