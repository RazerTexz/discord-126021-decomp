package b.i.a.g.e;

import android.graphics.Matrix;
import androidx.annotation.NonNull;
import com.google.android.material.animation.MatrixEvaluator;

/* JADX INFO: compiled from: FloatingActionButtonImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class f$a extends MatrixEvaluator {
    public final /* synthetic */ f a;

    public f$a(f fVar) {
        this.a = fVar;
    }

    @Override // com.google.android.material.animation.MatrixEvaluator, android.animation.TypeEvaluator
    public Matrix evaluate(float f, @NonNull Matrix matrix, @NonNull Matrix matrix2) {
        this.a.f1619z = f;
        return super.evaluate(f, matrix, matrix2);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.material.animation.MatrixEvaluator
    public Matrix evaluate(float f, @NonNull Matrix matrix, @NonNull Matrix matrix2) {
        this.a.f1619z = f;
        return super.evaluate(f, matrix, matrix2);
    }
}
