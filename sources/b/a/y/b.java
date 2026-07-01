package b.a.y;

import android.view.View;
import android.view.View$OnFocusChangeListener;
import com.discord.views.CodeVerificationView;

/* JADX INFO: compiled from: CodeVerificationView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class b implements View$OnFocusChangeListener {
    public final /* synthetic */ CodeVerificationView j;

    public b(CodeVerificationView codeVerificationView) {
        this.j = codeVerificationView;
    }

    @Override // android.view.View$OnFocusChangeListener
    public final void onFocusChange(View view, boolean z2) {
        if (z2) {
            CodeVerificationView.a(this.j);
        }
    }
}
