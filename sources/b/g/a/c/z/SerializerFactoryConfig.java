package b.g.a.c.z;

import b.g.a.c.g0.BeanSerializerModifier;
import b.g.a.c.g0.Serializers;
import b.g.a.c.i0.ArrayIterator2;
import java.io.Serializable;

/* JADX INFO: renamed from: b.g.a.c.z.o, reason: use source file name */
/* JADX INFO: compiled from: SerializerFactoryConfig.java */
/* JADX INFO: loaded from: classes3.dex */
public final class SerializerFactoryConfig implements Serializable {
    public static final Serializers[] j = new Serializers[0];
    public static final BeanSerializerModifier[] k = new BeanSerializerModifier[0];
    private static final long serialVersionUID = 1;
    public final Serializers[] _additionalKeySerializers;
    public final Serializers[] _additionalSerializers;
    public final BeanSerializerModifier[] _modifiers;

    public SerializerFactoryConfig() {
        Serializers[] serializersArr = j;
        this._additionalSerializers = serializersArr;
        this._additionalKeySerializers = serializersArr;
        this._modifiers = k;
    }

    public boolean a() {
        return this._modifiers.length > 0;
    }

    public Iterable<BeanSerializerModifier> b() {
        return new ArrayIterator2(this._modifiers);
    }
}
