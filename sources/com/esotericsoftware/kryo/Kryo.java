package com.esotericsoftware.kryo;

import b.e.a.a$a;
import com.esotericsoftware.kryo.factories.PseudoSerializerFactory;
import com.esotericsoftware.kryo.factories.ReflectionSerializerFactory;
import com.esotericsoftware.kryo.factories.SerializerFactory;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.serializers.ClosureSerializer$Closure;
import com.esotericsoftware.kryo.serializers.CollectionSerializer;
import com.esotericsoftware.kryo.serializers.DefaultArraySerializers$BooleanArraySerializer;
import com.esotericsoftware.kryo.serializers.DefaultArraySerializers$ByteArraySerializer;
import com.esotericsoftware.kryo.serializers.DefaultArraySerializers$CharArraySerializer;
import com.esotericsoftware.kryo.serializers.DefaultArraySerializers$DoubleArraySerializer;
import com.esotericsoftware.kryo.serializers.DefaultArraySerializers$FloatArraySerializer;
import com.esotericsoftware.kryo.serializers.DefaultArraySerializers$IntArraySerializer;
import com.esotericsoftware.kryo.serializers.DefaultArraySerializers$LongArraySerializer;
import com.esotericsoftware.kryo.serializers.DefaultArraySerializers$ObjectArraySerializer;
import com.esotericsoftware.kryo.serializers.DefaultArraySerializers$ShortArraySerializer;
import com.esotericsoftware.kryo.serializers.DefaultArraySerializers$StringArraySerializer;
import com.esotericsoftware.kryo.serializers.DefaultSerializers$BigDecimalSerializer;
import com.esotericsoftware.kryo.serializers.DefaultSerializers$BigIntegerSerializer;
import com.esotericsoftware.kryo.serializers.DefaultSerializers$BooleanSerializer;
import com.esotericsoftware.kryo.serializers.DefaultSerializers$ByteSerializer;
import com.esotericsoftware.kryo.serializers.DefaultSerializers$CalendarSerializer;
import com.esotericsoftware.kryo.serializers.DefaultSerializers$CharSerializer;
import com.esotericsoftware.kryo.serializers.DefaultSerializers$CharsetSerializer;
import com.esotericsoftware.kryo.serializers.DefaultSerializers$ClassSerializer;
import com.esotericsoftware.kryo.serializers.DefaultSerializers$CollectionsEmptyListSerializer;
import com.esotericsoftware.kryo.serializers.DefaultSerializers$CollectionsEmptyMapSerializer;
import com.esotericsoftware.kryo.serializers.DefaultSerializers$CollectionsEmptySetSerializer;
import com.esotericsoftware.kryo.serializers.DefaultSerializers$CollectionsSingletonListSerializer;
import com.esotericsoftware.kryo.serializers.DefaultSerializers$CollectionsSingletonMapSerializer;
import com.esotericsoftware.kryo.serializers.DefaultSerializers$CollectionsSingletonSetSerializer;
import com.esotericsoftware.kryo.serializers.DefaultSerializers$CurrencySerializer;
import com.esotericsoftware.kryo.serializers.DefaultSerializers$DateSerializer;
import com.esotericsoftware.kryo.serializers.DefaultSerializers$DoubleSerializer;
import com.esotericsoftware.kryo.serializers.DefaultSerializers$EnumSerializer;
import com.esotericsoftware.kryo.serializers.DefaultSerializers$EnumSetSerializer;
import com.esotericsoftware.kryo.serializers.DefaultSerializers$FloatSerializer;
import com.esotericsoftware.kryo.serializers.DefaultSerializers$IntSerializer;
import com.esotericsoftware.kryo.serializers.DefaultSerializers$KryoSerializableSerializer;
import com.esotericsoftware.kryo.serializers.DefaultSerializers$LocaleSerializer;
import com.esotericsoftware.kryo.serializers.DefaultSerializers$LongSerializer;
import com.esotericsoftware.kryo.serializers.DefaultSerializers$ShortSerializer;
import com.esotericsoftware.kryo.serializers.DefaultSerializers$StringBufferSerializer;
import com.esotericsoftware.kryo.serializers.DefaultSerializers$StringBuilderSerializer;
import com.esotericsoftware.kryo.serializers.DefaultSerializers$StringSerializer;
import com.esotericsoftware.kryo.serializers.DefaultSerializers$TimeZoneSerializer;
import com.esotericsoftware.kryo.serializers.DefaultSerializers$TreeMapSerializer;
import com.esotericsoftware.kryo.serializers.DefaultSerializers$TreeSetSerializer;
import com.esotericsoftware.kryo.serializers.DefaultSerializers$URLSerializer;
import com.esotericsoftware.kryo.serializers.DefaultSerializers$VoidSerializer;
import com.esotericsoftware.kryo.serializers.FieldSerializer;
import com.esotericsoftware.kryo.serializers.FieldSerializerConfig;
import com.esotericsoftware.kryo.serializers.GenericsResolver;
import com.esotericsoftware.kryo.serializers.MapSerializer;
import com.esotericsoftware.kryo.serializers.OptionalSerializers;
import com.esotericsoftware.kryo.serializers.TaggedFieldSerializerConfig;
import com.esotericsoftware.kryo.serializers.TimeSerializers;
import com.esotericsoftware.kryo.util.DefaultClassResolver;
import com.esotericsoftware.kryo.util.DefaultStreamFactory;
import com.esotericsoftware.kryo.util.IdentityMap;
import com.esotericsoftware.kryo.util.IntArray;
import com.esotericsoftware.kryo.util.MapReferenceResolver;
import com.esotericsoftware.kryo.util.ObjectMap;
import com.esotericsoftware.kryo.util.Util;
import h0.b.b.a;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Currency;
import java.util.Date;
import java.util.EnumSet;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.TreeMap;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes.dex */
public class Kryo {
    public static final byte NOT_NULL = 1;
    private static final int NO_REF = -2;
    public static final byte NULL = 0;
    private static final int REF = -1;
    private boolean autoReset;
    private ClassLoader classLoader;
    private final ClassResolver classResolver;
    private ObjectMap context;
    private int copyDepth;
    private boolean copyReferences;
    private boolean copyShallow;
    private SerializerFactory defaultSerializer;
    private final ArrayList<Kryo$DefaultSerializerEntry> defaultSerializers;
    private int depth;
    private FieldSerializerConfig fieldSerializerConfig;
    private GenericsResolver genericsResolver;
    private ObjectMap graphContext;
    private final int lowPriorityDefaultSerializerCount;
    private int maxDepth;
    private Object needsCopyReference;
    private int nextRegisterID;
    private IdentityMap originalToCopy;
    private Object readObject;
    private final IntArray readReferenceIds;
    private ReferenceResolver referenceResolver;
    private boolean references;
    private boolean registrationRequired;
    private a strategy;
    private StreamFactory streamFactory;
    private TaggedFieldSerializerConfig taggedFieldSerializerConfig;
    private volatile Thread thread;
    private boolean warnUnregisteredClasses;

