package b.a.y;

import android.view.View;
import com.discord.views.CodeVerificationView;

/* JADX INFO: renamed from: b.a.y.b, reason: use source file name */
/* JADX INFO: compiled from: CodeVerificationView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class CodeVerificationView2 implements View.OnFocusChangeListener {
    public final /* synthetic */ CodeVerificationView j;

    public CodeVerificationView2(CodeVerificationView codeVerificationView) {
        this.j = codeVerificationView;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z2) {
        if (z2) {
            CodeVerificationView.a(this.j);
        }
    }
}
