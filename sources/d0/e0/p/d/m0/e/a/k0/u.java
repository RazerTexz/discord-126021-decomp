package d0.e0.p.d.m0.e.a.k0;

import d0.e0.p.d.m0.g.FqName;
import d0.e0.p.d.m0.g.Name;
import java.util.Collection;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: javaElements.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface u extends d, l {
    Collection<g> getClasses(Function1<? super Name, Boolean> function1);

    FqName getFqName();

    Collection<u> getSubPackages();
}