    public Kryo() {
        this(new DefaultClassResolver(), new MapReferenceResolver(), new DefaultStreamFactory());
    }

    private void beginObject() {
        a$a a_a = b.e.a.a.a;
        int i = this.depth;
        if (i != this.maxDepth) {
            this.depth = i + 1;
        } else {
            StringBuilder sbU = b.d.b.a.a.U("Max depth exceeded: ");
            sbU.append(this.depth);
            throw new KryoException(sbU.toString());
        }
    }

    public void addDefaultSerializer(Class cls, Serializer serializer) {
        if (cls == null) {
            throw new IllegalArgumentException("type cannot be null.");
        }
        if (serializer == null) {
            throw new IllegalArgumentException("serializer cannot be null.");
        }
        Kryo$DefaultSerializerEntry kryo$DefaultSerializerEntry = new Kryo$DefaultSerializerEntry(cls, new PseudoSerializerFactory(serializer));
        ArrayList<Kryo$DefaultSerializerEntry> arrayList = this.defaultSerializers;
        arrayList.add(arrayList.size() - this.lowPriorityDefaultSerializerCount, kryo$DefaultSerializerEntry);
    }

    public <T> T copy(T t) {
        if (t == null) {
            return null;
        }
        if (this.copyShallow) {
            return t;
        }
        this.copyDepth++;
        try {
            if (this.originalToCopy == null) {
                this.originalToCopy = new IdentityMap();
            }
            T t2 = (T) this.originalToCopy.get(t);
            if (t2 != null) {
                return t2;
            }
            if (this.copyReferences) {
                this.needsCopyReference = t;
            }
            T t3 = t instanceof KryoCopyable ? (T) ((KryoCopyable) t).copy(this) : (T) getSerializer(t.getClass()).copy(this, t);
            if (this.needsCopyReference != null) {
                reference(t3);
            }
            a$a a_a = b.e.a.a.a;
            return t3;
        } finally {
            int i = this.copyDepth - 1;
            this.copyDepth = i;
            if (i == 0) {
                reset();
            }
        }
    }

    public <T> T copyShallow(T t) {
        if (t == null) {
            return null;
        }
        this.copyDepth++;
        this.copyShallow = true;
        try {
            if (this.originalToCopy == null) {
                this.originalToCopy = new IdentityMap();
            }
            T t2 = (T) this.originalToCopy.get(t);
            if (t2 != null) {
                return t2;
            }
            if (this.copyReferences) {
                this.needsCopyReference = t;
            }
            T t3 = t instanceof KryoCopyable ? (T) ((KryoCopyable) t).copy(this) : (T) getSerializer(t.getClass()).copy(this, t);
            if (this.needsCopyReference != null) {
                reference(t3);
            }
            a$a a_a = b.e.a.a.a;
            return t3;
        } finally {
            this.copyShallow = false;
            int i = this.copyDepth - 1;
            this.copyDepth = i;
            if (i == 0) {
                reset();
            }
        }
    }

    @Deprecated
    public boolean getAsmEnabled() {
        return this.fieldSerializerConfig.isUseAsm();
    }

    public ClassLoader getClassLoader() {
        return this.classLoader;
    }

    public ClassResolver getClassResolver() {
        return this.classResolver;
    }

    public ObjectMap getContext() {
        if (this.context == null) {
            this.context = new ObjectMap();
        }
        return this.context;
    }

