package b.a.i;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.typing.TypingDot;

/* JADX INFO: renamed from: b.a.i.t1, reason: use source file name */
/* JADX INFO: compiled from: TypingDotsViewBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class TypingDotsViewBinding implements ViewBinding {

    @NonNull
    public final View a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final TypingDot f202b;

    @NonNull
    public final TypingDot c;

    @NonNull
    public final TypingDot d;

    public TypingDotsViewBinding(@NonNull View view, @NonNull TypingDot typingDot, @NonNull TypingDot typingDot2, @NonNull TypingDot typingDot3) {
        this.a = view;
        this.f202b = typingDot;
        this.c = typingDot2;
        this.d = typingDot3;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
