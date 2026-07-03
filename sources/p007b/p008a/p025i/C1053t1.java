package p007b.p008a.p025i;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.typing.TypingDot;

/* JADX INFO: renamed from: b.a.i.t1 */
/* JADX INFO: compiled from: TypingDotsViewBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C1053t1 implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final View f1239a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TypingDot f1240b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TypingDot f1241c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TypingDot f1242d;

    public C1053t1(@NonNull View view, @NonNull TypingDot typingDot, @NonNull TypingDot typingDot2, @NonNull TypingDot typingDot3) {
        this.f1239a = view;
        this.f1240b = typingDot;
        this.f1241c = typingDot2;
        this.f1242d = typingDot3;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1239a;
    }
}