    public Serializer getDefaultSerializer(Class cls) {
        if (cls == null) {
            throw new IllegalArgumentException("type cannot be null.");
        }
        Serializer defaultSerializerForAnnotatedType = getDefaultSerializerForAnnotatedType(cls);
        if (defaultSerializerForAnnotatedType != null) {
            return defaultSerializerForAnnotatedType;
        }
        int size = this.defaultSerializers.size();
        for (int i = 0; i < size; i++) {
            Kryo$DefaultSerializerEntry kryo$DefaultSerializerEntry = this.defaultSerializers.get(i);
            if (kryo$DefaultSerializerEntry.type.isAssignableFrom(cls)) {
                return kryo$DefaultSerializerEntry.serializerFactory.makeSerializer(this, cls);
            }
        }
        return newDefaultSerializer(cls);
    }

    public Serializer getDefaultSerializerForAnnotatedType(Class cls) {
        if (cls.isAnnotationPresent(DefaultSerializer.class)) {
            return ReflectionSerializerFactory.makeSerializer(this, ((DefaultSerializer) cls.getAnnotation(DefaultSerializer.class)).value(), cls);
        }
        return null;
    }

    public int getDepth() {
        return this.depth;
    }

    public FieldSerializerConfig getFieldSerializerConfig() {
        return this.fieldSerializerConfig;
    }

    public GenericsResolver getGenericsResolver() {
        return this.genericsResolver;
    }

    public ObjectMap getGraphContext() {
        if (this.graphContext == null) {
            this.graphContext = new ObjectMap();
        }
        return this.graphContext;
    }

    public a getInstantiatorStrategy() {
        return this.strategy;
    }

    public int getNextRegistrationId() {
        while (true) {
            int i = this.nextRegisterID;
            if (i == -2) {
                throw new KryoException("No registration IDs are available.");
            }
            if (this.classResolver.getRegistration(i) == null) {
                return this.nextRegisterID;
            }
            this.nextRegisterID++;
        }
    }

    public IdentityMap getOriginalToCopyMap() {
        return this.originalToCopy;
    }

    public ReferenceResolver getReferenceResolver() {
        return this.referenceResolver;
    }

    public boolean getReferences() {
        return this.references;
    }

    public Registration getRegistration(Class cls) {
        if (cls == null) {
            throw new IllegalArgumentException("type cannot be null.");
        }
        Registration registration = this.classResolver.getRegistration(cls);
        if (registration != null) {
            return registration;
        }
        if (Proxy.isProxyClass(cls)) {
            registration = getRegistration(InvocationHandler.class);
        } else if (!cls.isEnum() && Enum.class.isAssignableFrom(cls) && !Enum.class.equals(cls)) {
            registration = getRegistration(cls.getEnclosingClass());
        } else if (EnumSet.class.isAssignableFrom(cls)) {
            registration = this.classResolver.getRegistration(EnumSet.class);
        } else if (isClosure(cls)) {
            registration = this.classResolver.getRegistration(ClosureSerializer$Closure.class);
        }
        if (registration != null) {
            return registration;
        }
        if (this.registrationRequired) {
            throw new IllegalArgumentException(unregisteredClassMessage(cls));
        }
        if (this.warnUnregisteredClasses) {
            b.e.a.a.a.a(4, null, unregisteredClassMessage(cls), null);
        }
        return this.classResolver.registerImplicit(cls);
    }

    public Serializer getSerializer(Class cls) {
        return getRegistration(cls).getSerializer();
    }

    public StreamFactory getStreamFactory() {
        return this.streamFactory;
    }

    public TaggedFieldSerializerConfig getTaggedFieldSerializerConfig() {
        return this.taggedFieldSerializerConfig;
    }

    public boolean isClosure(Class cls) {
        if (cls != null) {
            return cls.getName().indexOf(47) >= 0;
        }
        throw new IllegalArgumentException("type cannot be null.");
    }

    public boolean isFinal(Class cls) {
        if (cls != null) {
            return cls.isArray() ? Modifier.isFinal(Util.getElementClass(cls).getModifiers()) : Modifier.isFinal(cls.getModifiers());
        }
        throw new IllegalArgumentException("type cannot be null.");
    }

    public boolean isRegistrationRequired() {
        return this.registrationRequired;
    }

    public boolean isWarnUnregisteredClasses() {
        return this.warnUnregisteredClasses;
    }

    public Serializer newDefaultSerializer(Class cls) {
        return this.defaultSerializer.makeSerializer(this, cls);
    }

    public <T> T newInstance(Class<T> cls) {
        Registration registration = getRegistration(cls);
        h0.b.a.a instantiator = registration.getInstantiator();
        if (instantiator == null) {
            instantiator = newInstantiator(cls);
            registration.setInstantiator(instantiator);
        }
        return (T) instantiator.newInstance();
    }

    public h0.b.a.a newInstantiator(Class cls) {
        return this.strategy.newInstantiatorOf(cls);
    }

    public Registration readClass(Input input) {
        if (input == null) {
            throw new IllegalArgumentException("input cannot be null.");
        }
        try {
            return this.classResolver.readClass(input);
        } finally {
            if (this.depth == 0 && this.autoReset) {
                reset();
            }
        }
    }

