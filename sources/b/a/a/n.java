package b.a.a;

import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppDialog;
import com.discord.utilities.view.recycler.MaxHeightRecyclerView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.utilities.views.SimpleRecyclerAdapter;
import com.discord.utilities.views.SimpleRecyclerAdapter$Companion;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: SelectorDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class n extends AppDialog {
    public static final /* synthetic */ KProperty[] j = {a.d0(n.class, "binding", "getBinding()Lcom/discord/databinding/DialogSimpleSelectorBinding;", 0)};
    public static final n$a k = new n$a(null);

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public Function1<? super Integer, Unit> onSelectedListener;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public final FragmentViewBindingDelegate binding;

    public n() {
        super(R$layout.dialog_simple_selector);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, n$c.j, null, 2, null);
    }

    public final b.a.i.l g() {
        return (b.a.i.l) this.binding.getValue((Fragment) this, j[0]);
    }

    @Override // com.discord.app.AppDialog, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        dismiss();
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        d0.z.d.m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        TextView textView = g().d;
        d0.z.d.m.checkNotNullExpressionValue(textView, "binding.dialogTitle");
        textView.setText(getArgumentsOrDefault().getCharSequence("INTENT_DIALOG_TITLE", null));
        g().f149b.setOnClickListener(new n$d(this));
        CharSequence[] charSequenceArray = getArgumentsOrDefault().getCharSequenceArray("INTENT_DIALOG_OPTIONS");
        if (charSequenceArray != null) {
            MaxHeightRecyclerView maxHeightRecyclerView = g().c;
            d0.z.d.m.checkNotNullExpressionValue(maxHeightRecyclerView, "binding.dialogSelections");
            maxHeightRecyclerView.setAdapter(new SimpleRecyclerAdapter(d0.t.j.asList(charSequenceArray), new n$e(this)));
            MaxHeightRecyclerView maxHeightRecyclerView2 = g().c;
            RecyclerView$Adapter adapter = maxHeightRecyclerView2.getAdapter();
            if (adapter != null) {
                adapter.notifyDataSetChanged();
            }
            maxHeightRecyclerView2.setHasFixedSize(false);
            maxHeightRecyclerView2.setNestedScrollingEnabled(false);
            SimpleRecyclerAdapter$Companion simpleRecyclerAdapter$Companion = SimpleRecyclerAdapter.Companion;
            MaxHeightRecyclerView maxHeightRecyclerView3 = g().c;
            d0.z.d.m.checkNotNullExpressionValue(maxHeightRecyclerView3, "binding.dialogSelections");
            simpleRecyclerAdapter$Companion.addThemedDivider(maxHeightRecyclerView3);
        }
    }
}
