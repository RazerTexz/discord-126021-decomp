package p007b.p008a.p009a;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.app.AppDialog;
import com.discord.databinding.DialogSimpleSelectorItemBinding;
import com.discord.utilities.view.recycler.MaxHeightRecyclerView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.utilities.views.SimpleRecyclerAdapter;
import com.google.android.material.button.MaterialButton;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p025i.C0995l;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12139j;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.a.n */
/* JADX INFO: compiled from: SelectorDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C0837n extends AppDialog {

    /* JADX INFO: renamed from: j */
    public static final /* synthetic */ KProperty[] f410j = {C1643a.m846d0(C0837n.class, "binding", "getBinding()Lcom/discord/databinding/DialogSimpleSelectorBinding;", 0)};

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

        /* JADX INFO: renamed from: a */
        public final C0837n m142a(FragmentManager fragmentManager, CharSequence charSequence, CharSequence[] charSequenceArr, Function1<? super Integer, Unit> function1) {
            C12238m.checkNotNullParameter(fragmentManager, "fragmentManager");
            C12238m.checkNotNullParameter(charSequence, "title");
            C12238m.checkNotNullParameter(charSequenceArr, "options");
            C12238m.checkNotNullParameter(function1, "onSelectedListener");
            C0837n c0837n = new C0837n();
            Bundle bundle = new Bundle();
            bundle.putCharSequence("INTENT_DIALOG_TITLE", charSequence);
            bundle.putCharSequenceArray("INTENT_DIALOG_OPTIONS", charSequenceArr);
            c0837n.setArguments(bundle);
            c0837n.onSelectedListener = function1;
            c0837n.show(fragmentManager, C12216a0.getOrCreateKotlinClass(C0837n.class).toString());
            return c0837n;
        }
    }

    /* JADX INFO: renamed from: b.a.a.n$b */
    /* JADX INFO: compiled from: SelectorDialog.kt */
    public final class b extends SimpleRecyclerAdapter.ViewHolder<CharSequence> {

        /* JADX INFO: renamed from: a */
        public final DialogSimpleSelectorItemBinding f414a;

        /* JADX INFO: renamed from: b */
        public final /* synthetic */ C0837n f415b;

        /* JADX WARN: Illegal instructions before constructor call */
        public b(C0837n c0837n, DialogSimpleSelectorItemBinding dialogSimpleSelectorItemBinding) {
            C12238m.checkNotNullParameter(dialogSimpleSelectorItemBinding, "binding");
            this.f415b = c0837n;
            TextView textView = dialogSimpleSelectorItemBinding.f15039a;
            C12238m.checkNotNullExpressionValue(textView, "binding.root");
            super(textView);
            this.f414a = dialogSimpleSelectorItemBinding;
        }

        @Override // com.discord.utilities.views.SimpleRecyclerAdapter.ViewHolder
        public void bind(CharSequence charSequence) {
            CharSequence charSequence2 = charSequence;
            C12238m.checkNotNullParameter(charSequence2, "data");
            TextView textView = this.f414a.f15039a;
            C12238m.checkNotNullExpressionValue(textView, "binding.root");
            textView.setText(charSequence2);
            this.f414a.f15039a.setOnClickListener(new ViewOnClickListenerC0838o(this));
        }
    }

    /* JADX INFO: renamed from: b.a.a.n$c */
    /* JADX INFO: compiled from: SelectorDialog.kt */
    public static final /* synthetic */ class c extends C12236k implements Function1<View, C0995l> {

        /* JADX INFO: renamed from: j */
        public static final c f416j = new c();

        public c() {
            super(1, C0995l.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/DialogSimpleSelectorBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public C0995l invoke(View view) {
            View view2 = view;
            C12238m.checkNotNullParameter(view2, "p1");
            int i = C5419R.id.dialog_cancel;
            MaterialButton materialButton = (MaterialButton) view2.findViewById(C5419R.id.dialog_cancel);
            if (materialButton != null) {
                i = C5419R.id.dialog_selections;
                MaxHeightRecyclerView maxHeightRecyclerView = (MaxHeightRecyclerView) view2.findViewById(C5419R.id.dialog_selections);
                if (maxHeightRecyclerView != null) {
                    i = C5419R.id.dialog_title;
                    TextView textView = (TextView) view2.findViewById(C5419R.id.dialog_title);
                    if (textView != null) {
                        return new C0995l((LinearLayout) view2, materialButton, maxHeightRecyclerView, textView);
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
            C0837n.this.dismiss();
        }
    }

    /* JADX INFO: renamed from: b.a.a.n$e */
    /* JADX INFO: compiled from: SelectorDialog.kt */
    public static final class e extends AbstractC12240o implements Function2<LayoutInflater, ViewGroup, b> {
        public e() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public b invoke(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            LayoutInflater layoutInflater2 = layoutInflater;
            ViewGroup viewGroup2 = viewGroup;
            C12238m.checkNotNullParameter(layoutInflater2, "inflater");
            C12238m.checkNotNullParameter(viewGroup2, "parent");
            DialogSimpleSelectorItemBinding dialogSimpleSelectorItemBindingM8381a = DialogSimpleSelectorItemBinding.m8381a(layoutInflater2, viewGroup2, false);
            C12238m.checkNotNullExpressionValue(dialogSimpleSelectorItemBindingM8381a, "DialogSimpleSelectorItem…(inflater, parent, false)");
            return new b(C0837n.this, dialogSimpleSelectorItemBindingM8381a);
        }
    }

    public C0837n() {
        super(C5419R.layout.dialog_simple_selector);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, c.f416j, null, 2, null);
    }

    /* JADX INFO: renamed from: g */
    public final C0995l m141g() {
        return (C0995l) this.binding.getValue((Fragment) this, f410j[0]);
    }

    @Override // com.discord.app.AppDialog, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        dismiss();
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        TextView textView = m141g().f1011d;
        C12238m.checkNotNullExpressionValue(textView, "binding.dialogTitle");
        textView.setText(getArgumentsOrDefault().getCharSequence("INTENT_DIALOG_TITLE", null));
        m141g().f1009b.setOnClickListener(new d());
        CharSequence[] charSequenceArray = getArgumentsOrDefault().getCharSequenceArray("INTENT_DIALOG_OPTIONS");
        if (charSequenceArray != null) {
            MaxHeightRecyclerView maxHeightRecyclerView = m141g().f1010c;
            C12238m.checkNotNullExpressionValue(maxHeightRecyclerView, "binding.dialogSelections");
            maxHeightRecyclerView.setAdapter(new SimpleRecyclerAdapter(C12139j.asList(charSequenceArray), new e()));
            MaxHeightRecyclerView maxHeightRecyclerView2 = m141g().f1010c;
            RecyclerView.Adapter adapter = maxHeightRecyclerView2.getAdapter();
            if (adapter != null) {
                adapter.notifyDataSetChanged();
            }
            maxHeightRecyclerView2.setHasFixedSize(false);
            maxHeightRecyclerView2.setNestedScrollingEnabled(false);
            SimpleRecyclerAdapter.Companion companion = SimpleRecyclerAdapter.INSTANCE;
            MaxHeightRecyclerView maxHeightRecyclerView3 = m141g().f1010c;
            C12238m.checkNotNullExpressionValue(maxHeightRecyclerView3, "binding.dialogSelections");
            companion.addThemedDivider(maxHeightRecyclerView3);
        }
    }
}
