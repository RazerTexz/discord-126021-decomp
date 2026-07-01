package b.g.a.c.g0.u;

import b.c.a.a0.AnimatableValueParser;
import b.g.a.a.JsonFormat;
import b.g.a.a.ObjectIdGenerator;
import b.g.a.a.ObjectIdGenerators3;
import b.g.a.b.JsonGenerator;
import b.g.a.b.JsonToken2;
import b.g.a.b.SerializableString;
import b.g.a.b.s.WritableTypeId;
import b.g.a.c.AnnotationIntrospector;
import b.g.a.c.BeanProperty;
import b.g.a.c.JavaType;
import b.g.a.c.JsonSerializer;
import b.g.a.c.PropertyName;
import b.g.a.c.SerializationConfig;
import b.g.a.c.SerializerProvider;
import b.g.a.c.c0.Annotated;
import b.g.a.c.c0.AnnotatedMember;
import b.g.a.c.c0.ObjectIdInfo;
import b.g.a.c.e0.TypeSerializer;
import b.g.a.c.g0.AnyGetterWriter;
import b.g.a.c.g0.BeanPropertyWriter;
import b.g.a.c.g0.BeanSerializerBuilder;
import b.g.a.c.g0.ContainerSerializer;
import b.g.a.c.g0.ContextualSerializer;
import b.g.a.c.g0.ResolvableSerializer;
import b.g.a.c.g0.t.MapEntrySerializer;
import b.g.a.c.g0.t.ObjectIdWriter;
import b.g.a.c.g0.t.PropertyBasedObjectIdGenerator;
import b.g.a.c.g0.t.WritableObjectId;
import b.g.a.c.i0.ClassUtil;
import b.g.a.c.i0.Converter;
import b.g.a.c.i0.EnumValues;
import b.g.a.c.i0.NameTransformer4;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: renamed from: b.g.a.c.g0.u.d, reason: use source file name */
/* JADX INFO: compiled from: BeanSerializerBase.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class BeanSerializerBase extends StdSerializer<Object> implements ContextualSerializer, ResolvableSerializer {
    public static final BeanPropertyWriter[] k;
    public final AnyGetterWriter _anyGetterWriter;
    public final JavaType _beanType;
    public final BeanPropertyWriter[] _filteredProps;
    public final ObjectIdWriter _objectIdWriter;
    public final Object _propertyFilterId;
    public final BeanPropertyWriter[] _props;
    public final JsonFormat.c _serializationShape;
    public final AnnotatedMember _typeId;

    static {
        new PropertyName("#object-ref");
        k = new BeanPropertyWriter[0];
    }

    public BeanSerializerBase(JavaType javaType, BeanSerializerBuilder beanSerializerBuilder, BeanPropertyWriter[] beanPropertyWriterArr, BeanPropertyWriter[] beanPropertyWriterArr2) {
        super(javaType);
        this._beanType = javaType;
        this._props = beanPropertyWriterArr;
        this._filteredProps = beanPropertyWriterArr2;
        if (beanSerializerBuilder == null) {
            this._typeId = null;
            this._anyGetterWriter = null;
            this._propertyFilterId = null;
            this._objectIdWriter = null;
            this._serializationShape = null;
            return;
        }
        this._typeId = beanSerializerBuilder.h;
        this._anyGetterWriter = beanSerializerBuilder.f;
        this._propertyFilterId = beanSerializerBuilder.g;
        this._objectIdWriter = beanSerializerBuilder.i;
        this._serializationShape = beanSerializerBuilder.f701b.a(null).e();
    }

    public static final BeanPropertyWriter[] t(BeanPropertyWriter[] beanPropertyWriterArr, NameTransformer4 nameTransformer4) {
        if (beanPropertyWriterArr == null || beanPropertyWriterArr.length == 0 || nameTransformer4 == null || nameTransformer4 == NameTransformer4.j) {
            return beanPropertyWriterArr;
        }
        int length = beanPropertyWriterArr.length;
        BeanPropertyWriter[] beanPropertyWriterArr2 = new BeanPropertyWriter[length];
        for (int i = 0; i < length; i++) {
            BeanPropertyWriter beanPropertyWriter = beanPropertyWriterArr[i];
            if (beanPropertyWriter != null) {
                beanPropertyWriterArr2[i] = beanPropertyWriter.g(nameTransformer4);
            }
        }
        return beanPropertyWriterArr2;
    }

    /* JADX WARN: Code duplicated, block: B:73:0x0171  */
    @Override // b.g.a.c.g0.ContextualSerializer
    public JsonSerializer<?> a(SerializerProvider serializerProvider, BeanProperty beanProperty) throws JsonMappingException {
        JsonFormat.c cVarE;
        Object objG;
        Set<String> set;
        Set<String> setD;
        int i;
        BeanSerializerBase beanSerializerBaseW;
        Object obj;
        ObjectIdInfo objectIdInfoS;
        AnnotationIntrospector annotationIntrospectorV = serializerProvider.v();
        BeanPropertyWriter[] beanPropertyWriterArr = null;
        AnnotatedMember member = (beanProperty == null || annotationIntrospectorV == null) ? null : beanProperty.getMember();
        SerializationConfig serializationConfig = serializerProvider._config;
        JsonFormat.d dVarL = l(serializerProvider, beanProperty, this._handledType);
        char c = 0;
        if (dVarL == null || !dVarL.i()) {
            cVarE = null;
        } else {
            cVarE = dVarL.e();
            if (cVarE != JsonFormat.c.ANY && cVarE != this._serializationShape) {
                if (this._beanType.w()) {
                    int iOrdinal = cVarE.ordinal();
                    if (iOrdinal == 5 || iOrdinal == 7 || iOrdinal == 8) {
                        serializationConfig.n(this._beanType);
                        Class<?> cls = this._beanType._class;
                        return serializerProvider.y(new EnumSerializer2(EnumValues.a(serializerProvider._config, cls), EnumSerializer2.p(cls, dVarL, true, null)), beanProperty);
                    }
                } else if (cVarE == JsonFormat.c.NATURAL && ((!this._beanType.z() || !Map.class.isAssignableFrom(this._handledType)) && Map.Entry.class.isAssignableFrom(this._handledType))) {
                    JavaType javaTypeI = this._beanType.i(Map.Entry.class);
                    return serializerProvider.y(new MapEntrySerializer(this._beanType, javaTypeI.h(0), javaTypeI.h(1), false, null, beanProperty), beanProperty);
                }
            }
        }
        ObjectIdWriter objectIdWriterA = this._objectIdWriter;
        if (member != null) {
            setD = annotationIntrospectorV.x(serializationConfig, member).d();
            set = annotationIntrospectorV.A(serializationConfig, member)._included;
            ObjectIdInfo objectIdInfoR = annotationIntrospectorV.r(member);
            if (objectIdInfoR != null) {
                ObjectIdInfo objectIdInfoS2 = annotationIntrospectorV.s(member, objectIdInfoR);
                Class<? extends ObjectIdGenerator<?>> cls2 = objectIdInfoS2.c;
                JavaType javaType = serializerProvider.d().i(serializerProvider.b(cls2), ObjectIdGenerator.class)[0];
                if (cls2 == ObjectIdGenerators3.class) {
                    String str = objectIdInfoS2.f681b._simpleName;
                    int length = this._props.length;
                    i = 0;
                    while (true) {
                        if (i == length) {
                            JavaType javaType2 = this._beanType;
                            Object[] objArr = new Object[2];
                            objArr[c] = ClassUtil.u(this._handledType);
                            objArr[1] = str == null ? "[null]" : ClassUtil.c(str);
                            serializerProvider.f(javaType2, String.format("Invalid Object Id definition for %s: cannot find property with name %s", objArr));
                            throw null;
                        }
                        BeanPropertyWriter beanPropertyWriter = this._props[i];
                        if (str.equals(beanPropertyWriter._name._value)) {
                            objectIdWriterA = ObjectIdWriter.a(beanPropertyWriter._declaredType, null, new PropertyBasedObjectIdGenerator(objectIdInfoS2, beanPropertyWriter), objectIdInfoS2.f);
                            break;
                        }
                        i++;
                        c = 0;
                    }
                } else {
                    objectIdWriterA = ObjectIdWriter.a(javaType, objectIdInfoS2.f681b, serializerProvider.e(member, objectIdInfoS2), objectIdInfoS2.f);
                }
                objG = annotationIntrospectorV.g(member);
                if (objG != null || ((obj = this._propertyFilterId) != null && objG.equals(obj))) {
                    objG = null;
                }
            } else if (objectIdWriterA != null && (objectIdInfoS = annotationIntrospectorV.s(member, null)) != null) {
                objectIdWriterA = this._objectIdWriter;
                boolean z2 = objectIdInfoS.f;
                if (z2 != objectIdWriterA.e) {
                    objectIdWriterA = new ObjectIdWriter(objectIdWriterA.a, objectIdWriterA.f704b, objectIdWriterA.c, objectIdWriterA.d, z2);
                }
            }
            i = 0;
            objG = annotationIntrospectorV.g(member);
            if (objG != null) {
                objG = null;
            } else {
                objG = null;
            }
        } else {
            objG = null;
            set = null;
            setD = null;
            i = 0;
        }
        if (i > 0) {
            BeanPropertyWriter[] beanPropertyWriterArr2 = this._props;
            BeanPropertyWriter[] beanPropertyWriterArr3 = (BeanPropertyWriter[]) Arrays.copyOf(beanPropertyWriterArr2, beanPropertyWriterArr2.length);
            BeanPropertyWriter beanPropertyWriter2 = beanPropertyWriterArr3[i];
            System.arraycopy(beanPropertyWriterArr3, 0, beanPropertyWriterArr3, 1, i);
            beanPropertyWriterArr3[0] = beanPropertyWriter2;
            BeanPropertyWriter[] beanPropertyWriterArr4 = this._filteredProps;
            if (beanPropertyWriterArr4 != null) {
                beanPropertyWriterArr = (BeanPropertyWriter[]) Arrays.copyOf(beanPropertyWriterArr4, beanPropertyWriterArr4.length);
                BeanPropertyWriter beanPropertyWriter3 = beanPropertyWriterArr[i];
                System.arraycopy(beanPropertyWriterArr, 0, beanPropertyWriterArr, 1, i);
                beanPropertyWriterArr[0] = beanPropertyWriter3;
            }
            beanSerializerBaseW = y(beanPropertyWriterArr3, beanPropertyWriterArr);
        } else {
            beanSerializerBaseW = this;
        }
        if (objectIdWriterA != null) {
            ObjectIdWriter objectIdWriter = new ObjectIdWriter(objectIdWriterA.a, objectIdWriterA.f704b, objectIdWriterA.c, serializerProvider.t(objectIdWriterA.a, beanProperty), objectIdWriterA.e);
            if (objectIdWriter != this._objectIdWriter) {
                beanSerializerBaseW = beanSerializerBaseW.x(objectIdWriter);
            }
        }
        if ((setD != null && !setD.isEmpty()) || set != null) {
            beanSerializerBaseW = beanSerializerBaseW.v(setD, set);
        }
        if (objG != null) {
            beanSerializerBaseW = beanSerializerBaseW.w(objG);
        }
        if (cVarE == null) {
            cVarE = this._serializationShape;
        }
        return cVarE == JsonFormat.c.ARRAY ? beanSerializerBaseW.s() : beanSerializerBaseW;
    }

    /* JADX WARN: Code duplicated, block: B:60:0x00b6  */
    @Override // b.g.a.c.g0.ResolvableSerializer
    public void b(SerializerProvider serializerProvider) throws JsonMappingException {
        BeanPropertyWriter beanPropertyWriter;
        TypeSerializer typeSerializer;
        Annotated annotated;
        Object objH;
        JsonSerializer<Object> jsonSerializer;
        BeanPropertyWriter beanPropertyWriter2;
        BeanPropertyWriter[] beanPropertyWriterArr = this._filteredProps;
        int length = beanPropertyWriterArr == null ? 0 : beanPropertyWriterArr.length;
        int length2 = this._props.length;
        for (int i = 0; i < length2; i++) {
            BeanPropertyWriter beanPropertyWriter3 = this._props[i];
            if (!beanPropertyWriter3._suppressNulls) {
                if (!(beanPropertyWriter3._nullSerializer != null) && (jsonSerializer = serializerProvider._nullValueSerializer) != null) {
                    beanPropertyWriter3.e(jsonSerializer);
                    if (i < length && (beanPropertyWriter2 = this._filteredProps[i]) != null) {
                        beanPropertyWriter2.e(jsonSerializer);
                    }
                }
            }
            if (!(beanPropertyWriter3._serializer != null)) {
                AnnotationIntrospector annotationIntrospectorV = serializerProvider.v();
                JsonSerializer<Object> jsonSerializerT = null;
                if (annotationIntrospectorV != null && (annotated = beanPropertyWriter3._member) != null && (objH = annotationIntrospectorV.H(annotated)) != null) {
                    Converter<Object, Object> converterC = serializerProvider.c(beanPropertyWriter3._member, objH);
                    JavaType javaTypeA = converterC.a(serializerProvider.d());
                    jsonSerializerT = new StdDelegatingSerializer(converterC, javaTypeA, javaTypeA.y() ? null : serializerProvider.t(javaTypeA, beanPropertyWriter3));
                }
                if (jsonSerializerT == null) {
                    JavaType javaType = beanPropertyWriter3._cfgSerializationType;
                    if (javaType == null) {
                        javaType = beanPropertyWriter3._declaredType;
                        if (!javaType.x()) {
                            if (javaType.v() || javaType.g() > 0) {
                                beanPropertyWriter3._nonTrivialBaseType = javaType;
                            }
                        }
                    }
                    jsonSerializerT = serializerProvider.t(javaType, beanPropertyWriter3);
                    if (javaType.v() && (typeSerializer = (TypeSerializer) javaType.k()._typeHandler) != null && (jsonSerializerT instanceof ContainerSerializer)) {
                        ContainerSerializer containerSerializer = (ContainerSerializer) jsonSerializerT;
                        Objects.requireNonNull(containerSerializer);
                        jsonSerializerT = containerSerializer.p(typeSerializer);
                    }
                    if (i < length) {
                        beanPropertyWriter3.f(jsonSerializerT);
                    } else {
                        beanPropertyWriter3.f(jsonSerializerT);
                    }
                } else if (i < length || (beanPropertyWriter = this._filteredProps[i]) == null) {
                    beanPropertyWriter3.f(jsonSerializerT);
                } else {
                    beanPropertyWriter.f(jsonSerializerT);
                }
            }
        }
        AnyGetterWriter anyGetterWriter = this._anyGetterWriter;
        if (anyGetterWriter != null) {
            JsonSerializer<?> jsonSerializer2 = anyGetterWriter.c;
            if (jsonSerializer2 instanceof ContextualSerializer) {
                JsonSerializer<?> jsonSerializerY = serializerProvider.y(jsonSerializer2, anyGetterWriter.a);
                anyGetterWriter.c = jsonSerializerY;
                if (jsonSerializerY instanceof MapSerializer2) {
                    anyGetterWriter.d = (MapSerializer2) jsonSerializerY;
                }
            }
        }
    }

    @Override // b.g.a.c.JsonSerializer
    public void g(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException {
        if (this._objectIdWriter != null) {
            jsonGenerator.e(obj);
            p(obj, jsonGenerator, serializerProvider, typeSerializer);
            return;
        }
        jsonGenerator.e(obj);
        WritableTypeId writableTypeIdR = r(typeSerializer, obj, JsonToken2.START_OBJECT);
        typeSerializer.e(jsonGenerator, writableTypeIdR);
        Object obj2 = this._propertyFilterId;
        if (obj2 == null) {
            u(obj, jsonGenerator, serializerProvider);
            typeSerializer.f(jsonGenerator, writableTypeIdR);
        } else {
            if (this._filteredProps != null) {
                Class<?> cls = serializerProvider._serializationView;
            }
            m(serializerProvider, obj2, obj);
            throw null;
        }
    }

    @Override // b.g.a.c.JsonSerializer
    public boolean i() {
        return this._objectIdWriter != null;
    }

    public final void p(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException {
        ObjectIdWriter objectIdWriter = this._objectIdWriter;
        WritableObjectId writableObjectIdP = serializerProvider.p(obj, objectIdWriter.c);
        if (writableObjectIdP.a(jsonGenerator, serializerProvider, objectIdWriter)) {
            return;
        }
        if (writableObjectIdP.f713b == null) {
            writableObjectIdP.f713b = writableObjectIdP.a.c(obj);
        }
        Object obj2 = writableObjectIdP.f713b;
        if (objectIdWriter.e) {
            objectIdWriter.d.f(obj2, jsonGenerator, serializerProvider);
            return;
        }
        ObjectIdWriter objectIdWriter2 = this._objectIdWriter;
        WritableTypeId writableTypeIdR = r(typeSerializer, obj, JsonToken2.START_OBJECT);
        typeSerializer.e(jsonGenerator, writableTypeIdR);
        writableObjectIdP.c = true;
        Objects.requireNonNull(jsonGenerator);
        SerializableString serializableString = objectIdWriter2.f704b;
        if (serializableString != null) {
            jsonGenerator.x(serializableString);
            objectIdWriter2.d.f(writableObjectIdP.f713b, jsonGenerator, serializerProvider);
        }
        Object obj3 = this._propertyFilterId;
        if (obj3 != null) {
            m(serializerProvider, obj3, obj);
            throw null;
        }
        u(obj, jsonGenerator, serializerProvider);
        typeSerializer.f(jsonGenerator, writableTypeIdR);
    }

    public final void q(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, boolean z2) throws IOException {
        ObjectIdWriter objectIdWriter = this._objectIdWriter;
        WritableObjectId writableObjectIdP = serializerProvider.p(obj, objectIdWriter.c);
        if (writableObjectIdP.a(jsonGenerator, serializerProvider, objectIdWriter)) {
            return;
        }
        if (writableObjectIdP.f713b == null) {
            writableObjectIdP.f713b = writableObjectIdP.a.c(obj);
        }
        Object obj2 = writableObjectIdP.f713b;
        if (objectIdWriter.e) {
            objectIdWriter.d.f(obj2, jsonGenerator, serializerProvider);
            return;
        }
        if (z2) {
            jsonGenerator.d0(obj);
        }
        writableObjectIdP.c = true;
        SerializableString serializableString = objectIdWriter.f704b;
        if (serializableString != null) {
            jsonGenerator.x(serializableString);
            objectIdWriter.d.f(writableObjectIdP.f713b, jsonGenerator, serializerProvider);
        }
        Object obj3 = this._propertyFilterId;
        if (obj3 != null) {
            m(serializerProvider, obj3, obj);
            throw null;
        }
        u(obj, jsonGenerator, serializerProvider);
        if (z2) {
            jsonGenerator.u();
        }
    }

    public final WritableTypeId r(TypeSerializer typeSerializer, Object obj, JsonToken2 jsonToken2) {
        AnnotatedMember annotatedMember = this._typeId;
        if (annotatedMember == null) {
            return typeSerializer.d(obj, jsonToken2);
        }
        Object objJ = annotatedMember.j(obj);
        if (objJ == null) {
            objJ = "";
        }
        WritableTypeId writableTypeIdD = typeSerializer.d(obj, jsonToken2);
        writableTypeIdD.c = objJ;
        return writableTypeIdD;
    }

    public abstract BeanSerializerBase s();

    public void u(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        BeanPropertyWriter[] beanPropertyWriterArr = this._filteredProps;
        if (beanPropertyWriterArr == null || serializerProvider._serializationView == null) {
            beanPropertyWriterArr = this._props;
        }
        int i = 0;
        try {
            int length = beanPropertyWriterArr.length;
            while (i < length) {
                BeanPropertyWriter beanPropertyWriter = beanPropertyWriterArr[i];
                if (beanPropertyWriter != null) {
                    beanPropertyWriter.i(obj, jsonGenerator, serializerProvider);
                }
                i++;
            }
            AnyGetterWriter anyGetterWriter = this._anyGetterWriter;
            if (anyGetterWriter != null) {
                anyGetterWriter.a(obj, jsonGenerator, serializerProvider);
            }
        } catch (Exception e) {
            o(serializerProvider, e, obj, i != beanPropertyWriterArr.length ? beanPropertyWriterArr[i]._name._value : "[anySetter]");
            throw null;
        } catch (StackOverflowError e2) {
            JsonMappingException jsonMappingException = new JsonMappingException(jsonGenerator, "Infinite recursion (StackOverflowError)", e2);
            jsonMappingException.e(new JsonMappingException.a(obj, i != beanPropertyWriterArr.length ? beanPropertyWriterArr[i]._name._value : "[anySetter]"));
            throw jsonMappingException;
        }
    }

    public abstract BeanSerializerBase v(Set<String> set, Set<String> set2);

    public abstract BeanSerializerBase w(Object obj);

    public abstract BeanSerializerBase x(ObjectIdWriter objectIdWriter);

    public abstract BeanSerializerBase y(BeanPropertyWriter[] beanPropertyWriterArr, BeanPropertyWriter[] beanPropertyWriterArr2);

    public BeanSerializerBase(BeanSerializerBase beanSerializerBase, BeanPropertyWriter[] beanPropertyWriterArr, BeanPropertyWriter[] beanPropertyWriterArr2) {
        super(beanSerializerBase._handledType);
        this._beanType = beanSerializerBase._beanType;
        this._props = beanPropertyWriterArr;
        this._filteredProps = beanPropertyWriterArr2;
        this._typeId = beanSerializerBase._typeId;
        this._anyGetterWriter = beanSerializerBase._anyGetterWriter;
        this._objectIdWriter = beanSerializerBase._objectIdWriter;
        this._propertyFilterId = beanSerializerBase._propertyFilterId;
        this._serializationShape = beanSerializerBase._serializationShape;
    }

    public BeanSerializerBase(BeanSerializerBase beanSerializerBase, ObjectIdWriter objectIdWriter, Object obj) {
        super(beanSerializerBase._handledType);
        this._beanType = beanSerializerBase._beanType;
        this._props = beanSerializerBase._props;
        this._filteredProps = beanSerializerBase._filteredProps;
        this._typeId = beanSerializerBase._typeId;
        this._anyGetterWriter = beanSerializerBase._anyGetterWriter;
        this._objectIdWriter = objectIdWriter;
        this._propertyFilterId = obj;
        this._serializationShape = beanSerializerBase._serializationShape;
    }

    public BeanSerializerBase(BeanSerializerBase beanSerializerBase, Set<String> set, Set<String> set2) {
        super(beanSerializerBase._handledType);
        this._beanType = beanSerializerBase._beanType;
        BeanPropertyWriter[] beanPropertyWriterArr = beanSerializerBase._props;
        BeanPropertyWriter[] beanPropertyWriterArr2 = beanSerializerBase._filteredProps;
        int length = beanPropertyWriterArr.length;
        ArrayList arrayList = new ArrayList(length);
        ArrayList arrayList2 = beanPropertyWriterArr2 == null ? null : new ArrayList(length);
        for (int i = 0; i < length; i++) {
            BeanPropertyWriter beanPropertyWriter = beanPropertyWriterArr[i];
            if (!AnimatableValueParser.b2(beanPropertyWriter._name._value, set, set2)) {
                arrayList.add(beanPropertyWriter);
                if (beanPropertyWriterArr2 != null) {
                    arrayList2.add(beanPropertyWriterArr2[i]);
                }
            }
        }
        this._props = (BeanPropertyWriter[]) arrayList.toArray(new BeanPropertyWriter[arrayList.size()]);
        this._filteredProps = arrayList2 != null ? (BeanPropertyWriter[]) arrayList2.toArray(new BeanPropertyWriter[arrayList2.size()]) : null;
        this._typeId = beanSerializerBase._typeId;
        this._anyGetterWriter = beanSerializerBase._anyGetterWriter;
        this._objectIdWriter = beanSerializerBase._objectIdWriter;
        this._propertyFilterId = beanSerializerBase._propertyFilterId;
        this._serializationShape = beanSerializerBase._serializationShape;
    }
}
