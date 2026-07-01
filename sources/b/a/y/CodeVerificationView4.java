package b.a.y;

import android.view.KeyEvent;
import android.view.View;
import com.discord.views.CodeVerificationView;
import d0.g0._Strings;
import d0.z.d.Intrinsics3;
import java.util.Objects;

/* JADX INFO: renamed from: b.a.y.d, reason: use source file name */
/* JADX INFO: compiled from: CodeVerificationView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class CodeVerificationView4 implements View.OnKeyListener {
    public final /* synthetic */ CodeVerificationView j;

    public CodeVerificationView4(CodeVerificationView codeVerificationView) {
        this.j = codeVerificationView;
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        Intrinsics3.checkNotNullExpressionValue(keyEvent, "event");
        if (keyEvent.getAction() == 0) {
            CodeVerificationView codeVerificationView = this.j;
            CodeVerificationView.a aVar = CodeVerificationView.j;
            Objects.requireNonNull(codeVerificationView);
            if (keyEvent.getKeyCode() == 67) {
                if (codeVerificationView.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String.length() > 0) {
                    codeVerificationView.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String = _Strings.dropLast(codeVerificationView.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String, 1);
                    codeVerificationView.d();
                }
            } else if (keyEvent.getKeyCode() == 7) {
                codeVerificationView.c('0');
            } else {
                int unicodeChar = keyEvent.getUnicodeChar();
                if (unicodeChar != 0) {
                    codeVerificationView.c((char) unicodeChar);
                }
            }
        }
        return true;
    }
}