    public Object readClassAndObject(Input input) {
        Object obj;
        if (input == null) {
            throw new IllegalArgumentException("input cannot be null.");
        }
        beginObject();
        try {
            Registration registration = readClass(input);
            if (registration == null) {
                return null;
            }
            Class type = registration.getType();
            if (this.references) {
                registration.getSerializer().setGenerics(this, null);
                int referenceOrNull = readReferenceOrNull(input, type, false);
                if (referenceOrNull == -1) {
                    return this.readObject;
                }
                obj = registration.getSerializer().read(this, input, type);
                if (referenceOrNull == this.readReferenceIds.size) {
                    reference(obj);
                }
            } else {
                obj = registration.getSerializer().read(this, input, type);
            }
            a$a a_a = b.e.a.a.a;
            return obj;
        } finally {
            int i = this.depth - 1;
            this.depth = i;
            if (i == 0 && this.autoReset) {
                reset();
            }
        }
    }

    public <T> T readObject(Input input, Class<T> cls) {
        T t;
        if (input == null) {
            throw new IllegalArgumentException("input cannot be null.");
        }
        if (cls == null) {
            throw new IllegalArgumentException("type cannot be null.");
        }
        beginObject();
        try {
            if (this.references) {
                int referenceOrNull = readReferenceOrNull(input, cls, false);
                if (referenceOrNull == -1) {
                    return (T) this.readObject;
                }
                t = (T) getRegistration(cls).getSerializer().read(this, input, cls);
                if (referenceOrNull == this.readReferenceIds.size) {
                    reference(t);
                }
            } else {
                t = (T) getRegistration(cls).getSerializer().read(this, input, cls);
            }
            a$a a_a = b.e.a.a.a;
            return t;
        } finally {
            int i = this.depth - 1;
            this.depth = i;
            if (i == 0 && this.autoReset) {
                reset();
            }
        }
    }

    public <T> T readObjectOrNull(Input input, Class<T> cls) {
        T t;
        if (input == null) {
            throw new IllegalArgumentException("input cannot be null.");
        }
        if (cls == null) {
            throw new IllegalArgumentException("type cannot be null.");
        }
        beginObject();
        try {
            if (this.references) {
                int referenceOrNull = readReferenceOrNull(input, cls, true);
                if (referenceOrNull == -1) {
                    return (T) this.readObject;
                }
                t = (T) getRegistration(cls).getSerializer().read(this, input, cls);
                if (referenceOrNull == this.readReferenceIds.size) {
                    reference(t);
                }
            } else {
                Serializer serializer = getRegistration(cls).getSerializer();
                if (!serializer.getAcceptsNull() && input.readByte() == 0) {
                    a$a a_a = b.e.a.a.a;
                    return null;
                }
                t = (T) serializer.read(this, input, cls);
            }
            a$a a_a2 = b.e.a.a.a;
            return t;
        } finally {
            int i = this.depth - 1;
            this.depth = i;
            if (i == 0 && this.autoReset) {
                reset();
            }
        }
    }

    public int readReferenceOrNull(Input input, Class cls, boolean z2) {
        int varInt;
        if (cls.isPrimitive()) {
            cls = Util.getWrapperClass(cls);
        }
        boolean zUseReferences = this.referenceResolver.useReferences(cls);
        if (z2) {
            varInt = input.readVarInt(true);
            if (varInt == 0) {
                a$a a_a = b.e.a.a.a;
                this.readObject = null;
                return -1;
            }
            if (!zUseReferences) {
                this.readReferenceIds.add(-2);
                return this.readReferenceIds.size;
            }
        } else {
            if (!zUseReferences) {
                this.readReferenceIds.add(-2);
                return this.readReferenceIds.size;
            }
            varInt = input.readVarInt(true);
        }
        if (varInt == 1) {
            int iNextReadId = this.referenceResolver.nextReadId(cls);
            a$a a_a2 = b.e.a.a.a;
            this.readReferenceIds.add(iNextReadId);
            return this.readReferenceIds.size;
        }
        this.readObject = this.referenceResolver.getReadObject(cls, varInt - 2);
        a$a a_a3 = b.e.a.a.a;
        return -1;
    }

    public void reference(Object obj) {
        int iPop;
        if (this.copyDepth <= 0) {
            if (!this.references || obj == null || (iPop = this.readReferenceIds.pop()) == -2) {
                return;
            }
            this.referenceResolver.setReadObject(iPop, obj);
            return;
        }
        Object obj2 = this.needsCopyReference;
        if (obj2 != null) {
            if (obj == null) {
                throw new IllegalArgumentException("object cannot be null.");
            }
            this.originalToCopy.put(obj2, obj);
            this.needsCopyReference = null;
        }
    }

    public Registration register(Class cls) {
        Registration registration = this.classResolver.getRegistration(cls);
        return registration != null ? registration : register(cls, getDefaultSerializer(cls));
    }

    public void reset() {
        this.depth = 0;
        ObjectMap objectMap = this.graphContext;
        if (objectMap != null) {
            objectMap.clear();
        }
        this.classResolver.reset();
        if (this.references) {
            this.referenceResolver.reset();
            this.readObject = null;
        }
        this.copyDepth = 0;
        IdentityMap identityMap = this.originalToCopy;
        if (identityMap != null) {
            identityMap.clear(2048);
        }
        a$a a_a = b.e.a.a.a;
    }

    @Deprecated
    public void setAsmEnabled(boolean z2) {
        this.fieldSerializerConfig.setUseAsm(z2);
    }

    public void setAutoReset(boolean z2) {
        this.autoReset = z2;
    }

