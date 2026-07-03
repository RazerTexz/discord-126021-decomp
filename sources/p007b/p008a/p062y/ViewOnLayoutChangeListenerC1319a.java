package p007b.p008a.p062y;

import android.view.View;
import com.discord.views.CodeVerificationView;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.y.a */
/* JADX INFO: compiled from: View.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ViewOnLayoutChangeListenerC1319a implements View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ CodeVerificationView f2006j;

    public ViewOnLayoutChangeListenerC1319a(CodeVerificationView codeVerificationView) {
        this.f2006j = codeVerificationView;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        C12238m.checkNotNullParameter(view, "view");
        view.removeOnLayoutChangeListener(this);
        CodeVerificationView.m8537a(this.f2006j);
    }
}
