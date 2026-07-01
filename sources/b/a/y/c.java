package b.a.y;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.views.CodeVerificationView;

/* JADX INFO: compiled from: CodeVerificationView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class c implements View$OnClickListener {
    public final /* synthetic */ CodeVerificationView j;

    public c(CodeVerificationView codeVerificationView) {
        this.j = codeVerificationView;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        CodeVerificationView.a(this.j);
    }
}