    public void setClassLoader(ClassLoader classLoader) {
        if (classLoader == null) {
            throw new IllegalArgumentException("classLoader cannot be null.");
        }
        this.classLoader = classLoader;
    }

    public void setCopyReferences(boolean z2) {
        this.copyReferences = z2;
    }

    public void setDefaultSerializer(SerializerFactory serializerFactory) {
        if (serializerFactory == null) {
            throw new IllegalArgumentException("serializer cannot be null.");
        }
        this.defaultSerializer = serializerFactory;
    }

    public void setInstantiatorStrategy(a aVar) {
        this.strategy = aVar;
    }

    public void setMaxDepth(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxDepth must be > 0.");
        }
        this.maxDepth = i;
    }

    public void setReferenceResolver(ReferenceResolver referenceResolver) {
        if (referenceResolver == null) {
            throw new IllegalArgumentException("referenceResolver cannot be null.");
        }
        this.references = true;
        this.referenceResolver = referenceResolver;
        a$a a_a = b.e.a.a.a;
    }

    public boolean setReferences(boolean z2) {
        if (z2 == this.references) {
            return z2;
        }
        this.references = z2;
        if (z2 && this.referenceResolver == null) {
            this.referenceResolver = new MapReferenceResolver();
        }
        a$a a_a = b.e.a.a.a;
        return !z2;
    }

    public void setRegistrationRequired(boolean z2) {
        this.registrationRequired = z2;
        a$a a_a = b.e.a.a.a;
    }

    public void setStreamFactory(StreamFactory streamFactory) {
        this.streamFactory = streamFactory;
    }

    public void setWarnUnregisteredClasses(boolean z2) {
        this.warnUnregisteredClasses = z2;
        a$a a_a = b.e.a.a.a;
    }

    public String unregisteredClassMessage(Class cls) {
        StringBuilder sbU = b.d.b.a.a.U("Class is not registered: ");
        sbU.append(Util.className(cls));
        sbU.append("\nNote: To register this class use: kryo.register(");
        sbU.append(Util.className(cls));
        sbU.append(".class);");
        return sbU.toString();
    }

    public Registration writeClass(Output output, Class cls) {
        if (output == null) {
            throw new IllegalArgumentException("output cannot be null.");
        }
        try {
            return this.classResolver.writeClass(output, cls);
        } finally {
            if (this.depth == 0 && this.autoReset) {
                reset();
            }
        }
    }

    public void writeClassAndObject(Output output, Object obj) {
        if (output == null) {
            throw new IllegalArgumentException("output cannot be null.");
        }
        beginObject();
        try {
            if (obj == null) {
                writeClass(output, null);
                int i = this.depth - 1;
                this.depth = i;
                if (i == 0 && this.autoReset) {
                    reset();
                    return;
                }
                return;
            }
            Registration registrationWriteClass = writeClass(output, obj.getClass());
            if (this.references && writeReferenceOrNull(output, obj, false)) {
                registrationWriteClass.getSerializer().setGenerics(this, null);
                int i2 = this.depth - 1;
                this.depth = i2;
                if (i2 == 0 && this.autoReset) {
                    reset();
                    return;
                }
                return;
            }
            a$a a_a = b.e.a.a.a;
            registrationWriteClass.getSerializer().write(this, output, obj);
            int i3 = this.depth - 1;
            this.depth = i3;
            if (i3 == 0 && this.autoReset) {
                reset();
            }
        } catch (Throwable th) {
            int i4 = this.depth - 1;
            this.depth = i4;
            if (i4 == 0 && this.autoReset) {
                reset();
            }
            throw th;
        }
    }

    public void writeObject(Output output, Object obj) {
        if (output == null) {
            throw new IllegalArgumentException("output cannot be null.");
        }
        if (obj == null) {
            throw new IllegalArgumentException("object cannot be null.");
        }
        beginObject();
        try {
            if (this.references && writeReferenceOrNull(output, obj, false)) {
                getRegistration(obj.getClass()).getSerializer().setGenerics(this, null);
            } else {
                a$a a_a = b.e.a.a.a;
                getRegistration(obj.getClass()).getSerializer().write(this, output, obj);
            }
        } finally {
            int i = this.depth - 1;
            this.depth = i;
            if (i == 0 && this.autoReset) {
                reset();
            }
        }
    }

    public void writeObjectOrNull(Output output, Object obj, Class cls) {
        int i;
        boolean z2;
        if (output == null) {
            throw new IllegalArgumentException("output cannot be null.");
        }
        beginObject();
        try {
            Serializer serializer = getRegistration(cls).getSerializer();
            if (this.references) {
                if (writeReferenceOrNull(output, obj, true)) {
                    serializer.setGenerics(this, null);
                    if (i == 0) {
                        if (z2) {
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                }
            } else if (!serializer.getAcceptsNull()) {
                if (obj == null) {
                    a$a a_a = b.e.a.a.a;
                    output.writeByte((byte) 0);
                    if (i == 0) {
                        if (z2) {
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                }
                output.writeByte((byte) 1);
            }
            a$a a_a2 = b.e.a.a.a;
            serializer.write(this, output, obj);
        } finally {
            i = this.depth - 1;
            this.depth = i;
            if (i == 0 && this.autoReset) {
                reset();
            }
        }
    }

    public boolean writeReferenceOrNull(Output output, Object obj, boolean z2) {
        if (obj == null) {
            a$a a_a = b.e.a.a.a;
            output.writeVarInt(0, true);
            return true;
        }
        if (!this.referenceResolver.useReferences(obj.getClass())) {
            if (z2) {
                output.writeVarInt(1, true);
            }
            return false;
        }
        int writtenId = this.referenceResolver.getWrittenId(obj);
        if (writtenId != -1) {
            a$a a_a2 = b.e.a.a.a;
            output.writeVarInt(writtenId + 2, true);
            return true;
        }
        this.referenceResolver.addWrittenObject(obj);
        output.writeVarInt(1, true);
        a$a a_a3 = b.e.a.a.a;
        return false;
    }

    public Kryo(ReferenceResolver referenceResolver) {
        this(new DefaultClassResolver(), referenceResolver, new DefaultStreamFactory());
    }

    public Kryo(ClassResolver classResolver, ReferenceResolver referenceResolver) {
        this(classResolver, referenceResolver, new DefaultStreamFactory());
    }

    public Registration register(Class cls, int i) {
        Registration registration = this.classResolver.getRegistration(cls);
        return registration != null ? registration : register(cls, getDefaultSerializer(cls), i);
    }

    public void setDefaultSerializer(Class<? extends Serializer> cls) {
        if (cls != null) {
            this.defaultSerializer = new ReflectionSerializerFactory(cls);
            return;
        }
        throw new IllegalArgumentException("serializer cannot be null.");
    }

    public Kryo(ClassResolver classResolver, ReferenceResolver referenceResolver, StreamFactory streamFactory) {
        this.defaultSerializer = new ReflectionSerializerFactory(FieldSerializer.class);
        ArrayList<Kryo$DefaultSerializerEntry> arrayList = new ArrayList<>(33);
        this.defaultSerializers = arrayList;
        this.classLoader = getClass().getClassLoader();
        this.strategy = new Kryo$DefaultInstantiatorStrategy();
        this.maxDepth = Integer.MAX_VALUE;
        this.autoReset = true;
        this.readReferenceIds = new IntArray(0);
        this.copyReferences = true;
        this.genericsResolver = new GenericsResolver();
        this.fieldSerializerConfig = new FieldSerializerConfig();
        this.taggedFieldSerializerConfig = new TaggedFieldSerializerConfig();
        if (classResolver != null) {
            this.classResolver = classResolver;
            classResolver.setKryo(this);
            this.streamFactory = streamFactory;
            streamFactory.setKryo(this);
            this.referenceResolver = referenceResolver;
            if (referenceResolver != null) {
                referenceResolver.setKryo(this);
                this.references = true;
            }
            addDefaultSerializer(byte[].class, DefaultArraySerializers$ByteArraySerializer.class);
            addDefaultSerializer(char[].class, DefaultArraySerializers$CharArraySerializer.class);
            addDefaultSerializer(short[].class, DefaultArraySerializers$ShortArraySerializer.class);
            addDefaultSerializer(int[].class, DefaultArraySerializers$IntArraySerializer.class);
            addDefaultSerializer(long[].class, DefaultArraySerializers$LongArraySerializer.class);
            addDefaultSerializer(float[].class, DefaultArraySerializers$FloatArraySerializer.class);
            addDefaultSerializer(double[].class, DefaultArraySerializers$DoubleArraySerializer.class);
            addDefaultSerializer(boolean[].class, DefaultArraySerializers$BooleanArraySerializer.class);
            addDefaultSerializer(String[].class, DefaultArraySerializers$StringArraySerializer.class);
            addDefaultSerializer(Object[].class, DefaultArraySerializers$ObjectArraySerializer.class);
            addDefaultSerializer(KryoSerializable.class, DefaultSerializers$KryoSerializableSerializer.class);
            addDefaultSerializer(BigInteger.class, DefaultSerializers$BigIntegerSerializer.class);
            addDefaultSerializer(BigDecimal.class, DefaultSerializers$BigDecimalSerializer.class);
            addDefaultSerializer(Class.class, DefaultSerializers$ClassSerializer.class);
            addDefaultSerializer(Date.class, DefaultSerializers$DateSerializer.class);
            addDefaultSerializer(Enum.class, DefaultSerializers$EnumSerializer.class);
            addDefaultSerializer(EnumSet.class, DefaultSerializers$EnumSetSerializer.class);
            addDefaultSerializer(Currency.class, DefaultSerializers$CurrencySerializer.class);
            addDefaultSerializer(StringBuffer.class, DefaultSerializers$StringBufferSerializer.class);
            addDefaultSerializer(StringBuilder.class, DefaultSerializers$StringBuilderSerializer.class);
            addDefaultSerializer(Collections.EMPTY_LIST.getClass(), DefaultSerializers$CollectionsEmptyListSerializer.class);
            addDefaultSerializer(Collections.EMPTY_MAP.getClass(), DefaultSerializers$CollectionsEmptyMapSerializer.class);
            addDefaultSerializer(Collections.EMPTY_SET.getClass(), DefaultSerializers$CollectionsEmptySetSerializer.class);
            addDefaultSerializer(Collections.singletonList(null).getClass(), DefaultSerializers$CollectionsSingletonListSerializer.class);
            addDefaultSerializer(Collections.singletonMap(null, null).getClass(), DefaultSerializers$CollectionsSingletonMapSerializer.class);
            addDefaultSerializer(Collections.singleton(null).getClass(), DefaultSerializers$CollectionsSingletonSetSerializer.class);
            addDefaultSerializer(TreeSet.class, DefaultSerializers$TreeSetSerializer.class);
            addDefaultSerializer(Collection.class, CollectionSerializer.class);
            addDefaultSerializer(TreeMap.class, DefaultSerializers$TreeMapSerializer.class);
            addDefaultSerializer(Map.class, MapSerializer.class);
            addDefaultSerializer(TimeZone.class, DefaultSerializers$TimeZoneSerializer.class);
            addDefaultSerializer(Calendar.class, DefaultSerializers$CalendarSerializer.class);
            addDefaultSerializer(Locale.class, DefaultSerializers$LocaleSerializer.class);
            addDefaultSerializer(Charset.class, DefaultSerializers$CharsetSerializer.class);
            addDefaultSerializer(URL.class, DefaultSerializers$URLSerializer.class);
            OptionalSerializers.addDefaultSerializers(this);
            TimeSerializers.addDefaultSerializers(this);
            this.lowPriorityDefaultSerializerCount = arrayList.size();
            register(Integer.TYPE, new DefaultSerializers$IntSerializer());
            register(String.class, new DefaultSerializers$StringSerializer());
            register(Float.TYPE, new DefaultSerializers$FloatSerializer());
            register(Boolean.TYPE, new DefaultSerializers$BooleanSerializer());
            register(Byte.TYPE, new DefaultSerializers$ByteSerializer());
            register(Character.TYPE, new DefaultSerializers$CharSerializer());
            register(Short.TYPE, new DefaultSerializers$ShortSerializer());
            register(Long.TYPE, new DefaultSerializers$LongSerializer());
            register(Double.TYPE, new DefaultSerializers$DoubleSerializer());
            register(Void.TYPE, new DefaultSerializers$VoidSerializer());
            return;
        }
        throw new IllegalArgumentException("classResolver cannot be null.");
    }

    public void addDefaultSerializer(Class cls, SerializerFactory serializerFactory) {
        if (cls == null) {
            throw new IllegalArgumentException("type cannot be null.");
        }
        if (serializerFactory != null) {
            Kryo$DefaultSerializerEntry kryo$DefaultSerializerEntry = new Kryo$DefaultSerializerEntry(cls, serializerFactory);
            ArrayList<Kryo$DefaultSerializerEntry> arrayList = this.defaultSerializers;
            arrayList.add(arrayList.size() - this.lowPriorityDefaultSerializerCount, kryo$DefaultSerializerEntry);
            return;
        }
        throw new IllegalArgumentException("serializerFactory cannot be null.");
    }

    public Registration register(Class cls, Serializer serializer) {
        Registration registration = this.classResolver.getRegistration(cls);
        if (registration != null) {
            registration.setSerializer(serializer);
            return registration;
        }
        return this.classResolver.register(new Registration(cls, serializer, getNextRegistrationId()));
    }

    public Registration register(Class cls, Serializer serializer, int i) {
        if (i >= 0) {
            return register(new Registration(cls, serializer, i));
        }
        throw new IllegalArgumentException(b.d.b.a.a.q("id must be >= 0: ", i));
    }

    public void addDefaultSerializer(Class cls, Class<? extends Serializer> cls2) {
        if (cls == null) {
            throw new IllegalArgumentException("type cannot be null.");
        }
        if (cls2 != null) {
            Kryo$DefaultSerializerEntry kryo$DefaultSerializerEntry = new Kryo$DefaultSerializerEntry(cls, new ReflectionSerializerFactory(cls2));
            ArrayList<Kryo$DefaultSerializerEntry> arrayList = this.defaultSerializers;
            arrayList.add(arrayList.size() - this.lowPriorityDefaultSerializerCount, kryo$DefaultSerializerEntry);
            return;
        }
        throw new IllegalArgumentException("serializerClass cannot be null.");
    }

    public Registration register(Registration registration) {
        int id2 = registration.getId();
        if (id2 >= 0) {
            getRegistration(registration.getId());
            a$a a_a = b.e.a.a.a;
            return this.classResolver.register(registration);
        }
        throw new IllegalArgumentException(b.d.b.a.a.q("id must be > 0: ", id2));
    }

    public void writeObject(Output output, Object obj, Serializer serializer) {
        int i;
        boolean z2;
        if (output == null) {
            throw new IllegalArgumentException("output cannot be null.");
        }
        if (obj == null) {
            throw new IllegalArgumentException("object cannot be null.");
        }
        if (serializer != null) {
            beginObject();
            try {
                if (this.references && writeReferenceOrNull(output, obj, false)) {
                    serializer.setGenerics(this, null);
                    if (i == 0) {
                        if (z2) {
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                } else {
                    a$a a_a = b.e.a.a.a;
                    serializer.write(this, output, obj);
                    if (i == 0) {
                        if (z2) {
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                }
            } finally {
                i = this.depth - 1;
                this.depth = i;
                if (i == 0 && this.autoReset) {
                    reset();
                }
            }
        }
        throw new IllegalArgumentException("serializer cannot be null.");
    }

    public <T> T copy(T t, Serializer serializer) {
        T t2;
        if (t == null) {
            return null;
        }
        if (this.copyShallow) {
            return t;
        }
        this.copyDepth++;
        try {
            if (this.originalToCopy == null) {
                this.originalToCopy = new IdentityMap();
            }
            T t3 = (T) this.originalToCopy.get(t);
            if (t3 != null) {
                return t3;
            }
            if (this.copyReferences) {
                this.needsCopyReference = t;
            }
            if (t instanceof KryoCopyable) {
                t2 = (T) ((KryoCopyable) t).copy(this);
            } else {
                t2 = (T) serializer.copy(this, t);
            }
            if (this.needsCopyReference != null) {
                reference(t2);
            }
            a$a a_a = b.e.a.a.a;
            return t2;
        } finally {
            int i = this.copyDepth - 1;
            this.copyDepth = i;
            if (i == 0) {
                reset();
            }
        }
    }

    public <T> T readObject(Input input, Class<T> cls, Serializer serializer) {
        T t;
        if (input == null) {
            throw new IllegalArgumentException("input cannot be null.");
        }
        if (cls == null) {
            throw new IllegalArgumentException("type cannot be null.");
        }
        if (serializer != null) {
            beginObject();
            try {
                if (this.references) {
                    int referenceOrNull = readReferenceOrNull(input, cls, false);
                    if (referenceOrNull == -1) {
                        return (T) this.readObject;
                    }
                    t = (T) serializer.read(this, input, cls);
                    if (referenceOrNull == this.readReferenceIds.size) {
                        reference(t);
                    }
                } else {
                    t = (T) serializer.read(this, input, cls);
                }
                a$a a_a = b.e.a.a.a;
                return t;
            } finally {
                int i = this.depth - 1;
                this.depth = i;
                if (i == 0 && this.autoReset) {
                    reset();
                }
            }
        }
        throw new IllegalArgumentException("serializer cannot be null.");
    }

    public void writeObjectOrNull(Output output, Object obj, Serializer serializer) {
        int i;
        boolean z2;
        if (output == null) {
            throw new IllegalArgumentException("output cannot be null.");
        }
        if (serializer != null) {
            beginObject();
            try {
                if (this.references) {
                    if (writeReferenceOrNull(output, obj, true)) {
                        serializer.setGenerics(this, null);
                        if (i == 0) {
                            if (z2) {
                                return;
                            } else {
                                return;
                            }
                        }
                        return;
                    }
                } else if (!serializer.getAcceptsNull()) {
                    if (obj == null) {
                        a$a a_a = b.e.a.a.a;
                        output.writeByte((byte) 0);
                        if (i == 0) {
                            if (z2) {
                                return;
                            } else {
                                return;
                            }
                        }
                        return;
                    }
                    output.writeByte((byte) 1);
                }
                a$a a_a2 = b.e.a.a.a;
                serializer.write(this, output, obj);
                if (i == 0) {
                    if (z2) {
                        return;
                    } else {
                        return;
                    }
                }
                return;
            } finally {
                i = this.depth - 1;
                this.depth = i;
                if (i == 0 && this.autoReset) {
                    reset();
                }
            }
        }
        throw new IllegalArgumentException("serializer cannot be null.");
    }

    public <T> T copyShallow(T t, Serializer serializer) {
        T t2;
        if (t == null) {
            return null;
        }
        this.copyDepth++;
        this.copyShallow = true;
        try {
            if (this.originalToCopy == null) {
                this.originalToCopy = new IdentityMap();
            }
            T t3 = (T) this.originalToCopy.get(t);
            if (t3 != null) {
                return t3;
            }
            if (this.copyReferences) {
                this.needsCopyReference = t;
            }
            if (t instanceof KryoCopyable) {
                t2 = (T) ((KryoCopyable) t).copy(this);
            } else {
                t2 = (T) serializer.copy(this, t);
            }
            if (this.needsCopyReference != null) {
                reference(t2);
            }
            a$a a_a = b.e.a.a.a;
            return t2;
        } finally {
            this.copyShallow = false;
            int i = this.copyDepth - 1;
            this.copyDepth = i;
            if (i == 0) {
                reset();
            }
        }
    }

    public Registration getRegistration(int i) {
        return this.classResolver.getRegistration(i);
    }

    public <T> T readObjectOrNull(Input input, Class<T> cls, Serializer serializer) {
        T t;
        if (input == null) {
            throw new IllegalArgumentException("input cannot be null.");
        }
        if (cls == null) {
            throw new IllegalArgumentException("type cannot be null.");
        }
        if (serializer != null) {
            beginObject();
            try {
                if (this.references) {
                    int referenceOrNull = readReferenceOrNull(input, cls, true);
                    if (referenceOrNull == -1) {
                        return (T) this.readObject;
                    }
                    t = (T) serializer.read(this, input, cls);
                    if (referenceOrNull == this.readReferenceIds.size) {
                        reference(t);
                    }
                } else {
                    if (!serializer.getAcceptsNull() && input.readByte() == 0) {
                        a$a a_a = b.e.a.a.a;
                        return null;
                    }
                    t = (T) serializer.read(this, input, cls);
                }
                a$a a_a2 = b.e.a.a.a;
                return t;
            } finally {
                int i = this.depth - 1;
                this.depth = i;
                if (i == 0 && this.autoReset) {
                    reset();
                }
            }
        }
        throw new IllegalArgumentException("serializer cannot be null.");
    }
}
