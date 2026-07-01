package b.a.a;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import b.a.i.DialogSimpleSelectorBinding;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppDialog;
import com.discord.databinding.DialogSimpleSelectorItemBinding;
import com.discord.utilities.view.recycler.MaxHeightRecyclerView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.utilities.views.SimpleRecyclerAdapter;
import com.google.android.material.button.MaterialButton;
import d0.t._ArraysJvm;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* JADX INFO: renamed from: b.a.a.n, reason: use source file name */
/* JADX INFO: compiled from: SelectorDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SelectorDialog extends AppDialog {
    public static final /* synthetic */ KProperty[] j = {outline.d0(SelectorDialog.class, "binding", "getBinding()Lcom/discord/databinding/DialogSimpleSelectorBinding;", 0)};

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public Function1<? super Integer, Unit> onSelectedListener;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: b.a.a.n$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: SelectorDialog.kt */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final SelectorDialog a(FragmentManager fragmentManager, CharSequence charSequence, CharSequence[] charSequenceArr, Function1<? super Integer, Unit> function1) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics3.checkNotNullParameter(charSequence, "title");
            Intrinsics3.checkNotNullParameter(charSequenceArr, "options");
            Intrinsics3.checkNotNullParameter(function1, "onSelectedListener");
            SelectorDialog selectorDialog = new SelectorDialog();
            Bundle bundle = new Bundle();
            bundle.putCharSequence("INTENT_DIALOG_TITLE", charSequence);
            bundle.putCharSequenceArray("INTENT_DIALOG_OPTIONS", charSequenceArr);
            selectorDialog.setArguments(bundle);
            selectorDialog.onSelectedListener = function1;
            selectorDialog.show(fragmentManager, Reflection2.getOrCreateKotlinClass(SelectorDialog.class).toString());
            return selectorDialog;
        }
    }

    /* JADX INFO: renamed from: b.a.a.n$b */
    /* JADX INFO: compiled from: SelectorDialog.kt */
    public final class b extends SimpleRecyclerAdapter.ViewHolder<CharSequence> {
        public final DialogSimpleSelectorItemBinding a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SelectorDialog f49b;

        /* JADX WARN: Illegal instructions before constructor call */
        public b(SelectorDialog selectorDialog, DialogSimpleSelectorItemBinding dialogSimpleSelectorItemBinding) {
            Intrinsics3.checkNotNullParameter(dialogSimpleSelectorItemBinding, "binding");
            this.f49b = selectorDialog;
            TextView textView = dialogSimpleSelectorItemBinding.a;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.root");
            super(textView);
            this.a = dialogSimpleSelectorItemBinding;
        }

        @Override // com.discord.utilities.views.SimpleRecyclerAdapter.ViewHolder
        public void bind(CharSequence charSequence) {
            CharSequence charSequence2 = charSequence;
            Intrinsics3.checkNotNullParameter(charSequence2, "data");
            TextView textView = this.a.a;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.root");
            textView.setText(charSequence2);
            this.a.a.setOnClickListener(new SelectorDialog2(this));
        }
    }

    /* JADX INFO: renamed from: b.a.a.n$c */
    /* JADX INFO: compiled from: SelectorDialog.kt */
    public static final /* synthetic */ class c extends FunctionReferenceImpl implements Function1<View, DialogSimpleSelectorBinding> {
        public static final c j = new c();

        public c() {
            super(1, DialogSimpleSelectorBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/DialogSimpleSelectorBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public DialogSimpleSelectorBinding invoke(View view) {
            View view2 = view;
            Intrinsics3.checkNotNullParameter(view2, "p1");
            int i = R.id.dialog_cancel;
            MaterialButton materialButton = (MaterialButton) view2.findViewById(R.id.dialog_cancel);
            if (materialButton != null) {
                i = R.id.dialog_selections;
                MaxHeightRecyclerView maxHeightRecyclerView = (MaxHeightRecyclerView) view2.findViewById(R.id.dialog_selections);
                if (maxHeightRecyclerView != null) {
                    i = R.id.dialog_title;
                    TextView textView = (TextView) view2.findViewById(R.id.dialog_title);
                    if (textView != null) {
                        return new DialogSimpleSelectorBinding((LinearLayout) view2, materialButton, maxHeightRecyclerView, textView);
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
        }
    }

    /* JADX INFO: renamed from: b.a.a.n$d */
    /* JADX INFO: compiled from: SelectorDialog.kt */
    public static final class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            SelectorDialog.this.dismiss();
        }
    }

    /* JADX INFO: renamed from: b.a.a.n$e */
    /* JADX INFO: compiled from: SelectorDialog.kt */
    public static final class e extends Lambda implements Function2<LayoutInflater, ViewGroup, b> {
        public e() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public b invoke(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            LayoutInflater layoutInflater2 = layoutInflater;
            ViewGroup viewGroup2 = viewGroup;
            Intrinsics3.checkNotNullParameter(layoutInflater2, "inflater");
            Intrinsics3.checkNotNullParameter(viewGroup2, "parent");
            DialogSimpleSelectorItemBinding dialogSimpleSelectorItemBindingA = DialogSimpleSelectorItemBinding.a(layoutInflater2, viewGroup2, false);
            Intrinsics3.checkNotNullExpressionValue(dialogSimpleSelectorItemBindingA, "DialogSimpleSelectorItem…(inflater, parent, false)");
            return new b(SelectorDialog.this, dialogSimpleSelectorItemBindingA);
        }
    }

    public SelectorDialog() {
        super(R.layout.dialog_simple_selector);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, c.j, null, 2, null);
    }

    public final DialogSimpleSelectorBinding g() {
        return (DialogSimpleSelectorBinding) this.binding.getValue((Fragment) this, j[0]);
    }

    @Override // com.discord.app.AppDialog, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        dismiss();
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        TextView textView = g().d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.dialogTitle");
        textView.setText(getArgumentsOrDefault().getCharSequence("INTENT_DIALOG_TITLE", null));
        g().f149b.setOnClickListener(new d());
        CharSequence[] charSequenceArray = getArgumentsOrDefault().getCharSequenceArray("INTENT_DIALOG_OPTIONS");
        if (charSequenceArray != null) {
            MaxHeightRecyclerView maxHeightRecyclerView = g().c;
            Intrinsics3.checkNotNullExpressionValue(maxHeightRecyclerView, "binding.dialogSelections");
            maxHeightRecyclerView.setAdapter(new SimpleRecyclerAdapter(_ArraysJvm.asList(charSequenceArray), new e()));
            MaxHeightRecyclerView maxHeightRecyclerView2 = g().c;
            RecyclerView.Adapter adapter = maxHeightRecyclerView2.getAdapter();
            if (adapter != null) {
                adapter.notifyDataSetChanged();
            }
            maxHeightRecyclerView2.setHasFixedSize(false);
            maxHeightRecyclerView2.setNestedScrollingEnabled(false);
            SimpleRecyclerAdapter.Companion companion = SimpleRecyclerAdapter.INSTANCE;
            MaxHeightRecyclerView maxHeightRecyclerView3 = g().c;
            Intrinsics3.checkNotNullExpressionValue(maxHeightRecyclerView3, "binding.dialogSelections");
            companion.addThemedDivider(maxHeightRecyclerView3);
        }
    }
}
