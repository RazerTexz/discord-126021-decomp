package b.a.i;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import com.discord.views.premium.AccountCreditView;

/* JADX INFO: compiled from: LayoutAccountCreditsListBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class f0 implements ViewBinding {

    @NonNull
    public final CardView a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final AccountCreditView f110b;

    @NonNull
    public final AccountCreditView c;

    @NonNull
    public final View d;

    public f0(@NonNull CardView cardView, @NonNull AccountCreditView accountCreditView, @NonNull AccountCreditView accountCreditView2, @NonNull View view) {
        this.a = cardView;
        this.f110b = accountCreditView;
        this.c = accountCreditView2;
        this.d = view;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
