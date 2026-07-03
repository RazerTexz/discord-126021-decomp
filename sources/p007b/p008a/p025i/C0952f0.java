package p007b.p008a.p025i;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import com.discord.views.premium.AccountCreditView;

/* JADX INFO: renamed from: b.a.i.f0 */
/* JADX INFO: compiled from: LayoutAccountCreditsListBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0952f0 implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final CardView f830a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final AccountCreditView f831b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final AccountCreditView f832c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final View f833d;

    public C0952f0(@NonNull CardView cardView, @NonNull AccountCreditView accountCreditView, @NonNull AccountCreditView accountCreditView2, @NonNull View view) {
        this.f830a = cardView;
        this.f831b = accountCreditView;
        this.f832c = accountCreditView2;
        this.f833d = view;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f830a;
    }
}
