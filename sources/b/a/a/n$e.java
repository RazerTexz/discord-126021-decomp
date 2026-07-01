package b.a.a;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.discord.databinding.DialogSimpleSelectorItemBinding;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: SelectorDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class n$e extends d0.z.d.o implements Function2<LayoutInflater, ViewGroup, n$b> {
    public final /* synthetic */ n this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n$e(n nVar) {
        super(2);
        this.this$0 = nVar;
    }

    @Override // kotlin.jvm.functions.Function2
    public n$b invoke(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        LayoutInflater layoutInflater2 = layoutInflater;
        ViewGroup viewGroup2 = viewGroup;
        d0.z.d.m.checkNotNullParameter(layoutInflater2, "inflater");
        d0.z.d.m.checkNotNullParameter(viewGroup2, "parent");
        DialogSimpleSelectorItemBinding dialogSimpleSelectorItemBindingA = DialogSimpleSelectorItemBinding.a(layoutInflater2, viewGroup2, false);
        d0.z.d.m.checkNotNullExpressionValue(dialogSimpleSelectorItemBindingA, "DialogSimpleSelectorItem…(inflater, parent, false)");
        return new n$b(this.this$0, dialogSimpleSelectorItemBindingA);
    }
}
