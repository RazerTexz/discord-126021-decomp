package d0.e0;

import java.util.List;
import kotlin.reflect.KDeclarationContainer;

/* JADX INFO: renamed from: d0.e0.c, reason: use source file name */
/* JADX INFO: compiled from: KClass.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface KClass<T> extends KDeclarationContainer, KAnnotatedElement, KClassifier {
    T getObjectInstance();

    String getQualifiedName();

    List<KClass<? extends T>> getSealedSubclasses();

    String getSimpleName();
}
