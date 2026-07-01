package b.a.y;

import android.view.View;
import com.discord.views.CodeVerificationView;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: View.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a implements View.OnLayoutChangeListener {
    public final /* synthetic */ CodeVerificationView j;

    public a(CodeVerificationView codeVerificationView) {
        this.j = codeVerificationView;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        Intrinsics3.checkNotNullParameter(view, "view");
        view.removeOnLayoutChangeListener(this);
        CodeVerificationView.a(this.j);
    }
}
