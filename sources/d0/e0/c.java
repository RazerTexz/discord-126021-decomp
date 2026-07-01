package d0.e0;

import java.util.List;
import kotlin.reflect.KDeclarationContainer;

/* JADX INFO: compiled from: KClass.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface c<T> extends KDeclarationContainer, b, d {
    T getObjectInstance();

    String getQualifiedName();

    List<c<? extends T>> getSealedSubclasses();

    String getSimpleName();
}
