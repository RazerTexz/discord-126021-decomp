package p007b.p008a.p062y;

import android.view.KeyEvent;
import android.view.View;
import com.discord.views.CodeVerificationView;
import java.util.Objects;
import p507d0.p579g0.C12108y;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.y.d */
/* JADX INFO: compiled from: CodeVerificationView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ViewOnKeyListenerC1325d implements View.OnKeyListener {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ CodeVerificationView f2015j;

    public ViewOnKeyListenerC1325d(CodeVerificationView codeVerificationView) {
        this.f2015j = codeVerificationView;
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        C12238m.checkNotNullExpressionValue(keyEvent, "event");
        if (keyEvent.getAction() == 0) {
            CodeVerificationView codeVerificationView = this.f2015j;
            CodeVerificationView.EnumC7072a enumC7072a = CodeVerificationView.f19031j;
            Objects.requireNonNull(codeVerificationView);
            if (keyEvent.getKeyCode() == 67) {
                if (codeVerificationView.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String.length() > 0) {
                    codeVerificationView.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String = C12108y.dropLast(codeVerificationView.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String, 1);
                    codeVerificationView.m8540d();
                }
            } else if (keyEvent.getKeyCode() == 7) {
                codeVerificationView.m8539c('0');
            } else {
                int unicodeChar = keyEvent.getUnicodeChar();
                if (unicodeChar != 0) {
                    codeVerificationView.m8539c((char) unicodeChar);
                }
            }
        }
        return true;
    }
}
