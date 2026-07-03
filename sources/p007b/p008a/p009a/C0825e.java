package p007b.p008a.p009a;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.discord.C5419R;
import com.discord.app.AppDialog;
import com.discord.dialogs.SimpleConfirmationDialogArgs;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.google.android.material.button.MaterialButton;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p025i.C1018o1;
import p007b.p008a.p027k.C1107b;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12083g;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.a.e */
/* JADX INFO: compiled from: SimpleConfirmationDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C0825e extends AppDialog {

    /* JADX INFO: renamed from: j */
    public static final /* synthetic */ KProperty[] f344j = {C1643a.m846d0(C0825e.class, "binding", "getBinding()Lcom/discord/databinding/SimpleConfirmationDialogBinding;", 0)};

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public final Lazy args;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public View.OnClickListener positiveClickListener;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    public final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: b.a.a.e$a */
    /* JADX INFO: compiled from: java-style lambda group */
    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ int f349j;

        /* JADX INFO: renamed from: k */
        public final /* synthetic */ Object f350k;

        public a(int i, Object obj) {
            this.f349j = i;
            this.f350k = obj;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            int i = this.f349j;
            if (i != 0) {
                if (i != 1) {
                    throw null;
                }
                ((C0825e) this.f350k).dismiss();
            } else {
                View.OnClickListener onClickListener = ((C0825e) this.f350k).positiveClickListener;
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
                ((C0825e) this.f350k).dismiss();
            }
        }
    }

    /* JADX INFO: renamed from: b.a.a.e$b */
    /* JADX INFO: compiled from: ArgUtils.kt */
    public static final class b extends AbstractC12240o implements Function0<SimpleConfirmationDialogArgs> {
        public final /* synthetic */ String $argsKey;
        public final /* synthetic */ AppDialog $this_args;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(AppDialog appDialog, String str) {
            super(0);
            this.$this_args = appDialog;
            this.$argsKey = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public SimpleConfirmationDialogArgs invoke() {
            Bundle arguments = this.$this_args.getArguments();
            Object obj = arguments != null ? arguments.get(this.$argsKey) : null;
            SimpleConfirmationDialogArgs simpleConfirmationDialogArgs = (SimpleConfirmationDialogArgs) (obj instanceof SimpleConfirmationDialogArgs ? obj : null);
            if (simpleConfirmationDialogArgs != null) {
                return simpleConfirmationDialogArgs;
            }
            StringBuilder sbM833U = C1643a.m833U("Missing args for class type ");
            C1643a.m862l0(SimpleConfirmationDialogArgs.class, sbM833U, " + key ");
            throw new IllegalStateException(C1643a.m820H(sbM833U, this.$argsKey, '!'));
        }
    }

    /* JADX INFO: renamed from: b.a.a.e$c, reason: from kotlin metadata */
    /* JADX INFO: compiled from: SimpleConfirmationDialog.kt */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        /* JADX INFO: renamed from: a */
        public final C0825e m128a(FragmentManager fragmentManager, SimpleConfirmationDialogArgs simpleConfirmationDialogArgs, View.OnClickListener onClickListener) {
            C12238m.checkNotNullParameter(fragmentManager, "fragmentManager");
            C12238m.checkNotNullParameter(simpleConfirmationDialogArgs, "args");
            C12238m.checkNotNullParameter(onClickListener, "positiveClickListener");
            C0825e c0825e = new C0825e();
            c0825e.setArguments(C1460d.m514e2(simpleConfirmationDialogArgs));
            c0825e.positiveClickListener = onClickListener;
            c0825e.show(fragmentManager, C12216a0.getOrCreateKotlinClass(C0825e.class).toString());
            return c0825e;
        }
    }

    /* JADX INFO: renamed from: b.a.a.e$d */
    /* JADX INFO: compiled from: SimpleConfirmationDialog.kt */
    public static final /* synthetic */ class d extends C12236k implements Function1<View, C1018o1> {

        /* JADX INFO: renamed from: j */
        public static final d f351j = new d();

        public d() {
            super(1, C1018o1.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/SimpleConfirmationDialogBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public C1018o1 invoke(View view) {
            View view2 = view;
            C12238m.checkNotNullParameter(view2, "p1");
            int i = C5419R.id.notice_header_container;
            LinearLayout linearLayout = (LinearLayout) view2.findViewById(C5419R.id.notice_header_container);
            if (linearLayout != null) {
                i = C5419R.id.simple_confirmation_dialog_description;
                TextView textView = (TextView) view2.findViewById(C5419R.id.simple_confirmation_dialog_description);
                if (textView != null) {
                    i = C5419R.id.simple_confirmation_dialog_negative;
                    MaterialButton materialButton = (MaterialButton) view2.findViewById(C5419R.id.simple_confirmation_dialog_negative);
                    if (materialButton != null) {
                        i = C5419R.id.simple_confirmation_dialog_positive;
                        MaterialButton materialButton2 = (MaterialButton) view2.findViewById(C5419R.id.simple_confirmation_dialog_positive);
                        if (materialButton2 != null) {
                            i = C5419R.id.simple_confirmation_dialog_title;
                            TextView textView2 = (TextView) view2.findViewById(C5419R.id.simple_confirmation_dialog_title);
                            if (textView2 != null) {
                                return new C1018o1((LinearLayout) view2, linearLayout, textView, materialButton, materialButton2, textView2);
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
        }
    }

    public C0825e() {
        super(C5419R.layout.simple_confirmation_dialog);
        this.args = C12083g.lazy(new b(this, "intent_args_key"));
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, d.f351j, null, 2, null);
    }

    /* JADX INFO: renamed from: g */
    public final SimpleConfirmationDialogArgs m126g() {
        return (SimpleConfirmationDialogArgs) this.args.getValue();
    }

    /* JADX INFO: renamed from: h */
    public final C1018o1 m127h() {
        return (C1018o1) this.binding.getValue((Fragment) this, f344j[0]);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        requireDialog().setCanceledOnTouchOutside(true);
        m127h().f1100d.setOnClickListener(new a(0, this));
        m127h().f1100d.setText(m126g().f18506l);
        m127h().f1099c.setOnClickListener(new a(1, this));
        MaterialButton materialButton = m127h().f1099c;
        C12238m.checkNotNullExpressionValue(materialButton, "binding.simpleConfirmationDialogNegative");
        materialButton.setText(m126g().f18507m);
        TextView textView = m127h().f1101e;
        C12238m.checkNotNullExpressionValue(textView, "binding.simpleConfirmationDialogTitle");
        C1107b.m209a(textView, m126g().f18504j);
        TextView textView2 = m127h().f1098b;
        C12238m.checkNotNullExpressionValue(textView2, "binding.simpleConfirmationDialogDescription");
        C1107b.m209a(textView2, m126g().f18505k);
    }
}
