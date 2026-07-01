package b.l.a;

import android.view.animation.AnimationUtils;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: ApngDrawable.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a$a$a extends o implements Function0<Long> {
    public static final a$a$a j = new a$a$a();

    public a$a$a() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public Long invoke() {
        return Long.valueOf(AnimationUtils.currentAnimationTimeMillis());
    }
}
