package b.i.a.g.e;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable$ConstantState;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: BorderDrawable.java */
/* JADX INFO: loaded from: classes3.dex */
public class c$b extends Drawable$ConstantState {
    public final /* synthetic */ c a;

    public c$b(c cVar, c$a c_a) {
        this.a = cVar;
    }

    @Override // android.graphics.drawable.Drawable$ConstantState
    public int getChangingConfigurations() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable$ConstantState
    @NonNull
    public Drawable newDrawable() {
        return this.a;
    }
}
