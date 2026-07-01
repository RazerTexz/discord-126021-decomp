package b.a.a;

import android.widget.TextView;
import com.discord.databinding.DialogSimpleSelectorItemBinding;
import com.discord.utilities.views.SimpleRecyclerAdapter$ViewHolder;

/* JADX INFO: compiled from: SelectorDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class n$b extends SimpleRecyclerAdapter$ViewHolder<CharSequence> {
    public final DialogSimpleSelectorItemBinding a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ n f49b;

    /* JADX WARN: Illegal instructions before constructor call */
    public n$b(n nVar, DialogSimpleSelectorItemBinding dialogSimpleSelectorItemBinding) {
        d0.z.d.m.checkNotNullParameter(dialogSimpleSelectorItemBinding, "binding");
        this.f49b = nVar;
        TextView textView = dialogSimpleSelectorItemBinding.a;
        d0.z.d.m.checkNotNullExpressionValue(textView, "binding.root");
        super(textView);
        this.a = dialogSimpleSelectorItemBinding;
    }

    @Override // com.discord.utilities.views.SimpleRecyclerAdapter$ViewHolder
    public void bind(CharSequence charSequence) {
        CharSequence charSequence2 = charSequence;
        d0.z.d.m.checkNotNullParameter(charSequence2, "data");
        TextView textView = this.a.a;
        d0.z.d.m.checkNotNullExpressionValue(textView, "binding.root");
        textView.setText(charSequence2);
        this.a.a.setOnClickListener(new o(this));
    }
}
