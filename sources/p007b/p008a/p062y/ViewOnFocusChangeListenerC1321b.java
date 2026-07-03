package p007b.p008a.p062y;

import android.view.View;
import com.discord.views.CodeVerificationView;

/* JADX INFO: renamed from: b.a.y.b */
/* JADX INFO: compiled from: CodeVerificationView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ViewOnFocusChangeListenerC1321b implements View.OnFocusChangeListener {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ CodeVerificationView f2007j;

    public ViewOnFocusChangeListenerC1321b(CodeVerificationView codeVerificationView) {
        this.f2007j = codeVerificationView;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z2) {
        if (z2) {
            CodeVerificationView.m8537a(this.f2007j);
        }
    }
}
