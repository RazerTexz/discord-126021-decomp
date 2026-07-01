package b.g.a.c.z;

import b.g.a.c.AbstractTypeResolver;
import b.g.a.c.a0.BeanDeserializerModifier;
import b.g.a.c.a0.Deserializers;
import b.g.a.c.a0.KeyDeserializers;
import b.g.a.c.a0.ValueInstantiators;
import b.g.a.c.a0.l.StdKeyDeserializers;
import java.io.Serializable;

/* JADX INFO: renamed from: b.g.a.c.z.j, reason: use source file name */
/* JADX INFO: compiled from: DeserializerFactoryConfig.java */
/* JADX INFO: loaded from: classes3.dex */
public class DeserializerFactoryConfig implements Serializable {
    public static final Deserializers[] j = new Deserializers[0];
    public static final BeanDeserializerModifier[] k = new BeanDeserializerModifier[0];
    public static final AbstractTypeResolver[] l = new AbstractTypeResolver[0];
    public static final ValueInstantiators[] m = new ValueInstantiators[0];
    public static final KeyDeserializers[] n = {new StdKeyDeserializers()};
    private static final long serialVersionUID = 1;
    public final Deserializers[] _additionalDeserializers = j;
    public final KeyDeserializers[] _additionalKeyDeserializers = n;
    public final BeanDeserializerModifier[] _modifiers = k;
    public final AbstractTypeResolver[] _abstractTypeResolvers = l;
    public final ValueInstantiators[] _valueInstantiators = m;
}
