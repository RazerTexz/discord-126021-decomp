package b.a.a;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.a.i.SimpleConfirmationDialogBinding;
import b.a.k.FormatUtils;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppDialog;
import com.discord.dialogs.SimpleConfirmationDialog2;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.google.android.material.button.MaterialButton;
import d0.LazyJVM;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* JADX INFO: renamed from: b.a.a.e, reason: use source file name */
/* JADX INFO: compiled from: SimpleConfirmationDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SimpleConfirmationDialog extends AppDialog {
    public static final /* synthetic */ KProperty[] j = {outline.d0(SimpleConfirmationDialog.class, "binding", "getBinding()Lcom/discord/databinding/SimpleConfirmationDialogBinding;", 0)};

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
        public final /* synthetic */ int j;
        public final /* synthetic */ Object k;

        public a(int i, Object obj) {
            this.j = i;
            this.k = obj;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            int i = this.j;
            if (i != 0) {
                if (i != 1) {
                    throw null;
                }
                ((SimpleConfirmationDialog) this.k).dismiss();
            } else {
                View.OnClickListener onClickListener = ((SimpleConfirmationDialog) this.k).positiveClickListener;
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
                ((SimpleConfirmationDialog) this.k).dismiss();
            }
        }
    }

    /* JADX INFO: renamed from: b.a.a.e$b */
    /* JADX INFO: compiled from: ArgUtils.kt */
    public static final class b extends Lambda implements Function0<SimpleConfirmationDialog2> {
        public final /* synthetic */ String $argsKey;
        public final /* synthetic */ AppDialog $this_args;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(AppDialog appDialog, String str) {
            super(0);
            this.$this_args = appDialog;
            this.$argsKey = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public SimpleConfirmationDialog2 invoke() {
            Bundle arguments = this.$this_args.getArguments();
            Object obj = arguments != null ? arguments.get(this.$argsKey) : null;
            SimpleConfirmationDialog2 simpleConfirmationDialog2 = (SimpleConfirmationDialog2) (obj instanceof SimpleConfirmationDialog2 ? obj : null);
            if (simpleConfirmationDialog2 != null) {
                return simpleConfirmationDialog2;
            }
            StringBuilder sbU = outline.U("Missing args for class type ");
            outline.l0(SimpleConfirmationDialog2.class, sbU, " + key ");
            throw new IllegalStateException(outline.H(sbU, this.$argsKey, '!'));
        }
    }

    /* JADX INFO: renamed from: b.a.a.e$c, reason: from kotlin metadata */
    /* JADX INFO: compiled from: SimpleConfirmationDialog.kt */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final SimpleConfirmationDialog a(FragmentManager fragmentManager, SimpleConfirmationDialog2 simpleConfirmationDialog2, View.OnClickListener onClickListener) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics3.checkNotNullParameter(simpleConfirmationDialog2, "args");
            Intrinsics3.checkNotNullParameter(onClickListener, "positiveClickListener");
            SimpleConfirmationDialog simpleConfirmationDialog = new SimpleConfirmationDialog();
            simpleConfirmationDialog.setArguments(AnimatableValueParser.e2(simpleConfirmationDialog2));
            simpleConfirmationDialog.positiveClickListener = onClickListener;
            simpleConfirmationDialog.show(fragmentManager, Reflection2.getOrCreateKotlinClass(SimpleConfirmationDialog.class).toString());
            return simpleConfirmationDialog;
        }
    }

    /* JADX INFO: renamed from: b.a.a.e$d */
    /* JADX INFO: compiled from: SimpleConfirmationDialog.kt */
    public static final /* synthetic */ class d extends FunctionReferenceImpl implements Function1<View, SimpleConfirmationDialogBinding> {
        public static final d j = new d();

        public d() {
            super(1, SimpleConfirmationDialogBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/SimpleConfirmationDialogBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public SimpleConfirmationDialogBinding invoke(View view) {
            View view2 = view;
            Intrinsics3.checkNotNullParameter(view2, "p1");
            int i = R.id.notice_header_container;
            LinearLayout linearLayout = (LinearLayout) view2.findViewById(R.id.notice_header_container);
            if (linearLayout != null) {
                i = R.id.simple_confirmation_dialog_description;
                TextView textView = (TextView) view2.findViewById(R.id.simple_confirmation_dialog_description);
                if (textView != null) {
                    i = R.id.simple_confirmation_dialog_negative;
                    MaterialButton materialButton = (MaterialButton) view2.findViewById(R.id.simple_confirmation_dialog_negative);
                    if (materialButton != null) {
                        i = R.id.simple_confirmation_dialog_positive;
                        MaterialButton materialButton2 = (MaterialButton) view2.findViewById(R.id.simple_confirmation_dialog_positive);
                        if (materialButton2 != null) {
                            i = R.id.simple_confirmation_dialog_title;
                            TextView textView2 = (TextView) view2.findViewById(R.id.simple_confirmation_dialog_title);
                            if (textView2 != null) {
                                return new SimpleConfirmationDialogBinding((LinearLayout) view2, linearLayout, textView, materialButton, materialButton2, textView2);
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
        }
    }

    public SimpleConfirmationDialog() {
        super(R.layout.simple_confirmation_dialog);
        this.args = LazyJVM.lazy(new b(this, "intent_args_key"));
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, d.j, null, 2, null);
    }

    public final SimpleConfirmationDialog2 g() {
        return (SimpleConfirmationDialog2) this.args.getValue();
    }

    public final SimpleConfirmationDialogBinding h() {
        return (SimpleConfirmationDialogBinding) this.binding.getValue((Fragment) this, j[0]);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        requireDialog().setCanceledOnTouchOutside(true);
        h().d.setOnClickListener(new a(0, this));
        h().d.setText(g().l);
        h().c.setOnClickListener(new a(1, this));
        MaterialButton materialButton = h().c;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.simpleConfirmationDialogNegative");
        materialButton.setText(g().m);
        TextView textView = h().e;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.simpleConfirmationDialogTitle");
        FormatUtils.a(textView, g().j);
        TextView textView2 = h().f172b;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.simpleConfirmationDialogDescription");
        FormatUtils.a(textView2, g().k);
    }
}
