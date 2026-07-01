package b.l.a;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable$ConstantState;
import androidx.annotation.IntRange;
import com.linecorp.apng.decoder.Apng;
import d0.z.d.m;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: ApngDrawable.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a$a extends Drawable$ConstantState {
    public final Apng a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1902b;
    public final int c;
    public final int d;
    public final Function0<Long> e;

    public a$a(Apng apng, @IntRange(from = 1, to = 2147483647L) int i, @IntRange(from = 1, to = 2147483647L) int i2, int i3, Function0<Long> function0) {
        m.checkNotNullParameter(apng, "apng");
        m.checkNotNullParameter(function0, "currentTimeProvider");
        this.a = apng;
        this.f1902b = i;
        this.c = i2;
        this.d = i3;
        this.e = function0;
    }

    @Override // android.graphics.drawable.Drawable$ConstantState
    public int getChangingConfigurations() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable$ConstantState
    public Drawable newDrawable() {
        return new a(new a$a(this));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a$a(a$a a_a) {
        this(a_a.a.copy(), a_a.f1902b, a_a.c, a_a.d, a_a.e);
        m.checkNotNullParameter(a_a, "apngState");
    }
}
