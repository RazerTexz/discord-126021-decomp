package d0.e0;

import java.util.List;
import kotlin.reflect.KType;

/* JADX INFO: renamed from: d0.e0.h, reason: use source file name */
/* JADX INFO: compiled from: KTypeParameter.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface KTypeParameter extends KClassifier {
    String getName();

    List<KType> getUpperBounds();

    KVariance getVariance();
}
