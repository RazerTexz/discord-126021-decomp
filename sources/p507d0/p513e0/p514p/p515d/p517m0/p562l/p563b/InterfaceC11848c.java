package p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b;

import java.util.List;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11682g;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11689n;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11692q;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11694s;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11696u;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.InterfaceC11704c;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.AbstractC11889y;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0;

/* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.c */
/* JADX INFO: compiled from: AnnotationAndConstantLoader.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface InterfaceC11848c<A, C> {
    List<A> loadCallableAnnotations(AbstractC11889y abstractC11889y, InterfaceC11734n interfaceC11734n, EnumC11846b enumC11846b);

    List<A> loadClassAnnotations(AbstractC11889y.a aVar);

    List<A> loadEnumEntryAnnotations(AbstractC11889y abstractC11889y, C11682g c11682g);

    List<A> loadExtensionReceiverParameterAnnotations(AbstractC11889y abstractC11889y, InterfaceC11734n interfaceC11734n, EnumC11846b enumC11846b);

    List<A> loadPropertyBackingFieldAnnotations(AbstractC11889y abstractC11889y, C11689n c11689n);

    C loadPropertyConstant(AbstractC11889y abstractC11889y, C11689n c11689n, AbstractC11913c0 abstractC11913c0);

    List<A> loadPropertyDelegateFieldAnnotations(AbstractC11889y abstractC11889y, C11689n c11689n);

    List<A> loadTypeAnnotations(C11692q c11692q, InterfaceC11704c interfaceC11704c);

    List<A> loadTypeParameterAnnotations(C11694s c11694s, InterfaceC11704c interfaceC11704c);

    List<A> loadValueParameterAnnotations(AbstractC11889y abstractC11889y, InterfaceC11734n interfaceC11734n, EnumC11846b enumC11846b, int i, C11696u c11696u);
}
